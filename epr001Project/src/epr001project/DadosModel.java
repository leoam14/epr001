/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epr001project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author leoam14
 */
public class DadosModel extends AbstractTableModel{
    public int anos = 1;
    public int rows = 19;
    
    public List<Double> receitaBruta = new ArrayList<Double>();
    public List<String> nomesColunas = new ArrayList<String>();
    public List<Double> impostoProp = new ArrayList<Double>();
    public List<Double> receitaLiquida = new ArrayList<Double>();
    public List<Double> custoVarProd = new ArrayList<Double>();
    public List<Double> custoFixProd = new ArrayList<Double>();
    public List<Double> lucroBruto = new ArrayList<Double>();
    public List<Double> despGerVar = new ArrayList<Double>();
    public List<Double> despGerFix = new ArrayList<Double>();
    public List<Double> depreciacao = new ArrayList<Double>();
    public List<Double> despFinanceiras = new ArrayList<Double>();
    public List<Double> lucroOperacional = new ArrayList<Double>();
    public List<Double> resVendAtivo = new ArrayList<Double>();
    public List<Double> lucroAntesIR = new ArrayList<Double>();
    public List<Double> irEContribSocial = new ArrayList<Double>();
    public List<Double> lucroAposIR = new ArrayList<Double>();
    public List<Double> vendaDeAtivo = new ArrayList<Double>();
    public List<Double> amort = new ArrayList<Double>();
    public List<Double> investimento = new ArrayList<Double>();
    public List<Double> liberaFinanciamento = new ArrayList<Double>();
    public List<Double> valorResidual = new ArrayList<Double>();
    public List<Double> fluxoCaixa = new ArrayList<Double>();
    
    String[] columns = {};
    String[] rowsNames = {"Receita Bruta","Imposto Prop.","Receita Líquida","Custo Var. Prod.",
                          "Custo Fix. Prod.","Lucro Bruto","Desp Gerais Var.","Desp Gerais Fix.",
                          "Depreciação","Desp. Finan.","Lucro Opera.","Resíduo de Venda","Lucro Antes IR",
                          "IR//Cont. Social","Lucro Após IR","Depreciação","Venda de Ativo","Amortecimento","Investimento","Lib. Finan.",
                          "Valor Residual","Fluxo de Caixa"};
    
    Object[][] data = {};
    
