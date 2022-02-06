package no.hvl.dat110.system.display;

import no.hvl.dat110.rpc.RPCRemoteImpl;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.rpc.RPCServer;

public class DisplayImpl extends RPCRemoteImpl {

	public DisplayImpl(byte rpcid, RPCServer rpcserver) {
		super(rpcid,rpcserver);
	}
	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] params) {
		
		byte[] reply = null;
		
        RPCUtils.unmarshallVoid(params); 
		
		String write = RPCUtils.unmarshallString(params);
		
		write(write);
				
		reply = RPCUtils.marshallString(write); 
		
		return reply;
	}
}
