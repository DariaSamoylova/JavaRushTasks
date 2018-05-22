package com.javarush.task.task31.task3110;

public enum Operation {
   /* CREATE,
    ADD,
    REMOVE,
    EXTRACT,
    CONTENT,
    EXIT*/
   CREATE("упаковать файлы в архив"),
    ADD("добавить файл в архив"),
    REMOVE("удалить файл из архива"),
    EXTRACT("распаковать архив"),
    CONTENT("просмотреть содержимое архива"),
    EXIT("выход");

    private String comment;

    Operation(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return comment;
    }
}

/*0 - упаковать файлы в архив
        1 - добавить файл в архив
        2 - удалить файл из архива
        3 - распаковать архив
        4 - просмотреть содержимое архива
        5 – выход*/
