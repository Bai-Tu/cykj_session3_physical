package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyLogMapper;
import com.pojo.PhyLog;
import com.service.LogsService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/22 14:20
 * @description:
 */
@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    PhyLogMapper mapper;

    @Override
    public ResponseDTO addLogs(PhyLog log) {
        int i = mapper.insertSelective(log);
        return ResponseDTO.success(i);
    }

    @Override
    public ResponseDTO getLogsByPage(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyLog> logs = mapper.getLogs();
        PageInfo<PhyLog> pageInfo = new PageInfo<>(logs);
        return ResponseDTO.success(pageInfo);
    }
}
