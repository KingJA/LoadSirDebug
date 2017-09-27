package debug.kingja.loadsirdebug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import butterknife.BindView;
import butterknife.ButterKnife;

import static debug.kingja.loadsirdebug.R.id.ll_rootView;

/**
 * Description:TODO
 * Create Time:2017/9/26 14:33
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FragmentBK extends Fragment {

    private LoadService loadService;
    @BindView(R.id.tv_fragment_msg)
    TextView mTv_Fragment_msg;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
//        View rootView = View.inflate(getActivity(), R.layout.fragment_bk, null);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_bk, container, false);
        ButterKnife.bind(this, rootView);
        LinearLayout ll_content = rootView.findViewById(R.id.ll_content);

        LoadSir loadSir = new LoadSir.Builder()
                .addCallback(new EmptyCallback())
                .build();
        loadService = loadSir.register(ll_content, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                loadService.showSuccess();
            }

        });
        loadService.showCallback(EmptyCallback.class);

        mTv_Fragment_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("mTv_Fragment_msg", "onClick: " );
            }
        });
        return loadService.getLoadLayout();
    }
}
