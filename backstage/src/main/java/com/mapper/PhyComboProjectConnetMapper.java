package com.mapper;

import com.pojo.PhyComboProjectConnet;
import com.pojo.PhyProject;
import com.pojo.PhySubitem;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
public interface PhyComboProjectConnetMapper {
    int deleteByPrimaryKey(Integer comboProjectConnetId);

    int insert(PhyComboProjectConnet record);

    int insertSelective(PhyComboProjectConnet record);

    PhyComboProjectConnet selectByPrimaryKey(Integer comboProjectConnetId);

    int updateByPrimaryKeySelective(PhyComboProjectConnet record);

    int updateByPrimaryKey(PhyComboProjectConnet record);

    List<PhyProject> getProjectByProjectId(int project);
    List<PhyProject> getProjectByComboId(int comboId);
    List<PhySubitem> getSubitemByComboId(int comboId);
    int deleteByComboId(int comboId);
}