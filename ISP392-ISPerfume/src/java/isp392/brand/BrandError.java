package isp392.brand;

public class BrandError {
    private String brandIDErr;
    private String brandNameErr;
    private String imageErr;
    private String statusErr;
    private String error;

    public BrandError() {
    }

    public BrandError(String brandIDErr, String brandNameErr, String imageErr, String statusErr, String error) {
        this.brandIDErr = brandIDErr;
        this.brandNameErr = brandNameErr;
        this.imageErr = imageErr;
        this.statusErr = statusErr;
        this.error = error;
    }

    public String getBrandIDErr() {
        return brandIDErr;
    }

    public void setBrandIDErr(String brandIDErr) {
        this.brandIDErr = brandIDErr;
    }

    public String getBrandNameErr() {
        return brandNameErr;
    }

    public void setBrandNameErr(String brandNameErr) {
        this.brandNameErr = brandNameErr;
    }

    public String getImageErr() {
        return imageErr;
    }

    public void setImageErr(String imageErr) {
        this.imageErr = imageErr;
    }

    public String getStatusErr() {
        return statusErr;
    }

    public void setStatusErr(String statusErr) {
        this.statusErr = statusErr;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setBrandNameError(String this_brands_name_already_existed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setImageError(String brands_image_is_required) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
