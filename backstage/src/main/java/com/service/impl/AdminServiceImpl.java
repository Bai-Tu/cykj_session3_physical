package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyAdminMapper;
import com.mapper.PhyMenuMapper;
import com.pojo.PhyAdmin;
import com.pojo.PhyDepartment;
import com.pojo.PhyMenu;
import com.pojo.PhyRole;
import com.service.AdminService;
import com.util.JwtUtil;
import com.util.ListInTree;
import com.util.Md5;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/7 15:14
 * @description:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    PhyAdminMapper mapper;
    @Autowired
    PhyMenuMapper menuMapper;

    @Override
    public ResponseDTO getAdminOtherInfo(int roleId) {
        HashMap<String,Object> data = new HashMap<>();
        List<PhyRole> allRole = mapper.getAllRole();
        data.put("roleList",allRole);
        List<PhyDepartment> allDepartment = mapper.getAllDepartment();
        data.put("departmentList",allDepartment);
        List<PhyMenu> phyMenus = menuMapper.searchMenuByRole(roleId);
        ArrayList<PhyMenu> phyMenusInTree = ListInTree.turnToTree(phyMenus);
        data.put("menuList",phyMenusInTree);
        return ResponseDTO.success(data);
    }

    @Override
    public ResponseDTO adminLogin(LoginVo vo) {
        String encrypted = Md5.getEncrypted(vo.getPwd());
        PhyAdmin phyAdmin = mapper.loginAdmin(vo.getAcc(), encrypted);
        if (phyAdmin != null){
            if (phyAdmin.getAdminStatus() == 1){
                HashMap<String,Object> data = new HashMap<>();

                data.put("adminInfo",phyAdmin);
                String token = JwtUtil.generateToken(data);
                return ResponseDTO.success(token);
            }else {
                return new ResponseDTO(-101,"账户冻结",null);
            }

        }
        return ResponseDTO.fail();
    }

    @Override
    public ResponseDTO getAllAdmin(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyAdmin> phyAdmins = mapper.selectAll();
        PageInfo<PhyAdmin> pageInfo = new PageInfo<>(phyAdmins);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO resetPwd(PhyAdmin admin) {
        admin.setAdminPassword("e10adc3949ba59abbe56e057f20f883e");
        int i = mapper.updateByPrimaryKeySelective(admin);
        if (i>0){
            return ResponseDTO.success();
        }else {
            return ResponseDTO.fail();
        }
    }
    @Override
    public ResponseDTO addAdmin(PhyAdmin admin) {
        List<PhyAdmin> phyAdmins = mapper.selectAllByAdminAccount(admin.getAdminAccount());
        if (phyAdmins.size() != 0){
            return new ResponseDTO(-2,"已存在",null);
        }

        admin.setAdminPassword("e10adc3949ba59abbe56e057f20f883e");
        int i = mapper.insertSelective(admin);
        if (i>0){
            return ResponseDTO.success();
        }
        return ResponseDTO.fail();
    }

    @Override
    public ResponseDTO editAdmin(PhyAdmin admin) {
        int i = mapper.updateByPrimaryKeySelective(admin);
        if (i>0){
            return ResponseDTO.success();
        }else {
            return ResponseDTO.fail();
        }

    }
}
