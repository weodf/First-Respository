package com.dayuan.provider.impl;


import com.dayuan.entity.Movie;
import com.dayuan.mapper.MovieMapper;
import com.dayuan.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Resource
    MovieMapper movieMapper;

    @Override
    public List<Movie> listMovies() {
        return movieMapper.listMovies();
    }

    @Override
    public Movie selectByPrimaryKey(int id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    @Override
    public Movie selectByShowTimeId(Integer showTimeId) {
        return movieMapper.selectByShowTimeId(showTimeId);
    }

}
