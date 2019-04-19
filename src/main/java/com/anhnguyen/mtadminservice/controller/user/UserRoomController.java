package com.anhnguyen.mtadminservice.controller.user;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.controller.BaseController;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.impl.RoomService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/room")
public class UserRoomController extends BaseController {
    @Autowired
    private RoomService mRoomService;
    @GetMapping("/get")
    public Result getInfoRoom(@RequestHeader("token")String token,
                              @RequestParam Integer idRoom){
        logger.info("[Room User Get] Get Room Controller by idRoom {}",idRoom);
        if(token!=null && idRoom !=null){
            Integer id = checkToken(token);
            if(id!=null){
                Result result = mRoomService.getRoomById(id,token,idRoom);
                return result;
            }else {
                return Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            return Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
    }
}
