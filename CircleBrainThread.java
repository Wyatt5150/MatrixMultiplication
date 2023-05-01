public class CircleBrainThread implements Runnable
{
    public Thread t;

    private Matrix m1;
    private Matrix m2;
    private Matrix result;

    private int index;
    private int interval;
    private int max;

    public CircleBrainThread(Matrix m1, Matrix m2, Matrix res, int index, int interval)
    {
        this.m1 = m1;
        this.m2 = m2;
        this.index = index;
        this.interval = interval;
        result=res;
        max = m1.height()*m2.width();
    }

    public void start()
    {
        t = new Thread(this);
        t.start();
    }

    @Override public void run()
    {
        while(index<max)
        {
            int m1row = index/m2.width();
            int m2col = index%m2.width();
            result.set(m1row, m2col,MatrixMultiply.calc(m1, m2, m1row, m2col));

            index +=interval;
        }
    }
}
