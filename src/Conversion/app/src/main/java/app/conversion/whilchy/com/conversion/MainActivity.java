package app.conversion.whilchy.com.conversion;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Spinner unitTypeSpinner;
    private EditText amountTextView;
    TextView teaspoonTextView, tablespoonTextView, cupTextView, ounceTextView,
            pintTextView, quartTextView, gallonTextView, poundTextView,
            milliliterTextView, literTextView, milligramTextView, kilogramTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToUnitTypeSpinner();
        addListenerToUnitTypeSpinner();

        amountTextView = (EditText) findViewById(R.id.amount_text_view);

        initializeTextViews();
    }

    /**
     * Initializes all the text views
     */
    public void initializeTextViews(){
        teaspoonTextView = (TextView) findViewById(R.id.tsp_text_view);
        tablespoonTextView = (TextView) findViewById(R.id.tbs_text_view);
        cupTextView = (TextView) findViewById(R.id.cup_text_view);
        ounceTextView = (TextView) findViewById(R.id.oz_text_view);
        pintTextView = (TextView) findViewById(R.id.pint_text_view);
        quartTextView = (TextView) findViewById(R.id.quart_text_view);
        gallonTextView = (TextView) findViewById(R.id.gallon_text_view);
        poundTextView = (TextView) findViewById(R.id.pound_text_view);
        milliliterTextView = (TextView) findViewById(R.id.ml_text_view);
        literTextView = (TextView) findViewById(R.id.liter_text_view);
        milligramTextView = (TextView) findViewById(R.id.mg_text_view);
        kilogramTextView = (TextView) findViewById(R.id.kg_text_view);
    }

    public void addItemsToUnitTypeSpinner(){
        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);

        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_types,
                android.R.layout.simple_spinner_item);
        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitTypeSpinner.setAdapter(unitTypeSpinnerAdapter);
    }

    public void addListenerToUnitTypeSpinner(){
        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);

        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

                // checks if converting from teaspoons so I use the right conversion
                checkIfConvertingFromTsp(itemSelectedInSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO: Maybe something later
            }
        });
    }

    public void checkIfConvertingFromTsp(String currentUnit) {
        if(currentUnit.equals("teaspoon")){
            updateUnitTypeUsingTsp(Quantity.Unit.tsp);
        }
        else {
            if(currentUnit.equals("tablespoon")){
                updateUnitTypeUsingOther(Quantity.Unit.tbs);
            }
            else if(currentUnit.equals("cup")){
                updateUnitTypeUsingOther(Quantity.Unit.cup);
            }
            else if(currentUnit.equals("ounce")){
                updateUnitTypeUsingOther(Quantity.Unit.oz);
            }
            else if(currentUnit.equals("pint")){
                updateUnitTypeUsingOther(Quantity.Unit.pint);
            }
            else if(currentUnit.equals("quart")){
                updateUnitTypeUsingOther(Quantity.Unit.quart);
            }
            else if(currentUnit.equals("gallon")){
                updateUnitTypeUsingOther(Quantity.Unit.gallon);
            }
            else if(currentUnit.equals("pound")){
                updateUnitTypeUsingOther(Quantity.Unit.pound);
            }
            else if(currentUnit.equals("millimeter")){
                updateUnitTypeUsingOther(Quantity.Unit.ml);
            }
            else if(currentUnit.equals("liter")){
                updateUnitTypeUsingOther(Quantity.Unit.liter);
            }
            else if(currentUnit.equals("milligram")){
                updateUnitTypeUsingOther(Quantity.Unit.ml);
            }
            else if(currentUnit.equals("kilogram")){
                updateUnitTypeUsingOther(Quantity.Unit.kg);
            }
        }
    }

    public void updateUnitTypeUsingTsp(Quantity.Unit currentUnit){
        double doubleConvert = Double.parseDouble(amountTextView.getText().toString());

        String teaspoonValueAndUnit = doubleConvert + " tsp";
        teaspoonTextView.setText(teaspoonValueAndUnit);

        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.tbs, tablespoonTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.cup, cupTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.oz, ounceTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.pint, pintTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.quart, quartTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.gallon, gallonTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.pound, poundTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.ml, milliliterTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.liter, literTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.mg, milligramTextView);
        updateUnitTextFieldUsingTsp(doubleConvert, Quantity.Unit.kg, kilogramTextView);
    }

    public void updateUnitTextFieldUsingTsp(double doubleToConvert, Quantity.Unit unitConvertingTo, TextView theTextView){
        Quantity unitQuantity = new Quantity(doubleToConvert, Quantity.Unit.tsp);

        String tempUnit = unitQuantity.to(unitConvertingTo).toString();
        theTextView.setText(tempUnit);
    }

    public void updateUnitTypeUsingOther(Quantity.Unit currentUnit) {
        double doubleToConvert = Double.parseDouble(amountTextView.getText().toString());
        Quantity currentQuantitySelected = new Quantity(doubleToConvert, currentUnit);
        String valueInTeaspoons = currentQuantitySelected.to(Quantity.Unit.tsp).toString();
        teaspoonTextView.setText(valueInTeaspoons);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.tbs, tablespoonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.cup, cupTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.oz, ounceTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.pint, pintTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.quart, quartTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.gallon, gallonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.pound, poundTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.ml, milliliterTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.liter, literTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.mg, milligramTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.kg, kilogramTextView);

        if(currentUnit.name().equals(currentQuantitySelected.unit.name())) {
            String currentUnitTextViewText = doubleToConvert + " " + currentQuantitySelected.unit.name();

            String currentTextViewName = currentQuantitySelected.unit.name() +
                    "_text_view";

            int currentId = getResources().getIdentifier(currentTextViewName, "id", MainActivity.this.getPackageName());
            TextView currentTextView = (TextView) findViewById(currentId);
            currentTextView.setText(currentUnitTextViewText);
        }
    }

    public void updateUnitTextFieldUsingTsp(double doubleToConvert,
                                            Quantity.Unit currentUnit,
                                            Quantity.Unit preferredUnit,
                                            TextView targetTextView) {
        Quantity currentQuantitySelected = new Quantity(doubleToConvert, currentUnit);
        String tempTextViewText = currentQuantitySelected.to(Quantity.Unit.tsp).to(preferredUnit).toString();

        targetTextView.setText(tempTextViewText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
