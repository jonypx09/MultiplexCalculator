package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class VolumeConverter {

    private TextView volumeTextInput;
    private TextView volumeTextOutput;
    private Spinner volumeOptionsIn;
    private Spinner volumeOptionsOut;
    private BigDecimal mainResult;

    public VolumeConverter (TextView volumeTextInput, TextView volumeTextOutput, Spinner volumeOptionsIn, Spinner volumeOptionsOut){
        super();
        this.volumeTextInput = volumeTextInput;
        this.volumeTextOutput = volumeTextOutput;
        this.volumeOptionsIn = volumeOptionsIn;
        this.volumeOptionsOut = volumeOptionsOut;
        volumeOptionsIn.setSelection(0,false);
        volumeOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        volumeOptionsOut.setSelection(0,false);
        volumeOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void checkInSelection(){
        String textInput = volumeTextInput.getText().toString().replace(",", "");
        switch(volumeOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromCubicCentimetres(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 1:
                convertFromCubicFeet(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 2:
                convertFromCubicInches(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 3:
                convertFromCubicMetres(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 4:
                convertFromCubicYards(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 5:
                convertFromCups(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 6:
                convertFromFluidOuncesUS(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 7:
                convertFromFluidOuncesUK(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 8:
                convertFromGallonsUS(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 9:
                convertFromGallonsUK(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 10:
                convertFromLitres(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 11:
                convertFromMillilitres(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 12:
                convertFromPintsUS(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 13:
                convertFromPintsUK(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 14:
                convertFromQuartsUS(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 15:
                convertFromQuartsUK(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 16:
                convertFromTablespoonsUS(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 17:
                convertFromTeaspoonsUS(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 18:
                convertFromTablespoonsUK(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
            case 19:
                convertFromTeaspoonsUK(textInput, volumeOptionsOut.getSelectedItemPosition(), volumeTextOutput);
                break;
        }
    }

    public void convertFromCubicCentimetres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                output.setText(input);
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.0000353147)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0610237441).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001308).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0042267528).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0338140227).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0351950797).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0002641721).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0002199692).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0021133764).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001759754).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0010566882).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000879877).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0676280454).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2028841362).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0563121276).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1689363827).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromCubicFeet(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 28316.846592)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                output.setText(input);
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1728).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0283168466).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.037037037).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 119.68831169).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 957.50649351).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 996.61367345).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 7.4805194805).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6.228835459).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 28.316846592).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 28316.846592).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 59.844155844).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 49.830683672).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 29.922077922).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 24.915341836).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1915.012987).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 5745.038961).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1594.5818775).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4783.7456325).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 1){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromCubicInches(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 16.387064)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0005787037).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                output.setText(input);
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000163871).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000214335).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0692640693).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5541125541).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.576744024).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0043290043).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0036046501).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.016387064).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 16.387064).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0346320346).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0288372012).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0173160173).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0144186006).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.1082251082).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.3246753247).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.9227904384).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.7683713151).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 2){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromCubicMetres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 1000000)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 35.314666721).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 61023.744095).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                output.setText(input);
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.3079506193).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4226.7528377).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 33814.022702).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 35195.079728).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 264.17205236).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 219.9692483).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2113.3764189).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1759.7539864).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1056.6882094).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 879.8769932).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 67628.045404).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 202884.13621).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 56312.127565).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 168936.38269).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 3){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromCubicYards(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 764554.85798)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 27).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 46656).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.764554858).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                output.setText(input);
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3231.5844156).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 25852.675325).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 26908.569183).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 201.97402597).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 168.17855739).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 764.55485798).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 764554.85798).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1615.7922078).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1345.4284592).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 807.8961039).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 672.71422958).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 51705.350649).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 155116.05195).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 43053.710693).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 129161.13208).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 4){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromCups(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 236.5882365)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0083550347).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 14.4375).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0002365882).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0003094457).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                output.setText(input);
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 8.3267418463).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0520421365).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2365882365).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 236.5882365).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.4163370923).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.25).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2081685462).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 16).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 48).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 13.322786954).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 39.968360862).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 5){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromFluidOuncesUS(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 29.573529562)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0010443793).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.8046875).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000295735).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000386807).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                output.setText(input);
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.0408427308).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0078125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0065052671).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0295735296).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 29.573529562).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0520421365).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.03125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0260210683).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.6653483693).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4.9960451078).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 6){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromFluidOuncesUK(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 28.4130625)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0010033978).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.7338714549).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000284131).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000371629).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1200949926).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.9607599404).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                output.setText(input);
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.007505937).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0284130625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 28.4130625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0600474963).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.05).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0300237481).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.025).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.9215198808).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 5.7645596424).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.6).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4.8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 7){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromGallonsUS(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 3785.411784)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1336805556).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 231).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0037854118).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0049511317).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 16).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 128).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 133.22786954).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                output.setText(input);
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8326741846).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.785411784).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3785.411784).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6.661393477).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.3306967385).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 256).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 768).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 213.16459127).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 639.4937738).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 8){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromGallonsUK(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 4546.09)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1605436532).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 277.41943279).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00454609).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0059460612).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 19.215198808).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 153.72159046).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 160).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.2009499255).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                output.setText(input);
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4.54609).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4546.09).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9.607599404).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4.803799702).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 307.44318093).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 922.32954279).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 256).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 768).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 9){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromLitres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 1000)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0353146667).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 61.023744095).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0013079506).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4.2267528377).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 33.814022702).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 35.195079728).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2641720524).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2199692483).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                output.setText(input);
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.1133764189).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.7597539864).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.0566882094).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8798769932).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 67.628045404).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 202.88413621).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 56.312127565).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 168.93638269).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 10){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromMillilitres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 1)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000353147).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0610237441).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001308).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0042267528).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0338140227).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0351950797).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0002641721).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0002199692).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                output.setText(input);
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0021133764).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001759754).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0010566882).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000879877).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0676280454).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2028841362).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0563121276).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1689363827).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 11){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromPintsUS(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 473.176473)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0167100694).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 28.875).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0004731765).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0006188915).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 16).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 16.653483693).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1040842731).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.473176473).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 473.176473).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                output.setText(input);
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8326741846).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.4163370923).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 32).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 96).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 26.645573908).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 79.936721724).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 12){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromPintsUK(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 568.26125)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0200679567).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 34.677429099).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0005682613).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0007432577).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.401899851).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 19.215198808).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 20).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1501187407).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.56826125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 568.26125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.2009499255).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                output.setText(input);
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.6004749628).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 38.430397616).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 115.29119285).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 32).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 96).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 13){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromQuartsUS(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 946.352946)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0334201389).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 57.75).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0009463529).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0012377829).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 32).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 33.306967385).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.25).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2081685462).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.946352946).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 946.352946).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.6653483693).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                output.setText(input);
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8326741846).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 64).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 192).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 53.291147816).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 159.87344345).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 14){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromQuartsUK(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 1136.5225)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0401359133).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 69.354858198).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0011365225).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0014865153).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4.803799702).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 38.430397616).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 40).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.3002374814).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.25).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.1365225).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1136.5225).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.401899851).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.2009499255).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                output.setText(input);
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 76.860795232).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 230.5823857).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 64).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 192).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 15){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromTablespoonsUS(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 14.786764781)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0005221897).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.90234375).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000147868).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000193404).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5204213654).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00390625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0032526335).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0147867648).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 14.786764781).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.03125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0260210683).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.015625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0130105341).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                output.setText(input);
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8326741846).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.4980225539).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 16){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromTeaspoonsUS(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 4.9289215937)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001740632).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.30078125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000049289).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000064468).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0208333333).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1666666667).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1734737885).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0013020833).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0010842112).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0049289216).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4.9289215937).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0104166667).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0086736894).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0052083333).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0043368447).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.3333333333).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                output.setText(input);
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2775580615).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8326741846).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 17){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromTablespoonsUK(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 17.758164063)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0006271236).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.0836696593).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000177582).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000232268).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0750593703).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.6004749628).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0046912106).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00390625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0177581641).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 17.758164063).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0375296852).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.03125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0187648426).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.015625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.2009499255).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.6028497765).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                output.setText(input);
                break;
            case 19: //Teaspoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 18){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromTeaspoonsUK(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //CubicCentimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 5.9193880208)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Cubic Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0002090412).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Cubic Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.3612232198).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Cubic Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000059194).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Cubic Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000077423).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Cups (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0250197901).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Fluid Ounces (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2001583209).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Fluid Ounces (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2083333333).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Gallons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0015637369).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Gallons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0013020833).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Litres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.005919388).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Millilitres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 5.9193880208).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Pints (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0125098951).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Pints (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0104166667).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 14: //Quarts (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0062549475).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 15: //Quarts (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0052083333).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 16: //Tablespoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.4003166418).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 17: //Teaspoons (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.2009499255).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 18: //Tablespoons (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.3333333333).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 19: //Teaspoons (UK)
                output.setText(input);
                break;
        }
        if (selectedItem != 19){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }





    public void insertCommas(TextView volumeTextInput, TextView volumeTextOutput){
        String currentDisplay = volumeTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                volumeTextInput.setText(currentDisplay);
            }

            if (volumeTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(volumeTextInput.getText());
                int j = 0;

                for (int i = newDisplayBuilder.length() - 1; i >= 0; i--){
                    if ((newDisplayBuilder.charAt(i) == '+') || (newDisplayBuilder.charAt(i) == '-')
                            ||(newDisplayBuilder.charAt(i) == 'x') || (newDisplayBuilder.charAt(i) == '÷')){
                        j = -1;
                    }
                    if ((j % 3 == 0) && (j != 0)){
                        newDisplayBuilder.insert(i + 1, ",");
                    }
                    j ++;
                }

                //Check for leading commas beside operator symbols


                String newDisplay = newDisplayBuilder.toString();
                volumeTextInput.setText(newDisplay);
            }
        }
    }

    public void insertNumber(String number){
        if (volumeTextInput.getText() == "0") {
            volumeTextInput.setText(number);
        }else{
            volumeTextInput.setText(volumeTextInput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = volumeTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                volumeTextInput.setText(currentDisplay);
            }
        }
        insertCommas(volumeTextInput, volumeTextOutput);
        checkInSelection();
//        adjustGrowingTextSize();
    }

    public void insertPeriod(View v){
        String currentDisplay = volumeTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                volumeTextInput.setText(volumeTextInput.getText().toString() + ".");
            }
        }
    }

    public void insertOne(View v){
        insertNumber("1");
    }

    public void insertTwo(View v){
        insertNumber("2");
    }

    public void insertThree(View v){
        insertNumber("3");
    }

    public void insertFour(View v){
        insertNumber("4");
    }

    public void insertFive(View v){
        insertNumber("5");
    }

    public void insertSix(View v){
        insertNumber("6");
    }

    public void insertSeven(View v){
        insertNumber("7");
    }

    public void insertEight(View v){
        insertNumber("8");
    }

    public void insertNine(View v){
        insertNumber("9");
    }

    public void insertZero(View v){
        insertNumber("0");
    }

    public void deleteDigit(View v){
        String decrementedDisplay = volumeTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            volumeTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            volumeTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = volumeTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    volumeTextInput.setText(currentDisplay);
                }

                if (volumeTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(volumeTextInput.getText());
                    int j = 0;
                    for (int i = newDisplay.length() - 1; i >= 0; i--){
                        if ((newDisplay.charAt(i) == '+') || (newDisplay.charAt(i) == '-')
                                ||(newDisplay.charAt(i) == 'x') || (newDisplay.charAt(i) == '÷')){
                            j = -1;
                        }
                        if ((j % 3 == 0) && (j != 0)){
                            newDisplay.insert(i + 1, ",");
                        }
                        j ++;
                    }
                    volumeTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        volumeTextInput.setText("0");
        volumeTextOutput.setText("0");
        checkInSelection();
    }
    
    
}
