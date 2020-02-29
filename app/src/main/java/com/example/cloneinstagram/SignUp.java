package com.example.cloneinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    EditText mName, mPunchSpeed, mPunchPower, mKickSpeed, mKickPower;
    Button mSaveDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setTitle("SIGN UP");
        mName = findViewById(R.id.name);
        mPunchSpeed = findViewById(R.id.punchspeed);
        mPunchPower = findViewById(R.id.punchpower);
        mKickSpeed = findViewById(R.id.kickspeed);
        mKickPower = findViewById(R.id.kickpower);
        mSaveDataButton = findViewById(R.id.savedatabutton);
        mSaveDataButton.setOnClickListener(SignUp.this);


    }
    public void onClick(View view) {

        try {


            final ParseObject kickboxer = new ParseObject("KickBoxer");
            kickboxer.put("name", mName.getText().toString());
            kickboxer.put("punch_speed", Integer.parseInt(mPunchSpeed.getText().toString()));
            kickboxer.put("punch_power", Integer.parseInt(mPunchPower.getText().toString()));
            kickboxer.put("kick_speed", Integer.parseInt(mKickSpeed.getText().toString()));
            kickboxer.put("kick_power", Integer.parseInt(mKickPower.getText().toString()));
            kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUp.this,
                                kickboxer.get("name")
                                        + "is saved to server",
                                FancyToast.LENGTH_LONG,
                                FancyToast.SUCCESS,true).show();
                    } else {
                        FancyToast.makeText( SignUp.this,e.getMessage(),
                                FancyToast.LENGTH_LONG,FancyToast.ERROR,
                                true).show();                    }
                }
            });
        } catch (Exception e){
            FancyToast.makeText( SignUp.this,e.getMessage(),
                    FancyToast.LENGTH_LONG,FancyToast.ERROR,
                    true).show();
        }
    }
}
