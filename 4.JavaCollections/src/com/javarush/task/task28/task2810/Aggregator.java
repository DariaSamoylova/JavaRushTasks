package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_ma on 12.03.2018.
 */
public class Aggregator {
    public static  void  main(String[] args){
        /*HtmlView view = new HtmlView();
        Model model=new Model(view,new Provider(new MoikrugStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();*/
        HtmlView view = new HtmlView();
        Provider hhProvider = new Provider(new HHStrategy());
        Provider moikrugProvider = new Provider(new MoikrugStrategy());
        Model model = new Model(view, hhProvider, moikrugProvider);
        //Model model = new Model(view, hhProvider);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod ();


    }
}
/*4. 3.1. Создай вью, модель, контроллер.
3.2. Засэть во вью контроллер.
3.3. Вызови у вью метод userCitySelectEmulationMethod.


2. В методе main создай провайдер для MoikrugStrategy. Передай этот провайдер в конструктор Model.

Это удобно сделать, т.к. модель принимает много провайдеров.

Остальную логику менять не нужно. Видишь, как легко расширять функционал?

От правильной архитектуры зависит многое.

ВНИМАНИЕ: ОСОБЕННОСТИ ТЕСТИРОВАНИЯ!

HTML код странички c вакансиями с Моего круга, как и ХэдХантера, может меняться. Чтобы эта задача прошла тестирование,

при реализации задания воспользуйся закешированной версией страницы: http://javarush.ru/testdata/big28data2.html.

Это необходимо для тестирования данного задания, после его сдачи проверь работу MoikrugStrategy на реальном сайте.*/