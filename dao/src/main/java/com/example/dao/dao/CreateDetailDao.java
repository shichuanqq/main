package com.example.dao.dao;

import com.example.domain.domain.InventoryDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface CreateDetailDao extends BaseMapper<InventoryDetailDTO> {

    List<InventoryDetailDTO> queryDetail();

}
