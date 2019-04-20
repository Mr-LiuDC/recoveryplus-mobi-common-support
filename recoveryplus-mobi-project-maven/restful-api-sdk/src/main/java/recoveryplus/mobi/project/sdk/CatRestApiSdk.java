package recoveryplus.mobi.project.sdk;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import recoveryplus.mobi.common.rest.RestResponse;
import recoveryplus.mobi.project.sdk.breaker.CatRestApiBreaker;

/**
 * Rest SDK
 *
 * @author LiuDecai
 */
@FeignClient(name = "my-cat-service", path = "/api/cat", fallbackFactory = CatRestApiBreaker.class)
public interface CatRestApiSdk {

    /**
     * 创建猫咪信息
     *
     * @param catName 猫咪名称
     * @return 响应结果
     */
    @PostMapping
    RestResponse createCat(@RequestParam(name = "catName") String catName);

    /**
     * 根据ID删除猫咪信息
     *
     * @param catId 猫咪ID
     * @return 响应结果
     */
    @DeleteMapping
    RestResponse deleteById(@RequestParam(name = "catId") String catId);

    /**
     * 根据ID更新猫咪信息
     *
     * @param catId   猫咪ID
     * @param catName 猫咪名称
     * @return 响应结果
     */
    @PutMapping
    RestResponse updateById(@RequestParam(name = "catId") String catId, @RequestParam(name = "catName") String catName);

    /**
     * 根据ID查询猫咪信息
     *
     * @param catId 猫咪ID
     * @return 响应结果
     */
    @GetMapping
    RestResponse getById(@RequestParam(name = "catId") String catId);

}
