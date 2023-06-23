import java.util.Scanner;
import java.io.File;

/**
 * Fernando Flores Cabral Neto | Matricula 23102305
 * Leonardo Chiao Andreucci | Matricula 23102474
 * Francisco Castro Menezes de Freitas | Matricula 23103208
 * 
 *
/**
 * Classe SellApp representa um aplicativo para venda de passagens aéreas.
 *
 *
 * Método principal do aplicativo SellApp.
 * @param args argumentos de linha de comando.
 * @throws Exception se ocorrer um erro durante a execução do programa.
*/
public class SellApp{
    public static void main(String[] args) throws Exception{
        System.out.print("Bem vindos a compra de passagens aereas! Seu voo parte hoje dia: ");
        Date atualDate = new Date();
        //mostra na tela a data atual formatada em pt-br
        
        System.out.println("Para realizar sua compra primeiramente precisamos fazer um cadastro.");

        Scanner sc = new Scanner(System.in);
        Buyer person1 = new Buyer();
        
        if(person1.Buyer() == false){
            System.out.println("\nDigite [exit] para sair:");
            if(sc.next().equals("exit")){
                System.exit(0);    
            }
        }
        //verifica se a pessoa comprando já tem cadastro
        
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
        //mostra as opçoes de voo disponiveis
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
        //verifica se o usuário escolheu um destino válido

        AirPlane flight = new AirPlane(city);
        String filename = city.replace(" ", "") + ".txt";

        File file = new File(filename);
        
        if (file.exists()) {
            flight.read();
        }
        //verifica se o arquivo com o nome destino do voo ja existe

        System.out.println("Seu destino é "+ city +". Quantos assentos gostaria de comprar?\n*Na compra de 5 ou mais passagens você ganha 10% de desconto*");
        int quant = sc.nextInt();
        boolean discount = false;

        if(quant > 4)
        {
            discount = true;
        }
        //verifica se o desconto de 5 ou mais vendas está ativo
        
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

        if (discount == true) {
            price = price - (price * 10 / 100); //aplica do desconto de 10%
        }

        flight.print();
        System.out.printf("\nVALOR A PAGAR: R$ %.2f\n", price);
        System.out.println("\nPara finalizar sua compra nesse voo digite [exit]:");
        String secret = sc.next(); 
        
        if(secret.equals("talvez")){
            flight.clear(); //comando secreto "talvez" para limpar o arquivo do disco com o nome do voo
        }
        
        flight.save();
        person1.save();
    }
}
