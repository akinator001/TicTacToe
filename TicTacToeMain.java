package com.cp.tictactoe;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		System.out.println("Welcome");
		 
		TicTacToe ticObj = new TicTacToe();
		ticObj.playerTossChoice();
		ticObj.chooseOption();
		ticObj.showBoard();
		ticObj.makeMove();
		ticObj.showBoard();
		
	}

}
