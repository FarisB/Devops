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
    String nom = "Filibert;John;Patrick;Philippe;Clitorine";
    String age = "45;21;6;45;1";
    String taille = "1.40;1.5;1.87;1.63;2.10";
    
    String total[]={nom,age,taille};
    
    
    @Test
    public void CreateParserTest(){
        
        Parser p = new Parser(total);
        boolean ka=p!=null;
        boolean kb=p.entry!=null;
        boolean kc=p.nbColonnes==total.length;
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
    
    @Test
    public void ParseString(){
        Parser p = new Parser(total);
        String result;
        result=p.parse(0);
        assertTrue("Parser ne reconnait pas bien", result.equals("String"));
        
    }
    
    @Test
    public void ParseInt(){
        Parser p = new Parser(total);
        String result;
        result=p.parse(1);
        assertTrue("Parser ne reconnait pas bien", result.equals("Int"));
        
    }
    
    @Test
    public void ParseFloat(){
        Parser p = new Parser(total);
        String result;
        result=p.parse(2);
        assertTrue("Parser ne reconnait pas bien", result.equals("Float"));
    }
    
    @Test
    public void ParseEverything(){
        Parser p = new Parser(total);
        String result[]=p.parseAll();
        assertTrue("ParseAll deconne",result!=null&&result[0].equals("String")&&result[1].equals("Int")&&result[2].equals("Float"));
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
