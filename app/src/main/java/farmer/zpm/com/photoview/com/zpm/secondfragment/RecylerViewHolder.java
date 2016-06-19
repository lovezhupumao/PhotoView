package farmer.zpm.com.photoview.com.zpm.secondfragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import com.rey.material.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import farmer.zpm.com.photoview.PictureActivity;
import farmer.zpm.com.photoview.R;

/**
 * Created by Administrator on 2016/6/19.
 */
public class RecylerViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    public String url;
    @BindView(R.id.view_imageview)
    ImageView imageView;
    @BindView(R.id.view_textview)
    TextView textView;
    @OnClick(R.id.view_container)
    void click(){
//        Intent intent =new Intent(mContext, PictureActivity.class);
//        intent.putExtra("url",url);
//        mContext.startActivity(intent);
    }
    public RecylerViewHolder(View itemView,Context context) {
        super(itemView);
        this.mContext=context;
        ButterKnife.bind(this,itemView);

    }
}
