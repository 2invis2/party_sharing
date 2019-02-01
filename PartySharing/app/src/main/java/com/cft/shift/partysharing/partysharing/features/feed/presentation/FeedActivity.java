package com.cft.shift.partysharing.partysharing.features.feed.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.profile.presentation.CreateEventActivity;
import com.cft.shift.partysharing.partysharing.features.profile.presentation.ProfileActivity;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;

public class FeedActivity extends BaseActivity implements FeedView {

    private ListView mListFeed;
    private FeedListAdapter mFeedListAdapter;
    private TabItem mTabFeed;
    private TabItem mTabPending;
    private TabLayout.OnTabSelectedListener mOnTabSelectedListener;

    private FeedPresenter presenter;
    private ViewPager viewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    return true;
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_create:
                    Intent intent2 = new Intent(FeedActivity.this, CreateEventActivity.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_profile:
                    Intent intent3 = new Intent(FeedActivity.this, ProfileActivity.class);
                    startActivity(intent3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        initView();
    }

    private void initView(){
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        return ;
                    case 1:
                        Intent intent = new Intent(FeedActivity.this, PendingActivity.class);
                        startActivity(intent);
                        return ;
                }
                return;
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        };

        //viewPager = (ViewPager) findViewById(R.id.viewpager);
        //setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        //tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(mOnTabSelectedListener);

        TextView text = findViewById(R.id.text_feed);
        text.setText("Feed");

        loadFeed();

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FeedFragment(), "Feed");
        adapter.addFragment(new FeedFragment(), "Pending");
        viewPager.setAdapter(adapter);
    }

    private void loadFeed() {
        presenter.loadFeed();
    }

    @Override
    protected MvpPresenter<FeedView> getPresenter() {
        presenter = PresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected  MvpView getMvpView() {
        return this;
    }

    @Override
    public void showEventList(FeedResponse list) {
        FeedListAdapter mFeedListAdapter = new FeedListAdapter(this, list.getFeed().getData());

        mListFeed = findViewById(R.id.list_feed);
        mListFeed.setAdapter(mFeedListAdapter);
    }

    @Override
    public void showError(String message) {
        Toast toast = Toast.makeText( this,  message, Toast.LENGTH_LONG);
        toast.show();

    }
}
