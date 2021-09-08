package com.keep.me.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class KeepUser2 extends User2 {
    private int age;

    //@Override
    //public String toString() {
    //    return "KeepUser2(name=" + this.getName() + ",age=" + this.getAge() + ")";
    //}
}
