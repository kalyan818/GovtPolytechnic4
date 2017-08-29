package com.example.kalya.govtpolytechnic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.firebase.client.core.view.View;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class RetriveMultipleValues extends AppCompatActivity implements Communicator{
    ImageView imageView;
    private Firebase mRef,Mreference;
    private TextView textView,textView1;
    private ProgressDialog progressDialog;
    private ListView mListView;
    private ArrayList<String> mUsernames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_multiple_values);
        progressDialog = new ProgressDialog(this);
        textView = (TextView)findViewById(R.id.textView12);
        String name = getIntent().getStringExtra("message");
        textView.setText(name);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://govtpolytechnic-65c53.firebaseio.com/" + name + "/" );
        mListView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames);
        mListView.setAdapter(arrayAdapter);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String child = dataSnapshot.getValue(String.class);
                String parent = dataSnapshot.getKey();
                String values = parent + ":" + " " + child;
                mUsernames.add(values);
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                arrayAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
                }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        //
        //progressDialog.dismiss();
        //Toast.makeText(this, "please enter a valid pin number", Toast.LENGTH_SHORT).show();
        //onBackPressed();
    }

    @Override
    public void respond(String data) {
        textView.setText(data);
    }
}
