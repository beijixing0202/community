package net.bill99.community.community.mapper;

import net.bill99.community.community.entity.User;
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
    @Insert("insert into USER (NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED,AVATAR_URL) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insertUser(User user);
    @Select("select * from USER where token = #{token}")
    User getByToekn(@Param("token") String token);
    @Select("select * from USER where id=#{id}")
    User findById(@Param("id") Integer id);
}
