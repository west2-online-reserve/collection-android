package com.example.bili;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bili.databinding.ActivityMainBinding;
import com.example.bili.databinding.DynamicInfoBinding;
import com.example.bili.databinding.UpInfoBinding;
import com.example.bili.databinding.UpListBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 和recyclerview有关的变量
    RecyclerView recyclerView;
    Recycle_Adapter recycleAdapter;
    public List<UpList> uplists = new ArrayList<>();

    // 和viewpager2有关的变量
    ViewPager2 viewPager2;
    ViewPagers2_Adapter viewPagers2Adapter;

    private @NonNull ActivityMainBinding binding;
    private @NonNull UpListBinding list;
    private  @NonNull UpInfoBinding upinfo;
    private  @NonNull DynamicInfoBinding dry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = UpListBinding.inflate(getLayoutInflater());
        upinfo = UpInfoBinding.inflate(getLayoutInflater());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        dry = DynamicInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化控件
        recyclerView = binding.recyclerview;
        viewPager2 = binding.viwepager2;

        // 写up的id数据
        for (int i = 0; i < 6; i++) {
            UpList list = new UpList();
            list.ID = "up" + (i + 1);
            uplists.add(list);
        }

        // recyclerView需要一个Adapter
        recycleAdapter = new Recycle_Adapter();
        recyclerView.setAdapter(recycleAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        // viewPager2也需要一个Adapter
        viewPagers2Adapter = new ViewPagers2_Adapter();
        viewPager2.setAdapter(viewPagers2Adapter);

    }


    // ViewPagers2的Adapter函数
    class ViewPagers2_Adapter extends RecyclerView.Adapter<ViewPagers2_Adapter.ViewHolder> {

        private DynamicInfoBinding binding;

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            binding = DynamicInfoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            binding.getRoot().setLayoutParams(lp);
            ViewHolder viewHolder = new ViewHolder(binding.getRoot());
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            UpList list = uplists.get(position);
            holder.id_info.setText(list.ID+"的动态");
        }


        @Override
        public int getItemCount() {
            return uplists.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView head_info;
            TextView id_info;


            public ViewHolder(@NonNull View itemview) {
                super(itemview);
                head_info = binding.imageView3;
                id_info = binding.textView;

            }
        }

    }
    // RecyclerView的Adapter函数
    public class Recycle_Adapter extends RecyclerView.Adapter<Recycle_Adapter.MyViewHolder> implements View.OnClickListener {

        private UpListBinding binding;
        @Override
        public void onClick(View v){

        }

        private OnItemClickListener mListener;

        public void setOnItemClickListener(OnItemClickListener li) {
            mListener = li;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            binding = UpListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            binding.getRoot().setLayoutParams(lp);
            MyViewHolder myViewHolder = new MyViewHolder(binding.getRoot());
            return myViewHolder;
        }

        // 控件的各种跳转
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            UpList list = uplists.get(position);
            holder.head.setContentDescription(list.ID);
            holder.id.setText(list.ID);
            holder.id.setOnLongClickListener(new View.OnLongClickListener(){

                @Override
                public boolean onLongClick(View v){
                    Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                    intent.putExtra("name",list.ID);
                    startActivityForResult(intent,1);
                    return false;
                }
            });
            holder.id.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    viewPager2.setCurrentItem(position,true);
                }
            });

            holder.head.setOnLongClickListener(new View.OnLongClickListener(){

                @Override
                public boolean onLongClick(View v){
                    Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                    intent.putExtra("name",list.ID);
                    startActivityForResult(intent,1);
                    Log.e(TAG,"进入");
                    return false;
                }
            });
            holder.head.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    viewPager2.setCurrentItem(position,true);
                }
            });

        }

        public void dataDelete(String upname){
            for (int i = 0; i < uplists.size(); i++) {
                if (uplists.get(i).getID().equals(upname)) {
                    uplists.remove(i);
                    notifyItemRemoved(i);
                    notifyItemRangeChanged(i,uplists.size());
                    break;
                }
            }
        }

        @Override
        public int getItemCount() {
            return uplists.size();
        }

        class MyViewHolder  extends RecyclerView.ViewHolder {
            Button id;
            ImageButton head;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                head = binding.upHead;
                id = binding.upId;
            }
        }


    }
    // 按钮的接口
    public interface OnItemClickListener {
        void onItemClick(int pos);
    }


    // 接收DetailActivity传输来的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            // 获取被取关的up主的名称
            String name = data.getStringExtra("name");
            Log.e(TAG,(data.getStringExtra("name")));
            recycleAdapter.dataDelete(name);
        }
    }
}