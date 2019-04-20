package recoveryplus.mobi.project.application.service;

/**
 * 猫咪领域服务
 *
 * @author LiuDecai
 */
public interface ICatApplicationService {

    /**
     * 新建猫咪信息
     *
     * @param catId   猫咪ID
     * @param catName 猫咪名称
     */
    void createCat(String catId, String catName);

    /**
     * 根据ID删除猫咪信息
     *
     * @param catId 猫咪ID
     */
    void deleteCatById(String catId);

    /**
     * 根据ID更新喵咪信息
     *
     * @param catId   猫咪ID
     * @param catName 猫咪名称
     */
    void updateCatById(String catId, String catName);

}
