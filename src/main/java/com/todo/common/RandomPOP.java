package com.todo.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 按指定概率选取元素
 */
public class RandomPOP {
    /**
     *
     * @param ipArr ip数组
     * @param probablyArr ip对应的概率
     * @param count 选取次数
     */
    public static void select(String[] ipArr, int[] probablyArr, int count){
        int total = Arrays.stream(probablyArr).sum();
        System.out.println(total);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<probablyArr.length; i++){
            for(int j=0; j<probablyArr[i]; j++){
                list.add(i);
            }
        }
        // list [0,1,1,1,2,2,2,2,2,2]  list是1个0，3个1，6个2
        Random random = new Random();
        int k=0;
        while (k++<count){
            int nextIndex = list.get(random.nextInt(list.size()));
            System.out.println(ipArr[nextIndex]);
        }
    }

    public static void main(String[] args) {
        String[] ipArr = {"192.168.0.1","192.168.0.2", "192.168.0.3"};
        int[] probablyArr = {1, 3, 6};
        select(ipArr, probablyArr, 30);
    }
}
