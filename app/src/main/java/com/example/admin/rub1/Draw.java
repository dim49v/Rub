package com.example.admin.rub1;

import android.app.Instrumentation;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Admin on 18.04.2016.
 */


public class Draw extends View implements ColorPickerDialog.OnColorChangedListener {

    String strr;
    int x=100, y=100, xx, yy, xq, yq;
    Paint mPaint = new Paint();
    int[] col = new int[7];
    int[] ost_col = new int[6];
    int[] fil = new int[28];
    int i, u, num;
    //public Bitmap mBitmap;
    Bitmap st_01, st_02, st_11, st_12, st_21, st_22, st_31, st_32, st_41;
    public boolean deistv=false;
    public int sel_col_n=7;
    public static int k, l;
    public Bitmap mBitmap2;
    boolean col_ch=false;
    boolean dra = true;
    boolean get_bitmap = true;
    int ch1, pre_col;
    public Draw(Context context){
        super(context);
        for(i=0;i<7;i++){
            col[i]=MainActivity.colo[i];
        }
        for (i=0; i<28; i++){
            fil[i] = 6;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(dra) {
            if (get_bitmap) {
                //загрузка изображений
                xx = canvas.getWidth();
                yy = canvas.getHeight();
                l = 947;
                k = (int) (xx * 0.8);
                MainActivity.Csl_crea(l, k);
                mBitmap2 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.cub), k, k, false);
                get_bitmap = false;

                st_01 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st1);
                st_01 = Bitmap.createScaledBitmap(st_01, (int) ((double) st_01.getWidth() / 2 / l * k), (int) ((double) st_01.getHeight() / 2 / l * k), false);

                st_02 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st2);
                st_02 = Bitmap.createScaledBitmap(st_02, (int) ((double) st_02.getWidth() / 2 / l * k), (int) ((double) st_02.getHeight() / 2 / l * k), false);

