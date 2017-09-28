package com.example.gamis214.mvp_dagger_example.mainscreen;




import com.example.gamis214.mvp_dagger_example.models.Post;

import java.util.List;

/**
 * Created by Aditya on 11-May-16.
 */
public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
