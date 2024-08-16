package com.mapper;

import com.pojo.PhyProjectSubitemConnect;
import com.pojo.PhySubitem;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
public interface PhyProjectSubitemConnectMapper {
    int deleteByPrimaryKey(Integer projectSubitemConnectId);

    int insert(PhyProjectSubitemConnect record);

    int insertSelective(PhyProjectSubitemConnect record);

    PhyProjectSubitemConnect selectByPrimaryKey(Integer projectSubitemConnectId);

    int updateByPrimaryKeySelective(PhyProjectSubitemConnect record);

    int updateByPrimaryKey(PhyProjectSubitemConnect record);
    List<PhyProjectSubitemConnect> selectAllBySubitemId(int id);
    List<PhySubitem> selectAllByProjectId(int id);
    int deleteByProjectId(int projectId);
}