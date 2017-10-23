package binarySearch;

import java.util.*;


public class BaekJoon1654Correct {
	
	// N���� ������ִ� check �Լ�
	// long[] a: k���� ������ ���� �迭
	// n:�����̰� ������ �ִ� ������ ����
	// m:�ʿ��� ������ ����
	
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
        
        // �����̰� ������ �ִ� ���� �� ���� �� ���̸� max�� ����
        for (int i=0; i<n; i++) {
            a[i] = sc.nextLong();
            max = Math.max(max, a[i]);
        }
        
        // �ʱⰪ ����
        // ans: ���� m�� ����� �ִ� �ִ� ���� ������ �� -> ����
        // l  : left
        // r  : right
        
        long ans = 0;
        long l = 1;
        long r = max;
       
        // left�� right�� �Ѿ�� ���� ����
        
        while (l <= r) {
            long mid = (l+r)/2;
            
            // �ʿ��� ������ �������� ���ų� ���� ���,
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