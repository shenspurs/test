

import java.util.Collection;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.RosterPacket;
import org.jivesoftware.smack.packet.RosterPacket.Item;


public class testjive {

	
	
	private static final String SERVERNAME = "browser-server";

	public static void main(String args[]) 
	{
		
		test();
	}

	private static void test() {
		// TODO Auto-generated method stub
		
		ConnectionConfiguration config = new ConnectionConfiguration("10.3.34.132",
				5222, "browser-server");
		config.setDebuggerEnabled(true);
		config.setSASLAuthenticationEnabled(false);
//		config.setDeviceLogin(false);
		// System.setProperty("smack.debuggerClass", "")

		XMPPConnection m_connection = new XMPPConnection(config);
		try {
			m_connection.connect();
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		    try {
				m_connection.login("18908168757", "111111", "1");
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Roster roster = m_connection.getRoster();
			
			
			if (roster == null)
				return;

			Presence p = new Presence(Presence.Type.unsubscribe);
			p.setTo("13612341234" + "@" + SERVERNAME);
			p.setFrom("18708168757" + "@" + SERVERNAME);
			m_connection.sendPacket(p);

			RosterPacket r = new RosterPacket();
			r.setType(IQ.Type.SET);
			Item ri = new Item("13612341234", null);
			ri.setItemType(RosterPacket.ItemType.remove);
			r.addRosterItem(ri);
			m_connection.sendPacket(r);
	
	}
}
