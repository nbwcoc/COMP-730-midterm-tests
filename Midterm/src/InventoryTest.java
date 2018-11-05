import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class InventoryTest {
    
    Inventory testObject = new Inventory();
    InventoryItem itemToDrop;
    int count = 1;
    
    InventoryTest() {
        // mocked out to not interfere with other tests.
        itemToDrop = spy(new InventoryItem("test", 0, "test-drop", 0));
        doReturn(0).when(itemToDrop).getWeight();
        doReturn(0).when(itemToDrop).getCount();
        testObject.addItemToInventory(itemToDrop);
        // mocked to remove any assumptions about InventoryItem working properly
        InventoryItem persistent = mock(InventoryItem.class);
        when(persistent.getCount()).thenReturn(1);
        when(persistent.getWeight()).thenReturn(1);
        when(persistent.getName()).thenReturn("test-persistent");
        when(persistent.getType()).thenReturn("test");
        when(persistent.toString()).thenReturn("test-persistent type (test), wt: 1, there are 1 left");
        testObject.addItemToInventory(persistent);
    }

    @Test
    void testAddItemToInventory() {
        // package-private; this code is already test friendly
        int length = testObject.items.size();
        InventoryItem itemToAdd = spy(new InventoryItem("test", 0, "test-add", 0)); 
        doReturn(0).when(itemToAdd).getWeight();
        doReturn(0).when(itemToAdd).getCount();
        assertTrue(testObject.addItemToInventory(itemToAdd));
        assertEquals(length + 1, testObject.items.size());
        count++;
    }
    
    @Test
    void testAddHugeItemToInventory() {
        int length = testObject.items.size();
        InventoryItem itemToAdd = spy(new InventoryItem("test", 0, "test-add", 0)); 
        doReturn(500000).when(itemToAdd).getWeight();
        doReturn(0).when(itemToAdd).getCount();
        assertFalse(testObject.addItemToInventory(itemToAdd));
        assertEquals(length, testObject.items.size());
    }

    @Test
    void testDropInventoryItem() {
        int length = testObject.items.size();
        assertTrue(testObject.dropInventoryItem(itemToDrop));
        assertEquals(length - 1, testObject.items.size());
        count--;
    }
    
    @Test
    void testDropNonexistentItem() {
        int length = testObject.items.size();
        assertFalse(testObject.dropInventoryItem(new InventoryItem("", 0, "", 0)));
        assertEquals(length, testObject.items.size());
    }

    @Test
    void testGetWeight() {
        assertEquals(1, testObject.getWeight());
    }

    @Test
    void testGetCount() {
        assertEquals(count, testObject.getCount());
    }

    @Test
    void testToString() {
        // I'm making some assumptions about expected behavior here
        System.out.println(testObject.toString());
    }

}
