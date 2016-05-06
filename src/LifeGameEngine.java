/**
 * Created by Kimjonghak on 2016. 5. 6..
 */
public class LifeGameEngine {


    public boolean checkLeftTop(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon - 1][yPosition - 1].currentStatus(); }
    public boolean checkTop(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon - 1][yPosition].currentStatus(); }
    public boolean checkRightTop(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon - 1][yPosition + 1].currentStatus(); }

    public boolean checkLeft(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon][yPosition - 1].currentStatus(); }
    public boolean checkRight(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon][yPosition + 1].currentStatus(); }

    public boolean checkLeftBottom(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon + 1][yPosition - 1].currentStatus(); }
    public boolean checkBottom(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon + 1][yPosition].currentStatus(); }
    public boolean checkRightBottom(Cell[][] cell, int xPositon, int yPosition) { return cell[xPositon + 1][yPosition + 1].currentStatus(); }

    public void checkCells(Cell[][] cell, int N){
        int[][] NumberOfLives = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                NumberOfLives[i][j] = 0;
                if(i == 0 && j == 0) {
                    if (checkRight(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }
                    if (checkRightBottom(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }

                    if (checkBottom(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }
                } else if(i == 0 && j == N-1) {
                    if (checkLeft(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }
                    if (checkLeftBottom(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }

                    if (checkBottom(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }
                } else if(j == 0 && i == N-1){
                    if (checkRight(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }
                    if (checkRightTop(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }

                    if (checkTop(cell, i, j)) {
                        NumberOfLives[i][j]++;
                    }
                } else if(i == 0 && j < N-1){
                    if(checkLeft(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRight(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkLeftBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRightBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                } else if(j == 0 && i < N - 1){
                    if(checkTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRightTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRight(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRightBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                } else if(i == N-1 && j == N-1){
                    if(checkLeft(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }

                    if(checkLeftTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }

                    if(checkTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                } else if(i == N-1 && j > 0){
                    if(checkLeft(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRight(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkLeftTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRightTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }

                } else if(j == N-1 && i > 0){
                    if(checkTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkLeftTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkLeft(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkLeftBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                } else {
                    if(checkLeftTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }

                    if(checkTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }

                    if(checkRightTop(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRight(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkRightBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkLeftBottom(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                    if(checkLeft(cell, i, j)){
                        NumberOfLives[i][j]++;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(NumberOfLives[i][j] == 3){
                    cell[i][j].Live();
                } else if(NumberOfLives[i][j] == 2){

                } else {
                    cell[i][j].Die();
                }
            }
        }
    }
}
