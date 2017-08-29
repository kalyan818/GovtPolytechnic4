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
 * Created by kalya on 24-Dec-16.
 */

public class AttendenceFragment extends Fragment implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    RelativeLayout Btn12,Btn13,Btn14,Btn15,Btn16,Btn17;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.attendence,container,false);
        firebaseAuth = FirebaseAuth.getInstance();
        Btn12 = (RelativeLayout) v.findViewById(R.id.series12);
        Btn13 = (RelativeLayout) v.findViewById(R.id.series13);
        Btn14 = (RelativeLayout)v.findViewById(R.id.series14);
        Btn15 = (RelativeLayout)v.findViewById(R.id.series15);
        Btn16 = (RelativeLayout)v.findViewById(R.id.series16);
        Btn17 = (RelativeLayout)v.findViewById(R.id.series17);
        Btn12.setOnClickListener(this);
        Btn13.setOnClickListener(this);
        Btn14.setOnClickListener(this);
        Btn15.setOnClickListener(this);
        Btn16.setOnClickListener(this);
        Btn17.setOnClickListener(this);
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
        if(view == Btn12)
        {
            String memail="Atte/12004";
            Fragment Branch = new Branch();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle=new Bundle();
            bundle.putString("email",memail);
            Branch.setArguments(bundle);
            ft.replace(R.id.frame,Branch);
            ft.commit();
        }
        if(view == Btn13){
            String memail="Atte/13004";
            Fragment Branch = new Branch();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle=new Bundle();
            bundle.putString("email",memail);
            Branch.setArguments(bundle);
            ft.replace(R.id.frame,Branch);
            ft.commit();
        }
        if (view == Btn14){
            String memail="Atte/14004";
            Fragment Branch = new Branch();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle=new Bundle();
            bundle.putString("email",memail);
            Branch.setArguments(bundle);
            ft.replace(R.id.frame,Branch);
            ft.commit();
        }
        if (view == Btn15){
            String memail="Atte/15004";
            Fragment Branch = new Branch();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle=new Bundle();
            bundle.putString("email",memail);
            Branch.setArguments(bundle);
            ft.replace(R.id.frame,Branch);
            ft.commit();
        }
        if (view == Btn16){
            String memail="Atte/16004";
            Fragment Branch = new Branch();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle=new Bundle();
            bundle.putString("email",memail);
            Branch.setArguments(bundle);
            ft.replace(R.id.frame,Branch);
            ft.commit();
        }
        if (view == Btn17){
            String memail="Atte/17004";
            Fragment Branch = new Branch();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle=new Bundle();
            bundle.putString("email",memail);
            Branch.setArguments(bundle);
            ft.replace(R.id.frame,Branch);
            ft.commit();
        }
    }

    private Context getApplicationContext() {
        return getView().getContext();
    }
}
