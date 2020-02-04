package com.keep.me.tools;

import lombok.Data;
import org.apache.hadoop.hive.ql.lib.*;
import org.apache.hadoop.hive.ql.parse.*;

import java.util.*;

/**
 * Create by huangxuanfeng on 2019/12/13 上午10:24
 */
@Data
public class HiveLineageInfo implements NodeProcessor {
    /**
     * Stores input tables in sql.
     */
    private TreeSet inputTableList = new TreeSet();
    /**
     * Stores output tables in sql.
     */
    private TreeSet OutputTableList = new TreeSet();

    /**
     * Implements the process method for the NodeProcessor interface.
     */
    public Object process(Node nd, Stack stack, NodeProcessorCtx procCtx,
                          Object... nodeOutputs) throws SemanticException {
        ASTNode pt = (ASTNode) nd;

        switch (pt.getToken().getType()) {

            case HiveParser.TOK_CREATETABLE:  // create类型 outputtable
                OutputTableList.add(BaseSemanticAnalyzer.getUnescapedName((ASTNode)pt.getChild(0)));
                break;
            case HiveParser.TOK_TAB:  // insert类型 outputTable
                OutputTableList.add(BaseSemanticAnalyzer.getUnescapedName((ASTNode)pt.getChild(0)));
                break;

            case HiveParser.TOK_TABREF:  // inputTable
                ASTNode tabTree = (ASTNode) pt.getChild(0);
                String table_name = (tabTree.getChildCount() == 1) ?
                        BaseSemanticAnalyzer.getUnescapedName((ASTNode)tabTree.getChild(0)) :
                        BaseSemanticAnalyzer.getUnescapedName((ASTNode)tabTree.getChild(0)) + "." + tabTree.getChild(1);
                inputTableList.add(table_name);
                break;
        }
        return null;
    }

    /**
     * parses given query and gets the lineage info.
     *
     * @param query
     */
    public void getLineageInfo(String query) {

        /*
         * initialize Event Processor and dispatcher.
         */
        //inputTableList.clear();
        //OutputTableList.clear();

        /*
         * Get the AST tree
         */
        ParseDriver pd = new ParseDriver();
        ASTNode tree = new ASTNode();
        try {
            try {
                tree = pd.parse(query);
            } catch (Exception e) {
                return;
            }


            while ((tree.getToken() == null) && (tree.getChildCount() > 0)) {
                tree = (ASTNode)tree.getChild(0);
            }

            // create a walker which walks the tree in a DFS manner while maintaining
            // the operator stack. The dispatcher
            // generates the plan from the operator tree
            Map<Rule, NodeProcessor> rules = new LinkedHashMap<Rule, NodeProcessor>();

            // The dispatcher fires the processor corresponding to the closest matching
            // rule and passes the context along
            Dispatcher disp = new DefaultRuleDispatcher(this, rules, null);
            GraphWalker ogw = new DefaultGraphWalker(disp);

            // Create a list of topop nodes
            ArrayList topNodes = new ArrayList();
            topNodes.add(tree);
            ogw.startWalking(topNodes, null);

        } catch (Exception e) {
            return;
        }
    }

//    public static void main(String[] args) throws IOException, ParseException,
//            SemanticException {
//        String query = args[0];
//        HiveLineageInfo lep = new HiveLineageInfo();
//        lep.getLineageInfo(query);
//        System.out.println("Input tables = " + lep.getInputTableList());
//        System.out.println("Output tables = " + lep.getOutputTableList());
//    }
}