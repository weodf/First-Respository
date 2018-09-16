package com.dayuan.provider.impl;

import com.dayuan.api.OrderService;
import com.dayuan.provider.impl.mapper.OrderMapper;
import com.dayuan.provider.impl.mapper.ShowDayMapper;

import javax.annotation.Resource;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ShowDayMapper showDayMapper;

    public Map<String,Object> selectPlaceAndDate(Integer showTimeId){
        return showDayMapper.selectPlaceAndDate(showTimeId);

    }
}
