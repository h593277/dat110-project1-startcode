package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {
		
	private byte RPCIDDISPLAY = 2;
	
	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		
		// TODO - START
		
		// implement marshalling, call and unmarshalling for write RPC method
		
		byte[] encoded = RPCUtils.marshallString(message);
		
		String display = RPCUtils.unmarshallString(rpcclient.call(RPCIDDISPLAY, encoded));
		
		System.out.println(display);
		
		// TODO - END
		
	}
}
