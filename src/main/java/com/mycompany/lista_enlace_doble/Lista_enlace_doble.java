/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lista_enlace_doble;

/**
 *
 * @author pc
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Enlace_nodos.Captura;

public class Lista_enlace_doble {

    public static void main(String[] args) {
        Captura obj = new Captura();

        JFrame frame = new JFrame("Lista Enlace Doble");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JButton btnGenerar = new JButton("Generar Enlace");
        JButton btnImprimir = new JButton("Imprimir");
        JButton btnEliminarNodo = new JButton("Eliminar Nodo");
        JButton btnEliminarPrimerosN = new JButton("Eliminar Primeros N Nodos");
        JButton btnSalir = new JButton("Salir");

        btnGenerar.setBounds(100, 20, 200, 30);
        btnImprimir.setBounds(100, 60, 200, 30);
        btnEliminarNodo.setBounds(100, 100, 200, 30);
        btnEliminarPrimerosN.setBounds(100, 140, 200, 30);
        btnSalir.setBounds(100, 180, 200, 30);

        frame.add(btnGenerar);
        frame.add(btnImprimir);
        frame.add(btnEliminarNodo);
        frame.add(btnEliminarPrimerosN);
        frame.add(btnSalir);

        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj.Generacion_enlace();
                JOptionPane.showMessageDialog(frame, "Enlace generado.");
            }
        });

        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                
                obj.imprimir();

            }
        });

        btnEliminarNodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Ingrese el número del nodo a eliminar:");
                if (input != null) {
                    try {
                        int numero = Integer.parseInt(input);
                        obj.eliminarPorNumero(numero);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Entrada inválida.");
                    }
                }
            }
        });

        btnEliminarPrimerosN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Ingrese la cantidad de nodos a eliminar desde el inicio:");
                if (input != null) {
                    try {
                        int n = Integer.parseInt(input);
                        if (n > 0) {
                            obj.eliminarPrimerosN(n);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Ingrese un número mayor a 0.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Entrada inválida.");
                    }
                }
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