    public DadosModel() {
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
            receitaBruta = Arrays.<Double>asList((Double[])data[0][0]);
            impostoProp = Arrays.<Double>asList((Double[])data[1][0]);
            receitaLiquida = Arrays.<Double>asList((Double[])data[2][0]);
            custoVarProd = Arrays.<Double>asList((Double[])data[3][0]);
            custoFixProd = Arrays.<Double>asList((Double[])data[4][0]);
            lucroBruto = Arrays.<Double>asList((Double[])data[5][0]);
            despGerVar = Arrays.<Double>asList((Double[])data[6][0]);
            despGerFix = Arrays.<Double>asList((Double[])data[7][0]);
            depreciacao = Arrays.<Double>asList((Double[])data[8][0]);
            despFinanceiras = Arrays.<Double>asList((Double[])data[9][0]);
            lucroOperacional = Arrays.<Double>asList((Double[])data[10][0]);
            resVendAtivo = Arrays.<Double>asList((Double[])data[11][0]);
            lucroAntesIR = Arrays.<Double>asList((Double[])data[12][0]);
            irEContribSocial = Arrays.<Double>asList((Double[])data[13][0]);
            lucroAposIR = Arrays.<Double>asList((Double[])data[14][0]);
            vendaDeAtivo = Arrays.<Double>asList((Double[])data[16][0]);
            amort = Arrays.<Double>asList((Double[])data[17][0]);
            investimento = Arrays.<Double>asList((Double[])data[18][0]);
            liberaFinanciamento = Arrays.<Double>asList((Double[])data[19][0]);
            valorResidual = Arrays.<Double>asList((Double[])data[20][0]);
            fluxoCaixa = Arrays.<Double>asList((Double[])data[21][0]);
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
    
    public Boolean calculaReceitaLiquida(){
        if(receitaLiquida.size()>0){
            for(int i=0; i< receitaLiquida.size(); i++){
                receitaLiquida.set(i,receitaBruta.get(i)-impostoProp.get(i));
            }
        }
        return true;
    }
    
    public Boolean calculaLucroBruto(){
        if(lucroBruto.size()>0){
            for(int i=0; i< lucroBruto.size(); i++){
                lucroBruto.set(i,receitaLiquida.get(i)-custoVarProd.get(i)-custoFixProd.get(i));
            }
        }
        return true;
    }
    
    public Boolean calculaLucroOperacional(){
        if(lucroOperacional.size()>0){
            for(int i=0; i< lucroOperacional.size(); i++){
                lucroOperacional.set(i,lucroBruto.get(i)-despGerVar.get(i)-despGerFix.get(i)-depreciacao.get(i)-despFinanceiras.get(i));
            }
        }
        return true;
    }
    
    public Boolean calculaLucroAntesIR(){
        if(lucroAntesIR.size()>0){
            for(int i=0; i< lucroAntesIR.size(); i++){
                lucroAntesIR.set(i,lucroOperacional.get(i)+vendaDeAtivo.get(i));
            }
        }
        return true;
    }
    
    public Boolean calculaLucroAposIR(){
        if(lucroAposIR.size()>0){
            for(int i=0; i< lucroAposIR.size(); i++){
                lucroAposIR.set(i,lucroAntesIR.get(i)-irEContribSocial.get(i));
            }
        }
        return true;
    }
    
    public Boolean calculaFluxoDeCaixa(){
        if(fluxoCaixa.size()>0){
            for(int i=0; i< fluxoCaixa.size(); i++){
                fluxoCaixa.set(i,lucroAposIR.get(i)+depreciacao.get(i)-resVendAtivo.get(i)-amort.get(i)-investimento.get(i)+liberaFinanciamento.get(i)+valorResidual.get(i));
            }
        }
        return true;
    }
    
    public Boolean calculaValores(){
        return (calculaReceitaLiquida()&&calculaLucroBruto()&&calculaLucroOperacional()&&calculaLucroAntesIR()&&calculaLucroAposIR()&&calculaFluxoDeCaixa());
    }
    
    public void inicializar(){
        Double d = new Double(0);
        nomesColunas.add("");
        for(int i=0; i <= anos; i++){
            nomesColunas.add(i+"");
            receitaBruta.add(d);
            impostoProp.add(d);
            receitaLiquida.add(d);
            custoVarProd.add(d);
            custoFixProd.add(d);
            lucroBruto.add(d);
            despGerVar.add(d);
            despGerFix.add(d);
            depreciacao.add(d);
            despFinanceiras.add(d);
            lucroOperacional.add(d);
            resVendAtivo.add(d);
            lucroAntesIR.add(d);
            irEContribSocial.add(d);
            lucroAposIR.add(d);
            vendaDeAtivo.add(d);
            amort.add(d);
            investimento.add(d);
            liberaFinanciamento.add(d);
            valorResidual.add(d);
            fluxoCaixa.add(d);
        }
       updateData();
       columns = nomesColunas.toArray(new String[0]);
    }
    
    public void updateData(){
        data = new Object[][]{
            {receitaBruta.toArray(new Double[0])},
            {impostoProp.toArray(new Double[0])},
            {receitaLiquida.toArray(new Double[0])},
            {custoVarProd.toArray(new Double[0])},
            {custoFixProd.toArray(new Double[0])},
            {lucroBruto.toArray(new Double[0])},
            {despGerVar.toArray(new Double[0])},
            {despGerFix.toArray(new Double[0])},
            {depreciacao.toArray(new Double[0])},
            {despFinanceiras.toArray(new Double[0])},
            {lucroOperacional.toArray(new Double[0])},
            {resVendAtivo.toArray(new Double[0])},
            {lucroAntesIR.toArray(new Double[0])},
            {irEContribSocial.toArray(new Double[0])},
            {lucroAposIR.toArray(new Double[0])},
            {depreciacao.toArray(new Double[0])},
            {vendaDeAtivo.toArray(new Double[0])},
            {amort.toArray(new Double[0])},
            {investimento.toArray(new Double[0])},
            {liberaFinanciamento.toArray(new Double[0])},
            {valorResidual.toArray(new Double[0])},
            {fluxoCaixa.toArray(new Double[0])}
        };   
    }
    
    public boolean isCellEditable(int rowIndex,
                     int columnIndex){
    if(columnIndex != 0)
        return true;
    else
        return false;
    }
    
    public List<Double> getReceitaBruta() {
        return receitaBruta;
    }

    public void setReceitaBruta(List<Double> receitaBruta) {
        this.receitaBruta = receitaBruta;
    }

    public List<Double> getImpostoProp() {
        return impostoProp;
    }

    public void setImpostoProp(List<Double> impostoProp) {
        this.impostoProp = impostoProp;
    }

    public List<Double> getReceitaLiquida() {
        return receitaLiquida;
    }

    public void setReceitaLiquida(List<Double> receitaLiquida) {
        this.receitaLiquida = receitaLiquida;
    }

    public List<Double> getCustoVarProd() {
        return custoVarProd;
    }

    public void setCustoVarProd(List<Double> custoVarProd) {
        this.custoVarProd = custoVarProd;
    }

    public List<Double> getCustoFixProd() {
        return custoFixProd;
    }

    public void setCustoFixProd(List<Double> custoFixProd) {
        this.custoFixProd = custoFixProd;
    }

    public List<Double> getLucroBruto() {
        return lucroBruto;
    }

    public void setLucroBruto(List<Double> lucroBruto) {
        this.lucroBruto = lucroBruto;
    }

    public List<Double> getDespGerVar() {
        return despGerVar;
    }

    public void setDespGerVar(List<Double> despGerVar) {
        this.despGerVar = despGerVar;
    }

    public List<Double> getDespGerFix() {
        return despGerFix;
    }

    public void setDespGerFix(List<Double> despGerFix) {
        this.despGerFix = despGerFix;
    }

    public List<Double> getDepreciacao() {
        return depreciacao;
    }

    public void setDepreciacao(List<Double> depreciacao) {
        this.depreciacao = depreciacao;
    }

    public List<Double> getDespFinanceiras() {
        return despFinanceiras;
    }

    public void setDespFinanceiras(List<Double> despFinanceiras) {
        this.despFinanceiras = despFinanceiras;
    }

    public List<Double> getLucroOperacional() {
        return lucroOperacional;
    }

    public void setLucroOperacional(List<Double> lucroOperacional) {
        this.lucroOperacional = lucroOperacional;
    }

    public List<Double> getResVendAtivo() {
        return resVendAtivo;
    }

    public void setResVendAtivo(List<Double> resVendAtivo) {
        this.resVendAtivo = resVendAtivo;
    }

    public List<Double> getLucroAntesIR() {
        return lucroAntesIR;
    }

    public void setLucroAntesIR(List<Double> lucroAntesIR) {
        this.lucroAntesIR = lucroAntesIR;
    }

    public List<Double> getIrEContribSocial() {
        return irEContribSocial;
    }

    public void setIrEContribSocial(List<Double> irEContribSocial) {
        this.irEContribSocial = irEContribSocial;
    }

    public List<Double> getLucroAposIR() {
        return lucroAposIR;
    }

    public void setLucroAposIR(List<Double> lucroAposIR) {
        this.lucroAposIR = lucroAposIR;
    }

    public List<Double> getVendaDeAtivo() {
        return vendaDeAtivo;
    }

    public void setVendaDeAtivo(List<Double> vendaDeAtivo) {
        this.vendaDeAtivo = vendaDeAtivo;
    }

    public List<Double> getAmort() {
        return amort;
    }

    public void setAmort(List<Double> amort) {
        this.amort = amort;
    }

    public List<Double> getInvestimento() {
        return investimento;
    }

    public void setInvestimento(List<Double> investimento) {
        this.investimento = investimento;
    }

    public List<Double> getLiberaFinanciamento() {
        return liberaFinanciamento;
    }

    public void setLiberaFinanciamento(List<Double> liberaFinanciamento) {
        this.liberaFinanciamento = liberaFinanciamento;
    }

    public List<Double> getValorResidual() {
        return valorResidual;
    }

    public void setValorResidual(List<Double> valorResidual) {
        this.valorResidual = valorResidual;
    }

    public List<Double> getFluxoCaixa() {
        return fluxoCaixa;
    }

    public void setFluxoCaixa(List<Double> fluxoCaixa) {
        this.fluxoCaixa = fluxoCaixa;
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
