package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by mr_ma on 31.10.2017.
 */
public class UsersView implements  View {
    private Controller controller;
    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList())
            System.out.println("All deleted users:");
        else
            System.out.println("All users:");

        for(User r:modelData.getUsers()){
            System.out.println("\t"+r);
        }
        System.out.println( "===================================================");
    }

    @Override
    public void setController(Controller controller) {
this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }


}
/*3.1. Выведи в консоль фразу «All users:«.
3.2. Выведи в консоль всех пользователей, которые есть в modelData.
Перед каждым пользователем сделай отступ в виде табуляции.
3.3. В конце выведи визуальный разделитель данных fireEventOpenUserEditForm(long)
===============================================*/