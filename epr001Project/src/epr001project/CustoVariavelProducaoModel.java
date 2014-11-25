
package epr001project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author leoam14
 */
public class CustoVariavelProducaoModel extends AbstractTableModel{
    public int anos = 1;
    public int rows = 9;
    
    public List<Double> materiaPrima = new ArrayList<Double>();
    public List<String> nomesColunas = new ArrayList<String>();
    public List<Double> energiaEletrica = new ArrayList<Double>();
    public List<Double> combustivel = new ArrayList<Double>();
    public List<Double> frete = new ArrayList<Double>();
    public List<Double> agua = new ArrayList<Double>();
    public List<Double> embalagens = new ArrayList<Double>();
    public List<Double> outros = new ArrayList<Double>();
    public List<Double> eventuais = new ArrayList<Double>();
    public List<Double> total = new ArrayList<Double>();
    
    String[] columns = {};
    String[] rowsNames = {"Matéria Prima","Energia Elétrica","Combustível","Frete","Água","Embalagens","Outros","Eventuais","Total"};
    
    Object[][] data = {};
    
    public CustoVariavelProducaoModel() {
    inicializar();
    
    }
    
    public int getAnos() {
        return anos;
    }

    public void setAnos(int ano) {
        this.anos = ano;
        inicializar();
    }
    
    public Boolean atualizarVariaveis(){
        try{
            materiaPrima = Arrays.<Double>asList((Double[])data[0][0]);
            energiaEletrica = Arrays.<Double>asList((Double[])data[1][0]);
            combustivel = Arrays.<Double>asList((Double[])data[2][0]);
            frete = Arrays.<Double>asList((Double[])data[3][0]);
            agua = Arrays.<Double>asList((Double[])data[4][0]);
            embalagens = Arrays.<Double>asList((Double[])data[5][0]);
            outros = Arrays.<Double>asList((Double[])data[6][0]);
            eventuais = Arrays.<Double>asList((Double[])data[7][0]);
            
            
            calculaValores();
            updateData();
        }catch(Exception e){
        return false;
        }
      return true;
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        ((Object[])(data[rowIndex][0]))[columnIndex-1] = Double.parseDouble((String)aValue);
    }
    
    public Boolean calculaValores(){
        
        for(int i=0;i<total.size();i++)
        {
        total.set(i, materiaPrima.get(i)+energiaEletrica.get(i)+combustivel.get(i)+frete.get(i)+agua.get(i)+embalagens.get(i)+outros.get(i)+outros.get(i)+eventuais.get(i));
        }
        updateData();
        return (true);
    }
    
    public void inicializar(){
        Double d = new Double(0);
        nomesColunas.add("");
        for(int i=0; i <= anos; i++){
            nomesColunas.add(i+"");
            materiaPrima.add(d);
            energiaEletrica.add(d);
            combustivel.add(d);
            frete.add(d);
            agua.add(d);
            embalagens.add(d);
            outros.add(d);
            eventuais.add(d);
            total.add(d);
            
        }
       updateData();
       columns = nomesColunas.toArray(new String[0]);
    }
    
    public void updateData(){
        data = new Object[][]{
            {materiaPrima.toArray(new Double[0])},
            {energiaEletrica.toArray(new Double[0])},
            {combustivel.toArray(new Double[0])},
            {frete.toArray(new Double[0])},
            {agua.toArray(new Double[0])},
            {embalagens.toArray(new Double[0])},
            {outros.toArray(new Double[0])},
            {eventuais.toArray(new Double[0])},
            {total.toArray(new Double[0])}
            
        };   
    }
    
    public boolean isCellEditable(int rowIndex,
                     int columnIndex){
    if(columnIndex != 0)
        return true;
    else
        return false;
    }
    
    public List<Double> getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(List<Double> materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public List<Double> getImpostoProp() {
        return energiaEletrica;
    }

    public void setImpostoProp(List<Double> impostoProp) {
        this.energiaEletrica = impostoProp;
    }

    public List<Double> getReceitaLiquida() {
        return combustivel;
    }

    public void setReceitaLiquida(List<Double> receitaLiquida) {
        this.combustivel = receitaLiquida;
    }

    public List<Double> getCustoVarProd() {
        return frete;
    }

    public void setCustoVarProd(List<Double> custoVarProd) {
        this.frete = custoVarProd;
    }

    public List<Double> getCustoFixProd() {
        return agua;
    }

    public void setCustoFixProd(List<Double> custoFixProd) {
        this.agua = custoFixProd;
    }

    public List<Double> getLucroBruto() {
        return embalagens;
    }

    public void setLucroBruto(List<Double> lucroBruto) {
        this.embalagens = lucroBruto;
    }

    public List<Double> getDespGerVar() {
        return outros;
    }

    public void setDespGerVar(List<Double> despGerVar) {
        this.outros = despGerVar;
    }

    public List<Double> getDespGerFix() {
        return eventuais;
    }

    public void setDespGerFix(List<Double> despGerFix) {
        this.eventuais = despGerFix;
    }

    @Override
    public int getRowCount() {
        return data.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return anos+2; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex>=1)
            return ((Object[])(data[rowIndex][0]))[columnIndex-1];
        else
            if(rowsNames.length>rowIndex)
                return rowsNames[rowIndex];
            else
                return "";
    }
    
    
}


