package recoveryplus.mobi.project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recoveryplus.mobi.common.rest.RestResponse;
import recoveryplus.mobi.common.utils.ObjectId;
import recoveryplus.mobi.project.application.service.IDogApplicationService;
import recoveryplus.mobi.project.dto.DogDTO;
import recoveryplus.mobi.project.query.service.IDogQueryService;

import java.util.Optional;

import static java.lang.String.format;

/**
 * Dog Rest Api
 *
 * @author LiuDecai
 */
@RestController
@RequestMapping("/api/dog")
public class DogRestApi {

    private static final String SUCCESS = "success";

    @Autowired
    private IDogQueryService dogQueryService;
    @Autowired
    private IDogApplicationService dogApplicationService;

    /**
     * New dog information.
     *
     * @param dogName dog name.
     * @return response result.
     */
    @PostMapping
    public RestResponse createDog(@RequestParam String dogName) {
        dogApplicationService.createDog(ObjectId.get().toString(), dogName);
        return RestResponse.buildRestResponse("创建成功", SUCCESS);
    }

    /**
     * Delete dog information by id.
     *
     * @param dogId dog id.
     * @return response result.
     */
    @DeleteMapping
    public RestResponse deleteById(@RequestParam String dogId) {
        dogApplicationService.deleteDogById(dogId);
        return RestResponse.buildRestResponse("删除成功", SUCCESS);
    }

    /**
     * Update dog information by id
     *
     * @param dogId   dog id.
     * @param dogName dog name.
     * @return response result.
     */
    @PutMapping
    public RestResponse updateById(@RequestParam String dogId, @RequestParam String dogName) {
        dogApplicationService.updateById(dogId, dogName);
        return RestResponse.buildRestResponse("更新成功", SUCCESS);
    }

    /**
     * Get dog information by id.
     *
     * @param dogId dog id.
     * @return response result.
     */
    @GetMapping
    public RestResponse getById(@RequestParam String dogId) {
        Optional<DogDTO> optionalDogDTO = dogQueryService.getDogById(dogId);
        if (optionalDogDTO.isPresent()) {
            return RestResponse.buildRestResponse(optionalDogDTO.get(), SUCCESS);
        } else {
            return RestResponse.buildRestResponse(format("ID为%s的狗狗不存在", dogId), SUCCESS);
        }
    }

}
