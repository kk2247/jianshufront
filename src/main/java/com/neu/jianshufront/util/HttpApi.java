package com.neu.jianshufront.util;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpApi {
    String uri = "http://10.25.44.204:5000/item/46";

    /**
     * Get方法
     */
    public void test1() throws IOException {

            URL url = new URL(uri);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            //设置请求参数（过期时间，输入、输出流、访问方式），以流的形式进行连接
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);//设置缓存
            connection.setConnectTimeout(20000);//设置超时时间 毫秒
            connection.setInstanceFollowRedirects(true);//设否执行http重定向

            //建立连接
            connection.connect();
            String msg="";
            int code =connection.getResponseCode();
            System.out.println(code);
            if(code==200) {
                BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line=null;
                while(((line=br.readLine())!=null)) {
                    msg+=line+"\n";
                }
                br.close();
            }
            //关闭链接
            connection.disconnect();
            //输出结果
            System.out.println(msg);

    }

    /**
     * Post方法发送form表单
     */
    public void test2() {
        try {
            URL url = new URL(uri + "/test1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("code=001&name=测试");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Post方法发送json数据
     */
    public void test3() {
        try {
            URL url = new URL(uri + "/test2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("code", "001");
            data.put("name", "测试");
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write(objectMapper.writeValueAsString(data));
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}