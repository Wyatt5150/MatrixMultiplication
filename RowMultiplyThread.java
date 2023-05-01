public class RowMultiplyThread implements Runnable
{
    public Thread t;

    private Matrix m1;
    private Matrix m2;
    private Matrix result;

    private int m1row;
    private int interval;
    public RowMultiplyThread(Matrix m1, Matrix m2, Matrix res, int r, int i)
    {
        this.m1 = m1;
        this.m2 = m2;
        result = res;
        m1row = r;
        interval = i;
    }

    public void start()
    {
        t = new Thread(this);
        t.start();
    }

    @Override public void run()
    {
        while(m1row < m1.height())
        {
            for (int m2col = 0; m2col < m2.width(); m2col++)
            {
                result.set(m1row,m2col,MatrixMultiply.calc(m1, m2, m1row, m2col));
            }
            m1row+=interval;
        }
    }
}
