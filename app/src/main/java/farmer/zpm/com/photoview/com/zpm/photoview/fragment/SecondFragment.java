package farmer.zpm.com.photoview.com.zpm.photoview.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import farmer.zpm.com.photoview.R;
import farmer.zpm.com.photoview.com.zpm.secondfragment.GetPic;
import farmer.zpm.com.photoview.com.zpm.secondfragment.PicBean;
import farmer.zpm.com.photoview.com.zpm.secondfragment.RecylerViewAdapter;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/19.
 */
public class SecondFragment extends Fragment {
    private View view;
    private RecylerViewAdapter mrecyleradapter;
    @BindView(R.id.fragment_sec_recylerview)
    XRecyclerView xRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view==null)
            view=inflater.inflate(R.layout.fragment_home_second,container,false);
        ButterKnife.bind(this,view);
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 设置ItemAnimator
        xRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        xRecyclerView.setHasFixedSize(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com/txapi/mvtp/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        final GetPic pic = retrofit.create(GetPic.class);
        pic.getPic("8")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PicBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PicBean picBean) {
                        System.out.println("onNext");
                        mrecyleradapter=new RecylerViewAdapter(getActivity(),picBean.getNewslist());
                        xRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                        // 设置ItemAnimator
                        xRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        // 设置固定大小
                        xRecyclerView.setHasFixedSize(true);

                        // 为mRecyclerView设置适配器
                        xRecyclerView.setAdapter(mrecyleradapter);
                    }
                });
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                pic.getPic("4") .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<PicBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PicBean picBean) {
                        mrecyleradapter.addList(picBean.getNewslist());
                        xRecyclerView.loadMoreComplete();
                    }
                });
            }
        });
        return view;
    }
}
