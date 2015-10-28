package core.service;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("infoRetrieval")
public class TestingCenterInfoRetrievalImp implements TestingCenterInfoRetrieval {

    /**
     * this method retrieves all fields in TestingCenterInfo and wrap and return
     * them in a HashMap for display
     * @return
     */
    @Override
    public Map<String, Object> retrievalInfo() {
        //implement here
        return null;
    }

    /**
     * update the testing center information by
     * taking HashMap as a parameter
     * @param testingCenterInfoMap
     * @return return true if the update is a success
     *         return false if there is an error, an exception will be
     *         thrown
     */
    @Override
    public boolean updateTestingCenterInfo(Map<String, Object> testingCenterInfoMap) {
        //implement here
        return false;
    }
}
