package recoveryplus.mobi.project.sdk;

import org.springframework.cloud.openfeign.FeignClient;
import recoveryplus.mobi.project.sdk.breaker.CatRestApiBreaker;

/**
 * Rest SDK
 *
 * @author LiuDecai
 */
@FeignClient(name = "my-cat-service", path = "/api/cat", fallbackFactory = CatRestApiBreaker.class)
public interface CatRestApiSdk {



}
