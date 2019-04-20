package recoveryplus.mobi.common.exception;

import org.junit.Test;

import java.util.Objects;

import static junit.framework.TestCase.assertTrue;

/**
 * 非法操作异常测试
 *
 * @author LiuDecai
 */
public class InvalidOperationExceptionTest {

    @Test
    public void test1() {
        try {
            throw new InvalidOperationException("非法操作异常");
        } catch (Exception e) {
            assertTrue(Objects.equals(e.getMessage(), "非法操作异常"));
        }
    }

    @Test
    public void test2() {
        Throwable throwable = new Throwable("Throwable的内容");
        try {
            throw new InvalidOperationException(throwable);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Throwable的内容"));
        }
    }

    @Test
    public void test3() {
        Throwable throwable = new Throwable("Throwable的内容");
        try {
            throw new InvalidOperationException("非法操作异常", throwable);
        } catch (Exception e) {
            assertTrue(Objects.equals(e.getMessage(), "非法操作异常"));
            assertTrue(e.getCause().getMessage().contains("Throwable的内容"));
        }
    }

}
