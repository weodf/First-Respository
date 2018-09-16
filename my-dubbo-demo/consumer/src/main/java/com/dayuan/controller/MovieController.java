package com.dayuan.controller;


import com.dayuan.api.MovieService;
import com.dayuan.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("api/movie")
public class MovieController {
    @Resource
    private MovieService movieService;


    @PostMapping("movies.do")
    @ResponseBody
    public AjaxResult listAllMovies(){
        return AjaxResult.success(movieService.listmovies());
    }


    @PostMapping("info.do")
    @ResponseBody
    public AjaxResult info(@RequestParam("id") Integer id){
        return AjaxResult.success(movieService.info(id));
    }

    @PostMapping("ticket.do")
    @ResponseBody
    public AjaxResult listShowDays(@RequestParam("id") Integer id){
        return AjaxResult.success(movieService.listShowDays(id));
    }


    @PostMapping("listShowTime.do")
    @ResponseBody
    public AjaxResult listShowTime(@RequestParam("id") Integer id){
        return AjaxResult.success(movieService.listShowTime(id));
    }


    @PostMapping("selectMovieBySTID.do")
    @ResponseBody
    public AjaxResult selectMovieBySTID(@RequestParam("showTimeId") Integer showTimeId){
        return AjaxResult.success(movieService.selectMovieBySTID(showTimeId));
    }

    @PostMapping("unavaliableSeat.do")
    @ResponseBody
    public AjaxResult unavaliableSeat(@RequestParam("showTimeId") Integer showTimeId){
        return AjaxResult.success(movieService.unavaliableSeat(showTimeId));
    }
}
