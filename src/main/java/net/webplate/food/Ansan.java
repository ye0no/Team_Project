package net.webplate.food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import net.webplate.vo.FoodVO;

public class Ansan {

	public static void main(String[] args) throws IOException {
		// 1. URL�� ����� ���� StringBuilder.
		StringBuilder urlBuilder4 = new StringBuilder("https://api.odcloud.kr/api/3071314/v1/uddi:e4e7774d-0b16-4299-b830-dee5045df70f_201909291441?page=1&perPage=30&returnType=json&serviceKey=WZBWWUz20zYgzl3HeuXW1dKiMRMeTTkH2Ak8ssfM%2BJew2%2FbOP5mr5qwRntUWbHnghtJfz6WMjW9%2BXTDGdW9qcA%3D%3D\r\n" ); /*URL*/
		
        URL url4 = new URL(urlBuilder4.toString());
        HttpURLConnection conn4 = (HttpURLConnection) url4.openConnection();
        conn4.setRequestMethod("GET");
        conn4.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn4.getResponseCode());
        BufferedReader rd4;
        if(conn4.getResponseCode() >= 200 && conn4.getResponseCode() <= 300) {
            rd4 = new BufferedReader(new InputStreamReader(conn4.getInputStream()));
        } else {
            rd4 = new BufferedReader(new InputStreamReader(conn4.getErrorStream()));
        }
        StringBuilder sb4 = new StringBuilder();
        String line4;
        while ((line4 = rd4.readLine()) != null) {
            sb4.append(line4);
        }
        rd4.close();
        conn4.disconnect();
        System.out.println(sb4.toString());
        
        FoodVO vo=new FoodVO();
        
        try { 
            JSONParser parser4	= new JSONParser(); 
    		 JSONObject obj4 		= (JSONObject)parser4.parse(sb4.toString());
    		 JSONArray  item4 	= (JSONArray) obj4.get("data");
    		 
    		 System.out.println("JSON(obj) : " + obj4);
    		 System.out.println("JSON(item[]) : " + item4);
    		 
    		 for(int i=0; i<item4.size();i++) {
    			 Insert_food food=new Insert_food();
    			 JSONObject AnsanData=(JSONObject) item4.get(i);
    			 
    			 String bsnsCond4 =(String)AnsanData.get("�о߸�").toString();
    			 if(bsnsCond4.equals("�߱���")) {
    				 bsnsCond4="�߽�";
    			 }
    			 String bsnsNm4 =(String)AnsanData.get("���Ҹ�").toString();  
    			 String menu4 =(String)AnsanData.get("�ָ޴�").toString();  
    			 String addrJibun4 =(String)AnsanData.get("���������θ��ּ�").toString(); 
    			 String lat =(String)AnsanData.get("����").toString();  	
    			 String lng =(String)AnsanData.get("�浵").toString();   			 
    			 String tel4 =(String)AnsanData.get("��ȭ��ȣ").toString();  	
    			
    			 
    			 vo.setBsnscond(bsnsCond4);
    			 vo.setBsnsnm(bsnsNm4);
    			 vo.setMenu(menu4);
    			 vo.setAddr(addrJibun4);
    			 vo.setTel(tel4);
    			 vo.setLat(lat);
    			 vo.setLng(lng);
    			 
    			 food.save(vo);
    			 
    			 
    			 System.out.println("���� :"+bsnsCond4+"  ���Ҹ� : "+bsnsNm4+" ��ǥ�޴� : "+menu4+" �ּ�  : "+addrJibun4+" ��ȭ��ȣ :  "+tel4+ " ���� : "+ lat + "�浵  :"+ lng);
    			
    		 }
    		 
    		
           } catch(Exception e) {
        	   e.printStackTrace();
           }
        
	}

}