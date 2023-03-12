package leetcode.campus.meituan;

import java.util.Scanner;

/**
 * @author lrd
 * @date 2023-03-11 21:46
 * 3-11笔试第一题
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 1;
        int ans = 0;
        char[] arr = str.toCharArray();
        char index = arr[0];

        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];
            if(index == c){
                count++;
            }else {
                index = c;
                ans += (count / 2);
                count = 1;
            }
        }
        ans += (count / 2);
        System.out.println(ans);
    }


}
