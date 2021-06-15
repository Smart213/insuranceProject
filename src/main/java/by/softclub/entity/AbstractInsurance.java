package by.softclub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public abstract class AbstractInsurance implements Comparable<AbstractInsurance> {

    protected Integer id;
    protected String name;
    protected Integer interestRate;

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

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public AbstractInsurance(Integer id, String name, Integer interestRate) {
        this.id = id;
        this.name = name;
        this.interestRate = interestRate;
    }

    public AbstractInsurance() {
    }

    @Override
    public int compareTo(AbstractInsurance o) {
        return interestRate.compareTo(o.getInterestRate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractInsurance that = (AbstractInsurance) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(interestRate, that.interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, interestRate);
    }

}
