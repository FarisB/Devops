

import exceptions.MoreThanOneTypeException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Parser {
        public final int LIGNE_MAX = 50;
        public final int COLONNE_MAX = 50;
        public int nbLignes;
        public int nbColonnes=0;
	public String[] entry = new String[LIGNE_MAX];
	public String[] label = new String[COLONNE_MAX];
        public boolean is_init=false;
        
        
        
        public Parser(String[] r){
            for(int i=0;i<r.length;i++){
                entry[i]=r[i];
            }
            nbLignes=r.length;
            
                String l[]=GetLabel();
                nbColonnes=l.length;
        }
        
        
        
        public Parser(File f){
            try {
                BufferedReader b;
                String line="";
                FileReader fr = new FileReader(f);
                b=new BufferedReader(fr);
                int i=0;
                
                
                while((line = b.readLine()) != null) {
                    entry[i]=line;
                    i++;
                }
                nbLignes=i;
                String l[]=GetLabel();
                nbColonnes=l.length;
                is_init=true;
            } catch (IOException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("PutainXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            }
        }
        
        //j'ai meme pas honte
        public boolean checkNumber(char a){
            if(a=='0' || a=='1' || a=='2' || a=='3' || a=='4' || a=='5' || a=='6' || a=='7' || a=='8' || a=='9'){
                    return true;
            }
            return false;
        }
        
        public void printTab1(String[] T){
            for(int i=0;i<T.length;i++){
                System.out.print(T[i]+" /");
            }
            System.out.print("\n");
        }
        
        public void printTab2(String[][] T){
            for(int i=0;i<T.length;i++){
                for(int j=0;j<T[0].length;j++){
                    System.out.print(T[i][j]+" ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        
        public void parseAll(){
            //On recupere les labels
            
            String labels[]=GetLabel();
            nbColonnes=labels.length;
            
            //on cree les colonnes en checkant le type de la premiere ligne comme template
            String types[]=checkTypeTout();
            printTab1(types);
            
            //on cree le tableau 2d "contents"
            String content[][]=parse();
            printTab2(content);
            
        }
        
        public String[] GetLabel(){
                String S=entry[0];
                int i=0;
                int j=S.indexOf(";");
                String elem="";
                //On regarde le nombre de colonnes
                int compteur=0;
                while (j!=-1){
                    elem=S.substring(i,j);
                    i=j+1;
                    j=S.indexOf(";",i);
      
                    compteur++;
                }
                String r[]=new String[compteur+1];
                
                //On regarde les labels
                compteur=0;
                i=0;
                j=S.indexOf(";");
                while (j!=-1){
                    elem=S.substring(i,j);
                    r[compteur]=elem;
                    i=j+1;
                    j=S.indexOf(";",i);
      
                    compteur++;
                }
                elem=S.substring(i, S.length());
                r[compteur]=elem;
                return r;
                
        }
        
        public String[] checkTypeTout(){
            String elems[]=new String[nbColonnes];
            String types[]=new String[nbColonnes];
            int j=0,k=0,i=0;
            
            k=entry[1].indexOf(";",j);
            
            
            for(i=0; i<nbColonnes && k!=-1;i++){
                elems[i]=entry[1].substring(j,k);
                types[i]=checkType(elems[i]);
                j=k+1;
                k=entry[1].indexOf(";",j);
            }
            if(k==-1){
                elems[i]=entry[1].substring(j,entry[1].length());
                types[i]=checkType(elems[i]);
            }
            
            return types;
                
        }
        
        public String checkType(String elem){
            boolean k=true;
                String cas="Int";
                int i=0;
                int j=0;
                
               
                //On cherche le type
                
                
                i=elem.indexOf(".");
                if(i==-1){
                    //on check si c'est entier
                    for(j=0;j<elem.length();j++){
                        k=k&&checkNumber(elem.charAt(j));
                    }
                    
                    if(!k){
                        //Il y a autre chose que des chiffres, pas un entier, donc une string
                        cas="String";
                    }
                }else{
                    //On check si c'est un flottant
                    for(j=0;j<elem.length();j++){
                        if(j!=i){
                            k=k&&checkNumber(elem.charAt(j));
                        }
                    }
                    
                    if(!k){
                        //Il y a autre chose que des chiffres, pas un float, donc une string
                        cas="String";
                    }else{
                        //C'est bien un float
                        cas="Float";
                    }
                }
                return cas;
        }
        
        public String[][] parse(){
            String content[][]=new String[nbLignes-1][nbColonnes];
            String line;
            int a=0,b=0;
            int i=0,j=0;
            
            
            for(i=1;i<nbLignes;i++){
                line=entry[i];
                a=0;
                b=line.indexOf(";",a);
                for(j=0;j<nbColonnes&&b!=-1;j++){
                    content[i-1][j]=line.substring(a, b);
                    a=b+1;
                    b=line.indexOf(";",a);
                }
                if(j<nbColonnes){
                    content[i-1][j]=line.substring(a, line.length());
                }
            }
            
            return content;
        }
        
	
        
}
 
