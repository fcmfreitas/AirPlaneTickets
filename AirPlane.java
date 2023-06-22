import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileInputStream;

public class AirPlane{
    private boolean seats[][];
    private String city;
    
    public AirPlane(String destiny){
        this.city = destiny;
        this.seats = new boolean[10][4];
    }
    public void sell(String ticket){
        System.out.println("");
        char letter = ticket.charAt(0);
        int number = Integer.parseInt(ticket.substring(1));
        
        int column;
        int line;
        
        if(letter == 'a'|| letter == 'A'){
            column = 0;            
        } else if(letter == 'b'|| letter == 'B'){
            column = 1;
        } else if(letter == 'c'|| letter == 'C'){
            column = 2;
        } else if(letter == 'd'|| letter == 'D'){
            column = 3;
        } else{
            column = -1;
        }
        
        line = number - 1;
        if(this.seats [line][column] == true){
            System.out.println("ocupado");
        } else{
            this.seats[line][column] = true;
        }
    }
    
    public void save() throws Exception{
        String filename = this.city.replace(" ", "");
        PrintStream file = new PrintStream(filename+".txt");
        
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {            
                    file.print(this.seats[i][j]+" ");
            }
            file.println();
        }
        file.close();
    }
}