import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoList extends JFrame implements ActionListener {
    private DefaultListModel<String> listModel;
    private JList<String> todoJList;
    private JTextField inputField;
    private JButton addButton, removeButton;

    public TodoList() {
        setTitle("Todo List");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        todoJList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(todoJList);

        inputField = new JTextField();
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(this);
        removeButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = inputField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                inputField.setText("");
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = todoJList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new TodoList();
    }
}
