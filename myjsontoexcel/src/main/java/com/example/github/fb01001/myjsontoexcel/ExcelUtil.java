package com.example.github.fb01001.myjsontoexcel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @author fangbin
 * @date 19-7-13
 */

public class ExcelUtil {
  public static void main(String[] args) {
    //File file = new File("/home/fangbin/Desktop/JsonToExcel/response20190712-1");
      BufferedReader reader01 = null;
      BufferedReader reader02 = null;
      BufferedReader reader03 = null;
      try {
          reader01 = new BufferedReader(new InputStreamReader(new FileInputStream("/home/fangbin/Desktop/JsonToExcel/response20190712-1")));
          reader02 = new BufferedReader(new InputStreamReader(new FileInputStream("/home/fangbin/Desktop/JsonToExcel/response20190712-2")));
          reader03 = new BufferedReader(new InputStreamReader(new FileInputStream("/home/fangbin/Desktop/JsonToExcel/response20190712-3")));
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      try{
          String str01 = reader01.readLine();
          String str02 = reader02.readLine();
          String str03 = reader03.readLine();
          JSONObject jsonObject01= JSONObject.parseObject(str01);
          JSONObject jsonObject02= JSONObject.parseObject(str02);
          JSONObject jsonObject03= JSONObject.parseObject(str03);
          JSONArray jSONArray01 = jsonObject01.getJSONArray("data");
          JSONArray jSONArray02 = jsonObject02.getJSONArray("data");
          JSONArray jSONArray03 = jsonObject03.getJSONArray("data");
          int lineNum = 0;
          for(int i = 0; i < jSONArray01.size(); i++){
              String dataObj = jSONArray01.get(i).toString();
              JSONObject dataObject= JSONObject.parseObject(dataObj);
              if("Not an Issue".equals(dataObject.getString("primaryTag"))){
                  lineNum += 1;
                  System.out.println(lineNum + "---" + dataObject.getString("issueInstanceId") + "---" + dataObject.getString("primaryTag"));
              }

          }
          for(int i = 0; i < jSONArray02.size(); i++){
              String dataObj = jSONArray02.get(i).toString();
              JSONObject dataObject= JSONObject.parseObject(dataObj);
              if("Not an Issue".equals(dataObject.getString("primaryTag"))){
                  lineNum += 1;
                  System.out.println(lineNum + "---" + dataObject.getString("issueInstanceId") + "---" + dataObject.getString("primaryTag"));
              }
          }
          for(int i = 0; i < jSONArray03.size(); i++){
              String dataObj = jSONArray03.get(i).toString();
              JSONObject dataObject= JSONObject.parseObject(dataObj);
              if("Not an Issue".equals(dataObject.getString("primaryTag"))){
                  lineNum += 1;
                  System.out.println(lineNum + "---" + dataObject.getString("issueInstanceId") + "---" + dataObject.getString("primaryTag"));
              }
          }
          /*Set<String> keys = jsonObject.keySet();
          Iterator it = keys.iterator();
          while (it.hasNext()){
              System.out.println(it.next());
          }*/
          /*Object data = jsonObject.get("data");
          JSONObject jsonDataObject= JSONObject.parseObject(String.valueOf(data));
          jsonDataObject.get*/
      } catch (Exception e) {
          e.printStackTrace();
      }

      // 新建文件

      //File excelFile = new File("/home/fangbin/Desktop/JsonToExcel/1.xml");
      //excelFile.createNewFile();

      // excel 信息
      //OutputStream outputStream = new FileOutputStream(excelFile.);// 创建工作薄

      //WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);

      //WritableSheet sheet = writableWorkbook.createSheet("First sheet", 0);// 创建新的一页




  }
}
