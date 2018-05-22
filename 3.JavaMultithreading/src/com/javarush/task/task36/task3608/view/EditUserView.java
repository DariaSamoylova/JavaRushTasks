package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by mr_ma on 31.10.2017.
 */
public class EditUserView implements  View {
    private Controller controller;
    @Override
    public void refresh(ModelData modelData) {

            System.out.println("User to be edited:");
         //   for(User r:modelData.getUsers()){
                System.out.println("\t"+modelData.getActiveUser());

            System.out.println( "===================================================");
    }

    @Override
    public void setController(Controller controller)
        {
            this.controller = controller;
        }

    public  void fireEventUserDeleted(long id){
        controller.onUserDelete(id);
    }


    public void fireEventUserChanged(String name, long id, int level){
        controller.onUserChange(name,id,level);

    }
}
/*2.1. Вывести в консоль «User to be edited:«.
2.2. С новой строки вывести табуляцию и активного пользователя.
2.3. С новой строки вывести разделитель «===================================================».*/