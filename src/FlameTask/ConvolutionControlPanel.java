/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author David
 */
public class ConvolutionControlPanel extends JPanel {
    MyFlame myflame;
    Viewer viewer;
    ControlPanel controlPanel;
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    JFileChooser chooser;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    JLabel luminance, divisor;
    JSlider brightness, sliderdivisor;
    newEvents e = new newEvents();
    String ruta, filepath;

    public ConvolutionControlPanel(MyFlame myflame, Viewer viewer) {
        this.myflame = myflame;
        this.viewer = viewer;
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        this.setLayout(null);
        initComponents();
    }

    private void initComponents() {
        addButtons();
        addTextField();
        addLabels();
        addSlider();
    }

    private void addButtons() {
        btn0 = new JButton();
        btn0.setBounds(4, 4, 50, 50);
        ImageIcon left = new ImageIcon("src/Images/izqda.png");
        btn0.setIcon(new ImageIcon(left.getImage().getScaledInstance(btn0.
                getWidth(), btn0.getHeight(), Image.SCALE_SMOOTH)));
        btn0.setBorder(null);
        btn0.setBackground(null);
        btn0.setActionCommand("btn0");
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConvolutionControlPanel.this.removeAll();
                controlPanel = new ControlPanel(myflame, viewer);
                controlPanel.setBounds(0, 0, 400, 800);
                controlPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                ConvolutionControlPanel.this.add(controlPanel);
                controlPanel.setVisible(true);
                repaint();
            }
        });
        this.add(btn0);
        btn1 = new JButton();
        btn1.setBounds(4, 60, 196, 75);
        btn1.setBorder(null);
        btn1.setActionCommand("btn1");
        btn1.setText("Cambiar Fondo");
        btn1.addActionListener(e);
        this.add(btn1);

        btn2 = new JButton();
        btn2.setBounds(200, 60, 196, 75);
        btn2.setBorder(null);
        btn2.setActionCommand("btn2");
        btn2.setText("Original");
        btn2.addActionListener(e);
        this.add(btn2);

        btn3 = new JButton();
        btn3.setBounds(4, 135, 196, 75);
        btn3.setBorder(null);
        btn3.setActionCommand("btn3");
        btn3.setText("Bordes");
        btn3.addActionListener(e);
        this.add(btn3);

        btn4 = new JButton();
        btn4.setBounds(200, 135, 196, 75);
        btn4.setBorder(null);
        btn4.setActionCommand("btn4");
        btn4.setText("Nitidez");
        btn4.addActionListener(e);
        this.add(btn4);

        btn5 = new JButton();
        btn5.setBounds(4, 210, 196, 75);
        btn5.setBorder(null);
        btn5.setActionCommand("btn5");
        btn5.setText("Borde vertical");
        btn5.addActionListener(e);
        this.add(btn5);

        btn6 = new JButton();
        btn6.setBounds(200, 210, 196, 75);
        btn6.setBorder(null);
        btn6.setActionCommand("btn6");
        btn6.setText("Repujado");
        btn6.addActionListener(e);
        this.add(btn6);

        btn7 = new JButton();
        btn7.setBounds(4, 285, 196, 75);
        btn7.setBorder(null);
        btn7.setActionCommand("btn7");
        btn7.setText("Enfoque");
        btn7.addActionListener(e);
        this.add(btn7);

        btn8 = new JButton();
        btn8.setBounds(200, 285, 196, 75);
        btn8.setBorder(null);
        btn8.setActionCommand("btn8");
        btn8.setText("Desenfoque");
        btn8.addActionListener(e);
        this.add(btn8);

        btn9 = new JButton();
        btn9.setBounds(4, 360, 196, 75);
        btn9.setBorder(null);
        btn9.setActionCommand("btn9");
        btn9.setText("Personalizado");
        btn9.addActionListener(e);
        this.add(btn9);
    }
    
    private void addTextField() {
        tf1 = new JTextField();
        tf1.setText(String.valueOf(0));
        tf1.setBounds(20, 450, 40, 30);
        this.add(tf1);
        
        tf2 = new JTextField();
        tf2.setText(String.valueOf(0));
        tf2.setBounds(80, 450,40, 30);
        this.add(tf2);
        
        tf3 = new JTextField();
        tf3.setText(String.valueOf(0));
        tf3.setBounds(140, 450, 40, 30);
        this.add(tf3);
        
        tf4 = new JTextField();
        tf4.setText(String.valueOf(0));
        tf4.setBounds(20, 485, 40, 30);
        this.add(tf4);
        
        tf5 = new JTextField();
        tf5.setText(String.valueOf(0));
        tf5.setBounds(80, 485, 40, 30);
        this.add(tf5);
        
        tf6 = new JTextField();
        tf6.setText(String.valueOf(0));
        tf6.setBounds(140, 485, 40, 30);
        this.add(tf6);
        
        tf7 = new JTextField();
        tf7.setText(String.valueOf(0));
        tf7.setBounds(20, 520, 40, 30);
        this.add(tf7);
        
        tf8 = new JTextField();
        tf8.setText(String.valueOf(0));
        tf8.setBounds(80, 520, 40, 30);
        this.add(tf8);
        
        tf9 = new JTextField();
        tf9.setText(String.valueOf(0));
        tf9.setBounds(140, 520, 40, 30); 
        this.add(tf9);     
    }
    private void addLabels() {
        luminance = new JLabel("Pixels Flame");
        luminance.setForeground(Color.WHITE);
        luminance.setBounds(155, 565, 100, 20);
        luminance.setFont(new Font("calibri", 1, 16));
        this.add(luminance);
        
        divisor = new JLabel("Divisor");
        divisor.setForeground(Color.WHITE);
        divisor.setBounds(165, 650, 100, 20);
        divisor.setFont(new Font("calibri", 1, 16));
        this.add(divisor);
    }
    
    private void addSlider(){
        brightness = new JSlider(JSlider.HORIZONTAL, 0, 250, (int) myflame.viewer.flame.getBrightness());
        brightness.setBounds(45, 585, 300, 50);
        brightness.setInverted(false);
        brightness.setMinorTickSpacing(10);
        brightness.setMajorTickSpacing(25);
        brightness.setPaintTicks(true);
        brightness.setPaintLabels(true);
        brightness.addChangeListener(e);
        this.add(brightness); 
        
        sliderdivisor = new JSlider(JSlider.HORIZONTAL, 1, 10, (int) myflame.viewer.convolution.getDivisor());
        sliderdivisor.setBounds(45, 670, 300, 50);
        sliderdivisor.setInverted(false);
        sliderdivisor.setMajorTickSpacing(1);
        sliderdivisor.setPaintTicks(true);
        sliderdivisor.setPaintLabels(true);
        sliderdivisor.addChangeListener(e);
        this.add(sliderdivisor); 
    }

    private void FileChooser() {
        filepath = "";
        chooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPEG file", "jpg", "gif", "jfif", "jpeg");
        chooser.setFileFilter(filtrado);

        int respuesta = chooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            filepath = chooser.getSelectedFile().getPath();
            myflame.viewer.setFilepath(filepath);
        }
    }

    //Revisar Eventos están generados a partir de Statics
    private class newEvents implements ChangeListener, ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "btn1":
                    FileChooser();
                    break;

                case "btn2":
                    myflame.viewer.convolution.setKernelSelected(myflame.viewer.convolution.getKernelInicial());
                    myflame.viewer.flame.cleanFlame();
                    myflame.viewer.flame.setConvoluted(false);
                    
                    break;

                case "btn3":
                    myflame.viewer.convolution.setKernelSelected(myflame.viewer.convolution.getBordes());
                    myflame.viewer.flame.setConvoluted(true);
                    break;

                case "btn4":
                    myflame.viewer.convolution.setKernelSelected(myflame.viewer.convolution.getNitidez());
                    myflame.viewer.flame.setConvoluted(true);
                    break;

                case "btn5":
                    myflame.viewer.convolution.setKernelSelected(myflame.viewer.convolution.getBordesVerticales());
                    myflame.viewer.flame.setConvoluted(true);
                    break;

                case "btn6":
                    myflame.viewer.convolution.setKernelSelected(myflame.viewer.convolution.getRepujado());
                    myflame.viewer.flame.setConvoluted(true);
                    break;

                case "btn7":
                    myflame.viewer.convolution.setKernelSelected(myflame.viewer.convolution.getEnfoque());
                    myflame.viewer.flame.setConvoluted(true);
                    break;

                case "btn8":
                    myflame.viewer.convolution.setKernelSelected(myflame.viewer.convolution.getDesenfoque());
                    myflame.viewer.flame.setConvoluted(true);
                    break;
                case "btn9":
                    int matriz [][] = new int [3][3];
                    matriz[0][0] = Integer.parseInt(tf1.getText());
                    matriz[0][1] = Integer.parseInt(tf2.getText());
                    matriz[0][2] = Integer.parseInt(tf3.getText());
                    matriz[1][0] = Integer.parseInt(tf4.getText());
                    matriz[1][1] = Integer.parseInt(tf5.getText());
                    matriz[1][2] = Integer.parseInt(tf6.getText());
                    matriz[2][0] = Integer.parseInt(tf7.getText());
                    matriz[2][1] = Integer.parseInt(tf8.getText());
                    matriz[2][2] = Integer.parseInt(tf9.getText());
                    myflame.viewer.convolution.setPersonalizado(matriz);
                    myflame.viewer.convolution.setKernelSelected(myflame.viewer.convolution.getPersonalizado());
                    myflame.viewer.flame.setConvoluted(true);
                    break;
            }
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            myflame.viewer.flame.setBrightness(brightness.getValue());
            myflame.viewer.convolution.setDivisor(sliderdivisor.getValue());
        }
    }
}

