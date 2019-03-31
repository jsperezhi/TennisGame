package com.sebastianperez.tennisgame.business;

import com.sebastianperez.tennisgame.dto.Game;
import com.sebastianperez.tennisgame.dto.Player;
import com.sebastianperez.tennisgame.enumerable.EState;
import com.sebastianperez.tennisgame.memento.MementoGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class RecordBusinessTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream output = System.out;
    private RecordBusiness recordBusiness;

    @Before
    public void setUp(){
        recordBusiness = new RecordBusiness();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldSaveGameResult() {
        Player playerone = new Player((short) 1, "JUGADOR 1");
        playerone.setPoints((short) 5);
        playerone.setGameResult(EState.WINNER.get());

        Player playertwo = new Player((short) 2, "JUGADOR 2");
        playerone.setPoints((short) 3);

        Game game = new Game(playerone, playertwo);

        recordBusiness.save(game);

        Assert.assertEquals(MementoGame.getRecords().get(0).getGame(), game);
    }

    @Test
    public void shouldShowNoDataMessage() {
        recordBusiness.showRecords();
        String sytemOutput = "Sin datos de juego\r\n";

        Assert.assertEquals(sytemOutput, outContent.toString());
    }


}
