package com.cp.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	Scanner sc = new Scanner(System.in);
	char[] board ;
	char letter  ;
	TicTacToe(){
		board = new char[10];
		Arrays.fill(board, ' ');
	}
	
	public void chooseOption(){
		System.out.println("Choose x or o :");
		letter = sc.next().charAt(0);
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
		System.out.println("Board is like :");
		for(int i=1; i<10; i=i+3) {
			System.out.println(board[i]+" | " +board[i+1]+" | "+ board[i+2]);
			System.out.println("---------");
		}
		System.out.println();
	}
	public void makeMove() {
		System.out.println("Enter number betwwen 1-9 :");
		int number = sc.nextInt();
		if(board[number]==' ') {
			board[number] =letter; 
		}else{
			System.out.println("pos occupied");
		}	
	}
}
