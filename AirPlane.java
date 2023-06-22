public class AirPlane{
    private boolean seats[][];
    private String city;
    
    
    public AirPlane(String destiny){
        this.city = destiny;
        this.seats = new boolean[10][4];
        System.out.println("Seu destino eh "+ this.city);
    }
    public void sell(String ticket){
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
            System.out.println("occupied");
        } else{
            this.seats[line][column] = true;
        }
    }
    public void print(){
        
    }
    }