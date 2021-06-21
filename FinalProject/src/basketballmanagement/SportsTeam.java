package basketballmanagement;

/**
 *
 * @author Ida Bagus Ryogassa Avatara
 */
// Setters and Getters for Statistics for a Team
public abstract class SportsTeam {
    
    private String name;
    private String location;
    private String statistics;
    
    @Override
    public boolean equals(Object o) {
        return this.name.equals(((SportsTeam)o).name);
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
    // Setters
    public String getStatistics() {
        return statistics;
    }
    
    public void setLocation(String s) {
        this.location = s;
    }
    
    public void setName(String s) {
        this.name = s;
    } 
    
    public void setStatistics(String s) {
        this.statistics = s;
    }   
    
}