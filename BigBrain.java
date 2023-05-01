import java.util.ArrayList;

public class BigBrain extends MatrixMultiply
{
    int maxThreads;
    ArrayList<BigBrainThread> threads;
    ArrayList<String> newRows;

    public BigBrain(int num)
    {
        maxThreads = num;
        threads = new ArrayList<BigBrainThread>();
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
            threads.add(new BigBrainThread(m1, m2,retMatrix, m1row, maxThreads));
            threads.get(threads.size()-1).start();
        }

        for(BigBrainThread t : threads) 
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
