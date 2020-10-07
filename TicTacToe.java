package com.cp.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	Scanner sc = new Scanner(System.in);
	char[] board ;
	char letter  ;
	String playerTc;
	
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
		while(true) {
			System.out.println("Enter number betwwen 1-9 :");
			int number = sc.nextInt();
			if(board[number]==' ') {
				board[number] =letter; 
				showBoard();
			}else{
				System.out.println("pos occupied , don't you know how to play");
				break;
			}	
		}	
	}
	
	public void playerTossChoice() {
		System.out.println("enter your choice : ");
		int choice = sc.nextInt();
		if(choice == 1) {
			playerTc ="head";
		}
		else {
			playerTc="tail";
		}
		tossWin();
	}	
	
	public void tossWin() {
		int ran =(int) (Math.random() *20 % 2);
		String tossResult;
		if(ran == 0) {
			tossResult = "tail";
		}else {
			tossResult = "head";
		}
		System.out.println("coins shows :" + tossResult);
		
		
		if(tossResult == playerTc) {
			System.out.println("player wins the toss");
		}else {
			System.out.println("computer wins the toss");
		}
	}
	
}
