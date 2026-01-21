//package Practice_Code;
import java.util.Scanner;

class text_code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int secondTime = sc.nextInt();
        int hours = secondTime / 3600;
        int minutes = (secondTime % 3600) / 60; 
        int seconds = secondTime % 60;
        System.out.printf("%d %d %d", hours, minutes, seconds);
        sc.close();

    }   
}