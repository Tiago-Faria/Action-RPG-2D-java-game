/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

/**
 *
 * @author tiago
 */
public class SimpleFactoryHabilidades {
    public static void getHabilidadeDisponivel(String classe) {
        if("jogopoo.Model.PersonagemMago".equals(classe)){
            System.out.println("Mago escollhido");
            Habilidades.habilidadesDisponiveis.add(new HabilidadeBafoDeFogo());
            Habilidades.habilidadesDisponiveis.add(new HabilidadeBolaDeFogo());
            Habilidades.habilidadesDisponiveis.add(new HabilidadePeDeVento());
            Habilidades.habilidadesDisponiveis.add(new HabilidadeSetaDeGelo());
        }
        if("jogopoo.Model.PersonagemGuerreiro".equals(classe)){
            System.out.println("Mago Guerreiro");
            Habilidades.habilidadesDisponiveis.add(new HabilidadeFazOUrro());
            Habilidades.habilidadesDisponiveis.add(new HabilidadeGolpeFulminante());
            Habilidades.habilidadesDisponiveis.add(new HabilidadeGolpeGiratorio());
            Habilidades.habilidadesDisponiveis.add(new HabilidadeInvestida());
        }
        if("jogopoo.Model.PersonagemArqueiro".equals(classe)){
            System.out.println("Mago Arqueiro");
            Habilidades.habilidadesDisponiveis.add(new HabilidadeFlechaConcentrada());
            Habilidades.habilidadesDisponiveis.add(new HabilidadeFlechaVenenosa());
            Habilidades.habilidadesDisponiveis.add(new HabilidadeRajadaDeFlecha());
            Habilidades.habilidadesDisponiveis.add(new HabilidadeAdrenalina());
        }
    }
    
    public static void cleanHabilidades() {
        Habilidades.habilidadesDisponiveis.clear();
    }
}
