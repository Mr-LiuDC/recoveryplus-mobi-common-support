package recoveryplus.mobi.common.exception;

/**
 * 一般异常
 *
 * @author LiuDeCai
 */
public class CommonException extends RuntimeException {

    public CommonException(String message) {
        super(message);
    }

    public CommonException(Throwable throwable) {
        super(throwable);
    }

    public CommonException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
