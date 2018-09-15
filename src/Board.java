import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Board {
    /*


    private char[][] board = {{'1','3','2','5','6','7','9','4','8'},
                              {'5','4','6','3','8','9','2','1','7'},
                              {'9','7','8','2','4','1','6','3','5'},
                              {'2','6','4','9','1','8','7','5','3'},
                              {'7','1','5','6','3','2','8','9','4'},
                              {'3','8','9','4','7','5','1','2','6'},
                              {'8','5','7','1','2','3','4','6','9'},
                              {'6','9','1','7','5','4','3','8','2'},
                              {'4','2','3','8','9','6',' ',' ','1'},};


    */
    private char[][] board = {{'6','1',' ',' ',' ',' ',' ',' ',' '},
            {' ','4','8',' ','5','3','1',' ','2'},
            {' ',' ','3',' ','8',' ',' ','4','5'},
            {'4',' ',' ',' ','9',' ','5',' ','6'},
            {' ','5','7',' ','3',' ','2',' ',' '},
            {'3',' ',' ','5',' ','8',' ','1',' '},
            {' ','3','9',' ',' ',' ','6','2','1'},
            {'7','2',' ',' ','6','5','3',' ',' '},
            {'8',' ','4','3',' ','2',' ','5','9'},};

    public void makeMove(Move move){
        if(isValid(move)){
            board[move.getPosition().getY()-1][move.getPosition().getX()-1] = String.valueOf(move.getNumber()).charAt(0);
        }
    }

    public boolean solve(){

        Position emptyCell = findFirstEmptyCell();
        if(emptyCell == null){
            return true;
        }

        //try numbers 1-9
        for(int i=1; i<10; i++){
            try {
                Move m = new Move(i, emptyCell);
                if(isValid(m)){
                    board[m.getPosition().getY()-1][m.getPosition().getX()-1] = String.valueOf(m.getNumber()).charAt(0);
                    if(solve()){
                        return true;
                    }
                    board[m.getPosition().getY()-1][m.getPosition().getX()-1] = ' ';
                }
            }catch(InvalidNumberException e){
                e.printStackTrace();
            }

        }

        return false;
    }

    private Position findFirstEmptyCell(){
        Position emptyCell;

        //Find first empty cell
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == ' '){
                    try {
                        emptyCell = new Position(j + 1, i + 1);
                        return emptyCell;
                    }catch(InvalidPositionException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public boolean isComplete(){

        // check for spaces
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }

        return true;
    }

    // Takes a move and returns boolean whether allowed or not
    private boolean isValid(Move move){

        // check if already filled in
        if(board[move.getPosition().getY() - 1][move.getPosition().getX() - 1] != ' '){
            return false;
        }

        // check square
        // Find top left cell of the square number is in
        int x = 3*((int)Math.ceil((double)move.getPosition().getX()/3)) - 2;
        int y = 3*((int)Math.ceil((double)move.getPosition().getY()/3)) - 2;
        try {
            if(!checkSquare(move.getNumber(), new Position(x, y))){
                return false;
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        // check row
        for(int i=0; i<9; i++){
            // if number in row
            if(String.valueOf(move.getNumber()).charAt(0) == board[move.getPosition().getY() - 1][i]){
                return false;
            }
        }

        // check column
        for(int i=0; i<9; i++){
            // if number in column
            if(String.valueOf(move.getNumber()).charAt(0) == board[i][move.getPosition().getX() - 1]){
                return false;
            }
        }

        return true;
    }

    // checks a 3x3 square for a given number. 3x3 square based on topleft position
    private boolean checkSquare(int number, Position topLeft){
        int x = topLeft.getX()-1;
        int y = topLeft.getY()-1;

       char[] squares = {board[y][x],board[y][x+1],board[y][x+2],
                         board[y+1][x],board[y+1][x+1],board[y+1][x+2],
                         board[y+2][x],board[y+2][x+1],board[y+2][x+2],};

        for(char c:squares){
            if(!String.valueOf(c).equals(" ")){
             if(Integer.parseInt(String.valueOf(c)) == number){
                return false;
             }
            }
        }
        return true;
    }

    public void load(){


        File file = new File("C://Users//Jack biddlecombe//Documents//Code//sudoku//src//board.txt");
        int i =0;
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                StringBuilder line = new StringBuilder(sc.nextLine());
                while(line.length() < 9){
                    line.append(" ");
                }
                board[i] = line.toString().toCharArray();
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void print(){
        System.out.println(  "    1  2  3   4  5  6   7  8  9");
        System.out.println(  "  +-----------------------------+");
        for(int i=0; i<9; i++){
            StringBuilder row = new StringBuilder(i + 1 + " | ");
            for(int j=0; j<9; j++){
                if(j == 2 || j == 5 || j == 8){
                    row.append(board[i][j]).append(" | ");
                }else {
                    row.append(board[i][j]).append("  ");
                }
            }
            System.out.println(row);
            if(i == 2 || i == 5){
                System.out.println("  |---------+---------+---------|");
            }
        }
        System.out.println(  "  +-----------------------------+");
    }

}
