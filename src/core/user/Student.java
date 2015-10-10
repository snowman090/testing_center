package core.user;

import core.event.Appointment;
import core.user.Authorization;
import core.user.UserType;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student extends UserType {
    public static final Authorization permission;
    private List<Appointment> appointments = new List<Appointment>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Appointment> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Appointment appointment) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Appointment> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Appointment> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public Appointment get(int index) {
            return null;
        }

        @Override
        public Appointment set(int index, Appointment element) {
            return null;
        }

        @Override
        public void add(int index, Appointment element) {

        }

        @Override
        public Appointment remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Appointment> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Appointment> listIterator(int index) {
            return null;
        }

        @Override
        public List<Appointment> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    // Empty Constructor for Hibernate
    public Student() {
    }

    public Student(String netId, String pwd, String firstName, String lastName) {
        this.netId = netId;
        this.password = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public List<Appointment> getAppointments(){
        return appointments;
    }
    static {
        permission = Authorization.STUDENT;
    }
}
