package feicui.edu.tothetreasure.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;

import feicui.edu.tothetreasure.R;

public class HomeActivity extends Activity {

    MapView mMapView;
    BaiduMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       super.setContentView(R.layout.activity_home);
        initView();
    }

    public void initView() {
        mMapView= (MapView) findViewById(R.id.map_baidu_home);
        map=mMapView.getMap();
        map.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        map.setTrafficEnabled(true);
        map.setMyLocationEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }


}
