package task;
import java.util.HashMap;
public class WebAddressParser {
    private String url;
    private String scheme;
    private String login;
    private String password;
    private String host;
    private String port;
    private String fragment;
    private final HashMap<String, String> parameters = new HashMap<>();
    public WebAddressParser(String url) {
        parseUrl(url);
    }
    public boolean isValid() {
        return !(scheme == null && host == null && url == null);
    }
    public String getLogin() {
        if (!isValid() || login == null) {
            return "";
        }
        return login;
    }
    public String getPassword() {
        if (!isValid() || password == null) {
            return "";
        }
        return password;
    }
    public String getScheme() {
        if (!isValid()) {
            return "";
        }
        return scheme;
    }
    public String getHost() {
        if (!isValid()) {
            return "";
        }
        return host;
    }
    public String getPort() {
        if (!isValid() || port == null) {
            return "";
        }
        return port;
    }
    public String getUrl() {
        if (!isValid()) {
            return "";
        }
        return url;
    }
    public String getFragment() {
        if(!isValid() || fragment == null) {
            return "";
        }
        return fragment;
    }
    public HashMap<String, String> getParameters() {
        return parameters;
    }
    private void parseUrl(String inURL) {
        if (inURL.contains("://") && inURL.contains(".")) {
            String[] splitURL = inURL.split("://");
            scheme = splitURL[0];
            inURL = splitURL[1];
            if (inURL.contains("@")) {
                splitURL = inURL.split("@");
                password = splitURL[0];
                inURL = splitURL[1];
            }
            if (password != null) {
                splitURL = password.split(":");
                login = splitURL[0];
                password = splitURL[1];
            }
            if (inURL.contains("/")) {
                splitURL = inURL.split("/", 2);
                host = splitURL[0];
                inURL = splitURL[1];
            }
            if (host.contains(":")) {
                splitURL = host.split(":");
                port = splitURL[1];
                host = splitURL[0];
            }
            if (inURL.contains("#")) {
                splitURL = inURL.split("#");
                fragment = splitURL[1];
                inURL = splitURL[0];
            }
            url = inURL;
            if (inURL.contains("?")) {
                splitURL = inURL.split("\\?");
                url = splitURL[0];
                inURL = splitURL[1];
            }
            if (inURL.contains("=")) {
                splitURL = inURL.split("&");
                for (String s : splitURL) {
                    String[] params = s.split("=");
                    parameters.put(params[0], params[1]);
                }
            }
        }
    }
}