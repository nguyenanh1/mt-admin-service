package com.anhnguyen.mtadminservice.service;

import com.anhnguyen.mtadminservice.domain.mysql.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    int add(CategoryEntity categoryEntity);
    List<CategoryEntity> getListCategory(int start,int limit);
}
