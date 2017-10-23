package binarySearch;

import java.util.*;

public class BaekJoon2110Plus {
   
	// 길이 mid 보다 긴 거리가 있으면, cnt++ 해주어서 possible 계산
	public static boolean possible(int[] a, int c, int mid) {
        int cnt = 1;
        int last = a[0];
       
        
        for (int house : a) {
            if (house - last >= mid) {
                cnt += 1;
                last = house;
            }
        }
        return cnt >= c;
    }
    
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int ans = 1;
        int l = 1;
        int r = a[n-1]-a[0];
        
        while (l <= r) {
            int mid = (l+r)/2;
            if (possible(a, c, mid)) {
                ans = Math.max(ans,mid);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        System.out.println(ans);
    }
}