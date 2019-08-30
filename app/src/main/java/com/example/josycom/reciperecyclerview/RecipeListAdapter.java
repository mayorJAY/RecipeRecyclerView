package com.example.josycom.reciperecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>{
    private ArrayList<RecipeData> recipeList;
    private LayoutInflater mInflater;
    private View mItemView;
    private View.OnClickListener mOnItemClickListener;

    public RecipeListAdapter(Context context, ArrayList<RecipeData> recipeList){
        mInflater = LayoutInflater.from(context);
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mItemView = mInflater.inflate(R.layout.item_list, viewGroup, false);
        return new RecipeViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder recipeViewHolder, int position) {
        recipeViewHolder.name.setText((recipeList.get(position)).getName());
        recipeViewHolder.description.setText((recipeList.get(position)).getDescription());
    }


    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;


        public RecipeViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.recipe_name);
            description = itemView.findViewById(R.id.recipe_description);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}
