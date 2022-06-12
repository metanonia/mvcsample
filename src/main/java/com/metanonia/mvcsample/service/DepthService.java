package com.metanonia.mvcsample.service;

import com.metanonia.mvcsample.model.Depth;
import com.metanonia.mvcsample.model.DepthId;
import com.metanonia.mvcsample.repository.DepthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class DepthService {
    @Autowired
    DepthRepository depthRepository;


    public List<HashMap<String,Object>> findAll() {
        List<Depth>list = depthRepository.findAll();
        List<HashMap<String,Object>>result = new ArrayList<>();
        for(int idx=0;idx<5; idx++) {
            DepthId ask = new DepthId("BTCUSDT", idx, "ask");
            Optional<Depth> Ask = depthRepository.findById(ask);
            DepthId bid = new DepthId("BTCUSDT", idx, "bid");
            Optional<Depth> Bid = depthRepository.findById(bid);
            HashMap<String,Object>map = new HashMap<>();
            map.put("symbol", "BTCUSDT");
            map.put("level", idx);
            if(Ask.isPresent()) {
                Depth item = Ask.get();
                map.put("askprice", item.getPrice());
                map.put("askamt", item.getAmt());
            }
            if(Bid.isPresent()) {
                Depth item = Bid.get();
                map.put("bidprice", item.getPrice());
                map.put("bidamt", item.getAmt());
            }
            result.add(map);
        }
        return result;
    }
}
