package com.mapper;

import com.pojo.PhyProject;
import com.pojo.PhyProjectSubitemConnect;
import com.vo.SearchPageVo;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/12 14:11
 * @description:
 */
public interface PhyProjectMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(PhyProject record);

    int insertSelective(PhyProject record);

    PhyProject selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(PhyProject record);

    int updateByPrimaryKey(PhyProject record);

    List<PhyProject> getAllProject();

    List<PhyProject> selectAllByProjectName(String name);
    List<PhyProjectSubitemConnect> getProSubConnect(int projectId);
    List<PhyProject> selectAllByNameAndPrice(SearchPageVo vo);
    List<PhyProject> selectDiffProject(int comboId);
    List<PhyProject> getAllProjectWithStatus(int status);
}