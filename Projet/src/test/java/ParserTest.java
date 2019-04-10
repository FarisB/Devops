/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author armonev
 */
public class ParserTest {
    String labelFrance="nom;age;pays;taille";
    String John="John;19;USA;1.75";
    String Son="Son;24;coree;1.60";
    String Valentin="Valentin;24;France;1.80";
    String Kirikou="Kirikou;4;kenya;0.60";
    
    String total[]={labelFrance, John, Son, Valentin, Kirikou};
    
    
    @Test
    public void CreateParserTest(){
        
        Parser p = new Parser(total);
        boolean ka=p!=null;
        boolean kb=p.entry!=null;
        boolean kc=p.nbLignes==total.length;
        assertTrue("La creation de l'objet parser ne marche pas:a="+ka+"  b="+kb+"   c="+kc,ka&&kb&&kc);
    }
    
    @Test
    public void CheckNumberTestBon(){
        char a='0';
        Parser p = new Parser(total);
        boolean k= true;
        for(int i=0;i<10;i++){
            k=k&&p.checkNumber((char) ('0'+i));
        }
        
        assertTrue("CheckNumber deconne",k);
        
    }
    @Test
    public void CheckNumberTestFaux(){
        char a='0';
        Parser p = new Parser(total);
        boolean k= true;
        for(int i=0;i<20;i++){
            k=k&&p.checkNumber((char) ('0'+i));
        }
        
        assertTrue("CheckNumber deconne",!k);
        
    }
    /*
    @Test
    public void ParseTypeString(){
        Parser p = new Parser(total);
        String result;
        result=p.checkType(0);
        assertTrue("Parser ne reconnait pas bien", result.equals("String"));
        
    }
    
    @Test
    public void ParseTypeInt(){
        Parser p = new Parser(total);
        String result;
        result=p.checkType(1);
        assertTrue("Parser ne reconnait pas bien", result.equals("Int"));
        
    }
    
    @Test
    public void ParseTypeFloat(){
        Parser p = new Parser(total);
        String result;
        result=p.checkType(2);
        assertTrue("Parser ne reconnait pas bien", result.equals("Float"));
    }
    */
    @Test
    public void ParseEverything(){
        Parser p = new Parser(total);
        p.parseAll();
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
