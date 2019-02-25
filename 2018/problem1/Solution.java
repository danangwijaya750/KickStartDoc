import java.io.*;
import java.util.*;
class Solution{
    static ArrayList<Long> results= new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int t= scanner.nextInt();
        for (int i = 0; i < t; i++) {
            problemSolving(scanner,i);
        }
        scanner.close();
        for (int i = 0; i < results.size(); i++) {
            renderln("Case #"+(i+1)+": "+results.get(i));
        }
    }
    static void renderln(String data){
        System.out.println(data);
    }
    static void problemSolving(Scanner scanner, int t){
        String data= scanner.next();
        String firstData = data;
        ArrayList <Long> buttonPush= new ArrayList<>();
        long buttonPlus =0;
        long buttonMin =0;
        while(!oddExist(data)){
            long dataLong = Long.parseLong(data);
            dataLong++;
            data = String.valueOf(dataLong);
            buttonPlus++;
        }
        buttonPush.add(buttonPlus);
        data=firstData;
        while(!oddExist(data)){
            long dataLong = Long.parseLong(data);
            dataLong--;
            data = String.valueOf(dataLong);
            buttonMin++;
        }
        buttonPush.add(buttonMin);
        results.add(Collections.min(buttonPush));
    }
    static boolean oddExist(String data){
       boolean result= true;
       for (int i = 0; i < data.length(); i++) {
        if(Character.getNumericValue(data.charAt(i))%2!=0){
            result=false;
            break;
        }
    }
       return result;
    }
    
}