package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button topButton;
    private Button bottomButton;
    private TextView storyText;
    private int storyIndex = 0;
    private int[] storyOptions = { R.string.T1_Story, R.string.T2_Story, R.string.T3_Story,
                                    R.string.T4_End, R.string.T5_End, R.string.T6_End };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        topButton = (Button) findViewById(R.id.buttonTop);
        bottomButton = (Button) findViewById(R.id.buttonBottom);
        storyText = (TextView) findViewById(R.id.storyTextView);

        if (savedInstanceState != null){
            storyIndex = savedInstanceState.getInt("storyIndex");
            updateStory(storyIndex);
            updateButtons(storyIndex);
        }
        
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(storyIndex)
                {
                    case 0:
                    case 1:
                        storyIndex = 2;
                        break;
                    case 2:
                        storyIndex = 5;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        storyIndex = 0;
                        break;
                }
                updateStory(storyIndex);
                updateButtons(storyIndex);

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(storyIndex)
                {
                    case 0:
                        storyIndex = 1;
                        break;
                    case 1:
                        storyIndex = 3;
                        break;
                    case 2:
                        storyIndex = 4;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        finish();
                        break;
                }
                updateStory(storyIndex);
                updateButtons(storyIndex);
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("storyIndex", storyIndex);
    }

    private void updateStory(int storyIndex){
        storyText.setText(storyOptions[storyIndex]);
    }

    private void updateButtons(int storyIndex){
        switch (storyIndex)
        {
            case 0:
                topButton.setText(R.string.T1_Ans1);
                bottomButton.setText(R.string.T1_Ans2);
                break;
            case 1:
                topButton.setText(R.string.T2_Ans1);
                bottomButton.setText(R.string.T2_Ans2);
                break;
            case 2:
                topButton.setText(R.string.T3_Ans1);
                bottomButton.setText(R.string.T3_Ans2);
                break;
            case 3:
            case 4:
            case 5:
            default:
                topButton.setText("Replay");
                bottomButton.setText("Close Application");
                break;
        }

    }
}
