package com.example.kalya.govtpolytechnic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by kalya on 14-Jan-17.
 */

public class PinNumberM extends Fragment implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    Communicator communicator;
    RelativeLayout Submit;
    TextView memail;
    EditText Pinnumber;
    TextView txt;
    private NotificationCompat intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pinnumber, container, false);
        communicator = (Communicator)getActivity();
        Submit = (RelativeLayout) v.findViewById(R.id.Submit);
        memail = (TextView) v.findViewById(R.id.textView6);
        Pinnumber = (EditText) v.findViewById(R.id.Pinnumber);
        Submit.setOnClickListener(this);
        Bundle bundle1 = getArguments();
        memail.setText(String.valueOf(bundle1.getString("email")));
        return v;
    }

    @Override
    public void onClick(View view) {

        getView().setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    Fragment BranchM = new BranchM();
                    FragmentTransaction ft  = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, BranchM);
                    ft.commit();
                }
                return false;
            }
        } );
        if (view == Submit)
        {
            Bundle bundle1 = getArguments();
            String firstpart = String.valueOf(bundle1.getString("email"));
            String lastpart = Pinnumber.getText().toString();
            String data = firstpart + lastpart + "/";
            communicator.respond(data);
            //String memail="cme";
            //Activity RetriveMultipleValues = new RetriveMultipleValues();
            //Bundle bundle=new Bundle();
            //bundle.putString("email",memail);
            //RetriveMultipleValues.setArguments(bundle);
            //startActivity(new Intent(getApplicationContext(),RetriveMultipleValues.class));
            //Intent intent = new Intent(Intent.ACTION_VIEW);
            //intent.setData(Uri.parse("https://www.youtube.com"));
            //startActivity(intent);
        }

    }

    private Context getApplicationContext() {
        return getView().getContext();
    }

    public NotificationCompat getIntent() {
        return intent;
    }
}
