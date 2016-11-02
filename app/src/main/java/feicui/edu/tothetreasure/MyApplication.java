package feicui.edu.tothetreasure;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Administrator on 2016/10/31.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现  建议放在此处
        SDKInitializer.initialize(getApplicationContext());
    }
}
