package deran.dartscounter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static deran.dartscounter.MainActivity.PLAYER_NUMBER;//constante die string zur identifizierung des extras playernumber im bundle

/**
 * Created by EW on 15.03.2017.
 */

public class EnterPlayerNames extends Fragment {

    int nr;//soll anzahl der spieler übergeben von aktivität speichern
    String[] Playerhints = new String[6];


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        nr = getArguments().getInt(PLAYER_NUMBER);//anzahl der spieler aus dem bundle ziehen
        //Array mit hints für edit texts für playernamen füllen
        Playerhints[0] = "player1";
        Playerhints[1] = "player2";
        Playerhints[2] = "player3";
        Playerhints[3] = "player4";
        Playerhints[4] = "player5";
        Playerhints[5] = "player6";

        List DynamicViews = new ArrayList();//Liste die mit Views gefüllt werden kann um diese in einer schleife zum layout hinzuzufügen
        //layout zur dynamischen erstellung von views im fragment
        LinearLayout linearLayout = new LinearLayout(getActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL); //or HORIZONTAL

        ViewGroup.LayoutParams buttonParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        for(int i=0; i < nr; i++){

            //View view = layoutInflator.inflate(R.layout.linearLayout1, null);
            //TextView textView = (TextView) view.findViewById(R.id.textView1);
            //textView.setText(Playerhints[i]);
            EditText button = new EditText(getActivity());
            button.setLayoutParams(buttonParams);
            button.setHint(Playerhints[i]);
            button.setSingleLine(true);
            //linearLayout.addView(button);

            DynamicViews.add(button);
        }

        for(int i = 0; i < DynamicViews.size(); i++)
            linearLayout.addView((android.view.View)DynamicViews.get(i));

//mit if anweisung überprüfen ob bundle element spieleranzahl richitg übergeben wurde
// später ersetzen mit for schleife wobei nr= anzahl schleifendurchläufe
    /*if (nr==2) {
    EditText button = new EditText(getActivity());
    button.setLayoutParams(buttonParams);
    button.setHint("player name");

    Button button2 = new Button(getActivity());
    button2.setLayoutParams(buttonParams);
    button2.setText("test");

    linearLayout.addView(button);
    linearLayout.addView(button2);
    }

        //like this, add all buttons and other views
        //you can use a loop for adding multiple similar views
    */
        container.addView(linearLayout);

        View view = inflater.inflate(R.layout.enter_player_names, container, false);

        return view;
    }

}


