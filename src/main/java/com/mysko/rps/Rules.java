package main.java.com.mysko.rps;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;

import static main.java.com.mysko.rps.Mains.gameArray;


public final class Rules {

    private int n = gameArray.size();

    public void gameRules(){

        CellStyle alignCenter = new CellStyle(HorizontalAlign.center);
        Table t = new Table(gameArray.size() + 1, BorderStyle.UNICODE_BOX,
                ShownBorders.ALL);

        for(int i = 0; i < gameArray.size() + 1; i++) {
            t.setColumnWidth(i,15,15);
            for(int j = 0; j < gameArray.size() + 1; j++) {
                if(i == 0 && j ==0){
                    t.addCell("PC / USER", alignCenter);
                }else if(i == 0 && j != 0) {
                    t.addCell(gameArray.get(j - 1), alignCenter);
                }else  if(j == 0 && i != 0) {
                    t.addCell(gameArray.get(i -1), alignCenter);
                } else if(i!= 0 && j!= 0) {
                    if(i == j) {
                        t.addCell("DRAW", alignCenter);
                    } else {
                        if(i >  j) {
                            if((i - j) > (n -1)/2 ) t.addCell("WIN", alignCenter);
                            else t.addCell("LOSE", alignCenter);
                        } else if(i < j) {
                            if((j - i) > (n -1)/2 ) t.addCell("LOSE", alignCenter);
                            else t.addCell("WIN", alignCenter);
                        }
                    }

                }
            }
        }

        System.out.println(t.render());
    }
}
