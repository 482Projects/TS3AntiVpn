package ts3antivpn._482_projects.com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.PrivilegeKeyUsedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

/**
 * @author Formeinchen published by 482 Projects
 * 
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

    	
    	
    	JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("config.json"));

        JSONObject jsonObject = (JSONObject) obj;

        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001b[33m";
        String ANSI_RESET = "\u001B[0m";
        
        String error = " [" + ANSI_RED + "ERROR" + ANSI_RESET + "] ";
        String success = " [" + ANSI_GREEN + "OK" + ANSI_RESET + "] ";
        String waiting = " [" + ANSI_YELLOW + "WAITING" + ANSI_RESET + "] ";
        String host = jsonObject.get("host").toString();
        String queryusername = jsonObject.get("queryusername").toString();
        String querypassword = jsonObject.get("querypassword").toString();
        String portint = jsonObject.get("port").toString();

        int port = Integer.parseInt(portint);
        String querynickname = jsonObject.get("querynickname").toString();
        String reason = jsonObject.get("reason").toString();
        String banorkick = jsonObject.get("banorkick").toString();
        //
        String email = jsonObject.get("email").toString();
        String apikey = jsonObject.get("apikey").toString();
        String service = jsonObject.get("service").toString();
        String getipintel = "GetIpIntel";
        String getiphub = "GetIpHub";
        String Debug = jsonObject.get("debug").toString();

        try {
            Integer.parseInt(portint);
        } catch (NumberFormatException e) {
            System.out.println("Please enter an valid Port in the config.json file \n default port is 9987" + error);
            System.exit(0);
        }
        
        if (host.isBlank()) {
            System.out.println("Please enter an Host in the config.json file" + error);
            System.exit(0);
        } else {
            System.out.println("HOST" + success);
        }
        if (queryusername.isBlank()) {
            System.out.println("Please enter an Queryusername in the config.json file" + error);
            System.exit(0);
        } else {
            System.out.println("QUERYUSERNAME" + success);
        }
        if (querypassword.isBlank()) {
            System.out.println("Please enter an Querypassword in the config.json file" + error);
            System.exit(0);
        } else {
            System.out.println("QUERYPASSWORD" + success);
        }
        if (querynickname.isBlank()) {
            System.out.println("Please enter an Querynickname in the config.json file" + error);
            System.exit(0);
        } else {
            System.out.println("QUERYNICKNAME" + success);
        }
        if (reason.isBlank()) {
            System.out.println("Please enter an reason in the config.json file" + error);
            System.exit(0);
        } else {
            System.out.println("REASON" + success);
        }
        if (banorkick.isBlank()) {
            System.out.println("Please enter a value in the field banorkick config.json file" + error);
            System.exit(0);
        } else if (!(banorkick.equals("ban") || banorkick.equals("kick"))) {
            System.out.println("Please enter a valid value like ban or kick in the field banorkick config.json file" + error);
            System.exit(0);
        } else {
            System.out.println("BANORKICK" + success);
        }
        if (service.isBlank()) {
            System.out.println("Please enter an Service in the config.json file" + error);
            System.exit(0);
        } else {
            System.out.println("SERVICE" + success);
        }
        if (email.isBlank()) {
            System.out.println("Please enter an Email in the config.json file" + error);
            System.exit(0);
        } else {
            System.out.println("Email" + success);
        }
        if (service.equals(getiphub)) {
            if (apikey.isBlank()) {
                System.out.println("Please enter an ApiKey in the config.json file" + error);
                System.exit(0);
            } else if (apikey.equals("yourapikey")) {
                System.out.println("Please enter an ApiKey in the config.json file" + error);
                System.exit(0);
            } else {
                System.out.println("APIKEY OK" + success);
            }
            System.out.println("The Config was Successfully checked now Connecting" + waiting);
        }

        final TS3Config config = new TS3Config();
        config.setHost(host);
        config.setEnableCommunicationsLogging(true);

        final TS3Query query = new TS3Query(config);
        query.connect();

        final TS3Api api = query.getApi();
        api.login(queryusername, querypassword);
        api.selectVirtualServerByPort(port);
        api.setNickname(querynickname);
        System.out.println("Client has been Started and Connected to: " + host + ":" + port + " with the Queryname: " +
            querynickname + success);
        api.deleteAllBans();
        api.registerAllEvents();
        api.addTS3Listeners(new TS3Listener() {


            @Override
            public void onClientJoin(ClientJoinEvent e) {
                int clientId = e.getClientId();

                final String ip = api.getClientInfo(clientId).getIp();

                if (ip.equals("localhost") || ip.equals("127.0.0.1") || ip.equals("::1") || ip.equals("0.0.0.0")) {
                    if (Debug.equals("true")) {
                        System.out.println(api.getClientInfo(clientId).getNickname() + " Is Whitelisted with the ip " + ip);
                    } else {

                    }
                } else {
                    if (service.equals(getipintel)) {
                        try {
                            if (functions.CheckIP(ip, email) == IpState.VPN) {
                                if (Debug.equals("true")) {
                                    System.out.println("User: " + api.getClientInfo(clientId).getNickname() + " Using a VPN");
                                } else {
                                    System.out.println("User: " + api.getClientInfo(clientId).getNickname() + " Using not a VPN");
                                }
                                if (banorkick.equals("ban")) {
                                    api.addBan(ip, null, null, 0, reason);
                                } else if (banorkick.equals("kick")) {
                                    api.kickClientFromServer(reason, clientId);
                                }
                            } else {
                                return;
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } else if (service.equals(getiphub)) {

                        try {
                            if (functions.CheckIPHub(ip, apikey) == IpState.VPN) {
                                if (Debug.equals("true")) {
                                    System.out.println("User: " + api.getClientInfo(clientId).getNickname() + " Using a VPN");
                                } else {
                                    System.out.println("User: " + api.getClientInfo(clientId).getNickname() + " Using not a VPN");
                                }
                                if (banorkick.equals("ban")) {
                                    api.addBan(ip, null, null, 0, reason);
                                } else if (banorkick.equals("kick")) {
                                    api.kickClientFromServer(reason, clientId);
                                }
                            } else {
                                return;
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    } else {
                        System.out.println(
                            "Query could not be executed because you specified a wrong service please enter 'GetIpHub' or 'GetIpIntel'" +
                            error);
                        System.exit(0);
                    }
                }

            }

            @Override
            public void onClientLeave(ClientLeaveEvent e) {}

            @Override
            public void onServerEdit(ServerEditedEvent e) {}

            @Override
            public void onChannelEdit(ChannelEditedEvent e) {}

            @Override
            public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent e) {}

            @Override
            public void onClientMoved(ClientMovedEvent e) {}

            @Override
            public void onChannelCreate(ChannelCreateEvent e) {}

            @Override
            public void onChannelDeleted(ChannelDeletedEvent e) {}

            @Override
            public void onChannelMoved(ChannelMovedEvent e) {}

            @Override
            public void onChannelPasswordChanged(ChannelPasswordChangedEvent e) {}

            @Override
            public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent e) {}

            @Override
            public void onTextMessage(TextMessageEvent e) {}

        });

    }
}
