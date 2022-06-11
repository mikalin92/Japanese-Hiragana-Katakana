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
public class Hiragana {
    
    public static final int SYMBOL_BLOCKSTART_HEXVALUE = 0x3040;
    public static final String[] westernNames = {
        "?-a-A-i-I-u-U-e-E-o-O-Ka-ga-ki-gi-ku",
        "gu-Ke-ge-ko-go-sa-za-si-zi-su-zu-se-ze-so-zo-ta",
        "da-ti-di-tu-Tu-du-te-de-to-do-na-ni-nu-ne-no-ha",
        "ba-pa-hi-bi-pi-hu-bu-pu-he-be-pe-ho-bo-po-ma-mi",
        "mu-me-mo-ya-Ya-yu-Yu-yo-Yo-ra-ri-ru-re-ro-wa-Wa",
        "wi-we-wo-n-vu-ka-ke-?-?-sym1-sym2-sym3-sym4-sym5-sym6-yori"
    };
    public SymbolSystem sys;
    
    
    public Hiragana() {
        this.sys=new SymbolSystem("Hiragana",SYMBOL_BLOCKSTART_HEXVALUE,westernNames);
    }

    
    
    
    
    

}
