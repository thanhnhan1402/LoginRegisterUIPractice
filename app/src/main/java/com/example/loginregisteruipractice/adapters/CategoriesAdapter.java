package com.example.loginregisteruipractice.adapters;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.activities.ProductsActivity;
import com.example.loginregisteruipractice.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Category> categoryList;

    //getting the context and product list with constructor
    public CategoriesAdapter(Context mCtx, List<Category> categoryList) {
        this.mCtx = mCtx;
        this.categoryList = categoryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_category, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //getting the product of the specified position
        Category category = categoryList.get(position);

        TextView categoryName = holder.textViewCategoryName;
        categoryName.setText(category.getName());

        ImageView image = holder.imageView;
        Picasso.get().load(category.getUrl())
                .into(image);

        View view = holder.view;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mCtx, ProductsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("CATEGORY", category);
                intent.putExtras(bundle);
                mCtx.startActivity(intent);

                ((Activity) mCtx).finish();
            }
        });
    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView textViewCategoryName;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textViewCategoryName = itemView.findViewById(R.id.category_name);
            imageView = itemView.findViewById(R.id.category_image);

        }
    }
}
