/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.entity.FaspayPaymentChannelResponse;
import faspayapi.debit.entity.err.UnregisteredError;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Timeout;
import org.json.JSONObject;
import sun.rmi.runtime.Log;

/**
 *
 * @author hilmananwarsah
 */
public abstract class ApiServiceImpl<T> implements ApiService {

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient mClient;
    private FaspayConfigDebit mFaspayConfig;

    public ApiServiceImpl(FaspayConfigDebit mFaspayConfig) {
        mClient = new OkHttpClient.Builder().build();
        this.mFaspayConfig = mFaspayConfig;

    }

    public FaspayConfigDebit getFaspayConfig() {
        return mFaspayConfig;
    }
    private static final Logger LOG = Logger.getLogger(ApiServiceImpl.class.getName());

    @Override
    public void sendRequestHttpPost(String url, JSONObject params, Map<String, String> headers, ApiServiceCallbackPost mCallbackPost) {
        LOG.info(String.format("-> url %s ", url));
        LOG.info(String.format("-> params %s", params.toString()));
        RequestBody body = RequestBody.create(JSON, params.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException ioe) {
                LOG.info(String.format("<- err %s ", ioe.getMessage()));
                mCallbackPost.onFailure(call, ioe);

            }

            @Override
            public void onResponse(Call call, Response rspns) throws IOException {
                ResponseBody body = rspns.body();
                String src = body.string();
                body.close();
                LOG.info(String.format("<- response %s ", src));
                if (rspns.code() == 200) {
                    JSONObject mJSONObject = new JSONObject(src);
                    if(handleUnregistered(mJSONObject, getHandler(),mCallbackPost,call)){
                        return;
                    }
                    mCallbackPost.onResponse(mJSONObject);
                } else {
                    mCallbackPost.onFailure(new SrcCall(call, src), new IOException("invalid status code"));
                }
                call.cancel();

            }
        });

    }

    @Override
    public void sendRequestHttpPost(String url, JSONObject params, ApiServiceCallbackPost mCallbackPost) {
        sendRequestHttpPost(url, params, new HashMap<String, String>(), mCallbackPost);
    }

    protected T toEntity(String src, Class<T> x) {
        try {
            return new ObjectMapper().readValue(src, x);
        } catch (IOException ex) {
            Logger.getLogger(ApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected boolean handleUnregistered(JSONObject t, UnregisteredErrorCallback mCallback,ApiServiceCallbackPost mCallbackPost,Call mCall) {
        if (t.has("response_error")) {
            JSONObject er = t.getJSONObject("response_error");
            if (er.getString("response_code").equals("40")) {
                try {
                    UnregisteredError response = new ObjectMapper().readValue(t.toString(), UnregisteredError.class);
                    mCallback.onUserNotRegistered(response);
                    System.out.println("HANDLE UNREGISTER");
                    return true;
                } catch (IOException ex) {
                    Logger.getLogger(ApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    mCallbackPost.onFailure(mCall, ex);
                }
                
            }
        }
        return false;
    }
    public  abstract UnregisteredErrorCallback getHandler();
    public void sendRequestHttpPlain(String url,JSONObject params,Map<String,String> headers,ApiServiceCallbackPlain mCallbackPost){
        LOG.info(String.format("-> url %s ", url));
        LOG.info(String.format("-> params %s", params.toString()));
        RequestBody body = RequestBody.create(JSON, params.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException ioe) {
                LOG.info(String.format("<- err %s ", ioe.getMessage()));
                mCallbackPost.onFailure(call, ioe);

            }

            @Override
            public void onResponse(Call call, Response rspns) throws IOException {
                ResponseBody body = rspns.body();
                String src = body.string();
                body.close();
                LOG.info(String.format("<- response %s ", src));
                if (rspns.code() == 200) {
                    mCallbackPost.onResponse(src);
                } else {
                    mCallbackPost.onFailure(new SrcCall(call, src), new IOException("invalid status code"));
                }
                call.cancel();

            }
        });
    }
    public void sendRequestHttpPlain(String url,JSONObject params,ApiServiceCallbackPlain mCallbackPost){
        sendRequestHttpPlain(url, params, new HashMap<String, String>(), mCallbackPost);
    }
    public class SrcCall implements Call{
        Call del;
        public String src;

        public SrcCall(Call del, String src) {
            this.del = del;
            this.src = src;
        }

        @Override
        public Request request() {
            return del.request();
        }

        @Override
        public Response execute() throws IOException {
            return del.execute();
        }

        @Override
        public void enqueue(Callback clbck) {
            del.enqueue(clbck);
        }

        @Override
        public void cancel() {
            del.cancel();
        }

        @Override
        public boolean isExecuted() {
            return del.isExecuted();
        }

        @Override
        public boolean isCanceled() {
            return del.isCanceled();
        }

        @Override
        public Timeout timeout() {
            return del.timeout();
        }

        @Override
        public Call clone() {
            return del.clone();
        }
        
        
    }
    @Override
    public void sendRequestHttpPlain(String url, Map<String, String> params, Map<String, String> headers, ApiServiceCallbackPlain mCallbackPost) {
        LOG.info(String.format("-> url %s ", url));
        
        FormBody.Builder bo = new  FormBody.Builder(Charset.defaultCharset());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            bo.add(key  , value);
            LOG.info(String.format("-> params %s %s ",key,value));
        }
        FormBody d = bo.build();
        
        Request request = new Request.Builder()
                .url(url)
                .post(d)
                .build();

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException ioe) {
                LOG.info(String.format("<- err %s ", ioe.getMessage()));
                mCallbackPost.onFailure(call, ioe);

            }

            @Override
            public void onResponse(Call call, Response rspns) throws IOException {
                ResponseBody body = rspns.body();
                String src = body.string();
                body.close();
                LOG.info(String.format("<- response %s ", src));
                if (rspns.code() == 200) {
                    mCallbackPost.onResponse(src);
                } else {
                    mCallbackPost.onFailure(call, new IOException("invalid status code"));
                }
                call.cancel();

            }
        });
        
    }

    @Override
    public  void sendRequestHttpPlain(String url, Map<String, String> params, ApiServiceCallbackPlain mCallbackPost){
        sendRequestHttpPlain(url, params, new HashMap<String, String>(),mCallbackPost);
    }
}
