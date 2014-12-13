
package Model.HelperClasses;

import org.apache.commons.codec.binary.Base64;

public class Base64Encoder {
    
    public static String getByteArrayString(byte[] imageData)
    {
        return Base64.encodeBase64String(imageData);
    }
}
