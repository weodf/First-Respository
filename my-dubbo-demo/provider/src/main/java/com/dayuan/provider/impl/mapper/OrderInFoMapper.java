package com.dayuan.provider.impl.mapper;

import com.dayuan.provider.impl.entity.OrderInFo;

public interface OrderInFoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInFo record);


    OrderInFo selectByPrimaryKey(Integer id);

    void insertOderInfo(OrderInFo orderInfo);






}