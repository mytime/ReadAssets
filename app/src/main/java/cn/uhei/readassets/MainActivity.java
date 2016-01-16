package cn.uhei.readassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 读取Assets（资源）文件
 * Studio 环境下默认没有Assets目录，
 * Assets创建位置: 工程/app/src/main/
 *
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ReadAssets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //getAssets() 指向 工程/app/src/main/Assets目录
                    InputStream is = getResources().getAssets().open("info.txt");
                    //字符流
                    InputStreamReader isr = new InputStreamReader(is,"UTF-8");
                    //缓冲
                    BufferedReader bfr = new BufferedReader(isr);

                    String in = "";
                    while ((in = bfr.readLine()) != null){
                        Log.i(TAG,in);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
