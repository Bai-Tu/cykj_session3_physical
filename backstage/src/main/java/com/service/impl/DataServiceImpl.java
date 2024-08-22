package com.service.impl;

import com.mapper.PhyPatientMapper;
import com.service.DataService;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/22 11:02
 * @description:
 */
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    PhyPatientMapper patientMapper;

    @Override
    public ResponseDTO getAgeData() {
        List ageData = new ArrayList<>();
        for (int i = 0 ;i<=4;i++){
            HashMap<String,Object> ageDataItem = new HashMap<>();
            int minAge = 0+i*20;
            int maxAge = 19+i*20;
            int data = patientMapper.countPatientInAge(minAge, maxAge);
            String name = minAge+"-"+maxAge;
            ageDataItem.put("name",name);
            ageDataItem.put("value",data);
            ageData.add(ageDataItem);
        }
        HashMap<String,Object> ageDataItem = new HashMap<>();
        int data = patientMapper.countPatientInAge(100, 999);
        ageDataItem.put("name","100+");
        ageDataItem.put("value",data);
        ageData.add(ageDataItem);

        return ResponseDTO.success(ageData);
    }

    @Override
    public ResponseDTO getSaleData() {
        HashMap<String,Object> sale = new HashMap<>();
        List saleList = new ArrayList<>();
        List saleTitle = new ArrayList<>();
        for (int i = 0;i<3;i++){
            int month = 7+i;
            String mon = "2024-0"+month;
            BigDecimal saleInTime = patientMapper.getSaleInTime(mon);
            if (saleInTime == null){
                saleInTime =BigDecimal.valueOf(0.00);
            }
            saleList.add(saleInTime);
            saleTitle.add(mon);

        }
        sale.put("saleList",saleList);
        sale.put("saleTitle",saleTitle);

        return ResponseDTO.success(sale);

    }
}
