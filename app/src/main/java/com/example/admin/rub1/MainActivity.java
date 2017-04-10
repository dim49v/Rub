package com.example.admin.rub1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static int kub[][] = new int[6][10];
    public static int kub_r[][] = new int [6][10];
    public static int dp[] = new int[9];
    public static int colo[] = new int[]{Color.CYAN, Color.BLUE, Color.GREEN, Color.rgb(230,140,0), Color.YELLOW, Color.RED, Color.TRANSPARENT};
    public static int kol_d;

    static int i, u;
    static Csl s;// = new Csl();
    static Csl ss;
    static Csl1 s1;
    public static boolean crea = false;
    public static boolean scan = false;
    public static boolean scan1 = false;
    public static boolean reshh = false;

    public static Button bt1, bt2;
    public static TextView tv1;
    public static ArrayList<Integer> reshen = new ArrayList<Integer>();

    private int main_c1, main_c, ch1, ch2, ch3, ch4;
    private int krest[][] = new int[3][4];
    private boolean bo1, q1, q2, q3;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView);
        bt1 = (Button)findViewById(R.id.button);
        bt2 = (Button)findViewById(R.id.button2);
        imageView = (ImageView) findViewById(R.id.imageView);

    }
    @Override
    protected void onResume() {
        //вывод копки "решение"
        super.onResume();
        if (scan && scan1){
            bt2.setVisibility(View.VISIBLE);
        } else {
            bt2.setVisibility(View.INVISIBLE);
        }
    }

    static void Csl_crea(int l, int k){
       if (!crea) {
            //инициализация классов
            s = new Csl();
            s.Csl_c(l, k);
            crea = true;
            s1 = new Csl1();
            s1.Csl_c(l, k);
        }
    }
    static void Csl_crea1(int l, int k){
        //инициализация классов
        ss = new Csl();
        ss.Csl_c(l, k);
    }
    public void onClick(View v){
        //расположение граней по умолчанию
        scan = false;
        scan1 = false;
        for(i=1;i<10;i++){
            for(u=0;u<6;u++){
                kub[u][i] = u;
            }
        }
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    public void onClick2(View v){
        resh();//нахождение алгоритма сборки
    }

    private void resh() {
        Viv();
        tv1.setText("Ожидание...");
        main_c = kub[0][5];
        ch1 = 0;
        bo1 = true;
        reshen.clear();
        for (i=0;i<6;i++){
            for (u=1;u<10;u++){
                kub_r[i][u] = kub[i][u];
            }
        }
        //стороны креста вниз
        while(ch1!=4) {
            ch1 = 0;
            if (kub[0][4] == main_c) {
                while (kub[1][8] == main_c | kub[5][4] == main_c) {
                    N();
                    reshen.add(5);
                }
                L();
                L();
                reshen.add(3);
                reshen.add(3);
            }
            if (kub[1][2] == main_c) {
                while (kub[1][8] == main_c | kub[5][4] == main_c) {
                    N();
                    reshen.add(5);
                }
                L();
                L();
                reshen.add(3);
                reshen.add(3);
            }
            if (kub[1][4] == main_c) {
                while (kub[1][8] == main_c | kub[5][4] == main_c) {
                    N();
                    reshen.add(5);
                }
                L1();
                reshen.add(9);
            }
            if (kub[1][6] == main_c) {
                while (kub[1][8] == main_c | kub[5][4] == main_c) {
                    N();
                    reshen.add(5);
                }
                L();
                reshen.add(3);
            }
            if (kub[0][8] == main_c) {
                while (kub[2][8] == main_c | kub[5][2] == main_c) {
                    N();
                    reshen.add(5);
                }
                F();
                F();
                reshen.add(1);
                reshen.add(1);
            }
            if (kub[2][2] == main_c) {
                while (kub[2][8] == main_c | kub[5][2] == main_c) {
                    N();
                    reshen.add(5);
                }
                F();
                F();
                reshen.add(1);
                reshen.add(1);
            }
            if (kub[2][4] == main_c) {
                while (kub[2][8] == main_c | kub[5][2] == main_c) {
                    N();
                    reshen.add(5);
                }
                F1();
                reshen.add(7);
            }
            if (kub[2][6] == main_c) {
                while (kub[2][8] == main_c | kub[5][2] == main_c) {
                    N();
                    reshen.add(5);
                }
                F();
                reshen.add(1);
            }
            if (kub[0][6] == main_c) {
                while (kub[3][8] == main_c | kub[5][6] == main_c) {
                    N();
                    reshen.add(5);
                }
                P();
                P();
                reshen.add(2);
                reshen.add(2);
            }
            if (kub[3][2] == main_c) {
                while (kub[3][8] == main_c | kub[5][6] == main_c) {
                    N();
                    reshen.add(5);
                }
                P();
                P();
                reshen.add(2);
                reshen.add(2);
            }
            if (kub[3][4] == main_c) {
                while (kub[3][8] == main_c | kub[5][6] == main_c) {
                    N();
                    reshen.add(5);
                }
                P1();
                reshen.add(8);
            }
            if (kub[3][6] == main_c) {
                while (kub[3][8] == main_c | kub[5][6] == main_c) {
                    N();
                    reshen.add(5);
                }
                P();
                reshen.add(2);
            }
            if (kub[0][2] == main_c) {
                while (kub[4][8] == main_c | kub[5][8] == main_c) {
                    N();
                    reshen.add(5);
                }
                T();
                T();
                reshen.add(6);
                reshen.add(6);
            }
            if (kub[4][2] == main_c) {
                while (kub[4][8] == main_c | kub[5][4] == main_c) {
                    N();
                    reshen.add(5);
                }
                T();
                T();
                reshen.add(6);
                reshen.add(6);
            }
            if (kub[4][4] == main_c) {
                while (kub[4][8] == main_c | kub[5][4] == main_c) {
                    N();
                    reshen.add(5);
                }
                T1();
                reshen.add(12);
            }
            if (kub[4][6] == main_c) {
                while (kub[4][8] == main_c | kub[5][4] == main_c) {
                    N();
                    reshen.add(5);
                }
                T();
                reshen.add(6);
            }

            for(i=1; i<5; i++){
                if(kub[i][8] == main_c){
                    ch1++;
                }
                if(kub[5][i*2] == main_c){
                    ch1++;
                }
            }
        }


        //сборка креста
        while (!(kub[0][2]==main_c & kub[0][4]==main_c & kub[0][6]==main_c & kub[0][8]==main_c)) {
            if (kub[0][8] != main_c) {
                main_c1 = Math.max(main_c,kub[2][5])*10 + Math.min(main_c, kub[2][5]);
                while(Math.max(kub[2][8],kub[5][2])*10 + Math.min(kub[2][8],kub[5][2])!= main_c1){N();reshen.add(5);}
                if (kub[2][8]==main_c){
                    N();P();F1();P1();
                    reshen.add(5);reshen.add(2);reshen.add(7);reshen.add(8);
                }else{
                    F();F();
                    reshen.add(1);reshen.add(1);
                }
                if(!(kub[0][2] == main_c & kub[0][4] == main_c & kub[0][6] == main_c & kub[0][8] == main_c)){
                    OV();
                    reshen.add(23);
                }
            }else{
                OV();
                reshen.add(23);
            }
        }

        //углы верхнего пояса вниз
        ch1 = 0;
        for(u=0;u<4;u++){
            if (kub[0][7]==main_c | kub[1][3]==main_c | kub[2][1]==main_c){
                if (!(kub[0][7]==main_c & kub[1][3]==kub[1][2] & kub[2][1]==kub[2][2])){
                    ch1 = 0;
                    while (kub[1][9]==main_c | kub[2][7]==main_c | kub[5][1]==main_c){
                        N();
                        reshen.add(5);
                    }
                    L();N();L1();
                    reshen.add(3);
                    reshen.add(5);
                    reshen.add(9);
                }
            }
            OV();
            reshen.add(23);
            ch1++;
        }
        for(i=0; i<ch1; i++){
            reshen.remove(reshen.size()-1);
            OV1();
        }

        //правильно расположение углов верхнего пояса

        while (!(kub[0][1]==main_c & kub[0][3]==main_c & kub[0][9]==main_c & kub[0][7]==main_c))
        {
            while (kub[0][7] == main_c) {
                OV();
                reshen.add(23);
            }
            q1 = (kub[1][9] == main_c & kub[2][7] == kub[2][5] & kub[5][1] == kub[1][5]);
            q2 = (kub[1][9] == kub[1][5] & kub[2][7] == main_c & kub[5][1] == kub[2][5]);
            q3 = (kub[1][9] == kub[2][5] & kub[2][7] == kub[1][5] & kub[5][1] == main_c);

            while (!(q1 | q2 | q3)) {
                N();
                reshen.add(5);
                q1 = (kub[1][9] == main_c & kub[2][7] == kub[2][5] & kub[5][1] == kub[1][5]);
                q2 = (kub[1][9] == kub[1][5] & kub[2][7] == main_c & kub[5][1] == kub[2][5]);
                q3 = (kub[1][9] == kub[2][5] & kub[2][7] == kub[1][5] & kub[5][1] == main_c);
            }
            if (kub[1][9] == main_c & kub[2][7] == kub[2][5] & kub[5][1] == kub[1][5]) {
                L();
                N();
                L1();
                reshen.add(3);
                reshen.add(5);
                reshen.add(9);
            }
            if (kub[1][9] == kub[1][5] & kub[2][7] == main_c & kub[5][1] == kub[2][5]) {
                F1();
                N1();
                F();
                reshen.add(7);
                reshen.add(11);
                reshen.add(1);
            }
            if (kub[1][9] == kub[2][5] & kub[2][7] == kub[1][5] & kub[5][1] == main_c) {
                F1();
                P1();
                N();
                N();
                P();
                F();
                reshen.add(7);
                reshen.add(8);
                reshen.add(5);
                reshen.add(5);
                reshen.add(2);
                reshen.add(1);
            }
        }
        //сборка среднего пояса
        main_c = kub[5][5];
        bo1 = true;
        while(!(kub[1][4] == kub[1][5] & kub[1][6] == kub[1][5] & kub[2][4] == kub[2][5] & kub[2][6] == kub[2][5] & kub[3][4] == kub[3][5] & kub[3][6] == kub[3][5] & kub[4][4] == kub[4][5] & kub[4][6] == kub[4][5])) {
            if (!bo1){
                while(kub[2][4] == kub[2][5] & kub[1][6] == kub[1][5]){
                    OV();
                    reshen.add(23);
                }
                L();N1();L1();N1();F1();N();F();
                reshen.add(3);reshen.add(11);reshen.add(9);reshen.add(11);reshen.add(7);reshen.add(5);reshen.add(1);
            }
            bo1 = false;
            u = 0;
            if(kub[1][8] != main_c & kub[5][4] != main_c) {
                u = 1;
            }else {
                if (kub[2][8] != main_c & kub[5][2] != main_c) {
                    u = 2;
                }else {
                    if (kub[3][8] != main_c & kub[5][6] != main_c) {
                        u = 3;
                    }else {
                        if (kub[4][8] != main_c & kub[5][8] != main_c) {
                            u = 4;
                        }
                    }
                }
            }
            if(u != 0) {
                main_c1 = kub[u][8];
                while (kub[2][5] != main_c1) {
                    OV();
                    reshen.add(23);
                }
                while (kub[2][8] != main_c1 | kub[5][2] == main_c) {
                    N();
                    reshen.add(5);
                }
                if (kub[5][2] == kub[1][5]) {
                    N();
                    L();
                    N1();
                    L1();
                    N1();
                    F1();
                    N();
                    F();
                    reshen.add(5);
                    reshen.add(3);
                    reshen.add(11);
                    reshen.add(9);
                    reshen.add(11);
                    reshen.add(7);
                    reshen.add(5);
                    reshen.add(1);
                } else {
                    N1();
                    P1();
                    N();
                    P();
                    N();
                    F();
                    N1();
                    F1();
                    reshen.add(11);
                    reshen.add(8);
                    reshen.add(5);
                    reshen.add(2);
                    reshen.add(5);
                    reshen.add(1);
                    reshen.add(11);
                    reshen.add(7);
                }
                bo1 = true;
            }
        }
        //переворот
        OP();
        OP();
        reshen.add(21); reshen.add(21);

        //верхний крест(без ориентирования)

        krest[0][0] = kub[0][4] + kub[1][2] - main_c;
        krest[0][1] = kub[0][8] + kub[2][2] - main_c;
        krest[0][2] = kub[0][6] + kub[3][2] - main_c;
        krest[0][3] = kub[0][2] + kub[4][2] - main_c;

        krest[1][0] = kub[1][5];
        krest[1][1] = kub[2][5];
        krest[1][2] = kub[3][5];
        krest[1][3] = kub[4][5];

        for(i=0; i<4; i++){
            for(u=0; u<4; u++){
                if(krest[0][0] == krest[1][1] & krest[0][1] == krest[1][0] & krest[0][2] == krest[1][2] & krest[0][3] == krest[1][3]){
                    ch1 = 1;  //1-поменять места 2 клетки
                    ch2 = u;
                    ch3 = i;
                }
                if(krest[0][0] == krest[1][1] & krest[0][1] == krest[1][0] & krest[0][2] == krest[1][3] & krest[0][3] == krest[1][2]){
                    ch1 = 2;  //2-поменять места 4 клетки
                    ch2 = u;
                    ch3 = i;
                }
                if(krest[0][0] == krest[1][0] & krest[0][1] == krest[1][1] & krest[0][2] == krest[1][2] & krest[0][3] == krest[1][3]){
                    ch1 = 3;  //3-все на местах
                    ch2 = u;
                    ch3 = i;
                }

                ch4 = krest[0][0];
                krest[0][0] = krest[0][1];
                krest[0][1] = krest[0][2];
                krest[0][2] = krest[0][3];
                krest[0][3] = ch4;
            }
            ch4 = krest[1][0];
            krest[1][0] = krest[1][1];
            krest[1][1] = krest[1][2];
            krest[1][2] = krest[1][3];
            krest[1][3] = ch4;
        }
        switch (ch1){
            case 1:
                for (i=0; i<ch3; i++){
                    OV();
                    reshen.add(23);
                }
                if(ch3>ch2){
                    for (i=0; i<ch3-ch2; i++){
                        V1();
                        reshen.add(10);
                    }
                }else{
                    for (i=0; i<ch2-ch3; i++){
                        V();
                        reshen.add(4);
                    }
                }
                V(); F(); P(); V(); P1(); V1(); F1();
                reshen.add(4); reshen.add(1); reshen.add(2); reshen.add(4); reshen.add(8); reshen.add(10); reshen.add(7);

                break;
            case 2:
                for (i=0; i<ch3; i++){
                    OV();
                    reshen.add(23);
                }
                if(ch3>ch2){
                    for (i=0; i<ch3-ch2; i++){
                        V1();
                        reshen.add(10);
                    }
                }else{
                    for (i=0; i<ch2-ch3; i++){
                        V();
                        reshen.add(4);
                    }
                }
                V(); F(); P(); V(); P1(); V1(); F1();
                reshen.add(4); reshen.add(1); reshen.add(2); reshen.add(4); reshen.add(8); reshen.add(10); reshen.add(7);
                V(); V();
                reshen.add(4); reshen.add(4);
                V(); F(); P(); V(); P1(); V1(); F1();
                reshen.add(4); reshen.add(1); reshen.add(2); reshen.add(4); reshen.add(8); reshen.add(10); reshen.add(7);
                V(); V();
                reshen.add(4); reshen.add(4);
                break;
            case 3:
               break;
        }
        while(kub[1][2] + kub[0][4] - main_c != kub[1][5] ) {
            V();
            reshen.add(4);
        }

        //ориентирование верхнего креста

        ch1 = 0;
        for (i=0; i<4; i++){
            ch1++;
            if (kub[0][6] != main_c){
                for (u=0; u<4; u++){
                    P(); SN();
                    reshen.add(2); reshen.add(15);
                }
                ch1 = 0;
            }
            V();
            reshen.add(4);
        }

        //выставление верхнил углов(без ориентирования)

        ch2 = 0;
        for (i=0; i<4; i++){
            if (kub[1][3] == main_c){
                ch1=Math.max(kub[0][7], kub[2][1]) * 10 + Math.min(kub[0][7], kub[2][1]);
            }else{
                if(kub[0][7] == main_c){
                    ch1=Math.max(kub[1][3], kub[2][1]) * 10 + Math.min(kub[1][3], kub[2][1]);
                }else{
                    ch1=Math.max(kub[1][3], kub[0][7]) * 10 + Math.min(kub[1][3], kub[0][7]);
                }
            }
            krest[0][i] = ch1;
            krest[1][i] = Math.max(kub[1][5], kub[2][5]) * 10 + Math.min(kub[1][5], kub[2][5]);
            if (krest[0][i] == krest[1][i]){
                ch2++;
                ch3 = i;
            }
            OV();
        }

        if(ch2 < 4) {
            if (ch2 == 1) {
                for (i = 0; i < ch3 + 1; i++) {
                    OV();
                    reshen.add(23);
                }
            } else {
                if (krest[1][3] == krest[0][0]) {
                    V1();
                    reshen.add(7);
                    po_st();
                    V();
                    reshen.add(1);
                }
                if (krest[1][3] == krest[0][1]) {
                    V();
                    reshen.add(1);
                    pr_st();
                    V1();
                    reshen.add(7);
                }
                if (krest[1][3] == krest[0][2]) {
                    V();
                    reshen.add(1);
                    pr_st();
                    V1();
                    reshen.add(7);
                }
            }
            for (i=0; i<4; i++){
                if (kub[1][3] == main_c){
                    ch1=Math.max(kub[0][7], kub[2][1]) * 10 + Math.min(kub[0][7], kub[2][1]);
                }else{
                    if(kub[0][7] == main_c){
                        ch1=Math.max(kub[1][3], kub[2][1]) * 10 + Math.min(kub[1][3], kub[2][1]);
                    }else{
                        ch1=Math.max(kub[1][3], kub[0][7]) * 10 + Math.min(kub[1][3], kub[0][7]);
                    }
                }
                krest[0][i] = ch1;
                krest[1][i] = Math.max(kub[1][5], kub[2][5]) * 10 + Math.min(kub[1][5], kub[2][5]);
                if (krest[0][i] == krest[1][i]){
                    ch2++;
                    ch3 = i;
                }
                OV();
            }
            if (krest[0][0] == krest[1][2] & krest[0][1] == krest[1][0] & krest[0][2] == krest[1][1]){
                po_st();
            }
            if (krest[0][0] == krest[1][1] & krest[0][1] == krest[1][2] & krest[0][2] == krest[1][0]){
                pr_st();
            }
        }

        //ориентирование верхних углов

        ch1 = 0;
        for (i=0; i<4; i++){
            ch1++;
            if (kub[0][9] != main_c){
                if (kub[2][3] == main_c){
                    ch2 = 1;
                }else{
                    ch2 = 2;
                }
                for (u=0; u<ch2*2; u++){
                   P(); F1(); P1(); F();
                    reshen.add(2); reshen.add(7); reshen.add(8); reshen.add(1);
                }
                ch1 = 0;
            }
            V();
            reshen.add(4);
        }

        //окончание сборки

        kol_d = reshen.size();
        System.out.println(reshen.toString());
        simply();//сокращение ходов
        System.out.println(reshen.toString());
        Viv();
        ch1 = 0;
        for(i=0; i<6; i++){
            for(u=2; u<10; u++){
                if(kub[i][u]!=kub[i][1]){
                    ch1 = 1;
                }
            }
        }
        if (ch1 == 0){
            Toast toast = Toast.makeText(this, "Full", Toast.LENGTH_LONG);toast.show();
        }else{
            Toast toast = Toast.makeText(this, "Error", Toast.LENGTH_LONG);toast.show();
        }

        reshh = true;
        for (i=0;i<6;i++){
            for (u=1;u<10;u++){
                kub[i][u] = kub_r[i][u];
            }
        }

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    private void simply() {
        //сокращение ходов
        q1 = true;
        reshen.add(111);
        reshen.add(111);
        while (q1){
            q1 = false;
            for (i=0; i<reshen.size()-2; i++){
                ch2 = 0;
                if (reshen.get(i) == reshen.get(i+1) & reshen.get(i) == reshen.get(i+2)){
                    if (reshen.get(i) < 7){
                        reshen.remove(i);
                        reshen.remove(i);
                        reshen.set(i, reshen.get(i) + 6);
                        ch2 = 1;
                    }
                    if (reshen.get(i) >= 7 & reshen.get(i) < 13 & ch2 == 0){
                        reshen.remove(i);
                        reshen.remove(i);
                        reshen.set(i, reshen.get(i) - 6);
                        ch2 = 1;
                    }
                    if (reshen.get(i) == 23 & reshen.get(i+1) == 23 & reshen.get(i+2) == 23 & ch2 == 0){
                        reshen.remove(i);
                        reshen.remove(i);
                        reshen.set(i, 24);
                    }
                    q1 = true;
                }
                if (reshen.get(i) < 7 & reshen.get(i+1)-6 == reshen.get(i)){
                    reshen.remove(i);
                    reshen.remove(i);
                    q1 = true;
                }
                if (reshen.get(i) > 7 & reshen.get(i)<13 & reshen.get(i+1)+6 == reshen.get(i)){
                    reshen.remove(i);
                    reshen.remove(i);
                    q1 = true;
                }
                if (reshen.get(i) == 23 & reshen.get(i+1) == 24 | reshen.get(i) == 24 & reshen.get(i+1) == 23){
                    reshen.remove(i);
                    reshen.remove(i);
                    q1 = true;
                }
            }
        }
        reshen.remove(reshen.size()-1);
        reshen.remove(reshen.size()-1);
    }
    //процедуры алгоритма сборки
    private void po_st() {
        P1(); F1(); L1(); F(); P(); F1(); L(); F();
        reshen.add(8); reshen.add(7); reshen.add(9); reshen.add(1); reshen.add(2); reshen.add(7); reshen.add(3); reshen.add(1);
    }
    private void pr_st() {
        F1(); L1(); F(); P1(); F1(); L(); F(); P();
        reshen.add(7); reshen.add(9); reshen.add(1); reshen.add(8); reshen.add(7); reshen.add(3); reshen.add(1); reshen.add(2);
    }
    //отладка
    static void Viv() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("        "+kub[0][1]+" "+kub[0][2]+" "+kub[0][3]);
        System.out.println("        "+kub[0][4]+" "+kub[0][5]+" "+kub[0][6]);
        System.out.println("        "+kub[0][7]+" "+kub[0][8]+" "+kub[0][9]);
        System.out.println("       "+"-------");
        for(i=1;i<5;i++){
            System.out.print(kub[i][1]+" "+kub[i][2]+" "+kub[i][3]+" "+"| ");
        }
        System.out.println();
        for(i=1;i<5;i++){
            System.out.print(kub[i][4]+" "+kub[i][5]+" "+kub[i][6]+" "+"| ");
        }
        System.out.println();
        for(i=1;i<5;i++){
            System.out.print(kub[i][7]+" "+kub[i][8]+" "+kub[i][9]+" "+"| ");
        }
        System.out.println();
        System.out.println("       "+"-------");
        System.out.println("        "+kub[5][1]+" "+kub[5][2]+" "+kub[5][3]);
        System.out.println("        "+kub[5][4]+" "+kub[5][5]+" "+kub[5][6]);
        System.out.println("        "+kub[5][7]+" "+kub[5][8]+" "+kub[5][9]);
    }
    //процедуры поворотов граней
    static void F(){
        dp[0]=kub[2][1];
        kub[2][1]=kub[2][7];
        kub[2][7]=kub[2][9];
        kub[2][9]=kub[2][3];//
        kub[2][3]=dp[0];
        dp[0]=kub[2][2];
        kub[2][2]=kub[2][4];
        kub[2][4]=kub[2][8];
        kub[2][8]=kub[2][6];//
        kub[2][6]=dp[0];

        dp[0]=kub[1][3];
        dp[1]=kub[1][6];
        dp[2]=kub[1][9];
        kub[1][3]=kub[5][1];
        kub[1][6]=kub[5][2];
        kub[1][9]=kub[5][3];//
        kub[5][1]=kub[3][7];
        kub[5][2]=kub[3][4];
        kub[5][3]=kub[3][1];//
        kub[3][7]=kub[0][9];
        kub[3][4]=kub[0][8];
        kub[3][1]=kub[0][7];//
        kub[0][9]=dp[0];
        kub[0][8]=dp[1];
        kub[0][7]=dp[2];
    }  //1
    static void F1(){
        dp[0]=kub[2][1];
        kub[2][1]=kub[2][3];
        kub[2][3]=kub[2][9];
        kub[2][9]=kub[2][7];//
        kub[2][7]=dp[0];
        dp[0]=kub[2][2];
        kub[2][2]=kub[2][6];
        kub[2][6]=kub[2][8];
        kub[2][8]=kub[2][4];//
        kub[2][4]=dp[0];

        dp[0]=kub[1][3];
        dp[1]=kub[1][6];
        dp[2]=kub[1][9];
        kub[1][3]=kub[0][9];
        kub[1][6]=kub[0][8];
        kub[1][9]=kub[0][7];//
        kub[0][9]=kub[3][7];
        kub[0][8]=kub[3][4];
        kub[0][7]=kub[3][1];//
        kub[3][7]=kub[5][1];
        kub[3][4]=kub[5][2];
        kub[3][1]=kub[5][3];//
        kub[5][1]=dp[0];
        kub[5][2]=dp[1];
        kub[5][3]=dp[2];
    } //7
    static void P(){
        dp[0]=kub[3][1];
        kub[3][1]=kub[3][7];
        kub[3][7]=kub[3][9];
        kub[3][9]=kub[3][3];//
        kub[3][3]=dp[0];
        dp[0]=kub[3][2];
        kub[3][2]=kub[3][4];
        kub[3][4]=kub[3][8];
        kub[3][8]=kub[3][6];//
        kub[3][6]=dp[0];

        dp[0]=kub[2][3];
        dp[1]=kub[2][6];
        dp[2]=kub[2][9];
        kub[2][3]=kub[5][3];
        kub[2][6]=kub[5][6];
        kub[2][9]=kub[5][9];//
        kub[5][3]=kub[4][7];
        kub[5][6]=kub[4][4];
        kub[5][9]=kub[4][1];//
        kub[4][7]=kub[0][3];
        kub[4][4]=kub[0][6];
        kub[4][1]=kub[0][9];//
        kub[0][3]=dp[0];
        kub[0][6]=dp[1];
        kub[0][9]=dp[2];
    }  //2
    static void P1(){
        dp[0]=kub[3][1];
        kub[3][1]=kub[3][3];
        kub[3][3]=kub[3][9];
        kub[3][9]=kub[3][7];//
        kub[3][7]=dp[0];
        dp[0]=kub[3][2];
        kub[3][2]=kub[3][6];
        kub[3][6]=kub[3][8];
        kub[3][8]=kub[3][4];//
        kub[3][4]=dp[0];

        dp[0]=kub[2][3];
        dp[1]=kub[2][6];
        dp[2]=kub[2][9];
        kub[2][3]=kub[0][3];
        kub[2][6]=kub[0][6];
        kub[2][9]=kub[0][9];//
        kub[0][3]=kub[4][7];
        kub[0][6]=kub[4][4];
        kub[0][9]=kub[4][1];//
        kub[4][7]=kub[5][3];
        kub[4][4]=kub[5][6];
        kub[4][1]=kub[5][9];//
        kub[5][3]=dp[0];
        kub[5][6]=dp[1];
        kub[5][9]=dp[2];
    } //8
    static void L(){
        dp[0]=kub[1][1];
        kub[1][1]=kub[1][7];
        kub[1][7]=kub[1][9];
        kub[1][9]=kub[1][3];//
        kub[1][3]=dp[0];
        dp[0]=kub[1][2];
        kub[1][2]=kub[1][4];
        kub[1][4]=kub[1][8];
        kub[1][8]=kub[1][6];//
        kub[1][6]=dp[0];

        dp[0]=kub[0][1];
        dp[1]=kub[0][4];
        dp[2]=kub[0][7];
        kub[0][1]=kub[4][9];
        kub[0][4]=kub[4][6];
        kub[0][7]=kub[4][3];//
        kub[4][9]=kub[5][1];
        kub[4][6]=kub[5][4];
        kub[4][3]=kub[5][7];//
        kub[5][1]=kub[2][1];
        kub[5][4]=kub[2][4];
        kub[5][7]=kub[2][7];//
        kub[2][1]=dp[0];
        kub[2][4]=dp[1];
        kub[2][7]=dp[2];
    }  //3
    static void L1(){
        dp[0]=kub[1][1];
        kub[1][1]=kub[1][3];
        kub[1][3]=kub[1][9];
        kub[1][9]=kub[1][7];//
        kub[1][7]=dp[0];
        dp[0]=kub[1][2];
        kub[1][2]=kub[1][6];
        kub[1][6]=kub[1][8];
        kub[1][8]=kub[1][4];//
        kub[1][4]=dp[0];

        dp[0]=kub[0][1];
        dp[1]=kub[0][4];
        dp[2]=kub[0][7];
        kub[0][1]=kub[2][1];
        kub[0][4]=kub[2][4];
        kub[0][7]=kub[2][7];//
        kub[2][1]=kub[5][1];
        kub[2][4]=kub[5][4];
        kub[2][7]=kub[5][7];//
        kub[5][1]=kub[4][9];
        kub[5][4]=kub[4][6];
        kub[5][7]=kub[4][3];//
        kub[4][9]=dp[0];
        kub[4][6]=dp[1];
        kub[4][3]=dp[2];
    } //9
    static void V(){
        dp[0]=kub[0][1];
        kub[0][1]=kub[0][7];
        kub[0][7]=kub[0][9];
        kub[0][9]=kub[0][3];//
        kub[0][3]=dp[0];
        dp[0]=kub[0][2];
        kub[0][2]=kub[0][4];
        kub[0][4]=kub[0][8];
        kub[0][8]=kub[0][6];//
        kub[0][6]=dp[0];

        dp[0]=kub[1][1];
        dp[1]=kub[1][2];
        dp[2]=kub[1][3];
        kub[1][1]=kub[2][1];
        kub[1][2]=kub[2][2];
        kub[1][3]=kub[2][3];//
        kub[2][1]=kub[3][1];
        kub[2][2]=kub[3][2];
        kub[2][3]=kub[3][3];//
        kub[3][1]=kub[4][1];
        kub[3][2]=kub[4][2];
        kub[3][3]=kub[4][3];//
        kub[4][1]=dp[0];
        kub[4][2]=dp[1];
        kub[4][3]=dp[2];
    }  //4
    static void V1(){
        dp[0]=kub[0][1];
        kub[0][1]=kub[0][3];
        kub[0][3]=kub[0][9];
        kub[0][9]=kub[0][7];//
        kub[0][7]=dp[0];
        dp[0]=kub[0][2];
        kub[0][2]=kub[0][6];
        kub[0][6]=kub[0][8];
        kub[0][8]=kub[0][4];//
        kub[0][4]=dp[0];

        dp[0]=kub[1][1];
        dp[1]=kub[1][2];
        dp[2]=kub[1][3];
        kub[1][1]=kub[4][1];
        kub[1][2]=kub[4][2];
        kub[1][3]=kub[4][3];//
        kub[4][1]=kub[3][1];
        kub[4][2]=kub[3][2];
        kub[4][3]=kub[3][3];//
        kub[3][1]=kub[2][1];
        kub[3][2]=kub[2][2];
        kub[3][3]=kub[2][3];//
        kub[2][1]=dp[0];
        kub[2][2]=dp[1];
        kub[2][3]=dp[2];
    } //10
    static void N(){
        dp[0]=kub[5][1];
        kub[5][1]=kub[5][7];
        kub[5][7]=kub[5][9];
        kub[5][9]=kub[5][3];//
        kub[5][3]=dp[0];
        dp[0]=kub[5][2];
        kub[5][2]=kub[5][4];
        kub[5][4]=kub[5][8];
        kub[5][8]=kub[5][6];//
        kub[5][6]=dp[0];

        dp[0]=kub[1][7];
        dp[1]=kub[1][8];
        dp[2]=kub[1][9];
        kub[1][7]=kub[4][7];
        kub[1][8]=kub[4][8];
        kub[1][9]=kub[4][9];//
        kub[4][7]=kub[3][7];
        kub[4][8]=kub[3][8];
        kub[4][9]=kub[3][9];//
        kub[3][7]=kub[2][7];
        kub[3][8]=kub[2][8];
        kub[3][9]=kub[2][9];//
        kub[2][7]=dp[0];
        kub[2][8]=dp[1];
        kub[2][9]=dp[2];
    }  //5
    static void N1(){
        dp[0]=kub[5][1];
        kub[5][1]=kub[5][3];
        kub[5][3]=kub[5][9];
        kub[5][9]=kub[5][7];//
        kub[5][7]=dp[0];
        dp[0]=kub[5][2];
        kub[5][2]=kub[5][6];
        kub[5][6]=kub[5][8];
        kub[5][8]=kub[5][4];//
        kub[5][4]=dp[0];

        dp[0]=kub[1][7];
        dp[1]=kub[1][8];
        dp[2]=kub[1][9];
        kub[1][7]=kub[2][7];
        kub[1][8]=kub[2][8];
        kub[1][9]=kub[2][9];//
        kub[2][7]=kub[3][7];
        kub[2][8]=kub[3][8];
        kub[2][9]=kub[3][9];//
        kub[3][7]=kub[4][7];
        kub[3][8]=kub[4][8];
        kub[3][9]=kub[4][9];//
        kub[4][7]=dp[0];
        kub[4][8]=dp[1];
        kub[4][9]=dp[2];
    } //11
    static void T(){
        dp[0]=kub[4][1];
        kub[4][1]=kub[4][7];
        kub[4][7]=kub[4][9];
        kub[4][9]=kub[4][3];//
        kub[4][3]=dp[0];
        dp[0]=kub[4][2];
        kub[4][2]=kub[4][4];
        kub[4][4]=kub[4][8];
        kub[4][8]=kub[4][6];//
        kub[4][6]=dp[0];

        dp[0]=kub[0][1];
        dp[1]=kub[0][2];
        dp[2]=kub[0][3];
        kub[0][1]=kub[3][3];
        kub[0][2]=kub[3][6];
        kub[0][3]=kub[3][9];//
        kub[3][3]=kub[5][9];
        kub[3][6]=kub[5][8];
        kub[3][9]=kub[5][7];//
        kub[5][9]=kub[1][7];
        kub[5][8]=kub[1][4];
        kub[5][7]=kub[1][1];//
        kub[1][7]=dp[0];
        kub[1][4]=dp[1];
        kub[1][1]=dp[2];
    }  //6
    static void T1(){
        dp[0]=kub[4][1];
        kub[4][1]=kub[4][3];
        kub[4][3]=kub[4][9];
        kub[4][9]=kub[4][7];//
        kub[4][7]=dp[0];
        dp[0]=kub[4][2];
        kub[4][2]=kub[4][6];
        kub[4][6]=kub[4][8];
        kub[4][8]=kub[4][4];//
        kub[4][4]=dp[0];

        dp[0]=kub[0][1];
        dp[1]=kub[0][2];
        dp[2]=kub[0][3];
        kub[0][1]=kub[1][7];
        kub[0][2]=kub[1][4];
        kub[0][3]=kub[1][1];//
        kub[1][7]=kub[5][9];
        kub[1][4]=kub[5][8];
        kub[1][1]=kub[5][7];//
        kub[5][9]=kub[3][3];
        kub[5][8]=kub[3][6];
        kub[5][7]=kub[3][9];//
        kub[3][3]=dp[0];
        kub[3][6]=dp[1];
        kub[3][9]=dp[2];
    } //12
    static void SF(){
        dp[0]=kub[0][4];
        dp[1]=kub[0][5];
        dp[2]=kub[0][6];
        kub[0][4]=kub[1][8];
        kub[0][5]=kub[1][5];
        kub[0][6]=kub[1][2];//
        kub[1][8]=kub[5][6];
        kub[1][5]=kub[5][5];
        kub[1][2]=kub[5][4];//
        kub[5][6]=kub[3][2];
        kub[5][5]=kub[3][5];
        kub[5][4]=kub[3][8];//
        kub[3][2]=dp[0];
        kub[3][5]=dp[1];
        kub[3][8]=dp[2];
    } //13
    static void SF1(){
        dp[0]=kub[0][4];
        dp[1]=kub[0][5];
        dp[2]=kub[0][6];
        kub[0][4]=kub[3][2];
        kub[0][5]=kub[3][5];
        kub[0][6]=kub[3][8];//
        kub[3][2]=kub[5][6];
        kub[3][5]=kub[5][5];
        kub[3][8]=kub[5][4];//
        kub[5][6]=kub[1][8];
        kub[5][5]=kub[1][5];
        kub[5][4]=kub[1][2];//
        kub[1][8]=dp[0];
        kub[1][5]=dp[1];
        kub[1][2]=dp[2];
    }//16
    static void SP(){
        dp[0]=kub[0][2];
        dp[1]=kub[0][5];
        dp[2]=kub[0][8];
        kub[0][2]=kub[2][2];
        kub[0][5]=kub[2][5];
        kub[0][8]=kub[2][8];//
        kub[2][2]=kub[5][2];
        kub[2][5]=kub[5][5];
        kub[2][8]=kub[5][8];//
        kub[5][2]=kub[4][8];
        kub[5][5]=kub[4][5];
        kub[5][8]=kub[4][2];//
        kub[4][8]=dp[0];
        kub[4][5]=dp[1];
        kub[4][2]=dp[2];
    } //14
    static void SP1(){
        dp[0]=kub[0][2];
        dp[1]=kub[0][5];
        dp[2]=kub[0][8];
        kub[0][2]=kub[4][8];
        kub[0][5]=kub[4][5];
        kub[0][8]=kub[4][2];//
        kub[4][8]=kub[5][2];
        kub[4][5]=kub[5][5];
        kub[4][2]=kub[5][8];//
        kub[5][2]=kub[2][2];
        kub[5][5]=kub[2][5];
        kub[5][8]=kub[2][8];//
        kub[2][2]=dp[0];
        kub[2][5]=dp[1];
        kub[2][8]=dp[2];
    }//17
    static void SN(){
        dp[0]=kub[1][4];
        dp[1]=kub[1][5];
        dp[2]=kub[1][6];
        kub[1][4]=kub[4][4];
        kub[1][5]=kub[4][5];
        kub[1][6]=kub[4][6];//
        kub[4][4]=kub[3][4];
        kub[4][5]=kub[3][5];
        kub[4][6]=kub[3][6];//
        kub[3][4]=kub[2][4];
        kub[3][5]=kub[2][5];
        kub[3][6]=kub[2][6];//
        kub[2][4]=dp[0];
        kub[2][5]=dp[1];
        kub[2][6]=dp[2];
    } //15
    static void SN1(){
        dp[0]=kub[1][4];
        dp[1]=kub[1][5];
        dp[2]=kub[1][6];
        kub[1][4]=kub[2][4];
        kub[1][5]=kub[2][5];
        kub[1][6]=kub[2][6];//
        kub[2][4]=kub[3][4];
        kub[2][5]=kub[3][5];
        kub[2][6]=kub[3][6];//
        kub[3][4]=kub[4][4];
        kub[3][5]=kub[4][5];
        kub[3][6]=kub[4][6];//
        kub[4][4]=dp[0];
        kub[4][5]=dp[1];
        kub[4][6]=dp[2];
    }//18

    static void OF(){
        F();SF();T1();
    } //19
    static void OF1(){
        F1();SF1();T();
    }//20
    static void OP(){
        P();SP();L1();
    } //21
    static void OP1(){
        P1();SP1();L();
    }//22
    static void OV(){
        V();N1();SN1();
    } //23
    static void OV1(){
        V1();N();SN();
    }//24
}

