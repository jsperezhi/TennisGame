package com.sebastianperez.tennisgame.business;

import com.sebastianperez.tennisgame.dto.Game;
import com.sebastianperez.tennisgame.dto.Player;
import com.sebastianperez.tennisgame.enumerable.EState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameBusinessTest {
    private GameBusiness gameBusiness;
    private PlayerBusiness playerBusiness;
    private Player player1;
    private Player player2;

    @Before
    public void setUp(){
        playerBusiness = Mockito.mock(PlayerBusiness.class);
        gameBusiness = new GameBusiness(playerBusiness);
    }

    @Test
    public void shouldExecuteGametoWinPlayerOne() throws Exception {
       player1 = new Player((short) 1, "JUGADOR 1");
       player1.setPoints((short) 5);
       player2 = new Player((short) 2, "JUGADOR 2");
       player2.setPoints((short) 3);
       Game game = new Game(player1, player2);

       Mockito.when(playerBusiness.registerPlayer((short) 1)).thenReturn(player1);
       Mockito.when(playerBusiness.registerPlayer((short) 2)).thenReturn(player2);
       Mockito.when(playerBusiness.registerPlayerScore(Mockito.any())).thenReturn(game);
       Mockito.doNothing().when(playerBusiness).registerWinner(player1);
       gameBusiness.startGame();

        Assert.assertEquals(player1.getGameResult(), EState.WINNER.get());
        Assert.assertEquals(player2.getGameResult(), EState.LOOSER.get());
    }

    @Test
    public void shouldExecuteGametoWinPlayerTwo() throws Exception {
        player1 = new Player((short) 1, "JUGADOR 1");
        player1.setPoints((short) 6);
        player2 = new Player((short) 2, "JUGADOR 2");
        player2.setPoints((short) 8);
        Game game = new Game(player1, player2);

        Mockito.when(playerBusiness.registerPlayer((short) 1)).thenReturn(player1);
        Mockito.when(playerBusiness.registerPlayer((short) 2)).thenReturn(player2);
        Mockito.when(playerBusiness.registerPlayerScore(Mockito.any())).thenReturn(game);
        Mockito.doNothing().when(playerBusiness).registerWinner(player1);
        gameBusiness.startGame();

        Assert.assertEquals(player2.getGameResult(), EState.WINNER.get());
        Assert.assertEquals(player1.getGameResult(), EState.LOOSER.get());
    }
}
