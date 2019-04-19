package com.anhnguyen.mtadminservice.service.impl;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.domain.mysql.MovietimeEntity;
import com.anhnguyen.mtadminservice.domain.mysql.TicketEntity;
import com.anhnguyen.mtadminservice.domain.mysql.ZoomDetailEntity;
import com.anhnguyen.mtadminservice.domain.repo.MovieTimeRepo;
import com.anhnguyen.mtadminservice.domain.repo.TicketRepo;
import com.anhnguyen.mtadminservice.domain.repo.ZoomDetailRepo;
import com.anhnguyen.mtadminservice.domain.request.BodyMovieTime;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieTimeService extends BaseService {
    @Autowired
    private MovieTimeRepo mMoviTimeRepo;
    @Autowired
    private TicketRepo mTicketRepo;
    @Autowired
    private ZoomDetailRepo mRoomDetailRepo;
    @Autowired
    private UserService mUserService;

    public Result addMovieTime(BodyMovieTime bodyMovieTime){
        MovietimeEntity entity = new MovietimeEntity();
        entity.setIdMovie(bodyMovieTime.getIdMovie());
        entity.setTimeStart(bodyMovieTime.getTime());
        entity.setDateStart(bodyMovieTime.getDate());
        entity.setPrice(bodyMovieTime.getPrice());
        entity.setIdRoom(bodyMovieTime.getIdRoom());
        Timestamp currrent = currrentTime();
        entity.setCreateBy(1);
        entity.setUpdateBy(1);
        entity.setTimeCreate(currrent);
        entity.setTimeUpdate(currrent);
        mMoviTimeRepo.save(entity);
        List<ZoomDetailEntity> mZoomDetail = mRoomDetailRepo.findAllByRoom(bodyMovieTime.getIdRoom());
        List<TicketEntity> mList = new ArrayList<>();
        for(ZoomDetailEntity temp: mZoomDetail){
            TicketEntity mTicket = new TicketEntity();
            mTicket.setIdMovietime(entity.getId());
            mTicket.setIdZoomDetail(temp.getId());
            mTicket.setStatus(1);
            if(temp.getType()==1){
                mTicket.setPrice(bodyMovieTime.getPrice());
            }else if(temp.getType()==2){
                mTicket.setPrice(bodyMovieTime.getPrice()*2);
            }else {
                mTicket.setPrice(bodyMovieTime.getPrice());
            }
            mTicket.setCreateBy(1);
            mTicket.setUpdateBy(1);
            mTicket.setTimeCreate(currrent);
            mTicket.setTimeUpdate(currrent);
            mList.add(mTicket);
        }
        mTicketRepo.saveAll(mList);
        return Result.success();
    }

    public Result getMovieTimeByIdAndDate(Integer id, String token, Integer idMovie, Integer date) {
        ErrorType errorType = mUserService.checkToken(id,token);
        if(errorType==null){
            Date time = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String timeS = format.format(time);
            int timeInt = 0;
            try {
                timeInt = Integer.parseInt(timeS);
            }catch (Exception e){
                logger.error("Exception {}",e);
            }
            int timeGet =0;
            if(timeInt==date){
                int hh = time.getHours();
                int mm = time.getMinutes();
                timeGet = hh*100+mm;
            }
            List<MovietimeEntity> mEntities = mMoviTimeRepo.getAllByIdAndDate(idMovie,date,timeGet);
            if(mEntities!=null){
                return Result.success(mEntities);
            }else {
                return Result.fail(ErrorType.LIST_EMPTY);
            }
        }else {
            return Result.fail(errorType);
        }
    }
}
