import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class URLParameterExtractor {

    public static Map<String, String> getQueryParams(String url) throws UnsupportedEncodingException {
        Map<String, String> queryParams = new HashMap<>();
        URL urlObject = null;
        try {
            urlObject = new URL(url);
        } catch (Exception e) {
            e.printStackTrace();
            return queryParams;
        }

        String query = urlObject.getQuery();
        if (query == null || query.isEmpty()) {
            return queryParams;
        }

        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            String key = URLDecoder.decode(pair.substring(0, idx), "UTF-8");
            String value = URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
            queryParams.put(key, value);
        }
        return queryParams;
    }

    public static void main(String[] args) {
        String url = "https://merbabu.ciam.xlaxiata.co.id/realms/xl-ciam/broker/google/endpoint?code=4%2F0ATx3LY6EsAV281T-TomxAxkEh0P14P5pLDNCiFDKK4MkusZitpupV11zOcRXGIJPBViKvg&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fcontacts.readonly";
        //String url = "https://www.instagram.com/oauth/authorize?client_id=1573941103337125&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Frealms%2Ftest%2Fbroker%2Finstagram%2Fendpoint&response_type=code&scope=user_profile%2Cuser_media&logger_id=55a4f24c-129c-47a0-87fd-f5cc4e040654";
        
        try {
            System.out.println("Code: " + getQueryParams(url).get("code"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
