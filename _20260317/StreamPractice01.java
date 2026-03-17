package _20260317;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamPractice01 {
    public static void main(String[] args) {
        //Stream流的中间方法练习
        //1. filter方法：过滤掉不满足条件的元素，返回一个新的Stream流
        //2.limit方法：截取前n个元素，返回一个新的Stream流
        //3.skip方法：跳过前n个元素，返回一个新的Stream流
        //4.distinct方法：去重，返回一个新的Stream流(依赖元素的hashCode和equals方法，若是自定义类型的元素，则需要重写hashCode和equals方法)
        //concat方法：合并两个Stream流，返回一个新的Stream流

        //细节：
        //1.中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
        //2.修改Stream流中的数据，不会影响原集合或数组中的数据

        //1. filter方法练习
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张1", "张2", "张3", "李四", "王五", "赵六");

        //需求：过滤掉不以“张”开头的元素,即将以“张”开头的元素保留下来
        //细节：filter方法中的参数是一个函数式接口Predicate接口的实现类对象，Predicate接口中有一个抽象方法test，
        //test方法的参数是Stream流中的元素，返回值是boolean类型,返回true表示保留该元素，返回false表示过滤掉该元素
        //为了方便阅读，可以使用Lambda表达式来简化代码，并将链式编程的每个方法分行写
        list.stream()
            .filter(s -> s.startsWith("张"))
            .forEach(s-> System.out.println(s));   //张1、张2、张3

        System.out.println("-----------------------------");

        //2. limit方法练习
        //获取list中前2个元素
        list.stream()
            .limit(2)
            .forEach(s-> System.out.println(s));   //张1、张2

        System.out.println("-----------------------------");

        //3. skip方法练习
        //获取list中除前4个元素以外的元素
        list.stream()
            .skip(4)
            .forEach(s-> System.out.println(s));   //李四、王五、赵六

        System.out.println("-----------------------------");

        //综合练习1：获取list中以“张”开头的前2个元素
        list.stream()
            .filter(s->s.startsWith("张"))
            .limit(2)
            .forEach(s->System.out.println(s));  //张1、张2

        //综合练习2：获取list中第四和第五个元素
        list.stream()
            .skip(3)
            .limit(2)
            .forEach(s->System.out.println(s));   //李四、王五

        System.out.println("-----------------------------");

        //4. distinct方法练习   如果是自定义类型的元素，则需要重写hashCode和equals方法，否则无法去重
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张1", "张2", "张3", "李四", "张1", "李四");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "王五", "赵六");

        list1.stream()
            .distinct()
            .forEach(s-> System.out.println(s));   //张1、张2、张3、李四

        System.out.println("-----------------------------");

        //5. concat方法练习
        //将list1和list2合并成一个Stream流
        Stream.concat(list1.stream(), list2.stream())
            .distinct() //去重
            .forEach(s-> System.out.println(s));   //张1、张2、张3、李四、王五、赵六
    }
}
