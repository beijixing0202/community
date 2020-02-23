package net.bill99.community.community.dto;

import lombok.Data;
import net.bill99.community.community.entity.User;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 21:58 2020/2/22
 */
@Data
public class QuestionDto {
    private Integer id;
    private String title;
    private String description;
    private Integer creator;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCouunt;
    private User user;
}
