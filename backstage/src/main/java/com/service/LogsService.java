package com.service;

import com.pojo.PhyLog;
import com.util.ResponseDTO;
import com.vo.PageVo;

/**
 * @author 李璟瑜
 * @date 2024/8/22 14:19
 * @description:
 */
public interface LogsService {
    ResponseDTO addLogs(PhyLog log);
    ResponseDTO getLogsByPage(PageVo vo);
}
