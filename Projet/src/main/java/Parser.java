
public class Parser {
        public final int COLONNE_MAX = 50;
        public int nbColonnes;
	public String[] entry = new String[COLONNE_MAX];
        public String[] types = new String[COLONNE_MAX];
        
        
        
        public Parser(String[] r){
            for(int i=0;i<r.length;i++){
                entry[i]=r[i];
            }
            nbColonnes=r.length;
        }
        
        //j'ai meme pas honte
        public boolean checkNumber(char a){
            if(a=='0' || a=='1' || a=='2' || a=='3' || a=='4' || a=='5' || a=='6' || a=='7' || a=='8' || a=='9'){
                    return true;
            }
            return false;
        }
        
        public String[] parseAll(){
            for(int i=0;i<nbColonnes;i++){
                types[i]=parse(i);
            }
            return types;
        }
	
	public String parse(int line) {
		boolean k=true;
                String cas="Int";
                String elem;
                int i;
                int j;
                String S=entry[line];
                
                //On cherche le type
                i=S.indexOf(";");
		elem=S.substring(0,i);
                
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
                //On decoupe
		i=0;
                j=S.indexOf(";");
                elem="";
                k=true;
                
		while (j!=-1){
			elem=S.substring(i,j);
			
                        i=j+1;
                        j=S.indexOf(";",i);

			//On verifie son type
			

			k=false;
		}
                elem=S.substring(i,S.length());
                return cas;
		
	}
        
}
 