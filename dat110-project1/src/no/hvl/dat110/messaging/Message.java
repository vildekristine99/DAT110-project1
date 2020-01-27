package no.hvl.dat110.messaging;
import static no.hvl.dat110.messaging.MessageConfig.*;


public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if(payload.length > SEGMENTSIZE-1) {
			//str på payload er utenfor det vi kan håndtere
			this.payload = null;
		}
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[SEGMENTSIZE];
		
		encoded[0] = (byte) payload.length;
		for(int i = 0; i < payload.length; i++) {
			encoded[i+1] = payload[i];
		}
		
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
//		
//		if (true)
//		   throw new UnsupportedOperationException(TODO.method());

		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		int str = received[0];
		byte[] payload = new byte[str];
		for(int i = 0; i < str; i++) {
			payload[i] = received[i+1];
		}
		
		this.payload = payload;
		
//		throw new UnsupportedOperationException(TODO.method());
//		
	}
}
