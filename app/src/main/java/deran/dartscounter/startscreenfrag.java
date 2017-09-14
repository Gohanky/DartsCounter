package deran.dartscounter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * Created by EW on 03.03.2017.
 */

public class startscreenfrag extends Fragment implements AdapterView.OnItemSelectedListener {

    private static Spinner spinner;
    private static Spinner spinner2;
    private static int player_counter_var;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.start_screen_frag,
            container, false);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);

// Create an ArrayAdapter using the string array and a default spinner layout
        //"this" funktioniert nicht in fragment da fragment keine subklasse von context deswegen getContext()
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.player_count, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.play_choice, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

//specify the interface implementation
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);



        return view;
    }
    /*public void createPlayerNames(){
        EditText PlayerName = new EditText(getContext());
        PlayerName.setText("Press Me");
        PlayerName.setBackgroundColor(Color.YELLOW);
        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.start_screen_frag);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rl.addView(PlayerName,lp);
        view.setContentView(rl);

    }*/

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        switch (view.getId()) {

            case R.id.spinner:
                // do your code
                player_counter_var= Integer.parseInt(String.valueOf(parent.getItemAtPosition(pos)));
                // irgendwie den integer weitergeben um fragment mit x edit texts zu erstellen
                break;

            case R.id.spinner2:
                // do your code
                break;
            default:
                break;
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        switch (parent.getId()) {

            case R.id.spinner:
                // do your code
                player_counter_var=1;
                break;

            case R.id.spinner2:
                // do your code
                break;
            default:
                break;
        }
    }


}
