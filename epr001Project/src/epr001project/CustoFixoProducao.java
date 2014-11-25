/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epr001project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author leoam14
 */
public class CustoFixoProducao extends javax.swing.JPanel {

    /**
     * Creates new form CustoFixoProducao
     */
    CustoFixoProducao pt = this;
    JFrame j;
    
    public void salvarAlteracoes(){
            Data.getData().custoFixoProducao.atualizarVariaveis();
            Data.getData().dadosModel.setCustoFixProd(Data.getData().custoFixoProducao.total);
            }
    
    public CustoFixoProducao(JFrame j) {
        initComponents();
        this.j = j;
        final JFrame frame = new JFrame("Beginner");
        
        JTable table = new JTable(Data.getData().custoFixoProducao);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        JLabel lblHeading = new JLabel("Custo Fixo de Produção");
        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));
        JButton next = new JButton("Next");
        next.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                salvarAlteracoes();
                JFrame fAdvanced = new JFrame();
                DespGeralVar cfp = new DespGeralVar(fAdvanced);
                fAdvanced.setSize(800, 800);
                fAdvanced.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                fAdvanced.add(cfp);
                fAdvanced.setLocationRelativeTo(pt);
                fAdvanced.setVisible(true);
                j.setVisible(false);
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
 
        this.add(lblHeading,BorderLayout.PAGE_START);
        this.add(next,BorderLayout.SOUTH);
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
