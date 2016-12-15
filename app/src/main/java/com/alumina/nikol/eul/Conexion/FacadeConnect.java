package com.alumina.nikol.eul.Conexion;

/**
 * Created by i7 on 15-12-16.
 */

import com.loopj.android.http.*;

public class FacadeConnect {

        private static final String BASE_URL = "https://eultest.herokuapp.com/";

        private static AsyncHttpClient client = new AsyncHttpClient();

        public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(getAbsoluteUrl(url), params, responseHandler);
        }

        public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(getAbsoluteUrl(url), params, responseHandler);
        }

        private static String getAbsoluteUrl(String relativeUrl) {
            return BASE_URL + relativeUrl;
        }
}
