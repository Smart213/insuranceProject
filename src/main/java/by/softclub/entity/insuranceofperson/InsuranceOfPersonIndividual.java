package by.softclub.entity.insuranceofperson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class InsuranceOfPersonIndividual extends APersonIns {

    private int discount;

    @Builder(builderMethodName = "insuranceOfPersonIndividual")
    public InsuranceOfPersonIndividual(String name,
                                       int discount,
                                       int riskRatio) {
        super.name = name;
        super.riskRatio = riskRatio;
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InsuranceOfPersonIndividual that = (InsuranceOfPersonIndividual) o;
        return discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
