public class Game {

    private boolean running = true;
    private Board board = new Board();
    private Player player = new Player();

    public static void main(String[] args){

        Game game = new Game();
        game.update();

    }

    private void update(){
        while(running) {

            System.out.println("");
            board.print();

            board.solve();

            System.out.println("");
            board.print();
            running = false;
/*
            try {
                Player p = new Player();
                Move m = p.getMove();
                board.makeMove(m);
                if(board.isComplete()){
                    complete();
                }
            } catch (Exception e) {
                e.getMessage();
            }*/

        }
    }

    public void complete(){
        running = false;
        System.out.println("");
        board.print();
        System.out.println("Sudoku Complete.");
    }

}
