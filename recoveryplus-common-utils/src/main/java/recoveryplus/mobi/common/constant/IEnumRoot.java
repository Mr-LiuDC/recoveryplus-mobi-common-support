package recoveryplus.mobi.common.constant;

/**
 * 枚举接口
 *
 * @author LiuDeCai
 */
public interface IEnumRoot<T> {

    /**
     * 获枚举的值
     *
     * @return 枚举的值
     */
    T value();

    /**
     * 获枚举的描述信息
     *
     * @return 枚举的描述信息
     */
    String description();
}
