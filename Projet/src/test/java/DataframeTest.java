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
 * @author faris
 */
public class DataframeTest {
    
    public DataframeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     * Test of getAllLines method, of class Dataframe.
     */
    @Test
    public void testGetAllLines() {
        System.out.println("getAllLines");
        Dataframe instance = null;
        String expResult = "";
        String result = instance.getAllLines();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJFirstLines method, of class Dataframe.
     */
    @Test
    public void testGetJFirstLines() {
        System.out.println("getJFirstLines");
        int j = 0;
        Dataframe instance = null;
        String expResult = "";
        String result = instance.getJFirstLines(j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJLastLines method, of class Dataframe.
     */
    @Test
    public void testGetJLastLines() {
        System.out.println("getJLastLines");
        int j = 0;
        Dataframe instance = null;
        String expResult = "";
        String result = instance.getJLastLines(j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllLines method, of class Dataframe.
     */
    @Test
    public void testDisplayAllLines() {
        System.out.println("displayAllLines");
        Dataframe instance = null;
        instance.displayAllLines();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayJFirstLines method, of class Dataframe.
     */
    @Test
    public void testDisplayJFirstLines() {
        System.out.println("displayJFirstLines");
        int j = 0;
        Dataframe instance = null;
        instance.displayJFirstLines(j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayJLastLines method, of class Dataframe.
     */
    @Test
    public void testDisplayJLastLines() {
        System.out.println("displayJLastLines");
        int j = 0;
        Dataframe instance = null;
        instance.displayJLastLines(j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSmallDataframe method, of class Dataframe.
     */
    @Test
    public void testCreateSmallDataframe() throws Exception {
        System.out.println("createSmallDataframe");
        int start = 0;
        int end = 0;
        Dataframe instance = null;
        Dataframe expResult = null;
        Dataframe result = instance.createSmallDataframe(start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAverage method, of class Dataframe.
     */
    @Test
    public void testGetAverage() {
        System.out.println("getAverage");
        int colIndex = 0;
        Dataframe instance = null;
        float expResult = 0.0F;
        float result = instance.getAverage(colIndex);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAverage method, of class Dataframe.
     */
    @Test
    public void testDisplayAverage() {
        System.out.println("displayAverage");
        int i = 0;
        Dataframe instance = null;
        instance.displayAverage(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMin method, of class Dataframe.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        int i = 0;
        Dataframe instance = null;
        double expResult = 0.0;
        double result = instance.getMin(i);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMax method, of class Dataframe.
     */
    @Test
    public void testGetMax() {
        System.out.println("getMax");
        int i = 0;
        Dataframe instance = null;
        double expResult = 0.0;
        double result = instance.getMax(i);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMin method, of class Dataframe.
     */
    @Test
    public void testDisplayMin() {
        System.out.println("displayMin");
        int i = 0;
        Dataframe instance = null;
        instance.displayMin(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMax method, of class Dataframe.
     */
    @Test
    public void testDisplayMax() {
        System.out.println("displayMax");
        int i = 0;
        Dataframe instance = null;
        instance.displayMax(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
