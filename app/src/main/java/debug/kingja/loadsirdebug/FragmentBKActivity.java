package debug.kingja.loadsirdebug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Description:TODO
 * Create Time:2017/9/26 14:32
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FragmentBKActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_fragment);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_content,new ChildFragmentBK()).commit();

    }
}
