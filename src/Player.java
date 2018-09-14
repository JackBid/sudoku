import java.util.Scanner;

public class Player {

    public Move getMove(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x: ");
        int x = Integer.parseInt(sc.next());
        System.out.print("Enter y: ");
        int y = Integer.parseInt(sc.next());
        System.out.print("Enter number: ");
        int number = Integer.parseInt(sc.next());

        try{
            return new Move(number, new Position(x,y));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
