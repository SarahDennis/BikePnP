package com.bikepnp.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bikepnp.AddBike;
import com.bikepnp.R;
import com.bikepnp.SellerInfo;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private ImageButton mAddButton;
    private ArrayList<SellerInfo> mData = new ArrayList();
    private SellerInfo tempData = new SellerInfo();

    private RecyclerView mRecycler;
    private RecyclerView.Adapter<SquareHolder> mAdapter = new SquareHolderAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        mRecycler = (RecyclerView) root.findViewById(R.id.reycler_sell_view);
        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecycler.setAdapter(mAdapter);


        //Sets the add button so a user can add a bike they want to put up for rent
        this.mAddButton = (ImageButton)root.findViewById(R.id.add_button);
        this.mAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                addNewContent();
                textView.setText("Item(s) for rent:");
            }
        });


        return root;
    }


    //starts the new activity AddBike
    public void addNewContent(){
        Intent intent = new Intent(getActivity(), AddBike.class);
        startActivityForResult(intent, 411);
    }

    //******************************************************************************
    //Other Functions
    //******************************************************************************


    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 411){
            //Sets all the data into tempData after the form is filled out
            tempData.setmName(data.getStringExtra("name"));
            tempData.setItemDetails(data.getStringExtra("details"));
            tempData.setmPhoneNumber(data.getStringExtra("phone_number"));
            tempData.setmPrice(data.getDoubleExtra("item_price", 0));
            tempData.setmTitle(data.getStringExtra("title"));



            //Makes the Adapter change after the changes
            mData.add(tempData);

            //reset tempData for later
            tempData = null;
            mAdapter.notifyDataSetChanged();
        }
    }


    //******************************************************************************
    //Holder/Recycler View
    //******************************************************************************
    public class SquareHolder extends RecyclerView.ViewHolder {
        private Button mButton;
        private int mPosition;

        public SquareHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.home_square_view, container, false));


            //Set up buttons here
            mButton = (Button)itemView.findViewById(R.id.grid_button);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //If button is pressed add view page for the selling item
                    mAdapter.notifyItemChanged(mPosition);
                }
            });
        }



        public void bindPosition(int p) {
            mPosition = p;
        }
    }


    //**********************************************************************************************
    //Adapter
    //**********************************************************************************************
    public class SquareHolderAdapter extends RecyclerView.Adapter<SquareHolder> {

        @Override
        public void onBindViewHolder(SquareHolder holder, int position) {
            holder.bindPosition(position);

            //Makes sure the data isnt null
            if (mData.get(position) != null) {

                //Set the different parts here
                holder.mButton.setText(mData.get(position).getmName() + "\n"
                        + "Phone #: " + mData.get(position).getmPhoneNumber() + "\n\n"
                        + mData.get(position).getmTitle() + "\n"
                        + "Details: " + mData.get(position).getItemDetails() + "\n"
                        + "$" + mData.get(position).getmPrice() + " per hour");
            }

        }

        @Override
        public SquareHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new SquareHolder(inflater, parent);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

}

