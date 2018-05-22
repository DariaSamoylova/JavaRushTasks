package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_ma on 31.10.2017.
 */
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

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId)
        {
            throw new UnsupportedOperationException();
    }
}
