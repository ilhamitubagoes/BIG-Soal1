package com.ilhambagoest.soal1.ui.home;

import java.util.ArrayList;
import java.util.List;

class HomePresenter {

    HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }

    void getImageList(){
        List<String> imageList = new ArrayList<>();
        imageList.add("https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823__340.jpg");
        imageList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRYsx41-h1Phoih05MkiMDp7jmt5eCkov2NkQ&usqp=CAU");
        imageList.add("https://c4.wallpaperflare.com/wallpaper/826/405/131/clouds-colors-fence-forests-wallpaper-preview.jpg");
        homeView.showImage(imageList);

        /*ApiUtils.getAPIService().getImage().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(@NotNull Call<List<String>> call, @NotNull Response<List<String>> response) {
                homeView.showImage(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<List<String>> call, @NotNull Throwable t) {
                homeView.showError(t);
            }
        });*/
    }
}
