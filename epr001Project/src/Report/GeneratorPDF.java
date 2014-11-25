package Report;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.JFreeChart;

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
    
    public void addDate (Date date){
        try {
            String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
            document.add(new Paragraph("\n\nRelatório gerada em: " + newstring));
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

    public void addChart(JFreeChart chart) {
        try {
            //add image
            int width = 300;
            int height = 300;
            BufferedImage bufferedImage = chart.createBufferedImage(width, height);
            Image image = Image.getInstance(writer, bufferedImage, 1.0f);
            document.add(image);
        } catch (IOException | DocumentException e) {
        }
    }
}
