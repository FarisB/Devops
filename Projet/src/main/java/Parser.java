
public class Parser {
	static String un="Durand;Michel;Vincent;Antoine;Kanawasakishima";
	static String deux="12;4;0;68;-8";
	static String trois="20.0;10.0;600000.8;2.36;9.2";
        
        //j'ai meme pas honte
        public static boolean checkNumber(char a){
            if(a=='0' || a=='1' || a=='2' || a=='3' || a=='4' || a=='5' || a=='6' || a=='7' || a=='8' || a=='9'){
                    return true;
            }
            return false;
        }
	
	public static void main(String[] args) {
		boolean k=true;
                String cas="Int";
                String elem;
                int i;
                int j;
                String S=trois;
                
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
                System.out.print("Le type trouve est "+cas+"\n\n");
                //On decoupe
		i=0;
                j=S.indexOf(";");
                elem="";
                k=true;
                
		while (j!=-1){
			elem=S.substring(i,j);
			
			System.out.println(elem);
                        i=j+1;
                        j=S.indexOf(";",i);

			//On verifie son type
			

			k=false;
		}
                elem=S.substring(i,S.length());
                System.out.println(elem);
		
	}
}
 