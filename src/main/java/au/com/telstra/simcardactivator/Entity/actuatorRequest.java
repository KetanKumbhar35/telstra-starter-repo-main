package au.com.telstra.simcardactivator.Entity;

public class actuatorRequest {
    private String iccid;

    public actuatorRequest() {
        // Default constructor
    }

    public actuatorRequest(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
}
