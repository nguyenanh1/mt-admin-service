package com.anhnguyen.mtadminservice.service.impl;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.domain.mysql.RoomEntity;
import com.anhnguyen.mtadminservice.domain.mysql.ZoomDetailEntity;
import com.anhnguyen.mtadminservice.domain.repo.ZoomDetailRepo;
import com.anhnguyen.mtadminservice.domain.repo.ZoomRepo;
import com.anhnguyen.mtadminservice.domain.request.BodyAddRoom;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService extends BaseService {
    @Autowired
    private ZoomRepo mRoomRepo;
    @Autowired
    private ZoomDetailRepo mRoomDetailRepo;
    @Autowired
    private UserService mUserService;

    public Result add(BodyAddRoom bodyAddRoom){
        RoomEntity mRoomEntity = new RoomEntity();
        mRoomEntity.setNameRoom(bodyAddRoom.getName());
        mRoomEntity.setNumCol(bodyAddRoom.getCol());
        mRoomEntity.setNumRow(bodyAddRoom.getRow());
        mRoomEntity.setCreateBy(1);
        mRoomEntity.setUpdateBy(1);
        Timestamp current = currrentTime();
        mRoomEntity.setTimeCreate(current);
        mRoomEntity.setTimeUpdate(current);
        mRoomRepo.save(mRoomEntity);
        int index =1;
        List<ZoomDetailEntity> list = new ArrayList<>();
        for(int i=1; i<=bodyAddRoom.getRow();i++){
            for(int j=1;j<=bodyAddRoom.getCol();j++){
                ZoomDetailEntity zoomDetailEntity = new ZoomDetailEntity();
                zoomDetailEntity.setRow(i);
                zoomDetailEntity.setCol(j);
                zoomDetailEntity.setPostion(index);
                zoomDetailEntity.setType(1);
                zoomDetailEntity.setRoom(mRoomEntity.getIdRoom());
                index++;
                list.add(zoomDetailEntity);
            }
        }
        mRoomDetailRepo.saveAll(list);
        return Result.success();
    }

    public Result getRoomById(Integer id, String token, Integer idRoom){
        ErrorType errorType = mUserService.checkToken(id,token);
        if(errorType==null){
            Optional<RoomEntity> optional = mRoomRepo.findById(idRoom);
            if(optional.isPresent()){
                return Result.success(optional.get());
            }else {
                return Result.fail(ErrorType.OBJECT_EMPTY);
            }
        }else {
            return Result.fail(errorType);
        }
    }

}
