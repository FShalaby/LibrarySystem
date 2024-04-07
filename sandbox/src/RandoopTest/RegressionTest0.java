package RandoopTest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        java.util.List<sandbox.Newsletter> newsletterList0 = sandbox.Database.getNewsletters();
        org.junit.Assert.assertNotNull(newsletterList0);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        sandbox.Database.deleteItem("");
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        sandbox.User user0 = null;
        sandbox.CurrentUser.setUserInstance(user0);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        sandbox.Textbook textbook1 = sandbox.Database.getTextbook("");
        org.junit.Assert.assertNull(textbook1);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.ItemType itemType1 = item0.type;
        org.junit.Assert.assertNull(itemType1);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        sandbox.Database.deleteRental("hi!", "hi!");
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        java.util.List<sandbox.Newsletter> newsletterList1 = sandbox.Database.getUserSubscription("");
        org.junit.Assert.assertNotNull(newsletterList1);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        sandbox.Database.insertSubscription("hi!", "");
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        sandbox.ItemPermission itemPermission1 = sandbox.ItemPermission.from((int) (byte) 0);
        org.junit.Assert.assertTrue("'" + itemPermission1 + "' != '" + sandbox.ItemPermission.Disabled + "'", itemPermission1.equals(sandbox.ItemPermission.Disabled));
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        sandbox.Visitor visitor5 = new sandbox.Visitor("hi!", "", "", "", "hi!");
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        boolean boolean6 = sandbox.LibraryManager.verify((sandbox.User) nonFaculty5);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap7 = null;
        nonFaculty5.subscriptions = newsletterMap7;
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        librarySystem0.penalty = 0.0d;
        sandbox.Newsletter newsletter5 = null;
        librarySystem0.newsletter = newsletter5;
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        java.util.List<sandbox.ItemRequest> itemRequestList0 = sandbox.Database.getAllRequests();
        org.junit.Assert.assertNotNull(itemRequestList0);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        sandbox.CategoryStrategy categoryStrategy0 = new sandbox.CategoryStrategy();
        java.time.LocalDate localDate1 = null;
        categoryStrategy0.dueDate = localDate1;
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        sandbox.Database.insertRental("hi!", "f213457c-5ed7-4725");
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        sandbox.UserFactory userFactory0 = new sandbox.UserFactory();
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap6 = null;
        nonFaculty5.subscriptions = newsletterMap6;
        java.lang.String str8 = nonFaculty5.getPassword();
        int int9 = nonFaculty5.getLost();
        nonFaculty5.writeUserCsv();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        sandbox.Visitor visitor4 = new sandbox.Visitor("hi!", "f213457c-5ed7-4725", "", "f213457c-5ed7-4725");
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.price = 0.0d;
        java.lang.String str4 = item0.category;
        java.time.LocalDate localDate6 = null;
        // The following exception was thrown during execution in test generation
        try {
            sandbox.RentedItem rentedItem7 = new sandbox.RentedItem(item0, "", localDate6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.plusDays(long)\" because \"<parameter3>\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(localDate1);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        sandbox.Database.insertRental("", "f213457c-5ed7-4725");
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        sandbox.ItemStatus itemStatus0 = sandbox.ItemStatus.Purchased;
        int int1 = itemStatus0.getValue();
        org.junit.Assert.assertTrue("'" + itemStatus0 + "' != '" + sandbox.ItemStatus.Purchased + "'", itemStatus0.equals(sandbox.ItemStatus.Purchased));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 2 + "'", int1 == 2);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.ItemPermission itemPermission1 = item0.permission;
        org.junit.Assert.assertNull(itemPermission1);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        java.lang.String str0 = sandbox.LibrarySystem.checkUnavailableNewTextbooks();
// flaky:         org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n" + "'", str0, "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        sandbox.ItemType itemType0 = sandbox.ItemType.Book;
        org.junit.Assert.assertTrue("'" + itemType0 + "' != '" + sandbox.ItemType.Book + "'", itemType0.equals(sandbox.ItemType.Book));
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        sandbox.Item item1 = sandbox.Database.getItem("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
        org.junit.Assert.assertNull(item1);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.CreditCardPayment creditCardPayment3 = new sandbox.CreditCardPayment();
        librarySystem0.payment = creditCardPayment3;
        sandbox.Item item5 = librarySystem0.item;
        librarySystem0.penalty = '#';
        sandbox.NonFaculty nonFaculty14 = new sandbox.NonFaculty("hi!", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "f213457c-5ed7-4725", "hi!", "", false);
        librarySystem0.user = nonFaculty14;
        org.junit.Assert.assertNull(item5);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        java.util.HashMap<java.lang.String, sandbox.Item> strMap0 = sandbox.LibrarySystem.getItemMap();
        org.junit.Assert.assertNotNull(strMap0);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        java.util.HashMap<java.lang.String, sandbox.Item> strMap0 = sandbox.LibrarySystem.itemMap;
        sandbox.LibrarySystem.itemMap = strMap0;
        org.junit.Assert.assertNotNull(strMap0);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        sandbox.Faculty faculty6 = new sandbox.Faculty("", "", "f213457c-5ed7-4725", "", "", false);
        boolean boolean7 = faculty6.isVerified;
        java.lang.String str8 = faculty6.id;
        java.lang.String str9 = faculty6.name;
        java.util.List<sandbox.Course> courseList10 = faculty6.getCourses();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertNotNull(courseList10);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        // The following exception was thrown during execution in test generation
        try {
            sandbox.User user1 = sandbox.Database.getUser("f213457c-5ed7-4725");
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        sandbox.Course course0 = null;
        // The following exception was thrown during execution in test generation
        try {
            sandbox.Textbook textbook1 = sandbox.LibrarySystem.getLatestTextbook(course0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.Course.getTextbook()\" because \"<parameter1>\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        librarySystem0.penalty = 0.0d;
        java.util.List<sandbox.Item> itemList6 = librarySystem0.getRecommendations("hi!");
        sandbox.Item item8 = librarySystem0.searchItem("hi!");
        java.util.List<sandbox.Item> itemList10 = librarySystem0.getRecommendations("f213457c-5ed7-4725");
        java.util.List<sandbox.Item> itemList12 = librarySystem0.getRecommendations("f213457c-5ed7-4725");
        org.junit.Assert.assertNotNull(itemList6);
        org.junit.Assert.assertNull(item8);
        org.junit.Assert.assertNotNull(itemList10);
        org.junit.Assert.assertNotNull(itemList12);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        sandbox.Faculty faculty6 = new sandbox.Faculty("", "", "f213457c-5ed7-4725", "", "", false);
        boolean boolean7 = faculty6.isVerified;
        java.lang.String str8 = faculty6.id;
        java.lang.String str9 = faculty6.getPassword();
        sandbox.RentedItem rentedItem10 = null;
        // The following exception was thrown during execution in test generation
        try {
            faculty6.addRentedItem(rentedItem10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.RentedItem.getItem()\" because \"<parameter1>\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "f213457c-5ed7-4725" + "'", str9, "f213457c-5ed7-4725");
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.id = "";
        item0.name = "";
        java.lang.String str6 = item0.generateUniqueID();
        item0.name = "";
        java.lang.String str9 = item0.generateUniqueID();
        org.junit.Assert.assertNull(localDate1);
// flaky:         org.junit.Assert.assertEquals("'" + str6 + "' != '" + "a775c5bb-b09b-4171" + "'", str6, "a775c5bb-b09b-4171");
// flaky:         org.junit.Assert.assertEquals("'" + str9 + "' != '" + "7b483788-f009-4b5a" + "'", str9, "7b483788-f009-4b5a");
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        sandbox.ItemPermission itemPermission1 = sandbox.ItemPermission.RentableAndPurchasable;
        int int2 = itemPermission1.getValue();
        sandbox.Database.updateItemPermission("a775c5bb-b09b-4171", itemPermission1);
        org.junit.Assert.assertTrue("'" + itemPermission1 + "' != '" + sandbox.ItemPermission.RentableAndPurchasable + "'", itemPermission1.equals(sandbox.ItemPermission.RentableAndPurchasable));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.price = 0.0d;
        item0.location = "hi!";
        java.lang.String str6 = item0.generateUniqueID();
        org.junit.Assert.assertNull(localDate1);
// flaky:         org.junit.Assert.assertEquals("'" + str6 + "' != '" + "4ddb1bcd-3318-4d6e" + "'", str6, "4ddb1bcd-3318-4d6e");
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        librarySystem0.penalty = 0.0d;
        java.util.List<sandbox.Item> itemList6 = librarySystem0.getRecommendations("hi!");
        sandbox.Item item8 = librarySystem0.searchItem("hi!");
        java.util.List<sandbox.Item> itemList10 = librarySystem0.getRecommendations("f213457c-5ed7-4725");
        sandbox.Payment payment11 = librarySystem0.payment;
        org.junit.Assert.assertNotNull(itemList6);
        org.junit.Assert.assertNull(item8);
        org.junit.Assert.assertNotNull(itemList10);
        org.junit.Assert.assertNull(payment11);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        java.util.HashMap<java.lang.String, java.lang.String> strMap0 = sandbox.LibrarySystem.genre;
        sandbox.LibrarySystem.genre = strMap0;
        org.junit.Assert.assertNotNull(strMap0);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        java.lang.String str9 = itemRequest8.getItemID();
        java.lang.Class<?> wildcardClass10 = itemRequest8.getClass();
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "76b8a6a5-5e47-488b" + "'", str9, "76b8a6a5-5e47-488b");
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        sandbox.Database.insertRental("a775c5bb-b09b-4171", "hi!");
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        // The following exception was thrown during execution in test generation
        try {
            sandbox.User user5 = sandbox.UserFactory.createUser("", "a775c5bb-b09b-4171", "hi!", "hi!", true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap6 = null;
        nonFaculty5.subscriptions = newsletterMap6;
        java.lang.String str8 = nonFaculty5.getPassword();
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap9 = nonFaculty5.subscriptions;
        sandbox.RentedItem[] rentedItemArray10 = new sandbox.RentedItem[] {};
        java.util.ArrayList<sandbox.RentedItem> rentedItemList11 = new java.util.ArrayList<sandbox.RentedItem>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<sandbox.RentedItem>) rentedItemList11, rentedItemArray10);
        nonFaculty5.setRentedItems((java.util.List<sandbox.RentedItem>) rentedItemList11);
        nonFaculty5.isVerified = true;
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertNull(newsletterMap9);
        org.junit.Assert.assertNotNull(rentedItemArray10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        sandbox.NonFaculty nonFaculty6 = new sandbox.NonFaculty("", "4ddb1bcd-3318-4d6e", "a775c5bb-b09b-4171", "76b8a6a5-5e47-488b", "76b8a6a5-5e47-488b", true);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        java.util.List<sandbox.Newsletter> newsletterList1 = sandbox.Database.getUserSubscription("7b483788-f009-4b5a");
        org.junit.Assert.assertNotNull(newsletterList1);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        sandbox.ItemType itemType9 = itemRequest8.getItemType();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str10 = sandbox.LibrarySystem.submitItemRequest(itemRequest8);
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index 4 out of bounds for length 4");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertTrue("'" + itemType9 + "' != '" + sandbox.ItemType.Textbook + "'", itemType9.equals(sandbox.ItemType.Textbook));
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        java.lang.String str9 = itemRequest8.getItemID();
        java.lang.String str10 = itemRequest8.getAdditionalInfo();
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "76b8a6a5-5e47-488b" + "'", str9, "76b8a6a5-5e47-488b");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.Newsletter newsletter3 = null;
        librarySystem0.newsletter = newsletter3;
        sandbox.NonFaculty nonFaculty10 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap11 = null;
        nonFaculty10.subscriptions = newsletterMap11;
        java.lang.String str13 = nonFaculty10.email;
        librarySystem0.user = nonFaculty10;
        java.lang.String str15 = nonFaculty10.name;
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "hi!" + "'", str13, "hi!");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "" + "'", str15, "");
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        sandbox.ItemPermission itemPermission0 = sandbox.ItemPermission.Disabled;
        org.junit.Assert.assertTrue("'" + itemPermission0 + "' != '" + sandbox.ItemPermission.Disabled + "'", itemPermission0.equals(sandbox.ItemPermission.Disabled));
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        sandbox.Discount discount0 = new sandbox.Discount();
        discount0.item_id = "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n";
        discount0.item_id = "76b8a6a5-5e47-488b";
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        sandbox.Student student5 = new sandbox.Student("hi!", "7b483788-f009-4b5a", "f213457c-5ed7-4725", "76b8a6a5-5e47-488b", false);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        sandbox.Student student6 = new sandbox.Student("a775c5bb-b09b-4171", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "a775c5bb-b09b-4171", "hi!", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", true);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.id = "";
        item0.name = "";
        sandbox.ItemPermission itemPermission6 = item0.permission;
        java.lang.String str7 = item0.id;
        org.junit.Assert.assertNull(localDate1);
        org.junit.Assert.assertNull(itemPermission6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "" + "'", str7, "");
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        java.lang.String str9 = itemRequest8.getItemID();
        java.lang.String str10 = itemRequest8.getItemName();
        java.lang.String str11 = itemRequest8.getReason();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str12 = sandbox.LibrarySystem.submitItemRequest(itemRequest8);
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index 4 out of bounds for length 4");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "76b8a6a5-5e47-488b" + "'", str9, "76b8a6a5-5e47-488b");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n" + "'", str11, "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        // The following exception was thrown during execution in test generation
        try {
            sandbox.User user5 = sandbox.UserFactory.createUser("76b8a6a5-5e47-488b", "7b483788-f009-4b5a", "", "7b483788-f009-4b5a", true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        sandbox.ItemPermission itemPermission2 = sandbox.ItemPermission.Rentable;
        sandbox.Database.updateItemPermission("f213457c-5ed7-4725", itemPermission2);
        sandbox.Database.updateItemPermission("hi!", itemPermission2);
        org.junit.Assert.assertTrue("'" + itemPermission2 + "' != '" + sandbox.ItemPermission.Rentable + "'", itemPermission2.equals(sandbox.ItemPermission.Rentable));
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        sandbox.ItemPermission itemPermission0 = sandbox.ItemPermission.Purchasable;
        org.junit.Assert.assertTrue("'" + itemPermission0 + "' != '" + sandbox.ItemPermission.Purchasable + "'", itemPermission0.equals(sandbox.ItemPermission.Purchasable));
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        sandbox.Faculty faculty6 = new sandbox.Faculty("hi!", "a775c5bb-b09b-4171", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "", "4ddb1bcd-3318-4d6e", false);
        double double7 = faculty6.getPenalty();
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 0.0d + "'", double7 == 0.0d);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        java.util.Map<java.lang.String, java.lang.String> strMap0 = sandbox.Database.getAllUsersMap();
        org.junit.Assert.assertNotNull(strMap0);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str1 = sandbox.LibrarySystem.fetchNewsletterContent("f213457c-5ed7-4725");
            org.junit.Assert.fail("Expected exception of type java.net.MalformedURLException; message: no protocol: f213457c-5ed7-4725");
        } catch (java.net.MalformedURLException e) {
            // Expected exception.
        }
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.id = "";
        item0.name = "";
        sandbox.ItemPermission itemPermission6 = item0.permission;
        sandbox.ItemPermission itemPermission7 = item0.permission;
        java.time.LocalDate localDate9 = null;
        // The following exception was thrown during execution in test generation
        try {
            sandbox.RentedItem rentedItem10 = new sandbox.RentedItem(item0, "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", localDate9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.plusDays(long)\" because \"<parameter3>\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(localDate1);
        org.junit.Assert.assertNull(itemPermission6);
        org.junit.Assert.assertNull(itemPermission7);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.id = "";
        item0.name = "";
        java.lang.String str6 = item0.generateUniqueID();
        item0.name = "";
        sandbox.ItemType itemType9 = item0.type;
        org.junit.Assert.assertNull(localDate1);
// flaky:         org.junit.Assert.assertEquals("'" + str6 + "' != '" + "6894f2ec-beb5-4229" + "'", str6, "6894f2ec-beb5-4229");
        org.junit.Assert.assertNull(itemType9);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap6 = null;
        nonFaculty5.subscriptions = newsletterMap6;
        nonFaculty5.isVerified = true;
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        java.util.HashMap<java.lang.String, java.lang.Integer> strMap0 = sandbox.LibrarySystem.inventory;
        org.junit.Assert.assertNotNull(strMap0);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        sandbox.Faculty faculty6 = new sandbox.Faculty("", "", "f213457c-5ed7-4725", "", "", false);
        boolean boolean7 = faculty6.isVerified;
        java.lang.String str8 = faculty6.id;
        java.lang.String str9 = faculty6.name;
        java.lang.String str10 = faculty6.getPassword();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "f213457c-5ed7-4725" + "'", str10, "f213457c-5ed7-4725");
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.User user3 = librarySystem0.user;
        org.junit.Assert.assertNull(user3);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        boolean boolean6 = sandbox.LibraryManager.verify((sandbox.User) nonFaculty5);
        boolean boolean7 = sandbox.LibraryManager.verify((sandbox.User) nonFaculty5);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap8 = null;
        nonFaculty5.subscriptions = newsletterMap8;
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.Textbook textbook3 = new sandbox.Textbook(item0, "76b8a6a5-5e47-488b", (int) (byte) 0);
        item0.id = "a775c5bb-b09b-4171";
        java.lang.String str6 = item0.category;
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        sandbox.Textbook textbook2 = new sandbox.Textbook("", (int) (byte) 1);
        textbook2.groupID = "";
        java.lang.String str5 = textbook2.groupID;
        textbook2.groupID = "hi!";
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        sandbox.Student student5 = new sandbox.Student("76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", "", true);
        student5.email = "76b8a6a5-5e47-488b";
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        nonFaculty5.name = "4ddb1bcd-3318-4d6e";
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        sandbox.Visitor visitor5 = new sandbox.Visitor("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", "f213457c-5ed7-4725", "f213457c-5ed7-4725", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
        sandbox.CurrentUser.setUserInstance((sandbox.User) visitor5);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        double double6 = nonFaculty5.getPenalty();
        java.lang.String str7 = nonFaculty5.id;
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
// flaky:         org.junit.Assert.assertEquals("'" + str7 + "' != '" + "5b5131" + "'", str7, "5b5131");
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.disableItemForRenting(command5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.Command.execute()\" because \"this.disableItemCommand\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        sandbox.NewsletterProxy newsletterProxy0 = new sandbox.NewsletterProxy();
        newsletterProxy0.url = "hi!";
        sandbox.Newsletter newsletter3 = newsletterProxy0.newsletter;
        org.junit.Assert.assertNull(newsletter3);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        sandbox.ItemType itemType0 = sandbox.ItemType.Unknown;
        org.junit.Assert.assertTrue("'" + itemType0 + "' != '" + sandbox.ItemType.Unknown + "'", itemType0.equals(sandbox.ItemType.Unknown));
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.id = "76b8a6a5-5e47-488b";
        org.junit.Assert.assertNull(localDate1);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.addItemToLibrary(command5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.Command.execute()\" because \"this.addItemCommand\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        sandbox.Item item0 = new sandbox.Item();
        int int1 = item0.copies;
        java.lang.String str2 = item0.location;
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        sandbox.Textbook textbook2 = new sandbox.Textbook("", (int) (byte) 1);
        textbook2.groupID = "";
        java.lang.String str5 = textbook2.groupID;
        java.lang.String str6 = textbook2.groupID;
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        // The following exception was thrown during execution in test generation
        try {
            sandbox.User user1 = sandbox.Database.getUserByEmail("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        sandbox.Discount discount0 = new sandbox.Discount();
        discount0.code = "hi!";
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.enableItemForRenting(command5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.Command.execute()\" because \"this.enableItemCommand\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap6 = null;
        nonFaculty5.subscriptions = newsletterMap6;
        java.lang.String str8 = nonFaculty5.email;
        nonFaculty5.type = "hi!";
        double double11 = nonFaculty5.getPenalty();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 0.0d + "'", double11 == 0.0d);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.Textbook textbook3 = new sandbox.Textbook(item0, "76b8a6a5-5e47-488b", (int) (byte) 0);
        item0.id = "a775c5bb-b09b-4171";
        item0.id = "a775c5bb-b09b-4171";
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        sandbox.Textbook textbook1 = sandbox.Database.getTextbook("7b483788-f009-4b5a");
        org.junit.Assert.assertNull(textbook1);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        sandbox.Student student6 = new sandbox.Student("5b5131", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "f213457c-5ed7-4725", "hi!", "hi!", true);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        sandbox.Textbook textbook2 = new sandbox.Textbook("hi!", 1);
        java.lang.String str3 = textbook2.groupID;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        sandbox.ItemPermission itemPermission1 = sandbox.ItemPermission.from((int) (short) 100);
        org.junit.Assert.assertTrue("'" + itemPermission1 + "' != '" + sandbox.ItemPermission.Disabled + "'", itemPermission1.equals(sandbox.ItemPermission.Disabled));
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        // The following exception was thrown during execution in test generation
        try {
            sandbox.User user1 = sandbox.Database.getUser("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.CreditCardPayment creditCardPayment3 = new sandbox.CreditCardPayment();
        librarySystem0.payment = creditCardPayment3;
        sandbox.Item item5 = librarySystem0.item;
        librarySystem0.penalty = '#';
        sandbox.LibrarySystem librarySystem8 = new sandbox.LibrarySystem();
        librarySystem8.penalty = (byte) 10;
        sandbox.CreditCardPayment creditCardPayment11 = new sandbox.CreditCardPayment();
        librarySystem8.payment = creditCardPayment11;
        librarySystem0.payment = creditCardPayment11;
        librarySystem0.penalty = 0L;
        org.junit.Assert.assertNull(item5);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        sandbox.Faculty faculty6 = new sandbox.Faculty("", "", "f213457c-5ed7-4725", "", "", false);
        boolean boolean7 = faculty6.isVerified;
        java.lang.String str8 = faculty6.id;
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap9 = faculty6.subscriptions;
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
        org.junit.Assert.assertNotNull(newsletterMap9);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        sandbox.ItemStatus itemStatus0 = sandbox.ItemStatus.Available;
        org.junit.Assert.assertTrue("'" + itemStatus0 + "' != '" + sandbox.ItemStatus.Available + "'", itemStatus0.equals(sandbox.ItemStatus.Available));
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        double double6 = nonFaculty5.getPenalty();
        java.lang.String str7 = nonFaculty5.getPassword();
        java.lang.String str8 = nonFaculty5.getPassword();
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        sandbox.Payment payment1 = librarySystem0.payment;
        sandbox.Item item3 = librarySystem0.searchItem("a775c5bb-b09b-4171");
        org.junit.Assert.assertNull(payment1);
        org.junit.Assert.assertNull(item3);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("hi!", "a775c5bb-b09b-4171", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        libraryManager4.setReturnItemCommand(command5);
        sandbox.Command command7 = null;
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.deleteItem(command7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.Command.execute()\" because \"this.deleteItemCommand\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        sandbox.Textbook textbook2 = new sandbox.Textbook("", (int) (byte) 1);
        int int3 = textbook2.edition;
        sandbox.ItemStatus itemStatus4 = textbook2.status;
        int int5 = textbook2.edition;
        sandbox.Textbook textbook8 = new sandbox.Textbook((sandbox.Item) textbook2, "f213457c-5ed7-4725", (-1));
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertNull(itemStatus4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        sandbox.Student student6 = new sandbox.Student("5b5131", "249d3f7a-6f32-41d8", "249d3f7a-6f32-41d8", "a775c5bb-b09b-4171", "6894f2ec-beb5-4229", true);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        librarySystem0.penalty = 0.0d;
        java.util.List<sandbox.Item> itemList6 = librarySystem0.getRecommendations("hi!");
        sandbox.Item item8 = librarySystem0.searchItem("hi!");
        java.util.List<sandbox.Item> itemList10 = librarySystem0.getRecommendations("f213457c-5ed7-4725");
        librarySystem0.penalty = (byte) -1;
        double double13 = librarySystem0.penalty;
        org.junit.Assert.assertNotNull(itemList6);
        org.junit.Assert.assertNull(item8);
        org.junit.Assert.assertNotNull(itemList10);
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + (-1.0d) + "'", double13 == (-1.0d));
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.CreditCardPayment creditCardPayment3 = new sandbox.CreditCardPayment();
        librarySystem0.payment = creditCardPayment3;
        sandbox.Item item5 = librarySystem0.item;
        librarySystem0.penalty = 0;
        sandbox.CreditCardPayment creditCardPayment8 = new sandbox.CreditCardPayment();
        librarySystem0.payment = creditCardPayment8;
        org.junit.Assert.assertNull(item5);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        sandbox.NewsletterProxy newsletterProxy0 = new sandbox.NewsletterProxy();
        sandbox.NonFaculty nonFaculty7 = new sandbox.NonFaculty("4ddb1bcd-3318-4d6e", "a775c5bb-b09b-4171", "7b483788-f009-4b5a", "", "hi!", false);
        sandbox.NewsletterProxy newsletterProxy8 = new sandbox.NewsletterProxy();
        newsletterProxy8.url = "hi!";
        java.lang.Boolean boolean11 = newsletterProxy0.cancelSubscription((sandbox.User) nonFaculty7, (sandbox.Newsletter) newsletterProxy8);
        double double12 = newsletterProxy8.fee;
        org.junit.Assert.assertEquals("'" + boolean11 + "' != '" + false + "'", boolean11, false);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 0.0d + "'", double12 == 0.0d);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        sandbox.Faculty faculty6 = new sandbox.Faculty("", "", "f213457c-5ed7-4725", "", "", false);
        faculty6.type = "6894f2ec-beb5-4229";
        java.util.List<sandbox.Course> courseList9 = faculty6.getCourses();
        org.junit.Assert.assertNotNull(courseList9);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.Textbook textbook3 = new sandbox.Textbook(item0, "76b8a6a5-5e47-488b", (int) (byte) 0);
        item0.id = "a775c5bb-b09b-4171";
        sandbox.ItemType itemType6 = item0.type;
        org.junit.Assert.assertNull(itemType6);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        sandbox.Discount discount0 = new sandbox.Discount();
        discount0.item_id = "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n";
        discount0.item_id = "f213457c-5ed7-4725";
        java.lang.String str5 = discount0.item_id;
        java.lang.String str6 = discount0.code;
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "f213457c-5ed7-4725" + "'", str5, "f213457c-5ed7-4725");
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        sandbox.Textbook textbook2 = new sandbox.Textbook("", (int) (byte) 1);
        textbook2.groupID = "";
        java.lang.String str5 = textbook2.groupID;
        java.lang.String str6 = textbook2.id;
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        sandbox.Faculty faculty6 = new sandbox.Faculty("", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "", "", "", false);
        sandbox.Database database7 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest8 = null;
        database7.insertRequest(itemRequest8);
        java.util.List<sandbox.Course> courseList11 = database7.getStudentCourses("7b483788-f009-4b5a");
        faculty6.setCourses(courseList11);
        faculty6.id = "6894f2ec-beb5-4229";
        org.junit.Assert.assertNotNull(database7);
        org.junit.Assert.assertNotNull(courseList11);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        java.util.List<sandbox.RentedItem> rentedItemList1 = sandbox.Database.getUserRentals("a775c5bb-b09b-4171");
        org.junit.Assert.assertNotNull(rentedItemList1);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        sandbox.Visitor visitor5 = new sandbox.Visitor("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", "f213457c-5ed7-4725", "f213457c-5ed7-4725", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
        int int6 = visitor5.getLimit();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.price = 0.0d;
        java.lang.String str4 = item0.id;
        java.lang.String str5 = item0.name;
        org.junit.Assert.assertNull(localDate1);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.Newsletter newsletter3 = null;
        librarySystem0.newsletter = newsletter3;
        sandbox.NonFaculty nonFaculty10 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap11 = null;
        nonFaculty10.subscriptions = newsletterMap11;
        java.lang.String str13 = nonFaculty10.email;
        librarySystem0.user = nonFaculty10;
        librarySystem0.penalty = '#';
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "hi!" + "'", str13, "hi!");
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.Newsletter newsletter3 = null;
        librarySystem0.newsletter = newsletter3;
        sandbox.NewsletterProxy newsletterProxy5 = new sandbox.NewsletterProxy();
        newsletterProxy5.url = "hi!";
        sandbox.NonFaculty nonFaculty13 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy14 = new sandbox.NewsletterProxy();
        newsletterProxy14.url = "hi!";
        java.lang.Boolean boolean17 = newsletterProxy5.cancelSubscription((sandbox.User) nonFaculty13, (sandbox.Newsletter) newsletterProxy14);
        newsletterProxy5.id = "6894f2ec-beb5-4229";
        java.lang.String str20 = newsletterProxy5.url;
        librarySystem0.newsletter = newsletterProxy5;
        sandbox.NewsletterProxy newsletterProxy22 = new sandbox.NewsletterProxy();
        newsletterProxy5.newsletter = newsletterProxy22;
        org.junit.Assert.assertEquals("'" + boolean17 + "' != '" + false + "'", boolean17, false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "hi!" + "'", str20, "hi!");
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        libraryManager4.setDisableItemCommand(command5);
        sandbox.Command command7 = null;
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.disableItemForRenting(command7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.Command.execute()\" because \"this.disableItemCommand\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        sandbox.NewsletterProxy newsletterProxy0 = new sandbox.NewsletterProxy();
        newsletterProxy0.url = "hi!";
        sandbox.NonFaculty nonFaculty8 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy9 = new sandbox.NewsletterProxy();
        newsletterProxy9.url = "hi!";
        java.lang.Boolean boolean12 = newsletterProxy0.cancelSubscription((sandbox.User) nonFaculty8, (sandbox.Newsletter) newsletterProxy9);
        sandbox.NewsletterProxy newsletterProxy13 = new sandbox.NewsletterProxy((sandbox.Newsletter) newsletterProxy0);
        org.junit.Assert.assertEquals("'" + boolean12 + "' != '" + false + "'", boolean12, false);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        sandbox.NonFaculty nonFaculty6 = new sandbox.NonFaculty("hi!", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "f213457c-5ed7-4725", "hi!", "", false);
        java.lang.String str7 = nonFaculty6.name;
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        sandbox.Visitor visitor4 = new sandbox.Visitor("f213457c-5ed7-4725", "149434", "76b8a6a5-5e47-488b", "f213457c-5ed7-4725");
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        sandbox.Student student5 = new sandbox.Student("f213457c-5ed7-4725", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", "76b8a6a5-5e47-488b", false);
        sandbox.Database database6 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest7 = null;
        database6.insertRequest(itemRequest7);
        java.util.List<sandbox.Course> courseList10 = database6.getStudentCourses("7b483788-f009-4b5a");
        student5.setCourses(courseList10);
        // The following exception was thrown during execution in test generation
        try {
            student5.writeUserCsv();
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(database6);
        org.junit.Assert.assertNotNull(courseList10);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("hi!", "a775c5bb-b09b-4171", "", "4ddb1bcd-3318-4d6e");
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.writeUserCsv();
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        sandbox.Database database0 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest1 = null;
        database0.insertRequest(itemRequest1);
        java.util.List<sandbox.Item> itemList3 = database0.getAllItems();
        sandbox.ItemType itemType5 = sandbox.ItemType.Textbook;
        int int6 = itemType5.getValue();
        java.time.LocalDate localDate11 = null;
        sandbox.ItemRequest itemRequest12 = new sandbox.ItemRequest("", itemType5, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate11);
        java.lang.String str13 = itemRequest12.getItemID();
        java.lang.String str14 = itemRequest12.getItemName();
        database0.insertRequest(itemRequest12);
        java.util.List<sandbox.Course> courseList17 = database0.getStudentCourses("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
        // The following exception was thrown during execution in test generation
        try {
            database0.insertUser("f213457c-5ed7-4725", "7b483788-f009-4b5a", "149434", "7b483788-f009-4b5a", "", true);
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(database0);
        org.junit.Assert.assertNotNull(itemList3);
        org.junit.Assert.assertTrue("'" + itemType5 + "' != '" + sandbox.ItemType.Textbook + "'", itemType5.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 3 + "'", int6 == 3);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "76b8a6a5-5e47-488b" + "'", str13, "76b8a6a5-5e47-488b");
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "" + "'", str14, "");
        org.junit.Assert.assertNotNull(courseList17);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        sandbox.Textbook textbook2 = new sandbox.Textbook("5b5131", (int) '#');
        sandbox.ItemType itemType3 = textbook2.type;
        org.junit.Assert.assertNull(itemType3);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.CreditCardPayment creditCardPayment3 = new sandbox.CreditCardPayment();
        librarySystem0.payment = creditCardPayment3;
        boolean boolean6 = creditCardPayment3.processPayment((double) 10);
        boolean boolean8 = creditCardPayment3.processPayment((double) 2);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        java.lang.String str9 = itemRequest8.getAdditionalInfo();
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.Newsletter newsletter3 = null;
        librarySystem0.newsletter = newsletter3;
        java.util.HashMap<java.lang.String, java.lang.Integer> strMap5 = librarySystem0.getInventory();
        sandbox.NewsletterProxy newsletterProxy6 = new sandbox.NewsletterProxy();
        librarySystem0.newsletter = newsletterProxy6;
        sandbox.User user8 = librarySystem0.user;
        org.junit.Assert.assertNotNull(strMap5);
        org.junit.Assert.assertNull(user8);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap6 = null;
        nonFaculty5.subscriptions = newsletterMap6;
        sandbox.CurrentUser.setUserInstance((sandbox.User) nonFaculty5);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap9 = nonFaculty5.subscriptions;
        org.junit.Assert.assertNull(newsletterMap9);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        sandbox.Visitor visitor5 = new sandbox.Visitor("5b5131", "", "6894f2ec-beb5-4229", "hi!", "");
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Item item5 = null;
        sandbox.NewsletterProxy newsletterProxy6 = new sandbox.NewsletterProxy();
        newsletterProxy6.url = "hi!";
        sandbox.NonFaculty nonFaculty14 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy15 = new sandbox.NewsletterProxy();
        newsletterProxy15.url = "hi!";
        java.lang.Boolean boolean18 = newsletterProxy6.cancelSubscription((sandbox.User) nonFaculty14, (sandbox.Newsletter) newsletterProxy15);
        nonFaculty14.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand21 = new sandbox.ReturnItemCommand(item5, (sandbox.User) nonFaculty14);
        libraryManager4.setDeleteItemCommand((sandbox.Command) returnItemCommand21);
        java.lang.String str23 = libraryManager4.id;
        libraryManager4.email = "";
        org.junit.Assert.assertEquals("'" + boolean18 + "' != '" + false + "'", boolean18, false);
// flaky:         org.junit.Assert.assertEquals("'" + str23 + "' != '" + "faf289" + "'", str23, "faf289");
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        sandbox.ItemType itemType2 = sandbox.ItemType.Textbook;
        int int3 = itemType2.getValue();
        java.time.LocalDate localDate8 = null;
        sandbox.ItemRequest itemRequest9 = new sandbox.ItemRequest("", itemType2, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate8);
        sandbox.ItemRequest itemRequest13 = new sandbox.ItemRequest("249d3f7a-6f32-41d8", itemType2, "7b483788-f009-4b5a", "5b5131", "");
        org.junit.Assert.assertTrue("'" + itemType2 + "' != '" + sandbox.ItemType.Textbook + "'", itemType2.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 3 + "'", int3 == 3);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        sandbox.Discount discount0 = new sandbox.Discount();
        discount0.item_id = "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n";
        java.lang.String str3 = discount0.item_id;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n" + "'", str3, "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.Textbook textbook3 = new sandbox.Textbook(item0, "76b8a6a5-5e47-488b", (int) (byte) 0);
        item0.id = "a775c5bb-b09b-4171";
        java.lang.Double double6 = item0.price;
        org.junit.Assert.assertNull(double6);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        sandbox.Textbook textbook2 = new sandbox.Textbook("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", 100);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        sandbox.Database.insertRental("b0bd619f-8ed5-499c", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        sandbox.MobileWalletPayment mobileWalletPayment0 = new sandbox.MobileWalletPayment();
        boolean boolean2 = mobileWalletPayment0.processPayment((double) ' ');
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        sandbox.Student student5 = new sandbox.Student("a775c5bb-b09b-4171", "a775c5bb-b09b-4171", "a775c5bb-b09b-4171", "faf289", true);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Item item5 = null;
        sandbox.NewsletterProxy newsletterProxy6 = new sandbox.NewsletterProxy();
        newsletterProxy6.url = "hi!";
        sandbox.NonFaculty nonFaculty14 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy15 = new sandbox.NewsletterProxy();
        newsletterProxy15.url = "hi!";
        java.lang.Boolean boolean18 = newsletterProxy6.cancelSubscription((sandbox.User) nonFaculty14, (sandbox.Newsletter) newsletterProxy15);
        nonFaculty14.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand21 = new sandbox.ReturnItemCommand(item5, (sandbox.User) nonFaculty14);
        libraryManager4.setDeleteItemCommand((sandbox.Command) returnItemCommand21);
        // The following exception was thrown during execution in test generation
        try {
            returnItemCommand21.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"name\" because \"this.item\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + boolean18 + "' != '" + false + "'", boolean18, false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        sandbox.Textbook textbook2 = new sandbox.Textbook("", (int) (byte) 1);
        textbook2.groupID = "";
        java.lang.String str5 = textbook2.groupID;
        sandbox.ItemPermission itemPermission6 = textbook2.permission;
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNull(itemPermission6);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        sandbox.NewsletterProxy newsletterProxy0 = new sandbox.NewsletterProxy();
        newsletterProxy0.url = "hi!";
        sandbox.NonFaculty nonFaculty8 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy9 = new sandbox.NewsletterProxy();
        newsletterProxy9.url = "hi!";
        java.lang.Boolean boolean12 = newsletterProxy0.cancelSubscription((sandbox.User) nonFaculty8, (sandbox.Newsletter) newsletterProxy9);
        sandbox.NonFaculty nonFaculty19 = new sandbox.NonFaculty("", "", "hi!", "", "", false);
        nonFaculty19.type = "4ddb1bcd-3318-4d6e";
        sandbox.NonFaculty nonFaculty28 = new sandbox.NonFaculty("", "", "hi!", "", "", false);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap29 = nonFaculty28.subscriptions;
        nonFaculty19.subscriptions = newsletterMap29;
        sandbox.NewsletterProxy newsletterProxy31 = new sandbox.NewsletterProxy();
        newsletterProxy31.url = "hi!";
        sandbox.LibrarySystem librarySystem34 = new sandbox.LibrarySystem();
        librarySystem34.penalty = (byte) 10;
        sandbox.CreditCardPayment creditCardPayment37 = new sandbox.CreditCardPayment();
        librarySystem34.payment = creditCardPayment37;
        boolean boolean40 = creditCardPayment37.processPayment((double) 2);
        java.lang.Boolean boolean41 = newsletterProxy9.subscribe((sandbox.User) nonFaculty19, (sandbox.Newsletter) newsletterProxy31, (sandbox.Payment) creditCardPayment37);
        org.junit.Assert.assertEquals("'" + boolean12 + "' != '" + false + "'", boolean12, false);
        org.junit.Assert.assertNotNull(newsletterMap29);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
// flaky:         org.junit.Assert.assertEquals("'" + boolean41 + "' != '" + false + "'", boolean41, false);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        sandbox.NewsletterProxy newsletterProxy0 = new sandbox.NewsletterProxy();
        sandbox.NonFaculty nonFaculty7 = new sandbox.NonFaculty("4ddb1bcd-3318-4d6e", "a775c5bb-b09b-4171", "7b483788-f009-4b5a", "", "hi!", false);
        sandbox.NewsletterProxy newsletterProxy8 = new sandbox.NewsletterProxy();
        newsletterProxy8.url = "hi!";
        java.lang.Boolean boolean11 = newsletterProxy0.cancelSubscription((sandbox.User) nonFaculty7, (sandbox.Newsletter) newsletterProxy8);
        java.lang.String str12 = newsletterProxy0.name;
        org.junit.Assert.assertEquals("'" + boolean11 + "' != '" + false + "'", boolean11, false);
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        sandbox.MobileWalletPayment mobileWalletPayment0 = new sandbox.MobileWalletPayment();
        boolean boolean2 = mobileWalletPayment0.processPayment((double) 0L);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        sandbox.Database database0 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest1 = null;
        database0.insertRequest(itemRequest1);
        java.util.List<sandbox.Item> itemList3 = database0.getAllItems();
        // The following exception was thrown during execution in test generation
        try {
            database0.insertUser("7b483788-f009-4b5a", "faf289", "5b5131", "4ddb1bcd-3318-4d6e", "76b8a6a5-5e47-488b", false);
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(database0);
        org.junit.Assert.assertNotNull(itemList3);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        int int9 = itemType1.getValue();
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 3 + "'", int9 == 3);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        sandbox.ItemPermission itemPermission1 = sandbox.ItemPermission.from((int) ' ');
        org.junit.Assert.assertTrue("'" + itemPermission1 + "' != '" + sandbox.ItemPermission.Disabled + "'", itemPermission1.equals(sandbox.ItemPermission.Disabled));
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        sandbox.Database database0 = sandbox.Database.getInstance();
        sandbox.Course course2 = database0.getCourse("76b8a6a5-5e47-488b");
        java.util.List<sandbox.Course> courseList3 = database0.getAllCourses();
        org.junit.Assert.assertNotNull(database0);
        org.junit.Assert.assertNull(course2);
        org.junit.Assert.assertNotNull(courseList3);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.Newsletter newsletter3 = null;
        librarySystem0.newsletter = newsletter3;
        java.util.HashMap<java.lang.String, java.lang.Integer> strMap5 = librarySystem0.getInventory();
        sandbox.LibrarySystem.inventory = strMap5;
        org.junit.Assert.assertNotNull(strMap5);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        sandbox.Database.updateUserVerification("faf289", false);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        sandbox.Faculty faculty5 = new sandbox.Faculty("b0bd619f-8ed5-499c", "hi!", "", "hi!", true);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        sandbox.Database database0 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest1 = null;
        database0.insertRequest(itemRequest1);
        java.util.List<sandbox.Item> itemList3 = database0.getAllItems();
        // The following exception was thrown during execution in test generation
        try {
            database0.insertUser("249d3f7a-6f32-41d8", "faf289", "3afcd2", "b0bd619f-8ed5-499c", "faf289", true);
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(database0);
        org.junit.Assert.assertNotNull(itemList3);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        sandbox.Database.deleteRental("5b5131", "3afcd2");
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        sandbox.Database.insertRental("b0bd619f-8ed5-499c", "7b483788-f009-4b5a");
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.id = "";
        item0.name = "";
        item0.id = "5b5131";
        java.time.LocalDate localDate8 = item0.dueDate;
        org.junit.Assert.assertNull(localDate1);
        org.junit.Assert.assertNull(localDate8);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        java.lang.String str9 = itemRequest8.getItemID();
        java.lang.String str10 = itemRequest8.getItemName();
        java.lang.String str11 = itemRequest8.getReason();
        java.lang.String str12 = itemRequest8.getAdditionalInfo();
        java.lang.String str13 = itemRequest8.getReason();
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "76b8a6a5-5e47-488b" + "'", str9, "76b8a6a5-5e47-488b");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n" + "'", str11, "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n" + "'", str13, "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        sandbox.NewsletterProxy newsletterProxy0 = new sandbox.NewsletterProxy();
        sandbox.NonFaculty nonFaculty7 = new sandbox.NonFaculty("4ddb1bcd-3318-4d6e", "a775c5bb-b09b-4171", "7b483788-f009-4b5a", "", "hi!", false);
        sandbox.NewsletterProxy newsletterProxy8 = new sandbox.NewsletterProxy();
        newsletterProxy8.url = "hi!";
        java.lang.Boolean boolean11 = newsletterProxy0.cancelSubscription((sandbox.User) nonFaculty7, (sandbox.Newsletter) newsletterProxy8);
        java.lang.String str12 = newsletterProxy8.url;
        sandbox.NonFaculty nonFaculty18 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        double double19 = nonFaculty18.getPenalty();
        sandbox.NewsletterProxy newsletterProxy20 = new sandbox.NewsletterProxy();
        newsletterProxy20.url = "hi!";
        sandbox.NonFaculty nonFaculty28 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy29 = new sandbox.NewsletterProxy();
        newsletterProxy29.url = "hi!";
        java.lang.Boolean boolean32 = newsletterProxy20.cancelSubscription((sandbox.User) nonFaculty28, (sandbox.Newsletter) newsletterProxy29);
        newsletterProxy20.id = "6894f2ec-beb5-4229";
        java.lang.String str35 = newsletterProxy20.url;
        sandbox.NewsletterProxy newsletterProxy36 = new sandbox.NewsletterProxy((sandbox.Newsletter) newsletterProxy20);
        sandbox.LibrarySystem librarySystem37 = new sandbox.LibrarySystem();
        librarySystem37.penalty = (byte) 10;
        sandbox.CreditCardPayment creditCardPayment40 = new sandbox.CreditCardPayment();
        librarySystem37.payment = creditCardPayment40;
        java.lang.Boolean boolean42 = newsletterProxy8.subscribe((sandbox.User) nonFaculty18, (sandbox.Newsletter) newsletterProxy20, (sandbox.Payment) creditCardPayment40);
        boolean boolean44 = creditCardPayment40.processPayment((double) 10);
        org.junit.Assert.assertEquals("'" + boolean11 + "' != '" + false + "'", boolean11, false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertTrue("'" + double19 + "' != '" + 0.0d + "'", double19 == 0.0d);
        org.junit.Assert.assertEquals("'" + boolean32 + "' != '" + false + "'", boolean32, false);
        org.junit.Assert.assertEquals("'" + str35 + "' != '" + "hi!" + "'", str35, "hi!");
        org.junit.Assert.assertEquals("'" + boolean42 + "' != '" + true + "'", boolean42, true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("hi!", "a775c5bb-b09b-4171", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        libraryManager4.setDeleteItemCommand(command5);
        java.util.HashMap<sandbox.Newsletter, java.lang.Boolean> newsletterMap7 = null;
        libraryManager4.subscriptions = newsletterMap7;
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("hi!", "a775c5bb-b09b-4171", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        libraryManager4.setReturnItemCommand(command5);
        sandbox.LibraryManager libraryManager11 = new sandbox.LibraryManager("hi!", "a775c5bb-b09b-4171", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command12 = null;
        libraryManager11.setReturnItemCommand(command12);
        sandbox.Item item14 = null;
        sandbox.NewsletterProxy newsletterProxy15 = new sandbox.NewsletterProxy();
        newsletterProxy15.url = "hi!";
        sandbox.NonFaculty nonFaculty23 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy24 = new sandbox.NewsletterProxy();
        newsletterProxy24.url = "hi!";
        java.lang.Boolean boolean27 = newsletterProxy15.cancelSubscription((sandbox.User) nonFaculty23, (sandbox.Newsletter) newsletterProxy24);
        nonFaculty23.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand30 = new sandbox.ReturnItemCommand(item14, (sandbox.User) nonFaculty23);
        libraryManager11.setEnableItemCommand((sandbox.Command) returnItemCommand30);
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.deleteItem((sandbox.Command) returnItemCommand30);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.Command.execute()\" because \"this.deleteItemCommand\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + boolean27 + "' != '" + false + "'", boolean27, false);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        sandbox.Faculty faculty6 = new sandbox.Faculty("", "149434", "a775c5bb-b09b-4171", "5b5131", "", true);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.CreditCardPayment creditCardPayment3 = new sandbox.CreditCardPayment();
        librarySystem0.payment = creditCardPayment3;
        boolean boolean6 = creditCardPayment3.processPayment((double) 10);
        boolean boolean8 = creditCardPayment3.processPayment((double) '4');
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        sandbox.Database.insertRental("76b8a6a5-5e47-488b", "5b5131");
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        libraryManager4.setDisableItemCommand(command5);
        sandbox.Item item7 = null;
        sandbox.NewsletterProxy newsletterProxy8 = new sandbox.NewsletterProxy();
        newsletterProxy8.url = "hi!";
        sandbox.NonFaculty nonFaculty16 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy17 = new sandbox.NewsletterProxy();
        newsletterProxy17.url = "hi!";
        java.lang.Boolean boolean20 = newsletterProxy8.cancelSubscription((sandbox.User) nonFaculty16, (sandbox.Newsletter) newsletterProxy17);
        nonFaculty16.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand23 = new sandbox.ReturnItemCommand(item7, (sandbox.User) nonFaculty16);
        libraryManager4.setReturnItemCommand((sandbox.Command) returnItemCommand23);
        sandbox.LibraryManager libraryManager29 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command30 = null;
        libraryManager29.setDisableItemCommand(command30);
        sandbox.Item item32 = null;
        sandbox.NewsletterProxy newsletterProxy33 = new sandbox.NewsletterProxy();
        newsletterProxy33.url = "hi!";
        sandbox.NonFaculty nonFaculty41 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy42 = new sandbox.NewsletterProxy();
        newsletterProxy42.url = "hi!";
        java.lang.Boolean boolean45 = newsletterProxy33.cancelSubscription((sandbox.User) nonFaculty41, (sandbox.Newsletter) newsletterProxy42);
        nonFaculty41.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand48 = new sandbox.ReturnItemCommand(item32, (sandbox.User) nonFaculty41);
        libraryManager29.setReturnItemCommand((sandbox.Command) returnItemCommand48);
        libraryManager4.setDisableItemCommand((sandbox.Command) returnItemCommand48);
        sandbox.LibraryManager libraryManager55 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Item item56 = null;
        sandbox.NewsletterProxy newsletterProxy57 = new sandbox.NewsletterProxy();
        newsletterProxy57.url = "hi!";
        sandbox.NonFaculty nonFaculty65 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy66 = new sandbox.NewsletterProxy();
        newsletterProxy66.url = "hi!";
        java.lang.Boolean boolean69 = newsletterProxy57.cancelSubscription((sandbox.User) nonFaculty65, (sandbox.Newsletter) newsletterProxy66);
        nonFaculty65.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand72 = new sandbox.ReturnItemCommand(item56, (sandbox.User) nonFaculty65);
        libraryManager55.setDeleteItemCommand((sandbox.Command) returnItemCommand72);
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.disableItemForRenting((sandbox.Command) returnItemCommand72);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"name\" because \"this.item\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + boolean20 + "' != '" + false + "'", boolean20, false);
        org.junit.Assert.assertEquals("'" + boolean45 + "' != '" + false + "'", boolean45, false);
        org.junit.Assert.assertEquals("'" + boolean69 + "' != '" + false + "'", boolean69, false);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        sandbox.Student student5 = new sandbox.Student("3afcd2", "f213457c-5ed7-4725", "7b483788-f009-4b5a", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", true);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        sandbox.ItemPermission itemPermission1 = sandbox.ItemPermission.from((-1));
        org.junit.Assert.assertTrue("'" + itemPermission1 + "' != '" + sandbox.ItemPermission.Disabled + "'", itemPermission1.equals(sandbox.ItemPermission.Disabled));
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        sandbox.Discount discount0 = new sandbox.Discount();
        discount0.item_id = "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n";
        discount0.item_id = "f213457c-5ed7-4725";
        java.lang.String str5 = discount0.item_id;
        discount0.discount = ' ';
        java.lang.String str8 = discount0.code;
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "f213457c-5ed7-4725" + "'", str5, "f213457c-5ed7-4725");
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        sandbox.Student student5 = new sandbox.Student("f213457c-5ed7-4725", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", "76b8a6a5-5e47-488b", false);
        sandbox.Database database6 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest7 = null;
        database6.insertRequest(itemRequest7);
        java.util.List<sandbox.Course> courseList9 = database6.getAllCourses();
        student5.setCourses(courseList9);
        org.junit.Assert.assertNotNull(database6);
        org.junit.Assert.assertNotNull(courseList9);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        sandbox.Database.deleteRental("3afcd2", "5b5131");
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Item item5 = null;
        sandbox.NewsletterProxy newsletterProxy6 = new sandbox.NewsletterProxy();
        newsletterProxy6.url = "hi!";
        sandbox.NonFaculty nonFaculty14 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy15 = new sandbox.NewsletterProxy();
        newsletterProxy15.url = "hi!";
        java.lang.Boolean boolean18 = newsletterProxy6.cancelSubscription((sandbox.User) nonFaculty14, (sandbox.Newsletter) newsletterProxy15);
        nonFaculty14.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand21 = new sandbox.ReturnItemCommand(item5, (sandbox.User) nonFaculty14);
        libraryManager4.setDeleteItemCommand((sandbox.Command) returnItemCommand21);
        sandbox.LibraryManager libraryManager27 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Item item28 = null;
        sandbox.NewsletterProxy newsletterProxy29 = new sandbox.NewsletterProxy();
        newsletterProxy29.url = "hi!";
        sandbox.NonFaculty nonFaculty37 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy38 = new sandbox.NewsletterProxy();
        newsletterProxy38.url = "hi!";
        java.lang.Boolean boolean41 = newsletterProxy29.cancelSubscription((sandbox.User) nonFaculty37, (sandbox.Newsletter) newsletterProxy38);
        nonFaculty37.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand44 = new sandbox.ReturnItemCommand(item28, (sandbox.User) nonFaculty37);
        libraryManager27.setDeleteItemCommand((sandbox.Command) returnItemCommand44);
        // The following exception was thrown during execution in test generation
        try {
            libraryManager4.addItemToLibrary((sandbox.Command) returnItemCommand44);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"sandbox.Command.execute()\" because \"this.addItemCommand\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + boolean18 + "' != '" + false + "'", boolean18, false);
        org.junit.Assert.assertEquals("'" + boolean41 + "' != '" + false + "'", boolean41, false);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        sandbox.Newsletter newsletter3 = null;
        librarySystem0.newsletter = newsletter3;
        java.util.HashMap<java.lang.String, java.lang.Integer> strMap5 = librarySystem0.getInventory();
        sandbox.NewsletterProxy newsletterProxy6 = new sandbox.NewsletterProxy();
        librarySystem0.newsletter = newsletterProxy6;
        newsletterProxy6.id = "6894f2ec-beb5-4229";
        org.junit.Assert.assertNotNull(strMap5);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        sandbox.Student student5 = new sandbox.Student("hi!", "5b5131", "", "6894f2ec-beb5-4229", false);
        java.lang.String str6 = student5.email;
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "5b5131" + "'", str6, "5b5131");
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        libraryManager4.setEnableItemCommand(command5);
        sandbox.LibraryManager libraryManager11 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command12 = null;
        libraryManager11.setDisableItemCommand(command12);
        sandbox.Item item14 = null;
        sandbox.NewsletterProxy newsletterProxy15 = new sandbox.NewsletterProxy();
        newsletterProxy15.url = "hi!";
        sandbox.NonFaculty nonFaculty23 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy24 = new sandbox.NewsletterProxy();
        newsletterProxy24.url = "hi!";
        java.lang.Boolean boolean27 = newsletterProxy15.cancelSubscription((sandbox.User) nonFaculty23, (sandbox.Newsletter) newsletterProxy24);
        nonFaculty23.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand30 = new sandbox.ReturnItemCommand(item14, (sandbox.User) nonFaculty23);
        libraryManager11.setReturnItemCommand((sandbox.Command) returnItemCommand30);
        sandbox.LibraryManager libraryManager36 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command37 = null;
        libraryManager36.setDisableItemCommand(command37);
        sandbox.Item item39 = null;
        sandbox.NewsletterProxy newsletterProxy40 = new sandbox.NewsletterProxy();
        newsletterProxy40.url = "hi!";
        sandbox.NonFaculty nonFaculty48 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy49 = new sandbox.NewsletterProxy();
        newsletterProxy49.url = "hi!";
        java.lang.Boolean boolean52 = newsletterProxy40.cancelSubscription((sandbox.User) nonFaculty48, (sandbox.Newsletter) newsletterProxy49);
        nonFaculty48.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand55 = new sandbox.ReturnItemCommand(item39, (sandbox.User) nonFaculty48);
        libraryManager36.setReturnItemCommand((sandbox.Command) returnItemCommand55);
        libraryManager11.setDisableItemCommand((sandbox.Command) returnItemCommand55);
        libraryManager4.setDisableItemCommand((sandbox.Command) returnItemCommand55);
        org.junit.Assert.assertEquals("'" + boolean27 + "' != '" + false + "'", boolean27, false);
        org.junit.Assert.assertEquals("'" + boolean52 + "' != '" + false + "'", boolean52, false);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        sandbox.Database.updateUserVerification("4ddb1bcd-3318-4d6e", true);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        libraryManager4.name = "5b5131";
        sandbox.LibraryManager libraryManager11 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Item item12 = null;
        sandbox.NewsletterProxy newsletterProxy13 = new sandbox.NewsletterProxy();
        newsletterProxy13.url = "hi!";
        sandbox.NonFaculty nonFaculty21 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy22 = new sandbox.NewsletterProxy();
        newsletterProxy22.url = "hi!";
        java.lang.Boolean boolean25 = newsletterProxy13.cancelSubscription((sandbox.User) nonFaculty21, (sandbox.Newsletter) newsletterProxy22);
        nonFaculty21.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand28 = new sandbox.ReturnItemCommand(item12, (sandbox.User) nonFaculty21);
        libraryManager11.setDeleteItemCommand((sandbox.Command) returnItemCommand28);
        libraryManager4.setAddItemCommand((sandbox.Command) returnItemCommand28);
        org.junit.Assert.assertEquals("'" + boolean25 + "' != '" + false + "'", boolean25, false);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        sandbox.Database database0 = sandbox.Database.getInstance();
        sandbox.Course course2 = database0.getCourse("76b8a6a5-5e47-488b");
        java.util.List<sandbox.Item> itemList3 = database0.getAllItems();
        sandbox.ItemType itemType7 = sandbox.ItemType.CD;
        sandbox.ItemType itemType13 = sandbox.ItemType.Textbook;
        int int14 = itemType13.getValue();
        sandbox.ItemRequest itemRequest18 = new sandbox.ItemRequest("4ddb1bcd-3318-4d6e", itemType13, "hi!", "4ddb1bcd-3318-4d6e", "hi!");
        java.time.LocalDate localDate19 = itemRequest18.getRequestDate();
        sandbox.ItemRequest itemRequest20 = new sandbox.ItemRequest("b0bd619f-8ed5-499c", itemType7, "249d3f7a-6f32-41d8", "4ddb1bcd-3318-4d6e", "f213457c-5ed7-4725", (int) (short) 10, localDate19);
        database0.insertRental("hi!", "249d3f7a-6f32-41d8", localDate19);
        org.junit.Assert.assertNotNull(database0);
        org.junit.Assert.assertNull(course2);
        org.junit.Assert.assertNotNull(itemList3);
        org.junit.Assert.assertTrue("'" + itemType7 + "' != '" + sandbox.ItemType.CD + "'", itemType7.equals(sandbox.ItemType.CD));
        org.junit.Assert.assertTrue("'" + itemType13 + "' != '" + sandbox.ItemType.Textbook + "'", itemType13.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 3 + "'", int14 == 3);
        org.junit.Assert.assertNotNull(localDate19);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        sandbox.NonFaculty nonFaculty6 = new sandbox.NonFaculty("f213457c-5ed7-4725", "b0bd619f-8ed5-499c", "b0bd619f-8ed5-499c", "76b8a6a5-5e47-488b", "7b483788-f009-4b5a", true);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        sandbox.Faculty faculty6 = new sandbox.Faculty("", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "", "", "", false);
        double double7 = faculty6.getPenalty();
        // The following exception was thrown during execution in test generation
        try {
            faculty6.writeUserCsv();
// flaky:             org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 0.0d + "'", double7 == 0.0d);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        sandbox.Item item0 = null;
        sandbox.NewsletterProxy newsletterProxy1 = new sandbox.NewsletterProxy();
        newsletterProxy1.url = "hi!";
        sandbox.NonFaculty nonFaculty9 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy10 = new sandbox.NewsletterProxy();
        newsletterProxy10.url = "hi!";
        java.lang.Boolean boolean13 = newsletterProxy1.cancelSubscription((sandbox.User) nonFaculty9, (sandbox.Newsletter) newsletterProxy10);
        nonFaculty9.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand16 = new sandbox.ReturnItemCommand(item0, (sandbox.User) nonFaculty9);
        // The following exception was thrown during execution in test generation
        try {
            returnItemCommand16.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"name\" because \"this.item\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + boolean13 + "' != '" + false + "'", boolean13, false);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        sandbox.ItemType itemType0 = sandbox.ItemType.CD;
        int int1 = itemType0.getValue();
        org.junit.Assert.assertTrue("'" + itemType0 + "' != '" + sandbox.ItemType.CD + "'", itemType0.equals(sandbox.ItemType.CD));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 2 + "'", int1 == 2);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        // The following exception was thrown during execution in test generation
        try {
            sandbox.User user5 = sandbox.UserFactory.createUser("4ddb1bcd-3318-4d6e", "76b8a6a5-5e47-488b", "76b8a6a5-5e47-488b", "hi!", true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        java.lang.String str9 = itemRequest8.getItemID();
        java.lang.String str10 = itemRequest8.getItemName();
        java.lang.String str11 = itemRequest8.getReason();
        java.lang.String str12 = itemRequest8.getAdditionalInfo();
        java.lang.String str13 = itemRequest8.getItemID();
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "76b8a6a5-5e47-488b" + "'", str9, "76b8a6a5-5e47-488b");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n" + "'", str11, "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "76b8a6a5-5e47-488b" + "'", str13, "76b8a6a5-5e47-488b");
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("hi!", "a775c5bb-b09b-4171", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        libraryManager4.setReturnItemCommand(command5);
        sandbox.Item item7 = null;
        sandbox.NewsletterProxy newsletterProxy8 = new sandbox.NewsletterProxy();
        newsletterProxy8.url = "hi!";
        sandbox.NonFaculty nonFaculty16 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy17 = new sandbox.NewsletterProxy();
        newsletterProxy17.url = "hi!";
        java.lang.Boolean boolean20 = newsletterProxy8.cancelSubscription((sandbox.User) nonFaculty16, (sandbox.Newsletter) newsletterProxy17);
        nonFaculty16.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand23 = new sandbox.ReturnItemCommand(item7, (sandbox.User) nonFaculty16);
        libraryManager4.setEnableItemCommand((sandbox.Command) returnItemCommand23);
        // The following exception was thrown during execution in test generation
        try {
            returnItemCommand23.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"name\" because \"this.item\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + boolean20 + "' != '" + false + "'", boolean20, false);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        librarySystem0.penalty = 0.0d;
        java.util.List<sandbox.Item> itemList6 = librarySystem0.getRecommendations("hi!");
        sandbox.Item item8 = librarySystem0.searchItem("hi!");
        java.util.List<sandbox.Item> itemList10 = librarySystem0.getRecommendations("f213457c-5ed7-4725");
        sandbox.Item item12 = librarySystem0.searchItem("7b483788-f009-4b5a");
        sandbox.Newsletter newsletter13 = librarySystem0.newsletter;
        org.junit.Assert.assertNotNull(itemList6);
        org.junit.Assert.assertNull(item8);
        org.junit.Assert.assertNotNull(itemList10);
        org.junit.Assert.assertNull(item12);
        org.junit.Assert.assertNull(newsletter13);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        sandbox.Database database0 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest1 = null;
        database0.insertRequest(itemRequest1);
        java.util.List<sandbox.Course> courseList3 = database0.getAllCourses();
        java.util.List<sandbox.Course> courseList4 = database0.getAllCourses();
        java.util.List<sandbox.Course> courseList6 = database0.getFacultyCourses("4ddb1bcd-3318-4d6e");
        org.junit.Assert.assertNotNull(database0);
        org.junit.Assert.assertNotNull(courseList3);
        org.junit.Assert.assertNotNull(courseList4);
        org.junit.Assert.assertNotNull(courseList6);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        sandbox.LibraryManager libraryManager4 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command5 = null;
        libraryManager4.setEnableItemCommand(command5);
        sandbox.LibraryManager libraryManager11 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Item item12 = null;
        sandbox.NewsletterProxy newsletterProxy13 = new sandbox.NewsletterProxy();
        newsletterProxy13.url = "hi!";
        sandbox.NonFaculty nonFaculty21 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy22 = new sandbox.NewsletterProxy();
        newsletterProxy22.url = "hi!";
        java.lang.Boolean boolean25 = newsletterProxy13.cancelSubscription((sandbox.User) nonFaculty21, (sandbox.Newsletter) newsletterProxy22);
        nonFaculty21.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand28 = new sandbox.ReturnItemCommand(item12, (sandbox.User) nonFaculty21);
        libraryManager11.setDeleteItemCommand((sandbox.Command) returnItemCommand28);
        java.lang.String str30 = libraryManager11.id;
        sandbox.LibraryManager libraryManager35 = new sandbox.LibraryManager("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "6894f2ec-beb5-4229", "", "4ddb1bcd-3318-4d6e");
        sandbox.Command command36 = null;
        libraryManager35.setDisableItemCommand(command36);
        sandbox.Item item38 = null;
        sandbox.NewsletterProxy newsletterProxy39 = new sandbox.NewsletterProxy();
        newsletterProxy39.url = "hi!";
        sandbox.NonFaculty nonFaculty47 = new sandbox.NonFaculty("", "hi!", "hi!", "", true);
        sandbox.NewsletterProxy newsletterProxy48 = new sandbox.NewsletterProxy();
        newsletterProxy48.url = "hi!";
        java.lang.Boolean boolean51 = newsletterProxy39.cancelSubscription((sandbox.User) nonFaculty47, (sandbox.Newsletter) newsletterProxy48);
        nonFaculty47.type = "6894f2ec-beb5-4229";
        sandbox.ReturnItemCommand returnItemCommand54 = new sandbox.ReturnItemCommand(item38, (sandbox.User) nonFaculty47);
        libraryManager35.setReturnItemCommand((sandbox.Command) returnItemCommand54);
        libraryManager11.setEnableItemCommand((sandbox.Command) returnItemCommand54);
        libraryManager4.setDeleteItemCommand((sandbox.Command) returnItemCommand54);
        int int58 = libraryManager4.getOverdue();
        org.junit.Assert.assertEquals("'" + boolean25 + "' != '" + false + "'", boolean25, false);
// flaky:         org.junit.Assert.assertEquals("'" + str30 + "' != '" + "d980bc" + "'", str30, "d980bc");
        org.junit.Assert.assertEquals("'" + boolean51 + "' != '" + false + "'", boolean51, false);
        org.junit.Assert.assertTrue("'" + int58 + "' != '" + 0 + "'", int58 == 0);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        // The following exception was thrown during execution in test generation
        try {
            sandbox.User user5 = sandbox.UserFactory.createUser("a84bdd", "faf289", "a84bdd", "faf289", true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        sandbox.Item item0 = new sandbox.Item();
        java.time.LocalDate localDate1 = item0.dueDate;
        item0.id = "";
        item0.name = "";
        java.lang.String str6 = item0.generateUniqueID();
        item0.name = "";
        java.lang.Double double9 = item0.price;
        sandbox.ItemPermission itemPermission10 = item0.permission;
        java.lang.String str11 = item0.location;
        org.junit.Assert.assertNull(localDate1);
// flaky:         org.junit.Assert.assertEquals("'" + str6 + "' != '" + "f15007ab-3753-4795" + "'", str6, "f15007ab-3753-4795");
        org.junit.Assert.assertNull(double9);
        org.junit.Assert.assertNull(itemPermission10);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        sandbox.Textbook textbook2 = new sandbox.Textbook("", (int) (byte) 1);
        textbook2.groupID = "";
        java.lang.String str5 = textbook2.groupID;
        int int6 = textbook2.edition;
        int int7 = textbook2.edition;
        java.lang.String str8 = textbook2.category;
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        sandbox.ItemType itemType1 = sandbox.ItemType.Textbook;
        int int2 = itemType1.getValue();
        java.time.LocalDate localDate7 = null;
        sandbox.ItemRequest itemRequest8 = new sandbox.ItemRequest("", itemType1, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate7);
        java.lang.String str9 = itemRequest8.getItemID();
        java.lang.String str10 = itemRequest8.getReason();
        org.junit.Assert.assertTrue("'" + itemType1 + "' != '" + sandbox.ItemType.Textbook + "'", itemType1.equals(sandbox.ItemType.Textbook));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 3 + "'", int2 == 3);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "76b8a6a5-5e47-488b" + "'", str9, "76b8a6a5-5e47-488b");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n" + "'", str10, "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        sandbox.Database.deleteItem("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n");
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        sandbox.DebitCardPayment debitCardPayment0 = new sandbox.DebitCardPayment();
        boolean boolean2 = debitCardPayment0.processPayment((-1.0d));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        sandbox.Student student5 = new sandbox.Student("Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "4ddb1bcd-3318-4d6e", "a775c5bb-b09b-4171", "76b8a6a5-5e47-488b", false);
        sandbox.Database database6 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest7 = null;
        database6.insertRequest(itemRequest7);
        java.util.List<sandbox.Course> courseList10 = database6.getStudentCourses("7b483788-f009-4b5a");
        student5.setCourses(courseList10);
        org.junit.Assert.assertNotNull(database6);
        org.junit.Assert.assertNotNull(courseList10);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        sandbox.Student student5 = new sandbox.Student("76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", "", true);
        java.util.List<sandbox.Course> courseList6 = student5.getCourses();
        org.junit.Assert.assertNotNull(courseList6);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        java.util.List<sandbox.RentedItem> rentedItemList1 = sandbox.Database.getUserRentals("b0bd619f-8ed5-499c");
        org.junit.Assert.assertNotNull(rentedItemList1);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        sandbox.ItemStatus itemStatus0 = sandbox.ItemStatus.Unknown;
        int int1 = itemStatus0.getValue();
        org.junit.Assert.assertTrue("'" + itemStatus0 + "' != '" + sandbox.ItemStatus.Unknown + "'", itemStatus0.equals(sandbox.ItemStatus.Unknown));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + (-1) + "'", int1 == (-1));
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        sandbox.Student student6 = new sandbox.Student("149434", "", "149434", "", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", true);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        sandbox.NonFaculty nonFaculty5 = new sandbox.NonFaculty("6894f2ec-beb5-4229", "", "faf289", "a775c5bb-b09b-4171", false);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        java.util.List<sandbox.Newsletter> newsletterList1 = sandbox.Database.getUserSubscription("5b5131");
        org.junit.Assert.assertNotNull(newsletterList1);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        sandbox.Database database0 = sandbox.Database.getInstance();
        sandbox.Course course2 = database0.getCourse("76b8a6a5-5e47-488b");
        java.util.List<sandbox.Item> itemList3 = database0.getAllItems();
        java.util.List<sandbox.Course> courseList4 = database0.getAllCourses();
        org.junit.Assert.assertNotNull(database0);
        org.junit.Assert.assertNull(course2);
        org.junit.Assert.assertNotNull(itemList3);
        org.junit.Assert.assertNotNull(courseList4);
    }
}
