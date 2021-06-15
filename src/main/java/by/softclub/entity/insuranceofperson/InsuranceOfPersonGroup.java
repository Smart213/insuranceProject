package by.softclub.entity.insuranceofperson;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
public class InsuranceOfPersonGroup extends APersonIns {

    private Integer groupSize;

    @Builder(builderMethodName = "insuranceOfPersonGroup")
    public InsuranceOfPersonGroup(String name,
                                  int groupSize,
                                  int riskRatio) {
        super.name = name;
        super.riskRatio = riskRatio;
        this.groupSize = groupSize;
    }


    public Integer getGroupSize() {
        return groupSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InsuranceOfPersonGroup that = (InsuranceOfPersonGroup) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(groupSize, that.groupSize) &&
                Objects.equals(riskRatio, that.riskRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupSize);
    }

    @Override
    public String toString() {
        return "InsuranceOfPersonGroup{" +
                "groupSize=" + groupSize +
                ", riskRatio=" + riskRatio +
                ", name='" + name + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }
}
