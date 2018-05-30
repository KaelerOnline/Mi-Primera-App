package com.teaching.android.miprimeraapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.teaching.android.miprimeraapp.fragments.GameDetailFragment;
import com.teaching.android.miprimeraapp.interactors.GamesFirebseInteractor;
import com.teaching.android.miprimeraapp.model.GameModel;
import com.teaching.android.miprimeraapp.presenters.GameDetailPresenter;
import com.teaching.android.miprimeraapp.view.GameDetailView;

import java.util.Objects;

public class GameDetailActivity extends BaseActivity implements GameDetailView {

    private GameDetailPresenter presenter;
    private int currentPosition;
    private MyPagerAdapter myPagerAdapter;
    private GamesFirebseInteractor gamesFirebseInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);
        setupActionBar();
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        presenter = new GameDetailPresenter();

        currentPosition = getIntent().getIntExtra("position", 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_doom, menu);
        return true;
    }

    protected void setupActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar6);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_doom);
    }

    @Override
    public void onGameLoaded(GameModel game) {
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            int gameId = presenter.getGames().get(position).getId();
            return GameDetailFragment.newInstance(gameId);
        }

        @Override
        public int getCount() {
            return presenter.getGames().size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return (presenter.getGames().get(position).getName());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.startPresenting(this);
        ViewPager myViewPager = findViewById(R.id.view_pager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myPagerAdapter);
        myViewPager.setCurrentItem(currentPosition);
        Objects.requireNonNull(getSupportActionBar()).setTitle(myPagerAdapter.getPageTitle(currentPosition));
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                                @Override
                                                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                                }

                                                @Override
                                                public void onPageSelected(int position) {
                                                    Objects.requireNonNull(getSupportActionBar()).setTitle(myPagerAdapter.getPageTitle(position));
                                                }

                                                @Override
                                                public void onPageScrollStateChanged(int state) {
                                                }
                                            }
        );
    }
}
