package com.example.homework_9_10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework_9_10.R;

public class MainActivity extends AppCompatActivity {
    private EditText editA;
    private EditText editB;
    private EditText editC;
    private TextView editX1;
    private TextView editX2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.la);
        editB=findViewById(R.id.lb);
        editX1=findViewById(R.id.lans1);
        editC=findViewById(R.id.lc);
        editX2=findViewById(R.id.lans2);
    }
    private double getDoubleValue(EditText editText){
        if(editText.getText().toString().equals("")){
            editText.setText(String.valueOf(1));
            return 1;
        }
        return Double.parseDouble(editText.getText().toString());
    }
    public void click(View View){
        if(View.getId()==R.id.bub1){
            double a=getDoubleValue(editA);
            double b=getDoubleValue(editB);
            double c=getDoubleValue(editC);
            double disk=b*b-4*a*c;
            if(a==0){
                editX1.setText("x="+(-c/(double)b));
                editX2.setText("x="+(-c/(double)b));
            }
            else{
                if(disk>0){
                    editX1.setText("x1 = ("+String.format("%.4f",-b)+"-√"+String.format("%.4f",disk)+")/"+2*a+"\n"+" x2 = ("+String.format("%.4f",-b)+"+√"+String.format("%.4f",disk)+")/"+2*a);
                    editX2.setText("x1 = "+String.format("%.4f",(-b-Math.sqrt(disk))/(2*a))+"\n"+" x2 = "+String.format("%.4f",(-b+Math.sqrt(disk))/(2*a)));
                }
                else if(disk==0){
                    editX1.setText("x1 = x2 = ("+String.format("%.4f",-b)+")/"+2*a);
                    editX2.setText("x1 = x2 = "+String.format("%.4f",-b/(2*a)));
                }
                else{
                    editX1.setText("x1 = ("+String.format("%.4f",-b)+"-i√"+String.format("%.4f",-disk)+")/"+2*a+"\n"+" x2 = ("+String.format("%.4f",-b)+"+i√"+String.format("%.4f",-disk)+")/"+2*a);
                    editX2.setText("x1 = ("+String.format("%.4f",-b)+"-i√"+String.format("%.4f",-disk)+")/"+2*a+"\n"+" x2 = ("+String.format("%.4f",-b)+"+i√"+String.format("%.4f",-disk)+")/"+2*a);
                }
                Toast.makeText(this,a+" * x² + "+b+" * x = "+c,Toast.LENGTH_LONG).show();
            }
        }
        if(View.getId()== R.id.bub2){
            Toast.makeText(this,"С днем Кордана",Toast.LENGTH_SHORT).show();
        }
    }
}