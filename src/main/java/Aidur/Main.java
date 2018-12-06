package Aidur;

import Matrix.Matrix;
import Matrix.MatrixArray;
import Matrix.MatrixNxN;
import Matrix.Field;

public class Main {
    public static Matrix mtrIncrement(Matrix mtr){
        int size = mtr.getSize() * mtr.getSize();
        int prevEl = mtr.getElem(size - 2);
        mtr.increment(size - 1);

        for(int i = size - 1; i > 0; i--){
            if(prevEl == 1) {
                mtr.increment(i - 1);
                prevEl = mtr.getElem(i - 1);
            } else
                break;
        }

        return mtr;
    }

    public static MatrixArray getAllMatrixNonNullDet(int size){
        MatrixArray mtrArr = new MatrixArray();
        Matrix prevMtr = new MatrixNxN(size);

        for(int i = 0; i < Math.pow(2, size * size); i++){
            Matrix newMtr = mtrIncrement(prevMtr);
            prevMtr = newMtr;
            if(Field.getNum(newMtr.getDeterminant(), newMtr.getField()) != 0) {
                mtrArr.add(newMtr);
            }
        }
        return mtrArr;
    }



    public static void main(String[] args){
        int size = 4;
        MatrixArray mtrArray = getAllMatrixNonNullDet(size);

        System.out.println(size + ": " +mtrArray.getSize());
    }
}
