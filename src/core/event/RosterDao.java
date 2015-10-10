package core.event;

import java.util.List;

/**
 * Created by eson_wang on 10/11/15.
 */
public interface RosterDao {

    List<exam> findBynetId(String netId);

    boolean addRoster(Roster roster);

    boolean updateRoster(Roster roster, String netId);

    boolean deleteRoster(String netId);


}
