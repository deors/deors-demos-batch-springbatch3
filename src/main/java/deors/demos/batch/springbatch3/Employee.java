package deors.demos.batch.springbatch3;

import java.io.Serializable;

/**
 * Employee bean.
 *
 * @author jorge.hidalgo
 * @version 1.0
 */
public class Employee
    implements Serializable {

    /**
     * Serialization Id.
     */
    private static final long serialVersionUID = -5847039812444391969L;

    /**
     * The employee Id.
     */
    private String id;

    /**
     * The first name.
     */
    private String first;

    /**
     * The last name.
     */
    private String last;

    /**
     * The postal address.
     */
    private String address;

    /**
     * The telephone number.
     */
    private String phone;

    /**
     * The e-mail address.
     */
    private String email;

    /**
     * Default constructor.
     */
    public Employee() {

        super();
    }

    /**
     * Constructor that sets employee properties.
     *
     * @param id the employee id
     * @param first the first name
     * @param last the last name
     * @param address the postal address
     * @param phone the telephone number
     * @param email the e-mail address
     */
    public Employee(String id, String first, String last, String address,
                    String phone, String email) {

        super();
        this.id = id;
        this.first = first;
        this.last = last;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Returns the value of the property <code>id</code>.
     *
     * @return the value of the property
     */
    public String getId() {
        return id;
    }

    /**
     * Changes the value of the property <code>id</code>.
     *
     * @param id the new value for the property
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the value of the property <code>first</code>.
     *
     * @return the value of the property
     */
    public String getFirst() {
        return first;
    }

    /**
     * Changes the value of the property <code>first</code>.
     *
     * @param first the new value for the property
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * Returns the value of the property <code>last</code>.
     *
     * @return the value of the property
     */
    public String getLast() {
        return last;
    }

    /**
     * Changes the value of the property <code>last</code>.
     *
     * @param last the new value for the property
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * Returns the value of the property <code>address</code>.
     *
     * @return the value of the property
     */
    public String getAddress() {
        return address;
    }

    /**
     * Changes the value of the property <code>address</code>.
     *
     * @param address the new value for the property
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the value of the property <code>phone</code>.
     *
     * @return the value of the property
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Changes the value of the property <code>phone</code>.
     *
     * @param phone the new value for the property
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns the value of the property <code>email</code>.
     *
     * @return the value of the property
     */
    public String getEmail() {
        return email;
    }

    /**
     * Changes the value of the property <code>email</code>.
     *
     * @param email the new value for the property
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Compares the given object with this object.
     *
     * @param obj the object to compare this with
     * @return whether both objects are equals
     */
    public boolean equals(Object obj) {

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee tgt = (Employee) obj;

        return this.getId().equals(tgt.getId())
            && this.getFirst().equals(tgt.getFirst())
            && this.getLast().equals(tgt.getLast())
            && this.getAddress().equals(tgt.getAddress())
            && this.getPhone().equals(tgt.getPhone())
            && this.getEmail().equals(tgt.getEmail());
    }

    /**
     * Calculates this instance hash code.
     *
     * @return the calculated hash code
     */
    public int hashCode() {

        return toString().hashCode();
    }

    /**
     * Returns a string representation of this instance.
     *
     * @return the bean data as a string
     */
    public String toString() {

        return id + "/" + first + "/" + last + "/" + address + "/" + phone
            + "/" + email;
    }
}
