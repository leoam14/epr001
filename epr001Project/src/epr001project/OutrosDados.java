/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epr001project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author leoam14
 */
public class OutrosDados extends javax.swing.JPanel {

    /**
     * Creates new form OutrosDados
     */
    OutrosDados pt = this;
    JFrame j;
    
    
     public void salvarAlteracoes(){
            Data.getData().outrosDados.atualizarVariaveis();
            Data.getData().dadosModel.setReceitaBruta(Data.getData().outrosDados.elem1);
            Data.getData().dadosModel.setDespFinanceiras(Data.getData().outrosDados.elem2);
            Data.getData().dadosModel.setResVendAtivo(Data.getData().outrosDados.elem3);
            Data.getData().dadosModel.setAmort(Data.getData().outrosDados.elem4);
            Data.getData().dadosModel.setInvestimento(Data.getData().outrosDados.elem5);
            Data.getData().dadosModel.setLiberaFinanciamento(Data.getData().outrosDados.elem6);
            Data.getData().dadosModel.setIrEContribSocial(Data.getData().outrosDados.elem7);
            Data.getData().dadosModel.setValorResidual(Data.getData().outrosDados.elem8);
            Data.getData().dadosModel.updateData();
            }
     
    public OutrosDados(JFrame j) {
        initComponents();
        this.j = j;
        final JFrame frame = new JFrame("Passo-a-Passo");
        JTable table = new JTable(Data.getData().outrosDados);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(false);
        
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2, 1));
        
        JTextArea label = new JTextArea("Receita Bruta:\n" +
"	A receita bruta compreende o produto da venda de bens nas operações de conta própria, o preço dos serviços prestados e o resultado auferido na operações de conta alheia, excluídas as vendas canceladas, as devoluções de vendas, os descontos incondicionais concedidos e os impostos não cumulativos cobrados, destacadamente do comprador ou contratante, e dos quais o vendedor dos bens ou prestador dos serviços seja mero depositário.\n" +
"\n" +
"Despesas Financeiras:\n" +
"	Referem-se aos juros de financiamentos de médio e longo prazos e podem ser abatidas para efeito de Imposto de Renda.\n" +
"\n" +
"Resultado de Venda de Ativo:\n" +
"	Como o próprio nome diz, é o resultado da venda de prováveis benefícios econômicos futuros obtidos ou controlado por uma entidade em particular como um resultado de transações ou eventos passados.\n" +
"\n" +
"Amortecimento:\n" +
"	É um processo de extinção de uma dívida através de pagamentos periódicos, que são realizados em função de um planejamento, de modo que cada prestação corresponde à soma do reembolso do capital ou do pagamento dos juros do saldo devedor, podendo ser o reembolso de ambos, sendo que os juros são sempre calculados sobre o saldo devedor. \n" +
"\n" +
"Investimentos:\n" +
"	Gasto ativado em função de sua vida útil ou de benefícios atribuíveis a futuros períodos. \n" +
"\n" +
"Liberação Financeira:\n" +
"	É a liberação de parte ou todo o montante por parte da instituição financeira que concede o empréstimo.");
        JScrollPane scroll = new JScrollPane(label,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        label.setFont(new Font("Serif", Font.ITALIC, 16));
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setEnabled(false);
        label.setDisabledTextColor(Color.BLACK);
        centro.add(scrollPane);
        centro.add(scroll);
        
        
        JLabel lblHeading = new JLabel("Dados Adicionais");
        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));
        JPanel rodape = new JPanel();
        JButton next = new JButton("Próximo");
        next.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                 if(table.getCellEditor()!=null)
                table.getCellEditor().stopCellEditing();
                salvarAlteracoes();
                JFrame fAdvanced = new JFrame();
                Empreendimento cfp = new Empreendimento(fAdvanced);
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
        JButton back = new JButton("Voltar");
        back.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(table.getCellEditor()!=null)
                table.getCellEditor().stopCellEditing();
                salvarAlteracoes();
                JFrame fAdvanced = new JFrame();
                Depreciacao cfp = new Depreciacao(fAdvanced);
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
        
        JButton finish = new JButton("Terminar");
        finish.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(table.getCellEditor()!=null)
                table.getCellEditor().stopCellEditing();
                salvarAlteracoes();
                JFrame fAdvanced = new JFrame();
                Empreendimento cfp = new Empreendimento(fAdvanced);
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
        rodape.setLayout(new BorderLayout());
        rodape.add(next,BorderLayout.EAST);
        rodape.add(back,BorderLayout.WEST);
        rodape.add(finish,BorderLayout.CENTER);
        
        
        
        this.setLayout(new BorderLayout());
        this.add(rodape,BorderLayout.PAGE_END);
        this.add(lblHeading,BorderLayout.PAGE_START);
        this.add(centro,BorderLayout.CENTER);
 
        
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
