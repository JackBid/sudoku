import javax.swing.*;
import javax.swing.text.JTextComponent;

public class Window extends Thread {

    private Game game;
    private JFrame myFrame;

    public Window(Game game){
        this.game = game;
    }

    public void run(){
        myFrame = new JFrame();

        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        myFrame.setSize(500,500);
        myFrame.setVisible(true);
        display(game.getBoard().getGrid());
    }

    private void display(char[][] grid){
        StringBuilder data = new StringBuilder();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                data.append(grid[i][j]);
            }
            data.append("|");
        }
        JLabel l = new JLabel(data.toString());
        myFrame.add(l);
    }
}
