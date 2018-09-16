package com.dayuan.api;

import java.util.List;


public interface MovieService {

    List listmovies();

    Object info(Integer id);

    List listShowDays(Integer id);


    List listShowTime(Integer id);


    Object selectMovieBySTID(Integer showTimeId);


    List unavaliableSeat(Integer showTimeId);




}
