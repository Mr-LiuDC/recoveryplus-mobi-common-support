package recoveryplus.mobi.project.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recoveryplus.mobi.project.application.service.ICatApplicationService;
import recoveryplus.mobi.project.domain.model.Cat;
import recoveryplus.mobi.project.domain.repository.ICatRepository;

import java.util.Optional;

/**
 * 猫咪领域服务实现
 *
 * @author LiuDecai
 */
@Service
public class CatApplicationServiceImpl implements ICatApplicationService {

    private final ICatRepository catRepository;

    @Autowired
    public CatApplicationServiceImpl(ICatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public void createCat(String catId, String catName) {
        Cat cat = Cat.create(catId, catName);
        catRepository.add(cat);
    }

    @Override
    public void deleteCatById(String catId) {
        catRepository.delete(catId);
    }

    @Override
    public void updateCatById(String catId, String catName) {
        Optional<Cat> optionalCat = catRepository.get(catId);
        if (optionalCat.isPresent()) {
            Cat cat = optionalCat.get();
            cat.changeName(catName);
            catRepository.update(cat);
        }
    }

}
