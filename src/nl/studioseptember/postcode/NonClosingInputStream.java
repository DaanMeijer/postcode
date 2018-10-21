package nl.studioseptember.postcode;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NonClosingInputStream extends FilterInputStream {

	protected NonClosingInputStream(InputStream in) {
		super(in);
	}
	
	@Override
	public void close() throws IOException {
		//nope
	}

}
