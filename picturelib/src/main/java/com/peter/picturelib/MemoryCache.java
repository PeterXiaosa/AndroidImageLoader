package com.peter.picturelib;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.peter.picturelib.Interface.ImageCache;

public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> mCache;

    public MemoryCache() {
        int maxSize = (int) Runtime.getRuntime().maxMemory() / 4;
        mCache = new LruCache<String, Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                // 实践的时候可以试一下value.getByteCount和相乘的结果比较是否一致。
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        return mCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }
}
