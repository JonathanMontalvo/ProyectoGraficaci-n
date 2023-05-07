/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static org.yourorghere.Main.regresoMenu;
import static org.yourorghere.Main.reiniciar;
/**
 *
 * @author Jonathan Montalvo Pérez
 */
public class Ventanas extends JFrame
{

    public Ventanas()
    {
    }

    public Ventanas(String titulo, int ancho, int alto, boolean maximizar)
    {
        // Establece el tamaño de la ventana
        setSize(ancho, alto);

        // Establece el estilo para no mostrar los botones de minimizar, maximizar y cerrar
        setResizable(maximizar);
        setUndecorated(true);

        // Crea un JPanel para contener el título
        JPanel panelTitulo = new JPanel(new GridBagLayout());
        panelTitulo.setBackground(java.awt.Color.WHITE);
        panelTitulo.setPreferredSize(new java.awt.Dimension(ancho, 30));

        // Agrega un JLabel con el título al panel de título
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setForeground(java.awt.Color.BLACK);
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelTitulo.add(lblTitulo, gbc);

        // Establece la posición de la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        // Establece solo se cierre la ventada y no todas la ventanas
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Agrega a la ventana el panel de título
        add(panelTitulo, "North");
    }

    public void ventanaFinNivel1_2()
    {
        // Crear el panel con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(java.awt.Color.GREEN); // Cambiar el color de fondo del panel

        // Hacer que el fondo del panel cambie
        panel.setOpaque(true);

        // Crear el JLabel y los JButton
        JLabel label = new JLabel("¿Elija una opción?");
        JButton boton1 = new JButton("Siguiente Nivel");
        JButton boton2 = new JButton("Regresar Menu");

        label.setFont(new Font("Comic Sans MS", Font.BOLD, 36)); // Cambiar tipo de letra, estilo y tamaño de fuente del label
        boton1.setFont(new Font(label.getFont().getName(), Font.PLAIN, 30)); // Cambiar tamaño de fuente del boton
        boton2.setFont(new Font(boton1.getFont().getName(), Font.PLAIN, 30)); // Cambiar tamaño de fuente del boton

        // Crear un objeto GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();

        // Configurar el JLabel en la primera fila
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = gbc.anchor = GridBagConstraints.NORTH;
        panel.add(label, gbc);

        // Configurar el Botón 1 en la segunda fila
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 10, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(boton1, gbc);

        // Configurar el Botón 2 en la segunda fila
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 5, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(boton2, gbc);

        // Agregar el panel a la ventana
        add(panel);

        //Mostrar la ventana
        setVisible(true);

        // Agregar listeners a los botones
        boton1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Cargando Nivel 2");
                dispose();
            }
        });

        boton2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                regresoMenu();
                dispose();
            }
        });
    }

    public void ventanaPerdio()
    {
        // Crear el panel con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(java.awt.Color.red); // Cambiar el color de fondo del panel

        // Hacer que el fondo del panel cambie
        panel.setOpaque(true);

        // Crear el JLabel y los JButton
        JLabel label = new JLabel("¿Elija una opción?");
        JButton boton1 = new JButton("Reintentar Nivel");
        JButton boton2 = new JButton("Regresar Menu");

        label.setFont(new Font("Comic Sans MS", Font.BOLD, 36)); // Cambiar tipo de letra, estilo y tamaño de fuente del label
        boton1.setFont(new Font(label.getFont().getName(), Font.PLAIN, 30)); // Cambiar tamaño de fuente del boton
        boton2.setFont(new Font(boton1.getFont().getName(), Font.PLAIN, 30)); // Cambiar tamaño de fuente del boton

        // Crear un objeto GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();

        // Configurar el JLabel en la primera fila
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = gbc.anchor = GridBagConstraints.NORTH;
        panel.add(label, gbc);

        // Configurar el Botón 1 en la segunda fila
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 10, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(boton1, gbc);

        // Configurar el Botón 2 en la segunda fila
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 5, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(boton2, gbc);

        // Agregar el panel a la ventana
        add(panel);

        //Mostrar la ventana
        setVisible(true);

        // Agregar listeners a los botones
        boton1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                reiniciar();
                dispose();
            }
        });

        boton2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                regresoMenu();
                dispose();
            }
        });
    }
}