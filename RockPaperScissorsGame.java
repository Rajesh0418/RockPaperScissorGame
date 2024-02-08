import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class InvalidOptionEnteredException extends Exception    // user defined exception
{
    public InvalidOptionEnteredException(String s)
    { 
        super(s);
    }
}
class RPS   // R-rock  P-paper  S-scissor  over exception
{
    // for user playwith exception and rock,paper and scissor
    static void validate(int playWith) throws InvalidOptionEnteredException    
    {
        if(3<playWith) 
        {
            throw new InvalidOptionEnteredException("The option is invalid...please enter between 1 and 3");
        }
    }
    public static int checkingGame(String player1,String player2, int player01,int player02)  //game checking i.e., it will check who are win
    {
        System.out.println();
        if(player01==player02)
        {
            System.out.println("The game has been Tie ");
            return 0;
        }
        else if(player01==1 && player02==2)
        {
            System.out.println("The "+player2+" is won");
            return 2;
        }
        else if(player01==1 && player02==3)
        {
            System.out.println("The "+player1+" is won");
            return 1;
        }
        else if(player01==2 && player02==1)
        {
            System.out.println("The "+player1+" is won");
            return 1;
        }
        else if(player01==2 && player02==3)
        {
            System.out.println("The "+player2+" is won");
            return 2;
        }
        else if(player01==3 && player02==1)
        {
            System.out.println("The "+player2+" is won");
            return 2;
        }
        else
        {
            System.out.println("The "+player1+" is won");
            return 1;
        }
    }
    public static int rpsCheck(String player1,String player2,int playwith)
    {
        Scanner sc=new Scanner(System.in);
        int player01=0,player02=0;  // for both players of choosing options for rock, paper and scissor
        int check=0;
        switch(playwith)
        {
                case 1: boolean k=false;      // two player game
                        do
                        {
                            k=false;
                            System.out.println("1.Rock\t 2.Paper\t3.scissor");
                            System.out.println();
                            System.out.print(player1+" choice : ");   // player 1 name
                            player01=sc.nextInt();
                            try{
                                validate(player01);  // if out off three options of rock paper scissor
                            }
                            catch(InvalidOptionEnteredException e)
                            {
                                System.out.println("Exception occurred : "+e.getMessage());
                                System.out.println();
                                k=true;
                            }
                        }while(k);
                        do{
                            k=false;
                            System.out.print(player2+" choice : ");   // player 2 name
                            player02=sc.nextInt();
                            try{
                                validate(player02);  // if out off three options of rock paper scissor
                            }
                            catch(InvalidOptionEnteredException e)
                            {
                                System.out.println("Exception occurred : "+e.getMessage());
                                System.out.println();
                                k=true;
                            }
                        }while(k);
                        check=checkingGame(player1,player2,player01,player02);
                        System.out.println();
                        break;
                case 2: boolean l;   // with computer game
                        do
                        {
                            l=false;
                            System.out.println("1.Rock\t 2.Paper\t3.scissor");
                            System.out.println();
                            System.out.print(player1+" choice : ");
                            player01=sc.nextInt();
                            try{
                                validate(player01);       // if out off three options of rock paper scissor when the player is entered out off options
                            }
                            catch(InvalidOptionEnteredException e)
                            {
                                System.out.println("Exception occurred : "+e.getMessage());
                                System.out.println();
                                l=true;
                            }
                        }while(l);
                        System.out.print(player2+" choice : ");
                        List<String> stringList = new ArrayList<>();
                        stringList.add("Rock");
                        stringList.add("Paper");
                        stringList.add("scissor");
                        Random random = new Random();
                        int randomIndex = random.nextInt(1,stringList.size());   // getting random number from the arrayList size
                        System.out.println(randomIndex);    
                        String randomString = stringList.get(randomIndex);  // random genetated string---> optional
                        check=checkingGame(player1,player2,player01,randomIndex);  // call the method called who are win
                        System.out.println();
                        break;
        }
        return check;
    }
    public static void rockPaperscissor(String player1,String player2,int points,int playwith)
    {
        int pCount1=0,pCount2=0; //counting the players points
        for(int i=0;i<points;i++)  // this loop will iterate unitl the (no. of points is conducted)
        {
            int count=rpsCheck(player1,player2,playwith);  // game call
            switch(count)
            {
                case 1: pCount1++;    //counting the player 1 points
                        break;
                case 2 : pCount2++;   //counting the player 2 points
                         break;
            }
        }
        System.out.println();
        if(pCount1 > pCount2)  System.out.println(player1+" is won the match by "+pCount1);  // this statement will display the player 1 won
        else if(pCount1 < pCount2)  System.out.println(player2+" is won the match by "+pCount2); // this statement will display the player 1 won
        else System.out.println("Both players are win"); // tie 

    }
}
class RockPaperScissorsGame extends RPS
{
    public static void main(String ar[])
    {
        RPS rps=new RPS();
        Scanner sc=new Scanner(System.in); //for taking the input 
        System.out.println();
        System.out.println("\t\t<......Welcome Rock Paper scissor Game......>");
        System.out.println();
        boolean t=true,p=false;
        int playWith=0;
        do
        {
            do
            {
                System.out.println("1. Play with a friend\t 2. Play with a computer\t 3. Exit");
                System.out.println();
                System.out.print("Choose your game level : ");
                playWith=sc.nextInt();
                 try{
                     p=false;
                    rps.validate(playWith);
                }
                catch(InvalidOptionEnteredException e)
                {
                    System.out.println("Exception occurred : "+e.getMessage());  // exception raised when out off the above game level options
                    System.out.println();
                    p=true;
                }
            }while(p);
            int points=0,continueTheGame=0;
            switch(playWith)
            {
                case 1: System.out.print("Enter how many points do you want to play...");  // how many points will conduct for this game
                        points=sc.nextInt();
                        System.out.println();
                        System.out.print("Enter player 1 name : ");     //// playing with a friend
                        String player1=sc.next();
                        System.out.print("Enter player 2 name : ");
                        String player2=sc.next();
                        System.out.println();
                        System.out.println("\t\t\tLet's play the game");
                        System.out.println();
                        rps.rockPaperscissor(player1,player2,points,playWith);
                        System.out.print("Do you want to play agian then enter 1...otherwise enter 0 : "); // want to play another match
                        continueTheGame=sc.nextInt();
                        System.out.println();
                        if(continueTheGame==1) t=true;
                        else t=false;
                        break;
                case 2: System.out.print("Enter how many points to play..."); // playing with a computer
                        points=sc.nextInt();  
                        System.out.println();
                        System.out.print("Enter player name : ");
                        String playerr=sc.next();  // who are playing with a computer
                        System.out.println();
                        System.out.println("\t\t\tLet's play the game");
                        System.out.println();
                        rps.rockPaperscissor(playerr,"computer",points,playWith);
                        System.out.print("Do you want to play agian then enter 1...otherwise enter 0  : "); // want to play another match
                        continueTheGame=sc.nextInt();
                        System.out.println();
                        if(continueTheGame==1) t=true;
                        else t=false;
                        break;
                default:System.out.println(); 
                        t=false;
            }
        }while(t);
        if(!(playWith>4))   
             System.out.print("\t\t\tTHANK YOU FOR PLAYING THIS GAME");
    }
}