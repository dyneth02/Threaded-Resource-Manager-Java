package version_f.q3;

public class UserThread extends Thread {
    private Integer userID;
    private Integer currentResource;
    private ResourceManager rManager;

    public UserThread(Integer uid, ResourceManager rManager) {
        this.userID = uid;
        this.rManager = rManager;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) { 
            try {
                currentResource = rManager.requestResource(userID);
                Thread.sleep(1000); 
                rManager.releaseResource(userID, currentResource);
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                System.out.println("User " + userID + " was interrupted.");
                Thread.currentThread().interrupt(); 
            }
        }
    }
}
