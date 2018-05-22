package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mr_ma on 12.03.2018.
 */
/*public class HHStrategy implements Strategy {
    //    private  static final String URL_FORMAT="http://hh.ru/search/vacancy?text=java+\"%s\"&page=%d";
    //private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d&userAgent=true&referrer=true";
   private static final String URL_FORMAT = "https://hh.ua/search/vacancy?text=java+%s&page=%d";
  //  private static final String URL_FORMAT = "https://javarush.ru/testdata/big28data.html";
    @Override
    public List<Vacancy> getVacancies(String searchString) {
       List<Vacancy> resultList = new ArrayList<>();
        try {
            int i=0;
            while(true){
               // while (true){
               // Document document = getDocument(searchString, i);
              //  Elements vacanciesElements = document.select(vacancyQuery);
              //  if (!vacanciesElements.isEmpty()){
                Document doc =   getDocument(searchString,i);
                Elements elements=doc.select("[data-qa='vacancy-serp__vacancy']");
                if (elements.isEmpty())
                    break;

                for(Element elem:elements){
                    Elements elementsTitle= elem.select("[data-qa='vacancy-serp__vacancy-title']");
                    Elements elementsSalary= elem.select("[data-qa='vacancy-serp__vacancy-compensation']");
                    Elements elementsCity= elem.select("[data-qa='vacancy-serp__vacancy-address']");
                    Elements elementsCompany= elem.select("[data-qa='vacancy-serp__vacancy-employer']");
                   // Elements elementsSite= elem.select("data-qa='vacancy-serp__vacancy-title'");
                  //  Elements elementsUrl= elem.select("data-qa='vacancy-serp__vacancy-title'");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(elementsTitle.text());
                   // vacancy.setSalary(elementsSalary.isEmpty()?"":elementsSalary.text());
                    if (!elementsSalary.isEmpty()){
                        vacancy.setSalary(elementsSalary.text());
                    } else {
                        vacancy.setSalary("");
                    }
                    vacancy.setCity(elementsCity.text());
                    vacancy.setCompanyName(elementsCompany.text());
                   // vacancy.setSiteName(String.format(URL_FORMAT, searchString, i));
                    vacancy.setSiteName("http://hh.ua");
                    vacancy.setUrl(elementsTitle.attr("href"));
                    resultList.add(vacancy);
                }

                i++;
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
     //   String url ="http://javarush.ru/testdata/big28data.html";
       // String url = String.format(URL_FORMAT, "Москва", 2);
         String url = String.format(URL_FORMAT, searchString, page);
     //   String url = String.format(URL_FORMAT, "Москва", page);

      //Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36")
       //         .referrer("no-referrer-when-downgrade").get();
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla")
                .referrer("https://hh.ua")
                .get();
        return doc;





    }
}*/
public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

public static void  f(){

}
    @Override
    public   List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        if (searchString == null)
            return Collections.emptyList();
        int j = 0;
        while (true) {
            try {
                Document doc = getDocument(searchString, j++);
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() > 1) {
                    for (int i = 0; i < elements.size(); i++) {
                        Vacancy vacancy = new Vacancy();

                        String title = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text();
                        vacancy.setTitle(title);

                        String salary = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                        if (salary != null)
                            vacancy.setSalary(salary);
                        else vacancy.setSalary("");

                        String city = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text();
                        vacancy.setCity(city);

                        String companyName = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text();
                        vacancy.setCompanyName(companyName);

                        String url = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href");
                        vacancy.setUrl(url);

                        String siteName = "http://hh.ua";
                        vacancy.setSiteName(siteName);

                        vacancies.add(vacancy);
                    }
                }
                else break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return vacancies;
    }

    //получение объекта Document html-страницы.
    protected Document getDocument(String searchString, int page) throws IOException{
        String url = String.format(URL_FORMAT, searchString, page);
        Document doc = Jsoup.connect(url).userAgent("Chrome/57.0.2987.133 (jsoup)").referrer("?").get();
        return doc;
    }
}
//https://hh.ru/search/vacancy?text=java&enable_snippets=true&clusters=true&area=115&page=1
//http://hh.ru/search/vacancy?text=java+"?"&page=?
/*2. Реализуй следующую логику метода getVacancies в классе HHStrategy:
2.1. Приконнекться к закешированной страничке ХэдХантера используя метод getDocument, нумерация начинается с 0.
2.2. Получи список элементов с атрибутом "vacancy-serp__vacancy". Должно быть до 20 вакансий на странице.
2.3. Если данные в списке из п.2.2 есть, то для каждого элемента:
2.3.1. создать вакансию и заполнить все ее данные, получив данные из текущего элемента.
Если тег с зарплатой присутствует, то заполнить и поле salary, иначе инициализировать поле пустой строкой.
2.4. Выполнить п.2.1-2.3 для следующей страницы ХэдХантера.
2.5. Если закончились страницы с вакансиями, то выйти из цикла.

Исключения игнорировать.
Все вакансии добавить в общий список и вернуть в качестве результата метода.

Подсказка по зарплате:
Поиграйся с URL_FORMAT, добавь туда еще один параметр, чтобы получить вакансии с зарплатами.
Проанализируй полученный html и найди тег для зарплаты.
Не забудь потом вернуть значение URL_FORMAT обратно.


Требования:
1. В классе HHStrategy создай protected метод getDocument(String searchString, int page). Перенеси туда логику по получению объекта html-страницы Document.
2. Метод getVacancies класса HHStrategy должен получать содержимое страниц с помощью метода getDocument. Начни с 0 страницы.
3. Из объекта Document получи список html-элементов с атрибутом "vacancy-serp__vacancy". Для каждого элемента создай объект вакансии и добавь его в возвращающий методом список.
4. Нужно последовательно обработать все страницы результатов поиска. Как только страницы с вакансиями закончатся, прерви цикл и верни список найденных вакансий.
5. У каждой вакансии должно быть заполнено поле title полученными из html-элемента данными о названии вакансии.
6. У каждой вакансии должно быть заполнено поле url полученной из html-элемента ссылкой на вакансию.
7. У каждой вакансии должно быть заполнено поле city полученными из html-элемента данными о городе.
8. У каждой вакансии должно быть заполнено поле companyName полученными из html-элемента данными о компании.
9. У каждой вакансии должно быть заполнено поле siteName значением сайта, на котором вакансия была найдена.
10. Поле salary у вакансии должно быть заполнено, если в html-элементе присутствовал тег с зарплатой. Иначе поле должно быть инициализировано пустой строкой.
11. Если ты менял значение поля URL_FORMAT, не забудь вернуть его обратно.*/