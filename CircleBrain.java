import java.util.ArrayList;

public class CircleBrain extends MatrixMultiply
{
    int maxThreads;
    ArrayList<CircleBrainThread> threads;
    ArrayList<String> newRows;

    public CircleBrain(int num)
    {
        maxThreads = num;
        threads = new ArrayList<CircleBrainThread>();
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
            threads.add(new CircleBrainThread(m1, m2, retMatrix, i, maxThreads));
            threads.get(threads.size()-1).start();
        }

        for(CircleBrainThread t : threads) 
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
