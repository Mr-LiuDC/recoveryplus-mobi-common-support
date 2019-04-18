package recoveryplus.mobi.common.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import recoveryplus.mobi.common.utils.ObjectId;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 测试Rest接口包装类
 *
 * @author LiuDecai
 */
public class RestResponseTest {

    private Map<String, Object> map = new HashMap<>();

    @Before
    public void dataSet() {
        map.put("id", ObjectId.get().toString());
    }


    @Test
    public void buildRestResponse() {
        RestResponse<Map<String, Object>> response = RestResponse.buildRestResponse(map);
        Assert.assertTrue(response.getApiStatus() == 0);
        Assert.assertTrue(response.getSysStatus() == 0);
        Assert.assertFalse(response.getData().isEmpty());
        Assert.assertTrue(Objects.equals("success", response.getMessage()));
    }

    @Test
    public void buildRestResponse1() {
        RestResponse<Map<String, Object>> response = RestResponse.buildRestResponse(map, "操作成功");
        Assert.assertTrue(response.getApiStatus() == 0);
        Assert.assertTrue(response.getSysStatus() == 0);
        Assert.assertFalse(response.getData().isEmpty());
        Assert.assertTrue(Objects.equals("操作成功", response.getMessage()));
    }

    @Test
    public void buildRestResponse2() {
        RestResponse<Map<String, Object>> response = RestResponse.buildRestResponse(map, 5);
        Assert.assertTrue(response.getApiStatus() == 5);
        Assert.assertTrue(response.getSysStatus() == 0);
        Assert.assertFalse(response.getData().isEmpty());
    }

    @Test
    public void buildRestResponse3() {
        RestResponse<Map<String, Object>> response = RestResponse.buildRestResponse(map, 5, "响应成功");
        Assert.assertTrue(response.getApiStatus() == 5);
        Assert.assertTrue(response.getSysStatus() == 0);
        Assert.assertFalse(response.getData().isEmpty());
        Assert.assertTrue(Objects.equals("响应成功", response.getMessage()));
    }

    @Test
    public void buildRestResponse4() {
        RestResponse response = RestResponse.buildRestResponse("返回成功");
        Assert.assertTrue(response.getApiStatus() == 0);
        Assert.assertTrue(response.getSysStatus() == 0);
        Assert.assertTrue(Objects.equals("返回成功", response.getMessage()));
    }

    @Test
    public void buildExceptionResponse() {
        RestResponse response = RestResponse.buildExceptionResponse("出错了");
        Assert.assertTrue(response.getApiStatus() == -1);
        Assert.assertTrue(response.getSysStatus() == -1);
        Assert.assertTrue(Objects.equals("出错了", response.getMessage()));
    }

    @Test
    public void buildExceptionResponse1() {
        RestResponse response = RestResponse.buildExceptionResponse("出错了", -2);
        Assert.assertTrue(response.getApiStatus() == -2);
        Assert.assertTrue(response.getSysStatus() == -1);
        Assert.assertTrue(Objects.equals("出错了", response.getMessage()));
    }

}
