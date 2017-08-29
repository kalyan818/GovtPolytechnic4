package com.example.kalya.govtpolytechnic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by kalya on 24-Dec-16.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{

    private Firebase mRef;
    private ProgressDialog progressDialog;
    private ListView mListView,mListView1;
    private ArrayList<String> mUsernames = new ArrayList<>();
    private ArrayList<String> mUsernames1 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home,container,false);
        progressDialog = new ProgressDialog(v.getContext());
        Firebase.setAndroidContext(v.getContext());
        mRef = new Firebase("https://govtpolytechnic-65c53.firebaseio.com/notifications");
        mListView = (ListView)v.findViewById(R.id.listViewhome);
        mListView1 = (ListView)v.findViewById(R.id.listViewhome1);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_1,mUsernames);
        final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_1,mUsernames1);
        mListView.setAdapter(arrayAdapter);
        mListView1.setAdapter(arrayAdapter1);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                    String b = (String) ((TextView) view).getText();
                    String a = mUsernames1.get(i).toString();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(a));
                    startActivity(intent);
            }
        });
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                String vvv = dataSnapshot.getKey();
                //String abs = vvv + "\n"+"\n"+ value + "\n";
                mUsernames.add(vvv);
                mUsernames1.add(value);
                progressDialog.hide();
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
        return v;
    }

    @Override
    public void onClick(View view) {

    }
}
