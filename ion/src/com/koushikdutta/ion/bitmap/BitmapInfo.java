package com.koushikdutta.ion.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;

import com.koushikdutta.async.util.UntypedHashtable;

import java.io.File;

/**
 * Created by koush on 6/12/13.
 */
public class BitmapInfo {
    public BitmapInfo(String key, String mimeType, Bitmap[] bitmaps, Point originalSize) {
        this.originalSize = originalSize;
        this.bitmaps = bitmaps;
        this.key = key;
        this.mimeType = mimeType;
    }

    final public Point originalSize;
    public long loadTime = System.currentTimeMillis();
    public long drawTime;
    final public String key;
    public int loadedFrom;
    final public Bitmap[] bitmaps;
    public int[] delays;
    public Exception exception;
    public BitmapRegionLoader decoder;
    public File decoderFile;
    public final String mimeType;
    public final UntypedHashtable extras = new UntypedHashtable();

    public int sizeOf() {
        if (bitmaps == null)
            return 0;
        return bitmaps[0].getRowBytes() * bitmaps[0].getHeight() * bitmaps.length;
    }
}
