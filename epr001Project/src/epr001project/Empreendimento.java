package epr001project;

import Report.GeneratorReport;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author leoam14
 */
public class Empreendimento extends javax.swing.JPanel {

    /**
     * Creates new form Empreendimento
     */
    JFrame j;
    public Empreendimento(JFrame j) {
        initComponents();
        Data.getData().dadosModel.calculaValores();
        Data.getData().dadosModel.updateData();
        this.j = j;
//        DadosModel dataTable = new DadosModel();
//        JTable tabela = new JTable(dataTable);
//        JScrollPane scroll = new JScrollPane();
//        scroll.add(tabela);
//        scroll.setSize(500,500);
//        this.add(scroll);
        
        final JFrame frame = new JFrame("Tabela do Empreendimento");
        
        JTable table = new JTable(Data.getData().dadosModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.add(table.getTableHeader());
        table.setFillsViewportHeight(false);
 
        Data.getData().dadosModel.addTableModelListener(
        new TableModelListener() 
        {
            public void tableChanged(TableModelEvent evt) 
            {
                Data.getData().dadosModel.atualizarVariaveis();
            }
        });
        
        JLabel lblHeading = new JLabel("Empreendimento");
        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));
        JButton calcular = new JButton("Calcular");
        calcular.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(table.getCellEditor()!=null)
                table.getCellEditor().stopCellEditing();
                Data.getData().dadosModel.atualizarVariaveis();
                Double taxaSelic = new Double(0);
                Double vpl = new Double(0);
                Double tir = new Double(0);
                
                try {
                    DadosReceitaFederal taxa = new DadosReceitaFederal();
                    taxaSelic = taxa.getTaxaCelic();
                    taxaSelic = Math.pow((1+taxaSelic/100),12)-1;
                    taxaSelic*=100;
                    vpl = Epr001Finance.VPL(Data.getData().dadosModel.getFluxoCaixa(), taxaSelic);
                    tir = Epr001Finance.TIR(Data.getData().dadosModel.getFluxoCaixa(), taxaSelic);
                    GeneratorReport rep = new GeneratorReport(vpl,tir,taxaSelic,Data.getData().dadosModel.getFluxoCaixa());
                    rep.getReport();
                } catch (IOException ex) {
                    Logger.getLogger(Empreendimento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        this.setLayout(new BorderLayout());
 
        this.add(lblHeading,BorderLayout.NORTH);
        this.add(calcular,BorderLayout.SOUTH);
        this.add(scrollPane,BorderLayout.CENTER);
 
        
        this.setSize(550, 200);
        this.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1304, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
