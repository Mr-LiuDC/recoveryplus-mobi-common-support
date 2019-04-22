package recoveryplus.mobi.project.domain.model;

import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import recoveryplus.mobi.common.ddd.support.domain.IAggregateRoot;
import recoveryplus.mobi.common.exception.CommonException;
import recoveryplus.mobi.common.utils.ObjectId;

import java.util.Date;

/**
 * The dog domain.
 *
 * @author LiuDecai
 */
@Getter
@Setter(AccessLevel.PRIVATE)
public class Dog implements IAggregateRoot<String> {

    private String id;
    private String name;
    private Date createTime;
    private Date updateTime;

    private Dog() {
    }

    public static Dog create(String dogId, String dogName) {
        if (!ObjectId.isValid(dogId)) {
            throw new CommonException("不合法的dogId");
        }
        if (Strings.isNullOrEmpty(dogId)) {
            throw new CommonException("dogName不能为空");
        }
        Dog dog = new Dog();
        Date createTime = new Date();
        dog.id = dogId;
        dog.name = dogName;
        dog.createTime = createTime;
        dog.updateTime = createTime;
        return dog;
    }

    public static Dog fill(String id, String name, Date createTime, Date updateTime) {
        Dog dog = new Dog();
        dog.id = id;
        dog.name = name;
        dog.createTime = createTime;
        dog.updateTime = updateTime;
        return dog;
    }

    public void changeName(String dogName) {
        if (Strings.isNullOrEmpty(dogName)) {
            throw new CommonException("dogName不能为空");
        }
        this.name = dogName;
        this.updateTime = new Date();
    }

}
