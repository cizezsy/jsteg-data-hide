package me.cizezsy;

import me.cizezsy.exception.BitIOException;
import me.cizezsy.exception.JPEGParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            new JPEGImageReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\aaa.jpg")).readImage();
        } catch (BitIOException | FileNotFoundException | JPEGParseException e) {
            e.printStackTrace();
        }
    }

}
