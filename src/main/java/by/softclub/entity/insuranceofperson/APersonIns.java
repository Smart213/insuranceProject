package by.softclub.entity.insuranceofperson;

import by.softclub.entity.AbstractInsurance;
import lombok.Data;

@Data
public abstract class APersonIns extends AbstractInsurance {

    protected int riskRatio;

}
