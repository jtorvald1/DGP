
package Bean;

import Model.Image;
import java.util.List;

public class ProductBean {
    
    private List<Image> selectedImages;

    public ProductBean(List<Image> selectedImages) {
        this.selectedImages = selectedImages;
    }

    public ProductBean() {
    }

    public List<Image> getSelectedImages() {
        return selectedImages;
    }

    public void setSelectedImages(List<Image> selectedImages) {
        this.selectedImages = selectedImages;
    }
}
