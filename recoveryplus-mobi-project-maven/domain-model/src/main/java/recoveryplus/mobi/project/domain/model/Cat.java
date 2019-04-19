package recoveryplus.mobi.project.domain.model;

import java.util.Date;

/**
 * Cat领域模型
 *
 * @author LiuDecai
 */
public class Cat {

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



}
