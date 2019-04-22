package recoveryplus.mobi.project.application.service;

/**
 * The Dog application service interface.
 *
 * @author LiuDecai
 */
public interface IDogApplicationService {

    /**
     * Create dog information.
     *
     * @param dogId   dog id.
     * @param dogName dog name.
     */
    void createDog(String dogId, String dogName);

    /**
     * Delete dog by id.
     *
     * @param dogId dog id.
     */
    void deleteDogById(String dogId);

    /**
     * Update dog information by id.
     *
     * @param dogId   dog id.
     * @param dogName dog name.
     */
    void updateById(String dogId, String dogName);
}
