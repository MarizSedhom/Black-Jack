
package blackjack;


public class Player {
    private final String Name;
    private int Score;
    Card c[]=new Card[11];

    public Player(String Name) {
        this.Name = Name;
        
    }
    
    public String getName() {
        return Name;
    }
    
    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getScore() {
        return Score;
    }
       
}
