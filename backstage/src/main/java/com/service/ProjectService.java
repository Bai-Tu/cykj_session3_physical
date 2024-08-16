package com.service;

import com.pojo.PhyProject;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;

/**
 * @author 李璟瑜
 * @date 2024/8/11 21:30
 * @description:
 */
public interface ProjectService {
    ResponseDTO getAllProject(PageVo vo);
    ResponseDTO searchProject(SearchPageVo vo);
    ResponseDTO switchProjectStatus(PhyProject vo);
    ResponseDTO addProject(PhyProject vo);
    ResponseDTO editProject(PhyProject vo);
    ResponseDTO getAllProjectNoPage();
    ResponseDTO getDiffProject(int comboId);
    ResponseDTO getAllProjectWithStatus(int status);
}
