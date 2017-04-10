package com.example.admin.rub1;

import android.graphics.Point;

/**
 * Created by Admin on 28.05.2016.
 */
public class Csl1 {
    //класс точек вывода поворотов граней
    Point[] point = new Point[10];
    Point point_r(int i){
        return new Point(point[i].x, point[i].y);
    }
    void Csl_c(int l, int k) {
        for (int i = 0; i < 10; i++) {
            point[i] = new Point(0, 0);
        }
        point[1].set((int) ((double) 65 / l * k), (int) ((double) 250 / l * k));
        point[2].set((int) ((double) 185 / l * k), (int) ((double) 285 / l * k));
        point[3].set((int) ((double) 345 / l * k), (int) ((double) 370 / l * k));
        point[4].set((int) ((double) 155 / l * k), (int) ((double) 145 / l * k));
        point[5].set((int) ((double) 310 / l * k), (int) ((double) 80 / l * k));
        point[6].set((int) ((double) 460 / l * k), (int) ((double) 30 / l * k));
        point[7].set((int) ((double) 65 / l * k), (int) ((double) 255 / l * k));
        point[8].set((int) ((double) 70 / l * k), (int) ((double) 450 / l * k));
        point[9].set((int) ((double) 80 / l * k), (int) ((double) 625 / l * k));
    }
}
