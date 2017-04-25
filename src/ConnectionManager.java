import org.jivesoftware.smack.*;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

/**
 * Created by paradox on 16/4/17.
 */
public class ConnectionManager {

    AbstractXMPPConnection connection;

    public ConnectionManager() {
        connect();
    }

    private void connect() {

        try {

            XMPPTCPConnectionConfiguration.Builder config =
                    XMPPTCPConnectionConfiguration.builder()
                            .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
//                            .setResource("temp")
                            .setXmppDomain("undercroft")
                            .setHostAddress(InetAddress.getLocalHost())
                            .setPort(5222)
                            .setDebuggerEnabled(false);

            connection = new XMPPTCPConnection(config.build());
            /*connection = new AbstractXMPPConnection(config.build()) {
                @Override
                public boolean isSecureConnection() {
                    return false;
                }

                @Override
                protected void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {

                }

                @Override
                public void sendNonza(Nonza nonza) throws SmackException.NotConnectedException, InterruptedException {

                }

                @Override
                public boolean isUsingCompression() {
                    return false;
                }

                @Override
                protected void connectInternal() throws SmackException, IOException, XMPPException, InterruptedException {

                }

                @Override
                protected void loginInternal(String s, String s1, Resourcepart resourcepart) throws XMPPException, SmackException, IOException, InterruptedException {

                }

                @Override
                protected void shutdown() {

                }
            };*/
            connection.connect();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SmackException e) {
            e.printStackTrace();
        } catch (XMPPException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("\nConnected\n");
        }
    }

    public void login(String username, String password) {
        try {

            if (connection != null && connection.isConnected()) {
                connection.login(username, password);
            }

        } catch (XMPPException e) {
            e.printStackTrace();
        } catch (SmackException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("Login Successfully");
        }
    }

    public void printRoster() throws Exception {
        System.out.printf("\n\nPrint roster called\n");
        Roster roster = Roster.getInstanceFor(connection);
        Collection<RosterEntry> entries = roster.getEntries();
        for (RosterEntry entry : entries) {
            System.out.println(String.format("Buddy:%1$s - Status:%2$s",
                    entry.getName(), entry.getType()));
        }
        System.out.printf("\n\n");
    }

    public void chat() {

        ChatManager chatManager = ChatManager.getInstanceFor(connection);
        /*chatManager.addChatListener(new IncomingChatMessageListener() {
            @Override
            void newIncomingMessage(EntityBareJid from, Message message, Chat chat) {
                System.out.println("New message from " + from + ": " + message.getBody());
            }
        });*/

        EntityBareJid jid = null;
        try {
            jid = JidCreate.entityBareFrom("paradox@undercroft");
        } catch (XmppStringprepException e) {
            e.printStackTrace();
        }
        Chat chat = chatManager.createChat(jid);

        try {
            chat.sendMessage("Done...!");
        } catch (SmackException.NotConnectedException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*connection.addAsyncStanzaListener(new StanzaListener() {
            @Override
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                Message message = (Message) stanza;
                System.out.printf("\n\n"+message.getBody()+"\n\n");
            }
        }, new StanzaFilter() {
            @Override
            public boolean accept(Stanza stanza) {
                return false;
            }
        });*/
    }

    public void logout() {
        if (connection != null && connection.isConnected()) {
            connection.disconnect();
            System.out.printf("Disconnected");
        }
    }
}
