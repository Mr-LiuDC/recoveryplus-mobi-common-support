package recoveryplus.mobi.project.rest.sdk;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import recoveryplus.mobi.common.rest.RestResponse;
import recoveryplus.mobi.project.rest.sdk.breaker.DogRestApiBreaker;

/**
 * Dog Rest Api SDK
 *
 * @author LiuDecai
 */
@FeignClient(name = "my-dog-service", path = "/api/dog", fallbackFactory = DogRestApiBreaker.class)
public interface DogRestApiSdk {

    /**
     * Create dog information.
     *
     * @param dogName dog name.
     * @return response result.
     */
    @PostMapping
    RestResponse createDog(@RequestParam(name = "dogName") String dogName);

    /**
     * Delete dog information by id.
     *
     * @param dogId dog id.
     * @return response result.
     */
    @DeleteMapping
    RestResponse deleteById(@RequestParam(name = "dogId") String dogId);

    /**
     * Update dog information by id
     *
     * @param dogId   dog id.
     * @param dogName dog name.
     * @return response result.
     */
    @PutMapping
    RestResponse updateById(@RequestParam(name = "dogId") String dogId, @RequestParam(name = "dogName") String dogName);

    /**
     * Get dog information by id.
     *
     * @param dogId dog id.
     * @return response result.
     */
    @GetMapping
    RestResponse getById(@RequestParam(name = "dogId") String dogId);

}
