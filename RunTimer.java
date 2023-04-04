class RunTimer
{
    private long startTime = 0;
    private long endTime;

    public RunTimer()
    {

    }

    public void startTimer()
    {
        startTime = System.nanoTime();
        endTime = System.nanoTime();
    }

    public void stopTimer()
    {
        endTime = System.nanoTime();
        displayTimer();
    }

    private void displayTimer()
    {
        System.out.println((endTime - startTime) / 1000000000);
    }
}