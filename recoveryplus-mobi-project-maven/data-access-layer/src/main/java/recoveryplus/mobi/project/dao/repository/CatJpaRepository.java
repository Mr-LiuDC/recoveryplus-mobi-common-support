package recoveryplus.mobi.project.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recoveryplus.mobi.project.dao.entity.CatEntity;

/**
 * Cat Jpa仓储
 *
 * @author LiuDecai
 */
public interface CatJpaRepository extends JpaRepository<CatEntity, String> {
}
