package com.example.hemantbansal.subtract;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class SimpleSubtraction extends AppCompatActivity {
    private  TextView number1,number2;
    private ProgressBar progressBar;
    private Button button;
    TextView textView;
    private ImageView apple1,apple2,apple3,apple4,apple5,apple6,apple7,apple8,apple9,apples1,apples2,apples3,apples4,apples5,apples6,apples7,apples8,apples9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_subtraction);

         textView = (TextView) findViewById(R.id.answerTxt);
        button = (Button) findViewById(R.id.startPractise);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleSubtraction.this,PractiseActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        apple1=(ImageView)findViewById(R.id.apple1);
        apple2=(ImageView)findViewById(R.id.apple2);
        apple3=(ImageView)findViewById(R.id.apple3);
        apple4=(ImageView)findViewById(R.id.apple4);
        apple5=(ImageView)findViewById(R.id.apple5);
        apple6=(ImageView)findViewById(R.id.apple6);
        apple7=(ImageView)findViewById(R.id.apple7);
        apple8=(ImageView)findViewById(R.id.apple8);
        apple9=(ImageView)findViewById(R.id.apple9);
        apples1=(ImageView)findViewById(R.id.apples1);
        apples2=(ImageView)findViewById(R.id.apples2);
        apples3=(ImageView)findViewById(R.id.apples3);
        apples4=(ImageView)findViewById(R.id.apples4);
        apples5=(ImageView)findViewById(R.id.apples5);
        apples6=(ImageView)findViewById(R.id.apples6);
        apples7=(ImageView)findViewById(R.id.apples7);
        apples8=(ImageView)findViewById(R.id.apples8);
        apples9=(ImageView)findViewById(R.id.apples9);
        apple1.setVisibility(View.GONE);
        apple2.setVisibility(View.GONE);
        apple3.setVisibility(View.GONE);
        apple4.setVisibility(View.GONE);
        apple5.setVisibility(View.GONE);
        apple6.setVisibility(View.GONE);
        apple7.setVisibility(View.GONE);
        apple8.setVisibility(View.GONE);
        apple9.setVisibility(View.GONE);
        apples1.setVisibility(View.GONE);
        apples2.setVisibility(View.GONE);
        apples3.setVisibility(View.GONE);
        apples4.setVisibility(View.GONE);
        apples5.setVisibility(View.GONE);
        apples6.setVisibility(View.GONE);
        apples7.setVisibility(View.GONE);
        apples8.setVisibility(View.GONE);
        apples9.setVisibility(View.GONE);

        showinputdialog();

    }
    private void showinputdialog(){
        final Dialog dialog=new Dialog(SimpleSubtraction.this);
        View view = LayoutInflater.from(SimpleSubtraction.this).inflate(R.layout.custom_input_dialog,new LinearLayout(SimpleSubtraction.this),false);
        Button submit=(Button)view.findViewById(R.id.custom_input_dialog_submit_button);
        final EditText num1=(EditText)view.findViewById(R.id.number1input);
        final EditText num2=(EditText)view.findViewById(R.id.number2input);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(num1.getText().toString().length()>0&&num2.getText().toString().length()>0){

                            final Integer n1=Integer.parseInt(num1.getText().toString());
                            final Integer n2=Integer.parseInt(num2.getText().toString());
                            if(n1>=n2){
                                dialog.cancel();
                                vision1(n1);
                                vision2(n2);
                                Toast.makeText(SimpleSubtraction.this,"Starting Subtraction",Toast.LENGTH_LONG).show();

                              startThread(n1,n2);
                            }
                            else{
                                Toast.makeText(SimpleSubtraction.this,"Second number should be less than first",Toast.LENGTH_LONG).show();
                                num1.setText(null);
                                num2.setText(null);
                            }

                        }
                    }
                }
        );
        dialog.setContentView(view);
        dialog.setCancelable(false);
        dialog.show();
    }

    private SpannableStringBuilder drawablesApples(int n){
        SpannableStringBuilder builder=new SpannableStringBuilder();

        SpannableString ss=new SpannableString("          ");

        Drawable drawableapple= ResourcesCompat.getDrawable(getResources(),R.drawable.apple,null);
        drawableapple.setBounds(0,0,drawableapple.getIntrinsicWidth(),drawableapple.getIntrinsicHeight());
        ImageSpan applespan=new ImageSpan(drawableapple,ImageSpan.ALIGN_BOTTOM);
        for(int i=0;i<n;i++){
            ss.setSpan(applespan,i,i+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        builder.append(ss);
        return builder;

    }

    private  void vision1(int n){
     switch (n){
         case 9:apple9.setVisibility(View.VISIBLE);
         case 8:apple8.setVisibility(View.VISIBLE);
         case 7:apple7.setVisibility(View.VISIBLE);
         case 6:apple6.setVisibility(View.VISIBLE);
         case 5:apple5.setVisibility(View.VISIBLE);
         case 4:apple4.setVisibility(View.VISIBLE);
         case 3:apple3.setVisibility(View.VISIBLE);
         case 2:apple2.setVisibility(View.VISIBLE);
         case 1:apple1.setVisibility(View.VISIBLE);
             break;

     }
    }


    private  void vision2(int n){
        switch (n){
            case 9:apples9.setVisibility(View.VISIBLE);
            case 8:apples8.setVisibility(View.VISIBLE);
            case 7:apples7.setVisibility(View.VISIBLE);
            case 6:apples6.setVisibility(View.VISIBLE);
            case 5:apples5.setVisibility(View.VISIBLE);
            case 4:apples4.setVisibility(View.VISIBLE);
            case 3:apples3.setVisibility(View.VISIBLE);
            case 2:apples2.setVisibility(View.VISIBLE);
            case 1:apples1.setVisibility(View.VISIBLE);
                break;

        }
    }



    private void startThread(final int n1, final int n){

      new Thread(new Runnable() {
          @Override
          public void run() {
                int n2=n;
              try{
                  while(n2>0){
                      sleep(2000);

                  switch (n2){

                      case 1:
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {

                                  apple1.setVisibility(View.GONE);
                                  apples1.setVisibility(View.GONE);
                              }
                          });
                          break;

                      case 2:
                          runOnUiThread(new Runnable() {
                          @Override
                          public void run() {

                              apple2.setVisibility(View.GONE);
                              apples2.setVisibility(View.GONE);
                          }
                      });

                          break;
                      case 3:
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {

                                  apple3.setVisibility(View.GONE);
                                  apples3.setVisibility(View.GONE);
                              }
                          });

                          break;
                      case 4:
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {

                                  apple4.setVisibility(View.GONE);
                                  apples4.setVisibility(View.GONE);
                              }
                          });

                          break;
                      case 5:
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {


                                  apple5.setVisibility(View.GONE);
                                  apples5.setVisibility(View.GONE);
                              }
                          });
                        break;
                      case 6:
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {

                                  apple6.setVisibility(View.GONE);
                                  apples6.setVisibility(View.GONE);
                              }
                          });

                          break;
                      case 7:
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {

                                  apple7.setVisibility(View.GONE);
                                  apples7.setVisibility(View.GONE);
                              }
                          });

                          break;
                      case 8:
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {
                                  apple8.setVisibility(View.GONE);
                                  apples8.setVisibility(View.GONE);
                              }
                          });
                          break;
                      case 9:
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {
                                  apple9.setVisibility(View.GONE);
                                  apples9.setVisibility(View.GONE);

                              }
                          });

                          break;
                  }

                  n2--;

              }

                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          button.setVisibility(View.VISIBLE);
                          textView.setText("You can get the answer by counting the apples...\n\n"+"And your answer is  " +(n1-n));
                          textView.setVisibility(View.VISIBLE);
                      }
                  });





              }
              catch (InterruptedException e){
                  e.printStackTrace();
              }
          }
      }).start();





    }

}
