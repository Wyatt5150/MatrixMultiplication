class RunTimer
{
    private long startTime = 0;
    private long endTime;

    public void start()
    {
        startTime = System.nanoTime();
        endTime = System.nanoTime();
    }

    public void stop()
    {
        endTime = System.nanoTime();
        display();
    }

    private void display()
    {
        System.out.println((endTime - startTime) / 1000000000);
    }
}