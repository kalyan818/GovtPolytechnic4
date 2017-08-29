package com.example.kalya.govtpolytechnic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by kalya on 14-Jan-17.
 */

public class Branch extends Fragment implements View.OnClickListener{
    private FirebaseAuth firebaseAuth;
    RelativeLayout cme,mec,civil,ece,eee;
    TextView memail;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.branch,container,false);
        firebaseAuth = FirebaseAuth.getInstance();
        cme = (RelativeLayout) v.findViewById(R.id.cme);
        ece = (RelativeLayout)v.findViewById(R.id.ece);
        eee = (RelativeLayout)v.findViewById(R.id.eee);
        mec = (RelativeLayout)v.findViewById(R.id.mec);
        civil = (RelativeLayout)v.findViewById(R.id.civil);
        memail = (TextView)v.findViewById(R.id.textView9);
        Bundle bundle=getArguments();
        String atte =String.valueOf(bundle.getString("email"));
        memail.setText(atte);
        cme.setOnClickListener(this);
        eee.setOnClickListener(this);
        ece.setOnClickListener(this);
        civil.setOnClickListener(this);
        mec.setOnClickListener(this);
        return v;
    }
    private Context getApplicationContext() {
        return getView().getContext();
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
                    Fragment AttendenceFragment = new AttendenceFragment();
                    FragmentTransaction ft  = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, AttendenceFragment);
                    ft.commit();
                }
                return false;
            }
        } );
        if (view == cme)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "/cme/";
            Fragment PinNumber = new PinNumber();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            PinNumber.setArguments(bundle1);
            ft.replace(R.id.frame, PinNumber);
            ft.commit();
        }
        if (view == ece)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "/ece/";
            Fragment PinNumber = new PinNumber();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            PinNumber.setArguments(bundle1);
            ft.replace(R.id.frame, PinNumber);
            ft.commit();
        }
        if (view == mec)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "/mec/";
            Fragment PinNumber = new PinNumber();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            PinNumber.setArguments(bundle1);
            ft.replace(R.id.frame, PinNumber);
            ft.commit();
        }
        if (view == civil)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "/civil/";
            Fragment PinNumber = new PinNumber();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            PinNumber.setArguments(bundle1);
            ft.replace(R.id.frame, PinNumber);
            ft.commit();
        }
        if (view == eee)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "/eee/";
            Fragment PinNumber = new PinNumber();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            PinNumber.setArguments(bundle1);
            ft.replace(R.id.frame, PinNumber);
            ft.commit();
        }

    }
}
