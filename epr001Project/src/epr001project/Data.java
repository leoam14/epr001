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
        custoFixoProducao.setAnos(anos);
        custoVariavelProducao.setAnos(anos);
        depreciacao.setAnos(anos);
        despGeralFixa.setAnos(anos);
        despGeralVar.setAnos(anos);
        impProporcional.setAnos(anos);
    }
    
    public int getAnos(){
        return anos;
    }
    
    
    
    
}
