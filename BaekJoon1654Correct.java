package binarySearch;

import java.util.*;


public class BaekJoon1654Correct {
	
	// N개를 계산해주는 check 함수
	// long[] a: k개의 랜선의 길이 배열
	// n:영식이가 가지고 있는 랜선의 개수
	// m:필요한 랜선의 개수
	
    public static boolean check(long[] a, int m, long x) {
        int cnt = 0;
        for (int i=0; i<a.length; i++) {
            cnt += a[i]/x;
        }
        return cnt >= m;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        long max = 0;
        
        // 영식이가 가지고 있는 랜선 중 가장 긴 길이를 max에 저장
        for (int i=0; i<n; i++) {
            a[i] = sc.nextLong();
            max = Math.max(max, a[i]);
        }
        
        // 초기값 선언
        // ans: 랜선 m를 만들수 있는 최대 랜선 길이의 값 -> 정답
        // l  : left
        // r  : right
        
        long ans = 0;
        long l = 1;
        long r = max;
       
        // left가 right를 넘어서는 순간 종료
        
        while (l <= r) {
            long mid = (l+r)/2;
            
            // 필요한 랜선의 개수보다 많거나 같은 경우,
            if (check(a, m, mid)) {
            	ans = Math.max(ans,mid);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        System.out.println(ans);
    }
}