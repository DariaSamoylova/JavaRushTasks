package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

/**
 * Created by mr_ma on 15.03.2018.
 */
public class HtmlView implements View {
    private  Controller controller;
    //private final    String filepath="./"+this.getClass().getPackage().getName()+"/vacancies.html";
     private final String filePath = "./src/" + getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";
  //  private final String filePath =  "c:\\Users\\mr_ma\\Documents\\Даша\\jv\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task28\\task2810\\view\\vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
//System.out.println("vacancies.size()= "+vacancies.size());
     //  System.out.print ( vacancies.size());
        try{
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e){

        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller=controller;

    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies) {

        Document document = null;
        try {
            document = getDocument();

            Element templateOriginal = document.getElementsByClass("template").first();
            Element copyTemplate = templateOriginal.clone();
            copyTemplate.removeAttr("style");
            copyTemplate.removeClass("template");
            document.select("tr[class=vacancy]").remove().not("tr[class=vacancy template");

            for (Vacancy vacancy : vacancies) {
                Element localClone = copyTemplate.clone();
                localClone.getElementsByClass("city").first().text(vacancy.getCity());
                localClone.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                localClone.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link =localClone.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateOriginal.before(localClone.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();
    }
/*
рабочий вариант!!!не принят валидатором
   private   String getUpdatedFileContent(List<Vacancy> list)   {

       try {
           Document   doc = getDocument();
       //    Element element = doc.getElementsByAttributeValue("class", "vacancy template").first();
           Element element = doc.getElementsByClass("template").first();
          Element elementCopy = element.clone();
           elementCopy.removeClass("template");
           elementCopy.removeAttr("style");
           //elementCopy.attr("class","vacancy");
          // elementCopy.removeClass("template");
          // elementCopy.removeAttr("style");
           Elements elements = doc.getElementsByAttributeValue("class", "vacancy");
         //  Elements elements = doc.getElementsByClass( "vacancy");
           //Element element = doc.getElementsByClass("template").first();
           elements.remove();

                   elementCopy.appendTo(element.parent());
           for (Vacancy vacancy : list) {
               Element elemClone = elementCopy.clone();
               elemClone.appendTo(element.parent());
             // Element eee=elementCopy.getElementsByAttributeValue("class", "city").first();
               //eee.text(vacancy.getCity());
              // elementCopy.getElementsByAttributeValue("class", "companyName").first().text(vacancy.getCompanyName());
             //  elementCopy.getElementsByAttributeValue("class", "salary").first().text(vacancy.getSalary());
            //   elementCopy.getElementsByAttribute("a").attr("title", vacancy.getTitle());
            //   elementCopy.getElementsByAttribute("a").attr("href", vacancy.getUrl());
              // //attr("href");
            //   elementCopy.outerHtml();
             elemClone.getElementsByAttributeValue("class", "city").first().text(vacancy.getCity());

               elemClone.getElementsByAttributeValue("class", "companyName").first().text(vacancy.getCompanyName());
               elemClone.getElementsByAttributeValue("class", "salary").first().text(vacancy.getSalary());
               elemClone.getElementsByAttribute("a").attr("title", vacancy.getTitle());
               elemClone.getElementsByAttribute("a").attr("href", vacancy.getUrl());
               //attr("href");
             //  elemClone.outerHtml();

           }
           element.outerHtml();
           return doc.html();
       } catch (IOException e){
           e.printStackTrace();
           return "Some exception occurred";
       }


   }
*/

    private void updateFile(String string) throws IOException {
        FileWriter fw = new FileWriter(new File(filePath));
        fw.write(string);
        fw.flush();
        fw.close();

    }
     protected Document getDocument()  throws IOException {
       return Jsoup.parse(new File(filePath), "UTF-8");
   }


}
/*1.В классе HtmlView остался один пустой метод getUpdatedFileContent. В этом задании я опишу, что он должен делать.

1. В HtmlView создай protected метод Document getDocument() throws IOException, в котором
распарси файл vacancies.html используя Jsoup. Кодировка файла "UTF-8", используй поле filePath.

2. Получи элемент, у которого есть класс template.
Сделай копию этого объекта, удали из нее атрибут "style" и класс "template".
Используй этот элемент в качестве шаблона для добавления новой строки в таблицу вакансий.

3. Удали все добавленные ранее вакансии. У них единственный класс "vacancy".
В файле backup.html это одна вакансия - Junior Java Developer.
Нужно удалить все теги tr, у которых class="vacancy".
Но тег tr, у которого class="vacancy template", не удаляй.
Используй метод remove.

4. В цикле для каждой вакансии:
4.1. склонируй шаблон тега, полученного в п.2. Метод clone.
4.2. получи элемент, у которого есть класс "city". Запиши в него название города из вакансии.
4.3. получи элемент, у которого есть класс "companyName". Запиши в него название компании из вакансии.
4.4. получи элемент, у которого есть класс "salary". Запиши в него зарплату из вакансии.
4.5. получи элемент-ссылку с тегом a. Запиши в него название вакансии(title). Установи реальную ссылку на вакансию вместо href="url".
4.6. добавь outerHtml элемента, в который ты записывал данные вакансии,
непосредственно перед шаблоном <tr class="vacancy template" style="display: none">

5. Верни html код всего документа в качестве результата работы метода.

6. В случае возникновения исключения, выведи его стек-трейс и верни строку "Some exception occurred".

7. Запусти приложение, убедись, что все вакансии пишутся в файл vacancies.html.


Требования:
1. В классе HtmlView добавь метод protected Document getDocument() в котором распарси файл vacancies.html используя Jsoup.
2. Реализуй метод getUpdatedFileContent(). Для начала, получи распарсеную страницу с помощью метода getDocument().
3. Получи элемент, у которого есть класс template. Сделай копию этого объекта, удали из нее атрибут "style" и класс "template".
4. Удали из страницы все добавленные ранее вакансии с классом "vacancy". Элемент с классом "vacancy template" должен остаться.
5. Перед объектом template для каждой вакансии добавь на страницу отдельный html-элемент, используя копию template. Верни html-код всей страницы в качестве результата работы метода.
6. Для каждой вакансии должен быть корректно заполнен элемент-ссылка с названием вакансии(title) и http-ссылкой на нее(href).
7. Для каждой вакансии должен быть корректно заполнен элемент с классом "city".
8. Для каждой вакансии должен быть корректно заполнен элемент с классом "companyName".
9. Для каждой вакансии должен быть корректно заполнен элемент с классом "salary".
10. В случае возникновения исключения, выведи его стек-трейс и верни строку "Some exception occurred".*/