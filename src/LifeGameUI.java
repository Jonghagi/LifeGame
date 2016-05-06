import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;
import java.util.Timer;
public class LifeGameUI extends JFrame {
    JPanel[][] CellUI = new JPanel[60][60];
    JButton StartButton = new JButton("Start");
    LifeGameEngine Engine;
    int N = 60;
    boolean isGaming;
    Cell[][] cells;
    public void start(){
        cells = new Cell[N][N];
        Engine = new  LifeGameEngine();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                cells[i][j] = new Cell();
            }
        }


        isGaming = false;
        for(int i = 0; i < 60; i++)
            for (int j = 0; j < 60; j++) {
                CellUI[i][j] = new JPanel();
                CellUI[i][j].setBounds(i * 10, (j * 10) + 80, 10, 10);
                if(cells[i][j].currentStatus()){
                    CellUI[i][j].setBackground(Color.black);
                } else {
                    CellUI[i][j].setBackground(Color.white);
                }
                add(CellUI[i][j]);
            }

        StartButton.setBounds(100, 10, 100, 50);
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameStart();
            }
        });
        add(StartButton);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = (e.getX());
                int y = (e.getY());

                if(x >= 0 && y >= 80) {
                    System.out.println(x + " " + y);
                    x = x / 10;
                    y = ((y - 80 - 20) / 10);
                    System.out.println(x + " " + y);
                    if (cells[x][y].currentStatus()) {
                        cells[x][y].Die();
                        CellUI[x][y].setBackground(Color.white);
                    } else {
                        cells[x][y].Live();
                        CellUI[x][y].setBackground(Color.black);
                    }
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

    public void Live(int x, int y){ CellUI[x][y].setBackground(Color.black);
    }

    public void GameStart(){
        System.out.println("Start");
        Timer timer = new Timer();
        timer.schedule(new EngineRun(), 100, 100);
    }

    public class EngineRun extends TimerTask {
        @Override
        public void run() {
            Engine.checkCells(cells, N);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(cells[i][j].currentStatus()){
                        Live(i, j);
                    } else {
                        Die(i, j);
                    }
                }
            }
        }
    }


}