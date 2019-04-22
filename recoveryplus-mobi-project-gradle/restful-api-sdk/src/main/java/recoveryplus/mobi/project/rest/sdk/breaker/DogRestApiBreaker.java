package recoveryplus.mobi.project.rest.sdk.breaker;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import recoveryplus.mobi.common.rest.RestResponse;
import recoveryplus.mobi.project.rest.sdk.DogRestApiSdk;

/**
 * The rest api breaker.
 *
 * @author LiuDecai
 */
@Slf4j
public class DogRestApiBreaker implements FallbackFactory<DogRestApiSdk> {
    @Override
    public DogRestApiSdk create(Throwable throwable) {
        return new DogRestApiSdk() {
            @Override
            public RestResponse createDog(String dogName) {
                return defaultResponse();
            }

            @Override
            public RestResponse deleteById(String dogId) {
                return defaultResponse();
            }

            @Override
            public RestResponse updateById(String dogId, String dogName) {
                return defaultResponse();
            }

            @Override
            public RestResponse getById(String dogId) {
                return defaultResponse();
            }

            private RestResponse<?> defaultResponse() {
                log.warn("Breaker提示当前服务不可用: {}", throwable.getMessage());
                return RestResponse.buildRestResponse("当前服务不可用", throwable.getMessage());
            }
        };
    }
}
