package com.huobi.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huobi.exception.SDKException;


public class ConnectionFactory {

  private static final OkHttpClient client = new OkHttpClient();

  private static final Logger log = LoggerFactory.getLogger(ConnectionFactory.class);

  public static String execute(Request request) {

    Response response = null;
    String str = null;
    try {
      log.info("[Request URL]{}",request.url());
      response = client.newCall(request).execute();
      if (response.code() != 200) {
        throw new SDKException(SDKException.EXEC_ERROR, "[Execute] Response Status Error : " + response.code() + " message:" + response.message());
      }
      if (response != null && response.body() != null) {
        str = response.body().string();
        response.close();
      } else {
        throw new SDKException(SDKException.ENV_ERROR, "[Execute] Cannot get the response from server");
      }
      log.info("[Response]{}", str);
      return str;
    } catch (IOException e) {
      e.printStackTrace();
      throw new SDKException(SDKException.RUNTIME_ERROR, "[Execute] Cannot get the response from server");
    }

  }

  public static WebSocket createWebSocket(Request request, WebSocketListener listener) {
    return client.newWebSocket(request, listener);
  }

}
