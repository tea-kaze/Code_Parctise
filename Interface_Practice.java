//package Practice_Code;

public class Interface_Practice {
    public interface A {
        int flag = 1; // implicitly public, static, and final
        int show();
        
    }

    public interface B {
        int flag = 2; // implicitly public, static, and final
        int show();
        boolean campare(B b);
    }

    public static interface  C extends A, B {
        int Cflag = A.flag + B.flag;
    }
}

