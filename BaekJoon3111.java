package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

// �˿�
public class BaekJoon3111 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Deque<String> deque = new LinkedList<String>();
		
		
		String checkWord = sc.nextLine();
		String text = sc.nextLine();
		
		for(int i=0; i< text.length(); i++) {
			deque.offer(text.substring(i, i+1));
			
		}
		
		finalScore(checkWord, deque);
		
	}

	static void finalScore(String checkWord, Deque<String> deque) {

		// ���� ����
		int length = checkWord.length();
		String finalWord = "";
		Stack<String> stack1 = new Stack<String>();
		Stack<String> stack2 = new Stack<String>();
		boolean OK1 = true;
		boolean OK2 = true;
		boolean OK3 = true;
		
		// 
		while(!deque.isEmpty()) {
			
			// stack1�� �տ��� ���� ����. �̶� top���� A ���ڿ��� ������ stack���� �����.
			// ������ stack1�� �ް� ����� ���
				
				// deque�� ������� �ʰ�, stack1�� �˻� ���ڿ� ���� ª����, ���ڿ� ���̰� �ɶ����� push
				while(!deque.isEmpty() && stack1.size() < length) {
					String a = deque.pollFirst();
					stack1.add(a);
				}
				
				// ���ڿ� �˻�. A�� ������ pop �� while���� ��������
				// A�� �ٸ���, deque�� ������� ������ ��� �߰��ϸ鼭 �˻�
				while(OK1 && stack1.size() >= length) {
					String temp = "";
					for(int i=0; i<length; i++) {
						temp = stack1.pop()+temp;
					}
					
					
					if(!(temp.equals(checkWord))){
						for(int i=0; i<length; i++) {
							stack1.add(temp.substring(i, i+1));
						}
					}else {
						break;
					}
					// ���� deque�� ��� �ִٸ�, ���̻� stack1�� ������ �����Ƿ�, while���� ���� ����
					// �ִٸ�
					if(deque.isEmpty()) {
							OK1 = false;
					}else {
							stack1.add(deque.pollFirst());
						}
					
				}
				
			// stack2�� �ڿ������� �״´�. �̶� top���� A ���ڿ��� ������ 
			// stack���� ����. ������ stack1 �� �ް� ����� ���
				
				while(!deque.isEmpty() && stack2.size() < length) {
					stack2.push(deque.pollLast());
				}
			
				while(OK2 && stack2.size() >= length) {
					String temp2 = "";
					for(int i=0; i<length; i++) {
						temp2 += stack2.pop();
					}
					
					if(!temp2.equals(checkWord)) {
						for(int i=length; i >= 1; i--) {
							stack2.add(temp2.substring(i-1, i));
						}
					}else {
						break;
					}
						
					if(deque.isEmpty()){
							OK2 = false;
					}else{
							stack2.add(deque.pollLast());
						}
					
				}
		}
		
			// 
			while(!stack1.isEmpty()) {
				
				stack2.push(stack1.pop());
			
			while(stack2.size() >= length && OK3) {
			
			String temp3 = "";
			for(int i=0; i<length; i++) {
					temp3 += stack2.pop();
			}
			
			if(!temp3.equals(checkWord)) {
				for(int i=length; i >= 1; i--) {
					stack2.push(temp3.substring(i-1, i));
			}
			}
			if(stack1.isEmpty()){
				OK3 = false;
			}else {
				stack2.push(stack1.pop());
			}
		}
	}
		
		while(!stack2.isEmpty()) {
			finalWord += stack2.pop();
		}
		
		System.out.println(finalWord);
	}
}
