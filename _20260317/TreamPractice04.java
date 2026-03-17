package _20260317;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.Map;

public class TreamPractice04 {
    public static void main(String[] args) {
        //Stream流的终结方法练习
        //4.collect(collector,collector)方法：将Stream流中的元素收集到一个集合(List、Set、Map)中，返回一个Collection类型的结果
        //注意：如果要收集到Map集合中，Stream流中不能有重复的键，否则会抛出IllegalStateException异常

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张1-男-16", "张2-男-17", "张3-女-16", "李四-男-20", 
                            "王五-女-22", "赵六-男-33", "钱七-女-18", "孙八-男-19", "周九-女-21", "吴十-男-25");

        //收集到List集合
        //把所有的男性元素收集到一个List集合中
        List<String> maleList = list.stream()
            .filter(s->"男".equals(s.split("-")[1]))
            .collect(Collectors.toList());

        System.out.println(maleList);

        System.out.println("----------------------------------------------------------------------");

        //收集到Set集合(可以去重)
        //把所有的男性元素收集到一个Set集合中
        Set<String> maleSet = list.stream()
            .filter(s->"男".equals(s.split("-")[1]))
            .collect(Collectors.toSet());

        System.out.println(maleSet);

        System.out.println("----------------------------------------------------------------------");

        //收集到Map集合
        //把所有的男性元素收集到一个Map集合中，要求：以姓名作为键，以年龄作为值
        //细节：如果Stream流中有重复的键，则会抛出IllegalStateException异常
        Map<String, Integer> maleMap = list.stream()
            .filter(s->"男".equals(s.split("-")[1]))
            /*  
                toMap:参数一表示键的生成规则
                      参数二表示值的生成规则

                参数一：
                Function泛型一：Stream流中每个元素的数据类型
                Function泛型二：Map集合中键的数据类型

                allpy方法形参：依次表示Stream流中的每一个元素
                       方法体：生成键的代码
                       返回值：生成的键
            
                参数二：
                Function泛型一：Stream流中每个元素的数据类型
                Function泛型二：Map集合中值的数据类型

                allpy方法形参：依次表示Stream流中的每一个元素
                       方法体：生成键的代码
                       返回值：生成的键
            
            */
            .collect(Collectors.toMap(new Function<String/* Stream流中每个元素的数据类型 */, String/* Map集合中键的数据类型 */>() {
                @Override
                public String/* Map集合中键的数据类型 */ apply(String s/* Stream流中每个元素的数据类型 */) {
                    //返回Stream流中元素的姓名部分，即“-”前面的部分，作为键
                    return s.split("-")[0];
                }
            }, new Function<String, Integer>() {
                @Override
                public Integer/* Map集合中值的数据类型 */ apply(String s/* Stream流中每个元素的数据类型 */) {
                    //返回Stream流中元素的年龄部分，即“-”后面的部分，作为值
                    return Integer.parseInt(s.split("-")[2]);
                }
            }));

        System.out.println(maleMap);

        System.out.println("----------------------------------------------------------------------");

        //使用Lambda表达式简化代码
        Map<String, Integer> maleMap2 = list.stream()
            .filter(s->"男".equals(s.split("-")[1]))
            .collect(Collectors.toMap(s->s.split("-")[0], 
                                      s->Integer.parseInt(s.split("-")[2])));
        
        System.out.println(maleMap2);
    }
}
