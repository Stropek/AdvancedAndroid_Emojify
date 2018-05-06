package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    private static String TAG = Emojifier.class.getName();

    public static void detectFaces(Context context, Bitmap bitmap) {

        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .setTrackingEnabled(false)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);

        String message = "Detected " + faces.size() + " faces";
        Log.i(TAG, message);
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        faceDetector.release();
    }
}
