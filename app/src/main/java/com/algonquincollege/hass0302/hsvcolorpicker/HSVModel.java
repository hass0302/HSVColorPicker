package com.algonquincollege.hass0302.hsvcolorpicker;

import android.graphics.Color;
import android.util.Log;

import java.util.Observable;

/**
 * Created by damian on 2017-10-26.
 * The model holds the data.
 *
 * Model HSV, based on Hue, Satuaration, and Value
 *
 * Hue is integer values in the range of 0 to 360 degrees
 * hues of red (which start at 0)
 * yellow (starting at 60)
 * green (starting at 120)
 * cyan (starting at 180)
 * blue (starting at 240)
 * magenta (starting at 300)
 * Saturation is integer value from 0 to 100 (percent)
 * Value is an integer from 0 to 100 (percent)
 *
 * @author hass0302@AlgonquinCollege.com
 * @version 1.0
 */

public class HSVModel extends Observable {

    // CLASS VARIABLES
    public static final Integer MAX_HUE = 359;
    public static final Integer MAX_SV = 100;
    public static final Integer MIN_HUE = 0;
    public static final Integer MIN_SV = 0;

    // INSTANCE VARIABLES
    private Integer hue;
    private Integer saturation;
    private Integer value;

    public HSVModel() {
        this(MAX_HUE, MAX_SV, MAX_SV);
    }

    /**
     * Convenience constructor.
     *
     * @param hue        - starting hue value
     * @param saturation - starting saturation value
     * @param value      - starting value value
     */

    public HSVModel(Integer hue, Integer saturation, Integer value) {
        super();

        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
    }

    // GET BACK TO THIS LATER
    public void asBlack()   { this.setHSV( 0,0,0); }
    public void asWhite()    { this.setHSV( 0,0,100); }
    public void asRed()      { this.setHSV( 0,100,100); }
    public void asLime()   { this.setHSV( 120,100,100); }
    public void asYellow()   { this.setHSV( 60,100,100); }
    public void asBlue()     { this.setHSV( 240,100,100); }
    public void asCyan()     { this.setHSV( 180, 100, 100); }
    public void asMagenta()  { this.setHSV( 300,100,100); }
    public void asSilver()   { this.setHSV( 0,0,75); }
    public void asGray()   { this.setHSV( 0,0,50); }
    public void asMaroon()   { this.setHSV( 0,100,50); }
    public void asOlive()   { this.setHSV( 60,100,50); }
    public void asPurple()   { this.setHSV( 300,100,50); }
    public void asTeal()   { this.setHSV( 180,100,50); }
    public void asNavy()   { this.setHSV( 240,100,50); }
    public void asGreen()    { this.setHSV( 120,100,50); }

    // Proof that my model is independent of any view.
    public static void main(String[] args) {
        HSVModel model = new HSVModel(0, 100, 100);

        Log.i("asdf", model.toString());
    }

    // GETTERS
    public Integer getHue() {
        return hue;
    }
    public Integer getSaturation() {
        return saturation;
    }

    public Integer getValue() {
        return value;
    }

    public int getColor() {
        float huef = (float) hue;
        float satf = (float) (saturation)/100f;
        float valf = (float) (value)/100f;

        return Color.HSVToColor(new float[]{huef, satf, valf});
    }

    // SETTERS
    public void setHue(Integer hue) {
        this.hue = hue;
        this.updateObservers();
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
        this.updateObservers();
    }

    public void setValue(Integer value) {
        this.value = value;
        this.updateObservers();
    }


    // Convenient setter: set H, S, V
    public void setHSV(Integer hue, Integer saturation, Integer value) {
        this.hue = hue;
        this.saturation = saturation;
        this.value = value;

        this.updateObservers();
    }

    // the model has changed!
    // broadcast the update method to all registered observers
    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return "HSV [H=" + hue + " S=" + saturation + " V=" + value + "]";
    }

}


