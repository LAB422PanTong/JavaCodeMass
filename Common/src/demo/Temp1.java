package demo;

import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class Temp1 {

	public static void main(String[] args) {
		Temp1 a = new Temp1();
		int[] nums = { 1, 3, 5, 7, 2, 6, 4, 8, 9, 2, 8, 7, 6, 0, 3, 5, 9, 4, 1, 0 };
		//a.boubbleSort(nums, nums.length);
		
			
		System.out.println(Arrays.toString(nums));
	}

	//选择排序,不断把最小的往前放
	private void selectSort(int[] toSort, int n) {
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (toSort[j] < toSort[i]) {
					int temp = toSort[i];
					toSort[i] = toSort[j];
					toSort[j] = temp;
				}
			}
		}
	}
	
	//冒泡排序,交换相邻两个的位置，不断把大的往后放
	private void boubbleSort(int[] toSort,int n) {
		for(int i=0;i<n-1;++i)
		{
			//每次放后面多一个，就少循环一次
			for(int j=0;j<n-i-1;++j)
			{
				if (toSort[j] > toSort[j+1]) {
					int temp = toSort[j];
					toSort[j] = toSort[j+1];
					toSort[j+1] = temp;
				}
			}
		}
	}
}