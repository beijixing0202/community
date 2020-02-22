package net.bill99.community.community.dto;

import lombok.Data;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 10:45 2020/2/16
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
