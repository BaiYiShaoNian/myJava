package com.keep.me.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class KeepUser extends User {
    private int age;

    //@Override
    //public String toString() {
    //    return "KeepUser(name=" + this.getName() + ",age=" + this.getAge() + ")";
    //}
}
