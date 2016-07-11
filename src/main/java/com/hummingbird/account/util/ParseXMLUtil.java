package com.hummingbird.account.util;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ParseXMLUtil {

    /**
     * 解析xml格式字符串
     * @return 对账文件名
     */
    public String parseXmlName(String xml){
        System.out.println("接收到的字符串为:" + xml);
        String findFileName = "";
        try {
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext();) {
                Element head = (Element) i.next();
                for (Iterator j = head.elementIterator(); j.hasNext();) {
                    Element elem = (Element) j.next();
                    for(Iterator k = elem.elementIterator();k.hasNext();){
                        Element data = (Element) k.next();
                        System.out.println(">>>"+data.getName() + ":" + data.getText());
                        if("DZJGWJM".equals(data.getName())){
                            findFileName = data.getText();
                        }
                    }
                }
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage() + "hello");
        }
        System.out.println("dom4j parserXml");
        return findFileName;
    }
    
    /**
     *  解析接收到的xml字符串 
     * @param xml
     * @return 获得ca签名后的字符串
     */
    public  String parseXmlCa(String xml){
        System.out.println("接收到的字符串为:" + xml);
        String ca = "";
        try {
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext();) {
                Element head = (Element) i.next();
                for (Iterator j = head.elementIterator(); j.hasNext();) {
                    Element elem = (Element) j.next();
                    System.out.println(">>>"+elem.getName() + ":" + elem.getText());
                    for(Iterator k = elem.elementIterator();k.hasNext();){
                        Element data = (Element) k.next();
                        System.out.println(">>>"+data.getName() + ":" + data.getText());
                        if("CA".equals(data.getName())){
                            ca = data.getText();
                        }
                    }
                }
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage() + "hello");
        }
        return ca;
    }
        
     public int parseXmlStatus(String xml){
	        int status = 0;
	        try {
	            Document document = DocumentHelper.parseText(xml);
	            Element root = document.getRootElement();
	            for (Iterator i = root.elementIterator(); i.hasNext();) {
	                Element head = (Element) i.next();
	                for (Iterator j = head.elementIterator(); j.hasNext();) {
	                    Element elem = (Element) j.next();
	                    System.out.println(">>>"+elem.getName() + ":" + elem.getText());
	                                        if("STATUS".equals(elem.getName())){
	                                            status = Integer.parseInt(elem.getTextTrim());
	                                        }
	                }
	            }
	        } catch (DocumentException e) {
	            System.out.println(e.getMessage() + "hello");
	        }
	        return status;
       }
}