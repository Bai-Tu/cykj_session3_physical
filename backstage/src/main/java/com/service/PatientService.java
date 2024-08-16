package com.service;

import com.pojo.PhyPatient;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;
import com.vo.RegisterVo;
import com.vo.SearchPageVo;

/**
 * @author 李璟瑜
 * @date 2024/8/8 9:20
 * @description:
 */
public interface PatientService {
    ResponseDTO registerPatient (RegisterVo vo);
    ResponseDTO loginPatient(LoginVo vo);
    ResponseDTO getAllPatientByPage(PageVo vo);
    ResponseDTO editPatient(PhyPatient vo);
    ResponseDTO addPatient(PhyPatient vo);
    ResponseDTO addBudget(PhyPatient vo);
    ResponseDTO searchPatient(SearchPageVo vo);
}
