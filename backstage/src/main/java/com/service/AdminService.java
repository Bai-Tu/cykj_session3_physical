package com.service;

import com.github.pagehelper.Page;
import com.pojo.PhyAdmin;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;

/**
 * @author 李璟瑜
 * @date 2024/8/7 15:13
 * @description:
 */
public interface AdminService {
    ResponseDTO adminLogin(LoginVo vo);
    ResponseDTO getAllAdmin(PageVo vo);
    ResponseDTO resetPwd(PhyAdmin admin);
    ResponseDTO addAdmin(PhyAdmin admin);
    ResponseDTO editAdmin(PhyAdmin admin);
    ResponseDTO getAdminOtherInfo(int roleId);
}
