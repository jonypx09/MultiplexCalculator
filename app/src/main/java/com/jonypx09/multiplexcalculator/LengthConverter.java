package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class LengthConverter {

    private TextView lengthTextInput;
    private TextView lengthTextOutput;
    private Spinner lengthOptionsIn;
    private Spinner lengthOptionsOut;
    private BigDecimal mainResult;

    public LengthConverter (TextView lengthTextInput, TextView lengthTextOutput, Spinner lengthOptionsIn, Spinner lengthOptionsOut){
        super();
        this.lengthTextInput = lengthTextInput;
        this.lengthTextOutput = lengthTextOutput;
        this.lengthOptionsIn = lengthOptionsIn;
        this.lengthOptionsOut = lengthOptionsOut;

        lengthOptionsIn.setSelection(0,false);
        lengthOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        lengthOptionsOut.setSelection(0,false);
        lengthOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        String textInput = lengthTextInput.getText().toString().replace(",", "");
        switch(lengthOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromCentimetres(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 1:
                convertFromFeet(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 2:
                convertFromInches(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 3:
                convertFromKilometres(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 4:
                convertFromMetres(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 5:
                convertFromMicrons(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 6:
                convertFromMillimetres(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 7:
                convertFromMiles(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 8:
                convertFromNauticalMiles(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 9:
                convertFromNanometres(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
            case 10:
                convertFromYards(textInput, lengthOptionsOut.getSelectedItemPosition(), lengthTextOutput);
                break;
        }
        
    }

    public void convertFromCentimetres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres
//                mainResult = BigDecimal.valueOf(0);
//                output.setText(format.format(mainResult.doubleValue()));
                output.setText(input);
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) / 30.48)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) + 273.15).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) / 100000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) / 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) / 10000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000006213711922).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000005399568034557236).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.010936133).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromFeet(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 30.48)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                output.setText(input);
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 12).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0003048).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.3048).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 304800).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 304.8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001893939).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000005399568034557236).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00016457883369330455).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.3333333333).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 1){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromInches(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 2.54)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.08333333).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                output.setText(input);
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00002539999).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0254).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 25400).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 25.4).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000015782828282828).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000013714902807775378).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 25400000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.02777777777777).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 2){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromKilometres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.########");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 100000)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3280.839895012123).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 39370.078740157485).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                output.setText(input);
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns - Adjust Text Size for large values
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.621371192237334).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5399568034557235).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres - Adjust Text Size for large variables
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * (1000000 * 1000000)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1093.6132983377079).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 3){

            //Future Update to App: Improved Formatting depending on size of result
//            BigDecimal newOutput = new Expression(mainResult.toBigInteger() + "+ 0").eval();
//            output.setText(newOutput.toString());
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromMetres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.########");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 100)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.280839895013123).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 39.37007874015748).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                output.setText(input);
                break;
            case 5: //Microns - Adjust Text Size for large values
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0006213711922373339).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0005399568034557236).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres - Adjust Text Size for large variables
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.0936132983377078).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 4){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromMicrons(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.########");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.0001)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000003280839895013123).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00003937007874015748).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000000001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns - Adjust Text Size for large values
                output.setText(input);
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000000000621371192237334).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000000005399568034557235).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres - Adjust Text Size for large variables
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000010936132983377078).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 5){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromMillimetres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.########");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.1)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0032808398950131233).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.03937007874015748).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns - Adjust Text Size for large values
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                output.setText(input);
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6.21371192237334).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000005399568034557235).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres - Adjust Text Size for large variables
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0010936132983377078).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 6){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromMiles(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.########");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 160934.4)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 5280).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 63360).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.609344).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1609.344).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns - Adjust Text Size for large values
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * (1609344400 * 10)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1609344).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                output.setText(input);
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8689762419006479).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres - Adjust Text Size for large variables
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * (1609344 * 1000000)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1760).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 7){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromNauticalMiles(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.########");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 185200)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6076.115485564304).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 72913.38582677166).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.852).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1852).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns - Adjust Text Size for large values
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1852000000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1852000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.1507794480235425).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                output.setText(input);
                break;
            case 9: //Nanometres - Adjust Text Size for large variables
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * (1852000000 * 1000)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2025.3718285214347).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 8){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromNanometres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.########");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.0000001)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000000032808398950131233).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000000039370078740157).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000000000001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000000001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns - Adjust Text Size for large values
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00000000000062137119223733).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000000000005399568034557235).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres - Adjust Text Size for large variables
                output.setText(input);
                break;
            case 10: //Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000000001093613298337708).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 9){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromYards(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.########");
        switch(selectedItem){
            case 0: //Centimetres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 91.44)).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 36).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0009144).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.9144).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Microns - Adjust Text Size for large values
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 914400).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 914.4).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000568181818).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Nautical Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0004937365010799136).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Nanometres - Adjust Text Size for large variables
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 914400000).setScale(8, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 10: //Yards
                output.setText(input);
                break;
        }
        if (selectedItem != 10){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }







    public void insertCommas(TextView lengthTextInput, TextView lengthTextOutput){
        String currentDisplay = lengthTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                lengthTextInput.setText(currentDisplay);
            }

            if (lengthTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(lengthTextInput.getText());
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
                lengthTextInput.setText(newDisplay);
            }
        }
    }

    public void insertNumber(String number){
        if (lengthTextInput.getText().toString() == "0") {
            lengthTextInput.setText(number);
        }else{
            lengthTextInput.setText(lengthTextInput.getText().toString() + number);
        }

        //Adjust Comma placement
        insertCommas(lengthTextInput, lengthTextOutput);
        checkInSelection();
    }

    public void insertPeriod(View v){
        String currentDisplay = lengthTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                lengthTextInput.setText(lengthTextInput.getText().toString() + ".");
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
        String decrementedDisplay = lengthTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            lengthTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            lengthTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = lengthTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    lengthTextInput.setText(currentDisplay);
                }

                if (lengthTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(lengthTextInput.getText());
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
                    lengthTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        lengthTextInput.setText("0");
        lengthTextOutput.setText("0");
        checkInSelection();
    }

}
