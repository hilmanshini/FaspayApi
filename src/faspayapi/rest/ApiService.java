/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.rest;

import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import org.json.JSONObject;

/**
 *
 * @author hilmananwarsah
 */
public interface ApiService {
    public void sendRequestHttpPlain(String url,Map<String,String> params,Map<String,String> headers,ApiServiceCallbackPlain mCallbackPost);
    public void sendRequestHttpPlain(String url,Map<String,String> params,ApiServiceCallbackPlain    mCallbackPost);
    public void sendRequestHttpPlain(String url,JSONObject params,Map<String,String> headers,ApiServiceCallbackPlain mCallbackPost);
    public void sendRequestHttpPlain(String url,JSONObject params,ApiServiceCallbackPlain    mCallbackPost);
    public void sendRequestHttpPost(String url,JSONObject params,Map<String,String> headers,ApiServiceCallbackPost mCallbackPost);
    public void sendRequestHttpPost(String url,JSONObject params,ApiServiceCallbackPost mCallbackPost);
    public interface ApiServiceCallbackPost{

        public void onFailure(Call call, IOException ioe);
        public void onResponse(JSONObject t);
        
        
    }
    public interface ApiServiceCallbackPlain{

        public void onFailure(Call call, IOException ioe);
        public void onResponse(String t);
        
        
    }
}
