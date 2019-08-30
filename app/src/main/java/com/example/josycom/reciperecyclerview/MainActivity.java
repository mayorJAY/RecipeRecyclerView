package com.example.josycom.reciperecyclerview;import androidx.appcompat.app.AppCompatActivity;import androidx.recyclerview.widget.DividerItemDecoration;import androidx.recyclerview.widget.LinearLayoutManager;import androidx.recyclerview.widget.RecyclerView;import android.content.Intent;import android.os.Bundle;import android.view.View;import java.util.ArrayList;public class MainActivity extends AppCompatActivity {    private RecyclerView recyclerView;    private RecipeListAdapter recipeListAdapter;    private ArrayList<RecipeData> recipeList;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        recyclerView = findViewById(R.id.recyclerview);        recipeListAdapter = new RecipeListAdapter(MainActivity.this, recipeList);        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);        recyclerView.setLayoutManager(layoutManager);        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));        recyclerView.setAdapter(recipeListAdapter);        recipeListAdapter.setOnItemClickListener(onItemClickListener);        prepareRecipeList();    }    private void prepareRecipeList() {        recipeList = new ArrayList<>();        RecipeData data;        data = new RecipeData(getString(R.string.moo_shu_name), getString(R.string.moo_shu_description));        recipeList.add(data);        data = new RecipeData(getString(R.string.grilled_shrimp_name), getString(R.string.grilled_shrimp_description));        recipeList.add(data);        data = new RecipeData(getString(R.string.sirloin_tips_name), getString(R.string.sirloin_tips_description));        recipeList.add(data);        data = new RecipeData(getString(R.string.squash_casserole_name), getString(R.string.squash_casserole_description));        recipeList.add(data);        data = new RecipeData(getString(R.string.slow_casserole_name), getString(R.string.slow_casserole_description));        recipeList.add(data);    }    public void openDetailActivity(int imageId, String details){        Intent intent = new Intent(MainActivity.this, DetailActivity.class);        intent.putExtra("image", imageId);        intent.putExtra("details", details);        startActivity(intent);    }    private View.OnClickListener onItemClickListener = new View.OnClickListener() {        @Override        public void onClick(View v) {            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();            int position = viewHolder.getAdapterPosition();            RecipeData thisRecipe = recipeList.get(position);            if (thisRecipe.getName().equals(getString(R.string.moo_shu_name))){                openDetailActivity(R.drawable.moo_shu_img, String.valueOf((R.string.moo_shu_details)));            }        }    };}