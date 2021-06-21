package basketballmanagement;

import java.util.Comparator; // Enables for ordering/compare objects of a user-defined class.

/**
 *
 * @author Ida Bagus Ryogassa Avatara
 */

// based on BasketballTeam Class (linked with SportsTeam)
public class AComparator implements Comparator<BasketballTeam> {
    
    /** This variables will display the teams in descending order according to the points they have scored (team with the most maximum points will appear first)
     *  IF HOWEVER two teams or more have the amount of points, then order will still be descending based on SCORE DIFFERENCE (team with the best score difference will appear first)
     */
    @Override
    public int compare(BasketballTeam t, BasketballTeam t1) { // first team (t), second team (t1)
        
        if(t.getPoints() > t1.getPoints()) 
            return -1;
        else 
            if (t.getPoints() < t1.getPoints())
                return 1;
            else {
                int scoreDif = t.getScoredScoreCount() - t.getReceivedScoreCount();
                int scoreDif1 = t1.getScoredScoreCount() - t1.getReceivedScoreCount();
                if(scoreDif > scoreDif1)
                    return -1;
                else
                    if(scoreDif < scoreDif1)
                        return 1;
                    else return 0;
            }
        
    }
}