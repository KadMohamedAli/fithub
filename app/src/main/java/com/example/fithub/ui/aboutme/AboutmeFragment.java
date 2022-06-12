package com.example.fithub.ui.aboutme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.fithub.R;
import com.example.fithub.databinding.FragmentAboutmeBinding;
import com.example.fithub.goal_calorie;

public class AboutmeFragment extends Fragment {

    private FragmentAboutmeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AboutmeViewModel aboutmeViewModel =
                new ViewModelProvider(this).get(AboutmeViewModel.class);

        binding = FragmentAboutmeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.placeholder2, new goal_calorie());
        ft.commit();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}