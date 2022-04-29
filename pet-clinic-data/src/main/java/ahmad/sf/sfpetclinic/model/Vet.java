package ahmad.sf.sfpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialitys;

    public Set<Speciality> getSpecialitys() {
        return specialitys;
    }

    public void setSpecialitys(Set<Speciality> specialitys) {
        this.specialitys = specialitys;
    }
}
