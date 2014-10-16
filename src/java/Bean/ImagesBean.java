
package Bean;

import org.apache.commons.codec.binary.Base64;

public class ImagesBean {
    
    private byte[] imagesData;

    public ImagesBean() {
    }

    public ImagesBean(byte[] imagesData) {
        this.imagesData = imagesData;
    }

    public byte[] getImagesData() {
        return imagesData;
    }

    public void setImagesData(byte[] imagesData) {
        this.imagesData = imagesData;
    }
    
    public String getByteArrayString()
    {
        return Base64.encodeBase64String(imagesData);
    }
}