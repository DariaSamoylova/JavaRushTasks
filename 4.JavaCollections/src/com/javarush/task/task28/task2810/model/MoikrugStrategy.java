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
 * Created by mr_ma on 19.03.2018.
 */
public class MoikrugStrategy implements  Strategy {
    //private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
 //   private static final String URL_FORMAT =  "https://moikrug.ru/vacancies?q=java&page=2";
    private static final String URL_FORMAT =  "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    //https://moikrug.ru/vacancies?q=java+Dnepropetrovsk         "http://hh.ua/search/vacancy?text=java+%s&page=%d"
    //https://moikrug.ru/vacancies?page=2&q=java+Dnepropetrovsk

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> Vacancies = new ArrayList<>();
        int pageNum = 0;
        Document doc = null;
        while(true)
        {
            try {
                doc = getDocument(searchString, pageNum);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements vacancies = doc.getElementsByClass("job");
            if (vacancies.size()==0) break;
            for (Element element: vacancies)
            {
                if (element != null)
                {
                    Vacancy vac = new Vacancy();
                    vac.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    vac.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vac.setSiteName(URL_FORMAT);
                    vac.setUrl("https://moikrug.ru" + element.select("a[class=job_icon]").attr("href"));
                    String salary = element.getElementsByAttributeValue("class", "salary").text();
                    String city = element.getElementsByAttributeValue("class", "location").text();
                    vac.setSalary(salary.length()==0 ? "" : salary);
                    vac.setCity(city.length()==0 ? "" : city);
                    Vacancies.add(vac);
                }
            }
            pageNum++;
        }
        return Vacancies;
    }/*
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        if (searchString == null)
            return Collections.emptyList();
        int j = 0;
        while (true) {
            try {
                Document doc = getDocument(searchString, j++);
                Elements elements = doc.select("[class=job]");//doc.getElementsByAttributeValue("class", "job");
              //  Elements elements = doc.getElementsByClass( "job");
                if (elements.size() > 1) {
                    for (int i = 0; i < elements.size(); i++) {
                        Vacancy vacancy = new Vacancy();

                        String title = elements.get(i).getElementsByAttributeValue("class", "title").text();
                        vacancy.setTitle(title);

                        String salary = elements.get(i).getElementsByAttributeValue("class", "salary").text();
                        if (salary != null)
                            vacancy.setSalary(salary);
                        else vacancy.setSalary("");

                        String city = elements.get(i).getElementsByAttributeValue("class", "location").text();
                        if (city != null)
                            vacancy.setCity(city);
                        else vacancy.setCity("");


                        String companyName = elements.get(i).getElementsByAttributeValue("class", "company_name").text();
                        vacancy.setCompanyName(companyName);

                        String url ="https://moikrug.ru"+ elements.get(i).getElementsByAttributeValue("class", "job_icon").attr("href");
                        vacancy.setUrl(url);

                        String siteName = "https://moikrug.ru";
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
*/
    //получение объекта Document html-страницы.
    protected Document getDocument(String searchString, int page) throws IOException{
        String url = String.format(URL_FORMAT, searchString, page);
     //   String url = "http://javarush.ru/testdata/big28data2.html";
        Document doc = Jsoup.connect(url).userAgent("Chrome/57.0.2987.133 (jsoup)").referrer("?").get();
        return doc;
    }
}
