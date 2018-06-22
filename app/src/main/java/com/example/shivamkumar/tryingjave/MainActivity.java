package com.example.shivamkumar.tryingjave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public int SIZE=5;
    ArrayList<LinearLayout> rows;
    buttonTTT board[][];
    int currentPlayer=0;
    int currentStatus=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBoard();
        Toast.makeText(this,"started",Toast.LENGTH_SHORT).show();
      //  board[0][0].setText("p");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_select,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();


        if(id==R.id.reset)
            setBoard();
        else if(id==R.id.three)
        {
            setBoard();
            SIZE=3;
        }
        else if(id==R.id.four)
        {
            setBoard();
            SIZE=4;
        }
        else if(id==R.id.five)
        {
            setBoard();
            SIZE=5;
        }


        return super.onOptionsItemSelected(item);
    }

    public void setBoard(){
        rows = new ArrayList<>();
        board= new buttonTTT[SIZE][SIZE];


        LinearLayout rootLayout = findViewById(R.id.rootLayout);
        rootLayout.setOrientation(LinearLayout.VERTICAL);

        rootLayout.removeAllViews();
        for(int i=0;i<SIZE;i++){
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
            linearLayout.setLayoutParams(layoutParams);
            rows.add(linearLayout);
            rootLayout.addView(linearLayout);
        }

        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                buttonTTT b = new buttonTTT(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1);
                b.setLayoutParams(layoutParams);
                b.setOnClickListener(MainActivity.this);
                rows.get(i).addView(b);
                board[i][j]=b;

            }
        }

    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(this,"buttonClicked",Toast.LENGTH_SHORT).show();

        if(currentStatus!=0)
        {
            Toast.makeText(this,"Game Over",Toast.LENGTH_SHORT).show();
            return;
        }
        buttonTTT b =(buttonTTT)view;
        b.setPlayer(currentPlayer);
        togglePlayer();
        checkStatus();
    }

    public void togglePlayer() {
        if(currentPlayer==0)
            currentPlayer=1;
        else
            currentPlayer=0;
    }

    public void gameOver(){
        if(currentStatus==1)
            Toast.makeText(this,"Player X wins",Toast.LENGTH_SHORT).show();
        else if(currentStatus==2)
            Toast.makeText(this,"Player O wins",Toast.LENGTH_SHORT).show();
        else if(currentStatus==3)
            Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();

    }
    public void checkStatus(){
        //rows
        for(int i=0;i<SIZE;i++){
            int x=board[i][0].getPlayer();
            if(x==-1)
                continue;
            boolean b=true;
            for(int j=1;j<SIZE;j++){
                if(x!=board[i][j].getPlayer()){
                    b=false;
                    break;
                }
            }t
            if(b)
                updateStatus(x);
        }

        //column
    }

    public void updateStatus(int x) {
        if(x==1)
            currentStatus=1;
        else
            currentStatus=2;
        gameOver();
    }

}
