package recoveryplus.mobi.common.ddd.support.domain;

import java.io.Serializable;

/**
 * 聚合根
 *
 * @param <ID> 主键类型
 * @author LiuDecai
 */
public interface IAggregateRoot<ID extends Serializable> extends IEntity<ID> {
}
