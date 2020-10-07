package com.cp.tictactoe;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		System.out.println("Welcome");
		Scanner sc = new Scanner(System.in); 
		TicTacToe ticObj = new TicTacToe();
		
		System.out.println("Choose x or o :");
		char letter  = sc.next().charAt(0);
		if(letter == 'x') {
			System.out.println("player have x to play ");
			System.out.println("computer have o to play ");
		}
		else {
			System.out.println("player have o to play ");
			System.out.println("computer have x to play ");
		}
	}

}
