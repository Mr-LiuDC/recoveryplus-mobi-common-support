package recoveryplus.mobi.project.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 喵咪信息表
 *
 * @author LiuDecai
 */
@Data
@Entity
@Table(name = "cat_table")
@org.hibernate.annotations.Table(appliesTo = "cat_table", comment = "喵咪信息表")
public class CatEntity {

    @Id
    @Column(columnDefinition = "char(24) comment '主键ID'")
    private String id;

    @Column(columnDefinition = "varchar(60) comment '猫咪名称'")
    private String name;

    @Column(name = "create_time", columnDefinition = "timestamp default current_timestamp comment '创建时间'")
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "timestamp default current_timestamp comment '修改时间'")
    private Date updateTime;

}
