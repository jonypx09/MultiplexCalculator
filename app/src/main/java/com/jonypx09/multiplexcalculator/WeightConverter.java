package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class WeightConverter {

    private TextView weightTextInput;
    private TextView weightTextOutput;
    private Spinner weightOptionsIn;
    private Spinner weightOptionsOut;
    private BigDecimal mainResult;

    public WeightConverter (TextView weightTextInput, TextView weightTextOutput, Spinner weightOptionsIn, Spinner weightOptionsOut){
        super();
        this.weightTextInput = weightTextInput;
        this.weightTextOutput = weightTextOutput;
        this.weightOptionsIn = weightOptionsIn;
        this.weightOptionsOut = weightOptionsOut;

        weightOptionsIn.setSelection(0,false);
        weightOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        weightOptionsOut.setSelection(0,false);
        weightOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        String textInput = weightTextInput.getText().toString().replace(",", "");
        switch(weightOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromCarats(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 1:
                convertFromCentigrams(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 2:
                convertFromDecagrams(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 3:
                convertFromDecigrams(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 4:
                convertFromGrams(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 5:
                convertFromHectograms(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 6:
                convertFromKilograms(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 7:
                convertFromLongTones(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 8:
                convertFromMetricTones(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 9:
                convertFromMilligrams(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 10:
                convertFromOunces(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 11:
                convertFromPounds(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 12:
                convertFromShortTones(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
            case 13:
                convertFromStone(textInput, weightOptionsOut.getSelectedItemPosition(), weightTextOutput);
                break;
        }
    }



    public void convertFromCarats(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                output.setText(input);
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 20)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.02).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.002).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0002).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.9684130552221215e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.0000000000000002e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 200).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.007054792389916083).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00044092452436975517).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.204622621848776e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00003149460888355394).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromCentigrams(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.049999999999999996)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                output.setText(input);
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9.842065276110606e-9).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1e-8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00035273961949580413).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000022046226218487758).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.1023113109243879e-8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000015747304441776972).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 1){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromDecagrams(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 50)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                output.setText(input);
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000009842065276110607).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.3527396194958041).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.022046226218487758).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000011023113109243879).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001574730444177697).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 2){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromDecigrams(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.5)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                output.setText(input);
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9.842065276110607e-8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.0000000000000001e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0035273961949580414).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00022046226218487759).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.102311310924388e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00001574730444177697).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 3){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromGrams(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 5)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                output.setText(input);
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9.842065276110607e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.035273961949580414).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.002204622621848776).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001102311310924388).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00015747304441776972).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 4){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromHectograms(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 500)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                output.setText(input);
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00009842065276110607).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.5273961949580412).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.22046226218487758).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00011023113109243879).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01574730444177697).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 5){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromKilograms(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 5000)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                output.setText(input);
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0009842065276110606).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 35.27396194958041).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.2046226218487757).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001102311310924388).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.15747304441776971).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 6){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromLongTones(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 5080234.544)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 101604690.88).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 101604.69088).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10160469.088).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1016046.9088).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10160.469088).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1016.0469088).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                output.setText(input);
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.0160469088).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1016046908.8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 35840).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2240).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.12).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 160).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 7){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromMetricTones(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 5000000)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.9842065276110606).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                output.setText(input);
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 35273.961949580415).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2204.622621848776).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.1023113109243878).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 157.4730444177697).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 8){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromMilligrams(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.005)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9.842065276110607e-10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1e-9).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                output.setText(input);
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000035273961949580415).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000002204622621848776).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.102311310924388e-9).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.5747304441776972e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 9){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromOunces(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 141.747615625)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2834.9523125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.8349523125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 283.49523125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 28.349523125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.28349523125000003).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.028349523125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000027901785714285717).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000028349523125000003).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 28349.523125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                output.setText(input);
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00003125).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.004464285714285715).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 10){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromPounds(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 2267.96185)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 45359.237).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 45.359237).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4535.9237).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 453.59237).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4.535923700000001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.45359237).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00044642857142857147).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00045359237000000004).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 453592.37).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 16).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                output.setText(input);
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0005).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.07142857142857144).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 11){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromShortTones(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 4535923.7)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 90718474).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 90718.474).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9071847.4).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 907184.74).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9071.8474).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 907.18474).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8928571428571429).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.90718474).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 907184740).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 32000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                output.setText(input);
                break;
            case 13: //Stone
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 142.85714285714286).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 12){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromStone(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Carats
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 31751.465899999996)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Centigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 635029.318).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Decagrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 635.029318).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Decigrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 63502.93179999999).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Grams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6350.29318).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Hectograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 63.5029318).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Kilograms
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6.3502931799999995).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Long Tones (UK)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0062499999999999995).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Metric Tonnes
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00635029318).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Milligrams
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6350293.18).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Ounces
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 224).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 11: //Pounds
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 14).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 12: //Short Tones (US)
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00699999).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 13: //Stone
                output.setText(input);
                break;
        }
        if (selectedItem != 13){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }






    public void insertCommas(TextView weightTextInput, TextView weightTextOutput){
        String currentDisplay = weightTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                weightTextInput.setText(currentDisplay);
            }

            if (weightTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(weightTextInput.getText());
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
                weightTextInput.setText(newDisplay);
            }
        }
    }

    public void insertNumber(String number){
        if (weightTextInput.getText() == "0") {
            weightTextInput.setText(number);
        }else{
            weightTextInput.setText(weightTextInput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = weightTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                weightTextInput.setText(currentDisplay);
            }

        }
        insertCommas(weightTextInput, weightTextOutput);
        checkInSelection();
//        adjustGrowingTextSize();
    }

    public void insertPeriod(View v){
        String currentDisplay = weightTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                weightTextInput.setText(weightTextInput.getText().toString() + ".");
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
        String decrementedDisplay = weightTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            weightTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            weightTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = weightTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    weightTextInput.setText(currentDisplay);
                }

                if (weightTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(weightTextInput.getText());
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
                    weightTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        weightTextInput.setText("0");
        weightTextOutput.setText("0");
        checkInSelection();
    }

}
