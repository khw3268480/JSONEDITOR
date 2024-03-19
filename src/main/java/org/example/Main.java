package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        final int start = 42;
        final int repeat = 124;
        JSONParser parser = new JSONParser();

        File file = new File("C:\\Users\\khw32\\OneDrive\\Bureau\\Json\\41.json");
        for (int i = start; i <= start + repeat; i++) {

//            FileUtils.copyFile(file, new File("C:\\Users\\khw32\\OneDrive\\Bureau\\Json\\" + i + ".json"));

            try (Reader reader = new FileReader("C:\\Users\\khw32\\OneDrive\\Bureau\\Json\\" + i + ".json")) {

//                JSONObject jsonObject = (JSONObject) parser.parse(reader);
                ArrayList<String> arrayList = new ArrayList<>();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("level", i);
                jsonObject.put("rewardGroup", i);
                jsonObject.put("amount", 1);
                jsonObject.put("rewardCommand", "");
                jsonObject.put("typeName", "");
                jsonObject.put("objectName", "");
                jsonObject.put("description", arrayList);
                FileWriter fileWriter = new FileWriter("C:\\Users\\khw32\\OneDrive\\Bureau\\Json\\" + i + ".json");
                ObjectMapper objectMapper = new ObjectMapper();
                Object prettyJsonObject = objectMapper.readValue(jsonObject.toJSONString(), Object.class);
                String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
                fileWriter.write(prettyJson);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //{
        //    "amount": 1,
        //    "rewardCommand": "",
        //    "level": 3,
        //    "typeName": "획득",
        //    "objectName": "3",
        //    "description": ["腊 &a기본템 획득하기 &7&o(/기본템)"],
        //    "rewardGroup": 3
        //}
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("amount", 1);
//        jsonObject.put("rewardCommand", "");
//        jsonObject.put("level", 1);
//        jsonObject.put("typeName", "");
//        jsonObject.put("objectName", "");
////        jsonObject.put("amount", 1);
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add("asd");
//        jsonObject.put(jsonArray);
    }

}