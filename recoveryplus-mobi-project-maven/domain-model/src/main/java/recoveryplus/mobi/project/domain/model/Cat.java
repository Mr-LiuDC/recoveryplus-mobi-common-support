package recoveryplus.mobi.project.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import recoveryplus.mobi.common.ddd.support.domain.IAggregateRoot;

import java.util.Date;

/**
 * Cat领域模型
 *
 * @author LiuDecai
 */
@Getter
@Setter(AccessLevel.PRIVATE)
public class Cat implements IAggregateRoot<String> {

    private String id;
    private String name;
    private Date createTime;
    private Date updateTime;

    private Cat() {
    }

    public static Cat create(String catId, String catName) {
        Cat cat = new Cat();
        Date createTime = new Date();
        cat.id = catId;
        cat.name = catName;
        cat.createTime = createTime;
        cat.updateTime = createTime;
        return cat;
    }

    public static Cat fill(String id, String name, Date createTime, Date updateTime) {
        Cat cat = new Cat();
        cat.id = id;
        cat.name = name;
        cat.createTime = createTime;
        cat.updateTime = updateTime;
        return cat;
    }

    public void changeName(String name) {
        this.name = name;
        this.updateTime = new Date();
    }

}
