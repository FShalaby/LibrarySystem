package RandoopTest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test01");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.Textbook textbook3 = new sandbox.Textbook(item0, "76b8a6a5-5e47-488b", (int) (byte) 0);
        java.time.LocalDate localDate4 = textbook3.dueDate;
        org.junit.Assert.assertTrue("Contract failed: equals-hashcode on item0 and textbook3", item0.equals(textbook3) ? item0.hashCode() == textbook3.hashCode() : true);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test02");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        librarySystem0.penalty = 0.0d;
        java.util.List<sandbox.Item> itemList6 = librarySystem0.getRecommendations("hi!");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        java.lang.String str7 = librarySystem0.toString();
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test03");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        librarySystem0.penalty = 0.0d;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        java.lang.String str5 = librarySystem0.toString();
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test04");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        librarySystem0.penalty = 0.0d;
        java.util.List<sandbox.Item> itemList6 = librarySystem0.getRecommendations("hi!");
        sandbox.Item item8 = librarySystem0.searchItem("hi!");
        java.util.List<sandbox.Item> itemList10 = librarySystem0.getRecommendations("f213457c-5ed7-4725");
        sandbox.Payment payment11 = librarySystem0.payment;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        sandbox.Newsletter newsletter13 = librarySystem0.searchNews("6894f2ec-beb5-4229");
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test05");
        sandbox.Textbook textbook3 = new sandbox.Textbook("", (int) (byte) 1);
        textbook3.groupID = "";
        java.lang.String str6 = textbook3.groupID;
        int int7 = textbook3.edition;
        sandbox.Item item8 = new sandbox.Item();
        sandbox.Textbook textbook11 = new sandbox.Textbook(item8, "76b8a6a5-5e47-488b", (int) (byte) 0);
        sandbox.Textbook textbook14 = new sandbox.Textbook("", (int) (byte) 1);
        textbook14.groupID = "";
        sandbox.Textbook textbook19 = new sandbox.Textbook("", (int) (byte) 1);
        textbook19.groupID = "";
        java.lang.String str22 = textbook19.groupID;
        int int23 = textbook19.edition;
        sandbox.Textbook textbook26 = new sandbox.Textbook("", (int) (byte) 1);
        textbook26.groupID = "";
        java.lang.String str29 = textbook26.groupID;
        int int30 = textbook26.edition;
        sandbox.Item item31 = new sandbox.Item();
        sandbox.Textbook textbook34 = new sandbox.Textbook(item31, "76b8a6a5-5e47-488b", (int) (byte) 0);
        sandbox.Textbook textbook37 = new sandbox.Textbook("", (int) (byte) 1);
        sandbox.Textbook[] textbookArray38 = new sandbox.Textbook[] { textbook3, textbook11, textbook14, textbook19, textbook26, textbook34, textbook37 };
        java.util.ArrayList<sandbox.Textbook> textbookList39 = new java.util.ArrayList<sandbox.Textbook>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<sandbox.Textbook>) textbookList39, textbookArray38);
        sandbox.TextbookGroup textbookGroup41 = new sandbox.TextbookGroup("4ddb1bcd-3318-4d6e", (java.util.List<sandbox.Textbook>) textbookList39);
        org.junit.Assert.assertTrue("Contract failed: equals-hashcode on textbook3 and item8", textbook3.equals(item8) ? textbook3.hashCode() == item8.hashCode() : true);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test06");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.Textbook textbook3 = new sandbox.Textbook(item0, "76b8a6a5-5e47-488b", (int) (byte) 0);
        java.lang.Double double4 = textbook3.price;
        org.junit.Assert.assertTrue("Contract failed: equals-hashcode on item0 and textbook3", item0.equals(textbook3) ? item0.hashCode() == textbook3.hashCode() : true);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test07");
        sandbox.Textbook textbook2 = new sandbox.Textbook("", (int) (byte) 1);
        int int3 = textbook2.edition;
        sandbox.ItemStatus itemStatus4 = textbook2.status;
        int int5 = textbook2.edition;
        sandbox.Textbook textbook8 = new sandbox.Textbook((sandbox.Item) textbook2, "f213457c-5ed7-4725", (-1));
        sandbox.Textbook textbook11 = new sandbox.Textbook((sandbox.Item) textbook8, "6894f2ec-beb5-4229", (int) (short) 1);
        org.junit.Assert.assertTrue("Contract failed: equals-hashcode on textbook2 and textbook8", textbook2.equals(textbook8) ? textbook2.hashCode() == textbook8.hashCode() : true);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test08");
        sandbox.Textbook textbook2 = new sandbox.Textbook("", (int) (byte) 1);
        int int3 = textbook2.edition;
        sandbox.ItemStatus itemStatus4 = textbook2.status;
        int int5 = textbook2.edition;
        sandbox.Textbook textbook8 = new sandbox.Textbook((sandbox.Item) textbook2, "f213457c-5ed7-4725", (-1));
        sandbox.ItemPermission itemPermission9 = textbook8.permission;
        org.junit.Assert.assertTrue("Contract failed: equals-hashcode on textbook2 and textbook8", textbook2.equals(textbook8) ? textbook2.hashCode() == textbook8.hashCode() : true);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test09");
        sandbox.Item item0 = new sandbox.Item();
        sandbox.Textbook textbook3 = new sandbox.Textbook(item0, "76b8a6a5-5e47-488b", (int) (byte) 0);
        sandbox.AddItemCommand addItemCommand4 = new sandbox.AddItemCommand((sandbox.Item) textbook3);
        org.junit.Assert.assertTrue("Contract failed: equals-hashcode on item0 and textbook3", item0.equals(textbook3) ? item0.hashCode() == textbook3.hashCode() : true);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test10");
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
        sandbox.Database database18 = sandbox.Database.getInstance();
        sandbox.ItemRequest itemRequest19 = null;
        database18.insertRequest(itemRequest19);
        java.util.List<sandbox.Item> itemList21 = database18.getAllItems();
        sandbox.ItemType itemType23 = sandbox.ItemType.Textbook;
        int int24 = itemType23.getValue();
        java.time.LocalDate localDate29 = null;
        sandbox.ItemRequest itemRequest30 = new sandbox.ItemRequest("", itemType23, "76b8a6a5-5e47-488b", "Newer edition of Introduction to Algorithms (3rd Edition) exists for EECS3101 but is not yet available at the library.\n", "hi!", (int) (byte) 1, localDate29);
        java.lang.String str31 = itemRequest30.getItemID();
        java.lang.String str32 = itemRequest30.getItemName();
        database18.insertRequest(itemRequest30);
        database0.insertRequest(itemRequest30);
        org.junit.Assert.assertTrue("Contract failed: equals-hashcode on itemList3 and itemList21", itemList3.equals(itemList21) ? itemList3.hashCode() == itemList21.hashCode() : true);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test11");
        sandbox.LibrarySystem librarySystem0 = new sandbox.LibrarySystem();
        librarySystem0.penalty = (byte) 10;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        java.lang.String str3 = librarySystem0.toString();
    }
}

