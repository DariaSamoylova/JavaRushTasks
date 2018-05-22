package com.javarush.task.task33.task3309;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import  com.javarush.task.task33.task3308.Shop;
/*
Комментарий внутри xml
*/
/*
public class Solution {
    public static void main(String[] args)
    {
      //  System.out.println(toXmlWithComment(new Cat("Яша", 14, 16), "name", "test"));
    }
    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            StringWriter writer = new StringWriter();

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(obj, writer);

            String xml = writer.toString();
            String commentPut = "<!--"+comment+"-->";
            String tag = "<"+tagName;

            //Создаю регулярку для поиска CDATA
            Pattern pattern = Pattern.compile("(<!\\[CDATA\\[(.|\n)*?]]>)");
            Matcher matcher = pattern.matcher(xml);
            //Все найденные CDATA кладу в лист
            List<String> cdatas = new ArrayList<>();
            while (matcher.find()){
                cdatas.add(matcher.group());
            }
            //Заменяю все CDATA на другой тег
            xml = (xml.replaceAll(pattern.pattern(),"<URURU/>"));

            //ставлю комментарии в xml в котором нету CDATA и есть URURU teg
            List<String> list = new ArrayList<>(Arrays.asList(xml.split("\n")));
            List<String> copy = new ArrayList<>(list);
            for(int i =0;i<copy.size();i++){
                String s = copy.get(i);
                if(s.contains(tag)){
                    int count = spaceCount(s);
                    for(int j =0;j<count;j++){
                        commentPut = " "+commentPut;
                    }
                    list.set(i,commentPut+"\n"+s);
                    commentPut = commentPut.trim();
                }

            }
            //делаю новый xml который уже с комментами
            StringBuilder comments = new StringBuilder();
            for(String elem : list){
                comments.append(elem+"\n");
            }
            xml = comments.toString();


            //заменяю все URURU обратно на CDATA
            List<String> ururu = new ArrayList<>(Arrays.asList(xml.split("<URURU/>")));
            for(int i =0;i<cdatas.size();i++){
                String s = ururu.get(i);
                s+=cdatas.get(i);
                ururu.set(i,s);
            }

            //Делаю финальный xml
            StringBuilder result = new StringBuilder();
            for(String cdata : ururu)
                result.append(cdata);


            return result.toString().replace("standalone=\"yes\"","standalone=\"no\"");

        }
        catch (JAXBException e)
        {
            e.printStackTrace();
            return "";
        }
    }
    //штука для счета пробелов
    public static int spaceCount(String word){
        word = word.substring(0,word.indexOf("<"));
        int count = 0;
        char[] array = word.toCharArray();
        for(Character charc : array){
            if(charc == ' ')count++;
        }
        return count;
    }
}
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {
  /*
public static void main(String[] args) throws Exception {
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
    DocumentBuilder db = dbf.newDocumentBuilder();
     Document doc = db.parse(new FileInputStream(new File("in.xml")));
     Element element = doc.getDocumentElement();
  Comment comment = doc.createComment("This is a comment");
element.getParentNode().insertBefore(comment, element);
  prettyPrint(doc);
 }
  public static final void prettyPrint(Document xml) throws Exception {
     Transformer tf = TransformerFactory.newInstance().newTransformer();
    tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    tf.setOutputProperty(OutputKeys.INDENT, "yes");
   Writer out = new StringWriter();
   tf.transform(new DOMSource(xml), new StreamResult(out));
    System.out.println(out.toString());
 }

*/








        StringWriter writer = new StringWriter();
       // DOMImplementation writer = docb.getDOMImplementation();
        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(obj, writer);
//String res = writer.toString();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docb = dbf.newDocumentBuilder();
      //  Document doc = docb.parse(res);
        Document doc = docb.parse(new ByteArrayInputStream(writer.toString().getBytes()));
        doc.setXmlStandalone(true);

       // Element element = doc.getElementById(tagName);
      //  Comment comm = doc.createComment(comment);
      //  element.getParentNode().insertBefore(comm, element);

//if (res.contains(tagName))
 //   return res.replaceAll("<"+tagName,"<!--"+comment+"--><"+tagName);
