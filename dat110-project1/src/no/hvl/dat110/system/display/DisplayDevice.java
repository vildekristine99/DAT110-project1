package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		DisplayImpl display = new DisplayImpl();
		RPCServer displayserver = new RPCServer(Common.DISPLAYPORT);
		displayserver.register(1, display);
		displayserver.run();
		displayserver.stop();
		// TODO
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
		
		System.out.println("Display server stopping ...");
		
	}
}
