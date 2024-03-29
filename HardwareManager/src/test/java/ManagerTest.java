
import hardwaremanager.logics.Hardware;
import hardwaremanager.logics.Manager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManagerTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Manager manager;
    Hardware hardware;

    public ManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        manager = new Manager();
        manager.addNewHardware("B550", "Motherboard", "Main machine");
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
    
    @Test
    public void showLastAddedShowsLastAdded(){
        manager.addNewHardware("Last", "hardware", "lost");
        manager.showLastAdded();
        assertEquals("Last - hardware @ lost.", outputStreamCaptor.toString().trim());
    }
    
    @Test
    public void getHardwareDoesntGetNonexistentHardwareID() {        
        assertEquals(null, manager.getHardware(2));
    }

    @Test
    public void getHardwareGetsHardware() {        
        assertEquals("B550 - Motherboard @ Main machine.", manager.getHardware(1).toString());
    }

    @Test
    public void hwlistCorrectlyNotEmpty() {
        assertEquals(true, manager.hwlistNotEmpty());
    }

    @Test
    public void hwlistNotIncorrectlyEmpty() {
        assertEquals(false, !manager.hwlistNotEmpty());
    }

    @Test
    public void hardwareIsRemoved() {
        manager.removeHardware(1);
        assertEquals(false, manager.hwlistNotEmpty());
    }

    @Test
    public void hardwareIsNotIncorrectlyRemovedOnTooHighNumber() {
        manager.removeHardware(2);
        assertEquals(true, manager.hwlistNotEmpty());
    }

    @Test
    public void hardwareIsNotIncorrectlyRemovedOnNegativeNumber() {
        manager.removeHardware(-2);
        assertEquals(true, manager.hwlistNotEmpty());
    }

    @Test
    public void hardwareIsListed() {
        manager.listHardware();
        assertEquals("1. B550 - Motherboard @ Main machine.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void titleSearchIsFound() {
        manager.searchByTitle("b55");
        assertEquals("B550 - Motherboard @ Main machine.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void typeSearchIsFound() {
        manager.searchByType("herbo");
        assertEquals("B550 - Motherboard @ Main machine.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void locationSearchIsFound() {
        manager.searchByLocation("machin");
        assertEquals("B550 - Motherboard @ Main machine.", outputStreamCaptor.toString().trim());
    }

}
