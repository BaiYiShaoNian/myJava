package com.java.base;

import com.google.gson.Gson;
import com.java.base.dto.City;
import com.java.base.dto.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Create by huangxuanfeng on 2020/12/13 下午9:37
 *
 * @author huangxuanfeng
 */
public class MyCollection {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println(list);
        list.forEach(System.out::print);
        list.removeIf(x -> x % 2 == 0);
        System.out.println(list);

        list.sort((x, y) -> y - x);
        System.out.println(list);

        /* **** map  **********/
        Map<String, String> map = new HashMap<String, String>(){
            {
                put("huang", "23");
                put("xuan", "30");
            }
        };
        System.out.println(map);

        City city = new City();
        List<City> cityList = new ArrayList<>();

        city.setCountry("中国"); city.setProvince("四川");
        cityList.add(city);

        city = new City();
        city.setCountry("中国"); city.setProvince("河南");
        cityList.add(city);

        city = new City();
        city.setCountry("美国"); city.setProvince("南加州");
        cityList.add(city);
        Map<String, City> cityMap = cityList.stream()
                .collect(Collectors.toMap(City::getCountry, Function.identity(), (v1, v2) -> v1));

        Gson gson = new Gson();
        System.out.println(gson.toJson(cityMap));

        System.out.println(map);
        Map<String, String> map1 = new HashMap<>();
        map1.put("huang1", "2342");
        System.out.println(map1);

        map.putAll(map1);
        System.out.println(map);
        map1 = null;
        if (MapUtils.isNotEmpty(map1)) {
            map.putAll(map1);
            System.out.println(map);
        }
    }
}
