package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by mr_ma on 31.10.2017.
 */
public class MainModel implements  Model {
    private UserService userService = new UserServiceImpl();
    private  ModelData modelData = new ModelData();


    private List<User> getAllUsers(){
        List<User> list =     userService.getUsersBetweenLevels(1, 100);
       return userService.filterOnlyActiveUsers(list);
    }
    public void loadUsers() {
        List<User> list =  getAllUsers();//userService.getUsersBetweenLevels(1, 100);
//В методе getAllUsers() нужно получить список всех пользователей у объекта userService
// используя метод getUsersBetweenLevels(1, 100), после чего у объекта userService вызвать метод filterOnlyActiveUsers(List<User>).
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(list);
    }

    public ModelData getModelData() {
        return modelData;
    }


    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(users);
    }


    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public  void deleteUserById(long id){
       // User user = userService.getUsersById(id); В методе deleteUserById() используй getAllUsers(), и не забудь обновить модель.
        modelData.setUsers(getAllUsers());
        userService.deleteUser(id);
    //    modelData.
    }


   /* public  void changeUserData(String name, long id, int level){
        modelData.setUsers(getAllUsers());
        userService.createOrUpdateUser(name, id, level);
    }*/

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name,id,level);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }
}
/*
В классе MainModel в методе loadDeletedUsers ты не установил список пользователей объекту modelData с помощью сеттера.
В классе MainModel в методе changeUserData(String, long, int) пользователь должен изменяться согласно условию.
В классе MainModel метод deleteUserById(long) должен установить список всех активных пользователей объекту modelData.
В классе MainModel в методе loadUserById(long) нужно вызвать метод getUsersById(long) на объекте класса UserService.



public class FakeModel implements  Model {
    private  ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> list =  new ArrayList<>();
        list.add(new User("first",1,1));
        list.add(new User("second",2,1));
        list.add(new User("third",3,1));

        modelData.setUsers(list);
    }
}

1. Аналогично FakeModel создай модель MainModel.

2. Т.к. Модель обращается к сервисам, то в MainModel создай поле UserService userService, инициализируй объектом.

3. Реализуй логику метода loadUsers:
3.1. Достань всех пользователей между 1 и 100 уровнями. (Метод getUsersBetweenLevels(1, 100)).
3.2. Положи всех пользователей в modelData.

4. Обнови Solution.main: замени FakeModel на MainModel.
Преимущества MVC в том, что в любой момент времени легко можно заменить любую часть паттерна.


*/