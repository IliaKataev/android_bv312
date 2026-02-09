package com.example.secondlesson;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FirstFragment extends Fragment {

    private SharedViewModel viewModel;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.text_value);
        Button button = view.findViewById(R.id.button_increase);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        viewModel.getCounter().observe(getViewLifecycleOwner(), counter -> textView.setText("Значение: " + counter));

        button.setOnClickListener(v -> {
            viewModel.increaseBy3();
        });
    }
}
