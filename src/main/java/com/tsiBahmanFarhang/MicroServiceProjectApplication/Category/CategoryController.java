package com.tsiBahmanFarhang.MicroServiceProjectApplication.Category;


import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * the @RequestMapping is important as it is used to map HTTP requests to handler methods of MVC and REST controller, and I
 * named it "api/v1 which I will use in postman"
 * */

@RestController
@RequestMapping("api/v1/category") //parent url
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/allCategory") //child url
    public Iterable<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PostMapping(value = "/addCategory")
    public List<Category> addCategory(@RequestBody List<Category> category){
        return categoryService.addCategory(category);
    }

    @DeleteMapping(value = "/deleteCategory{id}")
    public void deleteByCategoryId(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
    }

    @PutMapping(value = "/updateCategory/{id}")
    public Category updateCategory(@RequestBody Category category,@PathVariable("id") Long id){
        return categoryService.updateCategory(id,category);
    }


}
