package com.example.shivamkumar.tryingjave;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

public class buttonTTT extends AppCompatButton{

    private int player;

    public buttonTTT(Context context) {
        super(context);
        player=-1;
      //  setText("s");
    }
    public void setPlayer(int player){
        this.player=player;
        if(player==0)
            setText("O");
        else
            setText("X");
        setEnabled(false);
    }
    public int getPlayer(){
        return player;
    }
    public boolean isEmpty(){
        return player==-1;
    }
}
