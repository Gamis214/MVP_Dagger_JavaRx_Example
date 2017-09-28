package com.example.gamis214.mvp_dagger_example.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gamis214.mvp_dagger_example.R;
import com.example.gamis214.mvp_dagger_example.models.Post;

import java.util.List;

/**
 * Created by gamis214 on 27/09/17.
 */

public class CustomAdapterContract extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Post> lstPots;
    private OnClickToast onClickToast;

    public CustomAdapterContract(List<Post> lstPots, OnClickToast onClickToast){
        this.lstPots = lstPots;
        this.onClickToast = onClickToast;
    }

    public class ItemHolder extends RecyclerView.ViewHolder{

        private TextView txtId,txtContent;

        public ItemHolder(View itemView) {
            super(itemView);
            this.txtId       = itemView.findViewById(R.id.txtId);
            this.txtContent  = itemView.findViewById(R.id.txtContent);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemHolder itemHolder = (ItemHolder) holder;
        itemHolder.txtId.setText(lstPots.get(position).getId());
        itemHolder.txtContent.setText(lstPots.get(position).getBody());

        itemHolder.txtId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToast.showId(itemHolder.txtId.getText().toString());
            }
        });

        itemHolder.txtContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToast.showContent(itemHolder.txtContent.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstPots.size();
    }

    public interface OnClickToast {
        void showId(String id);
        void showContent(String content);
    }

}
