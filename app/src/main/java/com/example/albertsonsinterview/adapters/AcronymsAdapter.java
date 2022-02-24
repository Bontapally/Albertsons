package com.example.albertsonsinterview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.albertsonsinterview.R;
import com.example.albertsonsinterview.models.LongForm;
import com.example.albertsonsinterview.utils.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AcronymsAdapter extends RecyclerView.Adapter<AcronymsAdapter.AcronymsResultHolder> {
    private final List<LongForm> results;

    public AcronymsAdapter(List<LongForm> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public AcronymsResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.acronym_item_layout, parent, false);
        return new AcronymsResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AcronymsResultHolder holder, int position) {
        LongForm mLongForm = results.get(position);

        holder.tvAcronym.setText(Util.capitalizeByWords(mLongForm.getLongForm()));
        holder.tvYear.setText(String.valueOf(mLongForm.getSince()));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class AcronymsResultHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.acronym_tv)
        TextView tvAcronym;
        @BindView(R.id.year_tv)
        TextView tvYear;

        public AcronymsResultHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
