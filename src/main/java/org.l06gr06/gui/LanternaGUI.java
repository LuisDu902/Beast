package org.l06gr06.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.l06gr06.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
public class LanternaGUI implements GUI{
    private final Screen screen;
    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }
    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 3);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }
    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/TheFont.otf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);


        Font loadedFont = font.deriveFont(Font.PLAIN, 25);

        return AWTTerminalFontConfiguration.newInstance(loadedFont);

    }
    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        if (c == ' ') tg.setBackgroundColor(TextColor.Factory.fromString(color));
        else tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putCSIStyledString(x,y+3,"");
        tg.putString(x, y + 3, "" + c);
    }
    @Override
    public void drawText(Position position, String text, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }
    @Override
    public void drawPlayer(int phase, Position position){
        switch (phase) {
            case 0 -> drawCharacter(position.getX(), position.getY(), '&', "#00FFEF");
            case 1 -> drawCharacter(position.getX(), position.getY(), '&', "#FF9900");
        }

    }
    @Override
    public void drawShield(Position position){
        drawCharacter(position.getX(), position.getY(), '$', "#a64dff");
    }
    @Override
    public void drawWall(Position position){
        drawCharacter(position.getX(), position.getY(), ' ', "#FFFF66");
    }
    @Override
    public void drawHeart(Position position){
        drawCharacter(position.getX(), position.getY(), '@', "#FC0808");
    }
    @Override
    public void drawBeast(int phase, Position position){
        switch (phase) {
            case 0 -> drawCharacter(position.getX(), position.getY(), '*', "#FFFF66");
            case 1 -> drawCharacter(position.getX(), position.getY(), 'H', "#E80E0E");
            case 2 -> drawCharacter(position.getX(), position.getY(), '%', "#E80E0E");
        }
    }

    @Override
    public void drawBlock(Position position){
        drawCharacter(position.getX(), position.getY(), ' ', "#1DC249");
    }


    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException { screen.refresh(); }

    @Override
    public void close() throws IOException { screen.close(); }
}
