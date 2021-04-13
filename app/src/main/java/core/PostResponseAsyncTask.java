package core;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.human.edu.LoginActivity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 *  이 클래스는 AsyncTask클래스를 상속받아 비동깃 통신 기능 구현
 */
public class PostResponseAsyncTask extends AsyncTask {

    private Context context;
    private HashMap<String, String> postDataParams = new HashMap<String, String>();
    private AsyncResponse asyncResponse;
    private ProgressDialog progressDialog;
    private String loadingMessage = "처리중";
    private boolean showLoadingMessage = true;

    public PostResponseAsyncTask(LoginActivity loginActivity, HashMap postDataParams, AsyncResponse asyncResponse) {
        this.context = context;
        this.postDataParams = postDataParams;
        this.asyncResponse = asyncResponse;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public HashMap<String, String> getPostDataParams() {
        return postDataParams;
    }

    public void setPostDataParams(HashMap<String, String> postDataParams) {
        this.postDataParams = postDataParams;
    }

    public AsyncResponse getAsyncResponse() {
        return asyncResponse;
    }

    public void setAsyncResponse(AsyncResponse asyncResponse) {
        this.asyncResponse = asyncResponse;
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    public String getLoadingMessage() {
        return loadingMessage;
    }

    public void setLoadingMessage(String loadingMessage) {
        this.loadingMessage = loadingMessage;
    }

    public boolean isShowLoadingMessage() {
        return showLoadingMessage;
    }

    public void setShowLoadingMessage(boolean showLoadingMessage) {
        this.showLoadingMessage = showLoadingMessage;
    }

    @Override
    protected Object doInBackground(Object[] requestUrls) {
        //비동기 통신에서 요청사항을 스프링앱에서 응답받는 기능
        String result = "";
        result = invokePost(requestUrls[0], postDataParams);
        return result;
    }

    private String invokePost(Object requestUrl, HashMap<String, String> postDataParams) {
        URL url;
        String response = "";
        try {
            url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
