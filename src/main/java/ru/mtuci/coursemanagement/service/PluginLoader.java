package ru.mtuci.coursemanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PluginLoader {

    // Загрузка плагинов из произвольных URL отключена
    // как небезопасная функциональность
    public void tryLoad() {
        log.info("Plugin loading from external URLs is disabled for security reasons");
    }
}