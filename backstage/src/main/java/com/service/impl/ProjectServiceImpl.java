package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyComboProjectConnetMapper;
import com.mapper.PhyProjectMapper;
import com.mapper.PhyProjectSubitemConnectMapper;
import com.mapper.PhySubitemMapper;
import com.pojo.PhyProject;
import com.pojo.PhyProjectSubitemConnect;
import com.pojo.PhySubitem;
import com.service.ProjectService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/11 21:31
 * @description:
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    PhyProjectMapper mapper;

    @Autowired
    PhyProjectSubitemConnectMapper connectMapper;

    @Autowired
    PhyComboProjectConnetMapper comproConMapper;

    @Autowired
    PhySubitemMapper subMapper;

    @Override
    public ResponseDTO getAllProject(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyProject> allProject = mapper.getAllProject();
        PageInfo<PhyProject> pageInfo = new PageInfo<>(allProject);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO searchProject(SearchPageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyProject> phyProjects = mapper.selectAllByNameAndPrice(vo);
        PageInfo<PhyProject> pageInfo = new PageInfo<>(phyProjects);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO switchProjectStatus(PhyProject vo) {
        List<PhyProject> projectByComboId = comproConMapper.getProjectByProjectId(vo.getProjectId());
        if (projectByComboId.size() != 0){
            return new ResponseDTO(-2,"有存在",null);
        }else {
            int i = mapper.updateByPrimaryKeySelective(vo);
            return ResponseDTO.success();
        }
    }

    @Override
    public ResponseDTO addProject(PhyProject vo) {
        int i = mapper.insertSelective(vo);
        List<PhySubitem> subitems = vo.getSubitems();
        Iterator<PhySubitem> iterator = subitems.iterator();
        while (iterator.hasNext()){
            PhySubitem next = iterator.next();
            PhyProjectSubitemConnect ps = new PhyProjectSubitemConnect();
            ps.setProjectId(vo.getProjectId());
            ps.setSubitemId(next.getSubitemId());
            connectMapper.insertSelective(ps);
        }
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO editProject(PhyProject vo) {
        int i = mapper.updateByPrimaryKeySelective(vo);
        connectMapper.deleteByProjectId(vo.getProjectId());
        List<PhySubitem> subitems = vo.getSubitems();
        Iterator<PhySubitem> iterator = subitems.iterator();
        while (iterator.hasNext()){
            PhySubitem next = iterator.next();
            PhyProjectSubitemConnect ps = new PhyProjectSubitemConnect();
            ps.setProjectId(vo.getProjectId());
            ps.setSubitemId(next.getSubitemId());
            connectMapper.insertSelective(ps);
        }
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO getAllProjectNoPage() {
        List<PhyProject> allProject = mapper.getAllProject();
        return ResponseDTO.success(allProject);
    }

    @Override
    public ResponseDTO getDiffProject(int comboId) {
        List<PhyProject> phyProjects = mapper.selectDiffProject(comboId);
        return ResponseDTO.success(phyProjects);
    }

    @Override
    public ResponseDTO getAllProjectWithStatus(int status) {
        List<PhyProject> allProjectWithStatus = mapper.getAllProjectWithStatus(status);
        return ResponseDTO.success(allProjectWithStatus);
    }
}
