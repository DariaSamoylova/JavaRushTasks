package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        usersView.setController(controller); 
        controller.setModel(model);
        controller.setUsersView(usersView);

        editUserView.setController(controller);
        controller.setEditUserView(editUserView);
//editUserView.setController(controller);
        usersView.fireEventShowAllUsers();


        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserChanged("IvanovEdit", 126L, 5);
        editUserView.fireEventUserDeleted(124L);


     //   System.out.println("5675675675656756");
       // editUserView.fireEventUserChanged("Sidorov",126L, 2);

        usersView.fireEventShowDeletedUsers();


      //  UsersView usersView1 = new UsersView();
      //  usersView1.setController(controller);
      //  controller.setModel(model);
        // fireEventShowAllUsers(), fireEventOpenUserEditForm(126L), fireEventUserDeleted(124L), fireEventShowDeletedUsers().
//Ты не добавил в метод main класса Solution вызов метода fireEventUserDeleted(124L) у объекта класса EditUserView.
        //обавь в метод main открытие формы редактирования для пользователя с id=126 перед вызовом метода fireEventShowDeletedUsers().
        //Добавь в метод main класса Solution вызов метода fireEventOpenUserEditForm(126L) у объекта класса UsersView.
    }
}