package com.example.emptybase;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;

    public UserAdapter(ArrayList<User> input) {
        data = input;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate( R.layout.user_view2, parent, false);
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position) {
        User s = data.get(position);

        holder.txt.setText(s.name);
        holder.txt2.setText(s.description);

        if (s.name.charAt(s.name.length() - 1) == '7') {
            holder.iv.setVisibility(View.VISIBLE);
        }
    }

    public int getItemCount() {
        return data.size();
    }
}
