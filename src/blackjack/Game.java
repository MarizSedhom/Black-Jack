
package blackjack;


import java.util.Random;
import java.util.Scanner;
public class Game {
    Player p[]=new Player[4];
    public Card c[]=new Card[52];
    public static int count=0;
    int countDeck=0;
    public void Generate_Card_Deck(){
        for(int i=0;i<4;i++){
            int value=1;
            for(int j=0;j<13;j++){
                c[countDeck]=new Card (i,j,value);
                countDeck++;
                if(value<10){
                    value++;
                }
                else{
                    value=10;
                }
            }
        }
    }
    public Card Draw_Random_Card(){
        count++;
        Random rand= new Random();
        int randcard= rand.nextInt(52);
        while(c[randcard]==null){
            randcard= rand.nextInt(52);
        }
            Card returnCard = new Card(c[randcard]);
            c[randcard]=null;
        
        return returnCard;
    }
    public void Set_info_Player(){
        for(int i=0; i<4; i++){                   
            int j=0;
          if(i==3){
           p[i]= new Player("Dealer");
            p[i].c[j]= Draw_Random_Card();
            p[i].setScore(p[i].getScore()+p[i].c[j].getValue());
            j++;
            p[i].c[j]=Draw_Random_Card();
            p[i].setScore(p[i].getScore()+p[i].c[j].getValue());
            j++;
           }
          else{
            System.out.println("Enter the name of player number" + (i+1));
            Scanner input= new Scanner(System.in);
            String pName=input.next();
            
            p[i]= new Player(pName);
            p[i].c[j]= Draw_Random_Card();
            p[i].setScore(p[i].c[j].getValue());
            j++;
            p[i].c[j]=Draw_Random_Card();
            p[i].setScore(p[i].getScore()+p[i].c[j].getValue());
            j++;
          }  
        }
        
    }
    public int Game_Max_Score(){
        int max_score=0;
        for(int i=0; i<3; i++){  
            if(p[i].getScore()>= max_score && max_score<=21 && p[i].getScore()<=21){
                max_score= p[i].getScore();
            }    
        }
        return max_score;
    }
    public String Game_Max_player(){
        int max_score=0;
        String max_player = null;
        for(int i=0; i<3; i++){  
            if(p[i].getScore()>= max_score && max_score<=21 && p[i].getScore()<=21){
                max_score= p[i].getScore();
                max_player=p[i].getName();
            }    
        }
        return max_player;
    }
}
