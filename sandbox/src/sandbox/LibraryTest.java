package sandbox;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import sandbox.Library;
import sandbox.PhysicalItem;

public class LibraryTest {
	private Library library;
    private PhysicalItem item;
    private PhysicalItem item2;
    @Before
    public void setUp() {
        library = new Library();
        item = new PhysicalItem("Book","Physical", 20.0,true);
        item2 = new PhysicalItem("Book","Physical", 20.0,true);
    }

    @Test
    public void testRentItem() {
        library.RentItem(item);
        HashMap<String, Integer> inventory = library.getInventory();
        assertEquals(19, inventory.get("Book").intValue());
    }
        @Test
        public void testRentItem2() {
            library.RentItem(item2);
            HashMap<String, Integer> inventory = library.getInventory();
            assertEquals(18, inventory.get("Book").intValue());
}
}
