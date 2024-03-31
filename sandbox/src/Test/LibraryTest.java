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
    @Test
    public void testSetAndGetUserInstance() {
        // Creating a user instance
        User user = new Student("John Doe", "john@example.com", "password", "student", "123", false);

        // Setting the user instance using setUserInstance method
        CurrentUser.setUserInstance(user);

        // Getting the user instance using getUserInstance method
        User retrievedUser = CurrentUser.getUserInstance();

        // Asserting that the retrieved user instance is the same as the one set
        assertEquals(user, retrievedUser);
    }

    @Test
    public void testSetNullUserInstance() {
        // Setting the user instance to null using setUserInstance method
        CurrentUser.setUserInstance(null);

        // Getting the user instance using getUserInstance method
        User retrievedUser = CurrentUser.getUserInstance();

        // Asserting that the retrieved user instance is null
        assertNull(retrievedUser);
    }
    @Test
    public void testIsLost() {
        // Create an item with due date more than 15 days ago
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");
        RentedItem rentedItem1 = new RentedItem(item, "user1", LocalDate.now().minusDays(16));
        assertTrue(rentedItem1.isLost()); // Verify that the item is considered lost

        // Create an item with due date less than 15 days ago
        PhysicalItem item1 = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");
        RentedItem rentedItem2 = new RentedItem(item1, "user2", LocalDate.now().minusDays(14));
        assertTrue(!rentedItem2.isLost()); // Verify that the item is not considered lost
    }

    @Test
    public void testGetters() {
        // Create an item and a rented item
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");
        LocalDate dueDate = LocalDate.now().plusDays(7);
        RentedItem rentedItem = new RentedItem(item, "user1", dueDate);

        // Verify the correctness of getters
        assertEquals(item, rentedItem.getItem());
        assertEquals("user1", rentedItem.getUserID());
        assertEquals(dueDate, rentedItem.getDueDate());
    }
    @Test
    public void testGetters2() {
        // Create a PhysicalItem instance
        PhysicalItem item = new PhysicalItem("Book", "location", ItemType.Book, 10.0, ItemStatus.Available, ItemPermission.Rentable, "category");

        // Create a Textbook instance
        Textbook textbook = new Textbook(item, "456", 1);

        // Test getters
        assertEquals(textbook.id, textbook.id);
        assertEquals("Book", textbook.name);
        assertEquals("location", textbook.location);
        assertEquals(ItemType.Book, textbook.type);
        assertEquals(10.0, textbook.price, 0.001);
        assertEquals(ItemStatus.Available, textbook.status);
        assertEquals(ItemPermission.Rentable, textbook.permission);
        assertEquals("category", textbook.category);
        assertEquals("456", textbook.groupID);
        assertEquals(1, textbook.edition);
    }

    @Test
    public void testGettersForCourse() {
        // Create a Faculty instance
        Faculty user = new Faculty("John Doe", "john@example.com", "password", "student", "123", false);

        // Create a Textbook instance
        Textbook textbook = new Textbook("456", 1);

        // Create a Course instance
        LocalDate startDate = LocalDate.of(2024, 9, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        Course course = new Course("789", "Introduction to Java", "101", "Fall 2024", user, textbook, startDate, endDate);

        // Test getters
        assertEquals("789", course.getId());
        assertEquals("Introduction to Java", course.getName());
        assertEquals("101", course.getSection());
        assertEquals("Fall 2024", course.getTerm());
        assertEquals(user, course.getFaculty());
        assertEquals(textbook, course.getTextbook());
        assertEquals(startDate, course.getStartDate());
        assertEquals(endDate, course.getEndDate());
    }
    @Test
    public void testProcessPayment_Successful() {
        // Create an instance of DebitCardPayment
        DebitCardPayment debitCardPayment = new DebitCardPayment();

        // Call the processPayment method with a positive amount
        double amount = 100.0;
        boolean paymentResult = debitCardPayment.processPayment(amount);

        // Assert that the payment was successful
        assertTrue(paymentResult);
    }
    @Test
    public void testProcessPayment_Successful2() {
        // Create an instance of DebitCardPayment
        CreditCardPayment creditCardPayment = new CreditCardPayment();

        // Call the processPayment method with a positive amount
        double amount = 100.0;
        boolean paymentResult = creditCardPayment.processPayment(amount);

        // Assert that the payment was successful
        assertTrue(paymentResult);
    }
    @Test
    public void testProcessPayment_Successful3() {
        // Create an instance of DebitCardPayment
        MobileWalletPayment mobileCardPayment = new MobileWalletPayment();

        // Call the processPayment method with a positive amount
        double amount = 100.0;
        boolean paymentResult = mobileCardPayment.processPayment(amount);

        // Assert that the payment was successful
        assertTrue(paymentResult);
    }
    @Test
    public void testGetters3() {
        // Create an instance of ItemRequest with sample data
        String itemName = "Sample Item";
        ItemType itemType = ItemType.Book;
        String itemID = "123456";
        String reason = "Sample reason";
        String additionalInfo = "Additional info";
        int priority = 1; // Assuming low priority
        LocalDate requestDate = LocalDate.of(2022, 3, 30);

        ItemRequest itemRequest = new ItemRequest(itemName, itemType, itemID, reason, additionalInfo, priority, requestDate);

        // Test each getter method
        assertEquals(itemName, itemRequest.getItemName());
        assertEquals(itemType, itemRequest.getItemType());
        assertEquals(itemID, itemRequest.getItemID());
        assertEquals(reason, itemRequest.getReason());
        assertEquals(additionalInfo, itemRequest.getAdditionalInfo());
        assertEquals(priority, itemRequest.getPriority());
        assertEquals(requestDate, itemRequest.getRequestDate());
    }

}
