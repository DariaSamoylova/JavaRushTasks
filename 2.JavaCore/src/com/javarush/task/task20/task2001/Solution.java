package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human

все работает
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
        //    String file1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
          //  File your_file_name = File.createTempFile("c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt", null);
           String your_file_name = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov");//, new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
           System.out.println(ivanov.equals(somePerson));
          System.out.println(somePerson.name);
         //   System.out.println(somePerson.assets.get(0));
         //   System.out.println(somePerson.assets.get(1));
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);
            if (this.assets.size() > 0) {
                for (Asset current : this.assets) {
                    printWriter.println(current.getName());
                    printWriter.println(current.getPrice());
                }
            }
            printWriter.close();








          /*  PrintWriter writer = new PrintWriter(outputStream);
            writer.println(this.name);
          //  if (assets != null) {
            if (this.assets.size() > 0) {
                for (int i = 0; i < assets.size(); i++) {
                    writer.println(assets.get(i).getName());
                    writer.println(assets.get(i).getPrice());
                }
            }
            writer.close();*/



         /*   PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(name);
            printWriter.flush();
           String sizeAss =String.valueOf(assets.size());
            printWriter.println(sizeAss);
            printWriter.flush();

            for (Asset a : assets) {
                    a.save(outputStream);

                }


            printWriter.flush();*/

        }



            public void load(InputStream inputStream) throws Exception {
                //implement this method - реализуйте этот метод
              /*  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                this.name = reader.readLine();
                String assetName;
                int i=0;
                while ((assetName = reader.readLine()) != null){
              //  for (int i = 0; reader.ready() == true; i++) {
                    assets.add(i, new Asset(assetName));
                    assets.get(i).setPrice(Double.parseDouble(reader.readLine()));
                    i++;
                }
                reader.close();*/

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                this.name = reader.readLine();
                String assetName;
                int i=0;
                while ((assetName = reader.readLine()) != null) {
                    //  this.assets.add(new Asset(assetName));
                    assets.add(i, new Asset(assetName));
                    assets.get(i).setPrice(Double.parseDouble(reader.readLine()));
                    i++;
                }
                reader.close();
            }



       /*
            }
            //implement this method - реализуйте этот метод

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            name = reader.readLine();
          //  System.out.println(name);
          int len = Integer.parseInt(  reader.readLine());
         //   System.out.println(len);
          for(int i=0;i<len;i++)
            {
              //  System.out.println("i="+i);
                   Asset a=new Asset(reader.readLine());
              //  System.out.println("1i="+ a.getName());
                a.setPrice( Double.parseDouble(reader.readLine()));
                //   a.load(inputStream);
             //   System.out.println("2i="+a.getPrice());
                assets.add(a);
              //  System.out.println("3i="+i);

           //     }
            }


        }*/
    }
}
/*Читаем и пишем в файл: Human
Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.*/