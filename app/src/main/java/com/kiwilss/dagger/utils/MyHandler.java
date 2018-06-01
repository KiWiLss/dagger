package com.kiwilss.dagger.utils;


import android.util.Log;

import com.kiwilss.dagger.model.Provincel;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FileName: MyHandler
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/31
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class MyHandler extends DefaultHandler {

    public ArrayList<Provincel> mProvincels;
    private Provincel mProvincel;

    private String mCodeName;

    /**
     * 解析到文档开始调用，一般做初始化操作
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {

        //开始解析整个内容,初始化一些对象
        mProvincels = new ArrayList<>();
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //记录当前节点
        mCodeName = localName;
        //Log.e("MMM", "startElement: "+mCodeName );

        super.startElement(uri, localName, qName, attributes);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //根据节点获取内容
        StringBuilder sb = new StringBuilder();
        if ("province".equals(mCodeName)){
            mProvincel = new Provincel();
        }else if ("id".equals(mCodeName)){
            mProvincel.setId(sb.append(ch,start,length).toString());
        }else if ("countryId".equals(mCodeName)){
            mProvincel.setCountryId(sb.append(ch,start,length).toString());
        }else if ("provinceName".equals(mCodeName)){
            mProvincel.setProvinceName(sb.append(ch,start,length).toString());
        }
        Log.e("MMM", "characters: "+mProvincel);
        Log.e("MMM", "characters: ****"+ Arrays.toString(ch));


        super.characters(ch, start, length);


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("province".equals(mCodeName)){
            Log.e("MMM", "endElement: "+mProvincel);
            mProvincels.add(mProvincel);
        }
        Log.e("MMM", "endElement: "+localName+"||"+qName+"||"+mCodeName);
        super.endElement(uri, localName, qName);

    }

/**
 * * 解析到文档末尾调用，一般做回收操作
 */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        Log.e("MMM", "endDocument: "+mProvincels);
    }

    public List<Provincel>getList(){
        return mProvincels;
    }
}
