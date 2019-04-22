package recoveryplus.mobi.project.query.service;

import recoveryplus.mobi.project.dto.DogDTO;

import java.util.Optional;

/**
 * The Dog query service interface.
 *
 * @author LiuDecai
 */
public interface IDogQueryService {

    /**
     * Get dog information by id.
     *
     * @param dogId dog id.
     * @return optional dog information.
     */
    Optional<DogDTO> getDogById(String dogId);

}
