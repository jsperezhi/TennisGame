package com.sebastianperez.tennisgame.business;

import com.sebastianperez.tennisgame.dto.Game;
import com.sebastianperez.tennisgame.dto.Player;
import com.sebastianperez.tennisgame.enumerable.EState;
import com.sebastianperez.tennisgame.exception.TennisGameException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class PlayerBusinessTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream output = System.out;
    private PlayerBusiness playerBusiness;

    @Before
    public void setUp(){
        playerBusiness = new PlayerBusiness();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldIncrementScore() throws TennisGameException {
        Player playerOne = new Player((short) 1, "JUGADOR 1");
        Player playerTwo = new Player((short) 2, "JUGADOR 2");
        Game game = new Game(playerOne, playerTwo);

        playerBusiness.registerPlayerScore(game);

        Assert.assertTrue(game.getPlayers().stream().anyMatch(p -> p.getPoints() == 1));
    }

    @Test
    public void shouldShowTheWinner() {
        String systemOutput = "Juego terminado. \n Jugador #1 JUGADOR 1 GANADOR\n FELICIDADES!!!!\r\n";
        Player player = new Player((short) 1, "JUGADOR 1");
        player.setGameResult(EState.WINNER.get());

        playerBusiness.registerWinner(player);

        Assert.assertEquals(systemOutput, outContent.toString());
    }
}
