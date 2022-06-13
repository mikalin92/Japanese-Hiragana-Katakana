/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mika.japanese;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Mika
 */
public class SymbolKeyboardFrame extends JFrame {
    
    private FrameHandler caller;
    private SymbolSystem sys;
    public SymbolKeyboardFrame(FrameHandler caller, SymbolSystem sys) {
        this.caller=caller;
        this.sys=sys;
        this.setLayout(new GridLayout(this.sys.SYMBOL_BLOCK_ROWS,this.sys.HEXDECIMAL_BASE_VALUE));
        JButton [] buttons=new JButton[this.sys.HEXDECIMAL_BASE_VALUE*this.sys.SYMBOL_BLOCK_ROWS];
        for(int i=0;i<buttons.length;i++){
            buttons[i]=new JButton();
            char buttonchar=(char)(this.sys.SYMBOL_BLOCKSTART_HEXVALUE+i);
            buttons[i].setText(""+buttonchar+" ("+this.sys.searchForWesternName(buttonchar)+")");
            this.add(buttons[i]);
            buttons[i].addActionListener((e)->{
                this.caller.addCOMText(""+buttonchar);
            });
        }
        int size=70;
        this.setSize(this.sys.HEXDECIMAL_BASE_VALUE*size, this.sys.SYMBOL_BLOCK_ROWS*size );
        this.setTitle("Keyboard-"+sys.name);
        this.setVisible(true);
        
        
    }
    
    
    
}
