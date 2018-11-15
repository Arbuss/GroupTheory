package Matrix;

public interface Matrix {
    public void setElem(int i, int j, int elem);
    public int getElem(int i, int j);

    public void setElem(int i, int elem);
    public int getElem(int i);

    public int getDeterminant();
    public int getSize();
    public int getField();
    public void increment(int i);
}
