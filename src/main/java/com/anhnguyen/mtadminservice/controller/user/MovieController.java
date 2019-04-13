package com.anhnguyen.mtadminservice.controller.user;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.controller.BaseController;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.impl.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/movie")
public class MovieController extends BaseController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/getTop")
    private Result getAll() {
        logger.info("[MovieController] Get Top Movie Controller");
        Result result = movieService.getMovieTop();
        logger.info("[MovieController] Get Top Movie result: " + result);
        if (result != null) {
            return result;
        }
        return Result.fail(ErrorType.SYSTEM_ERROR);
    }

    @GetMapping("/getIsShowing")
    private Result getIsShowing(@RequestParam("partdate") int partDate,
                                @RequestParam("start") int start,
                                @RequestParam("limit") int limit) {
        logger.info("[MovieController] Get Is Showing Movie Controller");
        Result result = movieService.getMovieIsShowing(partDate, start, limit);
        logger.info("[MovieController] Get Is Showing Movie result: " + result);
        if (result != null) {
            return result;
        }
        return Result.fail(ErrorType.SYSTEM_ERROR);
    }

    @GetMapping("/getCommingSoon")
    private Result getCommingSoon(@RequestParam("partdate") int partDate,
                                  @RequestParam("start") int start,
                                  @RequestParam("limit") int limit) {
        logger.info("[MovieController] Get Comming Soon Movie Controller");
        Result result = movieService.getMovieCommingSoon(partDate, start, limit);
        logger.info("[MovieController] Get Comming Soon Movie result: " + result);
        if (result != null) {
            return result;
        }
        return Result.fail(ErrorType.SYSTEM_ERROR);
    }

    @GetMapping("/getDetail")
    private Result getDetail(@RequestParam("id") int idMovie){
        logger.info("[MovieController] Get Movie Detail Controller");
        Result result = movieService.getMovieById(idMovie);
        logger.info("[MovieController] Get Movie Detail result: " + result);
        if (result != null) {
            return result;
        }
        return Result.fail(ErrorType.SYSTEM_ERROR);
    }

}
