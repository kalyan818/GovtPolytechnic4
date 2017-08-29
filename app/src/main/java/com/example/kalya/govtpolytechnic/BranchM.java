package com.example.kalya.govtpolytechnic;

import android.content.Context;
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

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by kalya on 14-Jan-17.
 */

public class BranchM extends Fragment implements View.OnClickListener{
    private FirebaseAuth firebaseAuth;
    RelativeLayout cme,mec,civil,ece,eee;
    TextView memail;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.branchm,container,false);
        firebaseAuth = FirebaseAuth.getInstance();
        cme = (RelativeLayout) v.findViewById(R.id.cmeM);
        ece = (RelativeLayout) v.findViewById(R.id.eceM);
        eee = (RelativeLayout) v.findViewById(R.id.eeeM);
        mec = (RelativeLayout) v.findViewById(R.id.mecM);
        civil = (RelativeLayout)v.findViewById(R.id.civilM);
        memail = (TextView)v.findViewById(R.id.textView9);
        Bundle bundle=getArguments();
        memail.setText(String.valueOf(bundle.getString("email")));
        cme.setOnClickListener(this);
        eee.setOnClickListener(this);
        ece.setOnClickListener(this);
        civil.setOnClickListener(this);
        mec.setOnClickListener(this);
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
                    Fragment YearM = new YearM();
                    FragmentTransaction ft  = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, YearM);
                    ft.commit();
                }
                return false;
            }
        } );
        if (view == cme)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "cme/";
            Fragment pinNumberM = new PinNumberM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            pinNumberM.setArguments(bundle1);
            ft.replace(R.id.frame, pinNumberM);
            ft.commit();
        }
        if (view == ece)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "ece/";
            Fragment pinNumberM = new PinNumberM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            pinNumberM.setArguments(bundle1);
            ft.replace(R.id.frame, pinNumberM);
            ft.commit();
        }
        if (view == mec)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "mec/";
            Fragment pinNumberM = new PinNumberM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            pinNumberM.setArguments(bundle1);
            ft.replace(R.id.frame, pinNumberM);
            ft.addToBackStack(null);
            ft.commit();
        }
        if (view == civil)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "civil/";
            Fragment pinNumberM = new PinNumberM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            pinNumberM.setArguments(bundle1);
            ft.replace(R.id.frame, pinNumberM);
            ft.addToBackStack(null);
            ft.commit();
        }
        if (view == eee)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "eee/";
            Fragment pinNumberM = new PinNumberM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            pinNumberM.setArguments(bundle1);
            ft.replace(R.id.frame, pinNumberM);
            ft.addToBackStack(null);
            ft.commit();
        }

    }

    private Context getApplicationContext() {
        return getView().getContext();
    }
}
