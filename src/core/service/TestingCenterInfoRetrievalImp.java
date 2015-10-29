package core.service;

import core.event.TestingCenterInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("infoRetrieval")
public class TestingCenterInfoRetrievalImp implements TestingCenterInfoRetrieval {

    /**
     * retrieves the testing center information, return the object
     * of class TestingCenterInfo
     * @return
     */
    @Override
    public TestingCenterInfo retrieveInfo() {
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
