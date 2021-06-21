package basketballmanagement;

// IMPORTS
import java.text.ParseException;
import java.text.SimpleDateFormat; // For displaying calendar
import java.util.ArrayList; // For items in a list to be added and/or removed
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Ida Bagus Ryogassa Avatara
 */
// This will get all user input data that extends interface LeagueManager
public class NBAManager implements LeagueManager {
    
    private final int numberOfTeams; // This will take the number of teams a user have
    private final ArrayList<BasketballTeam> league; // This will take lists of teams
    private final Scanner scanner; // For keyboard input
    private final ArrayList<MatchGame> matches; // This will take lists of match played
    
    public NBAManager(int numberOfTeams) {
        
        this.numberOfTeams = numberOfTeams;
        league = new ArrayList<>(); // list of teams
        matches = new ArrayList<>(); // list of matches
        scanner = new Scanner(System.in);
        displayMenu();
    }
    
    // This allows to display menu and looped
    private void displayMenu() {
        
        while(true) {
            System.out.println("===============BASEKETBALL LEAGUE MENU================= ");
            System.out.println("1. Add a Team");
            System.out.println("2. Delete an existing team");
            System.out.println("3. Show Statistics for team");
            System.out.println("4. Show Basketball Teams");
            System.out.println("5. Add a Match");
            System.out.println("6. Show Calendar and Find Match");
            System.out.println("Please choose: ");
            String nLine = scanner.nextLine();
            int choice = 0; // by default 0
            try {
                choice = Integer.parseInt(nLine);
            } catch (Exception e) {
        }
            // Switch/case will call a specific function depending on user choice
            switch(choice) {
                case 1 :
                   addTeam();
            break;
                case 2 :
                    deleteTeam();
                    break;
                case 3 :
                    displayStatistics();
                  break;
                case 4 :
                    displayLeagueTable();
                  break;
                case 5:
                    addPlayedMatch();
                   break;
                case 6:
                    displayCalendar();
                   break;
            default:
            System.out.println("Invalid Input!");
        }
        
    } 
        
   }
    
    // Does not allow to add more teams if it has reached its max
    private void addTeam(){
        if(league.size() == numberOfTeams) {
            System.out.println("INVALID...Unable to Add more Teams to league!");
            return;
        }
        // User creates a new team and inputs a team name
        BasketballTeam team = new BasketballTeam();
        System.out.println("Insert Team Name: ");
        String line = scanner.nextLine();
        team.setName(line); 
        // Does not allow to add a team with the same name
        if(league.contains(team)){
            System.out.println("INVALID...Team has already Existed!");
            return;
        } 
        // User inputs a team location
        System.out.println("Insert a Team Location: ");
        line = scanner.nextLine();
        team.setLocation(line);
        league.add(team);   
    }
    
    // This will Delete a team depending on user's input
    private void deleteTeam() {
        System.out.println("Insert a Team name: ");
        String line = scanner.nextLine();
         for(BasketballTeam Team : league) {
             if(Team.getName().equals(line)){
                 league.remove(Team);
                 System.out.println(Team.getName()+" is removed!");
                 return;
             }
         }
         System.out.println("INVALID...Team not Found!");
    }
    
    // This will Display the statistics when user inputs it
    private void displayStatistics() {
        
        System.out.println("Insert a Team name: ");
        String line = scanner.nextLine();
         for (BasketballTeam team : league) {
             if(team.getName().equals(line)){
                 System.out.println("===============" + team.getLocation() + " " + team.getName() + " STATS" + "===============");
                 System.out.println(" WINS: " + team.getWinCount());
                 System.out.println(" LOSTS: " + team.getLossCount()); 
                 System.out.println(" Team Scores: " + team.getScoredScoreCount());
                 System.out.println(" Opponent Scores: " + team.getReceivedScoreCount());
                 System.out.println(" Points: " + team.getPoints());
                 System.out.println(" Matches Played: " + team.getMatchesPlayed());
                 return;
             }
         }
         System.out.println("INVALID...Team not Found!");
    } 
    // This will Display the league table when user input it
    private void displayLeagueTable() {
        // Sort the teams using AComparator class
        Collections.sort(league, new AComparator());
        for(BasketballTeam team : league) {
            System.out.println("Team: " + team.getLocation() + " " + team.getName() + " Points: " + team.getPoints() + " Score difference: " + 
                    (team.getScoredScoreCount() - team.getReceivedScoreCount()));
    }    
  }
    // This will Add a Match when a user inputs it
    private void addPlayedMatch(){
        System.out.println("Enter date (mm-dd-yyyy): ");
        String line = scanner.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("mm-dd-yyyy").parse(line);
        } catch (ParseException ex) {
            System.out.println("INVALID...enter date (mm-dd-yyyy)!");
            return;
        }
        System.out.println("Enter a Home Team: ");
        line = scanner.nextLine();
        BasketballTeam home = null;
          for(BasketballTeam team : league){
              if(team.getName().equals(line))
                  home = team;
          }  
          if (home == null) {
              System.out.println("INVALID...Team not Found!");
              return;
          }
          System.out.println("Enter a Away Team: ");
          line = scanner.nextLine();
          BasketballTeam away = null;
           for(BasketballTeam team : league){
              if(team.getName().equals(line))
                  away = team;
          } 
           if (away == null) {
              System.out.println("INVALID...Team not Found!");
              return;
          }
           
