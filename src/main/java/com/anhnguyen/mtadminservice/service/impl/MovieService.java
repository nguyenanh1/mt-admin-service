package com.anhnguyen.mtadminservice.service.impl;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.domain.mysql.CategoryEntity;
import com.anhnguyen.mtadminservice.domain.mysql.MovieEntity;
import com.anhnguyen.mtadminservice.domain.mysql.MoviecategoryEntity;
import com.anhnguyen.mtadminservice.domain.repo.CategoryRepo;
import com.anhnguyen.mtadminservice.domain.repo.MovieCategoryRepo;
import com.anhnguyen.mtadminservice.domain.repo.MovieRepo;
import com.anhnguyen.mtadminservice.domain.response.MovieResponse;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService extends BaseService {
    @Autowired
    private CategoryRepo mCateRepo;
    @Autowired
    private MovieRepo mMovieRepo;
    @Autowired
    private MovieCategoryRepo mMoviCateRepo;

//    public Result getListMovie(){
//        List<MovieEntity> mList = mMovieRepo.findAll();
//        List<MovieResponse> mData = new ArrayList<>();
//        if(mList!=null){
//            for(MovieEntity temp: mList){
//                MovieResponse response = new MovieResponse();
//                response.setMovie(temp);
//                List<MoviecategoryEntity> mMoviceCates = mMoviCateRepo.findAllByIdMovie(temp.getId());
//                if(mMoviceCates!=null){
//                    List<CategoryEntity> mListCate = new ArrayList<>();
//                    for(MoviecategoryEntity temp1:mMoviceCates){
//                        Optional<CategoryEntity> optional = mCateRepo.findById(temp1.getIdCategory());
//                        if(optional.isPresent()){
//                            mListCate.add(optional.get());
//                        }
//                    }
//                    response.setCategorys(mListCate);
//                }
//                mData.add(response);
//            }
//            return Result.success(mData);
//        }
//        return Result.fail();
//    }

    public Result getMovieTop() {
        List<MovieEntity> mList = mMovieRepo.getTopView();
        List<MovieResponse> mDataResult = getListMovieResposne(mList);
        if(mDataResult!=null){
            return Result.success(mDataResult);
        }
        return Result.fail(ErrorType.LIST_EMPTY);
    }

    public Result getMovieIsShowing(int partDate, int start, int limit) {
        List<MovieEntity> mList = mMovieRepo.getListMovieIsShowing(partDate,start,limit);
        List<MovieResponse> mDataResult = getListMovieResposne(mList);
        if(mDataResult!=null){
            return Result.success(mDataResult);
        }
        return Result.fail(ErrorType.LIST_EMPTY);
    }

    public Result getMovieCommingSoon(int partDate, int start,int limit){
        List<MovieEntity> mList = mMovieRepo.getListMovieCommingSoon(partDate,start,limit);
        List<MovieResponse> mDataResult = getListMovieResposne(mList);
        if(mDataResult!=null){
            return Result.success(mDataResult);
        }
        return Result.fail(ErrorType.LIST_EMPTY);
    }

    public Result getMovieById(int id){
        Optional<MovieEntity> oEntity = mMovieRepo.findById(id);
        if(oEntity.isPresent()){
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setMovie(oEntity.get());
            List<MoviecategoryEntity> mMovieCate = mMoviCateRepo.findAllByIdMovie(oEntity.get().getId());
            if(mMovieCate!=null){
                List<CategoryEntity> mListCate = new ArrayList<>();
                for (MoviecategoryEntity temp : mMovieCate) {
                    Optional<CategoryEntity> optional = mCateRepo.findById(temp.getIdCategory());
                    if (optional.isPresent()) {
                        mListCate.add(optional.get());
                    }
                }
                movieResponse.setCategorys(mListCate);
                return Result.success(movieResponse);
            }
        }
        return null;
    }

    public List<MovieResponse> getListMovieResposne(List<MovieEntity> list){
        List<MovieResponse> mDataResult = new ArrayList<>();
        if (list != null) {
            for (MovieEntity temp : list) {
                MovieResponse response = new MovieResponse();
                response.setMovie(temp);
                List<MoviecategoryEntity> mMoviceCates = mMoviCateRepo.findAllByIdMovie(temp.getId());
                if (mMoviceCates != null) {
                    List<CategoryEntity> mListCate = new ArrayList<>();
                    for (MoviecategoryEntity temp1 : mMoviceCates) {
                        Optional<CategoryEntity> optional = mCateRepo.findById(temp1.getIdCategory());
                        if (optional.isPresent()) {
                            mListCate.add(optional.get());
                        }
                    }
                    response.setCategorys(mListCate);
                }
                mDataResult.add(response);
            }
            return mDataResult;
        }
        return null;
    }
}
