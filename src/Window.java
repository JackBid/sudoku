import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class Window extends Thread {

    private Game game;
    private JFrame myFrame;
    private JPanel panel = new JPanel();

    public Window(){
    }

    public void run(){
        myFrame = new JFrame();

        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        myFrame.setPreferredSize(new Dimension(500,500));
        myFrame.setResizable(false);
        myFrame.pack();
        myFrame.setVisible(true);
        panel.setSize(500,500);
        GridLayout layout = new GridLayout(9,9, 0, 0);

        panel.setLayout(layout);

    }

    public void display(char[][] grid){


        panel.removeAll();
        for(int i=0; i<81; i++){
            JLabel j = new JLabel(String.valueOf(grid[(int)Math.floor(i/9)][i-9*(int)Math.floor(i/9)]), SwingConstants.CENTER);
            j.setBorder(BorderFactory.createLineBorder(Color.black));
            panel.add(j);

        }
        myFrame.add(panel);
        myFrame.pack();
    }
}
