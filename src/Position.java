public class Position {
    private int x;
    private int y;

    public Position(int x, int y) throws InvalidPositionException{
        if(x < 1 || x > 9 || y < 1 || y > 9){
            throw new InvalidPositionException("(" + x + ", " + y + ") is not a valid position, x and y must be between 1 and 9.");
        }else {
            this.x = x;
            this.y = y;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
