package com.example.admin.rub1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.List;

public class Main3Activity extends Activity {
    SurfaceView surfaceView;
    ImageView imageView;
    static Camera camera;
    Bitmap bitmap;
    FrameLayout frameLayout;
    int alpha;
    boolean bo = true;
    boolean sc = false;
    boolean flash = false;
    ToggleButton toggleButton;
    Button button;
    public static int[] point = new int[27];
    public static int[][] s_col = new int[6][3];
    int o_col=0;
    int i, u, por;
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    Camera.Parameters parameters;
    Camera.Size size;
    SurfaceHolder holder;
    SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            try {
                System.out.println(surfaceView.getWidth() + "-" + surfaceView.getHeight() + " - ");

                //camera.setParameters(parameters);
                if (cameraInfo.orientation == 0 | cameraInfo.orientation == 180){
                    size.width = imageView.getWidth();
                    size.height = imageView.getHeight();
                }else {
                    size.width = imageView.getHeight();
                    size.height = imageView.getWidth();
                }
                parameters.setPictureSize(size.width, size.height);
                parameters.setPreviewSize(size.width, size.height);
                camera.setParameters(parameters);
                camera.stopPreview();
                camera.startPreview();

                camera.setPreviewDisplay(holder);
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
    };

   // @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        imageView = (ImageView) findViewById(R.id.imageView);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        button = (Button) findViewById(R.id.button1);
        if (!getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            toggleButton.setVisibility(View.INVISIBLE);
        }
        if (!getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_AUTOFOCUS)) {
            button.setVisibility(View.INVISIBLE);
        }
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.cub));
    }

    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onResume() {
        super.onResume();
        if (MainActivity.scan & MainActivity.scan1) {
            MainActivity.bt2.setVisibility(View.VISIBLE);
            finish();
        } else {
            camera = Camera.open(0);
            camera.getCameraInfo(0, cameraInfo);
            camera.setDisplayOrientation(cameraInfo.orientation);
            parameters = camera.getParameters();
            System.out.println(parameters.getPreviewSize().width + "-" + parameters.getPreviewSize().height);
            parameters.setRotation(cameraInfo.orientation);
            parameters.setPictureFormat(ImageFormat.JPEG);
            List<Camera.Size> allSizes = parameters.getSupportedPictureSizes();
            size = allSizes.get(0); // get top size
            for (int i = 0; i < allSizes.size(); i++) {
                if (allSizes.get(i).width > size.width)
                    size = allSizes.get(i);
                System.out.println(size.width + "-" + size.height);
            }
            parameters.setPictureSize(size.width, size.height);
            if (flash) {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            } else {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            }
            camera.setParameters(parameters);
        }
        holder = surfaceView.getHolder();
        holder.addCallback(callback);
        surfaceView.destroyDrawingCache();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (camera != null) camera.release();
        camera = null;
        holder.removeCallback(callback);
        holder = null;

    }

    public void onClickLight(View v) {
        flash = ((ToggleButton) v).isChecked();
        Camera.Parameters prm = camera.getParameters();
        if (flash) {
            prm.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        } else {
            prm.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        }
        camera.setParameters(prm);
    }

    public void onClickAutoFocus(View view) {
        /*parameters = camera.getParameters();
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_FIXED);
        camera.setParameters(parameters);*/
        camera.autoFocus(new Camera.AutoFocusCallback(){
            @Override
            public void onAutoFocus(boolean success, Camera camera) {

            }
        });
    }

    public static void back() {
        if (camera != null) camera.release();
        camera = null;
    }

    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onClickScan(View v) {
        if (MainActivity.scan1) {
            if (MainActivity.scan) {
                back();
            }
            MainActivity.scan1 = false;
            MainActivity.scan = true;
            sc = true;
        }

        camera.takePicture(null, null, null, mPictureCallback);
        toggleButton.setChecked(false);
        flash = false;
        //surfaceView.setVisibility(View.INVISIBLE);
        //imageView.setImageAlpha(alpha);

    }

    private void scan() {
        int c1, c2, c3, c4, bl, re, gr, dr, dg, db, koef;
        double al;
        int l = 947;
        int k = imageView.getWidth();
        MainActivity.Csl_crea1(l, k);
        koef = 35;
        if(sc){
            o_col=6;
            for (i = 0; i < 6; i++) {
                s_col[i][0] = MainActivity.colo[i];
                s_col[i][1] = Color.green(s_col[i][0])/koef;
                s_col[i][2] = Color.blue(s_col[i][0])/koef;
                s_col[i][0] = Color.red(s_col[i][0])/koef;
            }
        }
        for (i = 0; i < 27; i++) {
            por = i;
            if (i<9){
                por = 8-i;
            }
            c1 = bitmap.getPixel(MainActivity.ss.point_r(por).x, MainActivity.ss.point_r(por).y + imageView.getHeight() / 2 - imageView.getWidth() / 2);
            c2 = bitmap.getPixel(MainActivity.ss.point_r(por).x, MainActivity.ss.point_r(por).y + 1 + imageView.getHeight() / 2 - imageView.getWidth() / 2);
            c3 = bitmap.getPixel(MainActivity.ss.point_r(por).x + 1, MainActivity.ss.point_r(por).y + imageView.getHeight() / 2 - imageView.getWidth() / 2);
            c4 = bitmap.getPixel(MainActivity.ss.point_r(por).x + 1, MainActivity.ss.point_r(por).y + 1 + imageView.getHeight() / 2 - imageView.getWidth() / 2);
            re = ((Color.red(c1)+Color.red(c2)+Color.red(c3)+Color.red(c4))/4);///64;
            gr = ((Color.green(c1)+Color.green(c2)+Color.green(c3)+Color.green(c4))/4);///64;
            bl = ((Color.blue(c1)+Color.blue(c2)+Color.blue(c3)+Color.blue(c4))/4);///64;
            al = (255/(double)(Math.max(Math.max(bl, re), gr)+1));
            //System.out.println(re + " " + gr + " " + bl+"al = "+al+" ");
            bl = (int)((double)bl*al);
            re = (int)((double)re*al);
            gr = (int)((double)gr*al);
            //System.out.print("___"+re + " " + gr + " " + bl+"___");
            bl = bl / koef;//52
            re = re / koef;
            gr = gr / koef;
            bo = true;
            for(u=0; u<o_col; u++){
                dr = Math.abs(s_col[u][0] - re);
                dg = Math.abs(s_col[u][1] - gr);
                db = Math.abs(s_col[u][2] - bl);
                if (dr + dg + db <=3){
                    point[por] = u;
                    bo = false;
                }
            }
            if (bo & o_col<6){
                s_col[o_col][0] = re;
                s_col[o_col][1] = gr;
                s_col[o_col][2] = bl;
                point[por] = o_col;
                o_col++;
            }
        }
        if(!sc) {
            for (i = 0; i < 6; i++) {
                s_col[i][0] = Color.rgb(s_col[i][0] * koef, s_col[i][1] * koef, s_col[i][2] * koef);
                MainActivity.colo[i] = s_col[i][0];
            }
        }
        for (i = 1; i < 10; i++) {
            MainActivity.kub[0][i] = point[i - 1];
        }
        for (i = 2; i < 4; i++) {
            for (u = 1; u < 10; u++) {
                MainActivity.kub[i][u] = point[(i - 1) * 9 + u - 1];
            }
        }
        bitmap.recycle();
        //BitmapDrawable bd = new BitmapDrawable(getResources(), bitmap);
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] arg0, Camera arg1) {
            bitmap = BitmapFactory.decodeByteArray(arg0, 0, arg0.length);
            //imageView.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
            scan();
        }
    };
}