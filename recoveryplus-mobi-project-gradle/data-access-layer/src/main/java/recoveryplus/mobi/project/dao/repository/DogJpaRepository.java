package recoveryplus.mobi.project.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recoveryplus.mobi.project.dao.entity.DogEntity;

/**
 * The dog JPA repository.
 *
 * @author LiuDecai
 */
public interface DogJpaRepository extends JpaRepository<DogEntity, String> {
}
