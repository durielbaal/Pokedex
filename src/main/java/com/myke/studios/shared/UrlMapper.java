package com.myke.studios.shared;

import java.util.Map;

public class UrlMapper {
  public static String convertUrl(Map<String,String> attributes,String url){
    for (Map.Entry<String, String> entry: attributes.entrySet()){
      url = url.replace(entry.getKey(), entry.getValue());
    }
    return url;
  }
}
