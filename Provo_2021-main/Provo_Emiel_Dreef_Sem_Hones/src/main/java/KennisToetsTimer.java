public class KennisToetsTimer {
    private final static long NANO_SECS_PER_SEC =  1000000000;
    private final static long NANO_SECS_PER_MIN = NANO_SECS_PER_SEC*60;
    private long stopWatchStartTijd = 0;
    private long stopWatchStopTijd = 0;
    private boolean stopWatchLoopt = false;

    public void start() {
        stopWatchStartTijd = 0;
        this.stopWatchStartTijd = System.nanoTime();
        this.stopWatchLoopt = true;
    }

    public void stop() {
        this.stopWatchStopTijd = System.nanoTime();
        this.stopWatchLoopt = false;
    }

    public long getVerlopenSeconden() {
        long elapsedTime;
        if (stopWatchLoopt)
            elapsedTime = (System.nanoTime() - stopWatchStartTijd);
        else
            elapsedTime = (stopWatchStopTijd - stopWatchStartTijd);

        return elapsedTime / NANO_SECS_PER_SEC;
    }

    public long getVerlopenMinuten() {
        long elapsedTime;
        if (stopWatchLoopt)
            elapsedTime = (System.nanoTime() - stopWatchStartTijd);
        else
            elapsedTime = (stopWatchStopTijd - stopWatchStartTijd);

        return elapsedTime / NANO_SECS_PER_MIN;
    }
}
