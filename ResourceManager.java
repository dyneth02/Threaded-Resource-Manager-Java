package version_f.q3;

import java.util.Stack;

public class ResourceManager {
    public Integer resourceAmt;
    public Stack<Integer> resourcesList = new Stack<>();

    public ResourceManager() {}

    public ResourceManager(Integer rAmt) {
        this.resourceAmt = rAmt;
        resourceAllocate();
    }

    public void resourceAllocate() {
        for (int i = (resourceAmt - 1); i >= 0; i--) {
            resourcesList.push(i);
        }
    }

    public synchronized Integer requestResource(Integer uid) throws InterruptedException {
        while (resourcesList.isEmpty()) {
            System.out.println("User " + uid + " is waiting for a resource.");
            wait();
        }
        Integer allocatedResource = resourcesList.pop();
        System.out.println("User " + uid + " acquires resource " + allocatedResource);
        return allocatedResource;
    }

    public synchronized void releaseResource(Integer uid, Integer rid) {
        if (rid != null) {
            System.out.println("User " + uid + " releases resource " + rid);
            resourcesList.push(rid);
            notifyAll();
        } else {
            System.out.println("User " + uid + " attempted to release a null resource.");
        }
    }
}
