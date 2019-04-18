package recoveryplus.mobi.common.utils;

import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * ObjectId测试
 *
 * @author LiuDecai
 */
public class ObjectIdTest {

    @Test
    public void get() {
        int times = 10;
        for (int i = 0; i < times; i++) {
            System.out.println(ObjectId.get().toString());
            System.out.println(UUID.randomUUID());
        }
    }

    @Test
    public void isValid() {
        assertTrue(ObjectId.isValid("5cb80371d3d02d2198a66e7a"));
        assertTrue(ObjectId.isValid("5cb80371d3d02d2198a66e7A"));
        assertFalse(ObjectId.isValid("5cb80371d3d02d2198a66e7"));
        assertFalse(ObjectId.isValid("5cb80371d3d02d2198a66e7g"));

        assertFalse(ObjectId.get().compareTo(new ObjectId()) == 1);

        ObjectId objectId1 = new ObjectId(new Date());
        ObjectId objectId2 = new ObjectId(new Date(), 4);
        assertFalse(objectId1.equals(objectId2));

    }

}
