package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyComboMapper;
import com.mapper.PhyComboProjectConnetMapper;
import com.mapper.PhyProjectMapper;
import com.pojo.PhyCombo;
import com.pojo.PhyComboProjectConnet;
import com.pojo.PhyProject;
import com.service.ComboService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/12 20:40
 * @description:
 */
@Service
public class ComboServiceImpl implements ComboService {

    @Autowired
    PhyComboMapper mapper;

    @Autowired
    PhyComboProjectConnetMapper comproConnetMapper;


    @Override
    public ResponseDTO getAllComboByPage(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyCombo> allCombo = mapper.getAllCombo();
        PageInfo<PhyCombo> pageInfo = new PageInfo<>(allCombo);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO searchCombo(SearchPageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyCombo> phyCombos = mapper.searchCombo(vo);
        PageInfo<PhyCombo> pageInfo = new PageInfo<>(phyCombos);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO addCombo(PhyCombo vo) {
        int i = mapper.insertSelective(vo);
        List<PhyProject> projects = vo.getProjects();
        Iterator<PhyProject> iterator = projects.iterator();
        while (iterator.hasNext()){
            PhyProject next = iterator.next();
            PhyComboProjectConnet temp = new PhyComboProjectConnet();
            temp.setComboId(vo.getComboId());
            temp.setProjectId(next.getProjectId());
            comproConnetMapper.insertSelective(temp);
        }
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO editCombo(PhyCombo vo) {
        int i = mapper.updateByPrimaryKeySelective(vo);
        List<PhyProject> projects = vo.getProjects();
        Iterator<PhyProject> iterator = projects.iterator();
        comproConnetMapper.deleteByComboId(vo.getComboId());
        while (iterator.hasNext()){
            PhyProject next = iterator.next();
            PhyComboProjectConnet temp = new PhyComboProjectConnet();
            temp.setComboId(vo.getComboId());
            temp.setProjectId(next.getProjectId());
            comproConnetMapper.insertSelective(temp);
        }

        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO switchComboStatus(PhyCombo vo) {
        int i = mapper.updateByPrimaryKeySelective(vo);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO getAllComboNoPage() {
        List<PhyCombo> allCombo = mapper.getAllCombo();
        return ResponseDTO.success(allCombo);
    }

    @Override
    public ResponseDTO getAllComboWithStatus(int status) {
        List<PhyCombo> allComboWithStatus = mapper.getAllComboWithStatus(status);
        return ResponseDTO.success(allComboWithStatus);
    }
}
