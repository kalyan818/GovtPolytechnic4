package com.example.kalya.govtpolytechnic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by kalya on 24-Dec-16.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener{
    private FirebaseAuth firebaseAuth;
    private Button changepassword,logout;
    private TextView Email;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile,container,false);
        changepassword = (Button)v.findViewById(R.id.ChangePassword);
        logout= (Button)v.findViewById(R.id.Logout);
        Email =  (TextView) v.findViewById(R.id.Email);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        logout.setOnClickListener(this);
        changepassword.setOnClickListener(this);
        return v;
    }
    private void ForgetPassword(){
        String abs = firebaseAuth.getCurrentUser().getEmail();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(abs)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            final Toast toast = Toast.makeText(getApplicationContext(), "A Mail has been sent to your Email", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else
                        {
                            final Toast toast = Toast.makeText(getApplicationContext(), "Try Again....", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == changepassword){
            ForgetPassword();
        }
        if (view == logout){
            firebaseAuth.signOut();
            startActivity(new Intent(getApplicationContext(),LoginPage.class));
            getActivity().onBackPressed();
        }
    }

    private Context getApplicationContext() {
        return getView().getContext();
    }
}
