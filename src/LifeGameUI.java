import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LifeGameUI extends JFrame {
    JPanel[][] CellUI = new JPanel[60][60];

    public void start(Cell[][] cells){
        for(int i = 0; i < 60; i++)
            for (int j = 0; j < 60; j++) {
                CellUI[i][j] = new JPanel();
                CellUI[i][j].setBounds(i * 10, j * 10, 10, 10);
                if(cells[i][j].currentStatus()){
                    CellUI[i][j].setBackground(Color.black);
                } else {
                    CellUI[i][j].setBackground(Color.white);
                }
                add(CellUI[i][j]);
            }
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = (e.getX());
                int y = (e.getY());

                System.out.println(x + " " + y);
                x = x / 10;
                y = (y - 20) / 10;
                System.out.println(x + " " + y);
                if(cells[x][y].currentStatus()){
                    cells[x][y].Die();
                    CellUI[x][y].setBackground(Color.white);
                } else {
                    cells[x][y].Live();
                    CellUI[x][y].setBackground(Color.black);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public void Die(int x, int y){
        CellUI[x][y].setBackground(Color.white);
    }

    public void Live(int x, int y){
        CellUI[x][y].setBackground(Color.black);
    }

}