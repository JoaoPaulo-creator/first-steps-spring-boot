package com.example.demo.utils;

import java.util.HashMap;

public class ResponseMessageSerializer {

  public static HashMap<String, String> serialize(String message) {
    var r = new HashMap<String, String>();
    r.put("message", message);
    return r;
  }
}
