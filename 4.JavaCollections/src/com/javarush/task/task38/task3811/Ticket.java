package com.javarush.task.task38.task3811;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mr_ma on 07.03.2018.
 */
@Target(value = ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Ticket {
    Priority priority() default Priority.MEDIUM;
    String[] tags() default {};
    String createdBy() default "Amigo";
    enum Priority { LOW, MEDIUM, HIGH};
}
/*Тикеты
Реализуй в отдельном файле аннотацию Ticket.

Требования к ней следующие:
  Должна быть доступна во время выполнения программы.
2) Применяться может только к новым типам данных.
  Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
  Приоритет будет задавать свойство priority - по умолчанию Priority.MEDIUM.
  Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
 Свойство createdBy будет строкой - по умолчанию Amigo.


Требования:
1. Аннотация Ticket должна быть доступна во время выполнения программы.
2. Аннотация Ticket должна применяться только к новым типам данных.
3. Аннотация Ticket должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
4. Аннотация Ticket должна содержать свойство priority - по умолчанию Priority.MEDIUM.
5. Аннотация Ticket должна содержать свойство tags - массив строк, пустой по умолчанию.
6. Аннотация Ticket должна содержать свойство createdBy - строку, равную "Amigo" по умолчанию.*/