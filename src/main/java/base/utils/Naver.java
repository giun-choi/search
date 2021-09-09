package base.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.constant.Constant;

public class Naver {

	private static final Logger logger = LoggerFactory.getLogger(Naver.class);
	
	public String getSearchInfo(String url, HashMap<String, String> params) {
		
        String clientId = Constant.CLIENT_ID; //애플리케이션 클라이언트 아이디값"
        String clientSecret = Constant.CLIENT_SECRET; //애플리케이션 클라이언트 시크릿값"
        
        HashMap<String, String> params_UTF_8 = getEncodingUTF_8(params, "UTF-8"); //value값들을 UTF-8로 인코딩

        String query_string = getQueryString(params_UTF_8); //UTF-8로 인코딩한 HashMap 데이터들을 쿼리스트링으로 변환

        logger.info("URL : " + url);
        logger.info("Query String : " + query_string + "\n");
        String apiURL = url + query_string;
        
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL, requestHeaders);
        
        logger.info(responseBody);
        return responseBody;
    }

    private String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }	
    
    /**
     * value값 UTF-8로 인코딩
     * @param params
     * @param type
     * @return
     */
    private HashMap<String, String> getEncodingUTF_8(HashMap<String, String> params, String encoding_type) {
    	
    	try {
        	for(String key : params.keySet()) {
        		params.put(key, URLEncoder.encode(params.get(key), encoding_type));
        	}
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
    	
    	return params;
    }
    
    /**
     * HashMap의 데이터를 쿼리스트링으로 변환
     * @param params_UTF_8
     * @return
     */
    private String getQueryString(HashMap<String, String> params_UTF_8) {

        String query_string = "?";
        boolean flag = true;
        
        for(String key : params_UTF_8.keySet()) {
        	
        	if(flag) {
        		query_string += ( key + "=" + params_UTF_8.get(key) );
        		flag = false;
        	} else {
        		query_string += ( "&" + key + "=" + params_UTF_8.get(key) );
        	}
        }    	
        
    	return query_string;
    }
    
    
	
}
