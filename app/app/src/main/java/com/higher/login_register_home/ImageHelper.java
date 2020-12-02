package com.higher.login_register_home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;

//_____Camera Code
// Coded By: Hilton
// Edited by:
//Tested by:

//these methods help to decrease image size for performance before loading them into the grid view
public class ImageHelper {

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if(height > reqHeight && width > reqWidth){
            final int halfHeight = height /2;
            final int halfWidth = width /2;

            while((halfHeight/inSampleSize) >= reqHeight && (halfWidth /inSampleSize)>= reqWidth){
                inSampleSize *= 2;
            }
        }
        return  inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromPath(String pathName, int reqWidth, int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pathName, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return  BitmapFactory.decodeFile(pathName, options);
    }

    public static Bitmap autoRotate(Bitmap myBitmap){

        if("samsung".contentEquals(Build.MANUFACTURER)){        //check if samsung manufacturer then rotate image, this is because for some reason
                                                                //samsung auto rotates images if the dimensions are within a specific range

            if(myBitmap != null){
                Matrix m = new Matrix();
                // clockwise
                m.postRotate(90, (float) myBitmap.getWidth() / 2,
                        (float) myBitmap.getHeight() / 2);

                Bitmap b2 = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.getWidth(),
                        myBitmap.getHeight(), m, true);

                if (myBitmap != b2) {
                    myBitmap.recycle();
                    myBitmap = b2;
                }
            }


        }
        return myBitmap;
    }
}
