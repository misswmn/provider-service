package com.roncoo.eshop.javase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-04 17:08
 */
public class HashMapTest01 {
    private static final int size = 20_000;
    private static List<String> keyList = new ArrayList<>(size);
    private static Random random = new Random();
    private static char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};

    static {
        for (int i = 0; i < size; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                key.append(chars[random.nextInt(16)]);
            }
            keyList.add(key.toString());
        }
    }

    public static void test01() {
        HashMap<String, String> map = new HashMap<>(4);
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("d", "dd");
        map.put("e", "ee");
        System.out.println(map.size());

        System.out.println(-1 >>> 4);
        System.out.println(Integer.toBinaryString(31));
    }

    public static void test02() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "aa");
        treeMap.put("c", "cc");
        treeMap.put("b", "bb");
        treeMap.put("aa", "aa");
        System.out.println(treeMap);
    }

    public static void test03() {
        long start = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            map.put(key, key);
        }
        long end = System.currentTimeMillis();
        System.out.println("HashMap 用了：" + (end-start));
    }

    public static void test04() {
        long start = System.currentTimeMillis();
        TreeMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            map.put(key, key);
        }
        long end = System.currentTimeMillis();
        System.out.println("TreeMap 用了：" + (end-start));
    }

    public static void main(String[] args) {
//        test02();
//        System.out.println(chars.length);

        test03();
//        test04();
    }
}
