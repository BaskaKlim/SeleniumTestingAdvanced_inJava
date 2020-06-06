package test;

import org.junit.*;
import org.junit.experimental.categories.*;
import categories.*;

public class DummyTests {

    static int numberOfFailTest;

    int failed = 0;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setup class");
        numberOfFailTest = 0;
    }

    @Before
    public void setUp() {
        System.out.println("setup before test");
    }

    @Category(SmokeTests.class)
    @Test
    public void testPrintA() {
        System.out.println("A");
        System.out.println("Static: " + numberOfFailTest);
        failed++;
        System.out.println(failed);
    }

    @Test
    public void testPrintB() {
        System.out.println("B");
        System.out.println("Static: " + numberOfFailTest);
        System.out.println(failed);
    }

    @Test
    public void testPrintC() {
        System.out.println("C");
        //chybny test, pridam nejaku logiku porovnavania a ak zluha tak pripocitam fail
        numberOfFailTest++;
        System.out.println("Static: " + numberOfFailTest);
        System.out.println(failed);
    }

    @Test
    public void testPrintD() {
        System.out.println("D");
        failed += 10;
        System.out.println("Static: " + numberOfFailTest);
        System.out.println(failed);

    }

    @Test
    public void testPrintE() {
        System.out.println("E");
        failed++;
        numberOfFailTest++;
        System.out.println("Static: " + numberOfFailTest);
        System.out.println(failed);
    }

    @After
    public void tearDown() {
        System.out.println("setup after test");
    }

    @AfterClass
    public static void printResult() {
        System.out.println("Number of faild test is: " + numberOfFailTest);
        //System.out.println("Number of faild test is: " + failed);
    }

}
