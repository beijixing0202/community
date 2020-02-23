package net.bill99.community.community.server;

import net.bill99.community.community.dto.PaginationDto;
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
    public PaginationDto list(Integer page, Integer size) {
        PaginationDto paginationDto = new PaginationDto();
        Integer totalCount = questionMapper.count();
        paginationDto.setPagination(totalCount,page,size);
        if(page<1){
            page = 1;
        }
        if(page>paginationDto.getTotalPage()){
            page = paginationDto.getTotalPage();
        }
        //size*(page-1)
        Integer offSet = size*(page-1);
        List<Question> questions = questionMapper.list(offSet,size);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for(Question question : questions){
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        paginationDto.setQuestions(questionDtoList);
        return paginationDto;
    }
}
