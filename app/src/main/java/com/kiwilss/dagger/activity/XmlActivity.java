package com.kiwilss.dagger.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.model.Provincel;
import com.kiwilss.dagger.utils.MyHandler;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

/**
 * FileName: XmlActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/31
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class XmlActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

    }


    public void pullListener(View view) {
        ArrayList<Provincel> provincels = null;
        //读取assets里的数据
        try {
            InputStream is = getAssets().open("provinceList.xml");
            //xml
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(is,"UTF_8");
            int eventType = xpp.getEventType();

            Provincel provincel = null;
            //开始循环解析
            while (eventType != XmlPullParser.END_DOCUMENT){
                String name = xpp.getName();
                //Log.e("MMM", "pullListener: "+name);
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("provinceList".equals(name)){
                            provincels = new ArrayList<>();
                        }else if ("province".equals(name)){
                            provincel = new Provincel();
                        }else if ("id".equals(name)){
                            provincel.setId(xpp.nextText());
                        }else if ("countryId".equals(name)){
                            provincel.setCountryId(xpp.nextText());
                        }else if ("provinceName".equals(name)){
                            assert provincel != null;
                            provincel.setProvinceName(xpp.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("province".equals(name)){
                            provincels.add(provincel);
                        }
                        break;
                        default:
                }
                eventType=xpp.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        for (Provincel p :
                provincels) {
            Log.e("MMM", "pullListener: "+p);
        }
    }

    public void saxListener(View view) {


        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);
            InputStream is = getAssets().open("provinceList.xml");
            xmlReader.parse(new InputSource(is));
            Log.e("MMM", "saxListener: "+myHandler.getList());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
