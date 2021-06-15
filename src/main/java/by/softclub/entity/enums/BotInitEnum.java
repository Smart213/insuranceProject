package by.softclub.entity.enums;

public enum BotInitEnum {
    TOKEN("1782808174:AAHTQzm_lBaTFW6hw7Oe7HWvta_z9GP-T1U"),
    NAME_BOT("learningSC_bot");

    BotInitEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private String value;
}
