package _20260317;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class StreamPractice03 {
    public static void main(String[] args) {
        //Stream流的终结方法练习
        //1. forEach(Consumer<T> action)方法：遍历Stream流中的元素
        //2. count方法：统计Stream流中元素的个数，返回一个long类型的结果
        //3.toArray方法：将Stream流中的元素转换成一个数组，返回一个Object[]类型的结果

        //forEach(Consumer<T> action)方法练习
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张1", "张2", "张3", "李四", "王五", "赵六");
        //accept方法中的参数t依次表示Stream流中的每一个元素
        //方法体：对Stream流中的每一个元素进行的操作
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String t){
                System.out.println(t);
            }
        });

        //使用Lambda表达式简化代码
        list.stream().forEach(s-> System.out.println(s));

        System.out.println("-----------------------------");

        //count方法练习
        long count = list.stream().count();
        System.out.println("Stream流中元素的个数：" + count);

        System.out.println("-----------------------------");

        //toArray方法练习
        Object[] arr = list.stream().toArray();
        System.out.println(Arrays.toString(arr));

        System.out.println("-----------------------------");

        //IntFunction的泛型：具体类型的数组
        //apply的形参：流中数据的个数，要与数组的长度一致
        //apply的返回值：一个具体类型的数组
        //方法体：创建一个与流中数据个数一致的数组，并将其返回
        String[] strArr = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(strArr));

        System.out.println("-----------------------------");

        //使用Lambda表达式简化代码
        String[] arr2 = list.stream().toArray(value->new String[value]);
        System.out.println(Arrays.toString(arr2));
    }
}
