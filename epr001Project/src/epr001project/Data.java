/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epr001project;

/**
 *
 * @author leoam14
 */
public class Data {
    private static Data data=null;
    DadosModel dadosModel = new DadosModel();
    CustoVariavelProducaoModel custoVariavelProducao = new CustoVariavelProducaoModel();
    CustoFixoProducaoModel custoFixoProducao = new CustoFixoProducaoModel();
    DespGeralVarModel despGeralVar = new DespGeralVarModel();
    DespGeralFixaModel despGeralFixa = new DespGeralFixaModel();
    ImpProporcionalModel impProporcional = new ImpProporcionalModel();
    DepreciacaoModel depreciacao = new DepreciacaoModel();
    int anos = 1;
    
    private Data(){};
    
    public static Data getData(){
        if(data == null){
            data = new Data();
            return data;
        }else{
            return data;
        }
    }
    
    public void setAnos(int anos){
        this.anos = anos;
        dadosModel.setAnos(anos);
    }
    
    public int getAnos(){
        return anos;
    }
    
    
    
    
}
