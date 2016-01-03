package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
	
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        // 5.12
        Hex hex = new Hex();
        byte[] bytearray1 = (byte[]) hex.decode("4d6f64756c652032");
        System.out.println(new String(bytearray1));
        
        // 5.13.1
        System.out.println(Base64.encodeBase64String(input.getBytes()));
        // 5.13.2
        byte[] bytearray2 = (byte[]) hex.decode("010203040506");
        System.out.println(Base64.encodeBase64String(bytearray2));
        // 5.13.3
        System.out.println(new String(Base64.decodeBase64("U29mdHdhcmUgU3lzdGVtcw==")));
        // 5.13.4
        String str = "a";
        for(int i = 1; i <= 10; i++) {
        	System.out.println(Base64.encodeBase64String(str.getBytes()));
        	str += "a";
        }
    }
}
