itimport org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test1() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test1");
        sandbox.Item item0 = null;
        sandbox.AddItemCommand addItemCommand1 = new sandbox.AddItemCommand(item0);
        // The following exception was thrown during execution in test generation
        try {
            addItemCommand1.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"name\" because \"this.item\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test2() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test2");
        sandbox.Item item0 = null;
        sandbox.AddItemCommand addItemCommand1 = new sandbox.AddItemCommand(item0);
        java.lang.Class<?> wildcardClass2 = addItemCommand1.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test3() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test3");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass1);
    }
}

