package com.example.loginregisteruipractice.adapters;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.activities.ProductDetailActivity;
import com.example.loginregisteruipractice.models.CartItem;

import java.util.List;

public class CartsAdapter extends RecyclerView.Adapter<CartsAdapter.CartItemViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<CartItem> cartList;

    //getting the context and product list with constructor
    public CartsAdapter(Context mCtx, List<CartItem> cartList) {
        this.mCtx = mCtx;
        this.cartList = cartList;
    }

    @Override
    public CartItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_cart, parent, false);
        return new CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartItemViewHolder holder, int position) {
        // Getting the product of the specified position
        CartItem cartItem = cartList.get(position);

        // Binding the data with the viewholder views
        holder.textViewProductName.setText(cartItem.getProduct().getName());
        holder.textViewQuantity.setText(String.valueOf(cartItem.getQuantity()));
        holder.textViewPrice.setText(String.valueOf(cartItem.getProduct().getPrice()));
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewProductName, textViewPrice, textViewQuantity;

        public CartItemViewHolder(View itemView) {
            super(itemView);

            textViewProductName = itemView.findViewById(R.id.product_name);
            textViewQuantity = itemView.findViewById(R.id.etAmount);
            textViewPrice = itemView.findViewById(R.id.product_price);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent detail = new Intent(mCtx, ProductDetailActivity.class);
            mCtx.startActivity(detail);
        }
    }
}