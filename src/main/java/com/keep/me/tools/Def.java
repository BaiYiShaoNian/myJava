package com.keep.me.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Def extends Abc {
    private String user;

    public Def(String user) {
        super("xuan");
        this.user = user;
    }

    public String toString() {
        return "结果：" + this.user + " , " + super.getName();
    }

}
