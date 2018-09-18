package com.dayuan.service;

import com.dayuan.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {

    List selectShowTimes(Integer showDayId);
    ShowTime selectShowTime(int id);
}
