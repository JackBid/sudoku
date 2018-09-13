public class Game {

    public static void main(String[] args){

        try {
            Position p = new Position(1, 1);
            Move m = new Move(9, p);
            System.out.println(m);
        } catch (InvalidPositionException e){
            System.out.println(e.getMessage());
        }

    }

}
