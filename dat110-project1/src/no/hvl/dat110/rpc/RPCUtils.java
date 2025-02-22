package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import no.hvl.dat110.messaging.MessageUtils;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		rpcmsg = new byte[payload.length+1];
		
		rpcmsg[0] = rpcid;
		
		for(int i = 0; i < payload.length; i++)
		{
			rpcmsg[i+1] = payload[i];
		}
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload;
	
		payload = new byte[rpcmsg.length-1];
		for(int i = 0; i < payload.length; i++)
		{
			payload[i] = rpcmsg[i+1];
		}
		
		return payload;
		
	}
	
	public static byte[] marshallString(String str) {
		
		byte[] encoded;
		
		encoded = new byte[str.length()];
		
		for(int i = 0; i < str.length(); i++)	
		{
		  encoded[i] = (byte) str.charAt(i);	
		}
		
		return encoded;
	}
	
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		decoded = new String(data);
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded;
		
		encoded = new byte[0];
	
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		byte[] dataVoid = new byte[MessageUtils.SEGMENTSIZE];
		
		ByteBuffer bb = ByteBuffer.wrap(dataVoid);
		
		bb.getInt();
		
		
	}
	
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}
	
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}
	
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded;
		
		encoded = new byte[MessageUtils.SEGMENTSIZE];
		
		ByteBuffer bb = ByteBuffer.wrap(encoded);
		
		bb.putInt(x);
		
		return encoded;
	}
	
	
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		ByteBuffer bb = ByteBuffer.wrap(data);
		
		decoded = bb.getInt();
		
		return decoded;
		
	}
}
