package hu.Progtech.FoxAndHounds;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Command.GameCommands;
import hu.Progtech.FoxAndHounds.Service.Command.StepCommand;
import hu.Progtech.FoxAndHounds.Service.Map.MapBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoxAndHoundsConfig {

    @Bean
    public GameState fahGameState() {
        return new GameState(null, false, true, null, null);
    }

    @Bean
    public MapVO fahMapVO() {
        return new MapVO(0, null);
    }

    @Bean
    public GameCommands fahGameCommands() {
        return new GameCommands("", null);
    }

    @Bean
    public StepCommand fahStepCommand() {
        return new StepCommand(null, "", "");
    }

    @Bean
    public MapBuilder fahMapBuilder() {
        return new MapBuilder(0);
    }
}
