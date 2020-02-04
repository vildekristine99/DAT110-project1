package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCServerStopStub;

public class Controller  {
	
	private static int N = 5;
	
	public static void main (String[] args) {
		
		Display display;
		Sensor sensor;
		
		RPCClient displayclient,sensorclient;
		
		System.out.println("Controller starting ...");
				
		RPCServerStopStub stopdisplay = new RPCServerStopStub();
		RPCServerStopStub stopsensor = new RPCServerStopStub();
		
		displayclient = new RPCClient(Common.DISPLAYHOST,Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST,Common.SENSORPORT);
		
		// TODO
		// connect to sensor and display RPC servers
		// create local display and sensor objects
		// register display and sensor objects in the RPC layer
		display = new Display();
		sensor = new Sensor();
		
		displayclient.register(display);
		sensorclient.register(sensor);
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
		
		// register stop methods in the RPC layer
		displayclient.register(stopdisplay);
		sensorclient.register(stopsensor);
		
		// TODO:
		// loop while reading from sensor and write to display via RPC
		String temp;
		for (int i = 0; i < N; i++) {
			temp = new Integer(sensor.read()).toString();
			display.write(Integer.toString(sensor.read()));
			try {
				Thread.sleep(750);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//			}
		
		stopdisplay.stop();
		stopsensor.stop();
	
		displayclient.disconnect();
		sensorclient.disconnect();
		
		System.out.println("Controller stopping ...");
		
	}
}
