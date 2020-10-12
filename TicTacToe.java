package com.cp.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	Scanner sc = new Scanner(System.in);
	char[] board ;
	char letter  ;
	String playerTc;
	String currentPlayer;
	char playerChar;
	char opponentChar;
	
	
	TicTacToe(){
		board = new char[10];
		Arrays.fill(board, ' ');
	}
	
	public void chooseOption(){
		System.out.println("Choose x or o :");
		letter = sc.next().charAt(0);
		if(letter == 'x') {
			playerChar = 'x';
			opponentChar = 'o';
			System.out.println("player have x to play ");
			System.out.println("computer have o to play ");
		}
		else {
			playerChar = 'o';
			opponentChar = 'x';
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
		if(currentPlayer == "Computer") {
			computerTurn();
		}else {
			playerTurn();
		}
	}
	
	public void playerTurn() {
		playerMove();
		showBoard();
		if (winningCondition()) {
			System.out.println("Player has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			computerTurn();
	}

	public void computerTurn() {
		computerMove();
		showBoard();
		if (winningCondition()) {
			System.out.println("Computer has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			playerTurn();
	}
	
	public void playerMove() {
		int flag = 0 ;
		while (flag == 0) {
			System.out.println("Enter position : ");
			int position = sc.nextInt();
			if (board[position] == ' ' && position >= 1 && position < 10) {
				System.out.println("Your Mark has been placed at position " + position);
				board[position] = playerChar;
				flag = 1;
			} else
				System.out.println("This Position is not vacant");
		}
	}
	
	public void computerMove() {
		
		int flag = 0;
		while (flag == 0) {
			int position = ((int) Math.floor(Math.random() * 10) % 9) + 1;
			if (board[position] == ' ' && position >= 1 && position < 10) {
				board[position] = opponentChar;
				flag = 1;
			}
		}
	}
	
	public void playerTossChoice() {
		System.out.println("enter your choice 1 for head : ");
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
		int ran =(int) (Math.random() *10 % 2);
		String tossResult;
		if(ran == 0) {
			tossResult = "tail";
		}else {
			tossResult = "head";
		}
		System.out.println("coins shows :" + tossResult);
		
		
		if(tossResult == playerTc) {
			System.out.println("player wins the toss");
			currentPlayer = "user";
		}else {
			System.out.println("computer wins the toss");
			currentPlayer = "computer";
		}
	}
	
	private boolean winningCondition() {
		char checkChar;
		if(currentPlayer == "user")
			checkChar = playerChar;
		else
			checkChar = opponentChar;

		
		for(int i=1; i<10 ;i+=3) {
			if(board[i]==checkChar && board[i+1]==checkChar && board[i+2]==checkChar)
				return true;
		}
		
		for(int i=1;i<=3;i++) {
			if(board[i]==checkChar && board[i+3]==checkChar && board[i+6]==checkChar)
				return true;
		}
		
		if((board[1]==board[5]) && (board[5]==board[9]) && (board[9]==checkChar))
			return true;
		
		if((board[3]==board[5]) && (board[5]==board[7]) && (board[7]==checkChar))
			return true;
		
		return false;	
	}

	
	public boolean drawCondition() {
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				return false;
			}
		}
		return true;
	}

	

	
	
	
}
