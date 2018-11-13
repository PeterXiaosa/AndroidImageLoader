package com.peter.picturelib.Interface;

import java.io.Closeable;
import java.io.IOException;

public final class CloseUtils{

    private CloseUtils(){};

    public static void closeQuietly(Closeable closeable){
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
