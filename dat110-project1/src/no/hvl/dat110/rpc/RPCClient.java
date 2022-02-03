package no.hvl.dat110.rpc;

import java.net.Socket;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		// TODO - START
		// connect using the underlying messaging layer connection
		
		connection = msgclient.connect();
		
		// TODO - END
	}
	
	public void disconnect() {
		
		// TODO - START
		// disconnect/close the underlying messaging connection
		
		connection.close();
		
		// TODO - END
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] returnval;
		
		byte[] rpcrequest = RPCUtils.encapsulate(rpcid, params);
		
		Message message = new Message(rpcrequest);	
		
		
		connection.send(message);
		
		Message replymessage = connection.receive();
		
		byte[] rpcreply = replymessage.getData();
		
		returnval = RPCUtils.decapsulate(rpcreply);
		
		// TODO - START 
		
		/* 
		 * 
		Make a remote call on the RPC server by sending an RPC request message
		and receive an RPC reply message
		
		params is the marshalled parameters from the client-stub
				
		The rpcid, params, and return value must be encapsulated/decapsulated
		according to the RPC message format
			
		*/
		
		// TODO - END
		return returnval;
		
	}

}
