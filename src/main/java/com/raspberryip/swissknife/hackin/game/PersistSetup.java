package com.raspberryip.swissknife.hackin.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.raspberryip.swissknife.hackin.game.component.Log;
import com.raspberryip.swissknife.hackin.game.pojo.Bio;
import com.raspberryip.swissknife.hackin.game.pojo.GameSetup;
import com.raspberryip.swissknife.hackin.generator.component.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class PersistSetup {
    private final String pathSetup = System.getProperty("user.home") + "/etc/hackin/mygame.yaml";

    @Autowired
    private Log log;

    @Autowired
    private Names names;

    private Bio bio;

    public void loadBio(String savePath) {
        File path = new File(savePath);
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

            GameSetup setup = mapper.readValue(
                    path,
                    GameSetup.class);
            bio = setup.getBio();
        } catch (IOException e) {
            path.getParentFile().mkdirs();
            bio = new Bio(names);
        }
    }


    public Bio getBio() {
        if (bio == null) {
            loadBio(pathSetup);
        }
        return bio;
    }

    public void setBio(Bio bio) {
        this.bio = bio;
    }

    public void save() {
        try {
            GameSetup setup = new GameSetup();
            setup.setBio(bio);

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.writeValue(
                    new File(pathSetup),
                    setup);
        } catch (IOException e) {
            log.track("E' rotto: " + e.getMessage());
        }
    }
}
