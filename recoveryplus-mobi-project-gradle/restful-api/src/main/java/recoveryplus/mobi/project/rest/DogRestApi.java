package recoveryplus.mobi.project.rest;

import org.springframework.web.bind.annotation.*;
import recoveryplus.mobi.common.rest.RestResponse;

/**
 * Dog Rest Api
 *
 * @author LiuDecai
 */
@RestController
@RequestMapping("/api/dog")
public class DogRestApi {

    private static final String SUCCESS = "success";

    @PostMapping
    public RestResponse create() {
        return RestResponse.buildRestResponse("", SUCCESS);
    }

    @DeleteMapping
    public RestResponse delete() {
        return RestResponse.buildRestResponse("", SUCCESS);
    }

    @PutMapping
    public RestResponse update() {
        return RestResponse.buildRestResponse("", SUCCESS);
    }

    @GetMapping
    public RestResponse query() {
        return RestResponse.buildRestResponse("", SUCCESS);
    }

}
