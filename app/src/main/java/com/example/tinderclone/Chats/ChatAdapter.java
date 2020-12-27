package com.example.tinderclone.Chats;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tinderclone.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolders> {

    private List<ChatObject> chatList;
    private Context context;

    public ChatAdapter(List<ChatObject> matchesList, Context context){
        this.chatList = matchesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null, false);
        ChatViewHolders rcv = new ChatViewHolders(layoutView);

        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolders holder, int position) {
        holder.mMessage.setText(chatList.get(position).getMessage());
        if (chatList.get(position).getCurrentUser()){
            holder.mContainer.setGravity(Gravity.END);
            holder.mMessage.setTextColor(Color.WHITE);
            holder.mMessage.setBackground(ContextCompat.getDrawable(context, R.drawable.msg_backround));
        }else{
            holder.mContainer.setGravity(Gravity.START);
            holder.mMessage.setTextColor(Color.BLACK);
            holder.mMessage.setBackground(ContextCompat.getDrawable(context, R.drawable.opp_msg_back));
        }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
}
