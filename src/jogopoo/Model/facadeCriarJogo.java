/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import jogopoo.Control.Application;
import jogopoo.Control.ColisionHandler;
import jogopoo.Control.Updater;

/**
 *
 * @author tiago
 */
public class facadeCriarJogo {
    private int jH;
    private int jW;
    private ColisionHandler colisionHandler;
    private Updater updater;
    private PersonagemModel persModel;
    public facadeCriarJogo(ColisionHandler colisionHandler,Updater updater,PersonagemModel persModel){
        jH = Application.AlturaJanela;
        jW = Application.ComprimentoJanela;
        this.colisionHandler = colisionHandler;
        this.updater = updater;
        this.persModel = persModel;
    }
    public void CriarJogo(){
      new NPCGoblin(new Coordenada(jW-40, jH-40),persModel.posicao);
      new NPCGoblin(new Coordenada(jW-40, jH/2),persModel.posicao);
      new NPCGoblin(new Coordenada(jW/2, jH-40),persModel.posicao);
      
      new NPCGoblin(new Coordenada(2*jW - jW*2/3-40, jH/2), persModel.posicao);
      new NPCJavali(new Coordenada(2*jW - jW*1/3-40, jH/2), persModel.posicao);
      new NPCGoblin(new Coordenada(2*jW - 40, jH/2), persModel.posicao);
      
      new NPCGoblin(new Coordenada(jW*5/2, jH*1/4), persModel.posicao);
      new NPCJavali(new Coordenada(jW*5/2, jH*2/4), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*5/2, jH*3/4), persModel.posicao);
      
      new NPCGoblin(new Coordenada(jW*3 + jW*1/5-40, 40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*3 + jW*2/5-40, 40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*3 + jW*3/5-40, 40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*3 + jW*4/5-40, 40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*3 + jW -40, 40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*4 -40, jH*1/5+40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*4 -40, jH*2/5+40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*4 -40, jH*3/5+40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*4 -40, jH*4/5+40), persModel.posicao);
      new NPCJavali(new Coordenada(jW*7/2, jH*1/2), persModel.posicao);
      
      new NPCJavali(new Coordenada(jW*1/4, jH*3/2), persModel.posicao);
      new NPCJavali(new Coordenada(jW*2/4, jH*3/2), persModel.posicao);
      new NPCJavali(new Coordenada(jW*3/4, jH*3/2), persModel.posicao);
      
      new NPCJavali(new Coordenada(jW + jW*1/4, jH*3/2), persModel.posicao);
      new NPCJavali(new Coordenada(jW + jW*2/4, jH*3/2), persModel.posicao);
      new NPCJavali(new Coordenada(jW + jW*3/4, jH*3/2), persModel.posicao);
      new NPCGoblin(new Coordenada(jW + jW*2/4, jH*5/4), persModel.posicao);
      new NPCGoblin(new Coordenada(jW + jW*2/4, jH*7/4), persModel.posicao);
      
      new NPCGoblin(new Coordenada(2*jW + jW*1/4, jH*3/2), persModel.posicao);
      new NPCGoblin(new Coordenada(2*jW + jW*2/4, jH*3/2), persModel.posicao);
      new NPCGoblin(new Coordenada(2*jW + jW*3/4, jH*3/2), persModel.posicao);
      new NPCJavali(new Coordenada(2*jW + jW*2/4, jH*5/4), persModel.posicao);
      new NPCJavali(new Coordenada(2*jW + jW*2/4, jH*7/4), persModel.posicao);
      
      new NPCGoblin(new Coordenada(3*jW + jW*1/3, jH + jH*1/3), persModel.posicao);
      new NPCGoblin(new Coordenada(3*jW + jW*1/3, jH + jH*2/3), persModel.posicao);
      new NPCGoblin(new Coordenada(3*jW + jW*2/3, jH + jH*1/3), persModel.posicao);
      new NPCGoblin(new Coordenada(3*jW + jW*2/3, jH + jH*2/3), persModel.posicao);
      
      
      
      new NPCGoblin(new Coordenada(jW-40, 3*jH-40),persModel.posicao);
      new NPCGoblin(new Coordenada(jW-40, jH*5/2),persModel.posicao);
      new NPCGoblin(new Coordenada(jW/2, 3*jH-40),persModel.posicao);
      
      new NPCGoblin(new Coordenada(2*jW - jW*2/3-40, jH*5/2), persModel.posicao);
      new NPCJavali(new Coordenada(2*jW - jW*1/3-40, jH*5/2), persModel.posicao);
      new NPCGoblin(new Coordenada(2*jW - 40, jH*5/2), persModel.posicao);
      
      new NPCGoblin(new Coordenada(jW*5/2, jH*9/4), persModel.posicao);
      new NPCJavali(new Coordenada(jW*5/2, jH*10/4), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*5/2, jH*11/4), persModel.posicao);
      
      new NPCGoblin(new Coordenada(jW*3 + jW*1/5-40, 2*jH + 40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*3 + jW*2/5-40, 2*jH +40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*3 + jW*3/5-40, 2*jH +40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*3 + jW*4/5-40, 2*jH +40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*3 + jW -40, 2*jH + 40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*4 -40, jH*11/5+40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*4 -40, jH*12/5+40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*4 -40, jH*13/5+40), persModel.posicao);
      new NPCGoblin(new Coordenada(jW*4 -40, jH*14/5+40), persModel.posicao);
      new NPCJavali(new Coordenada(jW*7/2, jH*5/2), persModel.posicao);
      
      new NPCJavali(new Coordenada(jW*1/4, jH*7/2), persModel.posicao);
      new NPCJavali(new Coordenada(jW*2/4, jH*7/2), persModel.posicao);
      new NPCJavali(new Coordenada(jW*3/4, jH*7/2), persModel.posicao);
      
      new NPCJavali(new Coordenada(jW + jW*1/4, jH*7/2), persModel.posicao);
      new NPCJavali(new Coordenada(jW + jW*2/4, jH*7/2), persModel.posicao);
      new NPCJavali(new Coordenada(jW + jW*3/4, jH*7/2), persModel.posicao);
      new NPCGoblin(new Coordenada(jW + jW*2/4, jH*15/4), persModel.posicao);
      new NPCGoblin(new Coordenada(jW + jW*2/4, jH*17/4), persModel.posicao);
      
      new NPCGoblin(new Coordenada(2*jW + jW*1/4, jH*7/2), persModel.posicao);
      new NPCGoblin(new Coordenada(2*jW + jW*2/4, jH*7/2), persModel.posicao);
      new NPCGoblin(new Coordenada(2*jW + jW*3/4, jH*7/2), persModel.posicao);
      new NPCJavali(new Coordenada(2*jW + jW*2/4, jH*15/4), persModel.posicao);
      new NPCJavali(new Coordenada(2*jW + jW*2/4, jH*17/4), persModel.posicao);
      
      new NPCGoblin(new Coordenada(3*jW + jW*1/3, jH + jH*10/3), persModel.posicao);
      new NPCGoblin(new Coordenada(3*jW + jW*1/3, jH + jH*11/3), persModel.posicao);
      new NPCGoblin(new Coordenada(3*jW + jW*2/3, jH + jH*10/3), persModel.posicao);
      new NPCGoblin(new Coordenada(3*jW + jW*2/3, jH + jH*11/3), persModel.posicao);
      
      new BOSS(new Coordenada(jW*7/2, jH*7/2), persModel.posicao);
      
      
    }
}
