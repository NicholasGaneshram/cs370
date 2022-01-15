package edu.qc.seclass.tipcalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TipCalculatorActivity extends AppCompatActivity {

    private boolean isInvalidInput(String checkAmountInput, String partySizeInput){
        if(checkAmountInput.matches("") || partySizeInput.matches("")) return true;
        try
        {
            double checkAmount = Double.parseDouble(checkAmountInput);
            int partySize = Integer.parseInt(partySizeInput);
            if(checkAmount <= 0 && partySize <=0) return true;
        }
        catch (Exception e)
        {
            return true;
        }
        return false;

    }

    public void calculateTip(View view){
        EditText checkAmountInput = findViewById(R.id.checkAmountValue);
        EditText partySizeInput = findViewById(R.id.partySizeValue);

        if(isInvalidInput(checkAmountInput.getText().toString(), partySizeInput.getText().toString())){
            Toast.makeText(this, "Empty or Wrong Input(s), Please Try Again", Toast.LENGTH_SHORT).show();
            return;
        }

        EditText fifteenPercentTip = findViewById(R.id.fifteenPercentTipValue);
        EditText twentyPercentTip = findViewById(R.id.twentyPercentTipValue);
        EditText twentyfivePercentTip = findViewById(R.id.twentyfivePercentTipValue);

        double checkAmount = Double.parseDouble(checkAmountInput.getText().toString());
        int partySize = Integer.parseInt(partySizeInput.getText().toString());
        final double fifteenPercent = .15;
        final double twentyPercent = .20;
        final double twentyfivePercent = .25;

        int fifteenTip = (int) Math.round( (checkAmount * fifteenPercent) / partySize );
        int twentyTip = (int) Math.round( (checkAmount * twentyPercent) / partySize );
        int twentyFiveTip = (int) Math.round( (checkAmount * twentyfivePercent) / partySize );

        fifteenPercentTip.setText(Integer.toString(fifteenTip));
        twentyPercentTip.setText(Integer.toString(twentyTip));
        twentyfivePercentTip.setText(Integer.toString(twentyFiveTip));

        EditText fifteenPercentTotal = findViewById(R.id.fifteenPercentTotalValue);
        EditText twentyPercentTotal = findViewById(R.id.twentyPercentTotalValue);
        EditText twentyfivePercentTotal = findViewById(R.id.twentyfivePercentTotalValue);

        int evenSplit = (int)Math.round(checkAmount / partySize);

        fifteenPercentTotal.setText(Integer.toString( evenSplit + fifteenTip ));
        twentyPercentTotal.setText(Integer.toString( evenSplit + twentyTip));
        twentyfivePercentTotal.setText(Integer.toString(evenSplit + twentyFiveTip));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}