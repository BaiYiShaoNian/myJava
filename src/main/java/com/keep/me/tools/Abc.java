package com.keep.me.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.Naming;

@Data
public class Abc {
    private String name;

    public Abc(String name) {
        this.name = name;
    }

    public Abc() {

    }
}
