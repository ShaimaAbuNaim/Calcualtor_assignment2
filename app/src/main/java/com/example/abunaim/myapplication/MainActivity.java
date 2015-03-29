package com.example.abunaim.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button bttn0,bttn1,bttn2,bttn3,bttn4,bttn5,bttn6,bttn7,bttn8,bttn9,bttnsum,bttnsub,bttndiv,bttnmul,bttnclr,bttnbck,bttneq;
    TextView rslt;
    int clear_flage=0;
    double total=0.0;
    int lastbutton=0;
    String operator="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declare the
        bttn0 = (Button) findViewById(R.id.button0);
        bttn1 = (Button) findViewById(R.id.button1);
        bttn2 = (Button) findViewById(R.id.button2);
        bttn3 = (Button) findViewById(R.id.button3);
        bttn4 = (Button) findViewById(R.id.button4);
        bttn5 = (Button) findViewById(R.id.button5);
        bttn6 = (Button) findViewById(R.id.button6);
        bttn7 = (Button) findViewById(R.id.button7);
        bttn8 = (Button) findViewById(R.id.button8);
        bttn9 = (Button) findViewById(R.id.button9);
        bttnsum = (Button) findViewById(R.id.buttonsum);
        bttnsub = (Button) findViewById(R.id.buttonsub);
        bttnmul = (Button) findViewById(R.id.buttonmul);
        bttndiv = (Button) findViewById(R.id.buttonsqr);
        bttnclr = (Button) findViewById(R.id.buttonc);
        bttnbck = (Button) findViewById(R.id.buttonbck);
        bttneq = (Button) findViewById(R.id.buttonequ);

        //declear the TextView on MainActivity

        rslt = (TextView) findViewById(R.id.txtview);

        bttn0.setOnClickListener( this);
        // bttn0.setOnClickListener( this);
        bttn1.setOnClickListener( this);
        bttn2.setOnClickListener( this);
        bttn3.setOnClickListener( this);
        bttn4.setOnClickListener( this);
        bttn5.setOnClickListener( this);
        bttn6.setOnClickListener( this);
        bttn7.setOnClickListener( this);
        bttn8.setOnClickListener( this);
        bttn9.setOnClickListener( this);
        bttnbck.setOnClickListener(this);
        bttnclr.setOnClickListener(this);
        bttnsub.setOnClickListener(this);
        bttnsum.setOnClickListener(this);
        bttndiv.setOnClickListener(this);
        bttnmul.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void shownum(String num){
        //if clear_flag=1 that mean there are numbers so clear the screen and return its value to 0 (which it mean no values on the screen)
        if(clear_flage==1){
            rslt.setText("");
            clear_flage=0;
            //if the value on screen =0 then clear the screen
        }else if (rslt.getText()=="0"){
            rslt.setText("");
            rslt.setText(rslt.getText()+num);
        }
        // if there 1 then pressed on 3 the new number will be as 1+3=13
        rslt.setText(rslt.getText()+num);

    }

    public void showoperator(String oper){
        if(lastbutton==R.id.buttonsum||lastbutton==R.id.buttonsub||lastbutton==R.id.buttonsqr||lastbutton==R.id.buttonmul){

        }
        else {
            clear_flage=1;
            int newnum=Integer.parseInt(rslt.getText().toString());

            if(operator==""||operator=="="){
                total=total;
                rslt.setText(total+"");
            }
            else if (operator=="+"){
                total=total+newnum;
                rslt.setText(total+"");
            }
            else if(operator=="-"){
                total=total-newnum;
                rslt.setText(total+"");
            }
            else if(operator=="*"){
                total=total*newnum;
                rslt.setText(total+"");
            }
            else if(operator=="/") {
                if (newnum == 0)
                    rslt.setText("Invalid value");
            }else{
                total=total/newnum;
                rslt.setText(total+"");

            }

        }



    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button0){
            shownum("0");
        }
        else  if(v.getId()==R.id.button1){
            shownum("1");
        }
        else if(v.getId()==R.id.button2){
            shownum("2");
        }
        else  if(v.getId()==R.id.button3){
            shownum("3");
        }
        else  if(v.getId()==R.id.button4){
            shownum("4");
        }
        else if(v.getId()==R.id.button5){
            shownum("5");
        }
        else  if(v.getId()==R.id.button6){
            shownum("6");
        }
        else   if(v.getId()==R.id.button7){
            shownum("7");
        }
        else  if(v.getId()==R.id.button8){
            shownum("8");
        }
        else if (v.getId()==R.id.button9){
            shownum("9");
        }
        else if (v.getId()== R.id.buttonc){
            rslt.setText("0");
            total=0.0;
        }
        else if (v.getId()== R.id.buttonbck){
            if(rslt.getText().toString().length()>0){
                int start=0;
                int end=rslt.getText().toString().length()-1;
                String bcktxt =rslt.getText().toString().substring(start,end);
                rslt.setText(bcktxt);
            }
        }
        else if (v.getId()==R.id.buttonsum){
            showoperator("+");
        }
        else if (v.getId()==R.id.buttonsub){
            showoperator("-");
        }
        else if (v.getId()==R.id.buttonmul){
            showoperator("*");
        }
        else if (v.getId()==R.id.buttonsqr){
            showoperator("/");
        }





    }


}
