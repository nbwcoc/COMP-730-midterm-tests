import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InventoryItemTest {

    InventoryItem testObject = new InventoryItem("test", 1, "test", 1);
    
    @Test
    void testGetName() {
        assertEquals("test", testObject.getName());
    }

    @Test
    void testGetType() {
        assertEquals("test", testObject.getType());
    }

    @Test
    void testGetWeight() {
        assertEquals(1, testObject.getWeight());
    }

    @Test
    void testGetCount() {
        assertEquals(1, testObject.getCount());
    }

    @Test
    void testToString() {
        assertEquals("test type (test), wt: 1, there are 1 left", testObject.toString());
    }

}
