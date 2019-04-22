package recoveryplus.mobi.project.query.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recoveryplus.mobi.project.dao.entity.DogEntity;
import recoveryplus.mobi.project.dao.repository.DogJpaRepository;
import recoveryplus.mobi.project.dto.DogDTO;
import recoveryplus.mobi.project.query.service.IDogQueryService;

import java.util.Optional;

/**
 * The Dog query service implementation.
 *
 * @author LiuDecai
 */
@Service
public class DogQueryServiceImpl implements IDogQueryService {

    @Autowired
    private DogJpaRepository dogJpaRepository;

    @Override
    public Optional<DogDTO> getDogById(String dogId) {
        Optional<DogEntity> optionalDogEntity = dogJpaRepository.findById(dogId);
        if (optionalDogEntity.isPresent()) {
            DogDTO dogDTO = new DogDTO();
            BeanUtils.copyProperties(optionalDogEntity.get(), dogDTO);
            return Optional.of(dogDTO);
        } else {
            return Optional.empty();
        }
    }

}
