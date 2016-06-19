package farmer.zpm.com.photoview.com.zpm.photoview.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import farmer.zpm.com.photoview.R;

/**
 * Created by Administrator on 2016/6/19.
 */
public class FifthFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view==null)
            view=inflater.inflate(R.layout.fragment_home_fifty,container,false);

        return view;
    }
}
