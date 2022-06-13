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
public class SymbolSystem {

    public final String name;
    
    public final int HEXDECIMAL_BASE_VALUE=16;
    public final int SYMBOL_BLOCKSTART_HEXVALUE;
    public final int SYMBOL_BLOCK_ROWS;
    public  final String[] westernNames;

    public SymbolSystem(String name,int SYMBOL_BLOCKSTART_HEXVALUE, String[] westernNames) {
        this.name=name;
        this.SYMBOL_BLOCKSTART_HEXVALUE = SYMBOL_BLOCKSTART_HEXVALUE;
        this.westernNames = westernNames;
        this.SYMBOL_BLOCK_ROWS=westernNames.length;
    }
    

    
    
    
    public  char searchForSymbol(String westerName) {
        int[] location = new int[2];
        location[0]=0;
        location[1]=-SYMBOL_BLOCKSTART_HEXVALUE+(int)'?';
        
        
        for (int i = 0; i < SYMBOL_BLOCK_ROWS; i++) {
            String[] rowWesternNames = westernNames[i].split("-");
            for (int j = 0; j < HEXDECIMAL_BASE_VALUE; j++) {
                if (rowWesternNames[j].equals(westerName)) {
                    location[0] = i;
                    location[1] = j;
                };

            }

        }

        return (char) (SYMBOL_BLOCKSTART_HEXVALUE + HEXDECIMAL_BASE_VALUE * location[0] + location[1]);
    }

    public  String searchForWesternName(char hiragana) {
        int place = (int) hiragana - SYMBOL_BLOCKSTART_HEXVALUE;
        return westernNames[place / HEXDECIMAL_BASE_VALUE].split("-")[place % HEXDECIMAL_BASE_VALUE];

    }

    public  String blockDump(){
        int flowsymbol = SYMBOL_BLOCKSTART_HEXVALUE;
        String ret="";
        for (int i = 0; i < SYMBOL_BLOCK_ROWS; i++) {
            for (int j = 0; j < HEXDECIMAL_BASE_VALUE; j++) {
                String westernName = westernNames[i].split("-")[j];
                 ret+= (char) (flowsymbol) + "(" + westernName + ")|";
                flowsymbol++;
            }
            ret+= "\n";
        }
        return ret;
    }
    
}
