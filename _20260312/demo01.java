package _20260312;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class demo01 {
    public static void main(String[] args) {
        
        /*  练习：实现随机点名器
            要求：
            70%概率点到男生
            30%概率点到女生
            
            男生：男1~男7
            女生：女1~女3    
        */

        //思路：

        //1. 男女生分开两个数组存储
        ArrayList<String> boys = new ArrayList<>();
        ArrayList<String> girls = new ArrayList<>();
        Collections.addAll(boys, "男1", "男2", "男3", "男4", "男5", "男6", "男7");
        Collections.addAll(girls, "女1", "女2", "女3");

        //2. 再用一个数组存储[1,1,1,1,1,1,1,0,0,0]，其中1代表男生，0代表女生
        ArrayList<Integer> selectarr = new ArrayList<>();
        Collections.addAll(selectarr, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);

        //3. 随机生成一个0~9的随机数，根据这个随机数来决定点到男生还是女生
        Random random = new Random();
        int index = random.nextInt(selectarr.size()); // 生成0~9的随机数

        //4. 根据点到的结果，再随机生成一个随机数来决定点到哪个男生或者女生
        if(selectarr.get(index) == 1) {
            //点到男生
            int boyIndex = random.nextInt(boys.size()); // 生成0~6的随机数
            System.out.println("点到了" + boys.get(boyIndex));
        } else {
            //点到女生
            int girlIndex = random.nextInt(girls.size()); // 生成0~2的随机数
            System.out.println("点到了" + girls.get(girlIndex));
        }
    }
}
