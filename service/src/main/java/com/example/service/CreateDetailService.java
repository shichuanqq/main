package com.example.service;

import com.example.domain.domain.InventoryDetailDTO;

import java.util.List;

public interface CreateDetailService {
    List<InventoryDetailDTO> queryDetail();

    List<InventoryDetailDTO> queryDetail1();

    String logDebug();
}
