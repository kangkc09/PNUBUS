package com.example.termproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class OntimeBus extends AppCompatActivity {
    EditText edit;
    TextView text;

    XmlPullParser xpp;
    String key="4fjxBK7t4qYFtFF%2BTQwQsYaGHtdhRpT7rD77MIK3PRkXFthtpbJAgJQl2s%2BjIHDrc%2FEZQSxrm5Z8fgHKnkvyXQ%3D%3D";
//인증키




    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit= (EditText)findViewById(R.id.edit);
        text= (TextView)findViewById(R.id.result);
    }

    //Button을 클릭했을 때 자동으로 호출되는 callback method....
    public void mOnClick(View v){
        switch( v.getId() ){
            case R.id.button:

                //Android 4.0 이상 부터는 네트워크를 이용할 때 반드시 Thread 사용해야 함
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        data= getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                        //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                        //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                text.setText(data); //TextView에 문자열  data 출력
                            }
                        });
                    }
                }).start();
                break;
        }
    }//mOnClick method..


    //XmlPullParser를 이용하여 Naver 에서 제공하는 OpenAPI XML 파일 파싱하기(parsing)
    String getXmlData(){


        StringBuffer buffer=new StringBuffer();
        String bstopid = "212540201";
        String lineid = "5291107000";
        String str= edit.getText().toString();//EditText에 작성된 Text얻어오기
        String location = URLEncoder.encode(str);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding..
        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";
        String queryUrl="http://61.43.246.153/openapi-data/service/busanBIMS2/busStopArr?serviceKey="//요청 URL
                +key+"&bstopid="+bstopid+"&lineid="+lineid;

        try {
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//테그 이름 얻어오기

                        if(tag.equals("item")) // 첫번째 검색결과
                            buffer.append("법학관 버스\n");
                        else if(tag.equals("min1")){
                        buffer.append("첫번째 버스 남은 도착시간 : ");
                        xpp.next();
                        buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        buffer.append("\n"); //줄바꿈 문자 추가
                    }
                    else if(tag.equals("station1")){
                        buffer.append("남은 정거장 개수 : ");
                        xpp.next();
                        buffer.append(xpp.getText());//category 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        buffer.append("\n");//줄바꿈 문자 추가
                    }
                    else if(tag.equals("min2")){
                        buffer.append("두번째 버스 남은 도착시간 :");
                        xpp.next();
                        buffer.append(xpp.getText());//description 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        buffer.append("\n");//줄바꿈 문자 추가
                    }
                    else if(tag.equals("station2")){
                        buffer.append("남은 정거장 개수 :");
                        xpp.next();
                        buffer.append(xpp.getText());//description 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        buffer.append("\n");//줄바꿈 문자 추가
                    }



                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //테그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
                        break;
                }

                eventType= xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }

        buffer.append("파싱 끝\n");
        return buffer.toString();//StringBuffer 문자열 객체 반환

    }//getXmlData method....

}//MainActivity class..