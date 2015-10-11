package net.thumbtack.su.service;

import net.thumbtack.su.dao.Storage;
import net.thumbtack.su.entity.Board;
import net.thumbtack.su.entity.MoveResult;
import net.thumbtack.su.service.exception.ServiceException;
import net.thumbtack.su.util.Helper;
import net.thumbtack.su.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    Storage storage;

    public Storage getDataStore() {
        return storage;
    }

    public Board get() {
        final String boardAsString = Helper.generateRandomBoard();

        Board board = new Board(boardAsString);
        final long uid = IdGenerator.getUID();
        board.setId(uid);

        storage.add(board);
        return board;
    }

    public MoveResult validateMove(long boardId, int x, int y, int value) throws ServiceException {
        String board = storage.get(boardId);
        if (board == null) {
            throw new ServiceException("board not found for ID: " + boardId);
        }
        MoveResult moveResult = Helper.checkMove(x, y, value, board);
        if (moveResult.equals(MoveResult.VALID)) {
            storage.add(boardId, Helper.updateMove(x, y, value, board));
        }

        return moveResult;
    }
}
