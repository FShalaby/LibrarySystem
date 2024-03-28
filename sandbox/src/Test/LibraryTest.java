package Test;

import sandbox.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LibraryTest {
    @Test
    public void testCreateUserWithValidType() {
        // Test creating user with valid user types
        User student = UserFactory.createUser("John Doe", "john@example.com", "password", "student", true);
        assertTrue(student instanceof Student);

        User faculty = UserFactory.createUser("Alice Smith", "alice@example.com", "password", "faculty", true);
        assertTrue(faculty instanceof Faculty);

        User nonFaculty = UserFactory.createUser("Bob Johnson", "bob@example.com", "password", "non-faculty", true);
        assertTrue(nonFaculty instanceof NonFaculty);

        User visitor = UserFactory.createUser("Eva Green", "eva@example.com", "password", "visitor",true);
        assertTrue(visitor instanceof Visitor);

        User manager = UserFactory.createUser("Mike Brown", "mike@example.com", "password", "manager",true);
        assertTrue(manager instanceof LibraryManager);
    }

    @Test
    public void testCreateUserWithInvalidType() {
        // Test creating user with invalid user type
        assertThrows(IllegalArgumentException.class, () -> {
            UserFactory.createUser("Test User", "test@example.com", "password", "invalidType",true);
        });
    }

    @Test
    public void testCreateUserWithId() {
        // Test creating user with ID
        User student = UserFactory.createUser("John Doe", "john@example.com", "password", "student", "123456", true);
        assertTrue(student instanceof Student);
        assertEquals("123456", student.id);

        User faculty = UserFactory.createUser("Alice Smith", "alice@example.com", "password", "faculty", "654321", true);
        assertTrue(faculty instanceof Faculty);
        assertEquals("654321", faculty.id);

        User nonFaculty = UserFactory.createUser("Bob Johnson", "bob@example.com", "password", "non-faculty", "987654", true);
        assertTrue(nonFaculty instanceof NonFaculty);
        assertEquals("987654", nonFaculty.id);

        User visitor = UserFactory.createUser("Eva Green", "eva@example.com", "password", "visitor", true);
        assertTrue(visitor instanceof Visitor);
        assertEquals(visitor.id, visitor.id);

        User manager = UserFactory.createUser("Mike Brown", "mike@example.com", "password", "manager", true);
        assertTrue(manager instanceof LibraryManager);
        assertEquals(manager.id, manager.id);

    }
    @Test
    public void testCreateUserStudent() {
        User user = UserFactory.createUser("John Doe", "john@example.com", "password", "student", "12345", true);
        assertTrue(user instanceof Student);
        assertEquals("John Doe", user.name);
        assertEquals("john@example.com", user.email);
        assertEquals("password", user.getPassword());
        assertEquals("12345", ((Student) user).id);
        assertTrue(((Student) user).isVerified);
    }

    @Test
    public void testCreateUserFaculty() {
        User user = UserFactory.createUser("Jane Smith", "jane@example.com", "password", "faculty", "67890", true);
        assertTrue(user instanceof Faculty);
        assertEquals("Jane Smith", user.name);
        assertEquals("jane@example.com", user.email);
        assertEquals("password", user.getPassword());
        assertEquals("67890", ((Faculty) user).id);
        assertTrue(((Faculty) user).isVerified);
    }

    @Test
    public void testCreateUserNonFaculty() {
        User user = UserFactory.createUser("Alice Johnson", "alice@example.com", "password", "non-faculty", "54321", true);
        assertTrue(user instanceof NonFaculty);
        assertEquals("Alice Johnson", user.name);
        assertEquals("alice@example.com", user.email);
        assertEquals("password", user.getPassword());
        assertEquals("54321", ((NonFaculty) user).id);
        assertTrue(((NonFaculty) user).isVerified);
    }

    @Test
    public void testCreateUserVisitor() {
        User user = UserFactory.createUser("Visitor", "visitor@example.com", "password", "visitor", "V123", false);
        assertTrue(user instanceof Visitor);
        assertEquals("Visitor", user.name);
        assertEquals("visitor@example.com", user.email);
        assertEquals("password", user.getPassword());
        assertEquals("V123", ((Visitor) user).id);
    }

    @Test
    public void testCreateUserManager() {
        User user = UserFactory.createUser("Manager", "manager@example.com", "password", "manager", "M456", true);
        assertTrue(user instanceof LibraryManager);
        assertEquals("Manager", user.name);
        assertEquals("manager@example.com", user.email);
        assertEquals("password", user.getPassword());
        assertEquals("M456", ((LibraryManager) user).id);
        assertTrue(((LibraryManager) user).isVerified);
    }

    @Test
    public void testCreateUserInvalidType() {
        assertThrows(IllegalArgumentException.class, () -> {
            UserFactory.createUser("Invalid User", "invalid@example.com", "password", "invalidType", "123", true);
        });
    }

    @Test
    public void testRentItemUserLimitExceeded() {
        // Create a user with a limit of 10 rented items
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", true);

        // Create a physical item
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");

        // Attempt to rent the item
        LibrarySystem librarySystem = new LibrarySystem();
        String result = librarySystem.RentItem(item, user);

        assertEquals("Item Book rented successfully.", result);
    }

    // More test cases for RentItem function...


    // More test cases for searchItem function...

    @Test
    public void testSubscribe() {
        // Create a user
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", true);

        // Create a newsletter
        Newsletter newsletter = new NewsletterProxy();

        // Create a payment
        Payment payment = new DebitCardPayment(); // Instantiate DebitCardPayment
        // Create a newsletter proxy
        NewsletterProxy newsletterProxy = new NewsletterProxy();

        // Subscribe to the newsletter
        boolean result = newsletterProxy.subscribe(user, newsletter, payment);

        assertTrue(result);
        assertTrue(user.subscriptions.containsKey(newsletter));
        assertTrue(user.subscriptions.get(newsletter));
    }

    @Test
    public void Payment() {
        // Create a user
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", true);

        // Create a newsletter
        Newsletter newsletter = new NewsletterProxy();

        // Create a payment
        Payment payment = new MobileWalletPayment(); // Instantiate DebitCardPayment
        // Create a newsletter proxy
        NewsletterProxy newsletterProxy = new NewsletterProxy();

        // Subscribe to the newsletter
        boolean result = newsletterProxy.subscribe(user, newsletter, payment);

        assertTrue(result);
        assertTrue(user.subscriptions.containsKey(newsletter));
        assertTrue(user.subscriptions.get(newsletter));
    }

    @Test
    public void testCancelSubscription() {
        // Create a user
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", true);

        // Create a newsletter
        Newsletter newsletter = new NewsletterProxy();

        // Create a payment
        Payment payment = new CreditCardPayment();

        // Create a newsletter proxy
        NewsletterProxy newsletterProxy = new NewsletterProxy();

        // Subscribe to the newsletter
        newsletterProxy.subscribe(user, newsletter, payment);

        // Cancel the subscription
        boolean result = newsletterProxy.cancelSubscription(user, newsletter);

        assertTrue(result);
        assertFalse(user.subscriptions.get(newsletter));
    }

    @Test
    public void testBuyItem() {
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", true);
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.RentableAndPurchasable, "category");
        Payment payment = new MobileWalletPayment();

        // Call the method under test
        String result = LibrarySystem.BuyItem(item, payment, user, 0);

        // Assert the result
        assertEquals("Item Book purchased successfully.", result);

    }

    @Test
    public void testBuyItemWithDiscount() {
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", true);
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.RentableAndPurchasable, "category");
        Payment payment = new MobileWalletPayment();

        // Call the method under test
        String result = LibrarySystem.BuyItem(item, payment, user, 10);

        // Assert the result
        assertEquals("Item Book purchased successfully.", result);

    }

    @Test
    public void testBuyItemNotPurchasable() {
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", true);
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");
        Payment payment = new MobileWalletPayment();

        // Call the method under test
        String result = LibrarySystem.BuyItem(item, payment, user, 0);

        // Assert the result
        assertEquals("Sorry, item Book cannot be purchased", result);

    }
    @Test
    public void testAddItemToLibrary() {
        // Create a LibraryManager instance
        LibraryManager manager = new LibraryManager("John Doe", "john@example.com", "password", "manager");
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");

        // Create a mock command for adding an item
        Command addItemCommand = new AddItemCommand(item);

        // Set the command for adding an item
        manager.setAddItemCommand(addItemCommand);

        // Call the method under test
        manager.addItemToLibrary(addItemCommand);

        // Assert the result if needed
        assertTrue(LibrarySystem.inventory.containsKey(item.name));
    }

    @Test
    public void testEnableItemForRenting() {
        // Similar approach as above
        LibraryManager manager = new LibraryManager("John Doe", "john@example.com", "password", "manager");
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Disabled, "category");

        // Create a mock command for adding an item
        Command enableItemCommand = new EnableItemCommand(item);

        // Set the command for adding an item
        manager.setEnableItemCommand(enableItemCommand);

        // Call the method under test
        manager.enableItemForRenting(enableItemCommand);

        assertEquals(ItemPermission.Rentable, item.permission);
    }

    @Test
    public void testDisableItemForRenting() {
        // Similar approach as above
        LibraryManager manager = new LibraryManager("John Doe", "john@example.com", "password", "manager");
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");

        Command disableItemCommand = new DisableItemCommand(item);

        manager.setDisableItemCommand(disableItemCommand);

        manager.disableItemForRenting(disableItemCommand);

        assertEquals(ItemPermission.Disabled, item.permission);
    }

    @Test
    public void testDeleteItem() {
        // Similar approach as above
        LibraryManager manager = new LibraryManager("John Doe", "john@example.com", "password", "manager");
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");

        Command deleteItemCommand = new DeleteItemCommand(item);

        manager.setDeleteItemCommand(deleteItemCommand);

        manager.deleteItem(deleteItemCommand);

        assertFalse(LibrarySystem.inventory.containsKey(item.name));

    }

    @Test
    public void testReturnItem() {
        // Similar approach as above
        LibraryManager manager = new LibraryManager("John Doe", "john@example.com", "password", "manager");
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", true);

        Command returnItemCommand = new ReturnItemCommand(item, user);

        manager.setReturnItemCommand(returnItemCommand);

        manager.returnItem(returnItemCommand);

        assertEquals(item.copies + 1, LibrarySystem.inventory.get(item.name).intValue());
    }

    @Test
    public void testVerify() {
        // Create a user
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", false);

        // Call the static method verify from LibraryManager class
        boolean verified = LibraryManager.verify(user);

        // Assert the result
        assertTrue(verified);
    }
}
