

import exceptions.MoreThanOneTypeException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.type.UnknownTypeException;


public class Parser {

        
    public static String[][] CSVtoTab(String path, String file) throws IOException{
        final String FILE_NAME = path+file;
        File f = new File(FILE_NAME);
        Scanner scannerFile = new Scanner(f);
        ArrayList<String[]> contents = new ArrayList<String[]>();
        while(scannerFile.hasNextLine()){
            String line = scannerFile.nextLine();
            Scanner scannerLine = new Scanner(line);
            scannerLine.useDelimiter(";");
            ArrayList<String> lineArray = new ArrayList<String>();
            while(scannerLine.hasNext()){
                lineArray.add(scannerLine.next());
            }
            contents.add(lineArray.toArray(new String[lineArray.size()]));
            scannerLine.close();
        }
        String [][] columns = new String[contents.get(0).length][contents.size()];
        for(int i=0; i<contents.get(0).length;i++){
            for(int j=0; j<contents.size();j++){	
                columns[i][j] = contents.get(j)[i];
            }
        }
        scannerFile.close();
        return columns;
    }
    
  
    public static Object[] getColumnWithParsing(String[] column) throws UnknownTypeException{
        Object[] res = new Object[column.length-1];
        for (int i = 1; i < column.length; i++) {	
            if(column[i].equals("true") || column[i].equals("false")){
                res[i-1] = Boolean.parseBoolean(column[i]);			
            }else{		
                try{
                    res[i - 1] = Integer.parseInt(column[i]);
                }catch(Exception e1){
                    try{
                        res[i-1] = Double.parseDouble(column[i]);
                    }catch(Exception e2){
                        res[i-1] = column[i];
                    }
                }
            }
        }
        return res;
    }
	
    public static String[] getLabelsFromTab(String[][] columns){
        String[] labels = new String[columns.length];
        for(int i=0; i<columns.length;i++){	
            labels[i] = columns[i][0];
        }
        return labels;
    }
    
        
}
 
