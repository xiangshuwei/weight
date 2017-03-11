package com.zhbit.www.a2weight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;

public class weght extends AppCompatActivity {
    /**Called when the activity is first created*/
    public static String sex="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*载入acticity_weight.xml Layout */
        setContentView(R.layout.activity_weght);
        /*以findViewById() 取得Button 对象，并加入onClickListener */
        Button b1 =(Button)findViewById(R.id.btn_calculate);
        b1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg) {
                EditText et =(EditText)findViewById(R.id.et_height);
                double height =Double.parseDouble(et.getText().toString());
                /*取得选择的性别*/
                RadioGroup rg=(RadioGroup)findViewById(R.id.rg_sex);
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId==R.id.rb_male){
                            sex="M";
                        }else {
                            sex="F";
                        }
                    }
                });
                /*new一个对象Intent对象，并指定class*/
                Intent intent=new Intent();
                Intent intent1 = intent.setClass(weght.this,Result.class);
                /*new 一个Bundle 对象，并将要传递的数据传入*/
                Bundle bundle=new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
                /*将Bundle对象给Intent*/
                intent.putExtras(bundle);
                /*调用Activity*/
                startActivity(intent);
            }
        });
    }
}
