package recoveryplus.mobi.project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import recoveryplus.mobi.common.rest.RestResponse;
import recoveryplus.mobi.common.utils.ObjectId;
import recoveryplus.mobi.project.application.service.CatApplicationService;
import recoveryplus.mobi.project.query.service.CatQueryService;

/**
 * 用户Rest接口
 *
 * @author LiuDecai
 */
@RestController
@RequestMapping("/api/cat")
public class CatRestApi {

    private final CatQueryService catQueryService;
    private final CatApplicationService catApplicationService;

    @Autowired
    public CatRestApi(CatQueryService catQueryService, CatApplicationService catApplicationService) {
        this.catQueryService = catQueryService;
        this.catApplicationService = catApplicationService;
    }

    @PostMapping
    public RestResponse createCat(@RequestParam String catName) {
        catApplicationService.createCat(ObjectId.get().toString(), catName);
        return RestResponse.buildRestResponse("", "success");
    }

}
