package com.dayuan.api;

import java.util.Map;

public interface OrderService {

    Map<String,Object> selectPlaceAndDate(Integer id);
}
