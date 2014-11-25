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
    OutrosDadosModel outrosDados = new OutrosDadosModel();
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
    
    public void limpaDados(){
        data=null;
        outrosDados = new OutrosDadosModel();
        dadosModel = new DadosModel();
        custoVariavelProducao = new CustoVariavelProducaoModel();
        custoFixoProducao = new CustoFixoProducaoModel();
        despGeralVar = new DespGeralVarModel();
        despGeralFixa = new DespGeralFixaModel();
        impProporcional = new ImpProporcionalModel();
        depreciacao = new DepreciacaoModel();
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
        outrosDados.setAnos(anos);
    }
    
    public int getAnos(){
        return anos;
    }
    
    
    
    
}
