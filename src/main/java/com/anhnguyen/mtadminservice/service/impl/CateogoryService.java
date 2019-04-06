package com.anhnguyen.mtadminservice.service.impl;

import com.anhnguyen.mtadminservice.domain.mysql.CategoryEntity;
import com.anhnguyen.mtadminservice.domain.repo.CategoryRepo;
import com.anhnguyen.mtadminservice.domain.request.CateogryRequest;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.BaseService;
import com.anhnguyen.mtadminservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateogoryService extends BaseService implements ICategoryService {
    @Autowired
    private CategoryRepo mCateRepo;

    public Result addCategory(CateogryRequest cateogryRequest){
        CategoryEntity entity = new CategoryEntity();
        entity.setName(cateogryRequest.getName());
        return null;
    }

    @Override
    public int add(CategoryEntity categoryEntity) {
        try{
            mCateRepo.save(categoryEntity);
            return  1;
        }catch (Exception e){
            logger.error("[Category Serivce] Error {}",e);
            return  0;
        }
    }

    @Override
    public List<CategoryEntity> getListCategory(int start, int limit) {
        return null;
    }
}
