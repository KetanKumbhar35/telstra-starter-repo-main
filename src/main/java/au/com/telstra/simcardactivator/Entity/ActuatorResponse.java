package au.com.telstra.simcardactivator.Entity;

public class ActuatorResponse {
    private boolean success;

    public ActuatorResponse() {
        // Default constructor
    }

    public ActuatorResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
