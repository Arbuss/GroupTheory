package Matrix;

public class Matrix2x2 implements Matrix{
    private int field;
    private int[] data;
    private int determinant;
    private boolean hasDeterminant;

    public Matrix2x2(int fieldNum){
        this.field = fieldNum;
        this.data = new int[4];
        this.hasDeterminant = false;
    }

    public void setElem(int i, int j, int elem){
        data[2 * i + j] = Field.getNum(elem, field);
    }

    public int getElem(int i, int j){
        return data[2 * i + j];
    }

    public int getElem(int i){
        return data[i];
    }

    public void setElem(int i, int elem){
        data[i] = elem;
    }

    public int getDeterminant(){
        this.hasDeterminant = true;
        return data[0] * data[3] - data[1] * data[2];
    }

    public int getSize(){
        return 4;
    }

    public int getField(){
        return field;
    }

    public String toString(){
        return data[0] + " " + data[1] + " " + data[2] + " " + data[3];
    }

    public void increment(int i){
        data[i]++;
    }
}
