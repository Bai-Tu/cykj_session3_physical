package com.mapper;

import com.pojo.PhyCombo;
import com.vo.SearchPageVo;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/13 8:38
 * @description:
 */
public interface PhyComboMapper {
    int deleteByPrimaryKey(Integer comboId);

    int insert(PhyCombo record);

    int insertSelective(PhyCombo record);

    PhyCombo selectByPrimaryKey(Integer comboId);

    int updateByPrimaryKeySelective(PhyCombo record);

    int updateByPrimaryKey(PhyCombo record);

    List<PhyCombo> getAllCombo();
    List<PhyCombo> getAllComboWithStatus(int status);

    List<PhyCombo> searchCombo(SearchPageVo vo);
}