package _20260317;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class StreamPractice02 {
    public static void main(String[] args) {
        //Stream流的中间方法练习
        //map方法：将Stream流中的元素转换成其他类型的元素，返回一个新的Stream流
        //细节：map方法中的参数是一个函数式接口Function接口的实现类对象，Function接口中有一个抽象方法apply，
        //apply方法的参数是Stream流中的元素，返回值是转换后的元素

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三-15", "李四-16", "王五-17", "赵六-18", "钱七-19", "孙八-20");

        //需求：只获取list中每个元素的年龄部分，即“-”后面的部分，并打印出来（String->Integer）
        list.stream().map(new Function<String,Integer>() {
            //Function后的<>中第一个参数是流中原本的数据类型
            //                第二个参数是要转化成的数据类型

            //apply方法中形参s依次表示流里面的每一个数据
            //        第二个参数是apply方法的返回值类型
            @Override
            public Integer apply(String s) {
                //使用split方法将字符串分割成一个字符串数组，分割符是“-”，然后获取数组中索引为1的元素，
                //即年龄部分，并将其转换成Integer类型返回
                return Integer.parseInt(s.split("-")[1]);
            }
        }).forEach(System.out::println);

        System.out.println("-----------------------------");

        //使用Lambda表达式简化代码
        list.stream()
            .map(s->Integer.parseInt(s.split("-")[1]))
            .forEach(s->System.out.println(s));
    }
}
