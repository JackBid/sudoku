import javafx.geometry.Pos;

public class Board {

    private char[][] board = {{'7','8',' ','9',' ','3',' ','5','6'},
                              {'1',' ',' ',' ',' ',' ',' ',' ','3'},
                              {' ',' ',' ','4',' ','2',' ',' ',' '},
                              {' ','7',' ',' ',' ',' ',' ','6',' '},
                              {'5','6',' ','2','9','8',' ','3','7'},
                              {' ','1',' ',' ',' ',' ',' ','9',' '},
                              {' ',' ',' ','6',' ','7',' ',' ',' '},
                              {'9',' ',' ',' ',' ',' ',' ',' ','1'},
                              {'8','3',' ','1',' ','9',' ','7','5'},};


    public void makeMove(Move move){
        if(isValid(move)){
            board[move.getPosition().getY()-1][move.getPosition().getX()-1] = String.valueOf(move.getNumber()).charAt(0);
        }
    }

    // Takes a move and returns boolean whether allowed or not
    public boolean isValid(Move move){

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
            if(c == number){
                return false;
            }
        }
        return true;
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
