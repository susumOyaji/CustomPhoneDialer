package jp.co.acesystems.callreceiver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myReceiver;
    IntentFilter intentFilter;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // レシーバーオブジェクトの生成
        myReceiver = new MyBroadcastReceiver();
        // レシーバーが受信できるインテントを指定してインテントフィルターを生成
        intentFilter = new IntentFilter("ORIGINAL_ACTION");

        // onClickListenerの登録
        findViewById(R.id.button).setOnClickListener(button1ClickListener);





    }

    @Override
    public void onResume() {
        super.onResume();
        // ブロードキャストレシーバーを登録する。（どんなインテントがきたらどのレシーバーをキックするかを定義づける）
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        // ブロードキャストレシーバーを解除する
        unregisterReceiver(myReceiver);
    }

    // ボタン押下時の処理を記載
    View.OnClickListener button1ClickListener = new View.OnClickListener() {
        // ボタン押下時にはこのメソッドが動く
        public void onClick(View view) {
            // ブロードキャスト送信するインテントの種類を定義する
            Intent i = new Intent("ORIGINAL_ACTION");
            // ブロードキャストにメッセージを付与する
            i.putExtra("key", "message");
            // ブロードキャスト送信
            sendBroadcast(i);
        }
    };

    public class MyBroadcastReceiver extends BroadcastReceiver {
        // ブロードキャスト受信時にこのメソッドが動く
        @Override
        public void onReceive(Context context, Intent i) {
            // ブロードキャスト受信時の処理（今回は適当）
            tv = (TextView) findViewById(R.id.textView);
            tv.setText("abc");
        }
    }
}