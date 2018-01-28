package xyz.anata.lightweightconcrete;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final double sur = 0.05;
    public double comS(View view){
        double M1,M2,mTotal,comTotal;
        EditText m1,m2,m3;
        TextView comR = (TextView) findViewById(R.id.comR);
        m1= (EditText) findViewById(R.id.max1);
        m2 =(EditText) findViewById(R.id.max2);
        if(m1.getText().toString().isEmpty()||m2.getText().toString().isEmpty()){
            comR.setText("โปรดใส่ให้ครบ");
            comR.setTextColor(Color.RED);
            comR.setVisibility(View.VISIBLE);
            return 0;
        }else{
            M1=Double.parseDouble(m1.getText().toString());
            M2=Double.parseDouble(m2.getText().toString());
            mTotal=(M1+M2)/2;
            comTotal=((mTotal*1000)/(Math.pow(sur,2)))/Math.pow(10,6);
            comR.setText(String.format( "%.2f", comTotal ));
            comR.setTextColor(Color.BLUE);
            comR.setVisibility(View.VISIBLE);
            return comTotal;
        }
    }
    public double densityS(View view){
        double DB1,DB2,DB3,dTotal;
        EditText db1,db2;
        db1= (EditText) findViewById(R.id.dye1);
        db2 =(EditText) findViewById(R.id.dye2);
        TextView dyR = (TextView) findViewById(R.id.dyeR);
        if(db1.getText().toString().isEmpty()||db2.getText().toString().isEmpty()){
            dyR.setText("โปรดใส่ให้ครบ");
            dyR.setTextColor(Color.RED);
            return 0;
        }else{
            DB1=Double.parseDouble(db1.getText().toString());
            DB2=Double.parseDouble(db2.getText().toString());
            dTotal=((DB1+DB2)/2)/(Math.pow(sur,3));
            dyR.setText(String.format( "%.2f", dTotal ));
            dyR.setTextColor(Color.BLUE);
            return dTotal;
        }

    }
    public void classy (View view,double density,double comPress,double water) {
        int classNum;
        String cPass,wPass;
        TextView cR = (TextView) findViewById(R.id.cR);
        TextView tis1 = (TextView) findViewById(R.id.tis1);
        TextView tis2 = (TextView) findViewById(R.id.tis2);
        if (density == 0) {
            cR.setText("-");
        } else {
            if (density >= 501 && density <= 600) {
                classNum = 6;
                cPass=comPress>=2.0?"Pass":"Not Pass";
                wPass=water<=25?"Pass":"Not Pass";
            } else if (density >= 601 && density <= 700) {
                classNum = 7;
                cPass=comPress>=2.0?"Pass":"Not Pass";
                wPass=water<=25?"Pass":"Not Pass";
            } else if (density >= 701 && density <= 800) {
                classNum = 8;
                cPass=comPress>=2.0?"Pass":"Not Pass";
                wPass=water<=25?"Pass":"Not Pass";
            } else if (density >= 801 && density <= 900) {
                classNum = 9;
                cPass=comPress>=2.5?"Pass":"Not Pass";
                wPass=water<=23?"Pass":"Not Pass";
            } else if (density >= 901 && density <= 1000) {
                classNum = 10;
                cPass=comPress>=2.5?"Pass":"Not Pass";
                wPass=water<=23?"Pass":"Not Pass";
            } else if (density >= 1001 && density <= 1200) {
                classNum = 12;
                cPass=comPress>=2.5?"Pass":"Not Pass";
                wPass=water<=23?"Pass":"Not Pass";
            } else if (density >= 1201 && density <= 1400) {
                classNum = 14;
                cPass=comPress>=5.0?"Pass":"Not Pass";
                wPass=water<=20?"Pass":"Not Pass";
            } else if (density >= 1401 && density <= 1600) {
                cPass=comPress>=5.0?"Pass":"Not Pass";
                classNum = 16;
                wPass=water<=20?"Pass":"Not Pass";
            } else {
                cR.setText("ไม่ใช่อิฐมวลเบา");
                cR.setTextColor(Color.RED);
                return;
            }
            cR.setText("C" + classNum);
            cR.setTextColor(Color.BLUE);
            cR.setVisibility(View.VISIBLE);
            if(cPass.equals("Pass")){
                tis1.setText("Pass");
                tis1.setTextColor(Color.BLUE);
            }else {
                tis1.setText("Not Pass");
                tis1.setTextColor(Color.RED);
            }
            if(wPass.equals("Pass")){
                tis2.setText("Pass");
                tis2.setTextColor(Color.BLUE);
            }else {
                tis2.setText("Not Pass");
                tis2.setTextColor(Color.RED);
            }
        }
    }
    public double waterR(View view){
        double A1,A2,W1,W2,m2,m1,a;
        EditText a1,a2,w1,w2;
        TextView waterR = (TextView) findViewById(R.id.waterR);
        a1= (EditText) findViewById(R.id.hr1);
        a2 =(EditText) findViewById(R.id.hr2);
        w1= (EditText) findViewById(R.id.hrs1);
        w2 =(EditText) findViewById(R.id.hrs2);
        if(a1.getText().toString().isEmpty()||a2.getText().toString().isEmpty()||w1.getText().toString().isEmpty()||w2.getText().toString().isEmpty()){
            waterR.setText("โปรดใส่ให้ครบ");
            waterR.setTextColor(Color.RED);
            return 0;
        }else{
            A1=Double.parseDouble(a1.getText().toString());
            A2=Double.parseDouble(a2.getText().toString());
            W1=Double.parseDouble(w1.getText().toString());
            W2=Double.parseDouble(w2.getText().toString());
            m1=(A1+A2)/2;
            m2=(W1+W2)/2;
            a=((m2-m1)/m1)*100;
            waterR.setText(String.format( "%.2f", a )+"%");
            waterR.setTextColor(Color.BLUE);
            return a;
        }
    }
    public void calCu(View view){
        double comPress= comS(view);
        double density = densityS(view);
        double water = waterR(view);
        classy(view,density,comPress,water);
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
