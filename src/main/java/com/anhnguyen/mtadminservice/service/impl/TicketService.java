package com.anhnguyen.mtadminservice.service.impl;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.domain.mysql.*;
import com.anhnguyen.mtadminservice.domain.repo.*;
import com.anhnguyen.mtadminservice.domain.request.BodyListTicket;
import com.anhnguyen.mtadminservice.domain.request.BodyUnHoldTicket;
import com.anhnguyen.mtadminservice.domain.response.ResponseTicket;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.domain.response.TicketResponse;
import com.anhnguyen.mtadminservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService extends BaseService {
    @Autowired
    private TicketRepo mTicketRepo;
    @Autowired
    private ZoomDetailRepo mRoomDetailRepo;
    @Autowired
    private TransactionRepo mTranRepo;
    @Autowired
    private DetailTransactionRepo mDetailTranRepo;
    @Autowired
    private UserService mUserService;

    public Result getTicket(Integer id, String token, Integer idMovieTime) {
        ErrorType errorType = mUserService.checkToken(id, token);
        if (errorType == null) {
            List<TicketEntity> mListTicket = mTicketRepo.getListTicket(idMovieTime);
            List<TicketResponse> mListRes = new ArrayList<>();
            List<DetailTransactionEntity> mDTrans = new ArrayList<>();
            if (mListTicket != null) {
                for (TicketEntity temp : mListTicket) {
                    TicketResponse response = new TicketResponse();
                    response.setTicket(temp);
                    Optional<ZoomDetailEntity> mZoomDetail = mRoomDetailRepo.findById(temp.getIdZoomDetail());
                    if (mZoomDetail.isPresent()) {
                        response.setPosition(mZoomDetail.get());
                    } else {
                        response.setPosition(new ZoomDetailEntity());
                    }
                    mListRes.add(response);
                }
                return Result.success(mListRes);
            }
        } else {
            return Result.fail(errorType);
        }
        return null;
    }

    public Result holderTicket(Integer id, String token, BodyListTicket bodyListTicket) {
        ErrorType errorType = mUserService.checkToken(id, token);
        if (errorType == null) {
            List<Integer> list = bodyListTicket.getMListId();
            List<TicketEntity> mListTicket = new ArrayList<>();
            TransactionEntity tranEntity = new TransactionEntity();
            List<DetailTransactionEntity> listTran = new ArrayList<>();
            tranEntity.setIdUser(id);
            tranEntity.setType(1);
            tranEntity.setStatus(1);
            tranEntity.setTime(currrentTime());
            mTranRepo.save(tranEntity);
            for (Integer idTicket : list) {
                Optional<TicketEntity> optional = mTicketRepo.findById(idTicket);
                if (optional.isPresent()) {
                    TicketEntity entity = optional.get();
                    DetailTransactionEntity detailTran = new DetailTransactionEntity();
                    if (entity.getStatus() == 1) {
                        entity.setStatus(3);
                        mListTicket.add(entity);
                        detailTran.setIdTransaction(tranEntity.getId());
                        detailTran.setIdTicket(entity.getIdTicket());
                        listTran.add(detailTran);
                    } else {
                        break;
                    }

                }
            }
            if (mListTicket.size() == list.size()) {
                mTicketRepo.saveAll(mListTicket);
                mDetailTranRepo.saveAll(listTran);
                return Result.success(tranEntity);
            } else {
                mTranRepo.delete(tranEntity);
                return Result.fail(ErrorType.TICKET_IS_HOLDING);
            }

        } else {
            return Result.fail(errorType);
        }
    }

    public Result booking(Integer id, String token, BodyUnHoldTicket bodyUnHoldTicket) {
        ErrorType errorType = mUserService.checkToken(id, token);
        if (errorType == null) {
            Optional<TransactionEntity> tranEntity = mTranRepo.findById(bodyUnHoldTicket.getIdTrans());
            if(tranEntity.isPresent()){
                TransactionEntity transactionEntity = tranEntity.get();
                List<DetailTransactionEntity> detailTransactionEntityList = mDetailTranRepo.findAllByIdTransaction(transactionEntity.getId());
                List<TicketEntity> mListTicket = new ArrayList<>();
                int tong = 0;
                for (DetailTransactionEntity temp: detailTransactionEntityList){
                    Optional<TicketEntity> entity = mTicketRepo.findById(temp.getIdTicket());
                    if(entity.isPresent()){
                        TicketEntity ticket = entity.get();
                        ticket.setStatus(2);
                        tong = tong+ticket.getPrice();
                        mListTicket.add(ticket);
                    }
                }
                tranEntity.get().setType(2);
                UserEntity userEntity = mUserService.findByUserId(id);
                userEntity.setBalace(userEntity.getBalace()+tong);
                int point = tong/1000;
                userEntity.setPoint(userEntity.getPoint()+point);
                mTicketRepo.saveAll(mListTicket);
                mTranRepo.save(tranEntity.get());
                return Result.success();
            }else {
                return Result.fail(ErrorType.OBJECT_EMPTY);
            }

        } else {
            return Result.fail(errorType);
        }
    }

    public Result unHolderTicket(Integer id, String token, BodyUnHoldTicket bodyUnHoldTicket) {
        ErrorType errorType = mUserService.checkToken(id, token);
        if (errorType == null) {
            Optional<TransactionEntity> tranEntity = mTranRepo.findById(bodyUnHoldTicket.getIdTrans());
            if(tranEntity.isPresent()){
                TransactionEntity transactionEntity = tranEntity.get();
                List<DetailTransactionEntity> detailTransactionEntityList = mDetailTranRepo.findAllByIdTransaction(transactionEntity.getId());
                List<TicketEntity> mListTicket = new ArrayList<>();
                for (DetailTransactionEntity temp: detailTransactionEntityList){
                    Optional<TicketEntity> entity = mTicketRepo.findById(temp.getIdTicket());
                    if(entity.isPresent()){
                        TicketEntity ticket = entity.get();
                        ticket.setStatus(1);
                        mListTicket.add(ticket);
                    }
                }
                mTicketRepo.saveAll(mListTicket);
                mTranRepo.delete(transactionEntity);
                mDetailTranRepo.deleteAll(detailTransactionEntityList);
                return Result.success();
            }else {
                return Result.fail(ErrorType.OBJECT_EMPTY);
            }

        } else {
            return Result.fail(errorType);
        }
    }

    public Result getListTicket(Integer id, String token, Integer idTrans) {
        ErrorType errorType = mUserService.checkToken(id, token);
        if (errorType == null) {
            List<DetailTransactionEntity> list = mDetailTranRepo.findAllByIdTransaction(idTrans);
            List<ResponseTicket>  listResposeTicket = new ArrayList<>();
            for(DetailTransactionEntity temp : list){
                ResponseTicket responseTicket = new ResponseTicket();
                Optional<TicketEntity>  optionalTicket  = mTicketRepo.findById(temp.getIdTicket());
                if(optionalTicket.isPresent()){
                    responseTicket.setTicketEntity(optionalTicket.get());
                    Optional<ZoomDetailEntity> optionalZoomDetai = mRoomDetailRepo.findById(optionalTicket.get().getIdZoomDetail());
                    if(optionalZoomDetai.isPresent()){
                        responseTicket.setZoomDetailEntity(optionalZoomDetai.get());
                    }else {
                        responseTicket.setZoomDetailEntity(new ZoomDetailEntity());
                    }
                }else {
                    responseTicket.setTicketEntity(new TicketEntity());
                    responseTicket.setZoomDetailEntity(new ZoomDetailEntity());
                }
                listResposeTicket.add(responseTicket);
            }
            return Result.success(listResposeTicket);
        } else {
            return Result.fail(errorType);
        }
    }
}
