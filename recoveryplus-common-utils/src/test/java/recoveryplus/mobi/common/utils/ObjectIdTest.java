package recoveryplus.mobi.common.utils;

import org.junit.Test;

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
        for (int i = 0; i < 10; i++) {
            System.out.println(ObjectId.get().toString());
            System.out.println(UUID.randomUUID());
        }
    }

    @Test
    public void isValid() {
        assertTrue(ObjectId.isValid("5cb80371d3d02d2198a66e7a"));
        assertFalse(ObjectId.isValid("5cb80371d3d02d2198a66e7"));
    }

}
