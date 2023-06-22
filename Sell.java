import java.util.Scanner;

public class Sell{
    public static void main(String[] args) throws Exception{
        System.out.print("Bem vindos a compra de passagens aereas! Hoje eh dia: ");
        Date dataCompraAtual = new Date();
        
       
        System.out.println("Para realizar sua compra primeiramente precisamos fazer um cadastro.");
        
    

        Scanner sc = new Scanner(System.in);
            
        Buyer person1 = new Buyer();
        
        
        
        System.out.println("Esclha para onde quer ir:\nDigite [1] para Rio de Janeiro\nDigite [2] para São Paulo\nDigite [3] para Salvador");
        String city = "";
        String destiny = sc.next();
        if(destiny.equals("1")||destiny.equals("[1]")){
            city = "Rio de Janeito";
        } else if(destiny.equals("2")||destiny.equals("[2]")){
            city = "São Paulo";
        } else if(destiny.equals("3")||destiny.equals("[3]")){
            city = "Salvador";
        } 
        AirPlane flight = new AirPlane(city);
        System.out.println("Seu destino é "+ city);
        
        
        
        //flight.save();
    }
}