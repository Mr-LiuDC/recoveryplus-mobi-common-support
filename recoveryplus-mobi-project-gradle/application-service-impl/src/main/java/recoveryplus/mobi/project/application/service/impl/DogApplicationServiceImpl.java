package recoveryplus.mobi.project.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recoveryplus.mobi.project.application.service.IDogApplicationService;
import recoveryplus.mobi.project.domain.model.Dog;
import recoveryplus.mobi.project.domain.repository.IDogRepository;

import java.util.Optional;

/**
 * The Dog application service implementation.
 *
 * @author LiuDecai
 */
@Service
public class DogApplicationServiceImpl implements IDogApplicationService {

    @Autowired
    private IDogRepository dogRepository;

    @Override
    public void createDog(String dogId, String dogName) {
        Dog dog = Dog.create(dogId, dogName);
        dogRepository.add(dog);
    }

    @Override
    public void deleteDogById(String dogId) {
        dogRepository.delete(dogId);
    }

    @Override
    public void updateById(String dogId, String dogName) {
        Optional<Dog> optionalDog = dogRepository.get(dogId);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.changeName(dogName);
            dogRepository.update(dog);
        }
    }

}
