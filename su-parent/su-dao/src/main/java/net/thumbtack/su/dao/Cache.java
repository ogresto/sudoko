package net.thumbtack.su.dao;

import net.thumbtack.su.entity.Board;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Cache implements Storage {
    Map<Long, String> map = new ConcurrentHashMap<>();

    @Override
    public void add(Board board){
        map.put(board.getId(), board.getValue());
    }

    @Override
    public void add(Long id, String attitude){
        map.put(id, attitude);
    }

    @Override
    public String get(Long id){
        return map.get(id);
    }
}
