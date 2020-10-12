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
			if (isAvailable(position)) {
				System.out.println("Your Mark has been placed at position " + position);
				board[position] = playerChar;
				flag = 1;
			} else
				System.out.println("This Position is not vacant");
		}
	}
	
	public void computerMove() {
		int position = ifPossibleToWin();
		if (position == 0) {
			position = blockPlayer();
		}
		board[position] = opponentChar;
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

	public boolean isAvailable(int position) {
		if (board[position] == ' ' && position >= 1 && position < 10)
			return true;
		else
			return false;
	}
	
	
	public int ifPossibleToWin() {
		char ch;
		if(currentPlayer == "user")
			ch = playerChar;
		else
			ch = opponentChar;
		
		if (isAvailable(1) && ((board[2] == ch && board[3] == ch) || (board[4] == ch && board[7] == ch)
				|| (board[5] == ch && board[9] == ch)))
			return 1;

		if (isAvailable(2) && ((board[1] == ch && board[3] == ch) || (board[5] == ch && board[8] == ch)))
			return 2;

		if (isAvailable(3) && ((board[2] == ch && board[1] == ch) || (board[6] == ch && board[9] == ch)
				|| (board[5] == ch && board[7] == ch)))
			return 3;

		if (isAvailable(4) && ((board[1] == ch && board[7] == ch) || (board[5] == ch && board[6] == ch)))
			return 4;

		if (isAvailable(5) && ((board[1] == ch && board[9] == ch) || (board[3] == ch && board[7] == ch)
				|| (board[2] == ch && board[8] == ch) || (board[4] == ch && board[6] == ch)))
			return 5;

		if (isAvailable(6) && ((board[3] == ch && board[9] == ch) || (board[5] == ch && board[4] == ch)))
			return 6;

		if (isAvailable(7) && ((board[1] == ch && board[4] == ch) || (board[9] == ch && board[8] == ch)
				|| (board[5] == ch && board[3] == ch)))
			return 7;

		if (isAvailable(8) && ((board[2] == ch && board[5] == ch) || (board[7] == ch && board[9] == ch)))
			return 8;

		if (isAvailable(9) && ((board[7] == ch && board[8] == ch) || (board[3] == ch && board[6] == ch)
				|| (board[5] == ch && board[1] == ch)))
			return 9;

		else
			return 0;

	}
	public int blockPlayer() {
		int position = ifPossibleToWin();
		 if (position == 0) {
			int flag = 0;
			while (flag == 0) {
				position = ((int) Math.floor(Math.random() * 10) % 9) + 1;
				if (isAvailable(position))
					flag = 1;
				}
			}
		return position;
	}
	
	
	
}
