package recoveryplus.mobi.common.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

/**
 * ObjectId测试
 *
 * @author LiuDecai
 */
public class ObjectIdTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test() {
        System.out.println(ObjectId.getCurrentCounter());
        assertTrue(ObjectId.getGeneratedMachineIdentifier() > 0);
        assertTrue(ObjectId.getGeneratedProcessIdentifier() > 0);
    }

    @Test
    public void test1() {
        ObjectId objectId1 = new ObjectId(ObjectId.get().toByteArray());
        ObjectId objectId2 = new ObjectId(objectId1.toHexString());
        ObjectId objectId3 = new ObjectId(1, 0, 1);
        ObjectId objectId4 = ObjectId.createFromLegacyFormat(0, 0, 0);
        System.out.println(objectId3.getProcessIdentifier());
        System.out.println(objectId3.getTimestamp());

        assertTrue(objectId2.getCounter() > 0);
        assertTrue(objectId2.getDate().after(new Date(0)));
        assertTrue(objectId3.getMachineIdentifier() >= 0);
        assertTrue(Objects.equals("000000000000000000000000", objectId4.toString()));
    }

    @Test
    public void get() {
        int times = 10;
        for (int i = 0; i < times; i++) {
            String objectId = ObjectId.get().toString();
            System.out.println(objectId);
            System.out.println(UUID.randomUUID());
            assertTrue(ObjectId.isValid(objectId));
        }
    }

    @Test
    public void isValid() {
        assertTrue(ObjectId.isValid("5cb80371d3d02d2198a66e7a"));
        assertFalse(ObjectId.isValid("-5b80371d3d02d2198a66e7a"));
        assertTrue(ObjectId.isValid("5cb80371d3d02d2198a66e7A"));
        assertFalse(ObjectId.isValid("5cb80371d3d02d2198a66e7"));
        assertFalse(ObjectId.isValid("5cb80371d3d02d2198a66e7G"));
        assertFalse(ObjectId.isValid("5cb80371d3d02d2198a66e7g"));

        ObjectId objectId1 = new ObjectId(new Date());
        ObjectId objectId2 = new ObjectId(new Date());
        ObjectId objectId3 = new ObjectId(new Date(), 4);
        System.out.println(objectId1.getTime());
        System.out.println(objectId1.getTimeSecond());
        System.out.println(objectId1.toStringMongod());
        assertTrue(objectId1.compareTo(objectId2) == -1);
        assertTrue(objectId1.compareTo(objectId1) == 0);
        assertTrue(objectId2.compareTo(objectId1) == 1);
        System.out.println(objectId1.hashCode());
        assertTrue(objectId1.equals(objectId1));
        assertFalse(objectId1.equals(objectId2));
        assertNotEquals(objectId1, objectId3);
    }

    @Test
    public void testEquals() {
        ObjectId objectId1 = new ObjectId(0, 0, 0);
        ObjectId objectId2 = new ObjectId(0, 0, 1);
        ObjectId objectId3 = new ObjectId(0, 1, 0);
        ObjectId objectId4 = new ObjectId(1, 0, 0);
        ObjectId objectId5 = new ObjectId(10000, 0, 0);
        ObjectId objectId6 = new ObjectId(0, 0, 0);
        ObjectId objectId7 = new ObjectId(0, 1111111111, 0);
        Object object = new Object();
        assertFalse(objectId1.equals(null));
        assertFalse(objectId1.equals(object));
        assertFalse(objectId1.equals(objectId2));
        assertFalse(objectId1.equals(objectId3));
        assertFalse(objectId1.equals(objectId4));
        assertFalse(objectId1.equals(objectId5));
        assertTrue(objectId1.equals(objectId6));
        assertFalse(objectId1.equals(objectId7));
    }

    @Test
    public void testValidException() {
        exception.expect(IllegalArgumentException.class);
        ObjectId.isValid(null);
    }

    @Test
    public void testException1() {
        exception.expect(IllegalArgumentException.class);
        byte[] b = null;
        new ObjectId(b);
    }

    @Test
    public void testException2() {
        exception.expect(IllegalArgumentException.class);
        byte[] b = new byte[11];
        new ObjectId(b);
    }

    @Test
    public void testException3() {
        exception.expect(NullPointerException.class);
        ObjectId objectId = new ObjectId();
        objectId.compareTo(null);
    }


    @Test
    public void testException4() {
        exception.expect(IllegalArgumentException.class);
        ObjectId.isValid(null);
    }

    @Test
    public void testException5() {
        exception.expect(IllegalArgumentException.class);
        short s = 32767;
        new ObjectId(0, 16777216, s, 0);
    }

    @Test
    public void testException6() {
        exception.expect(IllegalArgumentException.class);
        short s = 32767;
        new ObjectId(0, 0, s, 16777216);
    }

    @Test
    public void testException7() {
        exception.expect(IllegalArgumentException.class);
        new ObjectId("0000000");
    }

}
