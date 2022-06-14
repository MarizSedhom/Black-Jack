
package blackjack;


import java.util.Scanner;
public class BlackJack {
    
    static Game g = new Game();
    public static void main(String[] args) {
        GUI gui = new GUI();
        g.Generate_Card_Deck();
        g.Set_info_Player();
        gui.runGUI( g.c, g.p[0].c, g.p[1].c, g.p[2].c, g.p[3].c);
        Start_game(gui);
        Check_Winner();
    }
    public static void Start_game(GUI gui){
        for(int i=0; i<4;i++){
            int noCards=3;
            if(i==3){
                System.out.println("It's Dealer's turn");
               if( g.p[i].getScore()<=g.Game_Max_Score()){
                   while(g.p[i].getScore()<21 && noCards<=11 && g.p[i].getScore()<=g.Game_Max_Score()){
                       g.p[i].c[noCards]= g.Draw_Random_Card();
                       gui.updateDealerHand(g.p[i].c[noCards],g.c);
                       g.p[i].setScore(g.p[i].getScore()+g.p[i].c[noCards].getValue()); 
                       noCards++;
                    }    
               }
               System.out.println("the score of the " + g.p[i].getName() + " is " + g.p[i].getScore());
            }
            else{
                while(g.p[i].getScore()<21 && noCards<=11){
                    System.out.println("player " +g.p[i].getName()+" If you want to hit press 1 and if you want to stand press 2 ");
                    Scanner input= new Scanner(System.in);
                    int play = input.nextInt();
                    if(play==1){
                        g.p[i].c[noCards]= g.Draw_Random_Card();
                        gui.updatePlayerHand(g.p[i].c[noCards], i);
                        g.p[i].setScore(g.p[i].getScore()+g.p[i].c[noCards].getValue());  
                        noCards++;
                        
                    }
                    else if(play==2){
                        break;
                    }
                } 
                System.out.println("the score of player " + g.p[i].getName()+ " is " + g.p[i].getScore());
            }      
        }
    }
    
    public static void Check_Winner(){
        int counter=0;
        for(int i=0; i<4;i++){
           if(g.p[i].getScore()==g.Game_Max_Score()&&g.p[i].getScore()<=21 ){
               counter++;
           }
           if(i==3){
               if(counter>1){
                   if(g.p[i].getScore()>g.Game_Max_Score() &&g.p[i].getScore()<=21 ){
                       System.out.println("Dealer Won");
                   }
                   else{
                       System.out.println("Push");
                   }
               }
               else if(counter==1){
                   if(g.p[i].getScore()>g.Game_Max_Score() &&g.p[i].getScore()<=21 ){
                       System.out.println("Dealer Won");
                   }
                   else{
                       System.out.println(g.Game_Max_player()+" Won");
                   }
               }
               else if(counter==0){
                   if(g.p[i].getScore()>g.Game_Max_Score() &&g.p[i].getScore()<=21 ){
                       System.out.println("Dealer Won");
                   }
               }
           }
        }
    }
}
