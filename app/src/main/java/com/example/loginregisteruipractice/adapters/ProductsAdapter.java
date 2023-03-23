package com.example.loginregisteruipractice.adapters;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.activities.ProductDetailActivity;
import com.example.loginregisteruipractice.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

// Create the basic adapters extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    // ... view holder defined above...

    // Store a member variable for the contacts
    private List<Product> mProducts;
    private Context mContext;


    // Pass in the contact array into the constructor
    public ProductsAdapter(List<Product> products) {
        mProducts = products;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View productView = inflater.inflate(R.layout.item_product, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
        // Get the data models based on position
        Product product = mProducts.get(position);

        // Set item views based on your views and data models
        ImageView image = holder.image;
        Picasso.get().load(product.getUrl())
                .into(image);
        TextView name = holder.name;
        name.setText(String.format("%s", product.getName()));

        TextView price = holder.price;
        price.setText(String.format("%.0f VND", product.getPrice()));

        View view = holder.view;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra("PRODUCT_ID", product.getId());
                mContext.startActivity(intent);
            }
        });

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView image;
        public TextView name;
        public TextView price;
        public View view;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            view = itemView;
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
