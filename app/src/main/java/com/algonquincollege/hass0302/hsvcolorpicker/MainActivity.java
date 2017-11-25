package com.algonquincollege.hass0302.hsvcolorpicker;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

/**
 *  Purpose/Description HSV Color Picker, MIDTERM
 *  @author Damian Ha (hass0302@algonquinlive.com)
 */

public class MainActivity extends Activity implements Observer, SeekBar.OnSeekBarChangeListener {
    // CLASS VARIABLES
    private static final String ABOUT_DIALOG_TAG = "About";
    private static final String LOG_TAG = "ASDF";

    // INSTANCE VARIABLES
    private TextView mColorSwatch;
    private HSVModel mModel;
    private SeekBar mHueSB;
    private SeekBar mSaturationSB;
    private SeekBar mValueSB;
    private TextView mHueTV;
    private TextView mSaturationTV;
    private TextView mValueTV;
    private Button mblackButton;
    private Button mredButton;
    private Button mlimeButton;
    private Button mblueButton;
    private Button myellowButton;
    private Button mcyanButton;
    private Button mmagentaButton;
    private Button msilverButton;
    private Button mgrayButton;
    private Button mmaroonButton;
    private Button moliveButton;
    private Button mgreenButton;
    private Button mpurpleButton;
    private Button mtealButton;
    private Button mnavyButton;
    private Button mwhiteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(getResources().getString(R.string.app_name), Context.MODE_PRIVATE);

        // Instantiate a new AboutDialogFragment()
        // but do not show it (yet)
        // mAboutDialog = new AboutDialogFragment();

        // Instantiate a new HSV model and defaults to Black.
        mModel = new HSVModel(settings.getInt("hue", 0),
                settings.getInt("saturation", 0),
                settings.getInt("value", 0));

        // reference each View
        mColorSwatch = (TextView) findViewById(R.id.colorSwatch);
        mHueSB = (SeekBar) findViewById(R.id.hueSB);
        mSaturationSB = (SeekBar) findViewById(R.id.saturationSB);
        mValueSB = (SeekBar) findViewById(R.id.valueSB);
        mHueTV = (TextView) findViewById(R.id.hueTV);
        mSaturationTV = (TextView) findViewById(R.id.saturationTV);
        mValueTV = (TextView) findViewById(R.id.valueTV);

        // reference each Button
        mblackButton = (Button) findViewById(R.id.blackButton);
        mblueButton = (Button) findViewById(R.id.blueButton);
        mcyanButton = (Button) findViewById(R.id.cyanButton);
        mgrayButton = (Button) findViewById(R.id.grayButton);
        mgreenButton = (Button) findViewById(R.id.greenButton);
        mlimeButton = (Button) findViewById(R.id.limeButton);
        mmagentaButton = (Button) findViewById(R.id.magentaButton);
        mmaroonButton = (Button) findViewById(R.id.maroonButton);
        mnavyButton = (Button) findViewById(R.id.navyButton);
        moliveButton = (Button) findViewById(R.id.oliveButton);
        mpurpleButton = (Button) findViewById(R.id.purpleButton);
        mredButton = (Button) findViewById(R.id.redButton);
        msilverButton = (Button) findViewById(R.id.silverButton);
        mtealButton = (Button) findViewById(R.id.tealButton);
        myellowButton = (Button) findViewById(R.id.yellowButton);
        mwhiteButton = (Button) findViewById(R.id.whiteButton);

        // set the domain (i.e. max) for each component
        mHueSB.setMax(HSVModel.MAX_HUE);
        mSaturationSB.setMax(HSVModel.MAX_SV);
        mValueSB.setMax(HSVModel.MAX_SV);

        // register the event handler for each <SeekBar>
        mHueSB.setOnSeekBarChangeListener(this);
        mSaturationSB.setOnSeekBarChangeListener(this);
        mValueSB.setOnSeekBarChangeListener(this);

        // register all onClick listeners for each <Button>
        mblackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asBlack();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mredButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asRed();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mblueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asBlue();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mwhiteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asWhite();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mcyanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asCyan();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mgrayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asGray();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mgreenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asGreen();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        msilverButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asSilver();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mlimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asLime();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mmagentaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asMagenta();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mmaroonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asMaroon();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mnavyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asNavy();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        moliveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asOlive();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mpurpleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asPurple();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        mtealButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asTeal();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        myellowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asYellow();
                mHueSB.setProgress(mModel.getHue());
                mSaturationSB.setProgress(mModel.getSaturation());
                mValueSB.setProgress(mModel.getValue());
                mColorSwatch.setBackgroundColor(mModel.getColor());
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        // when the Color Swatch is clicked. it will display the HSV Value
        mColorSwatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String msg = "H: " + mModel.getHue() + " S: " + mModel.getSaturation() + " V: " + mModel.getValue() + "%";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        // initialize the View to the values of the Model
        this.updateView();
    }


    /**
     * Menu Dialog for About this Application.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Event handler for the <SeekBar>s: red, green, blue, and alpha.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if (fromUser == false) {
            return;
        }

        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mModel.setHue(mHueSB.getProgress());
                mHueTV.setText(getResources().getString(R.string.hueProgress, progress).toUpperCase());
                break;
            case R.id.saturationSB:
                mModel.setSaturation(mSaturationSB.getProgress());
                mSaturationTV.setText(getResources().getString(R.string.saturationProgress, progress).toUpperCase());
                break;
            case R.id.valueSB:
                mModel.setValue(mValueSB.getProgress());
                mValueTV.setText(getResources().getString(R.string.valueProgress, progress).toUpperCase());
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mColorSwatch.setBackgroundColor(mModel.getColor());
                break;
            case R.id.saturationSB:
                mColorSwatch.setBackgroundColor(mModel.getColor());
                break;
            case R.id.valueSB:
                mColorSwatch.setBackgroundColor(mModel.getColor());
                break;
        }
    }

    // The Model has changed state!
    // Refresh the View to display the current values of the Model.
    @Override
    public void update(Observable observable, Object data) {

        this.updateView();
    }

    private void updateHueSB() {
        mHueSB.setProgress(mModel.getHue());
    }

    private void updateColorSwatch() {
        //GET the model's HSV values, and SET the background colour of the swatch <TextView>
        mColorSwatch.setBackgroundColor(mModel.getColor());
    }

    private void updateSaturationSB() {
        //TODO: set the greenSB's progress to the model's green value
        mSaturationSB.setProgress(mModel.getSaturation());
    }

    private void updateValueSB() {
        //GET the model's red value, and SET the red <SeekBar>
        mValueSB.setProgress(mModel.getValue());
    }

    // synchronize each View component with the Model
    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();
    }

    // Remember the user's settings for RGBA
    @Override
    protected void onStop() {
        super.onStop();

        // We need an Editor object to make preference changes.
        SharedPreferences settings = getSharedPreferences(getResources().getString(R.string.app_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putInt("hue", mModel.getHue());
        editor.putInt("saturation", mModel.getSaturation());
        editor.putInt("value", mModel.getValue());

        // Commit the edits!
        editor.commit();
    }
}   // end of class
