package com.dayuan.provider.impl.mapper;

import com.dayuan.provider.impl.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);


    List<String> unavaliableSeat(Integer showTimeId);


    void insertOrder(Order order);

    void updateStatus(@Param("tradeNo") String tradeNo,
                      @Param("orderNo") String orderNo);


    List<Integer> listCancelOrders();

    Order selectByPrimaryKeyForLock(Integer id);


    void updateStatusById(Integer id);

    int countBySeat(@Param("seat") String seat,
                    @Param("showTimeId") Integer showTimeId);

}