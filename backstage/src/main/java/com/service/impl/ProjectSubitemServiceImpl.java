package com.service.impl;

import com.mapper.PhyProjectSubitemConnectMapper;
import com.pojo.PhySubitem;
import com.service.ProjectSubitemService;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/11 21:53
 * @description:
 */
@Service
public class ProjectSubitemServiceImpl implements ProjectSubitemService {

    @Autowired
    PhyProjectSubitemConnectMapper mapper;

    @Override
    public ResponseDTO getSubitemById(int projectId) {
        List<PhySubitem> phySubitems = mapper.selectAllByProjectId(projectId);
        return ResponseDTO.success(phySubitems);
    }
}
