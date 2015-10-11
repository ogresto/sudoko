package net.thumbtack.su.dao;

import net.thumbtack.su.entity.Board;
import org.springframework.stereotype.Component;

@Component
public interface Storage {
    void add(Board board);
    void add(Long id, String attitude);

    String get(Long id);
}
