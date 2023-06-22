import java.util.Scanner;
import java.io.File;

/**
 * Fernando Flores Cabral Neto | Matricula 23102305
 * Leonardo Chiao Andreucci | Matricula 23102474
 * Francisco Castro Menezes de Freitas | Matricula 23103208
 *
 */
public class SellApp{
    public static void main(String[] args) throws Exception{
        System.out.print("Bem vindos a compra de passagens aereas! Seu voo parte hoje dia: ");
        Date dataCompraAtual = new Date();

        System.out.println("Para realizar sua compra primeiramente precisamos fazer um cadastro.");

        Scanner sc = new Scanner(System.in);
        Buyer person1 = new Buyer();

        System.out.println("Esclha para onde quer ir:\nDigite [1] para Rio de Janeiro\nDigite [2] para São Paulo\nDigite [3] para Salvador");
        String city = "";

        String destiny = sc.next();

        if(destiny.equals("1")||destiny.equals("[1]")){
            city = "Rio de Janeiro";
        } else if(destiny.equals("2")||destiny.equals("[2]")){
            city = "São Paulo";
        } else if(destiny.equals("3")||destiny.equals("[3]")){
            city = "Salvador";
        } 
        boolean pass = true;

        while(pass == true){
            if(destiny.equals("1")||destiny.equals("[1]")){
                city = "Rio de Janeiro";
                pass = false;
            } else if(destiny.equals("2")||destiny.equals("[2]")){
                city = "São Paulo";
                pass = false;
            } else if(destiny.equals("3")||destiny.equals("[3]")){
                city = "Salvador";
                pass = false;
            } else{
                System.out.println("Por favor, escolha um destino válido.");
                sc.next();
            }
        }

        AirPlane flight = new AirPlane(city);
        String filename = city.replace(" ", "") + ".txt";

        File file = new File(filename);

        if (file.exists()) {
            flight.read();
        }

        System.out.println("Seu destino é "+ city +". Quantos assentos gostaria de comprar?");
        int quant = sc.nextInt();
        boolean desconto = false;

        if(quant > 4)
        {
            desconto = true;
        }

        flight.print();
        double price = 0;

        for (int i = 1; i <= quant; i++) {
            String seat = sc.next();
            if (flight.sell(seat)) {
                price = price + flight.price();
            } else {
                i--; 
            }
        }

        if (desconto == true) {
            price = price - (price * 10 / 100);
        }

        flight.print();
        System.out.printf("VALOR A PAGAR: R$ %.2f\n", price);

        flight.save();

    }
}
