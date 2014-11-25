package Report;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.JFreeChart;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;

/**
 *
 * @author Alison Augusto
 */
public class GeneratorPDF {

    private Document document = null;
    private PdfWriter writer = null;
    private final OutputStream outputStream;

    public GeneratorPDF(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void openDocument() {
        document = new Document();
        try {
            writer = PdfWriter.getInstance(document, outputStream);
        } catch (DocumentException ex) {
            Logger.getLogger(GeneratorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.open();
    }

    public void closeDocument() {
        document.close();
        document = null;
        writer.close();
        writer = null;
    }

    public void addDate(Date date) {
        try {
            int h = date.getHours();
            int m = date.getMinutes();
            String time = h+":"+m;
            String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
            Paragraph p = new Paragraph("\n\nRelatório gerado em " + newstring + " às " + time);
            p.setAlignment(Element.ALIGN_RIGHT);
            document.add(p);
        } catch (DocumentException ex) {
            Logger.getLogger(GeneratorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addList(String s1, String s2, String s3) {
        List unorderedList = new List(List.UNORDERED);
        unorderedList.add(new ListItem(s1));
        unorderedList.add(new ListItem(s2));
        unorderedList.add(new ListItem(s3));

        try {
            document.add(unorderedList);
        } catch (DocumentException ex) {
            Logger.getLogger(GeneratorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addText(String text) {
        try {
            document.add(new Paragraph(text));
        } catch (DocumentException ex) {
            Logger.getLogger(GeneratorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTitle(String title) {
        try {
            Font fontbold = FontFactory.getFont("Times-Roman", 18, Font.BOLD);
            Paragraph p = new Paragraph(title, fontbold);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
        } catch (DocumentException ex) {
            Logger.getLogger(GeneratorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addChart(JFreeChart chart) {
        try {
            //add image
            int width = 300;
            int height = 300;
            BufferedImage bufferedImage = chart.createBufferedImage(width, height);
            Image image = Image.getInstance(writer, bufferedImage, 1.0f);
            image.setAbsolutePosition(150, 400);
            document.add(image);
        } catch (IOException | DocumentException e) {
        }
    }

    public void savePDF() {

    }

    public void openPDF() {
        try {
            if ((new File("C:\\Reports\\Relatório Financeiro.pdf")).exists()) {

                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler C:\\Reports\\Relatório Financeiro.pdf");
                p.waitFor();

            } else {

                System.out.println("File is not exists");

            }

            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
