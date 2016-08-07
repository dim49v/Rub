package com.example.admin.rub1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static int kub[][] = new int[6][10];
    public static int kub_r[][] = new int [6][10];
    public static int dp[] = new int[9];
    public static int colo[] = new int[]{Color.CYAN, Color.BLUE, Color.GREEN, Color.rgb(230,140,0), Color.YELLOW, Color.RED};
    static int i, u;
    static boolean q1,q2,q3,q4,q5;
    static Csl s;// = new Csl();
    static Csl1 s1;
    public static boolean crea = false;
    public static boolean scan = false;
    public static boolean scan1 = false;
    public static boolean reshh = false;
    public static Button bt1, bt2;
    public static TextView tv1;
    public static ArrayList<Integer> reshen = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView);
        bt1 = (Button)findViewById(R.id.button);
        bt2 = (Button)findViewById(R.id.button2);


    }
    @Override
    protected void onResume() {
        super.onResume();
        if (scan && scan1){
            bt2.setVisibility(View.VISIBLE);
        }else{
            bt2.setVisibility(View.INVISIBLE);
        }
    }

    static void Csl_crea(int l, int k){
       if (!crea) {
            s = new Csl();
            s.Csl_c(l, k);
            crea = true;
            s1 = new Csl1();
            s1.Csl_c(l,k);
        }
    }

    public void onClick(View v){
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
        resh();
    }

    private void resh() {

        Viv();
        System.out.println("   start");
        tv1.setText("Ожидание...");
        int main_c=kub[0][5];
        int main_c1;
        int ch1, ch2;
        boolean bo1 = true;
        boolean bo2 = true;
        boolean bo3 = true;
        boolean bo4 = true;

        for (i=0;i<6;i++){
            for (u=1;u<10;u++){
                kub_r[i][u] = kub[i][u];
            }
        }

        if (kub[0][4]==main_c){
            while (bo1){
                if (kub[1][8]!= main_c & kub[5][4]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            L();L();
            reshen.add(3);
            reshen.add(3);
        }
        if (kub[1][2]==main_c){
            while (bo1){
                if (kub[1][8]!= main_c & kub[5][4]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            L();L();
            reshen.add(3);
            reshen.add(3);
        }
        if (kub[1][4]==main_c){
            while (bo1){
                if (kub[1][8]!= main_c & kub[5][4]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            L1();
            reshen.add(9);
        }
        if (kub[1][6]==main_c){
            while (bo1){
                if (kub[1][8]!= main_c & kub[5][4]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            L();
            reshen.add(3);
        }

        if (kub[0][8]==main_c){
            while (bo1){
                if (kub[2][8]!= main_c & kub[5][2]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            F();F();
            reshen.add(1);
            reshen.add(1);
        }
        if (kub[2][2]==main_c){
            while (bo1){
                if (kub[2][8]!= main_c & kub[5][2]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            F();F();
            reshen.add(1);
            reshen.add(1);
        }
        if (kub[2][4]==main_c){
            while (bo1){
                if (kub[2][8]!= main_c & kub[5][2]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            F1();
            reshen.add(7);
        }
        if (kub[2][6]==main_c){
            while (bo1){
                if (kub[2][8]!= main_c & kub[5][2]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            F();
            reshen.add(1);
        }

        if (kub[0][6]==main_c){
            while (bo1){
                if (kub[3][8]!= main_c & kub[5][6]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            P();P();
            reshen.add(2);
            reshen.add(2);
        }
        if (kub[3][2]==main_c){
            while (bo1){
                if (kub[3][8]!= main_c & kub[5][6]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            P();P();
            reshen.add(2);
            reshen.add(2);
        }
        if (kub[3][4]==main_c){
            while (bo1){
                if (kub[3][8]!= main_c & kub[5][6]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            P1();
            reshen.add(8);
        }
        if (kub[3][6]==main_c){
            while (bo1){
                if (kub[3][8]!= main_c & kub[5][6]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            P();
            reshen.add(2);
        }

        if (kub[0][2]==main_c){
            while (bo1){
                if (kub[4][8]!= main_c & kub[5][8]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            T();T();
            reshen.add(6);
            reshen.add(6);
        }
        if (kub[4][2]==main_c){
            while (bo1){
                if (kub[4][8]!= main_c & kub[5][4]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            T();T();
            reshen.add(6);
            reshen.add(6);
        }
        if (kub[4][4]==main_c){
            while (bo1){
                if (kub[4][8]!= main_c & kub[5][4]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }bo1=true;
            T1();
            reshen.add(12);
        }
        if (kub[4][6]==main_c){
            while (bo1){
                if (kub[4][8]!= main_c & kub[5][4]!=main_c){
                    bo1=false;
                }else {
                    N();
                    reshen.add(5);
                }
            }
            bo1=true;
            T();
            reshen.add(6);
        }
        ch1=0;
        Viv();
        System.out.println("   4 storoni vnizu ");
        reshen.add(222);
        while (!(kub[0][2]==main_c & kub[0][4]==main_c & kub[0][6]==main_c & kub[0][8]==main_c)) {
            if (kub[0][8] != main_c) {
                //while (bo2) {
                    main_c1 = Math.max(main_c,kub[2][5])*10 + Math.min(main_c, kub[2][5]);
                    while(Math.max(kub[2][8],kub[5][2])*10 + Math.min(kub[2][8],kub[5][2])!= main_c1){N();reshen.add(5);}
                    if (kub[2][8]==main_c){
                        bo2=false;
                        N();P();F1();P1();
                        reshen.add(5);reshen.add(2);reshen.add(7);reshen.add(8);
                    }else{
                        bo2=false;
                        F();F();
                        reshen.add(1);reshen.add(1);
                    }
                    if(!(kub[0][2]==main_c & kub[0][4]==main_c & kub[0][6]==main_c & kub[0][8]==main_c)){
                        V();SN1();
                        reshen.add(4);reshen.add(21);
                    }
              //  }
               // bo2=true;
            }else{
                V();SN1();
                reshen.add(4);reshen.add(21);
            }
        }
        Viv();
        System.out.println("    krest");
        //////////////////////////////////////////////
        for(u=0;u<4;u++){
            if (kub[0][7]==main_c | kub[1][3]==main_c | kub[2][1]==main_c){
                    if (!(kub[0][7]==main_c & kub[1][3]==kub[1][2] & kub[2][1]==kub[2][2])){
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
            V();//SN1();
            reshen.add(4);
        }
        reshen.add(222);
        Viv();
        System.out.println("     ugli vnizu");
        ////////////////////////////////

        System.out.println(reshen.toString());
        //if (!(kub[0][1]==main_c && kub[0][3]==main_c && kub[0][9]==main_c && kub[0][7]==main_c))
        //{
            while (!(kub[0][1]==main_c & kub[0][3]==main_c & kub[0][9]==main_c & kub[0][7]==main_c))
            {
                //while (!(kub[1][5] == kub[1][2] && kub[2][5] == kub[2][2] && kub[3][5] == kub[3][2] && kub[4][5] == kub[4][2])) {
                //    SN();
                //    reshen.add(15);
                //}
                while (kub[0][7] == main_c) {
                    V();SN1();
                    reshen.add(4);reshen.add(21);
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
        //}

        reshh = true;
        for (i=0;i<6;i++){
            for (u=1;u<10;u++){
                kub[i][u] = kub_r[i][u];
            }
        }
        Viv();
        System.out.println(reshen.toString());
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);


    }

    static void Viv() {
        System.out.println();
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }
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
    }

    static void OF(){
        F();SF();T1();
    }
    static void OF1(){
        F1();SF1();T();
    }
    static void OP(){
        P();SP();L1();
    }
    static void OP1(){
        P1();SP1();L();
    }
    static void OV(){
        V();N1();SN1();
    }
    static void OV1(){
        V1();N();SN();
    }
}

