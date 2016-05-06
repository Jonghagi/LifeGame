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
    JPanel[][] CellUI;
    JButton StartButton = new JButton("Start");
    JButton SettingButton = new JButton("Setting");
    JButton StopButton = new JButton("Stop");
    JTextField inputN = new JTextField();
    LifeGameEngine Engine;
    Timer timer;
    boolean isGaming;
    int N;
    Cell[][] cells;
    public void start(){
        isGaming = false;
        inputN.setBounds(10, 10, 50, 30);
        SettingButton.setBounds(60, 10, 100, 30);
        add(inputN);
        add(SettingButton);
        Engine = new  LifeGameEngine();
        add(StartButton);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 100);
        StartButton.setBounds(170, 10, 100, 30);
        StopButton.setBounds(270, 10, 100, 30);
        add(StopButton);

        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isGaming) {
                    isGaming = true;
                    GameStart();
                }
            }
        });

        StopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isGaming){
                    timer.cancel();
                    isGaming = false;
                }
            }
        });
        SettingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                N = Integer.parseInt(inputN.getText());
                SettingMap();
            }
        });

    }

    private void SettingMap(){
        cells = new Cell[N][N];
        CellUI = new JPanel[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                cells[i][j] = new Cell();
            }
        }


        for(int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                CellUI[i][j] = new JPanel();
                CellUI[i][j].setBounds(i * 10, (j * 10) + 80, 10, 10);
                if(cells[i][j].currentStatus()){
                    CellUI[i][j].setBackground(Color.black);
                } else {
                    CellUI[i][j].setBackground(Color.white);
                }
                add(CellUI[i][j]);
            }

        setSize(N * 10, N * 10 + 80);

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
    private void Die(int x, int y){CellUI[x][y].setBackground(Color.white);}

    private void Live(int x, int y){CellUI[x][y].setBackground(Color.black);}

    private void GameStart(){
        System.out.println("Start");
        timer = new Timer();
        timer.schedule(new EngineRun(), 100, 100);
    }

    private class EngineRun extends TimerTask {
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