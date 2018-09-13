public class Game {

    public static void main(String[] args){

        try {
            Position p = new Position(1, -1);
            System.out.println(p);
        } catch (InvalidPositionException e){
            System.out.println(e.getMessage());
        }

    }

}
