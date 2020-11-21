public class Score {
    private int aScore;
    private int bScore;

    public Score(){
        this.aScore = 0;
        this.bScore = 0;
    }

    public int incrementA(){
        return this.aScore += 1;
    }

    public int incrementB(){
        return this.bScore += 1;
    }
}