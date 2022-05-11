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

public class Hoengseong {

	public static void main(String[] args) throws IOException {
		
		FoodVO vo=new FoodVO();

		StringBuilder urlBuilder5 = new StringBuilder("https://api.odcloud.kr/api/15039331/v1/uddi:8a375705-5616-4e95-82e2-d0764df7caf3?page=1&perPage=20&returnType=json&serviceKey=WZBWWUz20zYgzl3HeuXW1dKiMRMeTTkH2Ak8ssfM%2BJew2%2FbOP5mr5qwRntUWbHnghtJfz6WMjW9%2BXTDGdW9qcA%3D%3D"); /*URL*/
        URL url5 = new URL(urlBuilder5.toString());
        HttpURLConnection conn5 = (HttpURLConnection) url5.openConnection();
        conn5.setRequestMethod("GET");
        conn5.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn5.getResponseCode());
        BufferedReader rd5;
        if(conn5.getResponseCode() >= 200 && conn5.getResponseCode() <= 300) {
            rd5 = new BufferedReader(new InputStreamReader(conn5.getInputStream()));
        } else {
            rd5 = new BufferedReader(new InputStreamReader(conn5.getErrorStream()));
        }
        StringBuilder sb5 = new StringBuilder();
        String line5;
        while ((line5 = rd5.readLine()) != null) {
            sb5.append(line5);
        }
        rd5.close();
        conn5.disconnect();
        System.out.println(sb5.toString());
        
       
        try { 
            JSONParser parser5	= new JSONParser(); 
    		 JSONObject obj5 		= (JSONObject)parser5.parse(sb5.toString());
    		 JSONArray  item5 	= (JSONArray) obj5.get("data");
    		 
    		 System.out.println("JSON(obj) : " + obj5);
    		 System.out.println("JSON(item[]) : " + item5);
    		 
    		 for(int i=0; i<item5.size();i++) {
    			 Insert_food food=new Insert_food();
    			 JSONObject KangwondoData=(JSONObject) item5.get(i);
    			 
    			 String bsnsCond5 =(String)KangwondoData.get("업태").toString(); 
    			 String bsnsNm5 =(String)KangwondoData.get("업소명").toString();  
    			 String menu5 =(String)KangwondoData.get("주요메뉴").toString();  
    			 String addrJibun5 =(String)KangwondoData.get("소재지지번주소").toString();

    			 String lat="";  //위도
    			 if((String)KangwondoData.get("위도(WGS84좌표)").toString()!=null){
    				 lat=(String)KangwondoData.get("위도(WGS84좌표)").toString();
    			 }
    			 
    			 String lng="";
    			 if((String)KangwondoData.get("경도(WGS84좌표)").toString()!=null){
     				lng=(String)KangwondoData.get("경도(WGS84좌표)").toString();  //경도
    			 }	    			
    			 
    			 String tel="";
    			 if((String)KangwondoData.get("연락처").toString()!=null) {
    				 tel=(String)KangwondoData.get("연락처").toString();
    			 }
    			 
    			 String accept=(String)KangwondoData.get("최대 수용인원").toString();
    			 String rest =(String)KangwondoData.get("휴무일").toString();
    			 
    			vo.setBsnscond(bsnsCond5);
    			vo.setBsnsnm(bsnsNm5);
    			vo.setMenu(menu5);
    			vo.setAddr(addrJibun5);
    			vo.setLat(lat);
    			vo.setLng(lng);
    			vo.setTel(tel);
    			vo.setRest(rest);
    			vo.setSuyong(accept);
    			 
    			 food.save2(vo);
    			 
    			 System.out.println("업태 :"+bsnsCond5+"업소명 : "+bsnsNm5+"메뉴 : "+menu5+"주소 :"+addrJibun5+"위도 : " +" 최대 수용인원 : "+accept+" 휴무일 :"+rest + 
    					 "위도 :" +lat +"경도"+ lng +"연락처  :"+ tel );
    			 
    			
    		 }
    		 
    		
           } catch(Exception e) {
        	   e.printStackTrace();
           }
        
	}

}