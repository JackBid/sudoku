import java.util.Scanner;

public class Game {

    private boolean running = true;
    private Board board = new Board();
    private Player player = new Player();
    private Window window = new Window();

    public static void main(String[] args){

        Game game = new Game();

    }

    private Game(){
        this.getBoard().load();
        window.start();
        this.startMenu();
    }

    private void startMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Play");
        System.out.println("2. Watch computer solve");

        boolean good = false;
        while(!good){
            String input = sc.next();
            if ("1".equals(input)) {
                good = true;
                play();
            } else if (input.equals("2")) {
                good = true;
                computer();
            } else {
                System.out.println("Invalid input.");
            }
        }


    }

    private void play(){
        System.out.println("");
        window.display(board.getGrid());
        //board.load();

        while(running) {
            board.print();
            window.display(board.getGrid());
            try {
                Player p = new Player();
                Move m = p.getMove();
                board.makeMove(m);
                if(board.isComplete()){
                    complete();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    private void computer(){
        System.out.println("");
        //board.load();
        try{
            board.generate();
        }catch(Exception e){
            e.printStackTrace();
        }
        board.print();

        board.solve();

        System.out.println("");
        board.print();
    }


    private void complete(){
        running = false;
        System.out.println("");
        board.print();
        System.out.println("Sudoku Complete.");
    }

    private Board getBoard(){
        return board;
    }
}
