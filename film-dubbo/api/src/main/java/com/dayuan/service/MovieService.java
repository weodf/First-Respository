package com.dayuan.service;

import com.dayuan.entity.Movie;

import java.util.List;

public interface MovieService {

    List listMovies();
    Movie selectByPrimaryKey(int id);
    Movie selectByShowTimeId(Integer showTimeId);
}
