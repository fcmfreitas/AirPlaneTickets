import java.util.Scanner;
import java.io.FileInputStream;


public class Plane{
    public static void print(boolean [][] seats){
        System.out.println("      A     B     C     D");
        for(int i = 0; i < seats.length; i++){
            System.out.printf("%2d ", i + 1);
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j] == true){
                    System.out.print("[X]");
                }else{
                    System.out.print("[ ]");
                };
            }
            System.out.printf(" %2d%n", i + 1);
        }
    }
    public Plane(String flight){
        Scanner in = new Scanner(System.in);
        boolean [][] seats; //vendido -- nao vendido
        seats = new boolean [33] [4];
        System.out.println("Venda de passagens aereas para "+ flight +" :");
        print(seats);

        boolean i = false;
        while(i == false){
            
            String choice = in.next();
            System.out.println(choice);

            if(!choice.equals("exit")){
                char letter = choice.charAt(0);
                System.out.println(letter);
                int number = Integer.parseInt(choice.substring(1)); //primeiro letra         
                System.out.println(number);

                int column = 0;
                int line;
                switch(letter){
                    case 'A':
                    case 'a':    
                        column = 0;
                        break;
                    case 'B':
                    case 'b':    
                        column = 1;
                        break;
                    case 'C':           
                    case 'c':    
                        column = 2;
                        break;
                    case 'D':
                    case 'd':    
                        column = 3;
                        break;
                }

                line = number - 1;
                
                seats [line][column] = true;
            }
            
            if(choice.equals("exit")){
                i = true;
            } else{
                print(seats);
            }
        }

    }
}