package farmer.zpm.com.photoview.com.zpm.secondfragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rey.material.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import farmer.zpm.com.photoview.PictureActivity;
import farmer.zpm.com.photoview.R;

/**
 * Created by Administrator on 2016/6/19.
 */
public class RecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<PicBean.NewslistBean> mlist;
    private Context mContext;

    public RecylerViewAdapter(Context context,List<PicBean.NewslistBean> list) {
        mLayoutInflater=LayoutInflater.from(context);
        mlist=list;
        mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecylerViewHolder(mLayoutInflater.inflate(R.layout.view_recylerview, parent, false),mContext);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PicBean.NewslistBean newslistBean=mlist.get(position);
        if (newslistBean==null)return;
        if (holder instanceof RecylerViewHolder){
            RecylerViewHolder nholder = (RecylerViewHolder) holder;
            bindNormalItem(newslistBean, nholder.imageView, nholder.textView,nholder.url);
        }
    }

    private void bindNormalItem(PicBean.NewslistBean newslistBean, ImageView imageView, TextView textView, String url) {
        textView.setText(newslistBean.getTitle());
        Picasso.with(mContext).load(newslistBean.getPicUrl()).into(imageView);
        url=newslistBean.getPicUrl();
        final String finalUrl = url;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mContext, PictureActivity.class);
                intent.putExtra("url", finalUrl);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    public void addList(PicBean.NewslistBean newslistBean){
        mlist.add(newslistBean);
        notifyDataSetChanged();
    }
    public  void addList(List<PicBean.NewslistBean> list){
        mlist.addAll(list);
        notifyDataSetChanged();
    }
    public void removeAll(){
        mlist.clear();
        notifyDataSetChanged();
    }
}
