package com.gymguard.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/settings/{id}")
    public int updatePatch(@PathVariable("id") int id, @RequestBody Setting updatedSetting) {
        Setting setting = settingRepository.getById(id);
        setting.setValue(updatedSetting.getValue());
        return settingRepository.update(setting);
    }
}
