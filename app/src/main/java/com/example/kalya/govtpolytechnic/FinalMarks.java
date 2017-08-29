package com.example.kalya.govtpolytechnic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class FinalMarks extends AppCompatActivity {
    private Firebase mRef;
    private ProgressDialog progressDialog;
    private ListView mListView,mListView1;
    private ArrayList<String> mUsernames = new ArrayList<>();
    private ArrayList<String> mUsernames1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_marks);
        progressDialog = new ProgressDialog(this);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://govtpolytechnic-65c53.firebaseio.com/FinalMarks/");
        mListView = (ListView) findViewById(R.id.listView);
        mListView1 = (ListView) findViewById(R.id.listView1);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames);
        final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames1);
        mListView.setAdapter(arrayAdapter);
        mListView1.setAdapter(arrayAdapter1);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                String a = mUsernames1.get(i).toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(a));
                startActivity(intent);
            }
        });
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String child = dataSnapshot.getValue(String.class);
                String parent = dataSnapshot.getKey();
                mUsernames.add(parent);
                mUsernames1.add(child);
                progressDialog.dismiss();
                arrayAdapter.notifyDataSetChanged();
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
}

