import java.time.LocalDate;
/**
 * Mostra a data em que a compra foi feita e consequentemente a data do voo. 
 * @param dataDaCompra usa o Metodo LocalDate, para pegar o dia (sem horario) em que o voo parte. Porem no formato da lingua inglesa(YYYY/MM/DD).
 * foi necessario importar o pacote java.time e usar o a funcao .now() que ultiliza como base o computador em que o programa esta sendo rodado.
 * @param date String que recebe dataDaCompra, para permitir que o formato passe para o portugues.
 * @param day String que recebe, de acordo com o charAt de date, o dia da compra e do voo.
 * @param month String que recebe, de acordo com o charAt de date, o mes da compra e do voo.
 * @param year String que recebe, de acordo com o charAt de date, o ano da compra e do voo.
 */


public class Date{
    public Date(){
        LocalDate dataDaCompra = LocalDate.now();
        String date = dataDaCompra.toString();

        String day = "";
        String month = "";
        String year = "";

        day = day + date.charAt(8) + date.charAt(9);
        month = month + date.charAt(5) + date.charAt(6);
        year = year + date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3);

        System.out.println(day+"/"+month+"/"+year);
    }
}