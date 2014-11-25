package Report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Alison Augusto
 */
public class GeneratorReport {

    private final double VPL;
    private final double TIR;
    private final double TMA;
    List <Double> fluxoCaixa;

    public GeneratorReport(double VPL, double TIR, double TMA, List <Double> fluxoCaixa) {
        this.fluxoCaixa = fluxoCaixa;
        this.TIR = TIR;
        this.VPL = VPL;
        this.TMA = TMA;
    }

    public boolean isViable() {
        if (TIR >= TMA && VPL >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void getReport() {
        final BarChart barChart = new BarChart("Fluxo de Caixa", fluxoCaixa);
        barChart.pack();
        RefineryUtilities.centerFrameOnScreen(barChart);
        barChart.setVisible(true);

        GeneratorPDF pdf = null;
        try {
            pdf = new GeneratorPDF(new FileOutputStream(
                    new File("C:\\Reports\\Relatório Financeiro.pdf")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeneratorReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        pdf.openDocument();
        
        pdf.addChart(barChart.getChart());
        
        pdf.addText ("VPL = "+VPL);
        pdf.addText ("TIR = "+TIR+"%");
        pdf.addText ("TMA = "+TMA+"%");
        if (isViable()){
            pdf.addText ("\nTIR >= TMA e VPL >= 0, logo:");
            pdf.addText("O investimento é viável");
        }else{
            pdf.addText ("TIR < TMA e VPL <0, logo:");
            pdf.addText("O investimento não é viável");
        }
        
        pdf.addDate(new Date());

        pdf.closeDocument();
    }
    
    public static void main(String[] args) {
        List<Double> l = new ArrayList<>();
        l.add(50.00);
        l.add(50.00);
        l.add(10.00);
        l.add(50.00);
        l.add(50.00);
        GeneratorReport rep = new GeneratorReport(0.2, 13.0, 12.0, l);
        rep.getReport();
    }
}
