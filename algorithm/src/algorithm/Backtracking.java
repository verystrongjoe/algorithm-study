package algorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backtracking 
{
	static int N = 4;
	static int[] sol = new int[N];
	static int[] perm = new int[N];
	
	public static void main(String args[])
	{
		backtrack(0);
	}
	
	public static void backtrack(int n)
	{
		//System.out.println("isSolution(n) ["+isSolution(n)+"]");
		if(isSolution(n))
		{
			processSolution();
			return;
		}
		
		for(int i=0; i<N; i++)
		{
			if(perm[i] == 0)
			{
				sol[n] = i+1;
				perm[i] = 1;
				backtrack(n+1);
				perm[i]=0;
			}
		}
	}
	
	public static boolean isSolution(int n)
	{
		return (n==N);
	}
	
	public static void processSolution()
	{
		for(int i=0; i<N; i++)
		{
			System.out.printf("%d", sol[i]);
		}
		System.out.println();
	}
}
