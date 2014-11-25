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
    List<Double> fluxoCaixa;

    public GeneratorReport(double VPL, double TIR, double TMA, List<Double> fluxoCaixa) {
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
        createFolder ();
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

        pdf.addTitle("RELATÓRIO DE ANÁLISE FINANCEIRA\n\n");

        pdf.addText("Com base nos dados da quadro fluxo financeiro, temos o seguinte fluxo de caixa representado pelo gráfico de barras abaixo:");

        pdf.addChart(barChart.getChart());

        pdf.addText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        String s1 = "O valor presente líquido do investimento (VPL) calculado é de " + VPL;
        String s2 = "A taxa interna de retorno do investimento (TIR) calculada é de " + TIR + "%";
        String s3 = "A taxa mínima de atratividade (TMA) requerida pela empresa é de " + TMA + "%";
        pdf.addList(s1, s2, s3);
        if (isViable()) {
            pdf.addText("\nLogo, sabendo que a TIR é maior ou igual à TMA e o VPL é maior ou igual a zero, chegamos a conclusão que:");
            pdf.addTitle("\nO investimento é viável");
        } else {
            pdf.addText("\nLogo, sabendo que a TIR é menor que à TMA e o VPL é menor que zero, chegamos a conclusão que:");
            pdf.addTitle("\nO investimento não é viável");
        }

        pdf.addText("\n\n\n\n\n\n");
        pdf.addDate(new Date());

        pdf.closeDocument();

        pdf.openPDF();
    }

    public void createFolder() {
        File theDir = new File("C:\\Reports");

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            try {
                theDir.mkdir();
            } catch (SecurityException se) {
                //handle it
            }
        }
    }

//    public static void main(String[] args) {
//        List<Double> l = new ArrayList<>();
//        l.add(50.00);
//        l.add(50.00);
//        l.add(10.00);
//        l.add(50.00);
//        l.add(50.00);
//        GeneratorReport rep = new GeneratorReport(0.2, 13.0, 12.0, l);
//        rep.getReport();
//
//    }
}
