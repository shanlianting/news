package net.shan.bwei.news.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.shan.bwei.news.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by shanlianting on 2017/7/6.
 */
public class PageFragment extends Fragment {
    public static  final String ARGS ="page_args";
    public String tab;
    TextView textView;
    public static PageFragment getInstance(String tab){
        Bundle bundle = new Bundle();
        bundle.putString(ARGS,tab);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tab = getArguments().getString(ARGS);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_page_content,null);
        textView = view.findViewById(R.id.textView);
        textView.setText(tab);
        return view;

    }


}
