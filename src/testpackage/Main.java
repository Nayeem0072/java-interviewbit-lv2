package testpackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static public ArrayList<Integer> maxset(ArrayList<Integer> A) {
		int maxSoFar = 0;
		int curMax = 0;

		int curStart = 0;
		int curEnd = 0;

		int finalStart = 0;
		int finalEnd = 0;

		boolean first = true;

		for (int i = 0; i < A.size(); i++ ){
			if(A.get(i) >= 0) {
				if(first) {
					curStart = i;
					curEnd = i;
					first = false;
				}
				curMax += 1;
				curEnd ++;
			}
			else {				
				curMax = 0;
				first = true;
			}
			if(maxSoFar < curMax) {
				maxSoFar = curMax;
				finalStart = curStart;
				finalEnd = curEnd;
			}
			if(first) {
				curStart = 0;
				curEnd = 0;
			}

		}
		if(finalStart > 0 && finalEnd == 0){
			finalEnd = finalStart + 1;
		}
		ArrayList<Integer> B = new ArrayList<>();
		for(int i = finalStart; i < finalEnd; i++){
			B.add(A.get(i));
		}
		return B;
	}

	static int maxNonnegetiveSubArray(int a[]){
		int maxSoFar = 0;
		int curMax = 0;
		for (int i = 0; i < a.length; i++ ){
			if(a[i] >= 0) {
				curMax += 1;
			}
			else {				
				curMax = 0;
			}
			maxSoFar = Math.max(maxSoFar, curMax);
		}

		return maxSoFar;
	}

	static int maxSubArraySum(int a[])
	{
		int maxSoFar = a[0];
		int currMax = a[0];
		int size = a.length;

		for (int i = 1; i < size; i++)
		{
			System.out.println(a[i] + " " + Integer.valueOf(currMax+a[i]));
			currMax = Math.max(a[i], currMax+a[i]);			
			maxSoFar = Math.max(maxSoFar, currMax);
			System.out.println("loop end: " +currMax + " " + maxSoFar);
		}
		return maxSoFar;
	}

	static public ArrayList<Integer> incrementSet(ArrayList<Integer> old){
		int n = old.size();
		int carry = 0;



		boolean first = true;
		for(int i = n - 1; i >= 0; i--){
			int d = old.get(i);
			if(first){
				d++;
				first = false;
			}
			if(d > 9) {
				d = 0;
				carry = 1;
			}
			old.set(i, d);
		}
		return null;
	}

	public static int[] repeatMissingArray(ArrayList<Integer> a){
		int size = a.size();
		int aa[] = new int[size];
		Arrays.fill(aa, 0);

		int rval = 0;
		int mval = 0;

		for(int i = 0; i < size; i++){
			if(aa[a.get(i) - 1] == 0) {
				aa[a.get(i)- 1] = a.get(i);				
			}
			else {
				rval = a.get(i);
			}
		}		
		for(int i = 0; i < aa.length; i++) {
			if(aa[i] == 0){
				mval = i + 1;
			}
		}						
		return new int[]{rval, mval};
	}

	public static int maxSumIndex(int[] a){
		int size = a.length;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int ans = Integer.MIN_VALUE;

		for(int i=0; i<size; i++){
			max1 = Math.max(max1, a[i]+i);
			max2 = Math.max(max2, a[i]-i);
			min1 = Math.min(min1, a[i]+i);
			min2 = Math.min(min2, a[i]-i);
		}

		ans = Math.max(ans, (max2 - min2));
		ans = Math.max(ans, (max1 - min1));

		return ans;
	}

	public static void pascalT(int n){
		for (int line = 1; line <= n; line++) {
			int c = 1; 
			for (int i = 1; i <= line; i++) {
				System.out.print(c);
				c = c * (line - i) / i;  
			}
			System.out.print("\n");
		}
	}

	// Driver 
	public static void main(String[] args)
	{

		pascalT(6);





		//		int a[] = {3, -2, 5, -4};
		//		System.out.println(maxSumIndex(a));
		//		ArrayList<Integer> arr = new  ArrayList<>();
		//		for (Integer integer : a) {
		//			arr.add(integer);
		//		}

		//		int[] b = repeatMissingArray(arr);
		//		for (int i : b) {
		//			System.out.println(i);
		//		}


		//		ArrayList<Integer> a = new  ArrayList<>();
		//		a.add(7);
		//		a.add(8);
		//		a.add(9);
		//		
		//		for (Integer integer : a) {
		//			System.out.println(integer);
		//		}


		//		//		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		//		//		int max_sum = maxSubArraySum(a);
		////		int a[] = new int[]{1, 0, 4, 0, 1, -1, -1, 0, 0, 1, 0};
		//		int a[] = new int[]{ -846930886, -1714636915, 424238335, -1649760492 };
		////		System.out.println(maxNonnegetiveSubArray(a));
		//		ArrayList<Integer> arrayList = new ArrayList<>();
		//		for (Integer integer : a) {
		//			arrayList.add(integer);
		//		}
		//		ArrayList<Integer> B =  maxset(arrayList);
		//		for (int i = 0; i < B.size(); i++ ){
		//			System.out.println(B.get(i));
		//		}

	}
}
