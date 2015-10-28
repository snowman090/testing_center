package core.service;

import java.util.Map;

public interface TestingCenterInfoRetrieval {
    /**
     * returns all fields of TestingCenterInfo
     * in a HashMap
     * @return
     */
    Map<String, Object> retrievalInfo ();

    /**
     * update the testing center information by
     * taking HashMap as a parameter
     * @param testingCenterInfo
     * @return return true if the update is a success
     *         return false if there is an error, an exception will be
     *         thrown
     */
    boolean updateTestingCenterInfo(Map<String, Object> testingCenterInfo);
}
