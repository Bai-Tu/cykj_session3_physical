package com.service;

import com.pojo.PhyMenu;
import com.pojo.PhyRole;
import com.util.ResponseDTO;
import com.vo.PageVo;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 14:06
 * @description:
 */
public interface RoleService {
    ResponseDTO getAllRole(PageVo vo);
    ResponseDTO addRole(PhyRole vo);
}
