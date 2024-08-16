package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyRoleMapper;
import com.pojo.PhyRole;
import com.service.RoleService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 14:06
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    PhyRoleMapper mapper;
    @Override
    public ResponseDTO getAllRole(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyRole> allRole = mapper.getAllRole();
        PageInfo<PhyRole> pageInfo = new PageInfo<>(allRole);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO addRole(PhyRole vo) {
        int i = mapper.insertSelective(vo);
        return ResponseDTO.success(i);
    }
}
