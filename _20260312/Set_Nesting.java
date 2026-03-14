package _20260312;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class Set_Nesting {
    public static void main(String[] args) {
        
        // 需求:
        // 定义一个Map集合，键用表示省份名称province，值表示市city，但是市会有多个。添加完毕后，遍历结果格式如下:
        // 江苏省 = 南京市，扬州市，苏州市，无锡市，常州市
        // 湖北省 = 武汉市，孝感市，十堰市，宜昌市，鄂州市
        // 河北省 = 石家庄市，唐山市，邢台市，保定市，张家口市

        //1.采用集合嵌套的方法
        HashMap<String, ArrayList<String>> hsmap = new HashMap<>();
        ArrayList<String> jiangsuCities = new ArrayList<>();
        ArrayList<String> hubeiCities = new ArrayList<>();  
        ArrayList<String> hebeiCities = new ArrayList<>();

        //2.添加城市
        Collections.addAll(jiangsuCities, "南京市", "扬州市", "苏州市", "无锡市", "常州市");
        Collections.addAll(hubeiCities, "武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");
        Collections.addAll(hebeiCities, "石家庄市", "唐山市", "邢台市", "保定市", "张家口市");

        //3.将省份和对应的城市集合添加到Map集合中
        hsmap.put("江苏省", jiangsuCities); 
        hsmap.put("湖北省", hubeiCities);
        hsmap.put("河北省", hebeiCities);

        //4.遍历Map集合，输出结果
        Set<Map.Entry<String, ArrayList<String>>> entries = hsmap.entrySet();
        //5.外层循环遍历Map集合，获取每个省份和对应的城市集合
        for(Map.Entry<String, ArrayList<String>> entry : entries) {
            String province = entry.getKey();
            ArrayList<String> cities = entry.getValue();
            StringJoiner sj = new StringJoiner("，","", "");    //三个参数分别是：分隔符、前缀、后缀
            //6.内层循环遍历城市集合，将每个城市添加到StringJoiner中
            for(String city : cities) {
                sj.add(city);
            }
            System.out.println(province + " = " + sj);
        }
    }
}
