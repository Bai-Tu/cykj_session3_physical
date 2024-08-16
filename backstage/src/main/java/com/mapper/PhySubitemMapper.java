package com.mapper;

import com.pojo.PhySubitem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
public interface PhySubitemMapper {
    int deleteByPrimaryKey(Integer subitemId);

    int insert(PhySubitem record);

    int insertSelective(PhySubitem record);

    PhySubitem selectByPrimaryKey(Integer subitemId);

    int updateByPrimaryKeySelective(PhySubitem record);

    int updateByPrimaryKey(PhySubitem record);

    List<PhySubitem> getAllSubitem();
    int insertSubitem(PhySubitem subitem);
    List<PhySubitem> getSubitemByName(String name);
    int editSubitem(PhySubitem subitem);
    List<PhySubitem> getBySubitemNameInSearch(String name);
    List<PhySubitem> getDiffSubitem(int projectId);
    List<PhySubitem> getAllSubitemNoVoWithStatus(int status);
    List<PhySubitem> getDiffSubitemWithStatus(@Param("status") int status,@Param("projectId") int projectId);

}