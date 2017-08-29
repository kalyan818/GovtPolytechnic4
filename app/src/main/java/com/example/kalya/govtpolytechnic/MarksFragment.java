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

import com.google.firebase.auth.FirebaseAuth;

import static android.R.attr.finishOnTaskLaunch;
import static android.R.attr.fragment;
import static android.R.attr.hand_minute;


public class MarksFragment extends Fragment implements View.OnClickListener{

    FirebaseAuth firebaseAuth;
    RelativeLayout mid1,mid2,Final;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.marks,container,false);
        firebaseAuth = FirebaseAuth.getInstance();
        mid1= (RelativeLayout) v.findViewById(R.id.mid1);
        mid2 = (RelativeLayout) v.findViewById(R.id.mid2);
        Final = (RelativeLayout)v.findViewById(R.id.Final);
        mid1.setOnClickListener(this);
        mid2.setOnClickListener(this);
        Final.setOnClickListener(this);
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
                    System.exit(0);
                }
                return false;
            }
        } );
        if(view == mid1)
        {
            String memail="Marks/mid1/";
            Fragment Year = new YearM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle=new Bundle();
            bundle.putString("email",memail);
            Year.setArguments(bundle);
            ft.replace(R.id.frame,Year);
            ft.commit();
        }
        if(view == mid2){
            String memail="Marks/mid2/";
            Fragment Year = new YearM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle=new Bundle();
            bundle.putString("email",memail);
            Year.setArguments(bundle);
            ft.replace(R.id.frame,Year);
            ft.commit();
        }
        if (view == Final){
            startActivity(new Intent(getApplicationContext(),FinalMarks.class));
        }
    }

    private Context getApplicationContext() {
        return getView().getContext();
    }

}
