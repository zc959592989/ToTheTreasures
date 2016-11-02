package feicui.edu.tothetreasure.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import feicui.edu.tothetreasure.R;

/**
 * Created by Administrator on 2016/11/1.
 */

public class TwoActivity extends Activity {

    @BindView(R.id.btn1)Button mBtn1;
    @BindView(R.id.btn2)Button mBtn2;
    @BindView(R.id.btn3)Button mBtn3;
    @BindView(R.id.btn4)Button mBtn4;
    @BindString(R.string.app_name)String s;

    Unbinder mUnbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    @Override
    public void onContentChanged() {
        mUnbinder= ButterKnife.bind(this);
        mBtn1.setText("按钮一");
        mBtn2.setText("按钮二");
        mBtn3.setText("按钮三");
        mBtn4.setText("按钮四");

    }

    @OnClick({R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                Toast.makeText(this,"btn1",Toast.LENGTH_SHORT).show();
                new SeverThread().start();

                break;
            case R.id.btn2:
                Toast.makeText(this,"btn2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn3:
                Toast.makeText(this,"btn3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn4:
                Toast.makeText(this,"btn4",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    class SeverThread extends Thread{
        @Override
        public void run() {//读数据  TCP协议
            //声明一个ServerSocket对象
//            ServerSocket serverSocket=null;
//            try {
//                serverSocket=new ServerSocket(4567);//指定在端口4567监听客户端
//                Socket socket=serverSocket.accept();//该方法有阻塞性，等待客户端连接
//                InputStream in=socket.getInputStream();
//                byte []arr=new byte[1024];
//                StringBuffer buffer=new StringBuffer();
//                int index=0;
//                while ((index=in.read(arr))!=-1){
//                  buffer=buffer.append(new String(arr,0,index));
//                    Log.e("aac", "run: "+buffer.toString());
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            try {
                DatagramSocket datagramSocket=new DatagramSocket(4567);//使用udp协议
                byte data[]=new byte[1024];
                DatagramPacket packet=new DatagramPacket(data,data.length);//发送或者接收数据，全部的数据都是以包的形式发送和接收的
                datagramSocket.receive(packet);//阻塞性    客户端发送数据才会向下执行
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
