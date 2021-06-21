package ts3antivpn._482_projects.com;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class functions {
    public static IpState CheckIP(String ipaddress, String emailaddress) throws IOException {
        String url = "http://check.getipintel.net/check.php?ip=" + ipaddress + "&contact=" + emailaddress + "&format=json";
        return CheckInner(url, "result", 0.9, 0.51);
    }

    public static IpState CheckIPHub(String ipaddress, String Apikey) throws IOException {
        String url = "http://v2.api.iphub.info/ip/" + ipaddress;
        return CheckInner(url, "block", 1.0, 0.0, "X-Key", Apikey);
    }

    private static IpState CheckInner(String webAddress, String key, double vpnValue, double userValue,
        String...requestProperty) throws MalformedURLException, IOException {
        URLConnection connection = new URL(webAddress).openConnection();
        for (int i = 0; i < requestProperty.length; i += 2) {
            connection.setRequestProperty(requestProperty[i], requestProperty[i + 1]);
        }
        try (Scanner scanner = new Scanner(connection.getInputStream());) {

            JSONObject obj = new JSONObject(scanner.useDelimiter("\\A").next());

            if (obj.getDouble(key) >= vpnValue) {
                return IpState.VPN;
            }
            if (obj.getDouble(key) <= userValue) {
                return IpState.User;
            } else {
                return IpState.Api;
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        return IpState.None;
    }
}
