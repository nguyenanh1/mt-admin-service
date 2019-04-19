package com.anhnguyen.mtadminservice.controller.webcms;

import com.anhnguyen.mtadminservice.controller.BaseController;
import com.anhnguyen.mtadminservice.domain.request.BodyAddRoom;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/room")
public class RoomController extends BaseController {
    @Autowired
    private RoomService mRooomService;

    @PostMapping("/add")
    public Result adddRooom(@RequestBody BodyAddRoom bodyAddRoom){
        Result result = mRooomService.add(bodyAddRoom);
        return  result;
    }
}
