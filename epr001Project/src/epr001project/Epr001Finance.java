package epr001project;

import java.util.ArrayList;
import java.util.List;
import sun.security.provider.VerificationProvider;

/**
 *
 * @author cafeemymelo
 */

public class Epr001Finance {
    // calcular o valor presente atraves do valor futuro
    public static Double PV( Double fv, Double per, Double tx ){
        return fv/Math.pow((1+(tx/100)), per);
    }//end function PV
    
    public static Double VPL(List<Double> d, Double tx){
    Double first = d.get(0);// Pega o primeiro valor da lista 
    Double vpl = first;// inicializa o calculo do VPL 
    for (int i=1; i<d.size(); i++) {  
        //calcula o VPL trazendo todos os valores futuros pro presente
        vpl = vpl + PV(d.get(i), (double)i ,tx);
        
    }  
        //System.out.println("VPL = "+ vpl);
    return vpl;
    }// end function VPL 
    
    public static Boolean verificaVetor(List<Double> d){
    int i = 0;
        for (int j=1;j<d.size();j++)
            if(d.get(j)!=0)
                i++;
        
        if(i>0)
            return true;
        else
            return false;
    }
    
    public static Double TIR(List<Double> d,Double tma){
        Double tirVPL = VPL(d,tma);
        Double aux = 0.00;
        Double auxVPL = 0.00;
        Double tir = 0.00;
        if(verificaVetor(d))
        {
        if (tirVPL >0){
            while(tirVPL >0){
             aux = tma;
             tma++;
             auxVPL = tirVPL;
             tirVPL = VPL(d,tma);
                System.out.println("TIRVPL: "+tirVPL+" TMA: "+tma);
            }
        }else{
             while(tirVPL <0){
             aux = tma;
             tma--;
             auxVPL = tirVPL;
             tirVPL = VPL(d,tma);
            }
            
        }
        tir = (((auxVPL*-1)*(tma-aux))/(tirVPL-auxVPL))+aux;
        System.out.println(tir);
        return tir;
        }
        else{
        return null;
        }
    }// end function TIR            
}// end class
