package Matrix;

import java.util.LinkedList;
import java.util.List;

public class MatrixArray {
    private List<Matrix> list;

    public MatrixArray(){
        this.list = new LinkedList<Matrix>();
    }

    public void add(Matrix mtr){
        list.add(mtr);
    }

    public Matrix getLast(){
        return list.get(list.size() - 1);
    }

    public Matrix get(int i){
        return list.get(i);
    }

    public int getSize(){
        return list.size();
    }

    public void del(Matrix mtr){
        list.remove(mtr);
    }
}
