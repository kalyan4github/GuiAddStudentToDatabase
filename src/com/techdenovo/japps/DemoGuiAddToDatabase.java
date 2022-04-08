package com.techdenovo.japps;

import com.techdenovo.japps.model.Student;
import com.techdenovo.japps.utils.DbConnectionUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoGuiAddToDatabase {
    public void addStudent(Student student){
        Connection con = new DbConnectionUtils().getDbConnection();
        String query= "INSERT INTO `testdb`.`STUDENTS` (`FIRST_NAME`, `LAST_NAME`, `COLLEGE_NAME`) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setString(3,student.getCollegeName());
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public DemoGuiAddToDatabase() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth= (int)size.getWidth();
        int screeHeight= (int)size.getHeight();
        JFrame frame = new JFrame("Add Student");
        frame.setBounds(screenWidth/3,screeHeight/3,500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblFirstName = new JLabel("First Name");
        JLabel lblLastName = new JLabel("Last Name");
        JLabel lblCollegeName = new JLabel("College Name");
        lblFirstName.setBounds(100,50,150,20);
        lblLastName.setBounds(100,80,150,20);
        lblCollegeName.setBounds(100,110,150,20);

        JTextField txtFirstName =new JTextField();
        JTextField txtLastName =new JTextField();
        JTextField txtCollegeName =new JTextField();
        txtFirstName.setBounds(200,50,150,20);
        txtLastName.setBounds(200,80,150,20);
        txtCollegeName.setBounds(200,110,150,20);

        JButton btnAddStudent= new JButton("ADD STUDENT");
        btnAddStudent.setBounds(100,150,250,30);
        btnAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String collegeName = txtCollegeName.getText();

                Student student = new Student(firstName,lastName,collegeName);
                addStudent(student);

            }
        });

        frame.add(lblFirstName);
        frame.add(lblLastName);
        frame.add(lblCollegeName);

        frame.add(txtFirstName);
        frame.add(txtLastName);
        frame.add(txtCollegeName);

        frame.add(btnAddStudent);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DemoGuiAddToDatabase demoGuiAddToFile = new DemoGuiAddToDatabase();
    }
}
