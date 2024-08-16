package com.service;

import com.pojo.PhyProject;
import com.pojo.PhySubitem;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;

/**
 * @author 李璟瑜
 * @date 2024/8/9 20:33
 * @description:
 */
public interface SubitemService {
    ResponseDTO getAllSubitem(PageVo vo);
    ResponseDTO insertSubitem(PhySubitem subitem);
    ResponseDTO editSubitem(PhySubitem subitem);
    ResponseDTO searchSubitem(SearchPageVo vo);
    ResponseDTO editSubitemStatus(PhySubitem subitem);
    ResponseDTO getAllSubitemNoVo();
    ResponseDTO getDiffSubitem(int projectId);
    ResponseDTO getAllSubitemNoVoWithStatus(int status);
    ResponseDTO getDiffSubitemWithStatus(PhyProject vo);
}
