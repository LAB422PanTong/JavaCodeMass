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

	//ѡ������,���ϰ���С����ǰ��
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
	
	//ð������,��������������λ�ã����ϰѴ�������
	private void boubbleSort(int[] toSort,int n) {
		for(int i=0;i<n-1;++i)
		{
			//ÿ�ηź����һ��������ѭ��һ��
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