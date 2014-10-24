
package JavaBean;

import java.util.ArrayList;

public class ImagesBean {
    
    private ArrayList<String> imagesData = new ArrayList<String>();

    public ImagesBean() {
    }

    public ArrayList<String> getImagesData() {
        return imagesData;
    }

    public void setImagesData(ArrayList<String> imagesData) {
        this.imagesData = imagesData;
    }
}