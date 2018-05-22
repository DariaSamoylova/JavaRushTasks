package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_ma on 15.03.2018.
 */
public class Model {
    private View view;
    private  Provider[] providers;

    public Model(View view, Provider... providers) {
        if (view==null||providers==null||providers.length<1)
            throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city){
        List<Vacancy> list = new ArrayList<>();
        for(Provider p:providers){
            list.addAll(p.getJavaVacancies(city));
        }
        view.update(list);
    }
}
/*4. Создай публичный метод void selectCity(String city).

5. Реализуй логику метода selectCity:
5.1. получить вакансии с каждого провайдера,
5.2. обновить вью списком вакансий из п.5.1.*/