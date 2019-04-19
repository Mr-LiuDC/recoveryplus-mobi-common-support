package recoveryplus.mobi.common.ddd.support.domain;

import java.io.Serializable;

/**
 * 实体对象
 *
 * @param <ID> 主键类型
 * @author LiuDecai
 */
public interface IEntity<ID extends Serializable> extends Serializable {

    /**
     * 获取主键
     *
     * @return 主键
     */
    ID getId();

}
