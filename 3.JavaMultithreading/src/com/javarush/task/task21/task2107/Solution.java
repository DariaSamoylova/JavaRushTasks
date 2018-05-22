package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements  Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone =(Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }


    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution a = new Solution();// (Solution) super.clone();
        a.users= new LinkedHashMap(this.users);
    //    for(Map.Entry<String, User> k:this.users.entrySet()){
    //        a.users.put(k.getKey(),k.getValue());
    //    }
      //  a.users.putAll(this.users);
     //   return super.clone();
        return a;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User  implements  Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }


        @Override
        protected User clone() throws CloneNotSupportedException {
            User a = new User(age,name);// (User) super.clone();
            //   return super.clone();
            return a;
            //return super.clone();
        }

        public boolean equals(Object n) {
            //  return n.first.equals(first) && n.last.equals(last);

            if (this == n)
                return true;
            if (n == null)
                return false;
            if (!(n instanceof User))
                return false;

            User other = (User) n;
            if (age != other.age)
                return false;
            if (!name.equals(other.name))
                return false;
            return true;
        }


        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;

            result = prime * result + age;//((first!=null)?first.hashCode():0);
            result = prime * result + ((name!=null)?name.hashCode():0) ;
            //  result=first.hashCode()*prime+last.hashCode()*prime;
            return result;
        }
    }
}
/*Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.


Требования:
1. Класс Solution должен поддерживать интерфейс Cloneable.
2. Класс User должен поддерживать интерфейс Cloneable.
3. В классе User должен быть корректно реализован метод clone.
4. В классе Solution должен быть корректно реализован метод clone.*/