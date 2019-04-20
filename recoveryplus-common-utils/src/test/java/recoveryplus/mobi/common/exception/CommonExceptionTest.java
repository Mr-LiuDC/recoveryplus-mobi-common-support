package recoveryplus.mobi.common.exception;

import org.junit.Test;

import java.util.Objects;

import static junit.framework.TestCase.assertTrue;

/**
 * 一般异常测试
 *
 * @author LiuDecai
 */
public class CommonExceptionTest {

    @Test
    public void test1() {
        try {
            throw new CommonException("一般异常");
        } catch (Exception e) {
            assertTrue(Objects.equals(e.getMessage(), "一般异常"));
        }
    }

    @Test
    public void test2() {
        Throwable throwable = new Throwable("Throwable的内容");
        try {
            throw new CommonException(throwable);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Throwable的内容"));
        }
    }

    @Test
    public void test3() {
        Throwable throwable = new Throwable("Throwable的内容");
        try {
            throw new CommonException("一般异常", throwable);
        } catch (Exception e) {
            assertTrue(Objects.equals(e.getMessage(), "一般异常"));
            assertTrue(e.getCause().getMessage().contains("Throwable的内容"));
        }
    }

}
