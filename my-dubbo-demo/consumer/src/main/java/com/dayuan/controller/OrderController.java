package com.dayuan.controller;

import com.dayuan.api.OrderService;
import com.dayuan.util.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "api/order")
public class OrderController {

    @Resource
    private OrderService orderService;

        @RequestMapping(value = "/ticketinfo.do")
        @ResponseBody
        public AjaxResult selectPlaceAndDate(@RequestParam("showTimeId") Integer showTimeId){
            return AjaxResult.success(orderService.selectPlaceAndDate(showTimeId));
        }
}
