package com.example.albertsonsinterview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.albertsonsinterview.adapters.AcronymsAdapter;
import com.example.albertsonsinterview.databinding.ActivityMainBinding;
import com.example.albertsonsinterview.utils.Util;
import com.example.albertsonsinterview.viewmodels.AcronymsViewModel;

public class MainActivity extends AppCompatActivity {
    public static final String NO_RECORDS_FOUND = "No Records Found";
    public static final String ERROR_IN_CALLING_API = "Error in calling API";
    ActivityMainBinding binding;
    private AcronymsViewModel viewModel;
    private AcronymsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(AcronymsViewModel.class);

        binding.searchBtn.setOnClickListener(v -> {
            performSearch();
        });
    }

    public void performSearch() {
        Util.hideKeyboard(MainActivity.this);
        String keyword = binding.etSearch.getEditableText().toString();
        viewModel.getAcronymsResponseLiveData(keyword).observe(this, acronymResponses -> {
            if (acronymResponses != null) {
                if(acronymResponses.size()>0){
                    adapter = new AcronymsAdapter(acronymResponses.get(0).getLongForms());
                    binding.rvAcronymList.setAdapter(adapter);
                }else{
                    Toast.makeText(this, NO_RECORDS_FOUND, Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, ERROR_IN_CALLING_API, Toast.LENGTH_SHORT).show();
            }
        });
    }
}