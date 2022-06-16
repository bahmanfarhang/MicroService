package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmController;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmService;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private FilmRepository filmRepository;

    @InjectMocks
    private FilmController filmController;

    @Test
    public void getAllActors_success() throws Exception{
        //creating a list of books because my book is a list
        List<Film> records = new ArrayList<>(Arrays.asList());
    }
}
