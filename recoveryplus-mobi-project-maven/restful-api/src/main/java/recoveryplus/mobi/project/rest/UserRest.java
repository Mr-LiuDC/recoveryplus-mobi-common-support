package recoveryplus.mobi.project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import recoveryplus.mobi.common.rest.RestResponse;
import recoveryplus.mobi.project.application.service.UserApplicationService;
import recoveryplus.mobi.project.query.service.UserQueryService;

/**
 * 用户Rest接口
 *
 * @author LiuDecai
 */
@RestController
@RequestMapping("/api/user")
public class UserRest {

    private final UserQueryService userQueryService;
    private final UserApplicationService userApplicationService;

    @Autowired
    public UserRest(UserQueryService userQueryService, UserApplicationService userApplicationService) {
        this.userQueryService = userQueryService;
        this.userApplicationService = userApplicationService;
    }

    @PostMapping
    public RestResponse createUser(@RequestParam String userName) {
        return RestResponse.buildRestResponse("", "success");
    }

}
