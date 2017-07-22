/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import jogopoo.Control.EntidadeController;
import jogopoo.Engine.*;
import jogopoo.Model.Coordenada;
import jogopoo.Model.PersonagemModel;
import jogopoo.Model.SimpleFactoryPersonagem;
import jogopoo.Model.SubjectPosPers;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;
/**
 *
 * @author tiago
 */
public class Application extends JFrame implements KeyListener,MouseListener{
    private BufferedImage backBuffer;
    private boolean gamePaused = false;
    private final int FPS = 30;
    private Updater updater;
    private static final int AlturaJanela = 450;
    private static final int ComprimentoJanela = 550;
    public static boolean teclas[] = new boolean[1024];
    public static boolean mouse = false;
    public static Application Application;
    public static Graphics bbg;
    ///testes camera
        private int camerax = 0;
        private int cameray = 0;
    ///termina testes
    
    public static void main(String[] args)  {
	Application.Application = new Application();
	Application.Mainloop();	
    }
    public void Mainloop() {
        inicializar();
        while (true) {
            if (gamePaused) {
                try {
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
        addKeyListener(this);
        addMouseListener(this);
        setTitle("title of the game");
        setSize(ComprimentoJanela, AlturaJanela);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        backBuffer = new BufferedImage(3*ComprimentoJanela, 3*AlturaJanela, BufferedImage.TYPE_INT_RGB);
        updater = new Updater();
        //p = new Personagem();
        EntidadeView entView = new EntidadeView();
        PersonagemModel persModel;
        persModel = SimpleFactoryPersonagem.CriarPersonagem("Mago", entView,new Coordenada(50,50),new SubjectPosPers());
        EntidadeController Personagem = new EntidadeController(entView, persModel, updater);
        
    }
    public void atualizar() {
        updater.notificarObservadores();
        if(teclas[KeyEvent.VK_RIGHT])camerax++;
        if(teclas[KeyEvent.VK_LEFT])camerax--;
        if(teclas[KeyEvent.VK_DOWN])cameray++;
        if(teclas[KeyEvent.VK_UP])cameray--;
    }
    public void desenharGraficos() {
        Graphics g = getGraphics();//COM g IREMOS DESENHAR O QUE ESTA NO BUFFER NA TELA
        bbg = backBuffer.getGraphics();//COM bbg IREMOS DESENHAR NO NOSSO BUFFER

        desenharFundo(bbg);
        
        
        //AQUI ESTAMOS DESENHANDO O BUFFER NA TELA,    
        g.drawImage(backBuffer, -camerax, -cameray, this);
    }

    public void desenharFundo(Graphics bbg) {
        //Image backGround = new ImageIcon("src/Imagens/backTile.png").getImage();
        bbg.clearRect(0,0,ComprimentoJanela, AlturaJanela);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                //bbg.drawString("n"+i+j, i*ComprimentoJanela/10, j*AlturaJanela/10);
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
}
