package com.gymguard.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettingController {

    @Autowired
    private SettingRepository settingRepository;

    @GetMapping("/settings")
    public List<Setting> getAll() {
        return settingRepository.getAll();
    }

    @GetMapping("/settings/{id}")
    public Setting getById(@PathVariable("id") int id) {
        return settingRepository.getById(id);
    }
}
