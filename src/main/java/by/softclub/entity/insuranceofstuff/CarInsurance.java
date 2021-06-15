package by.softclub.entity.insuranceofstuff;

import by.softclub.entity.AbstractInsurance;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarInsurance extends AbstractInsurance {

    private String category;
    protected Integer assessedValue;

    public CarInsurance(String category, Integer assessedValue) {
        this.category = category;
        this.assessedValue = assessedValue;
    }

    public CarInsurance() {
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAssessedValue() {
        return assessedValue;
    }

    public void setAssessedValue(Integer assessedValue) {
        this.assessedValue = assessedValue;
    }

    @Builder(builderMethodName = "carBuilder")
    public CarInsurance(String name,
                        Integer assessedValue,
                        Integer id,
                        String category,
                        Integer interestRate) {
        super.name = name;
        super.id = id;
        this.category = category;
        this.assessedValue = assessedValue;
        super.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "CarInsurance{" +
                "category='" + category + '\'' +
                ", assessedValue=" + assessedValue +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarInsurance that = (CarInsurance) o;
        return category == that.category;//TODO: добавить поля
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category);
    }//TODO: добавить поля
}
