
import exceptions.*;
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
public class Dataframe {

    private ArrayList<Column> columns;
    
    public Dataframe(Object[][] contents, String[] labels) throws InvalidTypeException, MoreThanOneTypeException, DifferentSizeException {
        if(labels.length != contents.length){
            throw new DifferentSizeException();
        }
        this.columns = new ArrayList<Column>();
        for(int index = 0; index < contents.length; index++){
            switch (contents[index][0].getClass().getName()) {
                case "java.lang.Integer":
                    this.columns.add(new Column<Integer>(contents[index], labels[index]));
                    break;
                case "java.lang.String":
                    this.columns.add(new Column<String>(contents[index], labels[index]));
                    break;
                case "java.lang.Double":
                    this.columns.add(new Column<Double>(contents[index], labels[index]));
                    break;
                default:
                    throw new InvalidTypeException("Type invalide lors de la creation du dataframe.\n Types possibles: Integer, String, Float");
            }
        }
    }
    
    public String getAllLines() {
        String res = new String();
        for(Column col : this.columns){
            res += col.getColumn();
        }
        return res;
    }
    
    public String getJFirstLines(int j) {
        if (this.columns.get(0).getLines().size()<j || j < 0)
            throw new IndexOutOfBoundsException("Vous voulez afficher plus de ligne qu'il y en a.");
        String res = new String();
        for (Column column : this.columns) {
            res += column.getColumn(0, j);
        }
        return res;
    }
    
    public String getJLastLines(int j) {
        if(this.columns.get(0).getLines().size() < j || j < 0){
            throw new IndexOutOfBoundsException("Vous voulez afficher plus de ligne qu'il y en a.");
        }
        String res = new String();
        for (Column column : this.columns) {
            res += column.getColumn(this.columns.get(0).getLines().size()-j, this.columns.get(0).getLines().size());
        }
        return res;
    }
    
    public void displayAllLines() {
        System.out.println(this.getAllLines());
    }

    public void displayJFirstLines(int j) {
        System.out.println(this.getJFirstLines(j));
    }
    
    public void displayJLastLines(int j) {
        System.out.println(this.getJLastLines(j));
    }
    
    public Dataframe createSmallDataframe(int start, int end) throws BadArgsException {
        // On check les arguments
        for (Column column : this.columns) {
            if(start > column.getLines().size() || start < 0 || end > column.getLines().size() || end < 0){
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        if(end <= start){
            throw new BadArgsException();
        }
        
        //Création du mini dataframe en fonction de start et end
        String[] miniLabels = new String[this.columns.size()];
        Object[][] miniContents = new Object[this.columns.size()][end-start];

        for(int index = 0; index < this.columns.size(); index++){
            miniLabels[index] = this.columns.get(index).getLabel();
        }

        //Recopie du contenu situé entre start et end
        int lineIndex = 0;
        for(int indexInTheOldDF = start; indexInTheOldDF < end; indexInTheOldDF++){
            for(int colIndex = 0; colIndex < this.columns.size(); colIndex++){
                miniContents[colIndex][lineIndex] = this.columns.get(colIndex).getLines().get(indexInTheOldDF);
            }
            lineIndex++;
        }
        try {
            return new Dataframe(miniContents, miniLabels);
        } catch (Exception e) {
            System.err.println("Création de Dataframe impossible pour les lignes de " + start + " Ã  " + end );
            return null;
        }
    }
    
    public float getAverage(int colIndex){
        if(colIndex > this.columns.size() || colIndex < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            return this.columns.get(colIndex).averageCalculation();
        }
    }
    
}
