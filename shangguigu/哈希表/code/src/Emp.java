import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/25
 * Time: 23:29
 * To change this template use File | Settings | File Templates.
 **/
public class Emp {
    private Integer id;
    private String name;

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(id, emp.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
