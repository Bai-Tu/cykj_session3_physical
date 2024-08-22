package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyStatementLogMapper;
import com.pojo.NewPhyStatementLog;
import com.pojo.PhyStatementLog;
import com.service.StatementLogService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/22 8:44
 * @description:
 */
@Service
public class StatementLogServiceImpl implements StatementLogService {
    @Autowired
    PhyStatementLogMapper statementLogMapper;

    @Override
    public ResponseDTO addLog(PhyStatementLog log) {
        int i = statementLogMapper.addLog(log);
        return ResponseDTO.success(i);
    }

    @Override
    public ResponseDTO getStatementlogByPage(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<NewPhyStatementLog> statement = statementLogMapper.getStatementlog();
        PageInfo<NewPhyStatementLog> pageInfo = new PageInfo<>(statement);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO getStatementlogInSearchByPage(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<NewPhyStatementLog> statement = statementLogMapper.getStatementlogInSearch(vo.getName());
        PageInfo<NewPhyStatementLog> pageInfo = new PageInfo<>(statement);
        return ResponseDTO.success(pageInfo);
    }
}
