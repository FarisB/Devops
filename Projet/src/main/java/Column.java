
import exceptions.MoreThanOneTypeException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faris
 */
class Column<E>{
    
    private ArrayList<E> lines;
    private String label;

    public Column(Object[] column, String label) throws MoreThanOneTypeException {
        this.lines = new ArrayList<E>();
        this.label = label;
        for(Object cell : column){ //Moche mais pas le choix
            if(cell.getClass().getName().equals(column[0].getClass().getName())){
                lines.add((E) cell);
            }else{
                    throw new MoreThanOneTypeException("Erreur : Il y a des types différents dans une même colonne");
            }
        }
    }
    
    public String getColumn(){
        String res = new String();
        res += this.label + ": ";
        for(E cell : this.lines){
            res += cell + " ";
        }
        res+= "\n";
        return res;
    }
    
      public String getColumn(int i, int j){ // i le debut et j la fin
        String res = new String();
        res += this.label + ": ";
        for (int index = i; index < j; index++) {
            res += this.lines.get(index) + " ";
        }
        res+= "\n";
        return res;
    }
    
    public ArrayList<E> getLinesOfAColumn() {
        return lines;
    }
    
    public String getLabel() {
        return label;
    }
    
    
}
