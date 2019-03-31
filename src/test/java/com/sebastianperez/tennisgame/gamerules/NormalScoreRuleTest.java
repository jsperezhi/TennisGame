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
public class NormalScoreRuleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream output = System.out;
    private NormalScoreRule normalScoreRule;

    @Before
    public void setUp(){
        normalScoreRule = new NormalScoreRule();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldExecuteRule() {
        Player playerone = new Player((short) 1, "JUGADOR 1");
        playerone.setPoints((short) 1);
        Player playertwo = new Player((short) 2, "JUGADOR 2");
        playertwo.setPoints((short) 3);

        Game game = new Game(playerone, playertwo);

        normalScoreRule.validatePoints(game);

        String systemOutput = "| MARCADOR |\n" +
                "Jugador #1 QUINCE | Jugador #2 CUARENTA\r\n";

        Assert.assertEquals(systemOutput, outContent.toString());
    }
}
