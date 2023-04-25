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

        Matrix retMatrix = new Matrix();
        
        for (int m1row = 0; m1row < m1.height(); m1row++)
        {
            threads.add(new BigBrainThread(m1, m2, m1row));
            threads.get(threads.size()-1).start();

            if(m1row%maxThreads == maxThreads-1)
            {
                for(BigBrainThread t : threads) 
                {
                    try
                    {
                        t.t.join();
                        newRows.add(t.newRow);
                    }
                    catch(Exception e) {}
                }
                threads = new ArrayList<>();
            }
        }
        for(BigBrainThread t : threads) 
        {
            try
            {
                t.t.join();
                newRows.add(t.newRow);
            }
            catch(Exception e) {}
        }

        for(String s: newRows)
        {
            retMatrix.addRow(s);
        }

        return retMatrix;
    }

    private void waitForThreads()
    {
        for(BigBrainThread t : threads) 
        {
            try
            {
                t.t.join();
            }
            catch(Exception e) {}
        }
    }
}
