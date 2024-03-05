package org.view;

import org.model.Operatii;
import org.model.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interfata extends JFrame {

    //constructor interfata
    public Interfata() {
        JFrame frame = new JFrame("Calculator polinomial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 350);

        Color c1 = new Color(255, 152, 102);

        JPanel panel = new JPanel();
        panel.setBackground(c1);
        panel.setPreferredSize(new Dimension(400, 600));
        panel.setLayout(null);

        JLabel calculator = new JLabel("Calculator");
        calculator.setBounds(300, 10, 100, 30);
        panel.add(calculator);
        calculator.setFont(new Font("Times New Roman", Font.BOLD, 17));

        JLabel polinom1 = new JLabel("Polinom 1:");
        polinom1.setBounds(30, 100, 100, 30);
        panel.add(polinom1);
        polinom1.setFont(new Font("Times New Roman", Font.ITALIC, 17));

        JLabel polinom2 = new JLabel("Polinom 2:");
        polinom2.setBounds(30, 150, 100, 30);
        panel.add(polinom2);
        polinom2.setFont(new Font("Times New Roman", Font.ITALIC, 17));

        JLabel rezultat = new JLabel("Rezultat:");
        rezultat.setBounds(30, 200, 100, 30);
        panel.add(rezultat);
        rezultat.setFont(new Font("Times New Roman", Font.ITALIC, 17));

        JTextField p1 = new JTextField();
        p1.setBounds(150, 100, 200, 30);
        panel.add(p1);
        p1.setBorder(BorderFactory.createLineBorder(Color.red, 2));

        JTextField p2 = new JTextField();
        p2.setBounds(150, 150, 200, 30);
        panel.add(p2);
        p2.setBorder(BorderFactory.createLineBorder(Color.red, 2));

        JTextField rez = new JTextField();
        rez.setBounds(150, 200, 200, 30);
        panel.add(rez);
        rez.setBorder(BorderFactory.createLineBorder(Color.red, 2));

        Color c2 = new Color(255, 255, 204);

        JButton adunare = new JButton("Adunare");
        adunare.setBounds(400, 100, 100, 30);
        panel.add(adunare);
        adunare.setBackground(c2);
        adunare.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //action listener adunare
        adunare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent sum) {
                    //iau polinom 1 si 2 din text field
                    String p1Input = p1.getText();
                    String p2Input = p2.getText();

                    //parsez
                    Polinom p1 = Operatii.parsare(p1Input);
                    Polinom p2 = Operatii.parsare(p2Input);

                    //aplic suma
                    Polinom rezultat = Operatii.suma(p1, p2);

                    //afisez rezultatul
                    String rezultatString = rezultat.printPolinom();
                    //System.out.println(rezultatString);
                    rez.setText(rezultatString);
            }
        });

        JButton scadere = new JButton("Scadere");
        scadere.setBounds(400, 150, 100, 30);
        panel.add(scadere);
        scadere.setBackground(c2);
        scadere.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //action listener scadere
        scadere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent dif) {
                    //iau polinom 1 si 2 din text field
                    String p1Input = p1.getText();
                    String p2Input = p2.getText();

                    //parsez
                    Polinom p1 = Operatii.parsare(p1Input);
                    Polinom p2 = Operatii.parsare(p2Input);

                    //aplic diferenta
                    Polinom rezultat = Operatii.diferenta(p1, p2);

                    //afisez rezultatul
                    String rezultatString = rezultat.printPolinom();
                    rez.setText(rezultatString);
            }
        });

        JButton inmultire = new JButton("Inmultire");
        inmultire.setBounds(400, 200, 100, 30);
        panel.add(inmultire);
        inmultire.setBackground(c2);
        inmultire.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //action listener produs
        inmultire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent imn) {
                    //iau polinom 1 si 2 din text field
                    String p1Input = p1.getText();
                    String p2Input = p2.getText();

                    //parsez
                    Polinom p1 = Operatii.parsare(p1Input);
                    Polinom p2 = Operatii.parsare(p2Input);

                    //aplic produs
                    Polinom rezultat = Operatii.produs(p1, p2);

                    //afisez rezultatul
                    String rezultatString = rezultat.printPolinom();
                    rez.setText(rezultatString);
            }
        });

        JButton impartire = new JButton("Impartire");
        impartire.setBounds(550, 100, 100, 30);
        panel.add(impartire);
        impartire.setBackground(c2);
        impartire.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //action listener impartire
        impartire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent imp) {
                try {
                    //iau polinom 1 si 2 din text field
                    String p1Input = p1.getText();
                    String p2Input = p2.getText();

                    if(p1Input != null && p2Input != null){
                        throw new Exception("Ups... impartirea nu a fost implementata :(");
                    }

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });

        JButton derivata = new JButton("Derivata");
        derivata.setBounds(550, 150, 100, 30);
        panel.add(derivata);
        derivata.setBackground(c2);
        derivata.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //action listener derivata
        derivata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent deriv) {
                    //iau un polinom din text field
                    String p1Input = "";
                    if (!p1.getText().isEmpty()) {
                        p1Input = p1.getText();
                    } else {
                        p1Input = p2.getText();
                    }

                    //parsez
                    Polinom p1 = Operatii.parsare(p1Input);

                    //aplic derivata
                    Polinom rezultat = Operatii.derivat(p1);

                    //afisez rezultatul
                    String rezultatString = rezultat.printPolinom();
                    rez.setText(rezultatString);
            }
        });

        JButton integrala = new JButton("Integrala");
        integrala.setBounds(550, 200, 100, 30);
        panel.add(integrala);
        integrala.setBackground(c2);
        integrala.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //action listener integrala
        integrala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent integr) {
                    //iau un polinom din text field
                    String p1Input = "";
                    if (!p1.getText().isEmpty()) {
                        p1Input = p1.getText();
                    } else {
                        p1Input = p2.getText();
                    }

                    //parsez
                    Polinom p1 = Operatii.parsare(p1Input);

                    //aplic integrala
                    Polinom rezultat = Operatii.integrala(p1);

                    //afisez rezultatul
                    String rezultatString = rezultat.printPolinom();
                    if (rezultatString != null) {
                        rezultatString += "+c";
                    }
                    rez.setText(rezultatString);
            }
        });

        JButton reset = new JButton("Reset");
        reset.setBounds(200, 250, 100, 30);
        panel.add(reset);
        reset.setBackground(c2);
        reset.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //action listener reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent reset) {
                p1.setText("");
                p2.setText("");
                rez.setText("");
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

}
