package net.thumbtack.su.service;


import net.thumbtack.su.dao.Cache;
import net.thumbtack.su.entity.Board;
import net.thumbtack.su.entity.MoveResult;
import net.thumbtack.su.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {MainService.class, Cache.class})
public class ServiceTest {

    private final String board     = "530070000600195300098000060800060003400803001700020006060000280000419005000080079";
    private final String afterMove = "530070000600195300198000060800060003400803001700020006060000280000419005000080079";

    @Autowired
    MainService service;

    @Test
    public void testGetSudoku() {
        Board board = service.get();
        assertNotNull(board);
        assertNotNull(board.getId());
        assertNotNull(board.getValue());
        assertEquals(board.getValue(), service.getDataStore().get(board.getId()));
    }

    @Test(expected = ServiceException.class)
    public void testValidateMoveWithNonExistentId() throws ServiceException {
        service.validateMove(1234, 4, 5, 8);
    }

    @Test
    public void testValidateMove() throws ServiceException {
        Board boardStub = new Board(board);
        long id = 8218048219143576781L;
        boardStub.setId(id);
        service.getDataStore().add(id, boardStub.getValue());
        assertEquals(MoveResult.VALID, service.validateMove(id, 2, 0, 1));
        assertEquals(afterMove, service.getDataStore().get(id));

    }
}
