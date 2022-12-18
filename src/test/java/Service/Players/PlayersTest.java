package Service.Players;

import hu.Progtech.FoxAndHounds.Service.Players.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayersTest {
    private Players underTest;
    @Mock
    private Connection connection;
    @Mock
    private Statement statement;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    private String name = "Laci";
    private String wrongName = "Erik";
    private String insertQuery = "INSERT INTO PLAYERS (NAME, SCORE) VALUES (?, ?)";
    private String updateQuery = "UPDATE PLAYERS SET SCORE = ? WHERE NAME = ?";
    private String executeQuery = "SELECT * FROM PLAYERS";
    private String highScoreQuery = "SELECT * FROM PLAYERS ORDER BY SCORE DESC";

    @BeforeEach
    public void setUp() throws SQLException {
        underTest = new Players(name, connection);
    }

    @Test
    public void testPlayerScoreShouldGiveBackCorrectNumber() throws SQLException {
        //given
        given(connection.createStatement()).willReturn(statement);
        given(connection.prepareStatement(insertQuery)).willReturn(preparedStatement);
        given(statement.executeQuery(executeQuery)).willReturn(resultSet);
        given(resultSet.getString("NAME")).willReturn(name);
        given(resultSet.getInt("SCORE")).willReturn(2);
        when(resultSet.next()).thenReturn(true).thenReturn(false);

        //when
        int result = underTest.playerScore();

        //then
        verify(connection).createStatement();
        verify(connection).prepareStatement(insertQuery);
        verify(statement).executeQuery(executeQuery);
        verify(resultSet,atLeast(2)).next();
        verify(resultSet).close();
        verify(statement).close();
        verify(preparedStatement).close();
        verify(connection).close();
        assertEquals(2, result);
    }

    @Test
    public void testPlayerScoreShouldGiveBackZero() throws SQLException {
        //given
        given(connection.createStatement()).willReturn(statement);
        given(connection.prepareStatement(insertQuery)).willReturn(preparedStatement);
        given(statement.executeQuery(executeQuery)).willReturn(resultSet);
        given(resultSet.getString("NAME")).willReturn(wrongName);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        given(preparedStatement.executeUpdate()).willReturn(1);


        //when
        int result = underTest.playerScore();

        //then
        verify(connection).createStatement();
        verify(connection).prepareStatement(insertQuery);
        verify(statement).executeQuery(executeQuery);
        verify(resultSet,atLeast(2)).next();
        verify(preparedStatement).setString(1, name);
        verify(preparedStatement).setInt(2,0);
        verify(preparedStatement).executeUpdate();
        verify(resultSet).close();
        verify(statement).close();
        verify(preparedStatement).close();
        verify(connection).close();
        assertEquals(0, result);
    }

    @Test
    public void testUpdateScoreShouldGiveBackOne() throws SQLException {
        //given
        given(connection.createStatement()).willReturn(statement);
        given(connection.prepareStatement(updateQuery)).willReturn(preparedStatement);
        given(statement.executeQuery(executeQuery)).willReturn(resultSet);
        given(resultSet.getString("NAME")).willReturn(name);
        given(resultSet.getInt("SCORE")).willReturn(2);
        given(preparedStatement.executeUpdate()).willReturn(1);
        when(resultSet.next()).thenReturn(true).thenReturn(false);

        //when
        int result = underTest.updateScore();

        //then
        verify(connection).createStatement();
        verify(connection).prepareStatement(updateQuery);
        verify(statement).executeQuery(executeQuery);
        verify(resultSet,atLeast(2)).next();
        verify(preparedStatement).setInt(1, 3);
        verify(preparedStatement).setString(2, name);
        verify(preparedStatement).executeUpdate();
        verify(resultSet).close();
        verify(statement).close();
        verify(preparedStatement).close();
        verify(connection).close();
        assertEquals(1, result);
    }

    @Test
    public void testShowHighScore() throws SQLException {
        //given
        given(connection.createStatement()).willReturn(statement);
        given(statement.executeQuery(highScoreQuery)).willReturn(resultSet);
        given(resultSet.getString("NAME")).willReturn(name);
        given(resultSet.getInt("SCORE")).willReturn(2);
        when(resultSet.next()).thenReturn(true).thenReturn(false);

        //when
        underTest.showHighScore();

        //then
        verify(connection).createStatement();
        verify(statement).executeQuery(highScoreQuery);
        verify(resultSet, atLeast(2)).next();
        verify(resultSet).getString("NAME");
        verify(resultSet).getInt("SCORE");
        verify(resultSet).close();
        verify(statement).close();
        verify(connection).close();
    }
}
