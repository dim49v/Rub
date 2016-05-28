package com.example.admin.rub1;

import android.graphics.Point;

/**
 * Created by Admin on 25.05.2016.
 */
class Csl {
    Point[] point = new Point[27];
    int[] rad = new int[27];
    Point point_r(int i){
        return new Point(point[i].x, point[i].y);
    }
    int rad_r(int i){
        return rad[i];
    }
    void Csl_c(int l, int k) {
        for (int i = 0; i < 27; i++) {
            point[i] = new Point(0, 0);
        }
        point[0].set((int) ((double) 475 / l  * k), (int) ((double) 40 / l * k));
        point[1].set((int) ((double) 630 / l * k), (int) ((double) 100 / l * k));
        point[2].set((int) ((double) 790 / l * k), (int) ((double) 155 / l * k));
        point[3].set((int) ((double) 320 / l * k), (int) ((double) 95 / l * k));
        point[4].set((int) ((double) 475 / l * k), (int) ((double) 155 / l * k));
        point[5].set((int) ((double) 635 / l * k), (int) ((double) 215 / l * k));
        point[6].set((int) ((double) 155 / l * k), (int) ((double) 145 / l * k));
        point[7].set((int) ((double) 315 / l * k), (int) ((double) 215 / l * k));
        point[8].set((int) ((double) 475 / l * k), (int) ((double) 285 / l * k));

        point[9].set((int) ((double) 95 / l * k), (int) ((double) 280 / l * k));
        point[10].set((int) ((double) 230 / l * k), (int) ((double) 340 / l * k));
        point[11].set((int) ((double) 390 / l * k), (int) ((double) 425 / l * k));
        point[12].set((int) ((double) 110 / l * k), (int) ((double) 465 / l * k));
        point[13].set((int) ((double) 240 / l * k), (int) ((double) 540 / l * k));
        point[14].set((int) ((double) 400 / l * k), (int) ((double) 630 / l * k));
        point[15].set((int) ((double) 125 / l * k), (int) ((double) 640 / l * k));
        point[16].set((int) ((double) 250 / l * k), (int) ((double) 715 / l * k));
        point[17].set((int) ((double) 400 / l * k), (int) ((double) 810 / l * k));

        point[18].set((int) ((double) 560 / l * k), (int) ((double) 420 / l * k));
        point[19].set((int) ((double) 720 / l * k), (int) ((double) 340 / l * k));
        point[20].set((int) ((double) 850 / l * k), (int) ((double) 280 / l * k));
        point[21].set((int) ((double) 555 / l * k), (int) ((double) 625 / l * k));
        point[22].set((int) ((double) 705 / l * k), (int) ((double) 545 / l * k));
        point[23].set((int) ((double) 830 / l * k), (int) ((double) 470 / l * k));
        point[24].set((int) ((double) 555 / l * k), (int) ((double) 805 / l * k));
        point[25].set((int) ((double) 695 / l * k), (int) ((double) 710 / l * k));
        point[26].set((int) ((double) 815 / l * k), (int) ((double) 635 / l * k));

        rad[0] = (int)((double)50/l*k);
        rad[1] = (int)((double)50/l*k);
        rad[2] = (int)((double)55/l*k);
        rad[3] = (int)((double)55/l*k);
        rad[4] = (int)((double)55/l*k);
        rad[5] = (int)((double)55/l*k);
        rad[6] = (int)((double)60/l*k);
        rad[7] = (int)((double)55/l*k);
        rad[8] = (int)((double)60/l*k);

        rad[9] = (int)((double)50/l*k);
        rad[10] = (int)((double)70/l*k);
        rad[11] = (int)((double)80/l*k);
        rad[12] = (int)((double)53/l*k);
        rad[13] = (int)((double)70/l*k);
        rad[14] = (int)((double)78/l*k);
        rad[15] = (int)((double)53/l*k);
        rad[16] = (int)((double)65/l*k);
        rad[17] = (int)((double)65/l*k);

        rad[18] = (int)((double)80/l*k);
        rad[19] = (int)((double)75/l*k);
        rad[20] = (int)((double)55/l*k);
        rad[21] = (int)((double)75/l*k);
        rad[22] = (int)((double)65/l*k);
        rad[23] = (int)((double)50/l*k);
        rad[24] = (int)((double)60/l*k);
        rad[25] = (int)((double)60/l*k);
        rad[26] = (int)((double)55/l*k);
    }

}
