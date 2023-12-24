package com.example.bili;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static java.lang.Math.random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bili.databinding.UpInfoBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DetailActivity extends AppCompatActivity {

    private UpInfoBinding binding;
    Button btnUnfollow;
    TextView name;
    TextView focus;
    TextView follow;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = UpInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        btnUnfollow = binding.button;
        name = binding.idInfo;
        focus = binding.focusInfo;
        follow = binding.fellowInfo;

        // 接受MainActivity传输过来的数据
        Intent i =getIntent();
        name.setText(i.getStringExtra("name"));
        focus.setText("关注：100");
        follow.setText("粉丝：100");
        String upid = i.getStringExtra("name");

        btnUnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 向上一个Activity返回数据
                Intent intent = new Intent();
                intent.putExtra("name", i.getStringExtra("name"));
                setResult(1, intent);

                // Toast提示取关成功
                Toast.makeText(getApplicationContext(), "取关成功", Toast.LENGTH_SHORT).show();
                // 关闭当前Activity
                finish();
            }
        });
    }

}

