/**
 * Created by Kimjonghak on 2016. 5. 2..
 */
public class Cell {
    private boolean status;

    Cell(){
        status = false;
    }
    public void Die(){
        status = false;
    }

    public void Live(){
        status = true;
    }

    public boolean currentStatus(){
        return status;
    }
}
