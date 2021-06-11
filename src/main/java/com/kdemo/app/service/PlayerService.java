package com.kdemo.app.service;

import com.kdemo.app.entity.PlayerEntity;
import com.kdemo.app.model.PlayerModel;
import com.kdemo.app.model.RequestModel;
import com.kdemo.app.model.ResultModel;
import com.kdemo.app.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PlayerService {
    private static final String EXPERT_TYPE = "expert";
    private static final String NOVICE_TYPE = "novice";

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private Producer producer;

    public ResultModel savePlayer(RequestModel requestModel) {
        ResultModel result = new ResultModel();
        List<String> playerMessage = new ArrayList<>();

        for(PlayerModel model : requestModel.getPlayers()) {
            String whereIsPersisted = persisData(modelToEntity(model));
            playerMessage.add(whereIsPersisted);
        }
        result.setResult(playerMessage);
        return result;
    }

    public PlayerEntity modelToEntity(PlayerModel model) {
        PlayerEntity entity = new PlayerEntity();
        entity.setName(model.getName());
        entity.setType(model.getType());
        return entity;
    }

    public String persisData(PlayerEntity entity) {
        if(entity.getType().equals(EXPERT_TYPE)) {
            playerRepository.save(entity);
            return "player " + entity.getName() + " stored in DB";
        }
        else if(entity.getType().equals(NOVICE_TYPE)) {
            producer.sendMessage(entity.toString());
            return "player " + entity.getName() + " sent to Kafka topic";
        }
        else {
            return "player " +entity.getName() + " did not fit";
        }
    }
}
