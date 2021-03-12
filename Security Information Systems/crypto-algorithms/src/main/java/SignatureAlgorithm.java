import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SignatureAlgorithm {
	/**
	 * Sign the API request with body.
	 */
	public static String signApiRequest(Map<String, String> params, String body, String appSecret, String signMethod, String apiName) throws IOException {
		// first: sort all text parameters
//		String[] keys = params.keySet().toArray(new String[0]);
//		Arrays.sort(keys);

		// second: connect all text parameters with key and value
		StringBuilder query = new StringBuilder();
//       query.append(apiName);
//		for (String key : keys) {
//			String value = params.get(key);
//			if (areNotEmpty(key, value)) {
//				query.append(key).append(value);
//			}
//		}

		// third：put the body to the end
		if (body != null) {
			query.append(body);
		}

		// next : sign the whole request
		byte[] bytes = null;
		
		if(signMethod.equals("hmac")) {
//			bytes = encryptWithHmac(query.toString(), appSecret);
		} else if(signMethod.equals("sha256")) {
			bytes = encryptHMACSHA256(query.toString(), appSecret);
		}

		// finally : transfer sign result from binary to upper hex string
		return byte2hex(bytes);
	}

	private static byte[] encryptHMACSHA256(String data, String secret) throws IOException  {
    	byte[] bytes = null;
    	try {
	        SecretKey secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
	        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
	        mac.init(secretKey);
	        bytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
    	} catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }
    
	/**
	 * Transfer binary array to HEX string.
	 */
	public static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}	
	
    private static boolean areNotEmpty(String key, String value) {
    	return true;
	}
    
    public static void main(String[] args) {
		try {
			System.out.println( signApiRequest(null, "/test/apibar2foo1foo_bar3foobar4", "4r", "sha256", "hihi"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}