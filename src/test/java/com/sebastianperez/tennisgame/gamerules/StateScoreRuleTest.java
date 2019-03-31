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
public class StateScoreRuleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream output = System.out;
    private StateScoreRule stateScoreRule;

    @Before
    public void setUp(){
        stateScoreRule = new StateScoreRule();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldExecuteDeuceRule() {
        Player playerone = new Player((short) 1, "JUGADOR 1");
        playerone.setPoints((short) 5);
        Player playertwo = new Player((short) 2, "JUGADOR 2");
        playertwo.setPoints((short) 5);

        Game game = new Game(playerone, playertwo);

        stateScoreRule.validatePoints(game);

        String systemOutput = "| MARCADOR |\n" +
                "Jugador #1 DEUCE | Jugador #2 DEUCE\r\n";

        Assert.assertEquals(systemOutput, outContent.toString());
    }

    @Test
    public void shouldExecuteAdvantageRule() {
        Player playerone = new Player((short) 1, "JUGADOR 1");
        playerone.setPoints((short) 5);
        Player playertwo = new Player((short) 2, "JUGADOR 2");
        playertwo.setPoints((short) 6);

        Game game = new Game(playerone, playertwo);

        stateScoreRule.validatePoints(game);

        String systemOutput = "| MARCADOR |\n" +
                "Jugador #1 CUARENTA | Jugador #2 VENTAJA\r\n";

        Assert.assertEquals(systemOutput, outContent.toString());
    }
}
