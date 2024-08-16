package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhySubitemConclutionMapper;
import com.pojo.PhyOrder;
import com.pojo.PhySubitemConclution;
import com.pojo.SubitemConclutionAndSubitem;
import com.service.DiagnoseService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/15 10:09
 * @description:
 */
@Service
public class DiagnoseServiceImpl implements DiagnoseService {
    @Autowired
    PhySubitemConclutionMapper mapper;

    @Override
    public ResponseDTO getOrderContextByNumberByPage(SearchPageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<SubitemConclutionAndSubitem> orderContextByNumber = mapper.getOrderContextByNumber(vo.getName());
        PageInfo<SubitemConclutionAndSubitem> pageInfo = new PageInfo<>(orderContextByNumber);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO updateConclution(PhySubitemConclution vo) {
        int i = mapper.updateByPrimaryKeySelective(vo);
        return ResponseDTO.success(i);
    }
}
