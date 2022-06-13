/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mika.japanese;

/**
 *
 * @author Mika
 */
public class FrameHandler {

    private MainFrame mf;
    private SymbolSystem system;
    private final SymbolSystem[] systems = {new Hiragana().sys, new Katakana().sys};
    private int systemrotation;

    void handleSystemChange() {
        systemrotation++;
        system = systems[systemrotation % systems.length];
        mf.setSystem(systems[systemrotation % systems.length].name, systems[(systemrotation + 1) % systems.length].name);
        if (systemrotation == systems.length) {
            systemrotation = 0;
        }
        mf.setTitle("Japanese-" + system.name);
    }

    void handleDump() {
        //mf.setText(system.blockDump());
        new SymbolKeyboardFrame(this, this.system);
    }

    void handleHiraganaToWestern() {

        String s = mf.getCOMText();
        char[] symbols = s.toCharArray();
        String message = "";
        for (int i = 0; i < symbols.length; i++) {
            try {
                message += system.searchForWesternName(symbols[i]);
            } catch (Exception ex) {
                message += "?";
            }
        }
        mf.setText(message);

    }

    void handleWesternToHiragana() {
        String s = mf.getCOMText();
        String[] westNames = s.split("-");
        String message = "";
        for (int i = 0; i < westNames.length; i++) {
            try {
                message += system.searchForSymbol(westNames[i]);
               
            } catch (Exception ex) {
                message += "?";
            }
        }
        mf.setText(message);

    }

    public void addCOMText(String s) {
        mf.setCOMText(mf.getCOMText() + s);
    }
    
    private void addText(String s) {
        mf.setText(mf.getText() + s);
    }

    public FrameHandler(MainFrame mf) {
        this.mf = mf;
        handle();
    }

    private void handle() {
        system = systems[0];
        systemrotation = 0;
        mf.setTitle("Japanese-" + system.name);
        mf.setSize(1700, 700);
        mf.setLocation(100, 100);
        mf.setFontSize(25f);
    }

}
