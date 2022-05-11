package net.webplate.food;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import net.webplate.vo.FoodVO;

import java.io.BufferedReader;
import java.io.IOException;

public class Busan {
    public static void main(String[] args) throws IOException {
    	// 1. URL을 만들기 위한 StringBuilder.
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/BusanTblFnrstrnStusService/getTblFnrstrnStusInfo"); /*URL*/
        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=WZBWWUz20zYgzl3HeuXW1dKiMRMeTTkH2Ak8ssfM%2BJew2%2FbOP5mr5qwRntUWbHnghtJfz6WMjW9%2BXTDGdW9qcA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("32", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
     
        // 3. URL 객체 생성.
        URL url = new URL(urlBuilder.toString());
        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 5. 통신을 위한 메소드 SET.
        conn.setRequestMethod("GET");
     // 6. 통신을 위한 Content-type SET
        conn.setRequestProperty("Content-type", "application/json");
        // 7. 통신 응답 코드 확인.
        System.out.println("Response code: " + conn.getResponseCode());
     // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
     // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        // 10. 객체 해제.
        rd.close();
        conn.disconnect();
     // 11. 전달받은 데이터 확인.
        System.out.println(sb.toString());
        
        
        FoodVO vo=new FoodVO();
       
        
       try { 
    	   // 1. 문자열 형태의 JSON을 파싱하기 위한 JSONParser 객체 생성.
        JSONParser parser	= new JSONParser(); 
     // 2. 문자열을 JSON 형태로 JSONObject 객체에 저장. 
		 JSONObject obj 		= (JSONObject)parser.parse(sb.toString());
		 
		 JSONObject body 	= (JSONObject)obj.get("getTblFnrstrnStusInfo");
		 JSONObject items 	= (JSONObject)body.get("header");
		 // 3. 필요한 리스트 데이터 부분만 가져와 JSONArray로 저장.
		 JSONArray  item 	= (JSONArray) body.get("item");
		 System.out.println("JSON(obj) : " + obj);
		 System.out.println("JSON(body) : " + body);
		 System.out.println("JSON(items) : " + items);
		 System.out.println("JSON(item[]) : " + item);
		 
		 
		 for(int i=2;i<item.size();i++) {
			 Insert_food food=new Insert_food();
			 JSONObject BusanData=(JSONObject) item.get(i);
			 

			 String bsnsCond =(String)BusanData.get("bsnsCond").toString();  //업태
			 if(bsnsCond.equals("경양식")) {
                 bsnsCond="일식";
             }else if(bsnsCond.equals("회집")) {
                 bsnsCond="일식";
             }else if(bsnsCond.equals("탕류(보신용)")) {
                 bsnsCond="한식";
             }else if(bsnsCond.equals("식육(숯불구이)")) {
                 bsnsCond="한식";
             }else if(bsnsCond.equals("중국식")) {
                 bsnsCond="중식";
             }
			 String bsnsNm =(String)BusanData.get("bsnsNm").toString();  //업소명
			 String menu =(String)BusanData.get("menu").toString();  //메뉴	
			 String addrRoad =(String)BusanData.get("addrRoad").toString();  // 도로명
			 String tel =(String)BusanData.get("tel").toString();  //전화번호	
			 String lat =(String)BusanData.get("lat").toString();  //위도
			 String lng =(String)BusanData.get("lng").toString();  //경도		 
				
			 vo.setBsnscond(bsnsCond);
			 vo.setBsnsnm(bsnsNm);
			 vo.setMenu(menu);
			 vo.setAddr(addrRoad);
			 vo.setTel(tel);
			 vo.setLat(lat);
			 vo.setLng(lng);
			 
			 food.save(vo);
			 			 
			 System.out.println("업태: "+bsnsCond+ "업소명: "+ bsnsNm+ "메뉴 :"+ menu+ "도로명:" + addrRoad+"전화번호:"+tel+"위도:"+lat+"경도:"+lng);
			 
		 }

       } catch(Exception e) {
    	   e.printStackTrace();
       }
    }
}