//else


 /*

                Document document = documentBuilder.parse(new ByteArrayInputStream(stringWriter.toString().getBytes()));
                document.setXmlStandalone(true);

                StreamResult streamResult = new StreamResult(new ByteArrayOutputStream());
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                //Метод toXmlWithComment не должен изменять входящий xml в случае, если искомый тег отсутствует в нём.
                if (document.getElementsByTagName(tagName).getLength() == 0){
                DOMSource source = new DOMSource(document);
                transformer.transform(source, streamResult);
                return streamResult.getOutputStream().toString();
                }

                walkToDocument(document.getDocumentElement(), tagName, comment, document);

                DOMSource source = new DOMSource(document);
                transformer.transform(source, streamResult);
                return streamResult.getOutputStream().toString();*/


        StreamResult streamResult = new StreamResult(new ByteArrayOutputStream());
        Transformer tf = TransformerFactory.newInstance().newTransformer();
     //   tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
     //   tf.setOutputProperty(OutputKeys.INDENT, "yes");
     //   Writer out = new StringWriter();
      //  tf.transform(new DOMSource(doc), new StreamResult(out));
      //  tf.transform(new DOMSource(doc),streamResult);
       // System.out.println(out.toString());
       // return out.toString();
      //  return  streamResult.getOutputStream().toString();
        doc.setXmlStandalone(false);
        if (doc.getElementsByTagName(tagName).getLength() == 0){
            DOMSource source = new DOMSource(doc);
            tf.transform(source, streamResult);
            return streamResult.getOutputStream().toString();
        }

        walkToDocument(doc.getDocumentElement(), tagName, comment, doc);

        DOMSource source = new DOMSource(doc);
        tf.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "yes");
        tf.transform(source, streamResult);
        return streamResult.getOutputStream().toString();
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        try {
            System.out.print(toXmlWithComment(new Shop(),"count","comm"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    public static void walkToDocument(Node node, String tagName, String comment, Document document){
       if (node == null) return;

      String nodeValue = node.getNodeValue();
       Node parent = node.getParentNode();
    //    Node parent = node;
        if (nodeValue != null && node.getNodeType() == Node.TEXT_NODE && nodeValue.matches("(\\w|\\W)*([\"'<>&])(\\w|\\W)*")){
            Node nextSibling = node.getNextSibling();
            CDATASection cdataSection = document.createCDATASection(nodeValue);

            parent.insertBefore(cdataSection, nextSibling);
            parent.removeChild(node);
            node = cdataSection;
        } else if (node.getNodeName().equals(tagName)) {
            Comment cmnt = document.createComment(comment);
            node.getParentNode().insertBefore(cmnt, node);
        }

        walkToDocument(node.getFirstChild(),  tagName, comment, document);
        walkToDocument(node.getNextSibling(), tagName, comment, document);
    }



    @XmlType(name = "shop")
    @XmlRootElement
    public static class Shop {
        public int count;
        public       double profit;
        //@XmlAnyElement
        // public ArrayList<String> secretData;
        public  String[] secretData;
        public  Goods goods=new Goods();
        @XmlType(name = "goods")
        public static class Goods{
            public Integer count=new Integer(1);
            public String ttt="ff<count>";
            @XmlAnyElement
            public List<String> names = new ArrayList<>() ;
            //  Goods(){
            //     names
            // }

        }
    }
 }
/*Комментарий внутри xml
http://info.javarush.ru/JavaRush_tasks_discussion/2015/01/15/level33-lesson10-bonus01.html#comment43166
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:
toXmlWithComment(firstSecondObject, "second", "it's a comment")

Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second><![CDATA[need CDATA because of < and >]]></second>
<!--it's a comment-->
<second/>
</first>


Требования:
1. Метод toXmlWithComment должен быть статическим.
2. Метод toXmlWithComment должен быть публичным.
3. Метод toXmlWithComment не должен изменять входящий xml в случае, если искомый тег отсутствует в нём.
4. Количество комментариев вставленных в xml должно быть равно количеству тегов tagName.
5. Метод toXmlWithComment должен возвращать xml в виде строки преобразованной в соответствии с условием задачи.*/