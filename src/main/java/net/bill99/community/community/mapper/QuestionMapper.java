package net.bill99.community.community.mapper;

import net.bill99.community.community.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 22:03 2020/2/18
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into QUESTION (TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAG) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void create(Question question);
    @Select("select * from QUESTION order by id desc limit #{offSet},#{size} ")
    List<Question> list(@Param(value = "offSet") Integer offSet,@Param(value = "size") Integer size);
    @Select("select count(1) from QUESTION")
    Integer count();
    @Select("select * from QUESTION where CREATOR=#{userId} order by id desc limit #{offSet},#{size}")
    List<Question> listByUserId(@Param(value = "userId") Integer userId, @Param(value = "offSet") Integer offSet,@Param(value = "size") Integer size);
    @Select("select count(1) from QUESTION where CREATOR=#{userId}")
    Integer countByUserId(@Param(value = "userId") Integer userId);
}
