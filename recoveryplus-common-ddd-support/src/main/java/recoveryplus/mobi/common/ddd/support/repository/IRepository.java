package recoveryplus.mobi.common.ddd.support.repository;

import recoveryplus.mobi.common.ddd.support.domain.IAggregateRoot;

import java.io.Serializable;
import java.util.Optional;


/**
 * 领域模型仓储
 *
 * @param <M>  领域模型
 * @param <ID> 模型主键
 * @author LiuDecai
 */
public interface IRepository<M extends IAggregateRoot<ID>, ID extends Serializable> {

    /**
     * 创建模型
     *
     * @param model 模型
     * @return 模型
     */
    M add(M model);

    /**
     * 根据ID删除模型
     *
     * @param id 模型ID
     */
    void delete(ID id);

    /**
     * 更新模型
     *
     * @param model 模型
     * @return 模型
     */
    M update(M model);

    /**
     * 根据ID获取模型
     *
     * @param id 模型ID
     * @return 模型
     */
    Optional<M> get(ID id);

}