                st_11 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st11);
                st_11 = Bitmap.createScaledBitmap(st_11, (int) ((double) st_11.getWidth() / 2 / l * k), (int) ((double) st_11.getHeight() / 2 / l * k), false);

                st_12 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st12);
                st_12 = Bitmap.createScaledBitmap(st_12, (int) ((double) st_12.getWidth() / 2 / l * k), (int) ((double) st_12.getHeight() / 2 / l * k), false);

                st_21 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st21);
                st_21 = Bitmap.createScaledBitmap(st_21, (int) ((double) st_21.getWidth() / 2 / l * k), (int) ((double) st_21.getHeight() / 2 / l * k), false);

                st_22 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st22);
                st_22 = Bitmap.createScaledBitmap(st_22, (int) ((double) st_22.getWidth() / 2 / l * k), (int) ((double) st_22.getHeight() / 2 / l * k), false);

                st_31 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st31);
                st_31 = Bitmap.createScaledBitmap(st_31, (int) ((double) st_31.getWidth() / 2 / l * k), (int) ((double) st_31.getHeight() / 2 / l * k), false);

                st_32 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st32);
                st_32 = Bitmap.createScaledBitmap(st_32, (int) ((double) st_32.getWidth() / 2 / l * k), (int) ((double) st_32.getHeight() / 2 / l * k), false);

                st_41 = BitmapFactory.decodeResource(this.getResources(), R.drawable.st41);
                st_41 = Bitmap.createScaledBitmap(st_41, (int) ((double) st_41.getWidth() / 2 / l * k), (int) ((double) st_41.getHeight() / 2 / l * k), false);
            }
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawColor(Color.WHITE);
            //обнуление цветов
            for (i = 0; i < 6; i++) {
                ost_col[i] = 0;
            }
            //подсчет закрашеных ячеек
            for (i = 0; i < 6; i++) {
                for (u = 1; u < 10; u++) {
                    ost_col[MainActivity.kub[i][u]]++;
                }
            }
            //вывод цветов и информации по ним
            mPaint.setTextSize(30);
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
            //закраска кубика
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.BLACK);
            Fill();
            //определение этапа работы приложения
            if (!MainActivity.scan1) {

                canvas.drawRect(0, yy * 10 / 11, xx, yy, mPaint);
                mPaint.setStrokeWidth(2);
                mPaint.setTextSize(30);
                if (!MainActivity.scan) {
                    canvas.drawText("Продолжить сканирование", xx / 6, (int) (yy * 13.5 / 14), mPaint);
                } else {
                    canvas.drawText("Завершить сканирование", xx / 6, (int) (yy * 13.5 / 14), mPaint);
                    for (i = 0; i < 6; i++) {
                        mPaint.setColor(col[i]);
                        mPaint.setColor(Color.BLACK);
                        canvas.drawText(Integer.toString(ost_col[i]), i * xx / 6, xx / 12, mPaint);
                    }
                }
            }
            //вывод кубика на экран
            xq = (int) (xx * 0.1);
            yq = (int) ((yy - (xx / 6)) * 0.3);
            canvas.drawBitmap(mBitmap2, xq, yq, mPaint);
            //режим вывода сборки кубика
            if (MainActivity.reshh) {
                canvas.drawRect(0, yy * 10 / 11, xx, yy, mPaint);
                mPaint.setStrokeWidth(2);
                mPaint.setTextSize(30);
                canvas.drawText("Следующий шаг", xx / 6, (int) (yy * 13.5 / 14), mPaint);
                if (ch1 < MainActivity.reshen.size()) {
                    canvas.drawText("Шаг " + Integer.toString(ch1 + 1) + "(" + Integer.toString(MainActivity.reshen.size()) + ")", xx / 20, xx / 6 + yy / 30, mPaint);
                    //вывод каждого шага
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
                            case 18:
                                canvas.drawBitmap(st_22, xq + MainActivity.s1.point_r(8).x, yq + MainActivity.s1.point_r(8).y, mPaint);
                                MainActivity.SN1();
                                break;
                            case 21:
                                canvas.drawBitmap(st_41, xq + MainActivity.s1.point_r(1).x, yq + MainActivity.s1.point_r(1).y, mPaint);
                                MainActivity.OP();
                                break;
                            case 23:
                                canvas.drawBitmap(st_31, xq + MainActivity.s1.point_r(8).x, yq + MainActivity.s1.point_r(8).y, mPaint);
                                MainActivity.OV();
                                break;
                            case 24:
                                canvas.drawBitmap(st_32, xq + MainActivity.s1.point_r(7).x, yq + MainActivity.s1.point_r(7).y, mPaint);
                                MainActivity.OV1();
                                break;

                        }
                    }
                }
                if (ch1 > MainActivity.reshen.size()){
                    //переход в меню
                    MainActivity.tv1.setText("Готово!");
                    MainActivity.scan1 = false;
                    MainActivity.scan = false;
                    MainActivity.reshh = false;
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


    //заливка ячеек кубика в нужный цвет, если это необходимо
    private void Fill() {
        for(u=0; u<9; u++) {
            if (fil[u+1] != MainActivity.kub[0][u+1]) {
                FloodFill(mBitmap2, MainActivity.s.point_r(u),  col[fil[u+1]], col[MainActivity.kub[0][u+1]]); //col[MainActivity.kub[0][u + 1]]);
                fil[u+1] = MainActivity.kub[0][u+1];
            }
        }
        for (i=1; i<3; i++) {
            for(u=0; u<9; u++) {
                if (fil[i*9 + u + 1] != MainActivity.kub[i+1][u+1]) {
                    FloodFill(mBitmap2, MainActivity.s.point_r(i * 9 + u), col[fil[i*9 + u + 1]], col[MainActivity.kub[i+1][u+1]]); //col[MainActivity.kub[i + 1][u + 1]]);
                    fil[i*9 + u + 1] = MainActivity.kub[i+1][u+1];
                }
            }
        }
    }
    //процедура заливки
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

    //обработка нажатий
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //оперделение точки нажатия
        x = (int)event.getX();
        y = (int)event.getY();
        //определие типа нажатия
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                if (y<xx/6) {
                    //изменение базового цвета
                    num = x / (xx / 6);
                    if (num == sel_col_n) {//вызов окна изменения цвета
                        new ColorPickerDialog(this.getContext(), this, col[num]).show();
                    } else {
                        sel_col_n = num;
                    }
                } else {
                    if (y>yy*10/11){
                        if (!MainActivity.scan) {
                            if (!MainActivity.scan1) {
                                //переход к сканированию 4-6 грани
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
                                    //окончание сканирования
                                    MainActivity.scan1 = true;
                                    dra = false;
                                    new Thread() {
                                        @Override
                                        public void run() {
                                            try {
                                                Instrumentation inst = new Instrumentation();
                                                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);

                                            } catch (Exception e) {

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

                                        }
                                    }
                                }.start();

                            }
                        }
                        if (MainActivity.reshh){
                            //следующий шаг
                            ch1++;
                            deistv=false;
                        }

                    }else {
                        Change_col();//изменеие цвета ячейки
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
                //определение ячейки, в которую произведено нажатие
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
    //перерисовка ячеек при изменении базового цвета
    @Override
    public void colorChanged(int color) {
        pre_col = col[num];
        col[num] = color;
        Fill_ch();
        invalidate();
    }
    private void Fill_ch() {
        for(u=0; u<9; u++) {
            if (fil[u+1] == num) {
                FloodFill(mBitmap2, MainActivity.s.point_r(u),  pre_col, col[fil[u+1]]);
            }
        }
        for (i=1; i<3; i++) {
            for(u=0; u<9; u++) {
                if (fil[i*9 + u + 1] == num) {
                    FloodFill(mBitmap2, MainActivity.s.point_r(i * 9 + u), pre_col, col[fil[i*9 + u + 1]]);
                }
            }
        }
    }
}