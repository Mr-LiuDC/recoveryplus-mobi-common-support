package recoveryplus.mobi.project.infrastructure.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import recoveryplus.mobi.common.exception.InvalidOperationException;
import recoveryplus.mobi.project.dao.entity.DogEntity;
import recoveryplus.mobi.project.dao.repository.DogJpaRepository;
import recoveryplus.mobi.project.domain.model.Dog;
import recoveryplus.mobi.project.domain.repository.IDogRepository;

import java.util.Optional;

import static java.lang.String.format;

/**
 * The Dog domain repository implementation.
 *
 * @author LiuDecai
 */
@Repository
public class DogRepositoryImpl implements IDogRepository {

    @Autowired
    private DogJpaRepository dogJpaRepository;

    @Override
    public Dog add(Dog domain) {
        DogEntity entity = new DogEntity();
        BeanUtils.copyProperties(domain, entity);
        dogJpaRepository.save(entity);
        return domain;
    }

    @Override
    public void delete(String id) {
        Optional<Dog> optionalDog = get(id);
        optionalDog.ifPresent(dog -> dogJpaRepository.deleteById(id));
    }

    @Override
    public Dog update(Dog domain) {
        Optional<Dog> optionalDog = get(domain.getId());
        if (optionalDog.isPresent()) {
            DogEntity entity = new DogEntity();
            BeanUtils.copyProperties(domain, entity);
            dogJpaRepository.saveAndFlush(entity);
            return domain;
        } else {
            throw new InvalidOperationException(format("要更新的模型【%s】不存在", Dog.class.getName()));
        }
    }

    @Override
    public Optional<Dog> get(String id) {
        Optional<DogEntity> optionalEntity = dogJpaRepository.findById(id);
        if (optionalEntity.isPresent()) {
            DogEntity entity = optionalEntity.get();
            return Optional.of(Dog.fill(entity.getId(), entity.getName(), entity.getCreateTime(), entity.getUpdateTime()));
        } else {
            return Optional.empty();
        }
    }

}
