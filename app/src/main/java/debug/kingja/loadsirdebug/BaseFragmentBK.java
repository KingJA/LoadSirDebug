package debug.kingja.loadsirdebug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description:TODO
 * Create Time:2017/9/26 14:33
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class BaseFragmentBK extends Fragment {

    protected LoadService loadService;
    protected Unbinder unBinder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
//        View rootView = View.inflate(getActivity(), R.layout.fragment_bk, null);
        View rootView = inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, rootView);

        LoadSir loadSir = new LoadSir.Builder()
                .addCallback(new EmptyCallback())
                .build();
        loadService = loadSir.register(rootView, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                loadService.showSuccess();
            }

        });
        loadService.showCallback(EmptyCallback.class);
        return loadService.getLoadLayout();
    }

    abstract int getLayoutId();
}
