package com.example.pr16;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Character> charList;

    public RecyclerViewAdapter(Context context, ArrayList<Character> charList) {
        this.context = context;
        this.charList = charList;
    }

    @NotNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Character character = charList.get(position);
        holder.charName.setText(character.getName_Char());
        holder.charClass.setText(character.getClass_Char());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoActivity.class);
                intent.putExtra("ID", character.getID_Char());
                intent.putExtra("Name", character.getName_Char());
                intent.putExtra("Class", character.getClass_Char());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return charList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView charName;
        TextView charClass;
        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            charName = itemView.findViewById(R.id.name_char);
            charClass = itemView.findViewById(R.id.class_char);
        }
    }
}
