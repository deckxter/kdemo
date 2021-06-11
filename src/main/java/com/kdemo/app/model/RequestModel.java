package com.kdemo.app.model;

import lombok.Data;

import java.util.List;

@Data
public class RequestModel {
    private List<PlayerModel> players;
}
