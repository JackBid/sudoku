public class Move {

    private int number;
    private Position position;

    public Move(int data, Position position) throws InvalidNumberException{
        if(data < 1 || data > 9){
            throw new InvalidNumberException("Invalid number " + data + " is not between 1-9");
        } else {
            this.number = data;
            this.position = position;
        }
    }

    public int getNumber(){
        return number;
    }

    public Position getPosition(){
        return position;
    }

    public String toString(){
        return "Data: " + number + "\nPosition: " + position;
    }

}
