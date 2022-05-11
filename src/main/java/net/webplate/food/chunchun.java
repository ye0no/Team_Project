package net.webplate.food;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import net.webplate.vo.FoodVO;

import java.io.BufferedReader;
import java.io.IOException;

public class chunchun {

	public static void main(String[] args) throws IOException {

		StringBuilder urlBuilder2 = new StringBuilder("https://api.odcloud.kr/api/15050522/v1/uddi:4c4692a3-f748-48b1-bb47-9c121b60445f?page=1&perPage=10&returnType=json&serviceKey=WZBWWUz20zYgzl3HeuXW1dKiMRMeTTkH2Ak8ssfM%2BJew2%2FbOP5mr5qwRntUWbHnghtJfz6WMjW9%2BXTDGdW9qcA%3D%3D"); /*URL*/
        URL url2 = new URL(urlBuilder2.toString());
        HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
        conn2.setRequestMethod("GET");
        conn2.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn2.getResponseCode());
        BufferedReader rd2;
        if(conn2.getResponseCode() >= 200 && conn2.getResponseCode() <= 300) {
            rd2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
        } else {
            rd2 = new BufferedReader(new InputStreamReader(conn2.getErrorStream()));
        }
        StringBuilder sb2 = new StringBuilder();
        String line2;
        while ((line2 = rd2.readLine()) != null) {
            sb2.append(line2);
        }
        rd2.close();
        conn2.disconnect();
        System.out.println(sb2.toString());
        
        FoodVO vo=new FoodVO();
        
        try { 
            JSONParser parser2	= new JSONParser(); 
    		 JSONObject obj2 		= (JSONObject)parser2.parse(sb2.toString());
    		 JSONArray  item2 	= (JSONArray) obj2.get("data");
    		 
    		 System.out.println("JSON(obj) : " + obj2);
    		 System.out.println("JSON(item[]) : " + item2);
    		 
    		 for(int i=0; i<item2.size();i++) {
    			 
    			 Insert_food food=new Insert_food();
    			 JSONObject ChunchunData=(JSONObject) item2.get(i);
    			 
    			 
    			 String bsnsCond =(String)ChunchunData.get("����������").toString();  //����
    			 String bsnsNm =(String)ChunchunData.get("���Ҹ�").toString();  //���Ҹ�
    			 String menu =(String)ChunchunData.get("�ֵ�����").toString();  //�޴�	
    			 String addrJibun ="������  "+(String)ChunchunData.get("������(���θ�)").toString();  // ����
    			 String tel =(String)ChunchunData.get("��������ȭ��ȣ").toString();  //��ȭ��ȣ	
    			 String lat =(String)ChunchunData.get("����").toString();  // ����
    			 String lng =(String)ChunchunData.get("�浵").toString();  //�浵	
    			
    			 vo.setBsnscond(bsnsCond);
    			 vo.setBsnsnm(bsnsNm);
    			 vo.setMenu(menu);
    			 vo.setAddr(addrJibun);
    			 vo.setTel(tel);
    			 vo.setLat(lat);
    			 vo.setLng(lng);
    			 
    			 food.save(vo);
    			 
    			 
    			 System.out.println("���� :"+bsnsCond+"���Ҹ� :"+bsnsNm+"�޴� :"+menu+"�ּ� :"+addrJibun+"��ȭ��ȣ :"+tel+
    					 "���� : "+lat+"�浵 :"+lng);
    			
    		 }
    		 
    		 
    		 
           } catch(Exception e) {
        	   e.printStackTrace();
           }
        
        
	}

}