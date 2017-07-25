package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TddApplication {

	// to calculate max value
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Solve method for Solving provided algorithm
	static int solve(int timeTaken, int wt[], int val[], int numberOfItems) {

		int i, w;
		int K[][] = new int[numberOfItems + 1][timeTaken + 1];

		for (i = 0; i <= numberOfItems; i++) {
			for (w = 0; w <= timeTaken; w++) {
				if (i == 0 || w == 0)
					{K[i][w] = 0;}
				else if (wt[i - 1] <= w)
					{K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);}
				else
					{K[i][w] = K[i - 1][w];}
			}
		}

		return K[numberOfItems][timeTaken];
	}

	// Driver program to test above function
	public static void main(String args[]) {

		int storageStructure[] = new int[100000];
		int time[] = new int[100000];
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("data.txt"));// Reading File
			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] arr = sCurrentLine.split(" ");
				// for the first line it'll print
				storageStructure[i] = Integer.parseInt(arr[0]);
				time[i] = Integer.parseInt(arr[1]);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close(); // This will be executed Every-time
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		int time_t = 100;
		int n = storageStructure.length; // calculating length of file
		System.out.println("Result:" + solve(time_t, time, storageStructure, n)); // Calling Solve Method
														

	}
}
