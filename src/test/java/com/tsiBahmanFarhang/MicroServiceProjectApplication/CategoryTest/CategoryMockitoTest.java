package com.tsiBahmanFarhang.MicroServiceProjectApplication.CategoryTest;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Category.Category;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Category.CategoryRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Category.CategoryService;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class CategoryMockitoTest {

    //im testing these methods from service
    @InjectMocks
    CategoryService categoryService;
    //make a mock object
    @MockBean
    CategoryRepository categoryRepository;
    @BeforeEach
    void setUp(){
        //,mock class has no functions
        categoryRepository = mock(CategoryRepository.class);
        ArgumentCaptor<Category> actorArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        categoryService = new CategoryService(categoryRepository);
    }
    @Test
    public void getAllCategoryTest(){
        //first created a mock object which is a film
        Category category = new Category(1L, "Horror");
        List<Category> categoryList = new ArrayList<Category>();
        categoryList.add(category);

        //whenever this function is called then we should filmList, it will NOT RUN IT, but
        //return it automatically
        when(categoryRepository.findAll()).thenReturn(categoryList);

        Iterable<Category> expected = categoryList;
        //as we have mocked the findAll function the service will return that only(mock data)
        Iterable<Category> actual = categoryService.getAllCategory();
        //
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void deleteCategoryTest(){
        //whenever filmService deleteById is called, then verify will ensure the filmRepo
        //the deleteById function is called 1 time only
        categoryService.deleteById(1L);
        //Allows verifying that certain behavior or action happened at least once
        //exact number of times or never. E.g:
        // verify(mock, times(5)).someMethod("was called five times");
        verify(categoryRepository,times(1)).deleteById(1L);
    }
    @Test
    public void addCategoryTest(){

        Category category = new Category(1L, "Fantasy");
        List<Category> categoryList = new ArrayList<Category>();
        categoryList.add(category);

        //whenever this function is called then wwe should filmList, it will NOT RUN IT, but
        //return it auto
        //im mocking saveAll and testing
        when(categoryRepository.saveAll(categoryList)).thenReturn(categoryList);

        Iterable<Category> expected = categoryList;
        //as we have mocked the findAll function the service will return that only(mock data)
        Iterable<Category> actual = categoryService.addCategory(categoryList);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void updateTestNoId(){
        when(categoryRepository.existsById(1L)).thenReturn(false);
        Category actual = categoryService.updateCategory(1L, new Category());
        Assertions.assertEquals(null, actual);
    }
    @Test
    public void updateTestId(){
        Category category = new Category(1L, "Romance");
        when(categoryRepository.existsById(1L)).thenReturn(true);
        when(categoryRepository.save(category)).thenReturn(category);
        Category actual = categoryService.updateCategory(1L, category);
        Assertions.assertEquals(category, actual);
    }
}
