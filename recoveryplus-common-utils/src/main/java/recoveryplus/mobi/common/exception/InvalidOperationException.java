package recoveryplus.mobi.common.exception;

/**
 * 非法操作异常
 *
 * @author LiuDecai
 */
public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(Throwable throwable) {
        super(throwable);
    }

    public InvalidOperationException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
