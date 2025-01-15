package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class EmployeeManagementUI extends JFrame {
    private JTextField fullNameField;
    private JTextField employeeIdField;
    private JTextField jobTitleField;
    private JTextField departmentField;
    private JTextField hireDateField;
    private JTextField employmentStatusField;
    private JTextField contactInfoField;
    private JTextField addressField;
    private JButton saveButton;
    private JButton deleteButton;

    public EmployeeManagementUI() {
        setTitle("Employee Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Full Name:"), gbc);
        fullNameField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(fullNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Employee ID:"), gbc);
        employeeIdField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(employeeIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Job Title:"), gbc);
        jobTitleField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(jobTitleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Department:"), gbc);
        departmentField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(departmentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Hire Date:"), gbc);
        hireDateField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(hireDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(new JLabel("Employment Status:"), gbc);
        employmentStatusField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(employmentStatusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(new JLabel("Contact Information:"), gbc);
        contactInfoField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(contactInfoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(new JLabel("Address:"), gbc);
        addressField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(addressField, gbc);

        JPanel buttonPanel = new JPanel(new MigLayout());
        saveButton = new JButton("Save");
        deleteButton = new JButton("Delete");
        buttonPanel.add(saveButton, "wrap");
        buttonPanel.add(deleteButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagementUI ui = new EmployeeManagementUI();
            ui.setVisible(true);
        });
    }
}