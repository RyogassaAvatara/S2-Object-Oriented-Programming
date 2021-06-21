package basketballmanagement;

/**
 *
 * @author Ida Bagus Ryogassa Avatara
 */
// BasketballTeam class inherits SportsTeam abstract class
// It will receive different aspects like number of wins, loss, points, matches player, etc depending on user input
public class BasketballTeam extends SportsTeam { 
    
    private int winCount;
    private int lossCount;
    private int scoredScoreCount;
    private int receivedScoreCount;
    private int points;
    private int matchesPlayed;
    
    // Getters
    public int getWinCount(){
        return winCount;
    }
   
    public int getLossCount(){
        return lossCount;
    }
    
    public int getScoredScoreCount() {
        return scoredScoreCount;
    }
    
    public int getReceivedScoreCount() {
        return receivedScoreCount;
    }
    
    public int getPoints() {
        return points;
    }
    
    public int getMatchesPlayed() {
        return matchesPlayed;
    }
    
    // Setters
    public void setWinCount(int i) {
        winCount = i;
    }
    
    public void setLossCount(int i) {
        lossCount=i;
    }
    
    public void setScoredScoreCount(int i){
        scoredScoreCount = i;
    }
    
     public void setRecievedScoreCount(int i){
        receivedScoreCount = i;
    }
     
     public void setPoints(int i){
        points = i;
    }
    
     public void setMatchesPlayed(int i){
        matchesPlayed = i;
    }
    
}
