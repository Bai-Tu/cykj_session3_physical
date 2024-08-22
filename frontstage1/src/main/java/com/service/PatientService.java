package com.service;

import com.pojo.PhyOrder;
import com.pojo.PhyPatient;
import com.pojo.PhyStatementLog;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;
import com.vo.RegisterVo;

/**
 * @author 李璟瑜
 * @date 2024/8/16 14:55
 * @description:
 */
public interface PatientService {
    ResponseDTO patientLogin(LoginVo vo);
    ResponseDTO registerPatient(RegisterVo vo);
    ResponseDTO updatePatient(PhyPatient patient);
    ResponseDTO getOrderListByIdInPage(PageVo vo);
    ResponseDTO checkOutOrder(PhyOrder vo);
    ResponseDTO getOrderIndex(PhyOrder vo);
    ResponseDTO getOrderConclution(PhyOrder vo);
    ResponseDTO addBudget(PhyPatient vo);
    ResponseDTO getNewInfo(PhyPatient vo);
    ResponseDTO addlog(PhyStatementLog log);
}
