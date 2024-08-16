package com.service.impl;

import com.mapper.PhyComboProjectConnetMapper;
import com.pojo.PhyProject;
import com.pojo.PhySubitem;
import com.service.ComboProjectService;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/12 20:41
 * @description:
 */
@Service
public class ComboProjectServiceImpl implements ComboProjectService {
    @Autowired
    PhyComboProjectConnetMapper mapper;

    @Override
    public ResponseDTO getProjectByComboId(int comboId) {
        List<PhyProject> projectByComboId = mapper.getProjectByComboId(comboId);
        return ResponseDTO.success(projectByComboId);

    }

    @Override
    public ResponseDTO getSubitemByComboId(int comboId) {
        List<PhySubitem> subitemByComboId = mapper.getSubitemByComboId(comboId);
        return ResponseDTO.success(subitemByComboId);
    }
}
