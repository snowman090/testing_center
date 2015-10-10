package core.event;

import core.user.Instructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by eson_wang on 10/11/15.
 */
public class exam {
    @Id
    @Column(name = "examId")
    @Basic(optional = false)
    private String courseId;

    @Basic(optional = false)
    @Column(name = "type" )
    private String type;//course or adhoc

    @Basic(optional = false)
    @Column(name = "catalogNumber")
    private int catalog;






}
