import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ReminderSet {
    private JFrame frame;
    private JTextField userField, passField, reminderField;
    private JList<String> reminderList;
    private DefaultListModel<String> listModel;
    private ArrayList<String> reminders = new ArrayList<>();
    private JLabel l1,l2;


    public ReminderSet() {
        frame = new JFrame("Login Page");
        JLabel userLabel = new JLabel("Username:");
        userField = new JTextField(10);
        JLabel passLabel = new JLabel("Password:");
        passField = new JPasswordField(10);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userField.getText().equals("vikas") && passField.getText().equals("@vk123")) {
                    showReminderPage();
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect Username or Password");
                }
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void showReminderPage() {
        frame.getContentPane().removeAll();
        frame.setTitle("Reminders Page");

        l1= new JLabel("Welcome to the Reminder Application");
        l1.setBounds(50,50,50,50);

        l2= new JLabel("Today is Friday, 9th of September");
        l2.setBounds(50,100,50,50);

        reminderField = new JTextField(5);
        JButton setButton = new JButton("Set Reminder");
        JButton modifyButton = new JButton("Modify Reminder");
        JButton deleteButton = new JButton("Delete Reminder");
        JButton enableButton = new JButton("Enable Reminder");
        JButton disableButton = new JButton("Disable Reminder");
        listModel = new DefaultListModel<>();
        reminderList = new JList<>(listModel);

        setButton.addActionListener(e -> {
            reminders.add(reminderField.getText());
            listModel.addElement(reminderField.getText());
        });

        modifyButton.addActionListener(e -> {
            int index = reminderList.getSelectedIndex();
            if (index != -1) {
                reminders.set(index, reminderField.getText());
                listModel.set(index, reminderField.getText());
            }
        });

        deleteButton.addActionListener(e -> {
            int index = reminderList.getSelectedIndex();
            if (index != -1) {
                reminders.remove(index);
                listModel.remove(index);
            }
        });

        enableButton.addActionListener(e -> {
            reminders.add(reminderField.getText());
            listModel.addElement(reminderField.getText());
        });

        disableButton.addActionListener(e -> {
            int index = reminderList.getSelectedIndex();
            if (index != -1) {
                reminders.remove(index);
                listModel.remove(index);
            }
        });


        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(l1);
        frame.add(l2);
        frame.add(reminderField);
        frame.add(setButton);
        frame.add(modifyButton);
        frame.add(deleteButton);
        frame.add(enableButton);
        frame.add(disableButton);
        frame.add(new JScrollPane(reminderList));
        frame.setVisible(true);
        frame.pack();

    }

    public static void main(String[] args) {
        new ReminderSet();
    }
}