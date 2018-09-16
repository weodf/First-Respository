package com.dayuan.provider.impl.mapper;



import com.dayuan.provider.impl.entity.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;




public interface MovieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);


    Movie selectByPrimaryKey(Integer id);


    List<Movie> selectlistmovies();


}