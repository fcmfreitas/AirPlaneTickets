import java.time.LocalDate;
import java.util.Locale;


public class Date{
    public Date(){
        Locale.setDefault(new Locale("pt", "BR"));
        //String dataCompra = "";
        LocalDate dataDaCompra = LocalDate.now();
        //dataCompra += dataDaCompra;
        
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