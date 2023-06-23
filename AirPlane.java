import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileInputStream;
/**
 * Fernando Flores Cabral Neto | Matricula 23102305
 * Leonardo Chiao Andreucci | Matricula 23102474
 * Francisco Castro Menezes de Freitas | Matricula 23103208
 * 
 *
 *
 * Classe AirPlane representa um avião com assentos para venda de passagens.
 */
public class AirPlane{
    private boolean seats[][];
    private String city;
    private double price;
    /**
     * Construtor da classe AirPlane.
     * @param destination o destino do avião.
     */
    public AirPlane(String destiny){
        this.city = destiny;
        this.seats = new boolean[10][4];
    }
    /**
     * Retorna o preço da passagem com base no destino do avião.
     * @return o preço da passagem.
     */
    public double price(){
        if(this.city.equals("Salvador")){
            this.price = 3100.00;
        }else if(this.city.equals("Rio de Janeiro")){
            this.price = 1999.99;
        }else if(this.city.equals("São Paulo")){
            this.price = 1750.50;
        }
        return this.price;
    }
    /**
     * Vende um assento no avião.
     * @param ticket a representação do assento a ser vendido (exemplo: A1, B2, C3, D4).
     * @return true se o assento foi vendido com sucesso, false se o assento já está ocupado.
     */

    public boolean sell(String ticket){

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
        if (this.seats[line][column] == true) {

            System.out.println("O assento escolhido está ocupado, escolha outro lugar:");

            return false;
        } else {
            this.seats[line][column] = true;
            return true;
        }

    }
    /**
     * Imprime a disposição dos assentos no avião.
     */
    public void print(){
        System.out.println("    A  B  C  D");
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
     /**
     * Salva o estado dos assentos do avião em um arquivo.
     * @throws Exception se ocorrer um erro ao salvar o arquivo.
     */
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
    /**
     * Lê o estado dos assentos do avião de um arquivo.
     * @throws Exception se ocorrer um erro ao ler o arquivo.
     */
    public void read() throws Exception {
        String filename = this.city.replace(" ", "");
        FileInputStream file = new FileInputStream(filename+".txt");

        Scanner sc = new Scanner(file);

        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {            
                this.seats[i][j] = sc.nextBoolean();
            }
        }

        sc.close();
        file.close();
    }
    /**
     * Limpa o estado dos assentos do avião, marcando todos como desocupados.
     */
    public void clear(){
        for(int i = 0; i <= 9; i++){
            for(int j = 0; j <= 3; j++){
                this.seats[i][j] = false;
            }
        }
    }
}