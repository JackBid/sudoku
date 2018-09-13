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

    public boolean isValid(Move move){
        return board[move.getPosition().getY() - 1][move.getPosition().getX() - 1] == ' ';
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
