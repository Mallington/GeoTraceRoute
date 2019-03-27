package com.company;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.lang.reflect.Field;
import java.util.Iterator;

public class WhoIsAPI extends LookupInfo{

    public static String WHO_IS_API = "http://free.ipwhois.io/json/";

    public static String EXTREME_LOOKUP_API = "https://extreme-ip-lookup.com/json/";

    private String URL = null;
    private String IP;

    public WhoIsAPI(String IP, String apiURL){
        this.URL = apiURL;
        this.IP = IP;
        loadInformation();
    }

    private void loadInformation(){
        String json = Util.getStringFromURL(URL+ IP);

        JSONTokener tokener = new JSONTokener(json);
        try {
            JSONObject jsonObject = new JSONObject(tokener);
            putJson(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    public void putJson(JSONObject jsonObject){
        Iterator it = jsonObject.sortedKeys();

        while(it.hasNext()){
            Object next = it.next();

            try {
                putField(next.toString(), jsonObject.get(next.toString()).toString());
            } catch (JSONException | IllegalAccessException e) {
                System.out.println("Set for: "+next+" failed");
            }
        }
    }

    private void putField(String key, String  value) throws IllegalAccessException {
        key = convertKey(key);


        Field field = getField(key);
        if(field !=null){
            setField(field, value);
        }
        else{
            //System.out.println(key+" not found.");
        }
    }

    public static String convertKey(String key){
        switch(key){
            case "lat":
                return "latitude";
            case "lon":
                return "longitude";

            case "query":
                return "ip";

            case "countryCode":
                return "country_code";

            default:
                return key;
        }
    }

    private Field getField(String key){
        try {
            return getClass().getField(key);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    private void setField(Field f, String value) throws IllegalAccessException {
        try {
            if (value != null && f != null && !value.equals("null")) {

                switch (f.getType().toString()) {
                    case "class java.lang.String":
                        f.set(this, value);
                        break;

                    case "boolean":
                        f.setBoolean(this, Boolean.parseBoolean(value));
                        break;

                    case "float":
                        f.setFloat(this, Float.parseFloat(value));
                        break;

                    case "int":
                        f.setInt(this, Integer.parseInt(value));
                        break;

                }
            }
        } catch (Exception e){
            //System.out.println("Failed to parse value: "+value);
        }

    }
}
