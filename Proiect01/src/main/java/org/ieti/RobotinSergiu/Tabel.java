package org.ieti.RobotinSergiu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tabel implements ActionListener {


    String[][] data =
            {{"2002", "Robotin Sergiu", "Germania"},
            {"1991", "Simona Halep", "Tenis de camp"},
            {"1984", "Lebron James", "Baschet"},
            {"1980", "Marian Dragulescu", "Gimnastica"}};
    String column[] = {"Anul nasterii", "Nume Prenume", "Sportul Practicat"};

    JFrame f;
    JLabel l;
    JTable jTable;
    JScrollPane sp;
    JButton button = new JButton("Add");
    JButton button2 = new JButton("Delete");
    JButton button3 = new JButton("Edit");
    JButton button4 = new JButton("Search");
    DefaultTableModel defaultTableModel;


    Tabel() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JTextField anField = new JTextField(10);
                final JTextField numeField = new JTextField(10);
                final JTextField sportField = new JTextField(10);
                JPanel pane = new JPanel(new GridBagLayout());
                GridBagConstraints gridBagConstraints = new GridBagConstraints();
                GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                        GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 3, 2), 0, 0);

                pane.add(new JLabel("Anul nasterii:"), gbc);
                gbc.gridy = 1;
                pane.add(new JLabel("Nume Prenume:"), gbc);
                gbc.gridy = 2;
                pane.add(new JLabel("Sportul Practicat:"), gbc);
                gbc.gridy = 3;

                gbc.gridx = 1;
                gbc.gridy = 0;
                pane.add(anField, gbc);
                gbc.gridy = 1;
                pane.add(numeField, gbc);
                gbc.gridy = 2;
                pane.add(sportField, gbc);
                gbc.gridy = 3;


                int reply = JOptionPane.showConfirmDialog(null, pane, "Introducere date",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (reply == JOptionPane.OK_OPTION) {
                    String an = anField.getText();
                    String nume = numeField.getText();
                    String sport = sportField.getText();


                    String[] newData = {an, nume, sport,};
                    defaultTableModel.addRow(newData);
                    jTable.validate();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jTable.getSelectedRow() != -1) {
                    defaultTableModel.removeRow(jTable.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Linie stearsa");
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTable.getSelectedRow() != -1) {
                    final JTextField anField = new JTextField(10);
                    final JTextField numeField = new JTextField(10);
                    final JTextField sportField = new JTextField(10);
                    JPanel pane = new JPanel(new GridBagLayout());
                    GridBagConstraints gridBagConstraints = new GridBagConstraints();
                    GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                            GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                            new Insets(2, 2, 3, 2), 0, 0);

                    pane.add(new JLabel("Anul nasterii:"), gbc);
                    gbc.gridy = 1;
                    pane.add(new JLabel("Nume Prenume:"), gbc);
                    gbc.gridy = 2;
                    pane.add(new JLabel("Sportul Practicat:"), gbc);


                    gbc.gridx = 1;
                    gbc.gridy = 0;
                    pane.add(anField, gbc);
                    gbc.gridy = 1;
                    pane.add(numeField, gbc);
                    gbc.gridy = 2;
                    pane.add(sportField, gbc);



                    int reply = JOptionPane.showConfirmDialog(null, pane, "Introducere date",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (reply == JOptionPane.OK_OPTION) {
                        String an = anField.getText();
                        String nume = numeField.getText();
                        String sport = sportField.getText();


                        defaultTableModel.setValueAt(an, jTable.getSelectedRow(), 0);
                        defaultTableModel.setValueAt(nume, jTable.getSelectedRow(), 1);
                        defaultTableModel.setValueAt(sport, jTable.getSelectedRow(), 2);

                        jTable.validate();
                    }
                }
            }
        });

        f = new JFrame();
        f.add(button);
        f.add(button2);
        f.add(button3);
        f.add(button4);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        defaultTableModel = new DefaultTableModel(data, column);
        jTable = new JTable(defaultTableModel);
        jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable.setBounds(30, 40, 200, 300);
        sp = new JScrollPane(jTable);
        f.getContentPane().setLayout(new FlowLayout());
        f.add(sp);
        f.setSize(500, 700);
        f.setVisible(true);
        f.getContentPane().setLayout(new FlowLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


    public static void main(String[] args){

        new Tabel();
    }
}