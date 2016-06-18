package farmer.zpm.com.photoview;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.widget.Button;




import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.mainactivity_enter)
    Button mBtn_enter;

    @OnClick(R.id.mainactivity_enter)
    void click(){
        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }



}
