package net.bill99.community.community.entity;

import lombok.Data;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 16:43 2020/2/18
 */
@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
