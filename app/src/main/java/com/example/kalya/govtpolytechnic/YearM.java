package com.example.kalya.govtpolytechnic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class YearM extends Fragment implements View.OnClickListener{

    FirebaseAuth firebaseAuth;
    TextView textView;
    RelativeLayout Btn12,Btn13,Btn14,Btn15,Btn16,Btn17;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.yearm,container,false);
        firebaseAuth = FirebaseAuth.getInstance();
        Btn12 = (RelativeLayout) v.findViewById(R.id.series12);
        Btn13 = (RelativeLayout)v.findViewById(R.id.series13);
        Btn14 = (RelativeLayout)v.findViewById(R.id.series14);
        Btn15 = (RelativeLayout)v.findViewById(R.id.series15);
        Btn16 = (RelativeLayout)v.findViewById(R.id.series16);
        Btn17 = (RelativeLayout)v.findViewById(R.id.series17);
        textView = (TextView)v.findViewById(R.id.textView11);
        Bundle bundle = getArguments();
        String firstpart = String.valueOf(bundle.getString("email"));
        textView.setText(firstpart);
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
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    Fragment MarksFragment = new MarksFragment();
                    FragmentTransaction ft  = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, MarksFragment);
                    ft.commit();
                }
                return false;
            }
        } );
        if(view == Btn12)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "12004/";
            Fragment BranchM = new BranchM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            BranchM.setArguments(bundle1);
            ft.replace(R.id.frame, BranchM);
            ft.commit();
        }
        if(view == Btn13)
        {
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "13004/";
            Fragment BranchM = new BranchM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            BranchM.setArguments(bundle1);
            ft.replace(R.id.frame, BranchM);
            ft.commit();
        }
        if (view == Btn14){
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "14004/";
            Fragment BranchM = new BranchM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            BranchM.setArguments(bundle1);
            ft.replace(R.id.frame, BranchM);
            ft.commit();
        }
        if (view == Btn15){
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "15004/";
            Fragment BranchM = new BranchM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            BranchM.setArguments(bundle1);
            ft.replace(R.id.frame, BranchM);
            ft.commit();
        }
        if (view == Btn16){
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "16004/";
            Fragment BranchM = new BranchM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            BranchM.setArguments(bundle1);
            ft.replace(R.id.frame, BranchM);
            ft.commit();
        }
        if (view == Btn17){
            Bundle bundle=getArguments();
            String atte =String.valueOf(bundle.getString("email"));
            String memail = atte + "17004/";
            Fragment BranchM = new BranchM();
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
            Bundle bundle1=new Bundle();
            bundle1.putString("email",memail);
            BranchM.setArguments(bundle1);
            ft.replace(R.id.frame, BranchM);
            ft.commit();
        }
    }
}
