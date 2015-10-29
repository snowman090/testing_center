package core.event;

import java.util.List;

public interface RosterDao {

    List<exam> findBynetId(String netId);

    boolean addRoster(Roster roster);

    boolean updateRoster(Roster roster, String netId);

    boolean deleteRoster(String netId);


}
