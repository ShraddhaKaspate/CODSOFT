import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class InteractiveStudentCourseManagement extends Frame {
    // Lists to store student and course data
    private ArrayList<String> students = new ArrayList<>();
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> studentDetails = new ArrayList<>();
    private ArrayList<String> courseDetails = new ArrayList<>();
    
    // GUI components
    private TextField studentNameField, studentAgeField;
    private TextField courseNameField, courseDurationField;
    private List studentList;
    private List courseList;
    
    public InteractiveStudentCourseManagement() {
        // Frame setup
        setTitle("Student Course Management");
        setSize(500, 500);
        setLayout(new BorderLayout());
        
        // Add a panel for the student and course input section
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBackground(new Color(230, 230, 230));
        
        // Student name input
        Label studentLabel = new Label("Enter Student Name:");
        studentNameField = new TextField(20);
        studentNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Student age input
        Label studentAgeLabel = new Label("Enter Student Age:");
        studentAgeField = new TextField(20);
        studentAgeField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Course name input
        Label courseLabel = new Label("Enter Course Name:");
        courseNameField = new TextField(20);
        courseNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Course duration input
        Label courseDurationLabel = new Label("Enter Course Duration:");
        courseDurationField = new TextField(20);
        courseDurationField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        inputPanel.add(studentLabel);
        inputPanel.add(studentNameField);
        inputPanel.add(studentAgeLabel);
        inputPanel.add(studentAgeField);
        inputPanel.add(courseLabel);
        inputPanel.add(courseNameField);
        inputPanel.add(courseDurationLabel);
        inputPanel.add(courseDurationField);
        
        // Buttons Panel
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        Button addStudentButton = new Button("Add Student");
        addStudentButton.setFont(new Font("Arial", Font.BOLD, 14));
        addStudentButton.setBackground(new Color(100, 150, 255));
        addStudentButton.setForeground(Color.WHITE);
        
        Button addCourseButton = new Button("Add Course");
        addCourseButton.setFont(new Font("Arial", Font.BOLD, 14));
        addCourseButton.setBackground(new Color(100, 255, 100));
        addCourseButton.setForeground(Color.WHITE);
        
        Button removeCourseButton = new Button("Remove Course");
        removeCourseButton.setFont(new Font("Arial", Font.BOLD, 14));
        removeCourseButton.setBackground(new Color(255, 100, 100));
        removeCourseButton.setForeground(Color.WHITE);
        
        buttonPanel.add(addStudentButton);
        buttonPanel.add(addCourseButton);
        buttonPanel.add(removeCourseButton);
        
        // Student and Course List Panel
        Panel listPanel = new Panel();
        listPanel.setLayout(new GridLayout(1, 2, 20, 0));
        
        studentList = new List();
        studentList.setFont(new Font("Arial", Font.PLAIN, 12));
        studentList.setBackground(new Color(240, 240, 240));
        
        courseList = new List();
        courseList.setFont(new Font("Arial", Font.PLAIN, 12));
        courseList.setBackground(new Color(240, 240, 240));
        
        // Wrap the lists in ScrollPanes
        ScrollPane studentScroll = new ScrollPane();
        studentScroll.add(studentList);
        
        ScrollPane courseScroll = new ScrollPane();
        courseScroll.add(courseList);
        
        listPanel.add(studentScroll);
        listPanel.add(courseScroll);
        
        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(listPanel, BorderLayout.SOUTH);
        
        // Button actions
        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameField.getText();
                String studentAge = studentAgeField.getText();
                if (!studentName.isEmpty() && !studentAge.isEmpty()) {
                    String studentDetail = studentName + " (Age: " + studentAge + ")";
                    students.add(studentDetail);
                    studentDetails.add("Name: " + studentName + ", Age: " + studentAge);
                    studentList.add(studentDetail);
                    studentNameField.setText("");
                    studentAgeField.setText("");
                    JOptionPane.showMessageDialog(null, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both student name and age!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                String courseDuration = courseDurationField.getText();
                if (!courseName.isEmpty() && !courseDuration.isEmpty()) {
                    String courseDetail = courseName + " (Duration: " + courseDuration + ")";
                    courses.add(courseDetail);
                    courseDetails.add("Course: " + courseName + ", Duration: " + courseDuration);
                    courseList.add(courseDetail);
                    courseNameField.setText("");
                    courseDurationField.setText("");
                    JOptionPane.showMessageDialog(null, "Course added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both course name and duration!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        removeCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = courseList.getSelectedItem();
                if (selectedCourse != null) {
                    courses.remove(selectedCourse);
                    courseDetails.remove(selectedCourse);
                    courseList.remove(courseList.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, "Course removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a course to remove!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Window close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new InteractiveStudentCourseManagement();
    }
}
