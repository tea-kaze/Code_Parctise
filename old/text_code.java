//package Practice_Code;
import java.util.ArrayList;
import java.util.Collection;

class text_code {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("Hello");
        c.add("World");

        for (String c2 : c) {
            c2 = "aaa";
        }

        // Lambda表达式示例
        c.forEach(s -> System.out.println(s));

        // 未被修改的原因是因为在增强for循环中，c2只是一个局部变量，它是集合中元素的一个副本。
        // 修改c2并不会改变集合中的元素。Lambda表达式也是一样的，它只是访问了集合中的元素，但没有修改它们。
        // 因此，集合中的元素仍然保持不变。
    }   
}