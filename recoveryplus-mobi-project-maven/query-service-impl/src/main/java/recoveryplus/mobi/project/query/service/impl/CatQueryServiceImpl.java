package recoveryplus.mobi.project.query.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recoveryplus.mobi.project.dao.entity.CatEntity;
import recoveryplus.mobi.project.dao.repository.CatJpaRepository;
import recoveryplus.mobi.project.query.service.ICatQueryService;
import recoveryplus.mobi.project.query.service.dto.CatDTO;

import java.util.Optional;

/**
 * 猫咪信息查询服务实现
 *
 * @author LiuDecai
 */
@Service
public class CatQueryServiceImpl implements ICatQueryService {

    private final CatJpaRepository catJpaRepository;

    @Autowired
    public CatQueryServiceImpl(CatJpaRepository catJpaRepository) {
        this.catJpaRepository = catJpaRepository;
    }

    @Override
    public Optional<CatDTO> getCatById(String catId) {
        Optional<CatEntity> catEntityOptional = catJpaRepository.findById(catId);
        if (catEntityOptional.isPresent()) {
            CatDTO catDTO = new CatDTO();
            BeanUtils.copyProperties(catEntityOptional.get(), catDTO);
            return Optional.of(catDTO);
        } else {
            return Optional.empty();
        }
    }
}
