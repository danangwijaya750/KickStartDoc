import java.io.*;
import java.util.*;

class Solution{
public static void main(String[] args) {
    Scanner scanner= new Scanner(new InputStreamReader(System.in));
    int t= scanner.nextInt();
    for (int i = 0; i < t; i++) {
        problemSolve(scanner, i);
    }
    scanner.close();
}
public static void renderln(String data) {
    System.out.println(data);
}
public static void problemSolve(Scanner scan,int trying) {
    long A,B,N;
    A=scan.nextLong();
    A++;
    B=scan.nextLong();
    N=scan.nextLong();
    while(A<=B){
        long middle=(A+B)/2;
        renderln(""+middle);
        String s= scan.next();
        if(s.equals("CORRECT")){
            return;
        }
        if(s.equals("TOO_SMALL")){
            A=middle+1;
        }
        if(s.equals("TOO_BIG")){
            B=middle-1;
        }
    }    
}
}