package com.example.notes2text.adapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.notes2text.R;
import com.example.notes2text.adapters.fragments.AccountViewController;
import com.example.notes2text.adapters.fragments.DirectoryAccessController;
import com.example.notes2text.adapters.fragments.OCRFragmentController;
import com.example.notes2text.databinding.ActivityViewBinding;

public class ActivitySwitchController extends AppCompatActivity {

    ActivityViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new DirectoryAccessController());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();
            if (itemId == R.id.directoryButton) {
                replaceFragment(new DirectoryAccessController());
            } else if (itemId == R.id.OCRButton) {
                replaceFragment(new OCRFragmentController());
            } else if (itemId == R.id.AccountButton) {
                replaceFragment(new AccountViewController());
            }

            return true;
        });
    }

        private void replaceFragment(Fragment fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.activity_view_frame, fragment);
            fragmentTransaction.commit();
        }
}