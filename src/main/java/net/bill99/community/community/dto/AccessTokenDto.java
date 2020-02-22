package net.bill99.community.community.dto;

import lombok.Data;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 9:52 2020/2/16
 */
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
