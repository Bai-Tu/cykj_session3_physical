package com.mapper;

import com.pojo.*;
import com.vo.RegisterVo;
import com.vo.SearchPageVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/13 11:26
 * @description:
 */
public interface PatPatientMapper {
    int deleteByPrimaryKey(Integer patientId);

    int insert(PhyPatient record);

    int insertSelective(PhyPatient record);

    PhyPatient selectByPrimaryKey(Integer patientId);

    int updateByPrimaryKeySelective(PhyPatient record);

    int updateByPrimaryKey(PhyPatient record);

    List<PhyPatient> selectAllByPatientIdentityOrPatientPhoneAndPatientPassword(@Param("patientIdentity") String patientIdentity, @Param("patientPhone") String patientPhone, @Param("patientPassword") String patientPassword);

    List<PhyPatient> selectAllPatient();

    //通过电话查询病人
    PhyPatient searchPatientByPhone(String phone);

    //根据身份证查询病人
    PhyPatient searchPatientByIdentity(String identity);

    //通过电话注册
    int registerByPhone(RegisterVo vo);

    //通过身份证注册
    int registerByIdentity(RegisterVo vo);

    Integer addBudget(PhyPatient vo);
    List<PhyPatient> searchPatient(SearchPageVo vo);
    int checkOutOrder(@Param("id") int id, @Param("price")BigDecimal price);

    int myInsertPatient(PhyPatient patient);

    List<PhyOrder> getOrderListByIdInPage(int id);

    PhyPatient selectPatientByPrimaryKey(Integer patientId);

    int updateOrderByPrimaryKeySelective(PhyOrder vo);
    List<PhyOrderContext> getContextListByOrderNumber(String number);
    List<PhyProject> getProjectByComboId(int comboId);
    List<PhySubitem> selectAllByProjectId(int id);

    int insertSubSelective(PhySubitemConclution record);
    PhyProject selectProByPrimaryKey(Integer projectId);
    int insertOrderSelective(PhyConclution record);

    List<SubitemConclutionAndSubitem> getOrderNumber(String number);

    PhyConclution getOrderConclution(String number);

    int addLogs(PhyStatementLog logs);
}