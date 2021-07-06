package com.raspberryip.swissknife.hackin.game.pojo;

import com.raspberryip.swissknife.hackin.generator.component.Names;
import com.raspberryip.swissknife.hackin.generator.pojo.Sex;
import lombok.Data;

@Data
public class Bio {
    private String firstName;
    private String lastName;
    private Sex sex;

    private String phD;
    private String enemy;

    private Integer income = 0;
    private Integer maxHours = 112; // Fulltime: 16h x 7d, can change using stamina/drugs/surgery to avoid sleep
    private Integer hours = 112;
    private Boolean tutorial = true;

    public Bio() {
    }

    public Bio(Names names) {
        sex = Sex.getRandom();
        lastName = names.getRandom("lastname");
        switch (sex) {
            case FEMALE:
                firstName = names.getRandom("firstname", "female", "fluid");
                break;
            case MALE:
                firstName = names.getRandom("firstname", "male", "fluid");
                break;
            default:
                firstName = names.getRandom("firstname");
        }

        phD = names.getRandom("university");
        enemy = names.getRandom("facility", "prefix") + " " + names.getRandom("facility", "suffix");
    }
}
