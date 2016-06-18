package farmer.zpm.com.photoview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    //    @BindView(R.id.homeactivity_bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.homeactivity_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.homeactivity_bottom_navigation_bar);
        setSupportActionBar(toolbar);
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


}
