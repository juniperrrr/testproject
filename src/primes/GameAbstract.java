
package primes;

public abstract class GameAbstract {
    
    private int scoreCounter, tryAgain;
    static int totalScore;
    
    public GameAbstract(){
        this.scoreCounter = 0;
        this.tryAgain = 0;
    }

    public int getScoreCounter() {
        return scoreCounter;
    }

    public void setScoreCounter(int scoreCounter) {
        this.scoreCounter += scoreCounter;
    }

    public int getTryAgain() {
        return tryAgain;
    }

    public void setTryAgain(int tryAgain) {
        this.tryAgain += tryAgain;
    }
    
    abstract boolean isInputPrimeNum(int n);
    abstract boolean isDivisibleNum(int dividend, int divisor);
    abstract int displayScore(int x, int y);
}
