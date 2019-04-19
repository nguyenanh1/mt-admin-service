package com.anhnguyen.mtadminservice.controller.webcms;

import com.anhnguyen.mtadminservice.controller.BaseController;
import com.anhnguyen.mtadminservice.domain.mysql.MovietimeEntity;
import com.anhnguyen.mtadminservice.domain.request.BodyMovieTime;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.impl.MovieTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/movietime")
public class MovieTimeController extends BaseController {
    @Autowired
    private MovieTimeService mService;

    @PostMapping("/add")
    public Result add(@RequestBody BodyMovieTime bodyMovieTime){
        Result result = mService.addMovieTime(bodyMovieTime);
        return result;
    }
}
