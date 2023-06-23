import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileInputStream;

/**
 * Fernando Flores Cabral Neto | Matricula 23102305
 * Leonardo Chiao Andreucci | Matricula 23102474
 * Francisco Castro Menezes de Freitas | Matricula 23103208
 * Classe Buyer representa um comprador de passagens aéreas.
 */
public class Buyer{
    private String name;
    private String cpf;
    private String p_destiny;
    /**
     * Realiza o cadastro do comprador.
     * @return true se o cadastro foi concluído com sucesso, false se o comprador já possui cadastro.
     */
    public boolean Buyer(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome completo:");
        String name = sc.nextLine();

        String filename = name.replace(" ", "");
        File file = new File(filename + ".txt");
        if (file.exists()) {
            System.out.println("Notamos que você já possui cadastro e passagens compradas, obrigado pela confiança!");
            return false;
        } else{
            System.out.println("Digite seu cpf:");
            String cpf = sc.next();
            boolean a = false;
            while(a == false){
                if(cpf.length() == 11){
                    a = true;
                    for(int i = 0; i <= 10; i++){
                        String test = "1234567890";
                        String letter = cpf.charAt(i)+"";
                        if(!test.contains(letter)){
                            System.out.println("O cpf só pode conter números, tente novamente:");
                            a = false;
                            i = 100;
                            cpf = sc.next();
                        }
                    }
                } else if(cpf.length() < 11 || cpf.length() > 11){
                    System.out.println("Esse cpf não existe, tente novamente:");
                    cpf = sc.next();
                }
            }
            
            this.name = name;
            this.cpf = cpf;
            return true;
        }
    }
    
    public void destiny(String a){
        this.p_destiny = a;
    }
    
    public void save() throws Exception{
        String filename = this.name.replace(" ", "");
        PrintStream file = new PrintStream(filename+".txt");
        file.println(this.name+"\n"+this.cpf);
        file.close();
    }

    
}