public class Move {

    private int data;
    private Position position;

    public Move(int data, Position position) throws InvalidPositionException{
        if(data < 1 || data > 9){
            throw new InvalidPositionException("Invalid number " + data + " is not between 1-9");
        } else {
            this.data = data;
            this.position = position;
        }
    }

    public String toString(){
        return "Data: " + data + "\nPosition: " + position;
    }

}
