package com.example.admin.rub1;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.test.InstrumentationTestCase;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Admin on 18.04.2016.
 */


public class Draw extends View implements ColorPickerDialog.OnColorChangedListener {

    String strr;
    int x=100, y=100, xx, yy, xq, yq;
    Paint mPaint = new Paint();
    int[] col = new int[6];;
    int i, num;
    Bitmap mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.cub);
    Bitmap st_01, st_02,st_11,st_12,st_21,st_22;
    Bitmap st1_01 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st1);
    Bitmap st1_02 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st2);
    Bitmap st1_11 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st11);
    Bitmap st1_12 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st12);
    Bitmap st1_21 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st21);
    Bitmap st1_22 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st22);
    public boolean deistv=false;
    public int sel_col_n=7;
    public static int k, l;
    public Bitmap mBitmap2;
    boolean col_ch=false;
    boolean dra = true;
    int ch1;
    public Draw(Context context){
        super(context);
        for(i=0;i<6;i++){
            col[i]=MainActivity.colo[i];
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if ( dra) {
            xx = canvas.getWidth();
            yy = canvas.getHeight();
            l = 947;
            k = (int) (xx * 0.8);

            MainActivity.Csl_crea(l, k);
            mBitmap2 = Bitmap.createScaledBitmap(mBitmap, k, k, false);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawColor(Color.WHITE);
            for (i = 0; i < 6; i++) {
                mPaint.setColor(col[i]);
                canvas.drawRect(i * xx / 6, 0, (i + 1) * xx / 6, xx / 6, mPaint);
            }
            mPaint.setStrokeWidth(6);
            if (sel_col_n < 7) {
                mPaint.setStyle(Paint.Style.STROKE);
                mPaint.setColor(Color.BLACK);
                canvas.drawRect(sel_col_n * xx / 6, 0, (sel_col_n + 1) * xx / 6, xx / 6, mPaint);
            }
            mPaint.setColor(Color.BLACK);
            mPaint.setStyle(Paint.Style.STROKE);

            Fill();
            if (!MainActivity.scan1) {
                canvas.drawRect(0, yy * 10 / 11, xx, yy, mPaint);
                mPaint.setStrokeWidth(2);
                mPaint.setTextSize(30);
                if (!MainActivity.scan) {//+ Integer.toString((int) ((double)st1_01.getWidth()/2 / l * k))+" "+Integer.toString(st1_01.getHeight()/2)
                    canvas.drawText("Продолжить сканирование", xx / 6, (int) (yy * 13.5 / 14), mPaint);
                } else {
                    canvas.drawText("Завершить сканирование", xx / 6, (int) (yy * 13.5 / 14), mPaint);
                }
            }
            xq=(int) (xx * 0.1);
            yq=(int) ((yy - (xx / 6)) * 0.3);
            canvas.drawBitmap(mBitmap2, xq, yq, mPaint);
            if (MainActivity.resh) {
                canvas.drawRect(0, yy * 10 / 11, xx, yy, mPaint);
                mPaint.setStrokeWidth(2);
                mPaint.setTextSize(30);
                canvas.drawText("Следующий шаг", xx / 6, (int) (yy * 13.5 / 14), mPaint);
                canvas.drawText("Шаг " + Integer.toString(ch1),xx/20, xx/6+yy/30,mPaint);
                st_01=Bitmap.createScaledBitmap(st1_01,(int) ((double)st1_01.getWidth()/2 / l * k), (int) ((double)st1_01.getHeight()/2 / l * k), false);
                st_02=Bitmap.createScaledBitmap(st1_02,(int) ((double)st1_02.getWidth()/2 / l * k), (int) ((double)st1_02.getHeight()/2 / l * k), false);
                st_11=Bitmap.createScaledBitmap(st1_11,(int) ((double)st1_11.getWidth()/2 / l * k), (int) ((double)st1_11.getHeight()/2 / l * k), false);
                st_12=Bitmap.createScaledBitmap(st1_12,(int) ((double)st1_12.getWidth()/2 / l * k), (int) ((double)st1_12.getHeight()/2 / l * k), false);
                st_21=Bitmap.createScaledBitmap(st1_21,(int) ((double)st1_21.getWidth()/2 / l * k), (int) ((double)st1_21.getHeight()/2 / l * k), false);
                st_22=Bitmap.createScaledBitmap(st1_22,(int) ((double)st1_22.getWidth()/2 / l * k), (int) ((double)st1_22.getHeight()/2 / l * k), false);

                if (ch1<MainActivity.reshen.size()) {
                    if (!deistv) {
                        deistv = true;
                        switch (MainActivity.reshen.get(ch1)) {
                            case 1:
                                canvas.drawBitmap(st_01, xq + MainActivity.s1.point_r(4).x, yq + MainActivity.s1.point_r(4).y, mPaint);
                                MainActivity.F();
                                break;
                            case 2:
                                canvas.drawBitmap(st_12, xq + MainActivity.s1.point_r(3).x, yq + MainActivity.s1.point_r(3).y, mPaint);
                                MainActivity.P();
                                break;
                            case 3:
                                canvas.drawBitmap(st_11, xq + MainActivity.s1.point_r(1).x, yq + MainActivity.s1.point_r(1).y, mPaint);
                                MainActivity.L();
                                break;
                            case 4:
                                canvas.drawBitmap(st_22, xq + MainActivity.s1.point_r(7).x, yq + MainActivity.s1.point_r(7).y, mPaint);
                                MainActivity.V();
                                break;
                            case 5:
                                canvas.drawBitmap(st_21, xq + MainActivity.s1.point_r(9).x, yq + MainActivity.s1.point_r(9).y, mPaint);
                                MainActivity.N();
                                break;
                            case 6:
                                canvas.drawBitmap(st_02, xq + MainActivity.s1.point_r(6).x, yq + MainActivity.s1.point_r(6).y, mPaint);
                                MainActivity.T();
                                break;
                            case 7:
                                canvas.drawBitmap(st_02, xq + MainActivity.s1.point_r(4).x, yq + MainActivity.s1.point_r(4).y, mPaint);
                                MainActivity.F1();
                                break;
                            case 8:
                                canvas.drawBitmap(st_11, xq + MainActivity.s1.point_r(3).x, yq + MainActivity.s1.point_r(3).y, mPaint);
                                MainActivity.P1();
                                break;
                            case 9:
                                canvas.drawBitmap(st_12, xq + MainActivity.s1.point_r(1).x, yq + MainActivity.s1.point_r(1).y, mPaint);
                                MainActivity.L1();
                                break;
                            case 10:
                                canvas.drawBitmap(st_21, xq + MainActivity.s1.point_r(7).x, yq + MainActivity.s1.point_r(7).y, mPaint);
                                MainActivity.V1();
                                break;
                            case 11:
                                canvas.drawBitmap(st_22, xq + MainActivity.s1.point_r(9).x, yq + MainActivity.s1.point_r(9).y, mPaint);
                                MainActivity.N1();
                                break;
                            case 12:
                                canvas.drawBitmap(st_01, xq + MainActivity.s1.point_r(6).x, yq + MainActivity.s1.point_r(6).y, mPaint);
                                MainActivity.T1();
                                break;
                            case 15:
                                canvas.drawBitmap(st_21, xq + MainActivity.s1.point_r(8).x, yq + MainActivity.s1.point_r(8).y, mPaint);
                                MainActivity.SN();
                                break;
                            case 222:

                                break;
                        }
                    }
                }else{
                    MainActivity.tv1.setText("Готово!");
                    MainActivity.scan1 = false;
                    MainActivity.scan = false;
                    MainActivity.resh = false;
                    MainActivity.crea = false;
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                Instrumentation inst = new Instrumentation();
                                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);

                            } catch (Exception e) {
                                //Log.e("Exception when sendKeyDownUpSync", e.toString());
                            }
                        }

                    }.start();
                }
            }
        }
    }

    private void Fill() {
        FloodFill(mBitmap2, MainActivity.s.point_r(0), Color.TRANSPARENT, col[MainActivity.kub[0][1]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(1), Color.TRANSPARENT, col[MainActivity.kub[0][2]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(2), Color.TRANSPARENT, col[MainActivity.kub[0][3]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(3), Color.TRANSPARENT, col[MainActivity.kub[0][4]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(4), Color.TRANSPARENT, col[MainActivity.kub[0][5]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(5), Color.TRANSPARENT, col[MainActivity.kub[0][6]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(6), Color.TRANSPARENT, col[MainActivity.kub[0][7]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(7), Color.TRANSPARENT, col[MainActivity.kub[0][8]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(8), Color.TRANSPARENT, col[MainActivity.kub[0][9]]);

        FloodFill(mBitmap2, MainActivity.s.point_r(9), Color.TRANSPARENT, col[MainActivity.kub[2][1]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(10), Color.TRANSPARENT, col[MainActivity.kub[2][2]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(11), Color.TRANSPARENT, col[MainActivity.kub[2][3]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(12), Color.TRANSPARENT, col[MainActivity.kub[2][4]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(13), Color.TRANSPARENT, col[MainActivity.kub[2][5]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(14), Color.TRANSPARENT, col[MainActivity.kub[2][6]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(15), Color.TRANSPARENT, col[MainActivity.kub[2][7]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(16), Color.TRANSPARENT, col[MainActivity.kub[2][8]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(17), Color.TRANSPARENT, col[MainActivity.kub[2][9]]);

        FloodFill(mBitmap2, MainActivity.s.point_r(18), Color.TRANSPARENT, col[MainActivity.kub[3][1]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(19), Color.TRANSPARENT, col[MainActivity.kub[3][2]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(20), Color.TRANSPARENT, col[MainActivity.kub[3][3]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(21), Color.TRANSPARENT, col[MainActivity.kub[3][4]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(22), Color.TRANSPARENT, col[MainActivity.kub[3][5]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(23), Color.TRANSPARENT, col[MainActivity.kub[3][6]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(24), Color.TRANSPARENT, col[MainActivity.kub[3][7]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(25), Color.TRANSPARENT, col[MainActivity.kub[3][8]]);
        FloodFill(mBitmap2, MainActivity.s.point_r(26), Color.TRANSPARENT, col[MainActivity.kub[3][9]]);

    }

    private void FloodFill(Bitmap bmp, Point pt, int targetColor, int replacementColor)
    {
        Queue<Point> q = new LinkedList<Point>();
        q.add(pt);
        while (q.size() > 0) {
            Point n = q.poll();
            if (bmp.getPixel(n.x, n.y) != targetColor)
                continue;

            Point w = n, e = new Point(n.x + 1, n.y);
            while ((w.x > 0) && (bmp.getPixel(w.x, w.y) == targetColor)) {
                bmp.setPixel(w.x, w.y, replacementColor);
                if ((w.y > 0) && (bmp.getPixel(w.x, w.y - 1) == targetColor))
                    q.add(new Point(w.x, w.y - 1));
                if ((w.y < bmp.getHeight() - 1)
                        && (bmp.getPixel(w.x, w.y + 1) == targetColor))
                    q.add(new Point(w.x, w.y + 1));
                w.x--;
            }
            while ((e.x < bmp.getWidth() - 1)
                    && (bmp.getPixel(e.x, e.y) == targetColor)) {
                bmp.setPixel(e.x, e.y, replacementColor);

                if ((e.y > 0) && (bmp.getPixel(e.x, e.y - 1) == targetColor))
                    q.add(new Point(e.x, e.y - 1));
                if ((e.y < bmp.getHeight() - 1)
                        && (bmp.getPixel(e.x, e.y + 1) == targetColor))
                    q.add(new Point(e.x, e.y + 1));
                e.x++;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int)event.getX();
        y = (int)event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                if (y<xx/6) {
                    num = x / (xx / 6);
                    if (num == sel_col_n) {
                        new ColorPickerDialog(this.getContext(), this, col[num]).show();
                    } else {
                        sel_col_n = num;
                    }
                } else {
                    if (y>yy*10/11){
                        if (!MainActivity.scan) {
                            if (!MainActivity.scan1) {
                                MainActivity.OP();
                                MainActivity.OP();
                                MainActivity.OV1();
                                MainActivity.scan1 = true;
                                dra = false;
                                for(i=0;i<6;i++){
                                    MainActivity.colo[i]=col[i];
                                }
                                new Thread() {
                                    @Override
                                    public void run() {
                                        try {
                                            Instrumentation inst = new Instrumentation();
                                            inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);

                                        } catch (Exception e) {
                                            //Log.e("Exception when sendKeyDownUpSync", e.toString());
                                        }
                                    }

                                }.start();

                            } else {
                                if (!MainActivity.scan1){
                                    MainActivity.scan1 = true;
                                    dra = false;
                                    new Thread() {
                                        @Override
                                        public void run() {
                                            try {
                                                Instrumentation inst = new Instrumentation();
                                                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);

                                            } catch (Exception e) {
                                                //Log.e("Exception when sendKeyDownUpSync", e.toString());
                                            }
                                        }
                                    }.start();
                                }
                            }
                        }else{
                            if (!MainActivity.scan1) {
                                MainActivity.scan1 = true;
                                new Thread() {
                                    @Override
                                    public void run() {
                                        try {
                                            Instrumentation inst = new Instrumentation();
                                            inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                                            Main3Activity.back();
                                        } catch (Exception e) {
                                            //Log.e("Exception when sendKeyDownUpSync", e.toString());
                                        }
                                    }
                                }.start();

                            }
                        }
                        if (MainActivity.resh){
                            ch1++;
                            deistv=false;
                        }

                    }else {
                        Change_col();
                        if (!col_ch) {
                            sel_col_n = 7;
                        }
                        col_ch = false;
                    }
                }
            break;
        }
        invalidate();
        return true;
    }

    private void Change_col() {
        for (i = 0; i < 27; i++) {
            if (sel_col_n < 7) {
                int xm = x-(int)(xx*0.1);

                if (Dlina(MainActivity.s.point_r(i), new Point(xm, y - (int) ((yy - (xx / 6)) * 0.3))) < MainActivity.s.rad_r(i)) {
                    strr = Integer.toString(i);
                    if (i < 9) {
                        MainActivity.kub[0][i + 1] = sel_col_n;
                    } else {
                        MainActivity.kub[1 + (int) (i / 9)][(i % 9)+1] = sel_col_n;
                    }
                    //MainActivity.Viv();
                    col_ch = true;
                    //mBitmap.setPixel(x - (int) (xx * 0.1)+1, y - (int) ((yy - (xx / 6)) * 0.3 + 1),Color.BLACK);

                    strr = strr + "___"+Integer.toString(xm)+"++++"+Integer.toString(MainActivity.s.point_r(i).x);
                }
            }
        }
    }

    private int Dlina(Point point, Point point1) {
        int x1,y1,x2,y2, xd,yd;
        x1=point.x;
        y1=point.y;
        x2=point1.x;
        y2=point1.y;
        xd=Math.abs(x1-x2);
        yd=Math.abs(y1-y2);
        return (int)Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
    }

    @Override
    public void colorChanged(int color) {
        col[num]=color;
        invalidate();
    }
}