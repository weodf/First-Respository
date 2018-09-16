package com.dayuan.provider.impl.mapper;

import com.dayuan.provider.impl.entity.ShowDay;

import java.util.List;
import java.util.Map;

public interface ShowDayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShowDay record);

    ShowDay selectByPrimaryKey(Integer id);

    ShowDay selectMovieIdByShowDId(Integer showTimeId);

    List<ShowDay> listShowDays(Integer movieId);

    Map<String,Object> selectPlaceAndDate(Integer id);

}