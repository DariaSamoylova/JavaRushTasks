package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * Created by mr_ma on 12.03.2018.
 */
public interface Strategy {
   List<Vacancy> getVacancies(String searchString);
}
