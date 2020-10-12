package com.cp.tictactoe;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome");
		int play = 1;
		while(play==1) {
			System.out.println("Enter 1 to play and any other key to exit");
			play = sc.nextInt();
			if(play==1) {
				TicTacToe ticObj = new TicTacToe();
				ticObj.playerTossChoice();
				ticObj.chooseOption();
				ticObj.showBoard();
				ticObj.makeMove();
			}
			System.out.println("thanks for being here ");
		}
	}

}
