public class CircleBrainThread implements Runnable
{
    public Thread t;
    private Matrix m1;
    private Matrix m2;
    public int m1row;
    private int m2col;
    public int sol;
    public CircleBrainThread(Matrix m1, Matrix m2, int r, int c)
    {
        this.m1 = m1;
        this.m2 = m2;
        m1row = r;
        m2col = c;
        sol = 0;
    }

    public void start()
    {
        t = new Thread(this);
        t.start();
    }

    @Override public void run()
    {
        sol = MatrixMultiply.calc(m1, m2, m1row, m2col);
    }
}
