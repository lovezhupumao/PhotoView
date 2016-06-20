package farmer.zpm.com.photoview;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import farmer.zpm.com.photoview.com.zpm.photoview.fragment.FifthFragment;
import farmer.zpm.com.photoview.com.zpm.photoview.fragment.FirstFragment;
import farmer.zpm.com.photoview.com.zpm.photoview.fragment.FourthFragment;
import farmer.zpm.com.photoview.com.zpm.photoview.fragment.SecondFragment;
import farmer.zpm.com.photoview.com.zpm.photoview.fragment.ThirtyFragment;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.homeactivity_bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.homeactivity_toolbar)
    Toolbar toolbar;
    @BindView(R.id.homeactivity_framelayout)
    FrameLayout mFrameLayout;
    private BottomBar mBottomBar;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirtyFragment thirtyFragment;
    private FourthFragment fourthFragment;
    private FifthFragment fifthFragment;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        fragmentManager=getFragmentManager();
        initBottomBar(savedInstanceState);
        //initBottomBar();



    }

    private void initBottomBar(Bundle savedInstanceState) {
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.noTabletGoodness();
        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                FragmentTransaction ft=fragmentManager.beginTransaction();
                hideFragments(ft);
                switch (menuItemId){
                    case R.id.bb_menu_recents:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.orange));
                        if (firstFragment==null) {
                            firstFragment = new FirstFragment();
                            ft.add(R.id.homeactivity_framelayout, firstFragment);
                        }
                        else {
                            ft.show(firstFragment);
                        }
                        break;
                    case R.id.bb_menu_favorites:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.teal));
                        if (secondFragment == null) {
                            secondFragment = new SecondFragment();
                            ft.add(R.id.homeactivity_framelayout, secondFragment);
                        } else {
                            ft.show(secondFragment);
                        }
                        break;
                    case R.id.bb_menu_nearby:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.blue));
                        if (thirtyFragment == null) {
                            thirtyFragment = new ThirtyFragment();
                            ft.add(R.id.homeactivity_framelayout, thirtyFragment);
                        } else {
                            ft.show(thirtyFragment);
                        }
                        break;
                    case R.id.bb_menu_friends:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.brown));
                        if (fourthFragment == null) {
                            fourthFragment = new FourthFragment();
                            ft.add(R.id.homeactivity_framelayout, fourthFragment);
                        } else {
                            ft.show(fourthFragment);
                        }
                        break;
                    case R.id.bb_menu_food:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        if (fifthFragment == null) {
                            fifthFragment = new FifthFragment();
                            ft.add(R.id.homeactivity_framelayout, fifthFragment);
                        } else {
                            ft.show(fifthFragment);
                        }
                        break;
                    default:
                        break;
                }
                ft.commit();
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
        mBottomBar.mapColorForTab(0, getResources().getColor(R.color.orange));
        mBottomBar.mapColorForTab(1, getResources().getColor(R.color.teal));
        mBottomBar.mapColorForTab(2, getResources().getColor(R.color.blue));
        mBottomBar.mapColorForTab(3, getResources().getColor(R.color.brown));
        mBottomBar.mapColorForTab(4, getResources().getColor(R.color.colorAccent));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mBottomBar.onSaveInstanceState(outState);
    }

    private void initBottomBar() {
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    case 0:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.orange));
                        break;
                    case 1:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.teal));
                        break;
                    case 2:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;
                    case 3:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.brown));
                        break;
                    case 4:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
        mBottomNavigationBar.clearAll();
        mBottomNavigationBar
                .setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
//        mBottomNavigationBar
////                .setActiveColor(R.color.primary)
//                .setInActiveColor(R.color.white)
//                .setBarBackgroundColor(R.color.primary_dark);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "Home")
                         .setActiveColorResource(R.color.orange)
                )
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "Books")
                        .setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "Music")
                        .setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "Movies & TV")
                        .setActiveColorResource(R.color.brown))
                .addItem(new BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "Games")
                        .setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .initialise();
    }
    public void hideFragments(FragmentTransaction ft) {
        if (firstFragment != null)
            ft.hide(firstFragment);
        if (secondFragment != null)
            ft.hide(secondFragment);
        if (thirtyFragment != null)
            ft.hide(thirtyFragment);
        if (fourthFragment != null)
            ft.hide(fourthFragment);
        if (fifthFragment!=null)
            ft.hide(fifthFragment);
    }

}
