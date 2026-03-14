package _20260312;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class demo02 {
    public static void main(String[] args) {
        
        /*  练习：实现随机点名器
            要求：
            被点到的学生不会再次被点到
            但是如果班级中所有学生都被点到过了，那么就重新开始点名
            
            男生：男1~男7
            女生：女1~女3    
        */

        //思路：
        //1. 用一个集合存储所有学生
        ArrayList<String> students = new ArrayList<>();
        Collections.addAll(students, "男1", "男2", "男3", "男4", "男5", "男6", "男7", "女8", "女9", "女0");

        //2. 用一个集合存储待点名的学生（即还未被点到）
        ArrayList<String> toSelect = new ArrayList<>(students);

        System.out.println("请输入要点名的次数：");
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();

        //如果要点名三次，则循环下面部分代码三次
        for (int i = 0; i < times; i++) {
            //3. 每次点名时，从待点名的集合中随机选择一个学生，并将其从待点名的集合中移除
            while (!toSelect.isEmpty()) {
                Random random = new Random();
                int index = random.nextInt(toSelect.size()); // 生成0~待点名集合大小-1的随机数

                String selectedStudent = toSelect.get(index); // 获取被点到的学生
                System.out.println("点到了" + selectedStudent);
                toSelect.remove(index); // 将被点到的学生从待点名的集合中移除
            }
            
            //4. 当循环结束时，待点名的集合为空，说明所有学生都被点到过了，可以重新开始点名
            if(i < (times-1)) System.out.println("所有学生都被点到过了，重新开始点名...");
            toSelect.addAll(students); 
        }

        scanner.close();
    }
}