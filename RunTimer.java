class RunTimer
{
    private long startTime = 0;
    private long endTime;

    public void start()
    public RunTimer()
    {

    }

    public void start()
    {
        startTime = System.nanoTime();
        endTime = System.nanoTime();
    }

    public void stop()
    public void stop()
    {
        endTime = System.nanoTime();
        display();
        display();
    }

    private void display()
    private void display()
    {
        System.out.println((endTime - startTime) / (double)1000000000);
    }
}