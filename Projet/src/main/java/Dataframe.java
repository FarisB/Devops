
import exceptions.InvalidTypeException;
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
    
    public Dataframe(Object[][] contents, String[] labels) throws InvalidTypeException {
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

    
}
