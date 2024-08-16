package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyPatientMapper;
import com.pojo.PhyPatient;
import com.service.PatientService;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;
import com.vo.RegisterVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 9:20
 * @description:
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PhyPatientMapper mapper;
    @Override
    public ResponseDTO registerPatient(RegisterVo vo) {
        int result = 0;
        if (vo.getAcc().length() == 11){
            PhyPatient patient = mapper.searchPatientByPhone(vo.getAcc());
            if (patient == null){
                result = mapper.registerByPhone(vo);
                if (result >= 0){
                    return ResponseDTO.success();
                }else {
                    return new ResponseDTO(-100,"注册失败",null);
                }
            }else {
                return new ResponseDTO(-1,"账号已存在",null);
            }
        }else {
            PhyPatient patient = mapper.searchPatientByIdentity(vo.getAcc());
            if (patient == null){
                result = mapper.registerByIdentity(vo);
                if (result >= 0){
                    return ResponseDTO.success();
                }else {
                    return new ResponseDTO(-100,"注册失败",null);
                }
            }else {
                return new ResponseDTO(-1,"账号已存在",null);
            }
        }
    }

    @Override
    public ResponseDTO loginPatient(LoginVo vo) {
        List<PhyPatient> phyPatients = mapper.selectAllByPatientIdentityOrPatientPhoneAndPatientPassword(vo.getAcc(), vo.getAcc(), vo.getPwd());
        if (phyPatients.size()!=0){
            return ResponseDTO.success(phyPatients.get(0));
        }else {
            return ResponseDTO.fail();
        }
    }

    @Override
    public ResponseDTO getAllPatientByPage(PageVo vo) {
        PageHelper.startPage(vo.getPagen(),vo.getLimit());
        List<PhyPatient> phyPatients = mapper.selectAllPatient();
        PageInfo<PhyPatient> pageInfo = new PageInfo<>(phyPatients);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO editPatient(PhyPatient vo) {
        int i = mapper.updateByPrimaryKeySelective(vo);
        return ResponseDTO.success(i);
    }

    @Override
    @Transactional
    public ResponseDTO addPatient(PhyPatient vo) {
        vo.setPatientPassword("e10adc3949ba59abbe56e057f20f883e");
        PhyPatient patient = mapper.searchPatientByIdentity(vo.getPatientIdentity());
        if (patient != null){
            return new ResponseDTO(-2,null,null);
        }

        PhyPatient patient1 = mapper.searchPatientByPhone(vo.getPatientPhone());
        if (patient1 != null){
            return new ResponseDTO(-2,null,null);
        }
        int i = mapper.insertSelective(vo);
        return ResponseDTO.success(i);
    }

    @Override
    public ResponseDTO addBudget(PhyPatient vo) {
        Integer i = mapper.addBudget(vo);
        return ResponseDTO.success(i);
    }

    @Override
    public ResponseDTO searchPatient(SearchPageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyPatient> phyPatients = mapper.searchPatient(vo);
        PageInfo<PhyPatient> pageInfo = new PageInfo<>(phyPatients);
        return ResponseDTO.success(pageInfo);
    }
}
