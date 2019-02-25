import java.io.*;
import java.util.*;
class Solution{
public static void renderln(String data){
        System.out.println(data);
}
public static ArrayList <Long> scores= new ArrayList<>();
public static void main(String[] args) {
  Scanner scanner= new Scanner(new InputStreamReader(System.in));
  int t= scanner.nextInt();
  for (int i = 0; i < t; i++) {
      problemSolve(scanner, t);
  }
  for (int i = 0; i < scores.size(); i++) {
    renderln("Case #"+(i+1)+": "+scores.get(i));
  }
  scanner.close();
}
public static void problemSolve(Scanner scann, int trying) {
    long n = scann.nextLong();
    String str= scann.next();
    ArrayList <Long> wall= new ArrayList<>();
    for (int i = 0; i < n; i++) {
        wall.add(Long.parseLong(String.valueOf(str.charAt(i))));
    }
    int notDestroy= (int) Math.ceil((double)n/2);
    long maxScore=0;
    for (int index = 0; index < n - notDestroy+1; index++) {
        long result=0;
        for (int x = index; x < notDestroy+index; x++) {
            result = result + wall.get(x);
        }
        if(result > maxScore){
            maxScore=result;
        }
    }
    scores.add(maxScore);
}
}