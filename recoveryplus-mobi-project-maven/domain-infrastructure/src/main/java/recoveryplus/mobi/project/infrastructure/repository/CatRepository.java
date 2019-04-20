package recoveryplus.mobi.project.infrastructure.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import recoveryplus.mobi.common.exception.InvalidOperationException;
import recoveryplus.mobi.project.dao.entity.CatEntity;
import recoveryplus.mobi.project.dao.repository.CatJpaRepository;
import recoveryplus.mobi.project.domain.model.Cat;
import recoveryplus.mobi.project.domain.repository.ICatRepository;

import java.util.Optional;

import static java.lang.String.format;

/**
 * Cat领域模型仓储实现
 *
 * @author LiuDecai
 */
@Repository
public class CatRepository implements ICatRepository {

    private final CatJpaRepository catJpaRepository;

    @Autowired
    public CatRepository(CatJpaRepository catJpaRepository) {
        this.catJpaRepository = catJpaRepository;
    }

    @Override
    public Cat add(Cat domain) {
        CatEntity entity = new CatEntity();
        BeanUtils.copyProperties(domain, entity);
        catJpaRepository.save(entity);
        return domain;
    }

    @Override
    public void delete(String id) {
        Optional<Cat> optionalCat = get(id);
        optionalCat.ifPresent(cat -> catJpaRepository.deleteById(cat.getId()));
    }

    @Override
    public Cat update(Cat domain) {
        Optional<Cat> optionalCat = get(domain.getId());
        if (optionalCat.isPresent()) {
            CatEntity entity = new CatEntity();
            BeanUtils.copyProperties(domain, entity);
            catJpaRepository.saveAndFlush(entity);
            return domain;
        } else {
            throw new InvalidOperationException(format("要更新的模型【%s】不存在", Cat.class.getName()));
        }
    }

    @Override
    public Optional<Cat> get(String id) {
        Optional<CatEntity> optionalEntity = catJpaRepository.findById(id);
        if (optionalEntity.isPresent()) {
            CatEntity entity = optionalEntity.get();
            return Optional.of(Cat.fill(entity.getId(), entity.getName(), entity.getCreateTime(), entity.getUpdateTime()));
        } else {
            return Optional.empty();
        }
    }
}
