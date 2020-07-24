package com.ilhambagoest.soal1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.ilhambagoest.soal1.R;
import com.ilhambagoest.soal1.data.SessionManager;
import com.ilhambagoest.soal1.data.api.ApiUtils;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

public class HomeFragment extends Fragment implements HomeView {

    CarouselView carouselView;
    SessionManager session;
    HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        carouselView = view.findViewById(R.id.cv_image);
        if (getContext() != null){
            session = new SessionManager(ApiUtils.getDefaultPreferences(getContext()));
        }

        ImageView ivProfile = view.findViewById(R.id.iv_profile_picture);
        Glide.with(this).load(session.getUserUrlPhoto()).error(R.drawable.ic_person_black).into(ivProfile);

        presenter = new HomePresenter(this);
        presenter.getImageList();
        return view;
    }

    @Override
    public void showImage(List<String> imageList) {
        ImageListener imageListener = (position, imageView) -> Glide.with(this)
                .load(imageList.get(position))
                .into(imageView);
        carouselView.setImageListener(imageListener);
        carouselView.setIndicatorVisibility(View.INVISIBLE);
        carouselView.setPageCount(imageList.size());
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}