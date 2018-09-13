public class Game {

    public static void main(String[] args){

        Board b = new Board();
        b.print();
        try {
            Move m = new Move(3, new Position(6, 1));
            System.out.println(b.isValid(m));
        }catch(Exception e) {
            e.getMessage();
        }
    }

}
