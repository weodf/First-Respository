package com.dayuan.provider.impl.mapper;

import com.dayuan.provider.impl.entity.ShowTime;

import java.util.List;

public interface ShowTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShowTime record);


    ShowTime selectByPrimaryKey(Integer id);

    List<ShowTime> listShowTimeByDayId(Integer showDayId);

    ShowTime selectMovieBySTID(Integer id);

}