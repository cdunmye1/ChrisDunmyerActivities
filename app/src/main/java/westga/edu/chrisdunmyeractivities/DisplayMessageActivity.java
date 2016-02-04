package westga.edu.chrisdunmyeractivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "westga.edu.chrisdunmyeractivities.MESSAGE";
    public final static String EXTRA_SECOND_MESSAGE = "westga.edu.chrisdunmyeractivities.SECOND_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        });
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(nextButtonListener);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.firstMessageTextView);
        textView.setText(message);
    }

    View.OnClickListener nextButtonListener=
            new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DisplayMessageActivity.this, DisplayBothMessagesActivity.class);
                    EditText secondMessage = (EditText) findViewById(R.id.secondMessage);
                    String secondMessageString = secondMessage.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
                    intent.putExtra(EXTRA_SECOND_MESSAGE, secondMessageString);
                    startActivity(intent);
                }
            };
}
