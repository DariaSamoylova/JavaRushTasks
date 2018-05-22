package com.javarush.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

/**
 * Created by mr_ma on 18.04.2018.
 */
public class LevelLoader {
    private Path levels;
    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public  GameObjects getLevel(int level) throws IOException {
        {
            Set<Wall> walls = new HashSet<>();
            Set<Box> boxes = new HashSet<>();
            Set<Home> homes = new HashSet<>();
            Player player = null;

            int loopLevel;
            if (level > 60) {
                loopLevel = level % 60;
            } else {
                loopLevel = level;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
                int readLevel = 0;
                int x;
                int y = Model.FIELD_CELL_SIZE / 2;
                boolean isLevelMap = false;

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Maze:")) {
                        readLevel = Integer.valueOf(line.split(" ")[1]);
                        continue;
                    }
                    if (readLevel == loopLevel) {
                        if (line.length() == 0) {
                            boolean isEnd = isLevelMap;

                            isLevelMap = !isLevelMap;

                            if (isEnd && !isLevelMap) {
                                break;
                            } else {
                                continue;
                            }
                        }
                        if (isLevelMap) {
                            x = Model.FIELD_CELL_SIZE / 2;

                            char[] chars = line.toCharArray();
                            for (char c : chars) {
                                switch (c) {
                                    case 'X':
                                        walls.add(new Wall(x, y));
                                        break;
                                    case '*':
                                        boxes.add(new Box(x, y));
                                        break;
                                    case '.':
                                        homes.add(new Home(x, y));
                                        break;
                                    case '&':
                                        boxes.add(new Box(x, y));
                                        homes.add(new Home(x, y));
                                        break;
                                    case '@':
                                        player = new Player(x, y);
                                }
                                x += Model.FIELD_CELL_SIZE;
                            }
                            y += Model.FIELD_CELL_SIZE;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new GameObjects(walls, boxes, homes, player);
            /*
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(levels.toFile())));
        int actualLevel=level%60+1;
        boolean read=false;
        int stroka=0;

        Set<Home> homeSet = new HashSet<>();
        Set<Box> boxSet = new HashSet<>();
        Set<Wall> wallSet = new HashSet<>();
        Player player = null;


        while(true){
            String line = r.readLine();
            if (line==null) break;

            if (line.contains("Maze:")) {
                if (actualLevel == Integer.parseInt(line.substring(6))) {
                    read = true;
                    stroka=1;
                }
                else
                    read = false;
            }

            if (read) {
                if (stroka >= 8) {
                    char[] chars = line.toCharArray();
                    for (int i=0;i<chars.length;i++) {
                        int x=(i+1)*FIELD_CELL_SIZE-FIELD_CELL_SIZE / 2;
                        int y = (stroka-7)*FIELD_CELL_SIZE -FIELD_CELL_SIZE / 2;
                        switch (chars[i]) {
                            case 'X':
                                wallSet.add(new Wall(x, y));
                                break;
                            case '*':
                                boxSet.add(new Box(x, y));
                                break;
                            case '.':
                                homeSet.add(new Home(x, y));
                                break;
                            case '&':
                                boxSet.add(new Box(x, y));
                                homeSet.add(new Home(x, y));
                                break;
                            case '@':
                                player = new Player(x, y);
                        }

                }

                stroka++;
                if (line.length()==0)
                    break;
            }







            }

        }

    return  new GameObjects(wallSet,boxSet,homeSet,player);*/
        }}
}
/* Реализуй метод GameObjects getLevel(int level). Он должен:
16.2.1. Вычитывать из файла данные уровня level. Уровни должны повторяться циклически, если пользователь прошел все 60 уровней и попал на 61 уровень, то ему нужно вернуть 1, вместо 62 уровня вернуть 2 и т.д.
16.2.2. Создать все игровые объекты, описанные в указанном уровне. Координаты каждого игрового объекта должны быть рассчитаны согласно следующей логике:
16.2.2.1. Самый верхний левый объект (если такой есть) должен иметь координаты x = x0 = FIELD_CELL_SIZE / 2 и y = y0 = FIELD_CELL_SIZE / 2.
16.2.2.2. Объект, который находится на одну позицию правее от него должен иметь координаты x = x0 + FIELD_CELL_SIZE и y = y0.
16.2.2.3. Объект, который находится на одну позицию ниже от самого верхнего левого должен иметь координаты x = x0 и y = y0 + FIELD_CELL_SIZE.
16.2.2.4. Аналогично должны рассчитываться координаты любого объекта на поле.
16.2.3. Создать новое хранилище объектов GameObjects и поместить в него все объекты.
16.2.4. Вернуть созданное хранилище.

Игра должна быть полностью рабочей. Проверь, если есть какие-то проблемы исправь их.


Требования:
1. Реализуй метод GameObjects getLevel(int level) согласно условию задачи.*/