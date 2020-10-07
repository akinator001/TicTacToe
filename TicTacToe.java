package com.cp.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	Scanner sc = new Scanner(System.in);
	char[] board ;
	
	TicTacToe(){
		board = new char[10];
		Arrays.fill(board, ' ');
	}
	
	public void chooseOption(){
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
	
	public void showBoard() {
		for(int i=0; i<10; i++) {
			System.out.print(board[i]+" -- ");
		}
		System.out.println();
	}
}
