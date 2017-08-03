/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import jogopoo.Model.*;
import jogopoo.View.*;
/**
 *
 * @author tiago
 */
public class Application extends JFrame implements KeyListener,MouseListener{
    private BufferedImage backBuffer;
    public boolean gamePaused = true;
    public  static final int FPS = 30;
    public static Updater updater;
    public static ColisionHandler colisionHandler;
    public static final int AlturaJanela = 450;
    public static final int ComprimentoJanela = 550;
    public static boolean teclas[] = new boolean[1024];
    public static boolean mouse = false;
    public static Application Application;
    public static Graphics bbg;
    private PersonagemModel persModel;
    private menuPrincipalView menuPrincipal;
    private menuEscolhaPersonagemView menuEscolhaPersonagem;
    private EntidadeView entView;
    private static boolean Terminar = false;
    InventarioView i = new InventarioView();
    InventarioController inv;
    ///testes camera
        private int camerax = 0;
        private int cameray = 0;
    ///termina testes
   
    public static void main(String[] args)  {
    Application.Application = new Application();
    Application.Mainloop();
    System.exit(1);
    }
    public static void Exit(){
        Terminar = true;
    }
    private void DesenharUI(Graphics g) {
        PersonagemMago m;
        PersonagemArqueiro a;
        g.drawString("level: "+ persModel.nivel, 0, AlturaJanela-49);
        g.drawString("HP:"+persModel.xp+"/"+persModel.XPNecessario[persModel.nivel], 0, AlturaJanela-31);
        g.drawString("HP:"+persModel.getHp()+"/"+persModel.getHp_max(), 0, AlturaJanela-18);
        if(persModel.getClass().getName().equalsIgnoreCase("jogopoo.model.PersonagemMago")){
            m = (PersonagemMago)persModel;
            g.drawString("MP:"+m.getMana()+"/"+m.getMana_max(), 0, AlturaJanela-5);
        }
        if(persModel.getClass().getName().equalsIgnoreCase("jogopoo.model.PersonagemArqueiro")){
            a = (PersonagemArqueiro)persModel;
            g.drawString("MP:"+a.getMana()+"/"+a.getMana_max(), 0, AlturaJanela-5);
        }
    }
    class PlayButtonListener implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            menuPrincipal.setVisible(false);
            menuEscolhaPersonagem.setVisible(true);
           
        }
       
    }
   
    class ChooseCharacterMage implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if(persModel != null) {
                updater.removerObservador(persModel);
                colisionHandler.removerObservador(persModel);
            }
             persModel = SimpleFactoryPersonagem.CriarPersonagem("Mago", entView,new Coordenada(150,150));
             SimpleFactoryHabilidades.cleanHabilidades();
             SimpleFactoryHabilidades.getHabilidadeDisponivel(persModel.getClass().getName());
             menuEscolhaPersonagem.updateCheckbox();
        }
       
    }
   
    class ChooseCharacterWarrior implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if(persModel != null) {
                updater.removerObservador(persModel);
                colisionHandler.removerObservador(persModel);
            }
            persModel = SimpleFactoryPersonagem.CriarPersonagem("Guerreiro", entView,new Coordenada(50,50));
            SimpleFactoryHabilidades.cleanHabilidades();
            SimpleFactoryHabilidades.getHabilidadeDisponivel(persModel.getClass().getName());            
            menuEscolhaPersonagem.updateCheckbox();
        }
       
    }
   
    class ChooseCharacterArcher implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if(persModel != null) {
                updater.removerObservador(persModel);
                colisionHandler.removerObservador(persModel);
            }
             persModel = SimpleFactoryPersonagem.CriarPersonagem("Arqueiro", entView,new Coordenada(50,50));
             SimpleFactoryHabilidades.cleanHabilidades();
             SimpleFactoryHabilidades.getHabilidadeDisponivel(persModel.getClass().getName());
             menuEscolhaPersonagem.updateCheckbox();
        }
       
    }
   
    class GameInit implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            facadeCriarJogo facade = new facadeCriarJogo(colisionHandler, updater,persModel);
            
            if(persModel != null && menuEscolhaPersonagem.getNumHability() >= 2) {
                menuEscolhaPersonagem.setVisible(false);
                facade.CriarJogo();
                setVisible(true);
                gamePaused = false;
                int[] habilities = new int[2];
                
                habilities = menuEscolhaPersonagem.getHability();
                

		 inv = new InventarioController(i, new InventarioModel(persModel));
                 persModel.setMagiaQ(Habilidades.habilidadesDisponiveis.get(habilities[0]));
                 persModel.setMagiaE(Habilidades.habilidadesDisponiveis.get(habilities[1]));
            }
        }
       
    }
   
    public void Mainloop() {
        inicializar();
        while (!Terminar) {
            if (gamePaused) {
                try {
                    pausarGame();
                    //desenharMenuPausa();
                    Thread.sleep(1000 / FPS);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            } else {
                desenharGraficos();
                atualizar();
                try {
                    Thread.sleep(1000 / FPS);
                } catch (Exception e) {
                    System.out.println("Thread interrompida!");
                }
            }
        }
    }
    public void inicializar() {
       
        menuPrincipal = new menuPrincipalView();
        menuPrincipal.addActionListenerPlay(new PlayButtonListener());
        menuPrincipal.setVisible(true);
        menuEscolhaPersonagem = new menuEscolhaPersonagemView();
        menuEscolhaPersonagem.addActionListenerMage(new ChooseCharacterMage());
        menuEscolhaPersonagem.addActionListenerWarrior(new ChooseCharacterWarrior());
        menuEscolhaPersonagem.addActionListenerArcher(new ChooseCharacterArcher());
       
        menuEscolhaPersonagem.addActionListenerGame(new GameInit());
       
        addKeyListener(this);
        addMouseListener(this);
        setTitle("title of the game");
        setSize(ComprimentoJanela, AlturaJanela);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        backBuffer = new BufferedImage(4*ComprimentoJanela, 4*AlturaJanela, BufferedImage.TYPE_INT_RGB);
        updater = new Updater();
        colisionHandler = new ColisionHandler();
       
        bbg = backBuffer.getGraphics();//COM bbg IREMOS DESENHAR NO NOSSO BUFFER
        //p = new Personagem();
        entView = new EntidadeView();
       
        InicializarParedes();
        
       
    }
    public void atualizar() {
        updater.notificarObservadores();
        colisionHandler.notificarObservadores();
        AtualizarCamera();
	pausarGame();
       
    }

    public void pausarGame() {
        if(teclas[KeyEvent.VK_M] && gamePaused == false){
            gamePaused = true;
            i.setVisible(true);
            
            
            
        }
        if(!i.isVisible()&& teclas[KeyEvent.VK_M] == true) {
            teclas[KeyEvent.VK_M] = false;
            gamePaused = false;
        }
            
    }

    public void desenharGraficos() {
        Graphics g = getGraphics();//COM g IREMOS DESENHAR O QUE ESTA NO BUFFER NA TELA
       
        //AQUI ESTAMOS DESENHANDO O BUFFER NA TELA,    
        g.drawImage(backBuffer, -camerax, -cameray, this);
        DesenharUI(g);
        desenharFundo(bbg);
    }
 
    public void desenharFundo(Graphics bbg) {
        Image backGround = new ImageIcon("src/imagens/backTile.png").getImage();
        bbg.clearRect(0,0,ComprimentoJanela*4, 4*AlturaJanela);
        for (int i = 0; i < 42; i++) {
            for (int j = 0; j < 42; j++) {
                bbg.drawImage(backGround, i*55, j*44,this);
                //bbg.drawImage(backGround, i * janelaW / 10, j * janelaH / 10, this);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
 
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)mouse = true;
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)mouse = false;
    }
 
    @Override
    public void mouseEntered(MouseEvent e) {}
 
    @Override
    public void mouseExited(MouseEvent e) {}
 
    @Override
    public void keyTyped(KeyEvent e) {}
 
    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }
 
    private void AtualizarCamera() {
        this.camerax = (int) this.persModel.posicao.x - ComprimentoJanela/2  + 25;
        this.cameray = (int) this.persModel.posicao.y - AlturaJanela/2 + 25;
        if(camerax<0)camerax=0;
        if(cameray<0)cameray=0;
        if(camerax + ComprimentoJanela > 4*ComprimentoJanela)camerax = 3*ComprimentoJanela;
        if(cameray + AlturaJanela > 4*AlturaJanela)cameray = 3*AlturaJanela;
       
    }
   
    class PlayListener implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
       
    }
   
    class ExitListener implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    public void InicializarParedes(){
        new ObjetoParede(new Coordenada(0,0),new Coordenada(10,AlturaJanela*4),this.colisionHandler,this.updater);
        new ObjetoParede(new Coordenada(0,0),new Coordenada(ComprimentoJanela*4,10),this.colisionHandler,this.updater);
        new ObjetoParede(new Coordenada(0,AlturaJanela*4 - 10),new Coordenada(ComprimentoJanela*4,AlturaJanela*4),this.colisionHandler,this.updater);
        new ObjetoParede(new Coordenada(ComprimentoJanela*4 -10,0),new Coordenada(ComprimentoJanela*4,AlturaJanela*4),this.colisionHandler,this.updater);
    }
}
