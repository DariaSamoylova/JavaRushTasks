package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/**
 * Created by mr_ma on 31.10.2017.
 */
public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }



    public void setModel(Model model) {
        this.model = model;
    }

  //  public Model getModel() {
   //     return model;
  //  }

    public  void onShowAllUsers(){
        model.loadUsers();

        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();

        usersView.refresh(model.getModelData());
    }
    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);

        editUserView.refresh(model.getModelData());
     //   System.out.println(1);
    }


    public  void onUserDelete(long id){
        model.deleteUserById(id);
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }


    public  void onUserChange(String name, long id, int level){
        model.changeUserData(name ,id,level);

        model.loadUsers();
        usersView.refresh(model.getModelData());
    }
}
//де onOpenUserEditForm(long) должен вызываться .refresh у объекта editUserView, а не usersView; В методе onUserDelete(long) ты не обновил объект класса UsersView.
//В методе onUserChange(String, long, int) ты не обновил объект класса UsersView. Как параметр метода refresh нужно использовать model.getModelData().