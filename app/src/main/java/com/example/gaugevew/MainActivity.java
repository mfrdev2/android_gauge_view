package com.example.gaugevew;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.ekn.gruzer.gaugelibrary.Range;
import com.example.gaugevew.databinding.ActivityMainBinding;
import com.github.anastr.speedviewlib.SpeedView;
import com.github.anastr.speedviewlib.components.Section;
import com.github.anastr.speedviewlib.components.Style;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SpeedView speedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        speedView = binding.speedometer;
        setContentView(binding.getRoot());
        initHalfGauge2();
        initSpeedMeter();
        initSection(binding.speedometer);
    }

    private void initSection(SpeedView speedView) {
        speedView.getSections().clear();
//        speedView.addSections(new Section(0f, .1f, Color.LTGRAY, speedView.dpTOpx(30f))
//                , new Section(.1f, .2f, Color.GRAY, speedView.dpTOpx(30f), Style.ROUND)
//                , new Section(.2f, .3f, Color.DKGRAY, speedView.dpTOpx(30f))
//                , new Section(.3f, .4f, Color.BLACK, speedView.dpTOpx(30f))
//                , new Section(.4f, .5f, Color.CYAN, speedView.dpTOpx(30f), Style.ROUND)
//                , new Section(.5f, .6f, Color.BLUE, speedView.dpTOpx(30f))
//                , new Section(.6f, .7f, Color.GREEN, speedView.dpTOpx(30f))
//                , new Section(.7f, .8f, Color.YELLOW, speedView.dpTOpx(30f))
//                , new Section(.8f, .9f, Color.MAGENTA, speedView.dpTOpx(30f)));

        speedView.addSections(
                new Section(0f,.5f,Color.parseColor("#FF0000"),speedView.dpTOpx(10f)),  //red
                new Section(.5f,1f,Color.parseColor("#00FF00"),speedView.dpTOpx(10f))  //green
        );

    }

    private void initSpeedMeter() {
         binding.speedometer.speedTo(30, 0);
    }


    private void initHalfGauge() {
        Range range = new Range();
        range.setColor(Color.parseColor("#ce0000"));
        range.setFrom(0.0);
        range.setTo(50.0);

        Range range2 = new Range();
        range2.setColor(Color.parseColor("#E3E500"));
        range2.setFrom(50.0);
        range2.setTo(100.0);

        Range range3 = new Range();
        range3.setColor(Color.parseColor("#00b20b"));
        range3.setFrom(100.0);
        range3.setTo(150.0);


        //add color ranges to gauge
        binding.halfGauge.addRange(range);
        binding.halfGauge.addRange(range2);
        binding.halfGauge.addRange(range3);

        //set min max and current value
        binding.halfGauge.setMinValue(0.0);
        binding.halfGauge.setMaxValue(150);
        binding.halfGauge.setValue(6);
    }

    private void initHalfGauge2() {
        Range range = new Range();
        range.setColor(Color.parseColor("#ce0000"));
        range.setFrom(0.0);
        range.setTo(30.0);

        Range range2 = new Range();
        range2.setColor(Color.parseColor("#00b20b"));
        range2.setFrom(30.0);
        range2.setTo(60.0);

        //add color ranges to gauge
        binding.halfGauge.addRange(range);
        binding.halfGauge.addRange(range2);


        //set min max and current value
        binding.halfGauge.setMinValue(0.0);
        binding.halfGauge.setMaxValue(60);
        binding.halfGauge.setValue(30);
    }
}