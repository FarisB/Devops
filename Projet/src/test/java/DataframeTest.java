/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exceptions.*;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author faris
 */
public class DataframeTest {
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     * Test of getAllLines method, of class Dataframe.
     */

    
    //Constructors tests
    @Test
    public void test_Constructor_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
            Object[][] contents = new Object[][]{{1,2,3},{"Hello", "World", "Guys"},{10.5, 20.0, 30.8}};
            String [] labels = new String[]{"entiers", "string", "doubles"};
            Dataframe datatest = new Dataframe(contents, labels);
    }
    
    @Test(expected = MoreThanOneTypeException.class)
	public void test_Constructor_with_more_than_one_type_in_a_column_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Object[][] contents = new Object[][]{{1.5,2,3},{"Hello", "World", 4}};
		String [] labels = new String[]{"double", "string"};
		Dataframe datatest = new Dataframe(contents, labels);
	}
	
	@Test(expected = InvalidTypeException.class)
	public void test_Constructor_with_invalid_type_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		long a = 1;
		long b = 2;
		long c = 3;
		Object[][] contents = new Object[][]{{a,b,c},{"Hello", "World", "Guys"}};
		String [] labels = new String[]{"long", "string"};
		Dataframe datatest = new Dataframe(contents, labels);
	}
	
	@Test(expected = DifferentSizeException.class)
	public void test_Constructor_bad_size_array_label_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Object[][] contents = new Object[][]{{1,2,3},{"Hello", "World", "Guys"}, {10.5,20.0}};
		String [] labels = new String[]{"entiers", "string"};
		Dataframe datatest = new Dataframe(contents, labels);
	}
	
	//For display all lines
	public Dataframe createGoodDataset() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Object[][] contents = new Object[][]{{1,2,3},{"Hello", "World", "Guys"}};
		String [] labels = new String[]{"entiers", "string"};
		Dataframe datatest = new Dataframe(contents, labels);
		return datatest;
	}
	@Test
	public void test_Display_all_lines() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDataset();
		datatest.displayAllLines();
		assertEquals("entiers: 1 2 3 \nstring: Hello World Guys \n", datatest.getAllLines());
	}
	
	//For csv exploration
	@Test
	public void test_csv_to_dataframe_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, IOException {
		Dataframe datatest = Dataframe.DataframeFromCSVFile("src/test/csv/", "goodDataframe.csv");
		assertEquals("entiers: 1 2 3 \nstring: Hello World Guys \ndoubles: 10.5 20.0 30.8 \n", datatest.getAllLines());
		assertEquals("Problème avec la moyenne sur des entiers d'un fichier csv", 2, datatest.getAverage(0), 0.0001);
		assertEquals("Problème avec la moyenne sur des flottants d'un fichier csv", 20.4333333333, datatest.getAverage(2), 0.0001);
	}
	
	@Test(expected = MoreThanOneTypeException.class)
	public void test_csv_toomuch_type_in_a_column_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, IOException {
		Dataframe datatest = Dataframe.DataframeFromCSVFile("src/test/csv/", "badDataframe.csv");
	}
	
	//For display first line
	@Test
	public void test_Display_jfirst_lines_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDataset();
		datatest.displayJFirstLines(2);
		assertEquals("entiers: 1 2 \nstring: Hello World \n", datatest.getJFirstLines(2));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_Display_jfirst_lines_with_index_too_big_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDataset();
		datatest.displayJFirstLines(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_Display_first_lines_with_negative_index_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDataset();
		datatest.displayJFirstLines(-3);
	}
	//For display last line
	@Test
	public void test_Display_jlast_lines_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDataset();
		datatest.displayJLastLines(2);
		assertEquals("entiers: 2 3 \nstring: World Guys \n", datatest.getJLastLines(2));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_Display_jlast_lines_with_index_too_big_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDataset();
		datatest.displayJLastLines(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_Display_jlast_lines_with_negative_index_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDataset();
		datatest.displayJLastLines(-6);
	}
	
	//For dataframe from first lines
	@Test
	public void test_createDFFromFirstLines_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createDataframeFromFirstLines(2);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_createDFFromFirstLines_with_index_too_big_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createDataframeFromFirstLines(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_createDFFromFirstLines_with_negative_index_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createDataframeFromFirstLines(-3);
	}
	
	//For dataframe from last lines
	@Test
	public void test_createDFFromLastLines_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createDataframeFromLastLines(2);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_createDFFromLastLines_with_index_too_big_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createDataframeFromLastLines(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_createDFFromLastLines_with_negative_index_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createDataframeFromLastLines(-3);
	}
	
	//For dataframe from selected indexes
	@Test
	public void test_createSmallDF_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createSmallDataframe(1,2);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_createSmallDF_with_startIndex_too_big_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createSmallDataframe(4,2);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_createSmallDF_with_startIndex_negative_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createSmallDataframe(-1,2);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_createSmallDF_with_endIndex_too_big_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createSmallDataframe(1,4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_createSmallDF_with_endIndex_negative_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createSmallDataframe(1,-1);
	}
	
	@Test(expected = BadArgsException.class)
	public void test_createSmallDF_with_endIndex_smaller_than_startIndex_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDataset();
		datatest.createSmallDataframe(2,1);
	}
	
	//For stats
	public Dataframe createGoodDatasetForStatistics() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Object[][] contents = new Object[][]{{1,2,3},{"Hello", "World", "Guys"}, {10.5,20.0,30.8}};
		String [] labels = new String[]{"entiers", "string", "double"};
		Dataframe datatest = new Dataframe(contents, labels);
		return datatest;
	}
	//For average
	@Test
	public void test_average_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException, BadArgsException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.displayAverage(2);
		assertEquals("Calcul de max avec mauvais entiers", 2, datatest.getAverage(0),0.0001);
		assertEquals("Calcul de max avec mauvais flottants", 20.4333333333, datatest.getAverage(2),0.0001);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_average_wrong_with_index_big() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.getAverage(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_average_with_negative_index_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.getAverage(-4);
	}
	//For min
	@Test
	public void test_min_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.displayMin(2);
		assertEquals("Calcul de max avec mauvais entiers", 1, datatest.getMin(0),0.0001);
		assertEquals("Calcul de max avec mauvais flottants", 10.5, datatest.getMin(2),0.0001);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_min_with_index_too_big_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.getMin(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_min_with_negative_index_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.getMin(-4);
	}
	//For max
	@Test
	public void test_max_good() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.displayMax(2);
		assertEquals("Calcul de max avec mauvais entiers", 3, datatest.getMax(0),0.0001);
		assertEquals("Calcul de max avec mauvais flottants", 30.8, datatest.getMax(2),0.0001);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_max_with_index_too_big_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.getMax(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_max_with_negative_index_wrong() throws MoreThanOneTypeException, InvalidTypeException, DifferentSizeException {
		Dataframe datatest = createGoodDatasetForStatistics();
		datatest.getMax(-2);
	}
}
