package day01;

import java.util.Scanner;
//题目：https://www.nowcoder.com/pat/6/problem/4077
public class A_B_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 1;i<= n;i++){
            Long A = sc.nextLong();
            Long B = sc.nextLong();
            Long C = sc.nextLong();
            if(A+B>C){
                a[i]=1;
            }else {
                a[i]=0;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(a[i]==1){
                System.out.println("Case #"+i+": true");
            }else {
                System.out.println("Case #"+i+": false");
            }
        }
    }
}
