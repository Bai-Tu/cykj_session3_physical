package com.mapper;

import com.pojo.NewPhyStatementLog;
import com.pojo.PhyStatementLog;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/22 8:46
 * @description:
 */
public interface PhyStatementLogMapper {
    int addLog(PhyStatementLog log);
    List<NewPhyStatementLog> getStatementlog();
    List<NewPhyStatementLog> getStatementlogInSearch(String name);
}
