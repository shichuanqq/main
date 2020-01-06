package com.example.service.impl;

import com.example.dao.dao.CreateDetailDao;
import com.example.domain.domain.InventoryDetailDTO;
import com.example.service.CreateDetailService;
import com.example.service.database.ReadOnlyAnnotation;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CreateDetailServiceImpl implements CreateDetailService {

    @Autowired
    private CreateDetailDao createDetailDao;

    @Override
    public List<InventoryDetailDTO> queryDetail() {
        PageHelper.startPage(2,5);
        return createDetailDao.queryDetail();
    }

    @ReadOnlyAnnotation
    @Override
    public List<InventoryDetailDTO> queryDetail1() {
        return createDetailDao.queryDetail();
    }


    @Override
    public String logDebug() {
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            log.info("logDebug is error :{} ", e.getMessage());
        }
        return "5";
    }
}
