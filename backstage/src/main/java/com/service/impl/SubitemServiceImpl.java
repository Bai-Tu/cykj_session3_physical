package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyProjectSubitemConnectMapper;
import com.mapper.PhySubitemMapper;
import com.pojo.PhyDepartment;
import com.pojo.PhyProject;
import com.pojo.PhyProjectSubitemConnect;
import com.pojo.PhySubitem;
import com.service.SubitemService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/9 20:33
 * @description:
 */
@Service
public class SubitemServiceImpl implements SubitemService {

    @Autowired
    PhySubitemMapper mapper;

    @Autowired
    PhyProjectSubitemConnectMapper PSCmapper;

    @Override
    public ResponseDTO getAllSubitem(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhySubitem> allSubitem = mapper.getAllSubitem();
        PageInfo<PhySubitem> pageInfo = new PageInfo<>(allSubitem);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO insertSubitem(PhySubitem subitem) {
        List<PhySubitem> subitemByName = mapper.getSubitemByName(subitem.getSubitemName());
        if (subitemByName.size() != 0){
            return new ResponseDTO(-2,"重复",null);
        }

        int i = mapper.insertSubitem(subitem);
        if (i>0){
            return ResponseDTO.success();
        }
        return ResponseDTO.fail();
    }

    @Override
    public ResponseDTO editSubitem(PhySubitem subitem) {
        int i = mapper.updateByPrimaryKeySelective(subitem);
        if (i>0){
            return ResponseDTO.success();
        }
        return ResponseDTO.fail();
    }

    @Override
    public ResponseDTO searchSubitem(SearchPageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhySubitem> bySubitemNameInSearch = mapper.getBySubitemNameInSearch(vo.getName());
        PageInfo<PhySubitem> phySubitemPageInfo = new PageInfo<>(bySubitemNameInSearch);
        return ResponseDTO.success(phySubitemPageInfo);
    }

    @Override
    public ResponseDTO editSubitemStatus(PhySubitem subitem) {
        List<PhyProjectSubitemConnect> phyProjectSubitemConnects = PSCmapper.selectAllBySubitemId(subitem.getSubitemId());
        if (phyProjectSubitemConnects.size() != 0){
            return new ResponseDTO(-2,"还有在使用的",null);
        }else {
            mapper.updateByPrimaryKeySelective(subitem);
            return ResponseDTO.success();
        }
    }

    @Override
    public ResponseDTO getAllSubitemNoVo() {
        List<PhySubitem> allSubitem = mapper.getAllSubitem();
        return ResponseDTO.success(allSubitem);
    }

    @Override
    public ResponseDTO getDiffSubitem(int projectId) {
        List<PhySubitem> diffSubitem = mapper.getDiffSubitem(projectId);
        return ResponseDTO.success(diffSubitem);
    }

    @Override
    public ResponseDTO getAllSubitemNoVoWithStatus(int status) {
        List<PhySubitem> allSubitemNoVoWithStatus = mapper.getAllSubitemNoVoWithStatus(status);
        return ResponseDTO.success(allSubitemNoVoWithStatus);
    }

    @Override
    public ResponseDTO getDiffSubitemWithStatus(PhyProject vo) {
        List<PhySubitem> diffSubitemWithStatus = mapper.getDiffSubitemWithStatus(vo.getProjectStatus(),vo.getProjectId());
        return ResponseDTO.success(diffSubitemWithStatus);
    }
}
