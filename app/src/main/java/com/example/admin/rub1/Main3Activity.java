package com.example.admin.rub1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

public class Main3Activity extends Activity{
    SurfaceView surfaceView;
    ImageView imageView;
    static Camera camera;
    Bitmap bitmap;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        imageView = (ImageView)findViewById(R.id.imageView);

        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.cub));
        surfaceView.setLayoutParams(imageView.getLayoutParams());
        imageView.setImageAlpha(150);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    camera.setPreviewDisplay(holder);
                    camera.setDisplayOrientation(90);
                    camera.startPreview();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onResume() {
        super.onResume();
        if (MainActivity.scan && MainActivity.scan1){
            MainActivity.bt2.setVisibility(View.VISIBLE);System.out.println("sfd");
            finish();
        }else {
            camera = Camera.open();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (camera != null)
            camera.release();
        camera = null;

    }

    public void onClickAutoFocus(View view) {
        Camera.AutoFocusCallback cb = null;
        camera.autoFocus(cb);
    }

    public static void back(){
        if (camera != null)
            camera.release();
        camera = null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onClickScan(View v){
        if (MainActivity.scan1){
            if (MainActivity.scan){
                back();
            }
            MainActivity.scan1 = false;
            MainActivity.scan = true;
        }
        Camera.Parameters parms = camera.getParameters();
        parms.setPictureSize(imageView.getHeight(), imageView.getWidth());
        parms.setRotation(90);
        camera.setParameters(parms);
        camera.takePicture(null, null, null, mPictureCallback);
        surfaceView.setVisibility(View.INVISIBLE);

        scan();

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }

    private void scan() {
        
    }

    Camera.PictureCallback mPictureCallback = new Camera.PictureCallback(){

        @Override
        public void onPictureTaken(byte[] arg0, Camera arg1) {
            bitmap = BitmapFactory.decodeByteArray(arg0, 0, arg0.length);
            imageView.setImageBitmap(bitmap);
        }};

}