package com.keep.me.tools;

import com.alibaba.fastjson.JSONObject;
import com.keep.me.ActionEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hello {

    private int num = 0;
    private static int num1 = 0;

    public Hello() {
        this.num ++;
    }

    static {
        num1 ++;
        System.out.println("静态代码块执行，num1 = " + num1);
        System.out.println("类加载的时候执行，只执行一次");
    }

    // 静态方法不能使用类实例访问，直接访问类所属的静态方法即可
    public static String hh() {
        System.out.println("hello");
        return null;
    }

    public String h1() {
        System.out.println("h1");
        return null;
    }

    // 可变参数
    public String print1(String...names) {
        System.out.println("names个数" + names.length);
        for (String name: names) {
            System.out.println("name: " + name);
        }
        return null;
    }

    // 泛型实现不同类型可变参数
    public <T> String print2(T...names) {
        System.out.println("泛型names个数" + names.length);
        for (T name: names) {
            System.out.println("泛型name: " + name);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, String> map2 = new HashMap<>();
        map2.put("h", "x");
        System.out.println(map2.get("h") + " " + map2.get("x"));

        Hello.hh();

        Hello hello = new Hello();
        hello.h1();
        System.out.println("hello: " + hello.num);

        Hello hello1 = new Hello();
        System.out.println("hello1: " + hello1.num);

        Hello hello2 = new Hello();
        System.out.println("hello2: " + hello2.num);

        hello2.print1("huang", "xuan", "feng", "li");
        hello2.print2("huang", 89, 3.1231);

        Def def = new Def("huang");
        System.out.println(def);
        System.out.println(def.toString());
        System.out.println(def.getUser());
        System.out.println(def.getName());

        System.out.println("------ 分割线 ------");
        KeepUser2 keepUser = new KeepUser2();
        keepUser.setName("huang xuanfeng");
        keepUser.setAge(27);
        System.out.println(keepUser.toString());

        List<String> nameList = new ArrayList<>();

        String str = "[{\"actionId\":131,\"description\":\"this is test\",\"eventName\":\"training_join\",\"moduleName\":\"SU\",\"propertyId\":\"0003,0004\",\"task\":\"T22000\",\"valid\":true},{\"actionId\":132,\"description\":\"this is test\",\"eventName\":\"training_join\",\"moduleName\":\"SU\",\"propertyId\":\"0003,0004\",\"task\":\"T22000\",\"valid\":true},{\"actionId\":133,\"description\":\"this is test\",\"eventName\":\"training_join\",\"moduleName\":\"SU\",\"propertyId\":\"0003,0004\",\"task\":\"T22000\",\"valid\":true},{\"actionId\":135,\"description\":\"this is test\",\"eventName\":\"training_join\",\"moduleName\":\"SU\",\"propertyId\":\"0003,0004\",\"task\":\"T22000\",\"valid\":true},{\"actionId\":137,\"description\":\"this is test\",\"eventName\":\"training_join\",\"moduleName\":\"SU\",\"propertyId\":\"0003,0004\",\"task\":\"T22000\",\"valid\":true},{\"actionId\":140,\"description\":\"app唤醒\",\"eventName\":\"app_awake\",\"propertyId\":\"35,61,57\",\"propertyMessage\":\"[{\\\"isRequired\\\":\\\"必须\\\",\\\"propertyName\\\":\\\"state_value\\\",\\\"type\\\":\\\"number\\\",\\\"value\\\":\\\"test1,test2,test3\\\"},{\\\"isRequired\\\":\\\"必须\\\",\\\"propertyName\\\":\\\"state_value\\\",\\\"type\\\":\\\"number\\\",\\\"value\\\":\\\"test1,test2,test3\\\"},{\\\"isRequired\\\":\\\"必须\\\",\\\"propertyName\\\":\\\"interactive\\\",\\\"type\\\":\\\"string\\\",\\\"value\\\":\\\"test1,test2\\\"},{\\\"isRequired\\\":\\\"必须\\\",\\\"propertyName\\\":\\\"log_server_time\\\",\\\"type\\\":\\\"number\\\",\\\"value\\\":\\\"test1\\\"},{\\\"isRequired\\\":\\\"必须\\\",\\\"propertyName\\\":\\\"log_server_time\\\",\\\"type\\\":\\\"number\\\",\\\"value\\\":\\\"test1\\\"}]\",\"task\":\"T30000\",\"valid\":true}]";
        List<ActionEvent> result = JSONObject.parseArray(str, ActionEvent.class);
        for (ActionEvent ae: result) {
            System.out.println(ae);
            System.out.println(ae.getActionId());
        }

        List<Integer> list = new ArrayList<>();
        list.add(10); list.add(20);
        System.out.println(list);
        say(list);
        System.out.println(list);
    }

    public static void say(List<Integer> list) {
        list.add(900);
    }

}
