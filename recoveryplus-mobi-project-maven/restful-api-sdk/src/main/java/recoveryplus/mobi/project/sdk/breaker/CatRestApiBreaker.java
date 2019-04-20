package recoveryplus.mobi.project.sdk.breaker;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import recoveryplus.mobi.common.rest.RestResponse;
import recoveryplus.mobi.project.sdk.CatRestApiSdk;

/**
 * 断路器
 *
 * @author LiuDecai
 */
@Slf4j
public class CatRestApiBreaker implements FallbackFactory<CatRestApiSdk> {
    @Override
    public CatRestApiSdk create(Throwable cause) {
        return new CatRestApiSdk() {
            @Override
            public RestResponse createCat(String catName) {
                return defaultResponse();
            }

            @Override
            public RestResponse deleteById(String catId) {
                return defaultResponse();
            }

            @Override
            public RestResponse updateById(String catId, String catName) {
                return defaultResponse();
            }

            @Override
            public RestResponse getById(String catId) {
                return defaultResponse();
            }

            private RestResponse<?> defaultResponse() {
                log.warn("Breaker提示当前服务不可用: {}", cause.getMessage());
                return RestResponse.buildRestResponse("当前服务不可用", cause.getMessage());
            }
        };
    }

}
