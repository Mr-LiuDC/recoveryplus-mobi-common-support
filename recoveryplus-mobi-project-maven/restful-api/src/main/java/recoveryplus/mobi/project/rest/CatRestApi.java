package recoveryplus.mobi.project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recoveryplus.mobi.common.rest.RestResponse;
import recoveryplus.mobi.common.utils.ObjectId;
import recoveryplus.mobi.project.application.service.ICatApplicationService;
import recoveryplus.mobi.project.query.service.ICatQueryService;
import recoveryplus.mobi.project.query.service.dto.CatDTO;

import java.util.Optional;

import static java.lang.String.format;

/**
 * 猫咪相关Rest接口
 *
 * @author LiuDecai
 */
@RestController
@RequestMapping("/api/cat")
public class CatRestApi {

    private final ICatQueryService catQueryService;
    private final ICatApplicationService catApplicationService;

    @Autowired
    public CatRestApi(ICatQueryService catQueryService, ICatApplicationService catApplicationService) {
        this.catQueryService = catQueryService;
        this.catApplicationService = catApplicationService;
    }

    @PostMapping
    public RestResponse createCat(@RequestParam String catName) {
        catApplicationService.createCat(ObjectId.get().toString(), catName);
        return RestResponse.buildRestResponse("创建成功", "success");
    }

    @DeleteMapping
    public RestResponse deleteById(@RequestParam String catId) {
        catApplicationService.deleteCatById(catId);
        return RestResponse.buildRestResponse("删除成功", "success");
    }

    @PutMapping
    public RestResponse updateById(@RequestParam String catId, @RequestParam String catName) {
        catApplicationService.updateCatById(catId, catName);
        return RestResponse.buildRestResponse("更新成功", "success");
    }

    @GetMapping
    public RestResponse getById(@RequestParam String catId) {
        Optional<CatDTO> optionalCatDTO = catQueryService.getCatById(catId);
        if (optionalCatDTO.isPresent()) {
            return RestResponse.buildRestResponse(optionalCatDTO.get(), "success");
        } else {
            return RestResponse.buildRestResponse(format("ID为%s的猫咪不存在", catId), "success");
        }
    }

}
