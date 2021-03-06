
package epr001project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author leoam14
 */
public class DespGeralFixaModel extends AbstractTableModel{
    public int anos = 1;
    public int rows = 9;
    
    public List<Double> elem1 = new ArrayList<Double>();
    public List<String> nomesColunas = new ArrayList<String>();
    public List<Double> elem2 = new ArrayList<Double>();
    public List<Double> elem3 = new ArrayList<Double>();
    public List<Double> total = new ArrayList<Double>();
    
    
    String[] columns = {};
    String[] rowsNames = {"Despesas Administrativas","Outros","Eventuais"};
    
    Object[][] data = {};
    
    public DespGeralFixaModel() {
    inicializar();
    
    }
    
    public int getAnos() {
        return anos;
    }

    public void limparDados(){
     elem1 = new ArrayList<Double>();
     nomesColunas = new ArrayList<String>();
     elem2 = new ArrayList<Double>();
     elem3 = new ArrayList<Double>();
     total = new ArrayList<Double>();
    }
    
    public void setAnos(int ano) {
        this.anos = ano;
        inicializar();
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    public Boolean atualizarVariaveis(){
        try{
            elem1 = Arrays.<Double>asList((Double[])data[0][0]);
            elem2 = Arrays.<Double>asList((Double[])data[1][0]);
            elem3 = Arrays.<Double>asList((Double[])data[2][0]);
            
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
        total.set(i, elem1.get(i)+elem2.get(i)+elem3.get(i));
        }
        updateData();
        return (true);
    }
    
    public void inicializar(){
        limparDados();
        Double d = new Double(0);
        nomesColunas.add("");
        for(int i=0; i <= anos; i++){
            nomesColunas.add(i+"");
            elem1.add(d);
            elem2.add(d);
            elem3.add(d);
            
           
            total.add(d);
            
        }
       updateData();
       columns = nomesColunas.toArray(new String[0]);
    }
    
    public void updateData(){
        data = new Object[][]{
            {elem1.toArray(new Double[0])},
            {elem2.toArray(new Double[0])},
            {elem3.toArray(new Double[0])}
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
        return elem1;
    }

    public void setMateriaPrima(List<Double> materiaPrima) {
        this.elem1 = materiaPrima;
    }

    public List<Double> getImpostoProp() {
        return elem2;
    }

    public void setImpostoProp(List<Double> impostoProp) {
        this.elem2 = impostoProp;
    }

    public List<Double> getReceitaLiquida() {
        return elem3;
    }

    public void setReceitaLiquida(List<Double> receitaLiquida) {
        this.elem3 = receitaLiquida;
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


