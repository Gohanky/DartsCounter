package deran.dartscounter;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import static android.R.attr.layout_below;


public  class MainActivity extends FragmentActivity
        implements startscreenfrag.PlayerCountListener{

    public final static String PLAYER_NUMBER = "deran.dartscounter.PLAYER_NUMBER";

    public void PlayerCountSelection(int position){
    playernumber=position;

    TextView textView=(TextView) findViewById(R.id.testView);
    textView.setText("hallo");

        Intent bndl=getIntent();
        bndl.putExtra(PLAYER_NUMBER,playernumber);
        Bundle bundle2=bndl.getExtras();
        EnterPlayerNames secondFragment = new EnterPlayerNames();
        secondFragment.setArguments(bundle2);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout2, secondFragment).commit();

    }

    int playernumber=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startscreenfrag firstFragment = new startscreenfrag();
        firstFragment.setArguments(getIntent().getExtras());
        /*getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main, firstFragment).commit();
        */
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout1, firstFragment).commit();



        //anstelle eines eigenen Konstruktors wird ein bundle mit argumenten erstellt und übergeben
        Intent bndl=getIntent();
        bndl.putExtra(PLAYER_NUMBER,playernumber);
        Bundle bundle2=bndl.getExtras();


        EnterPlayerNames secondFragment = new EnterPlayerNames();
        //secondFragment.setArguments(getIntent().getExtras());
        secondFragment.setArguments(bundle2);

        /*getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main, secondFragment).commit();
        */
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout2, secondFragment).commit();

    }

}
