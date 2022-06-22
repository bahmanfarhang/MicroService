package com.tsiBahmanFarhang.MicroServiceProjectApplication.Category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public CategoryService(){
    }

    //methods
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public List<Category> addCategory(List<Category> category){
        return categoryRepository.saveAll(category);
    }
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
    public Category updateCategory(Long id, Category category){
        if(categoryRepository.existsById(id)){
            category.setCategory_id(id);
            return categoryRepository.save(category);
        }
        return null;
    }

}
