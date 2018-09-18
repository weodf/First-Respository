package com.dayuan.service;

import com.dayuan.entity.ShowDay;

import java.util.List;

public interface ShowDayService {


    List listShowday(Integer movieId);

    ShowDay selectShowDay(int dayId);
}
