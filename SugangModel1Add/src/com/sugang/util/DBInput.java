package com.sugang.util;

import java.util.Scanner;

public class DBInput {
	private static Scanner sc = new Scanner(System.in);
	public static int inputInt() {
		System.out.println("only number :");
		return Integer.parseInt(sc.nextLine());
	}
	public static String inputString() {
		System.out.println("only letter :");
		return sc.nextLine();
	}
}
