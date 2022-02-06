package no.hvl.dat110.rpc;

import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		connection = msgclient.connect();
	}
	
	public void disconnect() {
		
		connection.close();
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] returnval;
		
		byte[] rpcrequest = RPCUtils.encapsulate(rpcid, params);
		
		Message message = new Message(rpcrequest);	
		
		
		connection.send(message);
		
		Message replymessage = connection.receive();
		
		byte[] rpcreply = replymessage.getData();
		
		returnval = RPCUtils.decapsulate(rpcreply);
		
		return returnval;
		
	}

}
