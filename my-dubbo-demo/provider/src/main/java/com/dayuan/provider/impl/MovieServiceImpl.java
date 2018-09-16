package com.dayuan.provider.impl;


import com.dayuan.api.MovieService;
import com.dayuan.provider.impl.entity.Movie;
import com.dayuan.provider.impl.entity.ShowDay;
import com.dayuan.provider.impl.entity.ShowTime;
import com.dayuan.provider.impl.mapper.MovieMapper;
import com.dayuan.provider.impl.mapper.OrderMapper;
import com.dayuan.provider.impl.mapper.ShowDayMapper;
import com.dayuan.provider.impl.mapper.ShowTimeMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService {


    @Resource
    private MovieMapper movieMapper;
    @Resource
    private ShowTimeMapper showTimeMapper;
    @Resource
    private ShowDayMapper showDayMapper;
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Object info(Integer id) {
        return (Movie) movieMapper.selectByPrimaryKey(id);
    }

    @Override
    public List listShowDays(Integer id) {
        return (showDayMapper.listShowDays(id));
    }

    @Override
    public List listShowTime(Integer id) {
        List<List<ShowTime>> showtime=new ArrayList<>();
        List<ShowDay> showDays=showDayMapper.listShowDays(id);

        for (ShowDay showDay:showDays) {
            List<ShowTime> showTimes = showTimeMapper.listShowTimeByDayId(showDay.getId());
            showtime.add(showTimes);
        }
        return showtime;
    }

    @Override
    public Movie selectMovieBySTID(Integer showTimeId) {
        ShowTime showTime = showTimeMapper.selectMovieBySTID(showTimeId);
        Integer showDayId = showTime.getShowDayId();
        System.out.println(showDayId);
        ShowDay showDay = showDayMapper.selectMovieIdByShowDId(showDayId);
        Integer movieId = showDay.getMovieId();
        return movieMapper.selectByPrimaryKey(movieId);
    }

    @Override
    public List unavaliableSeat(Integer showTimeId) {
        return orderMapper.unavaliableSeat(showTimeId);
    }

    @Override
    public List listmovies() {
        return movieMapper.selectlistmovies();

    }
}
