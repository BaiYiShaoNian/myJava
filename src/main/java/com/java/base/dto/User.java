package com.java.base.dto;

import lombok.Data;

/**
 * Create by huangxuanfeng on 2020/9/29 下午3:36
 */
@Data
public class User {
    private String username;

    private int age;

    private String address;

    private String gender;

    private String city;

    public static class Builder {
        private String username;

        private int age;

        private String address;

        private String gender;

        private String city;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public User (Builder builder) {
        this.username = builder.username;
        this.age = builder.age;
        this.address = builder.address;
        this.gender = builder.gender;
        this.city = builder.city;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
