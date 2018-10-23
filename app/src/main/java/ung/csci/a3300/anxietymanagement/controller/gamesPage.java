package ung.csci.a3300.anxietymanagement.controller;

import android.app.Activity;
import android.widget.TextView;
import ung.csci.a3300.anxietymanagement.R;


public class gamesPage extends Activity {

        String[] Games = {"Proteus","Abzu","Journey","Farming Simulator", "Meadow"};
        TextView text = (TextView) findViewById(R.id.text_display);
        //Button button = (Button) findViewById(R.id.button_gamepage);

        public String getGame(){
            int value = (int)(Math.random()* Games.length)-1;
            String game = Games[value];
            return game;

        }
        public void buttonClickGamepage(){
            String game = getGame();
            text.setText("have you tried playing " + game + "?");

        }



    }

