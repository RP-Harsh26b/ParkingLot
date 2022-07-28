package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.Person;

public class ParkingSlot {

    private static Integer idCount = 1;

    private final Integer id;
    Boolean isEmpty;
    Person person = null;

    public ParkingSlot( boolean isEmpty, Person person) {

        this.id = getIdCount();
        incrementIdCount();
        this.isEmpty = isEmpty;
        this.person = person;
    }

    private void incrementIdCount(){
        setIdCount(getId()+1);
    }

    public static Integer getIdCount() {
        return idCount;
    }

    public static void setIdCount(Integer idCount) {
        ParkingSlot.idCount = idCount;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Person getPerson() {
        if(!isEmpty) return person;
        else return null;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id=" + id +
                ", isEmpty=" + isEmpty +
                ", person=" + person +
                '}';
    }
}