package com.example.gamis214.mvp_dagger_example.mainscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gamis214.mvp_dagger_example.MainApplication;
import com.example.gamis214.mvp_dagger_example.R;
import com.example.gamis214.mvp_dagger_example.adapters.CustomAdapterContract;
import com.example.gamis214.mvp_dagger_example.models.Post;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View,
        CustomAdapterContract.OnClickToast{

    @Inject
    MainScreenPresenter mainScreenPresenter;

    private RecyclerView myList;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList   = (RecyclerView)findViewById(R.id.my_list);
        progress = (ProgressBar) findViewById(R.id.progress);

        DaggerMainScreenComponent.builder()
                .netComponent(((MainApplication) getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        mainScreenPresenter.loadPost();

    }

    @Override
    public void showPosts(List<Post> posts) {

        myList = (RecyclerView) findViewById(R.id.my_list);

        myList.setHasFixedSize(true);
        myList.setLayoutManager(new LinearLayoutManager(this));
        myList.setAdapter(new CustomAdapterContract(posts,this));

        progress.setVisibility(View.GONE);
        myList.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,"Error: " + message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(this,"SUCCES SERVICES",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showId(String id) {
        Toast.makeText(this,id,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showContent(String content) {
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }
}
