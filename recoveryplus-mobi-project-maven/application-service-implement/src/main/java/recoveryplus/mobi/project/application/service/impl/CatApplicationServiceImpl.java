package recoveryplus.mobi.project.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recoveryplus.mobi.project.application.service.CatApplicationService;
import recoveryplus.mobi.project.domain.model.Cat;
import recoveryplus.mobi.project.infrastructure.repository.CatRepository;

/**
 * 用户领域服务实现
 *
 * @author LiuDecai
 */
@Service
public class CatApplicationServiceImpl implements CatApplicationService {

    @Autowired
    private CatRepository catRepository;

    @Override
    public void createCat(String catId, String catName) {
        Cat cat = Cat.create(catId, catName);
        catRepository.save(cat);
    }
}
