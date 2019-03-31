package com.sebastianperez.tennisgame.gamerules;

import com.sebastianperez.tennisgame.dto.Game;
import com.sebastianperez.tennisgame.dto.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class GameRulesImplsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream output = System.out;

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldExcuteNormalScoreRule() {
        Player playerone = new Player((short) 1, "JUGADOR 1");
        playerone.setPoints((short) 1);
        Player playertwo = new Player((short) 2, "JUGADOR 2");
        playertwo.setPoints((short) 3);

        Game game = new Game(playerone, playertwo);

        GameRulesImpls.validateGameRules(game);

        String systemOutput = "| MARCADOR |\n" +
                "Jugador #1 QUINCE | Jugador #2 CUARENTA\r\n";

        Assert.assertEquals(systemOutput, outContent.toString());
    }

    @Test
    public void shouldExecuteStateScoreRule() {
        Player playerone = new Player((short) 1, "JUGADOR 1");
        playerone.setPoints((short) 5);
        Player playertwo = new Player((short) 2, "JUGADOR 2");
        playertwo.setPoints((short) 5);

        Game game = new Game(playerone, playertwo);

        GameRulesImpls.validateGameRules(game);

        String systemOutput = "| MARCADOR |\n" +
                "Jugador #1 DEUCE | Jugador #2 DEUCE\r\n";

        Assert.assertEquals(systemOutput, outContent.toString());
    }
}
