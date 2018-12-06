package Matrix;

public class MatrixNxN implements Matrix{
    private int field;
    private int[] data;
    private int size;
    private int determinant;
    private boolean hasDeterminant;

    public MatrixNxN(int size){
        this.field = 2;
        this.size = size;
        this.data = new int[size*size];
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
        if (hasDeterminant)
            return determinant;
        determinant = calculateDeterminant();
        hasDeterminant = true;
        return determinant;
    }

    public int getSize(){
        return size;
    }

    public int getField() {
        return field;
    }

    public void increment(int i){
        if(data[i] == 1)
            data[i] = 0;
        else
            data[i] = 1;
    }

    public int calculateDeterminant() throws ArrayIndexOutOfBoundsException {
        if (size == 2) {
            hasDeterminant = true;
            determinant = data[0] * data[3] - data[1] * data[2];
            return determinant;
        }
        int det = 0;
        int sign = 1;
        for (int col = 0; col < size; col++) {
            det += sign * getElem(0, col) * getAddMinor(0, col).getDeterminant();
            sign *= -1;
        }
        hasDeterminant = true;
        determinant = det;
        return determinant;
    }

    public Matrix getAddMinor(int row, int column) throws ArrayIndexOutOfBoundsException {
        Matrix result = new MatrixNxN(size - 1);
        for (int i = 0; i < size; i++) {
            if (i == row)
                continue;
            for (int j = 0; j < size; j++) {
                if (j == column)
                    continue;
                result.setElem(i >= row ? i - 1 : i, j >= column ? j - 1 : j, getElem(i, j));
            }
        }
        return result;
    }
}
