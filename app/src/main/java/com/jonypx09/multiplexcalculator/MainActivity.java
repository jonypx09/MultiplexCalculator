package com.jonypx09.multiplexcalculator;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.udojava.evalex.Expression;

import java.lang.Math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView randomText;
    private NavigationView navigationView;
    private Menu navigationMenu;
    private MenuItem navTitleCalculator;
    private SpannableString navTitleCalculatorString;
    private MenuItem navTitleConverters;
    private SpannableString navTitleConvertersString;
    private MenuItem navTitleConfigure;
    private SpannableString navTitleConfigureString;
    private BottomNavigationView bottomNavigationView;
    private final menuSelector mainSelector = new menuSelector();
    private int[] favShortcuts = {0, 0, 0};

    private LinearLayout basicCalView;
    private LinearLayout scientificCalView;
    private LinearLayout currencyConverter;
    private LinearLayout lengthConverter;
    private LinearLayout weightConverter;
    private LinearLayout volumeConverter;
    private LinearLayout areaConverter;
    private LinearLayout temperatureConverter;
    private LinearLayout pressureConverter;
    private LinearLayout speedConverter;
    private LinearLayout powerConverter;
    private LinearLayout fuelConverter;

    private Intent miscIntent;

    //Settings Variables
    private SharedPreferences sharedPref;
    private Boolean switchPref;
    private Boolean amoledPref;
    private String favShortcut1;
    private String favShortcut2;
    private String favShortcut3;

    //Displays for Each Mode
    private TextView bcDisplay;
    private BasicCalculator bcEngine;

    private TextView scDisplay;
    private ScientificCalculator scEngine;

    //Buttons for Basic Calculator
    private Button bcPercentButton;
    private Button bcRootButton;
    private Button bcSquaredButton;
    private Button bcReciprocolButton;
    private Button bcClearEntryButton;
    private Button bcCancelButton;
    private Button bcDeleteButton;
    private Button bcDivideButton;
    private Button bcSevenButton;
    private Button bcEightButton;
    private Button bcNineButton;
    private Button bcMultiplyButton;
    private Button bcFourButton;
    private Button bcFiveButton;
    private Button bcSixButton;
    private Button bcMinusButton;
    private Button bcOneButton;
    private Button bcTwoButton;
    private Button bcThreeButton;
    private Button bcPlusButton;
    private Button bcPosNegButton;
    private Button bcZeroButton;
    private Button bcPeriodButton;
    private Button bcEqualsButton;
    private TableLayout bcButtons;

    //Buttons for Scientific Calculator
    private Button scSquaredButton;
    private Button scClearEntryButton;
    private Button scCancelButton;
    private Button scDeleteButton;
    private Button scDivideButton;
    private Button scPiButton;
    private Button scSevenButton;
    private Button scEightButton;
    private Button scNineButton;
    private Button scMultiplyButton;
    private Button scFactorialButton;
    private Button scFourButton;
    private Button scFiveButton;
    private Button scSixButton;
    private Button scMinusButton;
    private Button scOneButton;
    private Button scTwoButton;
    private Button scThreeButton;
    private Button scPlusButton;
    private Button scPosNegButton;
    private Button scLeftBracketButton;
    private Button scRightBracketButton;
    private Button scZeroButton;
    private Button scPeriodButton;
    private Button scEqualsButton;
    private ToggleButton scToggle;
    private int scToggleIndicator = 0; //Toggles between additional functions
    private int scMeasureType = 0; //Either Degrees or Radians
    private TableLayout scButtons;

    private Button scExp10Button;
    private Button scSinButton;
    private Button scCosButton;
    private Button scTanButton;
    private Button scCustomExponentButton;
    private Button scLogButton;
    private Button scDegButton;
    private Button scModButton;
    private Button scSquareRootButton;


    //Buttons for Length Converter
    private Button lcOneButton;
    private Button lcTwoButton;
    private Button lcThreeButton;
    private Button lcFourButton;
    private Button lcFiveButton;
    private Button lcSixButton;
    private Button lcSevenButton;
    private Button lcEightButton;
    private Button lcNineButton;
    private Button lcZeroButton;
    private Button lcPeriodButton;
    private Button lcPosNegButton;
    private Button lcClearEntryButton;
    private Button lcCancelButton;
    private Button lcDeleteButton;
    private TableLayout lcButtons;


    //Buttons for Weight Converter
    private Button wcOneButton;
    private Button wcTwoButton;
    private Button wcThreeButton;
    private Button wcFourButton;
    private Button wcFiveButton;
    private Button wcSixButton;
    private Button wcSevenButton;
    private Button wcEightButton;
    private Button wcNineButton;
    private Button wcZeroButton;
    private Button wcPeriodButton;
    private Button wcPosNegButton;
    private Button wcClearEntryButton;
    private Button wcCancelButton;
    private Button wcDeleteButton;
    private TableLayout wcButtons;
    
    //Buttons for Volume Converter
    private Button vcOneButton;
    private Button vcTwoButton;
    private Button vcThreeButton;
    private Button vcFourButton;
    private Button vcFiveButton;
    private Button vcSixButton;
    private Button vcSevenButton;
    private Button vcEightButton;
    private Button vcNineButton;
    private Button vcZeroButton;
    private Button vcPeriodButton;
    private Button vcPosNegButton;
    private Button vcCancelButton;
    private Button vcDeleteButton;
    private TableLayout vcButtons;

    //Buttons for Area Converter
    private Button acOneButton;
    private Button acTwoButton;
    private Button acThreeButton;
    private Button acFourButton;
    private Button acFiveButton;
    private Button acSixButton;
    private Button acSevenButton;
    private Button acEightButton;
    private Button acNineButton;
    private Button acZeroButton;
    private Button acPeriodButton;
    private Button acPosNegButton;
    private Button acCancelButton;
    private Button acDeleteButton;
    private TableLayout acButtons;

    //Buttons for Temperature Converter
    private Button tcOneButton;
    private Button tcTwoButton;
    private Button tcThreeButton;
    private Button tcFourButton;
    private Button tcFiveButton;
    private Button tcSixButton;
    private Button tcSevenButton;
    private Button tcEightButton;
    private Button tcNineButton;
    private Button tcZeroButton;
    private Button tcPeriodButton;
    private Button tcPosNegButton;
    private Button tcCancelButton;
    private Button tcDeleteButton;
    private TableLayout tcButtons;

    //Buttons for Pressure Converter
    private Button pcOneButton;
    private Button pcTwoButton;
    private Button pcThreeButton;
    private Button pcFourButton;
    private Button pcFiveButton;
    private Button pcSixButton;
    private Button pcSevenButton;
    private Button pcEightButton;
    private Button pcNineButton;
    private Button pcZeroButton;
    private Button pcPeriodButton;
    private Button pcPosNegButton;
    private Button pcCancelButton;
    private Button pcDeleteButton;
    private TableLayout pcButtons;

    //Buttons for Speed Converter
    private Button spcOneButton;
    private Button spcTwoButton;
    private Button spcThreeButton;
    private Button spcFourButton;
    private Button spcFiveButton;
    private Button spcSixButton;
    private Button spcSevenButton;
    private Button spcEightButton;
    private Button spcNineButton;
    private Button spcZeroButton;
    private Button spcPeriodButton;
    private Button spcPosNegButton;
    private Button spcCancelButton;
    private Button spcDeleteButton;
    private TableLayout spcButtons;

    //Buttons for Power Converter
    private Button pocOneButton;
    private Button pocTwoButton;
    private Button pocThreeButton;
    private Button pocFourButton;
    private Button pocFiveButton;
    private Button pocSixButton;
    private Button pocSevenButton;
    private Button pocEightButton;
    private Button pocNineButton;
    private Button pocZeroButton;
    private Button pocPeriodButton;
    private Button pocPosNegButton;
    private Button pocCancelButton;
    private Button pocDeleteButton;
    private TableLayout pocButtons;

    //Buttons for Fuel Consumption Converter
    private Button fccOneButton;
    private Button fccTwoButton;
    private Button fccThreeButton;
    private Button fccFourButton;
    private Button fccFiveButton;
    private Button fccSixButton;
    private Button fccSevenButton;
    private Button fccEightButton;
    private Button fccNineButton;
    private Button fccZeroButton;
    private Button fccPeriodButton;
    private Button fccPosNegButton;
    private Button fccCancelButton;
    private Button fccDeleteButton;
    private TableLayout fccButtons;


    //Storage for Each Mode
    private double bcResult;

    //Colour Scheme for Dark Mode
    private int[][] statesDark = new int[][] {
            new int[] { android.R.attr.state_checked}, // checked
            new int[] {-android.R.attr.state_checked} // unchecked

    };
    private int[] colorsDark = new int[] {
            Color.parseColor("#FF1EFEE9"),
            Color.GRAY
    };
    private ColorStateList darkTheme = new ColorStateList(statesDark, colorsDark);

    //Colour Scheme for Default Mode
    private int[][] statesDefault = new int[][] {
            new int[] { android.R.attr.state_checked}, // checked
            new int[] {-android.R.attr.state_checked} // unchecked

    };
    private int[] colorsDefault = new int[] {
            Color.parseColor("#FF006E60"),
            Color.parseColor("#FF323232")
    };
    private ColorStateList defaultTheme = new ColorStateList(statesDefault, colorsDefault);




    //Variables for Currency Converter
    //REMOVED FOR NOW - TO BE ADDED IN A FUTURE UPDATE
    private TextView currencyTextInput;
    private TextView currencyTextOutput;
    private CurrencyConverter ccEngine;


    //Variables for Length Converter
    private TextView lengthTextInput;
    private TextView lengthTextOutput;
    private Spinner lengthOptionsIn;
    private Spinner lengthOptionsOut;
    private ArrayAdapter lengthOptionsDark;
    private ArrayAdapter lengthOptionsLight;
    private LengthConverter lcEngine;

    //Variables for Weight Converter
    private TextView weightTextInput;
    private TextView weightTextOutput;
    private Spinner weightOptionsIn;
    private Spinner weightOptionsOut;
    private ArrayAdapter weightOptionsDark;
    private ArrayAdapter weightOptionsLight;
    private WeightConverter wcEngine;

    //Variables for Volume Converter
    private TextView volumeTextInput;
    private TextView volumeTextOutput;
    private Spinner volumeOptionsIn;
    private Spinner volumeOptionsOut;
    private ArrayAdapter volumeOptionsDark;
    private ArrayAdapter volumeOptionsLight;
    private VolumeConverter vcEngine;


    //Variables for Area Converter
    private TextView areaTextInput;
    private TextView areaTextOutput;
    private Spinner areaOptionsIn;
    private Spinner areaOptionsOut;
    private ArrayAdapter areaOptionsDark;
    private ArrayAdapter areaOptionsLight;
    private AreaConverter acEngine;


    //Variables for Temperature Converter
    private TextView temperatureTextInput;
    private TextView temperatureTextOutput;
    private Spinner tempOptionsIn;
    private Spinner tempOptionsOut;
    private ArrayAdapter temperatureOptionsDark;
    private ArrayAdapter temperatureOptionsLight;
    private TemperatureConverter tcEngine;

    //Variables for Pressure Converter
    private TextView pressureTextInput;
    private TextView pressureTextOutput;
    private Spinner pressureOptionsIn;
    private Spinner pressureOptionsOut;
    private ArrayAdapter pressureOptionsDark;
    private ArrayAdapter pressureOptionsLight;
    private PressureConverter pcEngine;

    //Variables for Speed Converter
    private TextView speedTextInput;
    private TextView speedTextOutput;
    private Spinner speedOptionsIn;
    private Spinner speedOptionsOut;
    private ArrayAdapter speedOptionsDark;
    private ArrayAdapter speedOptionsLight;
    private SpeedConverter spcEngine;

    //Variables for Power Converter
    private TextView powerTextInput;
    private TextView powerTextOutput;
    private Spinner powerOptionsIn;
    private Spinner powerOptionsOut;
    private ArrayAdapter powerOptionsDark;
    private ArrayAdapter powerOptionsLight;
    private PowerConverter pocEngine;

    private TextView fuelTextInput;
    private TextView fuelTextOutput;
    private Spinner fuelOptionsIn;
    private Spinner fuelOptionsOut;
    private ArrayAdapter fuelOptionsDark;
    private ArrayAdapter fuelOptionsLight;
    private FuelConsumptionConverter fccEngine;

    public void changeBottomNavIcons(int itemNum, String shortcut){
        if (shortcut.equals("Basic Calculator")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.calculator_basic);
        }else if (shortcut.equals("Scientific Calculator")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.calculator);
        }else if (shortcut.equals("Unit Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.math_compass);
        }else if (shortcut.equals("Currency Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.currency_usd);
        }else if (shortcut.equals("Length Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.ruler);
        }else if (shortcut.equals("Weight Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.weight);
        }else if (shortcut.equals("Volume Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.volume);
        }else if (shortcut.equals("Area Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.area);
        }else if (shortcut.equals("Temperature Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.thermometer);
        }else if (shortcut.equals("Pressure Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.pressure);
        }else if (shortcut.equals("Speed Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.speedometer);
        }else if (shortcut.equals("Power Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.flash_circle);
        }else if (shortcut.equals("Fuel Consumption Converter")){
            bottomNavigationView.getMenu().getItem(itemNum).setIcon(R.drawable.gas_station);
        }
    }

    public void selectAppropriatePage(String favShortcut){
        if (favShortcut.equals("Basic Calculator")){
            mainSelector.selectBasicCalculator();
        }else if (favShortcut.equals("Scientific Calculator")){
            mainSelector.selectScientificCalculator();
        }else if (favShortcut.equals("Currency Converter")){
            mainSelector.selectCurrencyConverter();
        }else if (favShortcut.equals("Length Converter")){
            mainSelector.selectLengthConverter();
        }else if (favShortcut.equals("Weight Converter")){
            mainSelector.selectWeightConverter();
        }else if (favShortcut.equals("Volume Converter")){
            mainSelector.selectVolumeConverter();
        }else if (favShortcut.equals("Area Converter")){
            mainSelector.selectAreaConverter();
        }else if (favShortcut.equals("Temperature Converter")){
            mainSelector.selectTemperatureConverter();
        }else if (favShortcut.equals("Pressure Converter")){
            mainSelector.selectPressureConverter();
        }else if (favShortcut.equals("Speed Converter")){
            mainSelector.selectSpeedConverter();
        }else if (favShortcut.equals("Power Converter")){
            mainSelector.selectPowerConverter();
        }else if (favShortcut.equals("Fuel Consumption Converter")){
            mainSelector.selectFuelConsumptionConverter();
        }
    }

    /**Initialize the components of each view
     * **
     */
    public void initializeBcButtons(){
        //Declare Basic Calculator Components Here
        bcButtons = findViewById(R.id.bcButtons);

        bcPercentButton = findViewById(R.id.bcPercentButton);
        bcRootButton = findViewById(R.id.bcRootButton);
        bcSquaredButton = findViewById(R.id.bcSquaredButton);
        bcSquaredButton.setText(Html.fromHtml("X<sup>2</sup>"));
        bcReciprocolButton = findViewById(R.id.bcReciprocolButton);
        bcClearEntryButton = findViewById(R.id.bcClearEntryButton);
        bcCancelButton = findViewById(R.id.bcCancelButton);
        bcDeleteButton = findViewById(R.id.bcDeleteButton);
        bcDivideButton = findViewById(R.id.bcDivideButton);
        bcSevenButton = findViewById(R.id.bcSevenButton);
        bcEightButton = findViewById(R.id.bcEightButton);
        bcNineButton = findViewById(R.id.bcNineButton);
        bcMultiplyButton = findViewById(R.id.bcMultiplyButton);
        bcFourButton = findViewById(R.id.bcFourButton);
        bcFiveButton = findViewById(R.id.bcFiveButton);
        bcSixButton = findViewById(R.id.bcSixButton);
        bcMinusButton = findViewById(R.id.bcMinusButton);
        bcOneButton = findViewById(R.id.bcOneButton);
        bcTwoButton = findViewById(R.id.bcTwoButton);
        bcThreeButton = findViewById(R.id.bcThreeButton);
        bcPlusButton = findViewById(R.id.bcPlusButton);
        bcPosNegButton = findViewById(R.id.bcPosNegButton);
        bcZeroButton = findViewById(R.id.bcZeroButton);
        bcPeriodButton = findViewById(R.id.bcPeriodButton);
        bcEqualsButton = findViewById(R.id.bcEqualsButton);
    }
    public void initializeScButtons(){
        scButtons = findViewById(R.id.scButtons);

        scSquaredButton = findViewById(R.id.scSquaredButton);
        scSquaredButton.setText(Html.fromHtml("X<sup>2</sup>"));
        scClearEntryButton = findViewById(R.id.scClearEntryButton);
        scCancelButton = findViewById(R.id.scCancelButton);
        scDeleteButton = findViewById(R.id.scDeleteButton);
        scDivideButton = findViewById(R.id.scDivideButton);
        scPiButton = findViewById(R.id.scPiButton);
        scSevenButton = findViewById(R.id.scSevenButton);
        scEightButton = findViewById(R.id.scEightButton);
        scNineButton = findViewById(R.id.scNineButton);
        scMultiplyButton = findViewById(R.id.scMultiplyButton);
        scFactorialButton = findViewById(R.id.scFactorialButton);
        scFourButton = findViewById(R.id.scFourButton);
        scFiveButton = findViewById(R.id.scFiveButton);
        scSixButton = findViewById(R.id.scSixButton);
        scMinusButton = findViewById(R.id.scMinusButton);
        scOneButton = findViewById(R.id.scOneButton);
        scTwoButton = findViewById(R.id.scTwoButton);
        scThreeButton = findViewById(R.id.scThreeButton);
        scPlusButton = findViewById(R.id.scPlusButton);
        scPosNegButton = findViewById(R.id.scPosNegButton);
        scZeroButton = findViewById(R.id.scZeroButton);
        scLeftBracketButton = findViewById(R.id.scLeftBracketButton);
        scRightBracketButton = findViewById(R.id.scRightBracketButton);
        scPeriodButton = findViewById(R.id.scPeriodButton);
        scEqualsButton = findViewById(R.id.scEqualsButton);
        scExp10Button = findViewById(R.id.scExp10Button);
        scExp10Button.setText(Html.fromHtml("10<sup>X</sup>"));
        scSinButton = findViewById(R.id.scSinButton);
        scCosButton = findViewById(R.id.scCosButton);
        scTanButton = findViewById(R.id.scTanButton);
        scCustomExponentButton = findViewById(R.id.scCustomExponentButton);
        scCustomExponentButton.setText(Html.fromHtml("X<sup>Y</sup>"));
        scLogButton = findViewById(R.id.scLogButton);
        scDegButton = findViewById(R.id.scDegButton);
        scModButton = findViewById(R.id.scModButton);
        scSquareRootButton = findViewById(R.id.scSquareRootButton);
        scToggle = findViewById(R.id.scToggle);

    }
    public void initializeLcButtons(){
        lcOneButton = findViewById(R.id.lcOneButton);
        lcTwoButton = findViewById(R.id.lcTwoButton);
        lcThreeButton = findViewById(R.id.lcThreeButton);
        lcFourButton = findViewById(R.id.lcFourButton);
        lcFiveButton = findViewById(R.id.lcFiveButton);
        lcSixButton = findViewById(R.id.lcSixButton);
        lcSevenButton = findViewById(R.id.lcSevenButton);
        lcEightButton = findViewById(R.id.lcEightButton);
        lcNineButton = findViewById(R.id.lcNineButton);
        lcZeroButton = findViewById(R.id.lcZeroButton);
        lcPosNegButton = findViewById(R.id.lcPosNegButton);
        lcPeriodButton = findViewById(R.id.lcPeriodButton);
        lcDeleteButton = findViewById(R.id.lcDeleteButton);
        lcCancelButton = findViewById(R.id.lcCancelButton);

        lengthOptionsDark = ArrayAdapter.createFromResource(this, R.array.lengthConvert, R.layout.spinner_item_dark);
        lengthOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        lengthOptionsLight = ArrayAdapter.createFromResource(this, R.array.lengthConvert, R.layout.spinner_item_light);
        lengthOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        lcButtons = findViewById(R.id.lcButtons);
    }
    public void initializeWcButtons(){
        wcOneButton = findViewById(R.id.wcOneButton);
        wcTwoButton = findViewById(R.id.wcTwoButton);
        wcThreeButton = findViewById(R.id.wcThreeButton);
        wcFourButton = findViewById(R.id.wcFourButton);
        wcFiveButton = findViewById(R.id.wcFiveButton);
        wcSixButton = findViewById(R.id.wcSixButton);
        wcSevenButton = findViewById(R.id.wcSevenButton);
        wcEightButton = findViewById(R.id.wcEightButton);
        wcNineButton = findViewById(R.id.wcNineButton);
        wcZeroButton = findViewById(R.id.wcZeroButton);
        wcPosNegButton = findViewById(R.id.wcPosNegButton);
        wcPeriodButton = findViewById(R.id.wcPeriodButton);
        wcDeleteButton = findViewById(R.id.wcDeleteButton);
        wcCancelButton = findViewById(R.id.wcCancelButton);

        weightOptionsDark = ArrayAdapter.createFromResource(this, R.array.weightConvert, R.layout.spinner_item_dark);
        weightOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        weightOptionsLight = ArrayAdapter.createFromResource(this, R.array.weightConvert, R.layout.spinner_item_light);
        weightOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        wcButtons = findViewById(R.id.wcButtons);
    }
    public void initializeVcButtons(){
        vcOneButton = findViewById(R.id.vcOneButton);
        vcTwoButton = findViewById(R.id.vcTwoButton);
        vcThreeButton = findViewById(R.id.vcThreeButton);
        vcFourButton = findViewById(R.id.vcFourButton);
        vcFiveButton = findViewById(R.id.vcFiveButton);
        vcSixButton = findViewById(R.id.vcSixButton);
        vcSevenButton = findViewById(R.id.vcSevenButton);
        vcEightButton = findViewById(R.id.vcEightButton);
        vcNineButton = findViewById(R.id.vcNineButton);
        vcZeroButton = findViewById(R.id.vcZeroButton);
        vcPosNegButton = findViewById(R.id.vcPosNegButton);
        vcPeriodButton = findViewById(R.id.vcPeriodButton);
        vcDeleteButton = findViewById(R.id.vcDeleteButton);
        vcCancelButton = findViewById(R.id.vcCancelButton);

        volumeOptionsDark = ArrayAdapter.createFromResource(this, R.array.volumeConvert, R.layout.spinner_item_dark);
        volumeOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        volumeOptionsLight = ArrayAdapter.createFromResource(this, R.array.volumeConvert, R.layout.spinner_item_light);
        volumeOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        vcButtons = findViewById(R.id.vcButtons);
    }
    public void initializeAcButtons(){
        acOneButton = findViewById(R.id.acOneButton);
        acTwoButton = findViewById(R.id.acTwoButton);
        acThreeButton = findViewById(R.id.acThreeButton);
        acFourButton = findViewById(R.id.acFourButton);
        acFiveButton = findViewById(R.id.acFiveButton);
        acSixButton = findViewById(R.id.acSixButton);
        acSevenButton = findViewById(R.id.acSevenButton);
        acEightButton = findViewById(R.id.acEightButton);
        acNineButton = findViewById(R.id.acNineButton);
        acZeroButton = findViewById(R.id.acZeroButton);
        acPosNegButton = findViewById(R.id.acPosNegButton);
        acPeriodButton = findViewById(R.id.acPeriodButton);
        acDeleteButton = findViewById(R.id.acDeleteButton);
        acCancelButton = findViewById(R.id.acCancelButton);

        areaOptionsDark = ArrayAdapter.createFromResource(this, R.array.areaConvert, R.layout.spinner_item_dark);
        areaOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        areaOptionsLight = ArrayAdapter.createFromResource(this, R.array.areaConvert, R.layout.spinner_item_light);
        areaOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        acButtons = findViewById(R.id.acButtons);
    }
    public void initializeTcButtons(){
        tcOneButton = findViewById(R.id.tcOneButton);
        tcTwoButton = findViewById(R.id.tcTwoButton);
        tcThreeButton = findViewById(R.id.tcThreeButton);
        tcFourButton = findViewById(R.id.tcFourButton);
        tcFiveButton = findViewById(R.id.tcFiveButton);
        tcSixButton = findViewById(R.id.tcSixButton);
        tcSevenButton = findViewById(R.id.tcSevenButton);
        tcEightButton = findViewById(R.id.tcEightButton);
        tcNineButton = findViewById(R.id.tcNineButton);
        tcZeroButton = findViewById(R.id.tcZeroButton);
        tcPosNegButton = findViewById(R.id.tcPosNegButton);
        tcPeriodButton = findViewById(R.id.tcPeriodButton);
        tcDeleteButton = findViewById(R.id.tcDeleteButton);
        tcCancelButton = findViewById(R.id.tcCancelButton);

        temperatureOptionsDark = ArrayAdapter.createFromResource(this, R.array.tempConvert, R.layout.spinner_item_dark);
        temperatureOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        temperatureOptionsLight = ArrayAdapter.createFromResource(this, R.array.tempConvert, R.layout.spinner_item_light);
        temperatureOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        tcButtons = findViewById(R.id.tcButtons);
    }
    public void initializePcButtons(){
        pcOneButton = findViewById(R.id.pcOneButton);
        pcTwoButton = findViewById(R.id.pcTwoButton);
        pcThreeButton = findViewById(R.id.pcThreeButton);
        pcFourButton = findViewById(R.id.pcFourButton);
        pcFiveButton = findViewById(R.id.pcFiveButton);
        pcSixButton = findViewById(R.id.pcSixButton);
        pcSevenButton = findViewById(R.id.pcSevenButton);
        pcEightButton = findViewById(R.id.pcEightButton);
        pcNineButton = findViewById(R.id.pcNineButton);
        pcZeroButton = findViewById(R.id.pcZeroButton);
        pcPosNegButton = findViewById(R.id.pcPosNegButton);
        pcPeriodButton = findViewById(R.id.pcPeriodButton);
        pcDeleteButton = findViewById(R.id.pcDeleteButton);
        pcCancelButton = findViewById(R.id.pcCancelButton);

        pressureOptionsDark = ArrayAdapter.createFromResource(this, R.array.pressureConvert, R.layout.spinner_item_dark);
        pressureOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        pressureOptionsLight = ArrayAdapter.createFromResource(this, R.array.pressureConvert, R.layout.spinner_item_light);
        pressureOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        pcButtons = findViewById(R.id.pcButtons);
    }
    public void initializeSpcButtons(){
        spcOneButton = findViewById(R.id.spcOneButton);
        spcTwoButton = findViewById(R.id.spcTwoButton);
        spcThreeButton = findViewById(R.id.spcThreeButton);
        spcFourButton = findViewById(R.id.spcFourButton);
        spcFiveButton = findViewById(R.id.spcFiveButton);
        spcSixButton = findViewById(R.id.spcSixButton);
        spcSevenButton = findViewById(R.id.spcSevenButton);
        spcEightButton = findViewById(R.id.spcEightButton);
        spcNineButton = findViewById(R.id.spcNineButton);
        spcZeroButton = findViewById(R.id.spcZeroButton);
        spcPosNegButton = findViewById(R.id.spcPosNegButton);
        spcPeriodButton = findViewById(R.id.spcPeriodButton);
        spcDeleteButton = findViewById(R.id.spcDeleteButton);
        spcCancelButton = findViewById(R.id.spcCancelButton);

        speedOptionsDark = ArrayAdapter.createFromResource(this, R.array.speedConvert, R.layout.spinner_item_dark);
        speedOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        speedOptionsLight = ArrayAdapter.createFromResource(this, R.array.speedConvert, R.layout.spinner_item_light);
        speedOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        spcButtons = findViewById(R.id.spcButtons);
    }
    public void initializePocButtons(){
        pocOneButton = findViewById(R.id.pocOneButton);
        pocTwoButton = findViewById(R.id.pocTwoButton);
        pocThreeButton = findViewById(R.id.pocThreeButton);
        pocFourButton = findViewById(R.id.pocFourButton);
        pocFiveButton = findViewById(R.id.pocFiveButton);
        pocSixButton = findViewById(R.id.pocSixButton);
        pocSevenButton = findViewById(R.id.pocSevenButton);
        pocEightButton = findViewById(R.id.pocEightButton);
        pocNineButton = findViewById(R.id.pocNineButton);
        pocZeroButton = findViewById(R.id.pocZeroButton);
        pocPosNegButton = findViewById(R.id.pocPosNegButton);
        pocPeriodButton = findViewById(R.id.pocPeriodButton);
        pocDeleteButton = findViewById(R.id.pocDeleteButton);
        pocCancelButton = findViewById(R.id.pocCancelButton);

        powerOptionsDark = ArrayAdapter.createFromResource(this, R.array.powerConvert, R.layout.spinner_item_dark);
        powerOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        powerOptionsLight = ArrayAdapter.createFromResource(this, R.array.powerConvert, R.layout.spinner_item_light);
        powerOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        pocButtons = findViewById(R.id.pocButtons);
    }
    public void initializeFccButtons(){
        fccOneButton = findViewById(R.id.fccOneButton);
        fccTwoButton = findViewById(R.id.fccTwoButton);
        fccThreeButton = findViewById(R.id.fccThreeButton);
        fccFourButton = findViewById(R.id.fccFourButton);
        fccFiveButton = findViewById(R.id.fccFiveButton);
        fccSixButton = findViewById(R.id.fccSixButton);
        fccSevenButton = findViewById(R.id.fccSevenButton);
        fccEightButton = findViewById(R.id.fccEightButton);
        fccNineButton = findViewById(R.id.fccNineButton);
        fccZeroButton = findViewById(R.id.fccZeroButton);
        fccPosNegButton = findViewById(R.id.fccPosNegButton);
        fccPeriodButton = findViewById(R.id.fccPeriodButton);
        fccDeleteButton = findViewById(R.id.fccDeleteButton);
        fccCancelButton = findViewById(R.id.fccCancelButton);

        fuelOptionsDark = ArrayAdapter.createFromResource(this, R.array.fuelConvert, R.layout.spinner_item_dark);
        fuelOptionsDark.setDropDownViewResource(R.layout.spinner_dropdown_item_dark);
        fuelOptionsLight = ArrayAdapter.createFromResource(this, R.array.fuelConvert, R.layout.spinner_item_light);
        fuelOptionsLight.setDropDownViewResource(R.layout.spinner_dropdown_item_light);
        fccButtons = findViewById(R.id.fccButtons);
    }


    //Theme Modification Functions

    public void setBcPageDark(Boolean amoled){
        //Change Textcolor of buttons
        bcPercentButton.setTextColor(Color.WHITE);
        bcRootButton.setTextColor(Color.WHITE);
        bcSquaredButton.setTextColor(Color.WHITE);
        bcReciprocolButton.setTextColor(Color.WHITE);
        bcClearEntryButton.setTextColor(Color.WHITE);
        bcCancelButton.setTextColor(Color.WHITE);
        bcDeleteButton.setTextColor(Color.WHITE);
        bcDivideButton.setTextColor(Color.WHITE);
        bcSevenButton.setTextColor(Color.WHITE);
        bcEightButton.setTextColor(Color.WHITE);
        bcNineButton.setTextColor(Color.WHITE);
        bcMultiplyButton.setTextColor(Color.WHITE);
        bcFourButton.setTextColor(Color.WHITE);
        bcFiveButton.setTextColor(Color.WHITE);
        bcSixButton.setTextColor(Color.WHITE);
        bcMinusButton.setTextColor(Color.WHITE);
        bcOneButton.setTextColor(Color.WHITE);
        bcTwoButton.setTextColor(Color.WHITE);
        bcThreeButton.setTextColor(Color.WHITE);
        bcPlusButton.setTextColor(Color.WHITE);
        bcPosNegButton.setTextColor(Color.WHITE);
        bcZeroButton.setTextColor(Color.WHITE);
        bcPeriodButton.setTextColor(Color.WHITE);
        bcEqualsButton.setTextColor(Color.WHITE);

        bcDisplay.setTextColor(Color.WHITE);

        if (amoled){
            bcButtons.setBackgroundColor(Color.BLACK);
        }else {
            bcButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setBcPageLight(){
        //Change Textcolor of buttons
        bcPercentButton.setTextColor(Color.BLACK);
        bcRootButton.setTextColor(Color.BLACK);
        bcSquaredButton.setTextColor(Color.BLACK);
        bcReciprocolButton.setTextColor(Color.BLACK);
        bcClearEntryButton.setTextColor(Color.BLACK);
        bcCancelButton.setTextColor(Color.BLACK);
        bcDeleteButton.setTextColor(Color.BLACK);
        bcDivideButton.setTextColor(Color.BLACK);
        bcSevenButton.setTextColor(Color.BLACK);
        bcEightButton.setTextColor(Color.BLACK);
        bcNineButton.setTextColor(Color.BLACK);
        bcMultiplyButton.setTextColor(Color.BLACK);
        bcFourButton.setTextColor(Color.BLACK);
        bcFiveButton.setTextColor(Color.BLACK);
        bcSixButton.setTextColor(Color.BLACK);
        bcMinusButton.setTextColor(Color.BLACK);
        bcOneButton.setTextColor(Color.BLACK);
        bcTwoButton.setTextColor(Color.BLACK);
        bcThreeButton.setTextColor(Color.BLACK);
        bcPlusButton.setTextColor(Color.BLACK);
        bcPosNegButton.setTextColor(Color.BLACK);
        bcZeroButton.setTextColor(Color.BLACK);
        bcPeriodButton.setTextColor(Color.BLACK);
        bcEqualsButton.setTextColor(Color.BLACK);

        bcDisplay.setTextColor(Color.BLACK);
        bcButtons.setBackgroundColor(Color.WHITE);
    }

    public void setScPageDark(Boolean amoled){
        scSquaredButton.setTextColor(Color.WHITE);
        scClearEntryButton.setTextColor(Color.WHITE);
        scCancelButton.setTextColor(Color.WHITE);
        scDeleteButton.setTextColor(Color.WHITE);
        scDivideButton.setTextColor(Color.WHITE);
        scPiButton.setTextColor(Color.WHITE);
        scSevenButton.setTextColor(Color.WHITE);
        scEightButton.setTextColor(Color.WHITE);
        scNineButton.setTextColor(Color.WHITE);
        scMultiplyButton.setTextColor(Color.WHITE);
        scFactorialButton.setTextColor(Color.WHITE);
        scFourButton.setTextColor(Color.WHITE);
        scFiveButton.setTextColor(Color.WHITE);
        scSixButton.setTextColor(Color.WHITE);
        scMinusButton.setTextColor(Color.WHITE);
        scOneButton.setTextColor(Color.WHITE);
        scTwoButton.setTextColor(Color.WHITE);
        scThreeButton.setTextColor(Color.WHITE);
        scPlusButton.setTextColor(Color.WHITE);
        scPosNegButton.setTextColor(Color.WHITE);
        scLeftBracketButton.setTextColor(Color.WHITE);
        scRightBracketButton.setTextColor(Color.WHITE);
        scZeroButton.setTextColor(Color.WHITE);
        scPeriodButton.setTextColor(Color.WHITE);
        scEqualsButton.setTextColor(Color.WHITE);
        scToggle.setTextColor(Color.WHITE);
        scExp10Button.setTextColor(Color.WHITE);
        scSinButton.setTextColor(Color.WHITE);
        scCosButton.setTextColor(Color.WHITE);
        scTanButton.setTextColor(Color.WHITE);
        scCustomExponentButton.setTextColor(Color.WHITE);
        scLogButton.setTextColor(Color.WHITE);
        scDegButton.setTextColor(Color.WHITE);
        scModButton.setTextColor(Color.WHITE);
        scSquareRootButton.setTextColor(Color.WHITE);

        scDisplay.setTextColor(Color.WHITE);
        if (amoled){
            scButtons.setBackgroundColor(Color.BLACK);
        }else {
            scButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setScPageLight(){
        scSquaredButton.setTextColor(Color.BLACK);
        scClearEntryButton.setTextColor(Color.BLACK);
        scCancelButton.setTextColor(Color.BLACK);
        scDeleteButton.setTextColor(Color.BLACK);
        scDivideButton.setTextColor(Color.BLACK);
        scPiButton.setTextColor(Color.BLACK);
        scSevenButton.setTextColor(Color.BLACK);
        scEightButton.setTextColor(Color.BLACK);
        scNineButton.setTextColor(Color.BLACK);
        scMultiplyButton.setTextColor(Color.BLACK);
        scFactorialButton.setTextColor(Color.BLACK);
        scFourButton.setTextColor(Color.BLACK);
        scFiveButton.setTextColor(Color.BLACK);
        scSixButton.setTextColor(Color.BLACK);
        scMinusButton.setTextColor(Color.BLACK);
        scOneButton.setTextColor(Color.BLACK);
        scTwoButton.setTextColor(Color.BLACK);
        scThreeButton.setTextColor(Color.BLACK);
        scPlusButton.setTextColor(Color.BLACK);
        scPosNegButton.setTextColor(Color.BLACK);
        scLeftBracketButton.setTextColor(Color.BLACK);
        scRightBracketButton.setTextColor(Color.BLACK);
        scZeroButton.setTextColor(Color.BLACK);
        scPeriodButton.setTextColor(Color.BLACK);
        scEqualsButton.setTextColor(Color.BLACK);
        scToggle.setTextColor(Color.BLACK);
        scExp10Button.setTextColor(Color.BLACK);
        scSinButton.setTextColor(Color.BLACK);
        scCosButton.setTextColor(Color.BLACK);
        scTanButton.setTextColor(Color.BLACK);
        scCustomExponentButton.setTextColor(Color.BLACK);
        scLogButton.setTextColor(Color.BLACK);
        scDegButton.setTextColor(Color.BLACK);
        scModButton.setTextColor(Color.BLACK);
        scSquareRootButton.setTextColor(Color.BLACK);

        scDisplay.setTextColor(Color.BLACK);
        scButtons.setBackgroundColor(Color.WHITE);
    }

    public void setlcPageDark(Boolean amoled){
        lcOneButton.setTextColor(Color.WHITE);
        lcTwoButton.setTextColor(Color.WHITE);
        lcThreeButton.setTextColor(Color.WHITE);
        lcFourButton.setTextColor(Color.WHITE);
        lcFiveButton.setTextColor(Color.WHITE);
        lcSixButton.setTextColor(Color.WHITE);
        lcSevenButton.setTextColor(Color.WHITE);
        lcEightButton.setTextColor(Color.WHITE);
        lcNineButton.setTextColor(Color.WHITE);
        lcZeroButton.setTextColor(Color.WHITE);
        lcPosNegButton.setTextColor(Color.WHITE);
        lcPeriodButton.setTextColor(Color.WHITE);
        lcDeleteButton.setTextColor(Color.WHITE);
        lcCancelButton.setTextColor(Color.WHITE);

        lengthTextInput.setTextColor(Color.WHITE);
        lengthOptionsIn.setAdapter(lengthOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        lengthOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        lengthTextOutput.setTextColor(Color.WHITE);
        lengthOptionsOut.setAdapter(lengthOptionsDark);
        lengthOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            lcButtons.setBackgroundColor(Color.BLACK);
        }else {
            lcButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setlcPageLight(){
        lcOneButton.setTextColor(Color.BLACK);
        lcTwoButton.setTextColor(Color.BLACK);
        lcThreeButton.setTextColor(Color.BLACK);
        lcFourButton.setTextColor(Color.BLACK);
        lcFiveButton.setTextColor(Color.BLACK);
        lcSixButton.setTextColor(Color.BLACK);
        lcSevenButton.setTextColor(Color.BLACK);
        lcEightButton.setTextColor(Color.BLACK);
        lcNineButton.setTextColor(Color.BLACK);
        lcZeroButton.setTextColor(Color.BLACK);
        lcPosNegButton.setTextColor(Color.BLACK);
        lcPeriodButton.setTextColor(Color.BLACK);
        lcDeleteButton.setTextColor(Color.BLACK);
        lcCancelButton.setTextColor(Color.BLACK);

        lengthTextInput.setTextColor(Color.BLACK);
        lengthOptionsIn.setAdapter(lengthOptionsLight);
        lengthOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        lengthTextOutput.setTextColor(Color.BLACK);
        lengthOptionsOut.setAdapter(lengthOptionsLight);
        lengthOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        lcButtons.setBackgroundColor(Color.WHITE);
    }

    public void setWcPageDark(Boolean amoled){
        wcOneButton.setTextColor(Color.WHITE);
        wcTwoButton.setTextColor(Color.WHITE);
        wcThreeButton.setTextColor(Color.WHITE);
        wcFourButton.setTextColor(Color.WHITE);
        wcFiveButton.setTextColor(Color.WHITE);
        wcSixButton.setTextColor(Color.WHITE);
        wcSevenButton.setTextColor(Color.WHITE);
        wcEightButton.setTextColor(Color.WHITE);
        wcNineButton.setTextColor(Color.WHITE);
        wcZeroButton.setTextColor(Color.WHITE);
        wcPosNegButton.setTextColor(Color.WHITE);
        wcPeriodButton.setTextColor(Color.WHITE);
        wcDeleteButton.setTextColor(Color.WHITE);
        wcCancelButton.setTextColor(Color.WHITE);

        weightTextInput.setTextColor(Color.WHITE);
        weightOptionsIn.setAdapter(weightOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        weightOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        weightTextOutput.setTextColor(Color.WHITE);
        weightOptionsOut.setAdapter(weightOptionsDark);
        weightOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            wcButtons.setBackgroundColor(Color.BLACK);
        }else {
            wcButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setWcPageLight(){
        wcOneButton.setTextColor(Color.BLACK);
        wcTwoButton.setTextColor(Color.BLACK);
        wcThreeButton.setTextColor(Color.BLACK);
        wcFourButton.setTextColor(Color.BLACK);
        wcFiveButton.setTextColor(Color.BLACK);
        wcSixButton.setTextColor(Color.BLACK);
        wcSevenButton.setTextColor(Color.BLACK);
        wcEightButton.setTextColor(Color.BLACK);
        wcNineButton.setTextColor(Color.BLACK);
        wcZeroButton.setTextColor(Color.BLACK);
        wcPosNegButton.setTextColor(Color.BLACK);
        wcPeriodButton.setTextColor(Color.BLACK);
        wcDeleteButton.setTextColor(Color.BLACK);
        wcCancelButton.setTextColor(Color.BLACK);

        weightTextInput.setTextColor(Color.BLACK);
        weightOptionsIn.setAdapter(weightOptionsLight);
        weightOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        weightTextOutput.setTextColor(Color.BLACK);
        weightOptionsOut.setAdapter(weightOptionsLight);
        weightOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        wcButtons.setBackgroundColor(Color.WHITE);
    }

    public void setVcPageDark(Boolean amoled){
        vcOneButton.setTextColor(Color.WHITE);
        vcTwoButton.setTextColor(Color.WHITE);
        vcThreeButton.setTextColor(Color.WHITE);
        vcFourButton.setTextColor(Color.WHITE);
        vcFiveButton.setTextColor(Color.WHITE);
        vcSixButton.setTextColor(Color.WHITE);
        vcSevenButton.setTextColor(Color.WHITE);
        vcEightButton.setTextColor(Color.WHITE);
        vcNineButton.setTextColor(Color.WHITE);
        vcZeroButton.setTextColor(Color.WHITE);
        vcPosNegButton.setTextColor(Color.WHITE);
        vcPeriodButton.setTextColor(Color.WHITE);
        vcDeleteButton.setTextColor(Color.WHITE);
        vcCancelButton.setTextColor(Color.WHITE);

        volumeTextInput.setTextColor(Color.WHITE);
        volumeOptionsIn.setAdapter(volumeOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        volumeOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        volumeTextOutput.setTextColor(Color.WHITE);
        volumeOptionsOut.setAdapter(volumeOptionsDark);
        volumeOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            vcButtons.setBackgroundColor(Color.BLACK);
        }else {
            vcButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setVcPageLight(){
        vcOneButton.setTextColor(Color.BLACK);
        vcTwoButton.setTextColor(Color.BLACK);
        vcThreeButton.setTextColor(Color.BLACK);
        vcFourButton.setTextColor(Color.BLACK);
        vcFiveButton.setTextColor(Color.BLACK);
        vcSixButton.setTextColor(Color.BLACK);
        vcSevenButton.setTextColor(Color.BLACK);
        vcEightButton.setTextColor(Color.BLACK);
        vcNineButton.setTextColor(Color.BLACK);
        vcZeroButton.setTextColor(Color.BLACK);
        vcPosNegButton.setTextColor(Color.BLACK);
        vcPeriodButton.setTextColor(Color.BLACK);
        vcDeleteButton.setTextColor(Color.BLACK);
        vcCancelButton.setTextColor(Color.BLACK);

        volumeTextInput.setTextColor(Color.BLACK);
        volumeOptionsIn.setAdapter(volumeOptionsLight);
        volumeOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        volumeTextOutput.setTextColor(Color.BLACK);
        volumeOptionsOut.setAdapter(volumeOptionsLight);
        volumeOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        vcButtons.setBackgroundColor(Color.WHITE);
    }

    public void setAcPageDark(Boolean amoled){
        acOneButton.setTextColor(Color.WHITE);
        acTwoButton.setTextColor(Color.WHITE);
        acThreeButton.setTextColor(Color.WHITE);
        acFourButton.setTextColor(Color.WHITE);
        acFiveButton.setTextColor(Color.WHITE);
        acSixButton.setTextColor(Color.WHITE);
        acSevenButton.setTextColor(Color.WHITE);
        acEightButton.setTextColor(Color.WHITE);
        acNineButton.setTextColor(Color.WHITE);
        acZeroButton.setTextColor(Color.WHITE);
        acPosNegButton.setTextColor(Color.WHITE);
        acPeriodButton.setTextColor(Color.WHITE);
        acDeleteButton.setTextColor(Color.WHITE);
        acCancelButton.setTextColor(Color.WHITE);

        areaTextInput.setTextColor(Color.WHITE);
        areaOptionsIn.setAdapter(areaOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        areaOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        areaTextOutput.setTextColor(Color.WHITE);
        areaOptionsOut.setAdapter(areaOptionsDark);
        areaOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            acButtons.setBackgroundColor(Color.BLACK);
        }else {
            acButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setAcPageLight(){
        acOneButton.setTextColor(Color.BLACK);
        acTwoButton.setTextColor(Color.BLACK);
        acThreeButton.setTextColor(Color.BLACK);
        acFourButton.setTextColor(Color.BLACK);
        acFiveButton.setTextColor(Color.BLACK);
        acSixButton.setTextColor(Color.BLACK);
        acSevenButton.setTextColor(Color.BLACK);
        acEightButton.setTextColor(Color.BLACK);
        acNineButton.setTextColor(Color.BLACK);
        acZeroButton.setTextColor(Color.BLACK);
        acPosNegButton.setTextColor(Color.BLACK);
        acPeriodButton.setTextColor(Color.BLACK);
        acDeleteButton.setTextColor(Color.BLACK);
        acCancelButton.setTextColor(Color.BLACK);

        areaTextInput.setTextColor(Color.BLACK);
        areaOptionsIn.setAdapter(areaOptionsLight);
        areaOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        areaTextOutput.setTextColor(Color.BLACK);
        areaOptionsOut.setAdapter(areaOptionsLight);
        areaOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        acButtons.setBackgroundColor(Color.WHITE);
    }

    public void setTcPageDark(Boolean amoled){
        tcOneButton.setTextColor(Color.WHITE);
        tcTwoButton.setTextColor(Color.WHITE);
        tcThreeButton.setTextColor(Color.WHITE);
        tcFourButton.setTextColor(Color.WHITE);
        tcFiveButton.setTextColor(Color.WHITE);
        tcSixButton.setTextColor(Color.WHITE);
        tcSevenButton.setTextColor(Color.WHITE);
        tcEightButton.setTextColor(Color.WHITE);
        tcNineButton.setTextColor(Color.WHITE);
        tcZeroButton.setTextColor(Color.WHITE);
        tcPosNegButton.setTextColor(Color.WHITE);
        tcPeriodButton.setTextColor(Color.WHITE);
        tcDeleteButton.setTextColor(Color.WHITE);
        tcCancelButton.setTextColor(Color.WHITE);

        temperatureTextInput.setTextColor(Color.WHITE);
        tempOptionsIn.setAdapter(temperatureOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        tempOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        temperatureTextOutput.setTextColor(Color.WHITE);
        tempOptionsOut.setAdapter(temperatureOptionsDark);
        tempOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            tcButtons.setBackgroundColor(Color.BLACK);
        }else {
            tcButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setTcPageLight(){
        tcOneButton.setTextColor(Color.BLACK);
        tcTwoButton.setTextColor(Color.BLACK);
        tcThreeButton.setTextColor(Color.BLACK);
        tcFourButton.setTextColor(Color.BLACK);
        tcFiveButton.setTextColor(Color.BLACK);
        tcSixButton.setTextColor(Color.BLACK);
        tcSevenButton.setTextColor(Color.BLACK);
        tcEightButton.setTextColor(Color.BLACK);
        tcNineButton.setTextColor(Color.BLACK);
        tcZeroButton.setTextColor(Color.BLACK);
        tcPosNegButton.setTextColor(Color.BLACK);
        tcPeriodButton.setTextColor(Color.BLACK);
        tcDeleteButton.setTextColor(Color.BLACK);
        tcCancelButton.setTextColor(Color.BLACK);

        temperatureTextInput.setTextColor(Color.BLACK);
        tempOptionsIn.setAdapter(temperatureOptionsLight);
        tempOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        temperatureTextOutput.setTextColor(Color.BLACK);
        tempOptionsOut.setAdapter(temperatureOptionsLight);
        tempOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        tcButtons.setBackgroundColor(Color.WHITE);
    }

    public void setPcPageDark(Boolean amoled){
        pcOneButton.setTextColor(Color.WHITE);
        pcTwoButton.setTextColor(Color.WHITE);
        pcThreeButton.setTextColor(Color.WHITE);
        pcFourButton.setTextColor(Color.WHITE);
        pcFiveButton.setTextColor(Color.WHITE);
        pcSixButton.setTextColor(Color.WHITE);
        pcSevenButton.setTextColor(Color.WHITE);
        pcEightButton.setTextColor(Color.WHITE);
        pcNineButton.setTextColor(Color.WHITE);
        pcZeroButton.setTextColor(Color.WHITE);
        pcPosNegButton.setTextColor(Color.WHITE);
        pcPeriodButton.setTextColor(Color.WHITE);
        pcDeleteButton.setTextColor(Color.WHITE);
        pcCancelButton.setTextColor(Color.WHITE);

        pressureTextInput.setTextColor(Color.WHITE);
        pressureOptionsIn.setAdapter(pressureOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        pressureOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        pressureTextOutput.setTextColor(Color.WHITE);
        pressureOptionsOut.setAdapter(pressureOptionsDark);
        pressureOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            pcButtons.setBackgroundColor(Color.BLACK);
        }else {
            pcButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setPcPageLight(){
        pcOneButton.setTextColor(Color.BLACK);
        pcTwoButton.setTextColor(Color.BLACK);
        pcThreeButton.setTextColor(Color.BLACK);
        pcFourButton.setTextColor(Color.BLACK);
        pcFiveButton.setTextColor(Color.BLACK);
        pcSixButton.setTextColor(Color.BLACK);
        pcSevenButton.setTextColor(Color.BLACK);
        pcEightButton.setTextColor(Color.BLACK);
        pcNineButton.setTextColor(Color.BLACK);
        pcZeroButton.setTextColor(Color.BLACK);
        pcPosNegButton.setTextColor(Color.BLACK);
        pcPeriodButton.setTextColor(Color.BLACK);
        pcDeleteButton.setTextColor(Color.BLACK);
        pcCancelButton.setTextColor(Color.BLACK);

        pressureTextInput.setTextColor(Color.BLACK);
        pressureOptionsIn.setAdapter(pressureOptionsLight);
        pressureOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        pressureTextOutput.setTextColor(Color.BLACK);
        pressureOptionsOut.setAdapter(pressureOptionsLight);
        pressureOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        pcButtons.setBackgroundColor(Color.WHITE);
    }

    public void setSpcPageDark(Boolean amoled){
        spcOneButton.setTextColor(Color.WHITE);
        spcTwoButton.setTextColor(Color.WHITE);
        spcThreeButton.setTextColor(Color.WHITE);
        spcFourButton.setTextColor(Color.WHITE);
        spcFiveButton.setTextColor(Color.WHITE);
        spcSixButton.setTextColor(Color.WHITE);
        spcSevenButton.setTextColor(Color.WHITE);
        spcEightButton.setTextColor(Color.WHITE);
        spcNineButton.setTextColor(Color.WHITE);
        spcZeroButton.setTextColor(Color.WHITE);
        spcPosNegButton.setTextColor(Color.WHITE);
        spcPeriodButton.setTextColor(Color.WHITE);
        spcDeleteButton.setTextColor(Color.WHITE);
        spcCancelButton.setTextColor(Color.WHITE);

        speedTextInput.setTextColor(Color.WHITE);
        speedOptionsIn.setAdapter(speedOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        speedOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        speedTextOutput.setTextColor(Color.WHITE);
        speedOptionsOut.setAdapter(speedOptionsDark);
        speedOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            spcButtons.setBackgroundColor(Color.BLACK);
        }else {
            spcButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setSpcPageLight(){
        spcOneButton.setTextColor(Color.BLACK);
        spcTwoButton.setTextColor(Color.BLACK);
        spcThreeButton.setTextColor(Color.BLACK);
        spcFourButton.setTextColor(Color.BLACK);
        spcFiveButton.setTextColor(Color.BLACK);
        spcSixButton.setTextColor(Color.BLACK);
        spcSevenButton.setTextColor(Color.BLACK);
        spcEightButton.setTextColor(Color.BLACK);
        spcNineButton.setTextColor(Color.BLACK);
        spcZeroButton.setTextColor(Color.BLACK);
        spcPosNegButton.setTextColor(Color.BLACK);
        spcPeriodButton.setTextColor(Color.BLACK);
        spcDeleteButton.setTextColor(Color.BLACK);
        spcCancelButton.setTextColor(Color.BLACK);

        speedTextInput.setTextColor(Color.BLACK);
        speedOptionsIn.setAdapter(speedOptionsLight);
        speedOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        speedTextOutput.setTextColor(Color.BLACK);
        speedOptionsOut.setAdapter(speedOptionsLight);
        speedOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        spcButtons.setBackgroundColor(Color.WHITE);
    }

    public void setPocPageDark(Boolean amoled){
        pocOneButton.setTextColor(Color.WHITE);
        pocTwoButton.setTextColor(Color.WHITE);
        pocThreeButton.setTextColor(Color.WHITE);
        pocFourButton.setTextColor(Color.WHITE);
        pocFiveButton.setTextColor(Color.WHITE);
        pocSixButton.setTextColor(Color.WHITE);
        pocSevenButton.setTextColor(Color.WHITE);
        pocEightButton.setTextColor(Color.WHITE);
        pocNineButton.setTextColor(Color.WHITE);
        pocZeroButton.setTextColor(Color.WHITE);
        pocPosNegButton.setTextColor(Color.WHITE);
        pocPeriodButton.setTextColor(Color.WHITE);
        pocDeleteButton.setTextColor(Color.WHITE);
        pocCancelButton.setTextColor(Color.WHITE);

        powerTextInput.setTextColor(Color.WHITE);
        powerOptionsIn.setAdapter(powerOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        powerOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        powerTextOutput.setTextColor(Color.WHITE);
        powerOptionsOut.setAdapter(powerOptionsDark);
        powerOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            pocButtons.setBackgroundColor(Color.BLACK);
        }else {
            pocButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setPocPageLight(){
        pocOneButton.setTextColor(Color.BLACK);
        pocTwoButton.setTextColor(Color.BLACK);
        pocThreeButton.setTextColor(Color.BLACK);
        pocFourButton.setTextColor(Color.BLACK);
        pocFiveButton.setTextColor(Color.BLACK);
        pocSixButton.setTextColor(Color.BLACK);
        pocSevenButton.setTextColor(Color.BLACK);
        pocEightButton.setTextColor(Color.BLACK);
        pocNineButton.setTextColor(Color.BLACK);
        pocZeroButton.setTextColor(Color.BLACK);
        pocPosNegButton.setTextColor(Color.BLACK);
        pocPeriodButton.setTextColor(Color.BLACK);
        pocDeleteButton.setTextColor(Color.BLACK);
        pocCancelButton.setTextColor(Color.BLACK);

        powerTextInput.setTextColor(Color.BLACK);
        powerOptionsIn.setAdapter(powerOptionsLight);
        powerOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        powerTextOutput.setTextColor(Color.BLACK);
        powerOptionsOut.setAdapter(powerOptionsLight);
        powerOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        pocButtons.setBackgroundColor(Color.WHITE);
    }

    public void setFccPageDark(Boolean amoled){
        fccOneButton.setTextColor(Color.WHITE);
        fccTwoButton.setTextColor(Color.WHITE);
        fccThreeButton.setTextColor(Color.WHITE);
        fccFourButton.setTextColor(Color.WHITE);
        fccFiveButton.setTextColor(Color.WHITE);
        fccSixButton.setTextColor(Color.WHITE);
        fccSevenButton.setTextColor(Color.WHITE);
        fccEightButton.setTextColor(Color.WHITE);
        fccNineButton.setTextColor(Color.WHITE);
        fccZeroButton.setTextColor(Color.WHITE);
        fccPosNegButton.setTextColor(Color.WHITE);
        fccPeriodButton.setTextColor(Color.WHITE);
        fccDeleteButton.setTextColor(Color.WHITE);
        fccCancelButton.setTextColor(Color.WHITE);

        fuelTextInput.setTextColor(Color.WHITE);
        fuelOptionsIn.setAdapter(fuelOptionsDark);
        //This is to change the color of the arrow (credits to @toni on stackoverflow)
        fuelOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        fuelTextOutput.setTextColor(Color.WHITE);
        fuelOptionsOut.setAdapter(fuelOptionsDark);
        fuelOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        if (amoled){
            fccButtons.setBackgroundColor(Color.BLACK);
        }else {
            fccButtons.setBackgroundColor(Color.parseColor("#757575"));
        }
    }
    public void setFccPageLight(){
        fccOneButton.setTextColor(Color.BLACK);
        fccTwoButton.setTextColor(Color.BLACK);
        fccThreeButton.setTextColor(Color.BLACK);
        fccFourButton.setTextColor(Color.BLACK);
        fccFiveButton.setTextColor(Color.BLACK);
        fccSixButton.setTextColor(Color.BLACK);
        fccSevenButton.setTextColor(Color.BLACK);
        fccEightButton.setTextColor(Color.BLACK);
        fccNineButton.setTextColor(Color.BLACK);
        fccZeroButton.setTextColor(Color.BLACK);
        fccPosNegButton.setTextColor(Color.BLACK);
        fccPeriodButton.setTextColor(Color.BLACK);
        fccDeleteButton.setTextColor(Color.BLACK);
        fccCancelButton.setTextColor(Color.BLACK);

        fuelTextInput.setTextColor(Color.BLACK);
        fuelOptionsIn.setAdapter(fuelOptionsLight);
        fuelOptionsIn.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        fuelTextOutput.setTextColor(Color.BLACK);
        fuelOptionsOut.setAdapter(fuelOptionsLight);
        fuelOptionsOut.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        fccButtons.setBackgroundColor(Color.WHITE);
    }



    //Adjust selection of menus in main navigation as well as bottom navigation
    public class menuSelector{
        public void selectBasicCalculator(){
            basicCalView.setVisibility(VISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(true);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectScientificCalculator(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(VISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(true);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }

        public void selectCurrencyConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(VISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(true);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectLengthConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(VISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(true);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectWeightConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(VISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(true);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectVolumeConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(VISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(true);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectAreaConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(VISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(true);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectTemperatureConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(VISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(true);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectPressureConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(VISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(true);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectSpeedConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(VISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(true);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }
        public void selectPowerConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(VISIBLE);
            fuelConverter.setVisibility(INVISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(true);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(false);
        }

        public void selectFuelConsumptionConverter(){
            basicCalView.setVisibility(INVISIBLE);
            scientificCalView.setVisibility(INVISIBLE);
            currencyConverter.setVisibility(INVISIBLE);
            lengthConverter.setVisibility(INVISIBLE);
            weightConverter.setVisibility(INVISIBLE);
            volumeConverter.setVisibility(INVISIBLE);
            areaConverter.setVisibility(INVISIBLE);
            temperatureConverter.setVisibility(INVISIBLE);
            pressureConverter.setVisibility(INVISIBLE);
            speedConverter.setVisibility(INVISIBLE);
            powerConverter.setVisibility(INVISIBLE);
            fuelConverter.setVisibility(VISIBLE);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(0).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(0).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(3).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(4).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(5).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(6).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(7).setChecked(false);
            navigationView.getMenu().getItem(1).getSubMenu().getItem(8).setChecked(true);
        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Multiplex Calculator");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //Fetch User-Saved Settings
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        //Fetch Dark Mode Toggle Setting
        switchPref = sharedPref.getBoolean(SettingsActivity.DARK_MODE_SWITCH, false);
        amoledPref = sharedPref.getBoolean(SettingsActivity.AMOLED_MODE_SWITCH, false);

        //Fetch user's favourite tools
        favShortcut1 = sharedPref.getString(SettingsActivity.FAV_SHORTCUT1, "Basic Calculator");
        favShortcut2 = sharedPref.getString(SettingsActivity.FAV_SHORTCUT2, "Scientific Calculator");
        favShortcut3 = sharedPref.getString(SettingsActivity.FAV_SHORTCUT3, "Length Converter");

//        changeBottomNavIcons(0, favShortcut1);
//        changeBottomNavIcons(1, favShortcut2);
//        changeBottomNavIcons(2, favShortcut3);

        //
        navigationView = (NavigationView) findViewById(R.id.nav_view);



        //Change colors of nav menu titles
        //FIND A BETTER WAY TO IMPLEMENT THIS!!!!!!!!
        navigationMenu = navigationView.getMenu();
        navTitleCalculator = navigationMenu.findItem(R.id.calculator_title);
        SpannableString navTitleCalculatorString = new SpannableString(navTitleCalculator.getTitle());
        navTitleConverters = navigationMenu.findItem(R.id.converters_title);
        SpannableString navTitleConvertersString = new SpannableString(navTitleConverters.getTitle());
        navTitleConfigure = navigationMenu.findItem(R.id.configure_title);
        SpannableString navTitleConfigureString = new SpannableString(navTitleConfigure.getTitle());





        navigationView.setNavigationItemSelectedListener(this);

//        navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(true);

//        randomText = findViewById(R.id.textView);

        //----------------------INITIALIZE DISPLAYS FOR EACH TOOL----------------------------------

        bcDisplay = findViewById(R.id.bcDisplay);
        bcDisplay.setText("0");
        bcEngine = new BasicCalculator(this.bcDisplay);

        scDisplay = findViewById(R.id.scDisplay);
        scDisplay.setText("0");
        scEngine = new ScientificCalculator(scDisplay, this);

        currencyTextInput = findViewById(R.id.currencyTextInput);
        currencyTextOutput = findViewById(R.id.currencyTextOutput);
        currencyTextInput.setText("0");
        currencyTextOutput.setText("0");
        ccEngine = new CurrencyConverter(this.currencyTextInput, this.currencyTextOutput);

        lengthTextInput = findViewById(R.id.lengthTextInput);
        lengthTextOutput = findViewById(R.id.lengthTextOutput);
        lengthTextInput.setText("0");
        lengthTextOutput.setText("0");
        lengthOptionsIn = findViewById(R.id.lengthOptionsIn);
        lengthOptionsOut = findViewById(R.id.lengthOptionsOut);
        lcEngine = new LengthConverter(this.lengthTextInput, this.lengthTextOutput, lengthOptionsIn, lengthOptionsOut);


        weightTextInput = findViewById(R.id.weightTextInput);
        weightTextOutput = findViewById(R.id.weightTextOutput);
        weightTextInput.setText("0");
        weightTextOutput.setText("0");
        weightOptionsIn = findViewById(R.id.weightOptionsIn);
        weightOptionsOut = findViewById(R.id.weightOptionsOut);
        wcEngine = new WeightConverter(this.weightTextInput, this.weightTextOutput, weightOptionsIn, weightOptionsOut);


        volumeTextInput = findViewById(R.id.volumeTextInput);
        volumeTextOutput = findViewById(R.id.volumeTextOutput);
        volumeTextInput.setText("0");
        volumeTextOutput.setText("0");
        volumeOptionsIn = findViewById(R.id.volumeOptionsIn);
        volumeOptionsOut = findViewById(R.id.volumeOptionsOut);
        vcEngine = new VolumeConverter(this.volumeTextInput, this.volumeTextOutput, volumeOptionsIn, volumeOptionsOut);


        areaTextInput = findViewById(R.id.areaTextInput);
        areaTextOutput = findViewById(R.id.areaTextOutput);
        areaTextInput.setText("0");
        areaTextOutput.setText("0");
        areaOptionsIn = findViewById(R.id.areaOptionsIn);
        areaOptionsOut = findViewById(R.id.areaOptionsOut);
        acEngine = new AreaConverter(this.areaTextInput, this.areaTextOutput, areaOptionsIn, areaOptionsOut);


        temperatureTextInput = findViewById(R.id.tempTextInput);
        temperatureTextOutput = findViewById(R.id.tempTextOutput);
        temperatureTextInput.setText("0");
        temperatureTextOutput.setText("0");
        tempOptionsIn = findViewById(R.id.tempOptionsIn);
        tempOptionsOut = findViewById(R.id.tempOptionsOut);
        tcEngine = new TemperatureConverter(this.temperatureTextInput, this.temperatureTextOutput, tempOptionsIn, tempOptionsOut);


        pressureTextInput = findViewById(R.id.pressureTextInput);
        pressureTextOutput = findViewById(R.id.pressureTextOutput);
        pressureTextInput.setText("0");
        pressureTextOutput.setText("0");
        pressureOptionsIn = findViewById(R.id.pressureOptionsIn);
        pressureOptionsOut = findViewById(R.id.pressureOptionsOut);
        pcEngine = new PressureConverter(this.pressureTextInput, this.pressureTextOutput, pressureOptionsIn, pressureOptionsOut);


        speedTextInput = findViewById(R.id.speedTextInput);
        speedTextOutput = findViewById(R.id.speedTextOutput);
        speedTextInput.setText("0");
        speedTextOutput.setText("0");
        speedOptionsIn = findViewById(R.id.speedOptionsIn);
        speedOptionsOut = findViewById(R.id.speedOptionsOut);
        spcEngine = new SpeedConverter(this.speedTextInput, this.speedTextOutput, speedOptionsIn, speedOptionsOut);


        powerTextInput = findViewById(R.id.powerTextInput);
        powerTextOutput = findViewById(R.id.powerTextOutput);
        powerTextInput.setText("0");
        powerTextOutput.setText("0");
        powerOptionsIn = findViewById(R.id.powerOptionsIn);
        powerOptionsOut = findViewById(R.id.powerOptionsOut);
        pocEngine = new PowerConverter(this.powerTextInput, this.powerTextOutput, powerOptionsIn, powerOptionsOut);


        fuelTextInput = findViewById(R.id.fuelTextInput);
        fuelTextOutput = findViewById(R.id.fuelTextOutput);
        fuelTextInput.setText("0");
        fuelTextOutput.setText("0");
        fuelOptionsIn = findViewById(R.id.fuelOptionsIn);
        fuelOptionsOut = findViewById(R.id.fuelOptionsOut);
        fccEngine = new FuelConsumptionConverter(this.fuelTextInput, this.fuelTextOutput, fuelOptionsIn, fuelOptionsOut);


        //---------------------------------------------------------------------------------------


        basicCalView = findViewById(R.id.basicCalView);
        scientificCalView = findViewById(R.id.scientificCalView);
        currencyConverter = findViewById(R.id.currencyView);
        lengthConverter = findViewById(R.id.lengthView);
        weightConverter = findViewById(R.id.weightView);
        volumeConverter = findViewById(R.id.volumeView);
        areaConverter = findViewById(R.id.areaView);
        temperatureConverter = findViewById(R.id.temperatureView);
        pressureConverter = findViewById(R.id.pressureView);
        speedConverter = findViewById(R.id.speedView);
        powerConverter = findViewById(R.id.powerView);
        fuelConverter = findViewById(R.id.fuelView);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_bottom);

        //Activate all buttons in all pages
        initializeBcButtons();
        initializeScButtons();
        initializeLcButtons();
        initializeWcButtons();
        initializeVcButtons();
        initializeAcButtons();
        initializeTcButtons();
        initializePcButtons();
        initializeSpcButtons();
        initializePocButtons();
        initializeFccButtons();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        bottomNavigationView.getMenu().getItem(0).setCheckable(true);
                        bottomNavigationView.getMenu().getItem(1).setCheckable(true);
                        bottomNavigationView.getMenu().getItem(2).setCheckable(true);

                        if (id == R.id.nav_shortcut1) {
                            selectAppropriatePage(favShortcut1);
                            bottomNavigationView.getMenu().getItem(0).setChecked(true);
                            bottomNavigationView.getMenu().getItem(1).setChecked(false);
                            bottomNavigationView.getMenu().getItem(2).setChecked(false);
                        } else if (id == R.id.nav_shortcut2) {
                            selectAppropriatePage(favShortcut2);
                            bottomNavigationView.getMenu().getItem(0).setChecked(false);
                            bottomNavigationView.getMenu().getItem(1).setChecked(true);
                            bottomNavigationView.getMenu().getItem(2).setChecked(false);
                        } else if (id == R.id.nav_shortcut3) {
                            selectAppropriatePage(favShortcut3);
                            bottomNavigationView.getMenu().getItem(0).setChecked(false);
                            bottomNavigationView.getMenu().getItem(1).setChecked(false);
                            bottomNavigationView.getMenu().getItem(2).setChecked(true);
                        }
                        return true;
                    }
                });

        bottomNavigationView.getMenu().getItem(0).setTitle(favShortcut1);
        bottomNavigationView.getMenu().getItem(1).setTitle(favShortcut2);
        bottomNavigationView.getMenu().getItem(2).setTitle(favShortcut3);


        if (switchPref){
            if (amoledPref){
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#2e2e2d"));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e2e2d")));
                getWindow().setStatusBarColor(Color.BLACK);
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#2e2e2d"));
                ((Activity)this).setTaskDescription(taskDescription);
                navigationView.setBackgroundColor(Color.BLACK);
                bottomNavigationView.setBackgroundColor(Color.parseColor("#2e2e2d"));
            }else{
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#4d4d4d"));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00463E")));
                getWindow().setStatusBarColor(Color.parseColor("#FF003C35"));
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00463E"));
                ((Activity)this).setTaskDescription(taskDescription);
                navigationView.setBackgroundColor(Color.parseColor("#4d4d4d"));
                bottomNavigationView.setBackgroundColor(Color.parseColor("#FF00463E"));
            }

            bottomNavigationView.setItemTextColor(darkTheme);
            bottomNavigationView.setItemIconTintList(darkTheme);
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
            navigationView.setItemIconTintList(ColorStateList.valueOf(Color.WHITE));

            //Change Colour of Group Titles
            navTitleCalculatorString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDark), 0, navTitleCalculatorString.length(), 0);
            navTitleCalculator.setTitle(navTitleCalculatorString);
            navTitleConvertersString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDark), 0, navTitleConvertersString.length(), 0);
            navTitleConverters.setTitle(navTitleConvertersString);
            navTitleConfigureString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDark), 0, navTitleConfigureString.length(), 0);
            navTitleConfigure.setTitle(navTitleConfigureString);



            setBcPageDark(amoledPref);
            setScPageDark(amoledPref);
            setlcPageDark(amoledPref);
            setWcPageDark(amoledPref);
            setVcPageDark(amoledPref);
            setAcPageDark(amoledPref);
            setTcPageDark(amoledPref);
            setPcPageDark(amoledPref);
            setSpcPageDark(amoledPref);
            setPocPageDark(amoledPref);
            setFccPageDark(amoledPref);

        }else{
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00A192")));
            getWindow().setStatusBarColor(Color.parseColor("#FF006E60"));
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00A192"));
            ((Activity)this).setTaskDescription(taskDescription);

            bottomNavigationView.setBackgroundColor(Color.parseColor("#CEEAE7"));
            bottomNavigationView.setItemTextColor(defaultTheme);
            bottomNavigationView.setItemIconTintList(defaultTheme);

            navigationView.setBackgroundColor(Color.WHITE);
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
            navigationView.setItemIconTintList(ColorStateList.valueOf(Color.BLACK));

            //Change Colour of Group Titles
            navTitleCalculatorString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDefault), 0, navTitleCalculatorString.length(), 0);
            navTitleCalculator.setTitle(navTitleCalculatorString);
            navTitleConvertersString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDefault), 0, navTitleConvertersString.length(), 0);
            navTitleConverters.setTitle(navTitleConvertersString);
            navTitleConfigureString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDefault), 0, navTitleConfigureString.length(), 0);
            navTitleConfigure.setTitle(navTitleConfigureString);

            setBcPageLight();
            setScPageLight();
            setlcPageLight();
            setWcPageLight();
            setVcPageLight();
            setAcPageLight();
            setTcPageLight();
            setPcPageLight();
            setSpcPageLight();
            setPocPageLight();
            setFccPageLight();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//            alertDialog.setTitle("Settings");
//            alertDialog.setMessage("Display Settings Here!");
//            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                    new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//            alertDialog.show();
//            return true;
//        }

        miscIntent = new Intent(this, SettingsActivity.class);
        startActivity(miscIntent);

        return super.onOptionsItemSelected(item);
    }

    public void highlightAppropriateBottomIcon(int icon){
        for (int i = 0; i < 3; i ++){
//            int id2 = bottomNavigationView.getMenu().getItem(i).getItemId();
//            int someicon = R.drawable.ruler;
//
//            if (id == 1){
//                //do something
//            }
//            if (bottomNavigationView.getMenu().getItem(i).getIcon().getAlpha() == icon){
//                bottomNavigationView.getMenu().getItem(i).setChecked(true);
//            }
        }
    }

    public void highlightBottonNavIcon(String name){
        for (int i = 0; i < 3; i ++){
            if (bottomNavigationView.getMenu().getItem(i).getTitle().toString().equals(name)){
                bottomNavigationView.getMenu().getItem(0).setCheckable(true);
                bottomNavigationView.getMenu().getItem(1).setCheckable(true);
                bottomNavigationView.getMenu().getItem(2).setCheckable(true);
                bottomNavigationView.getMenu().getItem(i).setChecked(true);
            }
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        bottomNavigationView.getMenu().getItem(0).setCheckable(false);
        bottomNavigationView.getMenu().getItem(1).setCheckable(false);
        bottomNavigationView.getMenu().getItem(2).setCheckable(false);

        if (id == R.id.nav_basic_calculator) {
            mainSelector.selectBasicCalculator();
            highlightBottonNavIcon("Basic Calculator");
//            bottomNavigationView.getMenu().getItem(0).setChecked(true);
//            bottomNavigationView.getMenu().getItem(0).setTitle(favShortcut1);
            highlightAppropriateBottomIcon(R.drawable.calculator_basic);
        } else if (id == R.id.nav_scientific_calculator) {
            mainSelector.selectScientificCalculator();
            highlightBottonNavIcon("Scientific Calculator");
//            bottomNavigationView.getMenu().getItem(1).setChecked(true);
//            bottomNavigationView.getMenu().getItem(1).setTitle(favShortcut2);
            highlightAppropriateBottomIcon(R.drawable.calculator);

//        } else if (id == R.id.nav_currency) {
//            mainSelector.selectCurrencyConverter();
////            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
////            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
////            bottomNavigationView.getMenu().getItem(2).setCheckable(false);
//            highlightAppropriateBottomIcon(R.drawable.currency_usd);

        } else if (id == R.id.nav_length) {
            mainSelector.selectLengthConverter();
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(false);
            highlightAppropriateBottomIcon(R.drawable.ruler);
            highlightBottonNavIcon("Length Converter");

        } else if (id == R.id.nav_weight) {
            mainSelector.selectWeightConverter();
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(false);
            highlightAppropriateBottomIcon(R.drawable.weight);
            highlightBottonNavIcon("Weight Converter");

        } else if (id == R.id.nav_volume) {
            mainSelector.selectVolumeConverter();
            highlightBottonNavIcon("Volume Converter");
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(fals
            highlightAppropriateBottomIcon(R.drawable.volume);

        } else if (id == R.id.nav_area) {
            mainSelector.selectAreaConverter();
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(false)
            highlightBottonNavIcon("Area Converter");
            highlightAppropriateBottomIcon(R.drawable.area);

        } else if (id == R.id.nav_temp) {
            mainSelector.selectTemperatureConverter();
            highlightBottonNavIcon("Temperature Converter");
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(false);
            highlightAppropriateBottomIcon(R.drawable.thermometer);

        } else if (id == R.id.nav_pressure) {
            mainSelector.selectPressureConverter();
            highlightBottonNavIcon("Pressure Converter");
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(false);
            highlightAppropriateBottomIcon(R.drawable.pressure);

        } else if (id == R.id.nav_speed) {
            mainSelector.selectSpeedConverter();
            highlightBottonNavIcon("Speed Converter");
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(false)
            highlightAppropriateBottomIcon(R.drawable.speedometer);

        } else if (id == R.id.nav_power) {
            mainSelector.selectPowerConverter();
            highlightBottonNavIcon("Power Converter");
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(false);
            highlightAppropriateBottomIcon(R.drawable.flash_circle);

        } else if (id == R.id.nav_fuel) {
            mainSelector.selectFuelConsumptionConverter();
            highlightBottonNavIcon("Fuel Consumption Converter");
//            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//            bottomNavigationView.getMenu().getItem(2).setCheckable(false);
            highlightAppropriateBottomIcon(R.drawable.gas_station);

        }else if (id == R.id.nav_settings) {
            miscIntent = new Intent(this, SettingsActivity.class);
            startActivity(miscIntent);


        }else if (id == R.id.nav_share) {
            shareApp();

        }else if (id == R.id.nav_feedback){
            sendFeedback();
        }

//        bottomNavigationView.getMenu().getItem(0).setCheckable(true);
//        bottomNavigationView.getMenu().getItem(1).setCheckable(true);
//        bottomNavigationView.getMenu().getItem(2).setCheckable(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Initialize the navigation menu titles
        navigationMenu = navigationView.getMenu();
        navTitleCalculator = navigationMenu.findItem(R.id.calculator_title);
        SpannableString navTitleCalculatorString = new SpannableString(navTitleCalculator.getTitle());
        navTitleConverters = navigationMenu.findItem(R.id.converters_title);
        SpannableString navTitleConvertersString = new SpannableString(navTitleConverters.getTitle());
        navTitleConfigure = navigationMenu.findItem(R.id.configure_title);
        SpannableString navTitleConfigureString = new SpannableString(navTitleConfigure.getTitle());

        //Fetch User-Saved Settings
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        switchPref = sharedPref.getBoolean(SettingsActivity.DARK_MODE_SWITCH, false);
        amoledPref = sharedPref.getBoolean(SettingsActivity.AMOLED_MODE_SWITCH, false);

        if (switchPref){
            if (amoledPref){
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#2e2e2d"));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e2e2d")));
                getWindow().setStatusBarColor(Color.BLACK);
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#2e2e2d"));
                ((Activity)this).setTaskDescription(taskDescription);
                navigationView.setBackgroundColor(Color.BLACK);
                bottomNavigationView.setBackgroundColor(Color.parseColor("#2e2e2d"));
            }else{
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#4d4d4d"));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00463E")));
                getWindow().setStatusBarColor(Color.parseColor("#FF003C35"));
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00463E"));
                ((Activity)this).setTaskDescription(taskDescription);
                navigationView.setBackgroundColor(Color.parseColor("#4d4d4d"));
                bottomNavigationView.setBackgroundColor(Color.parseColor("#FF00463E"));
            }
            bottomNavigationView.setItemTextColor(darkTheme);
            bottomNavigationView.setItemIconTintList(darkTheme);
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
            navigationView.setItemIconTintList(ColorStateList.valueOf(Color.WHITE));

            navTitleCalculatorString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDark), 0, navTitleCalculatorString.length(), 0);
            navTitleCalculator.setTitle(navTitleCalculatorString);
            navTitleConvertersString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDark), 0, navTitleConvertersString.length(), 0);
            navTitleConverters.setTitle(navTitleConvertersString);
            navTitleConfigureString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDark), 0, navTitleConfigureString.length(), 0);
            navTitleConfigure.setTitle(navTitleConfigureString);

            setBcPageDark(amoledPref);
            setScPageDark(amoledPref);
            setlcPageDark(amoledPref);
            setWcPageDark(amoledPref);
            setVcPageDark(amoledPref);
            setAcPageDark(amoledPref);
            setTcPageDark(amoledPref);
            setPcPageDark(amoledPref);
            setSpcPageDark(amoledPref);
            setPocPageDark(amoledPref);
            setFccPageDark(amoledPref);
//            setTheme(R.style.SettingsFragmentStyleDark);
        }else{

            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00A192")));
            getWindow().setStatusBarColor(Color.parseColor("#FF006E60"));
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00A192"));
            ((Activity)this).setTaskDescription(taskDescription);

            bottomNavigationView.setBackgroundColor(Color.parseColor("#CEEAE7"));
            bottomNavigationView.setItemTextColor(defaultTheme);
            bottomNavigationView.setItemIconTintList(defaultTheme);

            navigationView.setBackgroundColor(Color.WHITE);
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
            navigationView.setItemIconTintList(ColorStateList.valueOf(Color.BLACK));

            //Change Colour of Group Titles
            navTitleCalculatorString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDefault), 0, navTitleCalculatorString.length(), 0);
            navTitleCalculator.setTitle(navTitleCalculatorString);
            navTitleConvertersString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDefault), 0, navTitleConvertersString.length(), 0);
            navTitleConverters.setTitle(navTitleConvertersString);
            navTitleConfigureString.setSpan(new TextAppearanceSpan(this, R.style.NavMenuTitleColorDefault), 0, navTitleConfigureString.length(), 0);
            navTitleConfigure.setTitle(navTitleConfigureString);

            setBcPageLight();
            setScPageLight();
            setlcPageLight();
            setWcPageLight();
            setVcPageLight();
            setAcPageLight();
            setTcPageLight();
            setPcPageLight();
            setSpcPageLight();
            setPocPageLight();
            setFccPageLight();
//            setTheme(R.style.SettingsFragmentStyle);
        }

        favShortcut1 = sharedPref.getString(SettingsActivity.FAV_SHORTCUT1, "Basic Calculator");
        favShortcut2 = sharedPref.getString(SettingsActivity.FAV_SHORTCUT2, "Scientific Calculator");
        favShortcut3 = sharedPref.getString(SettingsActivity.FAV_SHORTCUT3, "Length Converter");
        bottomNavigationView.getMenu().getItem(0).setTitle(favShortcut1);
        bottomNavigationView.getMenu().getItem(1).setTitle(favShortcut2);
        bottomNavigationView.getMenu().getItem(2).setTitle(favShortcut3);

        changeBottomNavIcons(0, favShortcut1);
        changeBottomNavIcons(1, favShortcut2);
        changeBottomNavIcons(2, favShortcut3);

        if (bottomNavigationView.getMenu().getItem(0).isChecked()){
            selectAppropriatePage(favShortcut1);
        }else if (bottomNavigationView.getMenu().getItem(1).isChecked()){
            selectAppropriatePage(favShortcut2);
        }else if (bottomNavigationView.getMenu().getItem(2).isChecked()){
            selectAppropriatePage(favShortcut3);
        }
    }


    public void shareApp(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String sharebodyText = "Your Sharing Message Goes Here";
        intent.putExtra(Intent.EXTRA_SUBJECT, "Multiplex Calculator");
        intent.putExtra(Intent.EXTRA_TEXT, sharebodyText);
        startActivity(Intent.createChooser(intent, "A all-in-one solution for calculating and converting"));
    }
    public void shareAppTrigger(View v){
        shareApp();
    }

    public void sendFeedback(){
        Intent intentFeedback = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:jpxsoftware@gmail.com?subject=" + " Multiplex Calculator Feedback");
        intentFeedback.setData(data);
        startActivity(intentFeedback);
    }


    public void adjustGrowingTextSize(){
        if (bcDisplay.length() > 10){
            bcDisplay.setTextSize(85);
        }
        if (bcDisplay.length() > 12){
            bcDisplay.setTextSize(65);
        }
        if (bcDisplay.length() > 15){
            bcDisplay.setTextSize(55);
        }
        if (bcDisplay.length() > 19){
            bcDisplay.setTextSize(45);
        }
        if (bcDisplay.length() > 25){
            bcDisplay.setTextSize(35);
        }
        if (bcDisplay.length() > 30){
            bcDisplay.setTextSize(25);
        }
    }

    public void adjustShrinkingTextSize(){
        if (bcDisplay.length() <= 30){
            bcDisplay.setTextSize(35);
        }
        if (bcDisplay.length() <= 25){
            bcDisplay.setTextSize(45);
        }
        if (bcDisplay.length() <= 19){
            bcDisplay.setTextSize(55);
        }
        if (bcDisplay.length() <= 15){
            bcDisplay.setTextSize(65);
        }
        if (bcDisplay.length() <= 12){
            bcDisplay.setTextSize(85);
        }
        if (bcDisplay.length() <= 10){
            bcDisplay.setTextSize(100);
        }
    }


    /***********************************************************************************************
     * Functions for Basic Calculator
     *********************************************************************************************/

    public void insertPeriod(View v){
        bcEngine.insertPeriod(v);
    }
    public void insertOne(View v){
        bcEngine.insertOne(v);
    }
    public void insertTwo(View v){
        bcEngine.insertTwo(v);
    }
    public void insertThree(View v){
        bcEngine.insertThree(v);
    }
    public void insertFour(View v){
        bcEngine.insertFour(v);
    }
    public void insertFive(View v){
        bcEngine.insertFive(v);
    }
    public void insertSix(View v){
        bcEngine.insertSix(v);
    }
    public void insertSeven(View v){
        bcEngine.insertSeven(v);
    }
    public void insertEight(View v){
        bcEngine.insertEight(v);
    }
    public void insertNine(View v){
        bcEngine.insertNine(v);
    }
    public void insertZero(View v){
        bcEngine.insertZero(v);
    }

    public void deleteDigit(View v){
        String decrementedDisplay = bcDisplay.getText().toString();

        if (decrementedDisplay.length() == 1){
            bcDisplay.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            bcDisplay.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = bcDisplay.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    bcDisplay.setText(currentDisplay);
                }

                if (bcDisplay.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(bcDisplay.getText());
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
                    bcDisplay.setText(newDisplay);
                }
            }
        }
        adjustShrinkingTextSize();
    }

    public void cancelEverything(View v){
        bcDisplay.setText("0");
        bcDisplay.setTextSize(100);
    }

    public void clearEntry(View v){
        bcDisplay.setText("0");
        bcDisplay.setTextSize(100);
    }

    public void changeSign(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (currentDisplay.startsWith("-")){
            bcDisplay.setText(bcDisplay.getText().toString().substring(1));
        }else if (!(currentDisplay.startsWith("0"))){
            bcDisplay.setText("-" + currentDisplay);
        }
    }

    public boolean checkInput(String currentDisplay){
        if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
            return false;
        }else{
            return true;
        }
    }

    public void insertPlus(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (!(currentDisplay.endsWith("+"))){
            bcDisplay.setText(bcDisplay.getText().toString() + "+");
        }
        adjustGrowingTextSize();

    }
    public void insertMinus(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (!(currentDisplay.endsWith("-"))){
            bcDisplay.setText(bcDisplay.getText().toString() + "-");
        }
        adjustGrowingTextSize();
    }
    public void insertTimes(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (!(currentDisplay.endsWith("x"))){
            bcDisplay.setText(bcDisplay.getText().toString() + "x");
        }
        adjustGrowingTextSize();
    }
    public void insertDivide(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (!(currentDisplay.endsWith("÷"))){
            bcDisplay.setText(bcDisplay.getText().toString() + "÷");
        }
        adjustGrowingTextSize();
    }

    public void squareRootEval(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (!(currentDisplay.contains("∞"))){
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                bcDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            try{
                bcDisplay.setText(currentNumString);
                BigDecimal result = null;
                result = new Expression(currentNumString).eval();
                double currentNumber = result.doubleValue();

                bcResult = Math.sqrt(currentNumber);
                bcDisplay.setText(Double.toString(bcResult));

                if (bcDisplay.getText().toString() == "NaN"){
                    throw new Exception();
                }

                //Adjust if it is a whole number (get rid of the .0)
                currentDisplay = bcDisplay.getText().toString();
                if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                        && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                    bcDisplay.setText(currentDisplay);
                }else{
                    bcDisplay.setTextSize(50);
                }
            }catch (Exception e){
                bcDisplay.setText("Invalid Input");
                disableInputBc();
            }
        }else{
            bcDisplay.setText("∞");
            bcDisplay.setTextSize(100);
        }
    }

    public void squaredEval(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (!(currentDisplay.contains("∞"))){
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                bcDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            bcDisplay.setText(currentNumString);

            BigDecimal result = null;
            try{
                result = new Expression(currentNumString).eval();
                double currentNumber = result.doubleValue();

                bcResult = Math.pow(currentNumber, 2);
                bcDisplay.setText(Double.toString(bcResult));

                if (bcDisplay.getText().toString() == "Infinity"){
                    bcDisplay.setText("∞");
                    bcDisplay.setTextSize(100);
                }else{
                    //Adjust if it is a whole number (get rid of the .0)
                    currentDisplay = bcDisplay.getText().toString();
                    if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                            && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                        currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                        bcDisplay.setText(currentDisplay);
                    }else{
                        bcDisplay.setTextSize(50);
                    }
                }
            }catch (Exception e){
                bcDisplay.setText("Invalid Input");
                disableInputBc();
            }
        }else{
            bcDisplay.setText("∞");
            bcDisplay.setTextSize(100);
        }
    }

    public void inverseX(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (currentDisplay.contains("∞")){
            bcDisplay.setText("∞");
            bcDisplay.setTextSize(100);
        }else{
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                bcDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            try {
                bcDisplay.setText(currentNumString);
                BigDecimal result = null;
                result = new Expression(currentNumString).eval();
                double currentNumber = result.doubleValue();


                bcResult = 1 / currentNumber;
                bcDisplay.setText(Double.toString(bcResult));

                if (bcDisplay.getText().toString() == "Infinity") {
                    bcDisplay.setText("∞");
                }
            }catch (Exception e){
                bcDisplay.setText("Invalid Input");
                disableInputBc();
            }
        }
    }

    public void percentEval(View v){
        String currentDisplay = bcDisplay.getText().toString();
        String previousDisplay = currentDisplay.toString();

        if (currentDisplay.contains("∞")){
            bcDisplay.setText("∞");
            bcDisplay.setTextSize(100);
        }else{
            ArrayList<Double> operands = new ArrayList<Double>();
            ArrayList<Character> operators = new ArrayList<Character>();

            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                String currentNumString = new String();
                for (int i = 0; i < currentDisplay.length(); i++){
                    if (!(currentDisplay.charAt(i) == ',')
                            && (!(currentDisplay.charAt(i) == '+'))
                            && (!(currentDisplay.charAt(i) == '-'))
                            && (!(currentDisplay.charAt(i) == 'x'))
                            && (!(currentDisplay.charAt(i) == '÷'))){
                        currentNumString += currentDisplay.charAt(i);
                    }else if ((currentDisplay.charAt(i) == '+')
                            ||(currentDisplay.charAt(i) == '-')
                            ||(currentDisplay.charAt(i) == 'x')
                            ||(currentDisplay.charAt(i) == '÷')) {
                        operators.add(currentDisplay.charAt(i));
                        operands.add(Double.parseDouble(currentNumString));
                        currentNumString = "";
                    }
                }
//            bcDisplay.setText(currentNumString);
                double currentNumber = Double.parseDouble(currentNumString);

                double currentPercent = currentNumber * (currentNumber / 100);
                previousDisplay += currentPercent;
                bcDisplay.setText(previousDisplay);

                //Adjust if it is a whole number (get rid of the .0)
                currentDisplay = bcDisplay.getText().toString();
                if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                        && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                    bcDisplay.setText(currentDisplay);
                }else{
                    bcDisplay.setTextSize(50);
                }

            }else{

                if (currentDisplay.contains("+")
                        || currentDisplay.contains("-")
                        || currentDisplay.contains("x")
                        || currentDisplay.contains("÷")) {

                    int expression = 0;
                    for (int i = currentDisplay.length() - 1; i > 0; i--) {
                        if ((currentDisplay.charAt(i) == '+')
                                || (currentDisplay.charAt(i) == '-')
                                || (currentDisplay.charAt(i) == 'x')
                                || (currentDisplay.charAt(i) == '÷')) {
                            expression = i;
                            break;
                        }
                    }
                    BigDecimal subResult = new Expression(currentDisplay.substring(0, expression)).eval();
                    DecimalFormat adjustedNewResult = new DecimalFormat("#.###");
                    BigDecimal percentResult = BigDecimal.valueOf(Double.parseDouble(currentDisplay.substring(expression + 1, currentDisplay.length())) / 100);

                    String newCurrentDisplay = currentDisplay.substring(0, expression + 1);

                    newCurrentDisplay += adjustedNewResult.format((subResult.doubleValue() * percentResult.doubleValue()));

                    bcDisplay.setText(newCurrentDisplay);

                }else{
                    bcDisplay.setText("0");
                }

            }

        }


    }

    public void evaluateEntry(View v){
        String currentDisplay = bcDisplay.getText().toString();
        ArrayList<Double> operands = new ArrayList<Double>();
        ArrayList<Character> operators = new ArrayList<Character>();

        if (currentDisplay.contains("∞")){
            bcDisplay.setText("∞");
            bcDisplay.setTextSize(100);
        }else{
            if (currentDisplay.contains("+")
                    || currentDisplay.contains("-")
                    || currentDisplay.contains("x")
                    || currentDisplay.contains("÷")){
                if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                        || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                        || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                        || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                        || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                    bcDisplay.setText(currentDisplay);
                }
                String currentNumString = new String();

                String newCurrentDisplay = new String();

                for (int i = 0; i < currentDisplay.length(); i++){
                    if (!(currentDisplay.charAt(i) == ',')
                            && (!(currentDisplay.charAt(i) == '+'))
                            && (!(currentDisplay.charAt(i) == '-'))
                            && (!(currentDisplay.charAt(i) == 'x'))
                            && (!(currentDisplay.charAt(i) == '÷'))){
                        currentNumString += currentDisplay.charAt(i);
                        newCurrentDisplay += currentDisplay.charAt(i);
                    }else if ((currentDisplay.charAt(i) == '+')
                            ||(currentDisplay.charAt(i) == '-')
                            ||(currentDisplay.charAt(i) == 'x')
                            ||(currentDisplay.charAt(i) == '÷')) {
                        if (currentDisplay.charAt(i) == 'x'){
                            newCurrentDisplay += '*';
                        }else if (currentDisplay.charAt(i) == '÷'){
                            newCurrentDisplay += '/';
                        }else{
                            newCurrentDisplay += currentDisplay.charAt(i);
                        }
//                    operators.add(currentDisplay.charAt(i));
//                    operands.add(Double.parseDouble(currentNumString));
                        currentNumString = "";
                    }
                }
                bcDisplay.setText(currentNumString);
                double currentNumber = Double.parseDouble(currentNumString);

                if (currentDisplay.contains("÷0")){
                    bcDisplay.setText("Undefined");
                    disableInputBc();
                }else{
                    BigDecimal result = null;
                    result = new Expression(newCurrentDisplay).eval();
                    bcDisplay.setText(Double.toString(result.doubleValue()));

                    //Adjust if it is a whole number (get rid of the .0)
                    currentDisplay = bcDisplay.getText().toString();
                    if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                            && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                        currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                        bcDisplay.setText(currentDisplay);
                    }else{
                        bcDisplay.setTextSize(50);
                    }
                }

                //Add commas if necessary

            }
        }

    }

    /***********************************************************************************************
     *********************************************************************************************/

    /***********************************************************************************************
     * Functions for Scientific Calculator
     *********************************************************************************************/

    public void insertPeriodSc(View v){
        scEngine.insertPeriod();
    }
    public void insertOneSc(View v){
        scEngine.insertOne();
    }
    public void insertTwoSc(View v){
        scEngine.insertTwo();
    }
    public void insertThreeSc(View v){
        scEngine.insertThree();
    }
    public void insertFourSc(View v){
        scEngine.insertFour();
    }
    public void insertFiveSc(View v){
        scEngine.insertFive();
    }
    public void insertSixSc(View v){
        scEngine.insertSix();
    }
    public void insertSevenSc(View v){
        scEngine.insertSeven();
    }
    public void insertEightSc(View v){
        scEngine.insertEight();
    }
    public void insertNineSc(View v){
        scEngine.insertNine();
    }
    public void insertZeroSc(View v){
        scEngine.insertZero();
    }
    public void insertPlusSc(View v){
        scEngine.insertPlus();
        adjustGrowingTextSize();

    }
    public void insertMinusSc(View v){
        scEngine.insertMinus();
        adjustGrowingTextSize();
    }
    public void insertTimesSc(View v){
        scEngine.insertTimes();
        adjustGrowingTextSize();
    }
    public void insertDivideSc(View v){
        scEngine.insertDivide();
        adjustGrowingTextSize();
    }
    public void insertLeftBracket(View v){
        scEngine.insertLeftBracket();
    }
    public void insertRightBracket(View v){
        scEngine.insertRightBracket();
    }
    public void deleteDigitSc(View v){
        scEngine.deleteDigit(v);
    }
    public void cancelEverythingSc(View v){
        scEngine.cancelEverything(v);
    }
    public void clearEntrySc(View v){
        scEngine.clearEntry(v);
    }
    public void changeSignSc(View v){
        scEngine.changeSign(v);
    }
    public void insertPi(View v){
        scEngine.insertPi();
    }
    public void factorialEval(View v){
        boolean intendedResult = scEngine.factorialEval();
        checkExtremeInput(intendedResult);
    }

    public void modFunction(View v){
        scEngine.insertMod();
    }
    public void evaluateEntrySc(View v){
        scEngine.evaluateEntry();
    }


    //This would toggle between multiple sets for the functions below
    public void changeButtonFunctions(View v){
        if (scToggleIndicator == 0){
            if (switchPref){
                scToggle.setBackgroundColor(Color.parseColor("#FF00463E"));
            }else{
                scToggle.setBackgroundColor(Color.parseColor("#CEEAE7"));
            }
            scCustomExponentButton.setText(Html.fromHtml("<sup>Y</sup>√x"));
            scSquareRootButton.setText(R.string.recipricol);
            scSquaredButton.setText(Html.fromHtml("X<sup>3</sup>"));
            scExp10Button.setText(Html.fromHtml("e<sup>x</sup>"));
            scSinButton.setText(Html.fromHtml("SIN<sup>-1</sup>"));
            scCosButton.setText(Html.fromHtml("COS<sup>-1</sup>"));
            scTanButton.setText(Html.fromHtml("TAN<sup>-1</sup>"));
            scLogButton.setText(R.string.ln);
            scToggleIndicator = 1;
        }else{
            scToggle.setChecked(false);
            scToggle.setBackgroundColor(Color.TRANSPARENT);

            scCustomExponentButton.setText(Html.fromHtml("X<sup>Y</sup>"));
            scSquareRootButton.setText(R.string.root);
            scSquaredButton.setText(Html.fromHtml("X<sup>2</sup>"));
            scExp10Button.setText(Html.fromHtml("10<sup>X</sup>"));
            scSinButton.setText(R.string.sin);
            scCosButton.setText(R.string.cos);
            scTanButton.setText(R.string.tan);
            scLogButton.setText(R.string.log);
            scToggleIndicator = 0;
        }
    }

    //Buttons with multiple functionalities
    public void squareRootEvalSc(View v){
        boolean intendedResult;
        if (scToggleIndicator == 0){
            intendedResult = scEngine.squareRootEval(0);
        }else{
            intendedResult = scEngine.squareRootEval(1);
        }
        checkExtremeInput(intendedResult);
    }
    public void squaredEvalSc(View v){
        if (scToggleIndicator == 0){
            scEngine.squaredEval();
        }else{
            scEngine.cubedEval();
        }
    }
    public void tenExponent(View v){
        if (scToggleIndicator == 0){
            scEngine.tenExponentEval(0);
        }else{
            scEngine.tenExponentEval(1);
        }
    }
    public void customExponent(View v){
        if (scToggleIndicator == 0){
            scEngine.customExponentEval(0);
        }else{
            scEngine.customExponentEval(1);
        }
    }
    public void sinFunction(View v){
        boolean intendedResult;
        if (scToggleIndicator == 0){
            intendedResult = scEngine.trigFunctionEval(0);
        }else{
            intendedResult = scEngine.trigFunctionEval(1);
        }
        checkExtremeInput(intendedResult);
    }
    public void cosFunction(View v){
        boolean intendedResult;
        if (scToggleIndicator == 0){
            intendedResult = scEngine.trigFunctionEval(2);
        }else{
            intendedResult = scEngine.trigFunctionEval(3);
        }
        checkExtremeInput(intendedResult);
    }
    public void tanFunction(View v){
        boolean intendedResult;
        if (scToggleIndicator == 0){
            intendedResult = scEngine.trigFunctionEval(4);
        }else{
            intendedResult = scEngine.trigFunctionEval(5);
        }
        checkExtremeInput(intendedResult);
    }
    public void logFunction(View v){
        boolean intendedResult;
        if (scToggleIndicator == 0){
            intendedResult = scEngine.logFunctionEval(0);
        }else{
            intendedResult = scEngine.logFunctionEval(1);
        }
        checkExtremeInput(intendedResult);
    }
    public void degFunction(View v){
        if (scMeasureType == 0){
            scDegButton.setText("RAD");
            scMeasureType = 1;
        }else{
            scDegButton.setText("DEG");
            scMeasureType = 0;
        }
    }


    public void checkExtremeInput(boolean intendedResult){
        if (!(intendedResult)){
            scDisplay.setText("Invalid Input");
            scSquaredButton.setVisibility(INVISIBLE);
            scClearEntryButton.setVisibility(INVISIBLE);
            scCancelButton.setVisibility(INVISIBLE);
            scDeleteButton.setVisibility(INVISIBLE);
            scDivideButton.setVisibility(INVISIBLE);
            scPiButton.setVisibility(INVISIBLE);
            scSevenButton.setVisibility(INVISIBLE);
            scEightButton.setVisibility(INVISIBLE);
            scNineButton.setVisibility(INVISIBLE);
            scMultiplyButton.setVisibility(INVISIBLE);
            scFactorialButton.setVisibility(INVISIBLE);
            scFourButton.setVisibility(INVISIBLE);
            scFiveButton.setVisibility(INVISIBLE);
            scSixButton.setVisibility(INVISIBLE);
            scMinusButton.setVisibility(INVISIBLE);
            scOneButton.setVisibility(INVISIBLE);
            scTwoButton.setVisibility(INVISIBLE);
            scThreeButton.setVisibility(INVISIBLE);
            scPlusButton.setVisibility(INVISIBLE);
            scPosNegButton.setVisibility(INVISIBLE);
            scLeftBracketButton.setVisibility(INVISIBLE);
            scRightBracketButton.setVisibility(INVISIBLE);
            scZeroButton.setVisibility(INVISIBLE);
            scPeriodButton.setVisibility(INVISIBLE);
            scEqualsButton.setVisibility(INVISIBLE);
            scToggle.setVisibility(INVISIBLE);
            scExp10Button.setVisibility(INVISIBLE);
            scSinButton.setVisibility(INVISIBLE);
            scCosButton.setVisibility(INVISIBLE);
            scTanButton.setVisibility(INVISIBLE);
            scCustomExponentButton.setVisibility(INVISIBLE);
            scLogButton.setVisibility(INVISIBLE);
            scDegButton.setVisibility(INVISIBLE);
            scModButton.setVisibility(INVISIBLE);
            scSquareRootButton.setVisibility(INVISIBLE);
            new CountDownTimer(2000, 1000) {
                public void onTick(long millisUntilFinished) {

                }
                public void onFinish() {
                    scSquaredButton.setVisibility(VISIBLE);
                    scClearEntryButton.setVisibility(VISIBLE);
                    scCancelButton.setVisibility(VISIBLE);
                    scDeleteButton.setVisibility(VISIBLE);
                    scDivideButton.setVisibility(VISIBLE);
                    scPiButton.setVisibility(VISIBLE);
                    scSevenButton.setVisibility(VISIBLE);
                    scEightButton.setVisibility(VISIBLE);
                    scNineButton.setVisibility(VISIBLE);
                    scMultiplyButton.setVisibility(VISIBLE);
                    scFactorialButton.setVisibility(VISIBLE);
                    scFourButton.setVisibility(VISIBLE);
                    scFiveButton.setVisibility(VISIBLE);
                    scSixButton.setVisibility(VISIBLE);
                    scMinusButton.setVisibility(VISIBLE);
                    scOneButton.setVisibility(VISIBLE);
                    scTwoButton.setVisibility(VISIBLE);
                    scThreeButton.setVisibility(VISIBLE);
                    scPlusButton.setVisibility(VISIBLE);
                    scPosNegButton.setVisibility(VISIBLE);
                    scLeftBracketButton.setVisibility(VISIBLE);
                    scRightBracketButton.setVisibility(VISIBLE);
                    scZeroButton.setVisibility(VISIBLE);
                    scPeriodButton.setVisibility(VISIBLE);
                    scEqualsButton.setVisibility(VISIBLE);
                    scToggle.setVisibility(VISIBLE);
                    scExp10Button.setVisibility(VISIBLE);
                    scSinButton.setVisibility(VISIBLE);
                    scCosButton.setVisibility(VISIBLE);
                    scTanButton.setVisibility(VISIBLE);
                    scCustomExponentButton.setVisibility(VISIBLE);
                    scLogButton.setVisibility(VISIBLE);
                    scDegButton.setVisibility(VISIBLE);
                    scModButton.setVisibility(VISIBLE);
                    scSquareRootButton.setVisibility(VISIBLE);
                    scDisplay.setText("0");

                }
            }.start();
        }
    }
    
    public void disableInputBc(){
        bcPercentButton.setVisibility(INVISIBLE);
        bcRootButton.setVisibility(INVISIBLE);
        bcSquaredButton.setVisibility(INVISIBLE);
        bcReciprocolButton.setVisibility(INVISIBLE);
        bcClearEntryButton.setVisibility(INVISIBLE);
        bcCancelButton.setVisibility(INVISIBLE);
        bcDeleteButton.setVisibility(INVISIBLE);
        bcDivideButton.setVisibility(INVISIBLE);
        bcSevenButton.setVisibility(INVISIBLE);
        bcEightButton.setVisibility(INVISIBLE);
        bcNineButton.setVisibility(INVISIBLE);
        bcMultiplyButton.setVisibility(INVISIBLE);
        bcFourButton.setVisibility(INVISIBLE);
        bcFiveButton.setVisibility(INVISIBLE);
        bcSixButton.setVisibility(INVISIBLE);
        bcMinusButton.setVisibility(INVISIBLE);
        bcOneButton.setVisibility(INVISIBLE);
        bcTwoButton.setVisibility(INVISIBLE);
        bcThreeButton.setVisibility(INVISIBLE);
        bcPlusButton.setVisibility(INVISIBLE);
        bcPosNegButton.setVisibility(INVISIBLE);
        bcZeroButton.setVisibility(INVISIBLE);
        bcPeriodButton.setVisibility(INVISIBLE);
        bcEqualsButton.setVisibility(INVISIBLE);
        new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                bcPercentButton.setVisibility(VISIBLE);
                bcRootButton.setVisibility(VISIBLE);
                bcSquaredButton.setVisibility(VISIBLE);
                bcReciprocolButton.setVisibility(VISIBLE);
                bcClearEntryButton.setVisibility(VISIBLE);
                bcCancelButton.setVisibility(VISIBLE);
                bcDeleteButton.setVisibility(VISIBLE);
                bcDivideButton.setVisibility(VISIBLE);
                bcSevenButton.setVisibility(VISIBLE);
                bcEightButton.setVisibility(VISIBLE);
                bcNineButton.setVisibility(VISIBLE);
                bcMultiplyButton.setVisibility(VISIBLE);
                bcFourButton.setVisibility(VISIBLE);
                bcFiveButton.setVisibility(VISIBLE);
                bcSixButton.setVisibility(VISIBLE);
                bcMinusButton.setVisibility(VISIBLE);
                bcOneButton.setVisibility(VISIBLE);
                bcTwoButton.setVisibility(VISIBLE);
                bcThreeButton.setVisibility(VISIBLE);
                bcPlusButton.setVisibility(VISIBLE);
                bcPosNegButton.setVisibility(VISIBLE);
                bcZeroButton.setVisibility(VISIBLE);
                bcPeriodButton.setVisibility(VISIBLE);
                bcEqualsButton.setVisibility(VISIBLE);
                bcDisplay.setText("0");
            }
        }.start();
    }


    /***********************************************************************************************
     *********************************************************************************************/


    /***********************************************************************************************
     * Functions for Currency Converter
     *********************************************************************************************/
    public void insertPeriodCc(View v){
        ccEngine.insertPeriod(v);
    }
    public void insertOneCc(View v){
        ccEngine.insertOne(v);
    }
    public void insertTwoCc(View v){
        ccEngine.insertTwo(v);
    }
    public void insertThreeCc(View v){
        ccEngine.insertThree(v);
    }
    public void insertFourCc(View v){
        ccEngine.insertFour(v);
    }
    public void insertFiveCc(View v){
        ccEngine.insertFive(v);
    }
    public void insertSixCc(View v){
        ccEngine.insertSix(v);
    }
    public void insertSevenCc(View v){
        ccEngine.insertSeven(v);
    }
    public void insertEightCc(View v){
        ccEngine.insertEight(v);
    }
    public void insertNineCc(View v){
        ccEngine.insertNine(v);
    }
    public void insertZeroCc(View v){
        ccEngine.insertZero(v);
    }
    public void deleteDigitCc(View v){
        ccEngine.deleteDigit(v);
    }
    public void cancelEverythingCc(View v){
        ccEngine.cancelEverything(v);
    }


    /***********************************************************************************************
     * Functions for Length Converter
     *********************************************************************************************/
    public void insertPeriodlc(View v){
        lcEngine.insertPeriod(v);
    }
    public void insertOnelc(View v){
        lcEngine.insertOne(v);
    }
    public void insertTwolc(View v){
        lcEngine.insertTwo(v);
    }
    public void insertThreelc(View v){
        lcEngine.insertThree(v);
    }
    public void insertFourlc(View v){
        lcEngine.insertFour(v);
    }
    public void insertFivelc(View v){
        lcEngine.insertFive(v);
    }
    public void insertSixlc(View v){
        lcEngine.insertSix(v);
    }
    public void insertSevenlc(View v){
        lcEngine.insertSeven(v);
    }
    public void insertEightlc(View v){
        lcEngine.insertEight(v);
    }
    public void insertNinelc(View v){
        lcEngine.insertNine(v);
    }
    public void insertZerolc(View v){
        lcEngine.insertZero(v);
    }
    public void deleteDigitlc(View v){
        lcEngine.deleteDigit(v);
    }
    public void cancelEverythinglc(View v){
        lcEngine.cancelEverything(v);
    }


    /***********************************************************************************************
     * Functions for Weight Converter
     *********************************************************************************************/
    public void insertPeriodwc(View v){
        wcEngine.insertPeriod(v);
    }
    public void insertOnewc(View v){
        wcEngine.insertOne(v);
    }
    public void insertTwowc(View v){
        wcEngine.insertTwo(v);
    }
    public void insertThreewc(View v){
        wcEngine.insertThree(v);
    }
    public void insertFourwc(View v){
        wcEngine.insertFour(v);
    }
    public void insertFivewc(View v){
        wcEngine.insertFive(v);
    }
    public void insertSixwc(View v){
        wcEngine.insertSix(v);
    }
    public void insertSevenwc(View v){
        wcEngine.insertSeven(v);
    }
    public void insertEightwc(View v){
        wcEngine.insertEight(v);
    }
    public void insertNinewc(View v){
        wcEngine.insertNine(v);
    }
    public void insertZerowc(View v){
        wcEngine.insertZero(v);
    }
    public void deleteDigitwc(View v){
        wcEngine.deleteDigit(v);
    }
    public void cancelEverythingwc(View v){
        wcEngine.cancelEverything(v);
    }


    /***********************************************************************************************
     * Functions for Volume Converter
     *********************************************************************************************/
    public void insertPeriodvc(View v){
        vcEngine.insertPeriod(v);
    }
    public void insertOnevc(View v){
        vcEngine.insertOne(v);
    }
    public void insertTwovc(View v){
        vcEngine.insertTwo(v);
    }
    public void insertThreevc(View v){
        vcEngine.insertThree(v);
    }
    public void insertFourvc(View v){
        vcEngine.insertFour(v);
    }
    public void insertFivevc(View v){
        vcEngine.insertFive(v);
    }
    public void insertSixvc(View v){
        vcEngine.insertSix(v);
    }
    public void insertSevenvc(View v){
        vcEngine.insertSeven(v);
    }
    public void insertEightvc(View v){
        vcEngine.insertEight(v);
    }
    public void insertNinevc(View v){
        vcEngine.insertNine(v);
    }
    public void insertZerovc(View v){
        vcEngine.insertZero(v);
    }
    public void deleteDigitvc(View v){
        vcEngine.deleteDigit(v);
    }
    public void cancelEverythingvc(View v){
        vcEngine.cancelEverything(v);
    }


    /***********************************************************************************************
     * Functions for Area Converter
     *********************************************************************************************/
    public void insertPeriodac(View v){
        acEngine.insertPeriod(v);
    }
    public void insertOneac(View v){
        acEngine.insertOne(v);
    }
    public void insertTwoac(View v){
        acEngine.insertTwo(v);
    }
    public void insertThreeac(View v){
        acEngine.insertThree(v);
    }
    public void insertFourac(View v){
        acEngine.insertFour(v);
    }
    public void insertFiveac(View v){
        acEngine.insertFive(v);
    }
    public void insertSixac(View v){
        acEngine.insertSix(v);
    }
    public void insertSevenac(View v){
        acEngine.insertSeven(v);
    }
    public void insertEightac(View v){
        acEngine.insertEight(v);
    }
    public void insertNineac(View v){
        acEngine.insertNine(v);
    }
    public void insertZeroac(View v){
        acEngine.insertZero(v);
    }
    public void deleteDigitac(View v){
        acEngine.deleteDigit(v);
    }
    public void cancelEverythingac(View v){
        acEngine.cancelEverything(v);
    }


    /***********************************************************************************************
     * Functions for Temperature Converter
     *********************************************************************************************/
    public void insertPeriodtc(View v){
        tcEngine.insertPeriod(v);
    }
    public void insertOnetc(View v){
        tcEngine.insertOne(v);
    }
    public void insertTwotc(View v){
        tcEngine.insertTwo(v);
    }
    public void insertThreetc(View v){
        tcEngine.insertThree(v);
    }
    public void insertFourtc(View v){
        tcEngine.insertFour(v);
    }
    public void insertFivetc(View v){
        tcEngine.insertFive(v);
    }
    public void insertSixtc(View v){
        tcEngine.insertSix(v);
    }
    public void insertSeventc(View v){
        tcEngine.insertSeven(v);
    }
    public void insertEighttc(View v){
        tcEngine.insertEight(v);
    }
    public void insertNinetc(View v){
        tcEngine.insertNine(v);
    }
    public void insertZerotc(View v){
        tcEngine.insertZero(v);
    }
    public void deleteDigittc(View v){
        tcEngine.deleteDigit(v);
    }
    public void cancelEverythingtc(View v){
        tcEngine.cancelEverything(v);
    }


    /***********************************************************************************************
     * Functions for Pressure Converter
     *********************************************************************************************/
    public void insertPeriodpc(View v){
        pcEngine.insertPeriod(v);
    }
    public void insertOnepc(View v){
        pcEngine.insertOne(v);
    }
    public void insertTwopc(View v){
        pcEngine.insertTwo(v);
    }
    public void insertThreepc(View v){
        pcEngine.insertThree(v);
    }
    public void insertFourpc(View v){
        pcEngine.insertFour(v);
    }
    public void insertFivepc(View v){
        pcEngine.insertFive(v);
    }
    public void insertSixpc(View v){
        pcEngine.insertSix(v);
    }
    public void insertSevenpc(View v){
        pcEngine.insertSeven(v);
    }
    public void insertEightpc(View v){
        pcEngine.insertEight(v);
    }
    public void insertNinepc(View v){
        pcEngine.insertNine(v);
    }
    public void insertZeropc(View v){
        pcEngine.insertZero(v);
    }
    public void deleteDigitpc(View v){
        pcEngine.deleteDigit(v);
    }
    public void cancelEverythingpc(View v){
        pcEngine.cancelEverything(v);
    }


    /***********************************************************************************************
     * Functions for Speed Converter
     *********************************************************************************************/
    public void insertPeriodspc(View v){
        spcEngine.insertPeriod(v);
    }
    public void insertOnespc(View v){
        spcEngine.insertOne(v);
    }
    public void insertTwospc(View v){
        spcEngine.insertTwo(v);
    }
    public void insertThreespc(View v){
        spcEngine.insertThree(v);
    }
    public void insertFourspc(View v){
        spcEngine.insertFour(v);
    }
    public void insertFivespc(View v){
        spcEngine.insertFive(v);
    }
    public void insertSixspc(View v){
        spcEngine.insertSix(v);
    }
    public void insertSevenspc(View v){
        spcEngine.insertSeven(v);
    }
    public void insertEightspc(View v){
        spcEngine.insertEight(v);
    }
    public void insertNinespc(View v){
        spcEngine.insertNine(v);
    }
    public void insertZerospc(View v){
        spcEngine.insertZero(v);
    }
    public void deleteDigitspc(View v){
        spcEngine.deleteDigit(v);
    }
    public void cancelEverythingspc(View v){
        spcEngine.cancelEverything(v);
    }


    /***********************************************************************************************
     * Functions for Power Converter
     *********************************************************************************************/
    public void insertPeriodpoc(View v){
        pocEngine.insertPeriod(v);
    }
    public void insertOnepoc(View v){
        pocEngine.insertOne(v);
    }
    public void insertTwopoc(View v){
        pocEngine.insertTwo(v);
    }
    public void insertThreepoc(View v){
        pocEngine.insertThree(v);
    }
    public void insertFourpoc(View v){
        pocEngine.insertFour(v);
    }
    public void insertFivepoc(View v){
        pocEngine.insertFive(v);
    }
    public void insertSixpoc(View v){
        pocEngine.insertSix(v);
    }
    public void insertSevenpoc(View v){
        pocEngine.insertSeven(v);
    }
    public void insertEightpoc(View v){
        pocEngine.insertEight(v);
    }
    public void insertNinepoc(View v){
        pocEngine.insertNine(v);
    }
    public void insertZeropoc(View v){
        pocEngine.insertZero(v);
    }
    public void deleteDigitpoc(View v){
        pocEngine.deleteDigit(v);
    }
    public void cancelEverythingpoc(View v){
        pocEngine.cancelEverything(v);
    }




    /***********************************************************************************************
     * Functions for Fuel Consumption Converter
     *********************************************************************************************/
    public void insertPeriodfcc(View v){
        fccEngine.insertPeriod(v);
    }
    public void insertOnefcc(View v){
        fccEngine.insertOne(v);
    }
    public void insertTwofcc(View v){
        fccEngine.insertTwo(v);
    }
    public void insertThreefcc(View v){
        fccEngine.insertThree(v);
    }
    public void insertFourfcc(View v){
        fccEngine.insertFour(v);
    }
    public void insertFivefcc(View v){
        fccEngine.insertFive(v);
    }
    public void insertSixfcc(View v){
        fccEngine.insertSix(v);
    }
    public void insertSevenfcc(View v){
        fccEngine.insertSeven(v);
    }
    public void insertEightfcc(View v){
        fccEngine.insertEight(v);
    }
    public void insertNinefcc(View v){
        fccEngine.insertNine(v);
    }
    public void insertZerofcc(View v){
        fccEngine.insertZero(v);
    }
    public void deleteDigitfcc(View v){
        fccEngine.deleteDigit(v);
    }
    public void cancelEverythingfcc(View v){
        fccEngine.cancelEverything(v);
    }
}
