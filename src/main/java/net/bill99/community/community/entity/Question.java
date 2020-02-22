package net.bill99.community.community.entity;

import lombok.Data;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 22:04 2020/2/18
 */
@Data
public class Question {
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

}
