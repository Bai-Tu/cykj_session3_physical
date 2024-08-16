package com.service.impl;

import com.mapper.PhyConclutionMapper;
import com.mapper.PhySubitemConclutionMapper;
import com.pojo.PhyConclution;
import com.pojo.PhySubitemConclution;
import com.service.ConclutionService;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/15 14:17
 * @description:
 */
@Service
public class ConclutionServiceImpl implements ConclutionService {
    @Autowired
    PhyConclutionMapper mapper;

    @Autowired
    PhySubitemConclutionMapper subitemConclutionMapper;

    @Override
    public ResponseDTO getConclutionByOrderNumber(PhyConclution vo) {
        List<PhySubitemConclution> nullConclutionByOrderNumber = subitemConclutionMapper.getNullConclutionByOrderNumber(vo.getOrderNumber());
        if (nullConclutionByOrderNumber.size() != 0){
            return new ResponseDTO(-2,"不为空",null);
        }

        PhyConclution conclutionByOrderNumber = mapper.getConclutionByOrderNumber(vo.getOrderNumber());
        return ResponseDTO.success(conclutionByOrderNumber);
    }

    @Override
    public ResponseDTO setConclution(PhyConclution vo) {
        int i = mapper.updateByOrderNumber(vo);
        return ResponseDTO.success(i);
    }
}
