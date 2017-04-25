/**
 * Created by paradox on 16/4/17.
 */
public class temp {/*
    XMPPTCPConnectionConfiguration connConfig = XMPPTCPConnectionConfiguration.builder().setHost(serverAddress)
            .setPort(5222).setDebuggerEnabled(true).setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
            .setUsernameAndPassword(loginUser, passwordUser).setServiceName(serverAddress).build();
        XMPPTCPConnection.setUseStreamManagementDefault(true);
        XMPPTCPConnection.setUseStreamManagementResumptionDefault(true);
    connection = new XMPPTCPConnection(connConfig);
        connection.setUseStreamManagement(true);
        connection.setUseStreamManagementResumption(true);

    XMPPConnectionListener connectionListener = new XMPPConnectionListener();
        connection.addConnectionListener(connectionListener);
        connection.setPacketReplyTimeout(10000);
        connection.addStanzaAcknowledgedListener(new StanzaListener() {
        @Override
        public void processPacket(Stanza packet) throws SmackException.NotConnectedException {
            String id = packet.getStanzaId();
            if (StringUtils.isNullOrEmpty(id)) {
                return;
            }
            stanzaAcknowledged(id);
        }
    });

    ReconnectionManager reconnectionManager = ReconnectionManager.getInstanceFor(connection);
        reconnectionManager.setEnabledPerDefault(true);
        reconnectionManager.enableAutomaticReconnection();*/
}
