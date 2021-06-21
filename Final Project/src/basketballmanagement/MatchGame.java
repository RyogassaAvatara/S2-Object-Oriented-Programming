package basketballmanagement;

import java.util.Date; // Enable to utilize dates

/**
 *
 * @author Ida Bagus Ryogassa Avatara
 */
// A Bunch of Setters and Getters when creating a Match
// it will get the two teams (team a and b) and get each of their scores and date, which allows users to see the score of each team and the date they are playing at.
public class MatchGame {
    
    private BasketballTeam teamA;
    private BasketballTeam teamB;
    private int teamAScore;
    private int teamBScore;
    private Date date;
    
    // Getters
    public BasketballTeam getTeamA() {
        return teamA;
    }
    
    public BasketballTeam getTeamB() {
        return teamB;
    }
    
    public int getTeamAScore(){
        return teamAScore;
    }
    
    public int getTeamBScore(){
        return teamBScore;
    }
    
    public Date getDate() {
        return date;
    }
    
    // Setters
    public void setTeamA(BasketballTeam teamA) {
        this.teamA = teamA;
    }
    
    public void setTeamB(BasketballTeam teamB) {
        this.teamB = teamB;
    }
    
    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }
    
    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
}