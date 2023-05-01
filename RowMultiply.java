import java.util.ArrayList;

public class RowMultiply extends MatrixMultiply
{
    int maxThreads;
    ArrayList<RowMultiplyThread> threads;
    ArrayList<String> newRows;

    public RowMultiply(int num)
    {
        maxThreads = num;
        threads = new ArrayList<RowMultiplyThread>();
        newRows = new ArrayList<String>();
    }

    public Matrix multiply (Matrix m1, Matrix m2) 
    {
        if(!isValid(m1, m2))
        {
            invalidSize(m1, m2);
            return null;
        }

        Matrix retMatrix = new Matrix(m1.height(), m2.width());
        for (int m1row = 0; m1row < maxThreads && m1row < m1.height(); m1row++)
        {
            threads.add(new RowMultiplyThread(m1, m2,retMatrix, m1row, maxThreads));
            threads.get(threads.size()-1).start();
        }

        for(RowMultiplyThread t : threads) 
        {
            try
            {
                t.t.join();
            }
            catch(Exception e) {}
        }

        return retMatrix;
    }
}
