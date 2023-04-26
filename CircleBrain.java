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

        Matrix retMatrix = new Matrix();
        String s ="";
        int row = 0;
        
        for (int m1row = 0; m1row < m1.height(); m1row++)
        {
            for (int m2col = 0; m2col < m2.width(); m2col++)
            {
                threads.add(new CircleBrainThread(m1, m2, m1row, m2col));
                threads.get(threads.size()-1).start();
                
                if(threads.size() == maxThreads)
                {
                    for(CircleBrainThread t : threads) 
                    {
                        try
                        {
                            t.t.join();
                            if(t.m1row > row)
                            {
                                retMatrix.addRow(s);
                                row++;
                                s = t.sol+" ";
                            }
                            else
                            {
                                s+= t.sol+ " ";
                            }
                        }
                        catch(Exception e) {}
                    }
                    threads = new ArrayList<>();
                }
            }
        }
        for(CircleBrainThread t : threads) 
                    {
                        try
                        {
                            t.t.join();
                            if(t.m1row > row)
                            {
                                retMatrix.addRow(s);
                                row++;
                                s = t.sol+" ";
                            }
                            else
                            {
                                s+= t.sol+ " ";
                            }
                        }
                        catch(Exception e) {}
                    }
                    retMatrix.addRow(s);

        return retMatrix;
    }
}
