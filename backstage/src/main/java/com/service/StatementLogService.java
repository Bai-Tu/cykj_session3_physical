package com.service;

import com.pojo.PhyStatementLog;
import com.util.ResponseDTO;
import com.vo.PageVo;
import org.springframework.stereotype.Service;

/**
 * @author 李璟瑜
 * @date 2024/8/22 8:43
 * @description:
 */
public interface StatementLogService {
    ResponseDTO addLog(PhyStatementLog log);
    ResponseDTO getStatementlogByPage(PageVo vo);
    ResponseDTO getStatementlogInSearchByPage(PageVo vo);
}