           System.out.println("Enter the home team score: ");
           line = scanner.nextLine();
           int homeScore = -1;
             try {
                 homeScore = Integer.parseInt(line);                
             } catch (Exception e) { 
    }
         if (homeScore == -1) { 
             System.out.println("INVALID.. enter a score >= 0!");
             return;
         }
         
         System.out.println("Enter the away team score: ");
           line = scanner.nextLine();
           int awayScore = -1;
             try {
                 awayScore = Integer.parseInt(line);                
             } catch (Exception e) { 
    }
         if (awayScore == -1) {
             System.out.println("INVALID.. enter a goal >= 0!");
             return;
         }
         
         // Implementing the MatchGame Class
         MatchGame match = new MatchGame();
         match.setDate(date);
         match.setTeamA(home);
         match.setTeamB(away);
         match.setTeamAScore(homeScore);
         match.setTeamBScore(awayScore);
         matches.add(match);
         
         home.setScoredScoreCount(home.getScoredScoreCount() + homeScore);
         away.setScoredScoreCount(away.getScoredScoreCount() + awayScore);
         home.setRecievedScoreCount(home.getReceivedScoreCount() + awayScore);
         away.setRecievedScoreCount(away.getReceivedScoreCount() + homeScore);
         home.setMatchesPlayed(home.getMatchesPlayed() + 1);
         away.setMatchesPlayed(away.getMatchesPlayed() + 1);
         // These will add points
         // if Home team scores more than away team, home team score will be added
         if (homeScore > awayScore) {            
             home.setPoints(home.getPoints()+3);
             home.setWinCount(home.getWinCount()+1);
             away.setLossCount(away.getLossCount()+1);
         }
         // if away team scores more than home team, away team score will be added
         else if (homeScore < awayScore) {            
             away.setPoints(away.getPoints()+3);
             away.setWinCount(away.getWinCount()+1);
             home.setLossCount(home.getLossCount()+1);
         }
         else {
             home.setPoints(home.getPoints()+1);
             away.setPoints(away.getPoints()+1);
             
         }      
    } 
    // This will display the calendar when user inputs it
    // Below are functions/variables to set a date and show the calendar depending on user choice
    private void displayCalendar() {
        
        System.out.println("Enter a year: ");
        String line = scanner.nextLine();
         int Y = -7777; // If user inputs a non-int, then y will stay as -7777
           try {
               Y = Integer.parseInt(line);
           } catch (Exception e) { 
    }
         if (Y == -7777) { 
             System.out.println("INVALID.. enter a year!");
             return;
         }
    
          System.out.println("Enter a Month: ");
          line = scanner.nextLine();
          int M = 0;
           try {
               M = Integer.parseInt(line);
           } catch (Exception e) { 
    }
         if (M == 0) {
             System.out.println("INVALID.. enter a month!");
             return;
         }
         
         // String of array months
         String[] months = {
            "", // index 0 empty so month 1 will be January
             "January", "February", "March",
             "April", "May", "June",
             "July", "August", "September",
             "October", "November", "December"};
         
         // int of array days
         int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
         
         // Check for any leap years
         if (M == 2 && leap(Y)) days[M] = 29;
         
         System.out.println("    " + months[M] + " " + Y);
         System.out.println("S  M  Tu  W  Th  F  S");
         
         // Below creating a proper calendar and display it
         // Matching the days with months
         int d = day(M, 1, Y);
         
         for (int i = 0; i < d; i++) // 
             System.out.print("   ");
         for (int i = 1; i <= days[M]; i++) {
             if (i < 10)
                 System.out.print(i + "  ");
             else 
                 System.out.print(i + " ");
             if (((i + d) % 7 == 0) || (i == days[M])) System.out.println();
         }
         // User inputs a day
         System.out.println("Enter a day: ");
         line = scanner.nextLine();
         int D = 0;
           try {
               D= Integer.parseInt(line);
           }  catch (Exception e) {             
           }
       if (D == 0 || days[M] < D) {
           System.out.println("INVALID.. enter a day in month!");
           return;
       }  
       
       // Checking if there was a game on a specific date chosen by user input
       Calendar c = Calendar.getInstance();
       c.set(Y, M - 1, D);
       for (MatchGame m : matches) { //added matches within a date
           Calendar c2 = Calendar.getInstance();
           c2.setTime(m.getDate());
            // If there is a match, it will display each team and score
            if (c.get(Calendar.YEAR) == c2.get(Calendar.YEAR) || c.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {
                System.out.println(m.getTeamA().getName() + " " + m.getTeamAScore() + " : " + m.getTeamBScore() + " " + m.getTeamB().getName()); 
            }
       }   
    } 
    
    // Method for day to match the days, months and years correctly
    public int day(int M, int D, int Y) {
        int y = Y - (14 - M) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = M + 12 * ((14 - M)/12) - 2;
        int d = (D + x + (31 * m)/12) % 7;
        return d;
    }
    // Method for leap year that will return true if the given year is a leap year
    public boolean leap(int year) {
        
        if ((year % 4 ==0) && (year % 100 !=0 )) return true;
        if (year % 400 == 0) return true;
        return false;  
    }
} 
    
    
    
