package com.kdemo.app.controller;

import com.kdemo.app.model.PlayerModel;
import com.kdemo.app.model.RequestModel;
import com.kdemo.app.model.ResultModel;
import com.kdemo.app.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kdemo")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping(value = "/player", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResultModel savePlayer(@RequestBody RequestModel requestModel) {
        return playerService.savePlayer(requestModel);
    }
}
