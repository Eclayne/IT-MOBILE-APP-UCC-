package com.ucc.itmobileapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.ucc.itmobileapp.R;
import com.ucc.itmobileapp.models.StaffMember;
import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> {

    private final Context context;
    private final List<StaffMember> staffList;

    public StaffAdapter(Context context, List<StaffMember> staffList) {
        this.context = context;
        this.staffList = staffList;
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_staff, parent, false);
        return new StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHolder holder, int position) {
        StaffMember member = staffList.get(position);

        holder.tvName.setText(member.getName());
        holder.tvTitle.setText(member.getTitle());
        holder.tvPhone.setText(member.getPhone());
        holder.tvEmail.setText(member.getEmail());

        if (member.getAvatarResId() != 0) {
            holder.ivAvatar.setImageResource(member.getAvatarResId());
        } else {
            holder.ivAvatar.setImageResource(android.R.drawable.sym_contact_card);
        }

        // Dial phone number
        holder.btnCall.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + member.getPhone().replaceAll("[^0-9+]", "")));
            context.startActivity(callIntent);
        });

        // Open email client
        holder.btnEmail.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + member.getEmail()));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry – UCC IT Department");
            if (emailIntent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(emailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    static class StaffViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvName, tvTitle, tvPhone, tvEmail;
        MaterialButton btnCall, btnEmail;

        StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvName);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            btnCall = itemView.findViewById(R.id.btnCall);
            btnEmail = itemView.findViewById(R.id.btnEmail);
        }
    }
}
