package com.bikepnp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bikepnp.R;
import com.bikepnp.SearchActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<String> mData= new ArrayList<>();
    private RecyclerView mRecycler;
    private RecyclerView.Adapter<SquareHolder> mAdapter = new SquareHolderAdapter();
    private ImageButton mSearchButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        //For testing purposes
        mData.add("R.drawable.bike");
        mData.add("R.drawable.bike2");
        mData.add("R.drawable.bike3");
        mData.add("R.drawable.bike4");
        mData.add("New Bike");
        mData.add("New Bike");


        mRecycler = (RecyclerView) root.findViewById(R.id.reycler_home_view);
        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecycler.setAdapter(mAdapter);



        mSearchButton = (ImageButton)root.findViewById(R.id.search_button);
        this.mSearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                seachbar();
            }
        });

        return root;
    }


    //**********************************************************************************************
    //Other Functions
    //**********************************************************************************************

    public void seachbar(){
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivity(intent);
    }


    //**********************************************************************************************
    //SquareHolder (RecyclerView)
    //**********************************************************************************************

    public class SquareHolder extends RecyclerView.ViewHolder {
        private Button mButton;
        private int mPosition;


        public SquareHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.home_square_view, container, false));


            //Sets up all of the buttons for the Game of Life
            mButton = (Button)itemView.findViewById(R.id.grid_button);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Add url redirect to show page
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

            if (position == 1){
                //Changes the button to the picture
                holder.mButton.setBackgroundResource(R.drawable.bike);
            } else if (position == 2){
                holder.mButton.setBackgroundResource(R.drawable.bike2);
            } else if (position == 3) {
                holder.mButton.setBackgroundResource(R.drawable.bike3);
            }else{
                holder.mButton.setBackgroundResource(R.drawable.bike4);
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