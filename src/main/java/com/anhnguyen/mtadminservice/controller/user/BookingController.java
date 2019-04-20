package com.anhnguyen.mtadminservice.controller.user;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.controller.BaseController;
import com.anhnguyen.mtadminservice.domain.request.BodyListTicket;
import com.anhnguyen.mtadminservice.domain.request.BodyUnHoldTicket;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/ticket/")
public class BookingController extends BaseController {
    @Autowired
    private TicketService mService;

    @GetMapping("/get")
    public Result getTicket(@RequestHeader("token")String token,
                            @RequestParam Integer idMovieTime){
        logger.info("[Ticket User Get] Get ticket by idMovieTime {}",idMovieTime);
        if(token!=null && idMovieTime !=null){
            Integer id = checkToken(token);
            if(id!=null){
                Result result = mService.getTicket(id,token,idMovieTime);
                return result;
            }else {
                return Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            return Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
    }

    @PutMapping("/hold")
    public Result holder(@RequestHeader("token")String token,
                         @RequestBody BodyListTicket bodyListTicket){
        logger.info("[Ticket User Holder] Holder ticket by idTicket {}",bodyListTicket);
        if(token!=null && bodyListTicket.isVadilate()){
            Integer id = checkToken(token);
            if(id!=null){
                Result result = mService.holderTicket(id,token,bodyListTicket);
                return result;
            }else {
                return Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            return Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
    }

    @PutMapping("/unhold")
    public Result unHolder(@RequestHeader("token")String token,
                         @RequestBody BodyUnHoldTicket bodyUnHoldTicket){
        logger.info("[Ticket User Unholder] Unholder ticket by idTicket {}",bodyUnHoldTicket);
        if(token!=null && bodyUnHoldTicket.isVadilate()){
            Integer id = checkToken(token);
            if(id!=null){
                Result result = mService.unHolderTicket(id,token,bodyUnHoldTicket);
                return result;
            }else {
                return Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            return Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
    }

    @PutMapping("/booking")
    public Result booking(@RequestHeader("token")String token,
                           @RequestBody BodyUnHoldTicket bodyUnHoldTicket){
        logger.info("[Ticket User Booking] Booking ticket by idTrans {}",bodyUnHoldTicket);
        if(token!=null && bodyUnHoldTicket.isVadilate()){
            Integer id = checkToken(token);
            if(id!=null){
                Result result = mService.booking(id,token,bodyUnHoldTicket);
                return result;
            }else {
                return Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            return Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
    }

    @GetMapping("/getTicketBook")
    public Result getListTicket(@RequestHeader("token")String token,
                                @RequestParam Integer idTrans){
        logger.info("[Ticket User getListTicket] getListTicket ticket by idtran {}",idTrans);
        if(token!=null && idTrans!=null){
            Integer id = checkToken(token);
            if(id!=null){
                Result result = mService.getListTicket(id,token,idTrans);
                return result;
            }else {
                return Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            return Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
    }

    @GetMapping("/history-transaction")
    public Result getHistoryTransaction(@RequestHeader("token")String token){
        logger.info("[Ticket User get history transaction] get history transaction  by token {}",token);
        if(token!=null){
            Integer id = checkToken(token);
            if(id!=null){
                Result result = mService.getHistoryTransaction(id,token);
                return result;
            }else {
                return Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            return Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
    }

}
