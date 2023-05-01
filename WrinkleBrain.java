import java.util.ArrayList;

public class WrinkleBrain extends MatrixMultiply
{
    int maxThreads;
    ArrayList<WrinkleBrainThread> threads;
    ArrayList<String> newRows;

    public WrinkleBrain(int num)
    {
        maxThreads = num;
        threads = new ArrayList<WrinkleBrainThread>();
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
        for(int i = 0; i<maxThreads && i<m1.height()*m2.width(); i++)
        {
            threads.add(new WrinkleBrainThread(m1, m2, retMatrix, i, maxThreads));
            threads.get(threads.size()-1).start();
        }

        for(WrinkleBrainThread t : threads) 
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