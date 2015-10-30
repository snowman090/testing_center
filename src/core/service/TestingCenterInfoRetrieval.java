package core.service;

import core.event.TestingCenterInfo;

import java.util.Map;

public interface TestingCenterInfoRetrieval {
    /**
     * returns the testing center information
     * @return
     */
    TestingCenterInfo retrieveInfo ();

    /**
     * update the testing center information by
     * taking HashMap as a parameter
     * @param testingCenterInfo
     * @return return true if the update is a success
     *         return false if there is an error, an exception will be
     *         thrown
     */
    boolean updateTestingCenterInfo(TestingCenterInfo testingCenterInfo);
}
