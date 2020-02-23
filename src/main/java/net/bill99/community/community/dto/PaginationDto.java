package net.bill99.community.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 17:17 2020/2/23
 */
@Data
public class PaginationDto {
    private List<QuestionDto> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();
    public void setPagination(Integer totalCount, Integer page, Integer size) {
        totalPage = (totalCount % size ==0 ? totalCount/size : totalCount/size+1);
        if(page<1){
            page = 1;
        }
        if(page>totalPage){
            page=totalPage;
        }
        this.page = page;
        pages.add(page);
        for(int i = 1;i<=3;i++){
            if (page -i > 0){
                pages.add(0,page-i);
            }
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }
        //是否展示前一页
        showPrevious = (page ==1 ? false : true);
        //是否展示后一页
        showNext = (page == totalPage ? false : true);
        //是否展示首页
        showFirstPage = (pages.contains(1) ? false : true);
        //是否展示最后页
        showEndPage = (pages.contains(totalPage) ? false : true);

    }
}
