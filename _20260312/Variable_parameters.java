package _20260312;

public class Variable_parameters {
    //可变参数：在方法的参数列表中使用三个点(...)来表示可变参数，可以接受任意数量的参数。
    //格式：数据类型... 参数名
    //细节：
    //1. 方法中只能有一个可变参数。
    //2. 在方法内部，可变参数被视为一个数组，可以使用数组的方式来访问和操作它们。
    //3. 可变参数可以与其他参数一起使用，但必须放在最后。
    public static void main(String[] args) {
        System.out.println(getSum(1, 2, 3, 4, 5, 6)); // 输出：6
        System.out.println(getSum(999, 995));    // 输出：9
        System.out.println(getSum(6));       // 输出：6

        System.out.println("---------------------------------------------------"); 
        System.out.println(getSum2(10, 1, 2, 3)); // 输出：16
        
    }


    public static int getSum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static int getSum2(int a, int... nums) {
        int sum = a;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    // 错误示例：可变参数没有放在最后
    //可以把可变参数看作一个大胖子，对传入的参数来者不拒，有多少就接受多少
    // public static int getSum3(int... nums, int a) {
    //     int sum = a + b;
    //     for (int num : nums) {
    //         sum += num;
    //     }
    //     return sum;
    // }
}

