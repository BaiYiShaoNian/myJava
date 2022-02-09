package com.keep.me.jsons;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.keep.me.model.Book;
import com.keep.me.model.Response;
import com.keep.me.model.Shop;
import com.keep.me.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by huangxuanfeng on 2022/1/27 5:25 PM
 *
 * @author huangxuanfeng
 */
public class HelloGson {

    public static void main(String[] args) {
        User user = new User();
        List<User> userList = new ArrayList<>();
        Shop shop = new Shop();
        Book book = new Book();

        book.setId(123);
        book.setName("huang-book");

        shop.setProvince("省：重庆市");
        shop.setCity("市：重庆市");
        book.setShop(shop);

        user.setId("sfeqfjpr234");
        user.setUsername("黄");
        user.setAge(28);
        userList.add(user);
        book.setUserList(userList);

        Gson gson = new Gson();
        String ob2json = gson.toJson(book);
        System.out.println("ob2json: " + ob2json);

        user = new User();
        userList = new ArrayList<>();
        shop = new Shop();
        book = new Book();

        // book = gson.fromJson(ob2json, Book.class);
        book = gson.fromJson(ob2json, new TypeToken<Book>(){}.getType());
        userList = book.getUserList();
        shop = book.getShop();
        System.out.println(book.getId() + " " + book.getName());
        System.out.println(shop.getProvince() + " " + shop.getCity());
        System.out.println(userList.size() + " " + userList.get(0).getUsername());

        user.setAge(30);
        user.setUsername("张");
        userList.add(user);
        ob2json = gson.toJson(userList);
        System.out.println(ob2json);
        userList = gson.fromJson(ob2json, new TypeToken<List<User>>(){}.getType());
        System.out.println("userList: " + userList);
        for (User tmp: userList) {
            System.out.println(tmp.getUsername() + " " + tmp.getId() + " " + tmp.getAge());
        }

        Response<String> response = new Response<>();
        response.setStatus(200);
        response.setMessage("hh");
        response.setData("test-data");
        ob2json = gson.toJson(response);
        System.out.println("res: " + ob2json);
        response = gson.fromJson(ob2json, new TypeToken<Response>(){}.getType());
        System.out.println(response.getStatus() + " " + response.getMessage() + " " + response.getData());

        Response<Book> res = new Response<>();
        res.setStatus(200);
        res.setMessage("hh");
        res.setData(book);
        ob2json = gson.toJson(res);
        System.out.println("res: " + ob2json);
        res = gson.fromJson(ob2json, new TypeToken<Response<Book>>(){}.getType());
        System.out.println(res.getStatus() + " " + res.getMessage() + " " + res.getData());
        System.out.println(res.getData().getShop().getProvince());

    }
}
