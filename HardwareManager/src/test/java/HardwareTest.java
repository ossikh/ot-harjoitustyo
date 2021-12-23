
import hardwaremanager.logics.Hardware;
import org.junit.Test;
import static org.junit.Assert.*;

public class HardwareTest {

    public HardwareTest() {
    }

    @Test
    public void hardwareIsCreatedAndPrinted() {
        Hardware mobo = new Hardware("B550", "Motherboard", "Main machine");
        assertEquals("B550 - Motherboard @ Main machine.", mobo.toString());
    }

}
