package com.javarush.task.task25.task2503;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();



        for (int i = 0; i < realOrder.length; i++) {
          innerFor:
            for (int y = 0; y < realOrder.length; y++) {
                if (realOrder[y]==i){
                    for (Column column : values()) {
                        if (column.ordinal()==y){
                            result.add(column);
                            break innerFor;
                        }
                    }
                }


            }
        }

        return result;
    }

    @Override
    public String getColumnName() {
        return this.columnName;
    }

    @Override
    public boolean isShown() {
        for (int i = 0; i < realOrder.length; i++) {

                if (this.ordinal()==i&&realOrder[i]>=0){
                    return true;
                }

        }
        return false;
    }

    @Override
    public void hide() {
        int oldNum=0;
        for (int i = 0; i < realOrder.length; i++) {
            if (this.ordinal()==i&&realOrder[i]>=0){
                oldNum= realOrder[i];
                realOrder[i]=-1;
                break;
            }
        }
        for (int i = 0; i < realOrder.length; i++) {
            if ( realOrder[i]>oldNum){
                realOrder[i] = realOrder[i]-1;
            }
        }
    }
}
/*Свой enum
Реализуй интерфейс Columnable у Column, описание методов смотрите в джавадоках.
Реализуй логику метода Column.getVisibleColumns.
Метод Column.configureColumns уже реализован, его не меняй.
Создавать дополнительные поля нельзя.
Метод main не участвует в тестировании.


Требования:
1. Интерфейс Columnable менять нельзя.
2. Класс Column должен реализовывать интерфейс Columnable.
3. Создавать дополнительные поля в классе Column нельзя.
4. Метод Column.configureColumns реализован. Менять его не нужно.
5. Метод Column.getVisibleColumns должен возвращать список отображаемых колонок в скофигурированом порядке.
6. Метод Column.getColumnName должен возвращать полное имя колонки.
7. Метод Column.isShown должен возвращать true, если колонка видимая, иначе false.
8. Метод Column.hide должен скрывать колонку и сдвигать индексы остальных отображаемых колонок.*/