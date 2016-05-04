/**
 * Created by Kimjonghak on 2016. 5. 2..
 */
public class LifeGame {
    static LifeGameUI UI = new LifeGameUI();

    public static void main(String args[]){
        Cell[][] cell;
        int N = 60;
        boolean isGaming;
        cell = new Cell[N][N];
        isGaming = true;


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                cell[i][j] = new Cell();
            }
        }

        
        UI.start(cell);

        while(isGaming){
            checkCells(cell, N);
        }
    }

    public static boolean checkLeftTop(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon - 1][yPosition - 1].currentStatus(); }
    public static boolean checkTop(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon - 1][yPosition].currentStatus(); }
    public static boolean checkRightTop(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon - 1][yPosition + 1].currentStatus(); }

    public static boolean checkLeft(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon][yPosition - 1].currentStatus(); }
    public static boolean checkRight(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon][yPosition + 1].currentStatus(); }

    public static boolean checkLeftBottom(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon + 1][yPosition - 1].currentStatus(); }
    public static boolean checkBottom(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon + 1][yPosition].currentStatus(); }
    public static boolean checkRightBottom(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon + 1][yPosition + 1].currentStatus(); }

    public static void checkCells(Cell[][] cell, int N){
        int NumberOfLives;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                NumberOfLives = 0;
                if(i == 0 && j == 0) {
                    if (checkRight(cell, i, j)) {
                        NumberOfLives++;
                    }
                    if (checkRightBottom(cell, i, j)) {
                        NumberOfLives++;
                    }

                    if (checkBottom(cell, i, j)) {
                        NumberOfLives++;
                    }
                } else if(i == 0 && j == N-1) {
                    if (checkLeft(cell, i, j)) {
                        NumberOfLives++;
                    }
                    if (checkLeftBottom(cell, i, j)) {
                        NumberOfLives++;
                    }

                    if (checkBottom(cell, i, j)) {
                        NumberOfLives++;
                    }
                } else if(j == 0 && i == N-1){
                    if (checkRight(cell, i, j)) {
                        NumberOfLives++;
                    }
                    if (checkRightTop(cell, i, j)) {
                        NumberOfLives++;
                    }

                    if (checkTop(cell, i, j)) {
                        NumberOfLives++;
                    }
                } else if(i == 0 && j < N-1){
                    if(checkLeft(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRight(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkLeftBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRightBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                } else if(j == 0 && i < N - 1){
                    if(checkTop(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRightTop(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRight(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRightBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                } else if(i == N-1 && j == N-1){
                    if(checkLeft(cell, i, j)){
                        NumberOfLives++;
                    }

                    if(checkLeftTop(cell, i, j)){
                        NumberOfLives++;
                    }

                    if(checkTop(cell, i, j)){
                        NumberOfLives++;
                    }
                } else if(i == N-1 && j > 0){
                    if(checkLeft(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRight(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkLeftTop(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkTop(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRightTop(cell, i, j)){
                        NumberOfLives++;
                    }

                } else if(j == N-1 && i > 0){
                    if(checkTop(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkLeftTop(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkLeft(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkLeftBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                } else {
                    if(checkLeftTop(cell, i, j)){
                        NumberOfLives++;
                    }

                    if(checkTop(cell, i, j)){
                        NumberOfLives++;
                    }

                    if(checkRightTop(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRight(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkRightBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkLeftBottom(cell, i, j)){
                        NumberOfLives++;
                    }
                    if(checkLeft(cell, i, j)){
                        NumberOfLives++;
                    }
                }

                if(NumberOfLives == 3){
                    cell[i][j].Live();
                    UI.Live(i, j);
                } else if(NumberOfLives == 2){

                } else {
                    cell[i][j].Die();
                    UI.Die(i, j);
                }
            }
        }
    }
}
