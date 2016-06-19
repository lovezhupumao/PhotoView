package farmer.zpm.com.photoview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class PictureActivity extends Activity {

    PhotoViewAttacher mAttacher;
    @BindView(R.id.picture_image)
    PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ButterKnife.bind(this);
        String url=getIntent().getStringExtra("url");
        final PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);
        Picasso.with(this).load(url).into(photoView, new Callback() {
            @Override
            public void onSuccess() {
                attacher.update();
            }

            @Override
            public void onError() {

            }
        });

    }
}
