package com.myshop.dao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Naver_Sens_V2 {
	@SuppressWarnings("unchecked")
	public void send_msg(String pnumber, String rand) {
        String hostNameUrl = "https://sens.apigw.ntruss.com";     		// ȣ��Ʈ URL
        String requestUrl= "/sms/v2/services/";                   		// ��û URL
        String requestUrlType = "/messages";                      		// ��û URL
        String accessKey = "nQ2TEzMRZMyxbICFYgTg";                     						// ���� ����Ű
        String secretKey = "3DKnGsDmGGkNdNBLpd2yjmqEFoaYv6lk23Z9FfSb";  										// 2�� ������ ���� ���񽺸��� �Ҵ�Ǵ� service secret
        String serviceId = "ncp:sms:kr:293451852456:shop";        									// ������Ʈ�� �Ҵ�� SMS ���� ID
        String method = "POST";											// ��û method
        String timestamp = Long.toString(System.currentTimeMillis()); 	// current timestamp (epoch)
        requestUrl += serviceId + requestUrlType;
        String apiUrl = hostNameUrl + requestUrl;

        // JSON �� Ȱ���� body data ����

        JSONObject bodyJson = new JSONObject();
        JSONObject toJson = new JSONObject();
	    JSONArray  toArr = new JSONArray();

	    toJson.put("content","Going �������� ["+rand+"]");		// ������ �Բ� ����
	    toJson.put("to",pnumber);
	    toArr.add(toJson);
	    
	    bodyJson.put("type","sms");	// �޽��� Type (sms | lms)
	    bodyJson.put("contentType","COMM");
	    bodyJson.put("countryCode","82");
	    bodyJson.put("from","01050151256");	// �߽Ź�ȣ * ������ ����/��ϵ� ��ȣ�� ����� �� �ֽ��ϴ�.		
	    bodyJson.put("content","Going �������� ["+rand+"]");		// ������ �Բ� ����
	    bodyJson.put("messages", toArr);			
	    

	    String body = bodyJson.toJSONString();
	    
	    System.out.println(body);
	    
        try {

            URL url = new URL(apiUrl);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("content-type", "application/json");
            con.setRequestProperty("x-ncp-apigw-timestamp", timestamp);
            con.setRequestProperty("x-ncp-iam-access-key", accessKey);
            con.setRequestProperty("x-ncp-apigw-signature-v2", makeSignature(requestUrl, timestamp, method, accessKey, secretKey));
            con.setRequestMethod(method);
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            
            wr.write(body.getBytes("UTF-8"));
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            System.out.println("responseCode" +" " + responseCode);
            System.out.println(url);
            if(responseCode==202) { // ���� ȣ��
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // ���� �߻�
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	public static String makeSignature(String url, String timestamp, String method, String accessKey, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
	    String space = " "; 
	    String newLine = "\n"; 
	    

	    String message = new StringBuilder()
	        .append(method)
	        .append(space)
	        .append(url)
	        .append(newLine)
	        .append(timestamp)
	        .append(newLine)
	        .append(accessKey)
	        .toString();

	    SecretKeySpec signingKey;
	    String encodeBase64String;
		try {
			signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
		    encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
		} catch (UnsupportedEncodingException e) {
			encodeBase64String = e.toString();
		}
	    

	  return encodeBase64String;
	}
}

