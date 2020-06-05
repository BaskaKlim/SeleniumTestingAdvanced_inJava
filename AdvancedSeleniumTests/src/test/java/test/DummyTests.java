package test;

import org.junit.*;

public class DummyTests {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setup class");
    }

    @Before
    public void setUp() {
        System.out.println("setup before test");
    }

    @Test
    public void testPrintA() {
        System.out.println("A");
    }

    @Test
    public void testPrintB() {
        System.out.println("B");
    }

    @Test
    public void testPrintC() {
        System.out.println("C");
    }

    @Test
    public void testPrintD() {
        System.out.println("D");
    }

    @Test
    public void testPrintE() {
        System.out.println("E");
    }

    @After
    public void tearDown() {
        System.out.println("setup after test");
    }

}
