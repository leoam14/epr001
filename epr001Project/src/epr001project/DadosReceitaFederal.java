package epr001project;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

public class DadosReceitaFederal {

    int year = Calendar.getInstance().get(Calendar.YEAR);
    int month = Calendar.getInstance().get(Calendar.MONTH);
    int day = Calendar.getInstance().get(Calendar.DATE);
    String currentCelicTax = "";
    String currentMonth = "";
    String[] months = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    String url = "http://www.receita.fazenda.gov.br/pagamentos/jrselic.htm#Taxa_de_Juros_Selic";
    Document document = Jsoup.connect(url).get();
    double taxaCelic;

    public DadosReceitaFederal() throws IOException {
        currentMonth = months[month];

        Calendar c = Calendar.getInstance();
        c.set(year, month, 1, 0, 0);
        Date beginOfMonth = c.getTime();

        Calendar c2 = Calendar.getInstance();
        c2.set(year, month, day, 0, 0);
        Date current = c2.getTime();

        if (current.after(beginOfMonth)) {
            currentCelicTax = months[month - 1].toLowerCase();
        }

        String celicTaxValue = document.select("table tr:eq(" + month + ")").text();

        String values = celicTaxValue.split(currentCelicTax)[0];

        String[] lastValue = values.split(" ");
        String strTax = lastValue[lastValue.length - 1].substring(0, 4);

        strTax = strTax.replace(",", ".");
        Double finalTax = Double.parseDouble(strTax);
        
        setTaxaCelic(finalTax);
        
    }

    public void setTaxaCelic(double taxaCelic) {
        this.taxaCelic = taxaCelic;
    }

    public double getTaxaCelic() {
        return taxaCelic;
    }
    

}
