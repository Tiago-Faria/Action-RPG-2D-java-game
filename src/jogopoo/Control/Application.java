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
    private static final int AlturaJanela = 450;
    private static final int ComprimentoJanela = 550;
    public static boolean teclas[] = new boolean[1024];
    public static boolean mouse = false;
    public static Application Application;
    public static Graphics bbg;
    private PersonagemModel persModel;
    private menuPrincipalView menuPrincipal;
    private menuEscolhaPersonagemView menuEscolhaPersonagem;
    private EntidadeView entView;
    InventarioView i = new InventarioView();
    InventarioController inv;
    ///testes camera
        private int camerax = 0;
        private int cameray = 0;
    ///termina testes
   
    public static void main(String[] args)  {
    Application.Application = new Application();
    Application.Mainloop();
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
             persModel = SimpleFactoryPersonagem.CriarPersonagem("Mago", entView,new Coordenada(150,150));
        }
       
    }
   
    class ChooseCharacterWarrior implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
             persModel = SimpleFactoryPersonagem.CriarPersonagem("Guerreiro", entView,new Coordenada(50,50));
        }
       
    }
   
    class ChooseCharacterArcher implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
             persModel = SimpleFactoryPersonagem.CriarPersonagem("Arqueiro", entView,new Coordenada(50,50));
        }
       
    }
   
    class GameInit implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if(persModel != null) {
                menuEscolhaPersonagem.setVisible(false);
                Javali javali = new Javali(new Coordenada(200,200),persModel.posicao);
                new Goblin(new Coordenada(250, 250), persModel.posicao);
                setVisible(true);
                gamePaused = false;

		 inv = new InventarioController(i, new InventarioModel(persModel));
            }
        }
       
    }
   
    public void Mainloop() {
        inicializar();
        while (true) {
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
        menuEscolhaPersonagem.addActionListenerMage(new ChooseCharacterWarrior());
        menuEscolhaPersonagem.addActionListenerMage(new ChooseCharacterArcher());
       
        menuEscolhaPersonagem.addActionListenerGame(new GameInit());
       
        addKeyListener(this);
        addMouseListener(this);
        setTitle("title of the game");
        setSize(ComprimentoJanela, AlturaJanela);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        backBuffer = new BufferedImage(3*ComprimentoJanela, 3*AlturaJanela, BufferedImage.TYPE_INT_RGB);
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
        desenharFundo(bbg);
    }
 
    public void desenharFundo(Graphics bbg) {
        Image backGround = new ImageIcon("src/imagens/backTile.png").getImage();
        bbg.clearRect(0,0,ComprimentoJanela*3, 3*AlturaJanela);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
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
        if(camerax + ComprimentoJanela > 3*ComprimentoJanela)camerax = 2*ComprimentoJanela;
        if(cameray + AlturaJanela > 3*AlturaJanela)cameray = 2*AlturaJanela;
       
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
        new ObjetoParede(new Coordenada(0,0),new Coordenada(10,AlturaJanela*3),this.colisionHandler,this.updater);
        new ObjetoParede(new Coordenada(0,0),new Coordenada(ComprimentoJanela*3,10),this.colisionHandler,this.updater);
        new ObjetoParede(new Coordenada(0,AlturaJanela*3 - 10),new Coordenada(ComprimentoJanela*3,AlturaJanela*3),this.colisionHandler,this.updater);
        new ObjetoParede(new Coordenada(ComprimentoJanela*3 -10,0),new Coordenada(ComprimentoJanela*3,AlturaJanela*3),this.colisionHandler,this.updater);
    }
}
