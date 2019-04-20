package recoveryplus.mobi.project.query.service;

import recoveryplus.mobi.project.query.service.dto.CatDTO;

import java.util.Optional;

/**
 * 猫咪信息查询服务
 *
 * @author LiuDecai
 */
public interface ICatQueryService {

    /**
     * 根据ID查询猫咪信息
     *
     * @param catId 猫咪ID
     * @return 猫咪信息
     */
    Optional<CatDTO> getCatById(String catId);

}
