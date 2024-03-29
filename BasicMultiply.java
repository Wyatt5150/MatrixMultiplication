public class BasicMultiply extends MatrixMultiply
{
    public Matrix multiply(Matrix m1, Matrix m2)
    {
        if(!isValid(m1, m2))
        {
            invalidSize(m1, m2);
            return null;
        }

        //Matrix retMatrix = new Matrix(m1.height(), m2.width());
        Matrix retMatrix = new Matrix();
        for (int m1row = 0; m1row < m1.height(); m1row++)
        {
            String newRow = "";
            for (int m2col = 0; m2col < m2.width(); m2col++)
            {
                //retMatrix.set(m1row, m2col, calc(m1, m2, m1row, m2col));
                newRow += calc(m1, m2, m1row, m2col) + " ";
            }
            retMatrix.addRow(newRow);
        }

        return retMatrix;
    }
}