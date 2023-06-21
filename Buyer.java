import java.util.Scanner;

public class Buyer{
    private String name;
    private String cpf;
    
    public Buyer(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite seu nome completo:");
        String name = sc.nextLine();
        
        System.out.println("Digite seu cpf:");
        String cpf = sc.next();
        boolean a = false;
        while(a == false){
            if(cpf.length() == 11){
                a = true;
            } else if(cpf.length() < 11 || cpf.length() > 11){
                System.out.println("Esse cpf nao existe, tente novamente:");
                cpf = sc.next();
            } else {
                for(int i = 0; i != 10; i++){
                    String test = "1234567890";
                    String letter = cpf.charAt(i)+"";
                    if(!test.contains(letter)){
                        a = false;
                        i = 11;
                    }
                }
                if(a == false){
                    System.out.println("O cpf so pode conter numeros, digite novamente:");
                }
            }
        }
        
        
        this.name = name;
        this.cpf = cpf;
    }
}