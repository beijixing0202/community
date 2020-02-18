package net.bill99.community.community.mapper;

import net.bill99.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 16:40 2020/2/18
 */
@Mapper
public interface UserMapper {
    @Insert("insert into USER (NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    public void insertUser(User user);
    @Select("select * from USER where TOKEN = #{token}")
    User getByToekn(@Param("token") String token);
}
