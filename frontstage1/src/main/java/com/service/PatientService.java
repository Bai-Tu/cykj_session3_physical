package com.service;

import com.pojo.PhyPatient;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.RegisterVo;

/**
 * @author 李璟瑜
 * @date 2024/8/16 14:55
 * @description:
 */
public interface PatientService {
    ResponseDTO patientLogin(LoginVo vo);
    ResponseDTO registerPatient(RegisterVo vo);
}
