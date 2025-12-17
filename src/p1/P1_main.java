package p1;

import java.util.Arrays;
import java.util.Random;

public class P1_main {
	public static void main(String[] args) {
		System.out.println("random Array:" + Arrays.toString(randomArray(2)));
		System.out.println("random Array 2:" + Arrays.toString(randomArray2(2)));
		System.out.println("random Array 3:" + Arrays.toString(randomArray3()));
		System.out.println("random Array 4:" + Arrays.toString(randomArray4(2)));
	}
	
	
	//x has to be bigger or equal than 1
	public static int[] randomArray(int x) {
		int[] randArray = new int[x];
		Random randomNumber = new Random();
		
		for (int i = 0; i < randArray.length; i++) {
			
			randArray[i] = randomNumber.nextInt();
		}
		
		return randArray;
	}
	
	public static int[] randomArray2(int x) {
		int[] randArray = new int[x];
		Random randomNumber = new Random();
		
		for (int i = 0; i < randArray.length; i++) {
			randArray[i] = randomNumber.nextInt(x);
		}
		
		return randArray;
	}
	
	
	public static int[] randomArray3() {
		int[] randArray = new int[6];
		Random randomNumber = new Random();
		
		for (int i = 0; i < randArray.length; i++) {
			randArray[i] = 55 + randomNumber.nextInt(21);
		}
		
		return randArray;
	}
	
	public static int[] randomArray4(int n) {
		int[] randArray = new int[n+1];
		Random randomNumber = new Random();
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			randArray[i] = 1 + randomNumber.nextInt(50);
			
			sum += randArray[i];
		}
		
		
		randArray[n] = sum / n;
		
		System.out.println("avg: " + sum / n + ";" + n + ";" + sum);
		
		return randArray;
	}
}
