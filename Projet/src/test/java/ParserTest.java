/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void printTab1(String[] T){
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
            for(int i=0;i<T.length;i++){
                System.out.print(T[i]+"/");
            }
            System.out.print("\n");
        }
    
    
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
    
    
    @Test
    public void testParserFileNonNull(){
        File f= null;
        ///src/test/csv/a.csv
        f = new File("src"+File.separator+"test"+File.separator+"csv"+File.separator+"a.csv");
        Parser p = new Parser(f);
        assertTrue("Le constructeur deconne complet", p!=null&&f!=null&&p.is_init);
    }
    
    @Test
    public void testParserFilea(){
        File f= null;
        ///src/test/csv/a.csv
        f = new File("src"+File.separator+"test"+File.separator+"csv"+File.separator+"a.csv");
        Parser p = new Parser(f);
        boolean k=p.entry[0].equals(labelFrance);
        k=k&&p.entry[1].equals(John);
        k=k&&p.entry[2].equals(Son);
        k=k&&p.entry[3].equals(Valentin);
        k=k&&p.entry[4].equals(Kirikou);
        assertTrue("Quand on ouvre le fichier, on lit mal",k);
    }
    
    @Test
    public void testLabel(){
        Parser p=new Parser(total);
        String l[] = p.GetLabel();
        boolean k=l[0].equals("nom");
        k=k&&l[1].equals("age");
        k=k&&l[2].equals("pays");
        k=k&&l[3].equals("taille");
        
        assertTrue("GetLabel marche mal", k);
    }
    
    @Test
    public void checkTypeInt(){
        Parser p=new Parser(total);
        String cas = p.checkType("12");
        assertTrue("CheckType reconnait mal les int", cas.equals("Int"));
    }
    
    @Test
    public void checkTypeString1(){
        Parser p=new Parser(total);
        String cas = p.checkType("John");
        assertTrue("CheckType reconnait mal les string", cas.equals("String"));
    }
    
    @Test
    public void checkTypeString2(){
        Parser p=new Parser(total);
        String cas = p.checkType("00111a2");
        assertTrue("CheckType reconnait mal les string", cas.equals("String"));
    }
    
    @Test
    public void checkTypeString3(){
        Parser p=new Parser(total);
        String cas = p.checkType("1.555.66.8");
        assertTrue("CheckType reconnait mal les string", cas.equals("String"));
    }
    
    @Test
    public void checkTypeFloat(){
        Parser p=new Parser(total);
        String cas = p.checkType("1.555");
        assertTrue("CheckType reconnait mal les float", cas.equals("Float"));
    }
    
    @Test 
    public void checkTypeTout(){
        Parser p=new Parser(total);
        String s[] = p.checkTypeTout();
        boolean k=s[0].equals("String");
        k=k&&s[1].equals("Int");
        k=k&&s[2].equals("String");
        k=k&&s[3].equals("Float");
        
        
        assertTrue("Probleme dans checktypetout", k);
    }
    
    @Test
    public void checkParse(){
        Parser p= new Parser(total);
        String data[][] = p.parse();
        boolean k=true;
        
        k=k&&(data[0][0].equals("John"));
        k=k&&(data[0][1].equals("19"));
        k=k&&(data[0][2].equals("USA"));
        k=k&&(data[0][3].equals("1.75"));
        k=k&&(data[1][0].equals("Son"));
        k=k&&(data[1][1].equals("24"));
        k=k&&(data[1][2].equals("coree"));
        k=k&&(data[1][3].equals("1.60"));
        k=k&&(data[2][0].equals("Valentin"));
        k=k&&(data[2][1].equals("24"));
        k=k&&(data[2][2].equals("France"));
        k=k&&(data[2][3].equals("1.80"));
        k=k&&(data[3][0].equals("Kirikou"));
        k=k&&(data[3][1].equals("4"));
        k=k&&(data[3][2].equals("kenya"));
        k=k&&(data[3][3].equals("0.60"));
        
        
        
        assertTrue("Le parse marche mal", k);
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
