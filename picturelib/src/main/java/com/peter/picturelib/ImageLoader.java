package com.peter.picturelib;

import android.widget.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoader {
    private ImageLoader() {}
    private MemoryCache mMemoryCache = new MemoryCache();
    private DiskCache mDiskCache = new DiskCache();
    // 线程池
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static ImageLoader getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder{
        private static final ImageLoader sInstance = new ImageLoader();
    }

    public void loadPicture(String url, ImageView imageView){
        if (mMemoryCache.get(url) != null){
            imageView.setImageBitmap(mMemoryCache.get(url));
            return;
        }

//        downLoadFromNetwork(url);
    }
}
