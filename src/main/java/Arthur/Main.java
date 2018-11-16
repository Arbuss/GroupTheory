package Arthur;

import Matrix.*;

public class Main {

    public static Matrix mtrIncrement(Matrix mtr){
        mtr.increment(3);
        if(mtr.getElem(3) == mtr.getField()) {
            mtr.setElem(3, 0);
            mtr.increment(2);
            for (int i = 2; i > 0; i--) {
                if (mtr.getElem(i) == mtr.getField()) {
                    mtr.setElem(i, 0);
                    mtr.increment(i - 1);
                }
            }
        }
        return mtr;
    }

    public static MatrixArray getAllMatrixNonNullDet(int field){
        MatrixArray mtrArr = new MatrixArray();
        Matrix prevMtr = new Matrix2x2(field);

        for(int z = 0; z < Math.pow(field, 4); z++){
            Matrix newMtr = mtrIncrement(prevMtr);
            prevMtr = newMtr;
            if(Field.getNum(newMtr.getDeterminant(), newMtr.getField()) != 0) {
                mtrArr.add(newMtr);
            }
        }
        return mtrArr;
    }

    public static void main(String[] args){
        int field = 3;
        MatrixArray mtrArray = getAllMatrixNonNullDet(field);

        System.out.println((int)Math.pow(field, 4) + ": " +mtrArray.getSize());
    }
}
