package nespresso.gossip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {
    public String name;
    public String role;
    public Person(String nameAndRole){
        List<String> nameAndRoleArr = this.parseNameAndRole(nameAndRole);
        this.role = nameAndRoleArr.get(0);
        this.name = nameAndRoleArr.get(1);
    }
    private List<String> parseNameAndRole(String nameAndRole){
        return new ArrayList<>(Arrays.asList(nameAndRole.split(" ")));
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(role, person.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }

}
