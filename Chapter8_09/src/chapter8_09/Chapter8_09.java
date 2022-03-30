/*
Chapter 8 Programming excercise 09
Riky Hernandez
9/22/21
Description: Game of TicTacToe, where two players take turns until theres a winner or tie
`;-.          ___,
  `.`\_...._/`.-"`
    \        /      ,
    /()   () \    .' `-._
   |)  .    ()\  /   _.'
   \  -'-     ,; '. <
    ;.__     ,;|   > \
   / ,    / ,  |.-'.-'
  (_/    (_/ ,;|.<`
    \    ,     ;-`
     >   \    /
    (_,-'`> .'
          (_,'
 */
package chapter8_09;

import java.util.Scanner;

public class Chapter8_09 {

public static void drawboard(char[][] board) {
    
    for (int i = 0; i < board.length; i++) {
   for (int j = 0; j < board[1].length; j++) {
    System.out.print("|" + board[j][i]);
   }
 
   System.out.println("|");
  }
 }
public static char Won(char [][] board){
    
    for(int i = 0 ; i <3 ; i++){      
        if(board[i][0] == board[i][1] && board[i][1] == board [i][2] && board[i][0] != ' '){    //checks the rows
            return board [i][0];
        }
        
    }
    for (int j = 0; j < 3 ; j++){
        if(board[0][j] == board[1][j] && board[1][j] == board [2][j] && board [0][j] != ' '){  //checks the col
        return board [0][j];
    }
    }
    if(board [0][0] == board [1][1] && board[1][1] == board[2][2] && board[0][0] != ' '){   //checks the diagnol lines
        return board [0][0];
    }
    if (board [2][0] == board [1][1] && board [1][1] == board[0][2] && board [2][0] != ' '){
        return board[2][0];
    }
    return '-';
}


public static boolean Tie(char[][] board){
    
    for(int i = 0; i < 3; i++ ){
        for (int j = 0 ; j< 3 ; j++){
            if(board[i][j] == ' ') {
            return false;
        }
        }
    }
    return true;
}
    
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
  
     System.out.print("Player1,whats your name?: ");
    String Player1 = input.nextLine();
     System.out.print("Player2,whats your name?: ");
    String Player2 = input.nextLine();
  
     
     
     
     
     char [][] board = new char [3][3];
     
     for(int i =0; i <3;i++){
         for (int j = 0; j < 3; j++){
             board[i][j] =' ';
         }
     }
     
   
     
     
     boolean isPlayer1 = true;
     
     boolean gameover = false;
     
     
     while(!gameover){
     
         drawboard(board);
     char symbol = ' ';
     if(isPlayer1){
         symbol = 'x';
     }
     else{
         symbol = 'o';
     }
     
     if(isPlayer1){
         System.out.println(Player1 + "s turn");
     }
     else{
         System.out.println(Player2 + "s turn");
     }
     
     int row = 0;
     int col = 0;
     
     while(true){
     
                System.out.print("Enter a row(0,1, or 2); ");
                row = input.nextInt();
                System.out.print("Enter a col(0,1, or 2); ");
               col = input.nextInt();


                if(row < 0 || col < 0 || row > 2 || col > 2){
                   System.out.println("number was not detected!,Try again");
                }
                else if(board[row][col] != ' '){
                    System.out.println("Spot taken!,Try again");
                }
                else{
                    break;
                }
     }
     
     
     board[row][col] = symbol;
     
     if(Won(board) == 'x') {
         System.out.println(Player1 + " has won!");
         gameover = true;
     }
     else if(Won(board) == 'o') {
        System.out.println(Player2 + " has won!"); 
         gameover = true;
     }
     else{
        if(Tie(board)){
            System.out.println("Its a tie!");
             gameover = true;
        }
        else{
            isPlayer1 = !isPlayer1;
        }
     }    
     
    }
     drawboard(board);
    }
}
