package recoveryplus.mobi.project.dto;

import lombok.Data;

import java.util.Date;

/**
 * Dog DTO
 *
 * @author LiuDecai
 */
@Data
public class DogDTO {

    private String id;

    private String name;

    private Date createTime;

    private Date updateTime;

}
