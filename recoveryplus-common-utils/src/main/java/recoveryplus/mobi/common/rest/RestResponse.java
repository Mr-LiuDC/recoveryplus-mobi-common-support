package recoveryplus.mobi.common.rest;

/**
 * Rest接口响应内容重新包装
 *
 * @author LiuDecai
 */
public class RestResponse<T> {

    /**
     * 当前API接口状态码(默认为0)
     */
    private Integer apiStatus = 0;
    /**
     * 系统状态码(默认为0)
     */
    private Integer sysStatus = 0;
    /**
     * 当前响应的时间戳
     */
    private Long timestamp = System.currentTimeMillis();
    /**
     * 提示消息
     */
    private String message;
    /**
     * 返回的数据
     */
    private T data;

    private RestResponse() {
    }

    public static <T> RestResponse<T> buildRestResponse(T data) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setData(data);
        restResponse.setMessage("success");
        return restResponse;
    }

    public static <T> RestResponse<T> buildRestResponse(T data, String message) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setData(data);
        restResponse.setMessage(message);
        return restResponse;
    }

    public static <T> RestResponse<T> buildRestResponse(T data, Integer apiStatus) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setData(data);
        restResponse.setApiStatus(apiStatus);
        return restResponse;
    }

    public static <T> RestResponse<T> buildRestResponse(T data, Integer apiStatus, String message) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setData(data);
        restResponse.setApiStatus(apiStatus);
        restResponse.setMessage(message);
        return restResponse;
    }

    public static RestResponse<?> buildRestResponse(String message) {
        RestResponse<?> restResponse = new RestResponse<>();
        restResponse.setMessage(message);
        return restResponse;
    }

    public static RestResponse<?> buildExceptionResponse(String errorMessage) {
        RestResponse<?> restResponse = new RestResponse<>();
        restResponse.setMessage(errorMessage);
        restResponse.setSysStatus(-1);
        restResponse.setApiStatus(-1);
        return restResponse;
    }

    public static RestResponse<?> buildExceptionResponse(String errorMessage, Integer apiStatus) {
        RestResponse<?> restResponse = new RestResponse<>();
        restResponse.setMessage(errorMessage);
        restResponse.setSysStatus(-1);
        restResponse.setApiStatus(apiStatus);
        return restResponse;
    }

    public Integer getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(Integer apiStatus) {
        this.apiStatus = apiStatus;
    }

    public Integer getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Integer sysStatus) {
        this.sysStatus = sysStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
