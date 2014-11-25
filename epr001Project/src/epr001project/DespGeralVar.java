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
public class DespGeralVar extends javax.swing.JPanel {

    /**
     * Creates new form DespGeralVar
     */
    DespGeralVar pt =this;
    JFrame j;
    
    public void salvarAlteracoes(){
            Data.getData().despGeralVar.atualizarVariaveis();
            Data.getData().dadosModel.setDespGerVar(Data.getData().despGeralVar.total);
            Data.getData().dadosModel.updateData();
            }
    
    public DespGeralVar(JFrame j) {
        initComponents();
        this.j = j;
        final JFrame frame = new JFrame("Passo-a-Passo");
        
        JTable table = new JTable(Data.getData().despGeralVar);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(false);
        
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2, 1));
        JTextArea label = new JTextArea("Despesas gerais variáveis\n" +
"	As Despesas Gerais são aquelas que, mesmo importantes para a operação não fazem parte da fabricação de um produto. \n" +
"	As Despesas Gerais Variáveis são considerados :\n" +
"	--> Comissão de vendedores;\n" +
"	--> Desconto de Duplicatas;  \n" +
"	Commisão de Vendas: 2% da Receita (sem IPI).\n" +
"	Outros: adiciona-se nesse campo todas as despesas variáveis não listados acima. \n" +
"	Eventuais : 2% para eventuais despesas.	");
        label.setFont(new Font("Serif", Font.ITALIC, 16));
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setEnabled(false);
        label.setDisabledTextColor(Color.BLACK);
        centro.add(scrollPane);
        centro.add(label);
        
        JLabel lblHeading = new JLabel("Despesa Geral Variável");
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
                DespGeralFixa cfp = new DespGeralFixa(fAdvanced);
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
                CustoFixoProducao cfp = new CustoFixoProducao(fAdvanced);
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
