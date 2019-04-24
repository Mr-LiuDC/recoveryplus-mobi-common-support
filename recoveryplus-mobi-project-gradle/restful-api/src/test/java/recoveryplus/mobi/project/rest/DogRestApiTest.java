package recoveryplus.mobi.project.rest;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import recoveryplus.mobi.common.rest.RestResponse;

import static org.junit.Assert.assertEquals;

/**
 * Dog rest api test.
 *
 * @author LiuDecai
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DogRestApiTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * 模拟MVC
     */
    private MockMvc mockMvc;
    /**
     * 应用上下文
     */
    @Autowired
    private WebApplicationContext wac;
    /**
     * 请求头
     */
    private HttpHeaders headers = new HttpHeaders();
    /**
     * 请求参数
     */
    private MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

    @Before
    public void setupBeforeMethod() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void createDog() throws Exception {
        String uri = "/api/dog";
        params.add("dogName", "Thunder");
        String result = mockMvc.perform(MockMvcRequestBuilders.post(uri).headers(headers).params(params)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        RestResponse response = JSON.parseObject(result, RestResponse.class);
        assertEquals(Integer.valueOf(0), response.getApiStatus());
    }

    @Test
    public void deleteById() throws Exception {
        String uri = "/api/dog";
        params.add("dogId", "123321");
        String result = mockMvc.perform(MockMvcRequestBuilders.delete(uri).headers(headers).params(params)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        RestResponse response = JSON.parseObject(result, RestResponse.class);
        assertEquals(Integer.valueOf(0), response.getApiStatus());
    }

    @Test
    public void updateById() throws Exception {
        String uri = "/api/dog";
        params.add("dogId", "123321");
        params.add("dogName", "Thunder");
        String result = mockMvc.perform(MockMvcRequestBuilders.put(uri).headers(headers).params(params)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        RestResponse response = JSON.parseObject(result, RestResponse.class);
        assertEquals(Integer.valueOf(0), response.getApiStatus());
    }

    @Test
    public void getById() throws Exception {
        String uri = "/api/dog";
        params.add("dogId", "123321");
        String result = mockMvc.perform(MockMvcRequestBuilders.get(uri).headers(headers).params(params)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        RestResponse response = JSON.parseObject(result, RestResponse.class);
        assertEquals(Integer.valueOf(0), response.getApiStatus());
    }

}
