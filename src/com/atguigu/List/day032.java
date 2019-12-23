package com.atguigu.List;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author hyz
 * @create 2019-12-16 20:33
 */
public class day032 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 1;i<=30; i++){
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
