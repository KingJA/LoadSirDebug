package debug.kingja.loadsirdebug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2017/9/27 10:04
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ChildFragmentBK extends BaseFragmentBK {

    @BindView(R.id.tv_fragment_msg)
    TextView mTv_Fragment_msg;

    @Override
    int getLayoutId() {
        return R.layout.fragment_bk;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTv_Fragment_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("ChildFragmentBK", "onClick: ");
                Toast.makeText(getActivity(), "onClick", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
    }
}
