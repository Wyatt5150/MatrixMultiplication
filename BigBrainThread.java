public class BigBrainThread implements Runnable
{
    public Thread t;
    private Matrix m1;
    private Matrix m2;
    private int m1row;
    public String newRow;
    public BigBrainThread(Matrix m1, Matrix m2, int r)
    {
        this.m1 = m1;
        this.m2 = m2;
        m1row = r;
        newRow = "";
    }

    public void start()
    {
        t = new Thread(this);
        t.start();
    }

    @Override public void run()
    {
        for (int m2col = 0; m2col < m2.width(); m2col++)
        {
            newRow += MatrixMultiply.calc(m1, m2, m1row, m2col) + " ";
        }
    }
}
