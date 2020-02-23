package net.bill99.community.community.server;

import net.bill99.community.community.dto.QuestionDto;
import net.bill99.community.community.entity.Question;
import net.bill99.community.community.entity.User;
import net.bill99.community.community.mapper.QuestionMapper;
import net.bill99.community.community.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 22:06 2020/2/22
 */
@Service
public class QuestionDtoServer {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    public List<QuestionDto> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for(Question question : questions){
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        return questionDtoList;
    }
}
