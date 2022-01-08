
import java.util.Random;
import java.util.Scanner;

public class TicTac {

	public static void main(String[] args) {
		
		
		
		// Displaying the welcome message.
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println("Lets begin: select a box in the grid from 1-9: ");
		System.out.println();

		// Creating a scanner. 
		Scanner scan = new Scanner(System.in);

		// 2D array of characters to make our Tic Tac Toe grid.
		// This will allow us to have a grid of 9 boxes. 
		char[][] gameBoard = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		
		int counter =0;
		boolean finish = true;
		// Creating a while loop with the following conditions/ 
		while(finish) {
			board(gameBoard);
			
			int userXinput = scan.nextInt();
			while (isItAvaiable(gameBoard,userXinput)== false) { //This while loop contains a method to check if the spot is taken or not.
				System.out.println("Try again!");
				userXinput = scan.nextInt();
			}
			playerX(gameBoard, userXinput, "player"); //This method allows user to select a number and have the correct player displayed.

			
			// This random class will return a number between 0-9
			Random random = new Random();
			int bot = random.nextInt(9)+1;	//We create a bot to play the Tic Tac Toe game with. 
			
			while (isItAvaiable(gameBoard,bot)== false) { //Similarly it contains a method to check if the spot is taken or not.
				bot = random.nextInt(9)+1;
			}
			
			playerX(gameBoard, bot, "bot"); 
			
			counter++; // This counter counts the user's input 
			
			if (win(gameBoard,'x')) {	
				System.out.println("YOU WIN!"); //Checks if user wins.
				board(gameBoard);
				finish=false;
			} else if (win(gameBoard,'o')) {
				System.out.println("You lose, bot wins!"); //Checks if bot wins.
				board(gameBoard);
				finish=false;
			} else if (counter == 4) {
				System.out.println("GAME OVER!"); //After the user plays until 4 without winning or losing the grid will eventually get full, therefore we want to stop it. 
				board(gameBoard);
				finish=false;
			}			

			
		}
		scan.close();
	
	}
	

	// Creating a method to print out the grid for the board game.
	// Using static void since we are not returning anything and
	// the method is related to the class and not any objects.
	public static void board(char[][] gameBoard) {

		System.out.println("|---|---|---|");
		System.out.println("| " + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2] + " |");
		System.out.println("|---|---|---|");

		System.out.println("| " + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2] + " |");
		System.out.println("|---|---|---|");

		System.out.println("| " + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2] + " |");
		System.out.println("|---|---|---|");
	}

	//This method allows user/bot to select a number on the grid and will display the correct character. 
	public static void playerX(char[][] gameBoard, int userXinput, String player) {
		
		char sign = ' ';
		if (player.equals("player")) {
			 sign = 'x';
		}else if (player.equals("bot")){
			 sign = 'o';
		}
	
		switch (userXinput) {

		case 1: {
			gameBoard[0][0] = sign;
			break;
		}

		case 2: {
			gameBoard[0][1] = sign;
			break;
		}

		case 3: {
			gameBoard[0][2] = sign;
			break;
		}

		case 4: {
			gameBoard[1][0] = sign;
			break;
		}

		case 5: {
			gameBoard[1][1] = sign;
			break;
		}

		case 6: {
			gameBoard[1][2] = sign;
			break;
		}

		case 7: {
			gameBoard[2][0] = sign;
			break;
		}

		case 8: {
			gameBoard[2][1] = sign;
			break;
		}

		case 9: {
			gameBoard[2][2] = sign;
			break;
		}

		default: {
			System.out.println("That's not right!");
			break;
		}

		}

	}

	// This method checks if the boxes are taken from either players.
	public static boolean isItAvaiable(char[][] gameBoard, int userXinput) {
	
		switch (userXinput) {

		case 1: 
			if (gameBoard[0][0] == 'x' || gameBoard[0][0] == 'o') {


				return false;
			}else {
				return true;
			}

		case 2: 
			if (gameBoard[0][1] == 'x' || gameBoard[0][1] == 'o') {

				return false;
			}else {
				return true;
			}
				
			

		case 3: 
			if (gameBoard[0][2]  == 'x' || gameBoard[0][2] == 'o'){

				return false;
			}else {
				return true;
			}
				
			
		case 4: 
			if (gameBoard[1][0]  == 'x' || gameBoard[1][0] == 'o') {

				return false;
			}else {
				return true;
			}
				

		case 5: 
			if (gameBoard[1][1]  == 'x' || gameBoard[1][1] == 'o') {

				return false;
			}else {
				return true;
			}
				
		case 6: 
			if (gameBoard[1][2]  == 'x' || gameBoard[1][2] == 'o') {

				return false;
			}else {
				return true;
			}
				
		case 7: 
			if (gameBoard[2][0]  == 'x' || gameBoard[2][0] == 'o'){

				return false;
			}else {
				return true;
			}
				

		case 8: 
			if (gameBoard[2][1]  == 'x'|| gameBoard[2][1] == 'o') {

				return false;
			}else {
				return true;
			}
				
		case 9: 
			if (gameBoard[2][2]  == 'x' || gameBoard[2][2] == 'o') {

				return false;
			}else {
				return true;
			}
				

		default: 

			return false;
		
		}
		
	}
	
	//This method contains all the winning conditions for either player.
	public static boolean win(char[][] gameBoard, char sign) {
		
		if(gameBoard[0][0] == sign && gameBoard[0][1]== sign && gameBoard[0][2] ==sign
				||(gameBoard[1][0]==sign && gameBoard[1][1]==sign && gameBoard[1][2]==sign)
				||(gameBoard[2][0]==sign && gameBoard[2][1]==sign && gameBoard[2][2]==sign)
				||(gameBoard[0][0]==sign && gameBoard[1][0]==sign && gameBoard[2][0]==sign)
				||(gameBoard[0][1]==sign && gameBoard[1][1]==sign && gameBoard[2][1]==sign)
				||(gameBoard[0][2]==sign && gameBoard[1][2]==sign && gameBoard[2][2]==sign)
				||(gameBoard[0][0]==sign && gameBoard[1][1]==sign && gameBoard[2][2]==sign)
				||(gameBoard[2][0]==sign && gameBoard[1][1]==sign && gameBoard[0][2]==sign)
				)
		{
			return true;
			
		}else {
			
			return false;
		}

		
		
	}


}
