package com.memebattle.megahack.main.fragment.request.presentation.recycler;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.memebattle.megahack.R;


import java.util.List;

public class RecyclerViewRequestsTaskAdapter extends RecyclerView.Adapter<RecyclerViewRequestsTaskAdapter.MyViewHolder> {
    private List<RequestsTask> requestsTaskList;
    public interface RecyclerCallback{
        void onItemClick(String requestId);
    }
    private RecyclerCallback recyclerCallback;
    public RecyclerViewRequestsTaskAdapter(List<RequestsTask> devicesList) {
        this.requestsTaskList = devicesList;

    }
    public void registerRecyclerCallback(RecyclerCallback recyclerCallback){
        this.recyclerCallback = recyclerCallback;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_request, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final RequestsTask requestsTask = requestsTaskList.get(position);
        holder.requestIdTextView.setText(requestsTask.requestId);
        holder.timeTextView.setText(requestsTask.time);
        holder.userIdTextView.setText(requestsTask.userId);
        holder.itemView.setOnClickListener(view -> {
            Log.i("TAG", "set on click item");
            recyclerCallback.onItemClick(requestsTask.requestId);
        });
    }
    @Override
    public int getItemCount() {
        return requestsTaskList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userIdTextView;
        private TextView timeTextView;
        private TextView requestIdTextView;

        MyViewHolder(View itemView) {
            super(itemView);
            userIdTextView = itemView.findViewById(R.id.textViewUserId);
            timeTextView = itemView.findViewById(R.id.textViewTime);
            requestIdTextView = itemView.findViewById(R.id.textViewRequestId);
        }
    }
}