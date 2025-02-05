package iuresti.training.peopleandcars.modeldb;

import javax.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "people")
public class PeopleDB {
    @Id
    private String guid;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private String email;
    private String gender;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "people_car",
            joinColumns = {
                    @JoinColumn(
                            name = "peopleid",
                            referencedColumnName = "guid"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "carid",
                            referencedColumnName = "vin"
                    )
            }
    )
//    @OneToMany(mappedBy = "car")
    private Set<CarDB> cars = new HashSet<>();

//
//    public void addCar(CarDB carDB) {
//        this.cars.add(carDB);
//        carDB.getPeople().add(this);
//    }
}
