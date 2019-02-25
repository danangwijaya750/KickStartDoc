import java.util.*;
import java.io.*;
public class Solution {
	public static ArrayList <Long> results=new ArrayList<>(); 
 public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  
    
    for (int tt = 1; tt <= t; tt++) 
    	  solve(in, tt);
   
    in.close();
    for (int i = 0; i < results.size();i++) {
        renderln("Case #" + (i+1) + ": " + results.get(i));  
    }
  }
 
 private static void renderln(String data) {
	 System.out.println(data);
 }
 
 private static int MOD = 1000000007;
 
 /////////????????
 private static long add(long a, long b){
     return multiply(multiply(a, modPower(a,b)-1+MOD), modPower(a-1, MOD-2));
 }
 
 private static long multiply(long a, long b){
     if(a>=MOD)
    	 	a%=MOD;
     
     if(b>=MOD)
    	 	b%=MOD;
     
     return (a*b)%MOD;
 }
 
 private static long  modPower(long a, long b){
     long aa = 1;
     
     while(b>0){
         if((b&1)==1) 
        	 	aa = multiply(aa,a);
         b>>=1;
         a = multiply(a,a);
     }
     
     return aa;
 }
 
private static void solve(Scanner scan, int tt) {
	long n = scan.nextLong();
	long k = scan.nextLong();
	long a = scan.nextLong();
	long b = scan.nextLong();
	long C = scan.nextLong();
	long D = scan.nextLong();
	long E1 = scan.nextLong();
	long E2 = scan.nextLong();
	long F = scan.nextLong();
	
	long Arr[] = new long[(int) n];
	
	Arr[0]= (a+b)%F;
	
    for(int idx = 1; idx< n; idx++){
        long aa = (C*a+D*b+E1)%F, bb = (D*a+C*b+E2)%F;
        a=aa;b=bb;
        Arr[idx] = (a+b)%F;
    }
    
    long[] Arr2 = new long[(int) n+1];
    
    Arr2[1] = k;
    
    for(int idx = 2; idx<= n; idx++){
        Arr2[idx] = Arr2[idx-1]+add(idx, k);
        if(Arr2[idx]>=MOD)
        	  Arr2[idx]%=MOD;
    }
    long res = 0;
    
    for(int idx = 0; idx< n; idx++){
        long aa = idx+1, bb = n-idx;
        res+= multiply(Arr[idx], multiply(Arr2[(int)aa], bb));
        if(res>=MOD)
        	   res%=MOD;
    }
 	results.add(res);
}
  
}