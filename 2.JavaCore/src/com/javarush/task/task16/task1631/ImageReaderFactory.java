package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by mr_ma on 04.10.2017.
 */
public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes e) throws IllegalArgumentException{
    /*    switch (month) {
            case 1:  monthString = "January";
                break;

                  BMP,
    JPG,
    PNG*/
try{
    if ((e.name()).equals("BMP"))
        return new BmpReader();
    else  if ((e.name()).equals("JPG"))
        return new JpgReader();
    else  if ((e.name()).equals("PNG"))
        return new PngReader();
        else
            throw new IllegalArgumentException();
} catch (NullPointerException w){
    throw new IllegalArgumentException();
}


    }
}
