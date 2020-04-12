package com.bikepnp.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.bikepnp.ContactInfo;
import com.bikepnp.HorizontalAdapter;
import com.bikepnp.HorizontalScrollItem;
import com.bikepnp.R;
import com.bikepnp.Rating;
import com.bikepnp.ContactInfo;

public class ProfileFragment extends Fragment {

    private Button mContactButton;
    private Button mRateButton;
    private Button mReportButton;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.profile_layout, container, false);

        ArrayList<HorizontalScrollItem> items = new ArrayList<>();
        HorizontalAdapter adapter = new HorizontalAdapter(getContext(), items);

        for (int i = 0; i < 5; i++) {
            items.add(new HorizontalScrollItem(R.drawable.bike2, "Title " + i));
            adapter.notifyDataSetChanged();
        }

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(adapter);


        this.mContactButton = (Button)root.findViewById(R.id.contact_button);
        this.mContactButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                conactUser();
            }
        });

        this.mRateButton = (Button)root.findViewById(R.id.rate_button);
        this.mRateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                rateUser();
            }
        });

        this.mReportButton = (Button)root.findViewById(R.id.report_button);
        this.mReportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                reportUser();
            }
        });

        return root;
    }


    //******************************************************************************
    //Other Functions
    //******************************************************************************
    public void conactUser(){
        Intent intent = new Intent(getActivity(), ContactInfo.class);
        startActivity(intent);
    }

    public void rateUser(){
        Intent intent = new Intent(getActivity(), Rating.class);
        startActivity(intent);
    }

    public void reportUser(){

    }


}