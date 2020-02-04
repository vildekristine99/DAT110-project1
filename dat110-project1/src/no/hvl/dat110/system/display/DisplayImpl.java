package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] request) {
		
		byte rpcid = request[0];
		String str = RPCUtils.unmarshallString(request);
		write(str);
		byte[] reply = RPCUtils.marshallString(rpcid, str);
		// TODO: 
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done int he SensorImpl for the read method
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
		
		return reply;
	}
}
