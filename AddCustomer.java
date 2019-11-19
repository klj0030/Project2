import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer {

    public JFrame view;

    public JButton btnAdd = new JButton("Add");
    public JButton btnCancel = new JButton("Cancel");

    public JTextField txtCustID = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPhone = new JTextField(20);


    public AddCustomer()   {
        this.view = new JFrame();

        view.setTitle("Add New Customer");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        String[] labels = {"CustID ", "Name ", "Phone "};

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("CustID "));
        line1.add(txtCustID);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("Name "));
        line2.add(txtName);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Price "));
        line3.add(txtPhone);
        view.getContentPane().add(line3);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAdd);
        panelButtons.add(btnCancel);
        view.getContentPane().add(panelButtons);

        btnAdd.addActionListener(new AddButtonListener());

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                view.dispose();
            }
        });

    }

    public void run() {
        view.setVisible(true);
    }

    class AddButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            CustomerModel cust = new CustomerModel();

            String id = txtCustID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "CustID cannot be null!");
                return;
            }

            try {
                cust.mCustomerID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "CustID is invalid!");
                return;
            }

            String name = txtName.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Customer name cannot be empty!");
                return;
            }

            cust.mName = name;

            String phone = txtPhone.getText();
            try {
                cust.mPhone = phone;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Phone is invalid!");
                return;
            }
            cust.mAddress = "default";

            switch (StoreManager.getInstance().getDataAdapter().saveCustomer(cust)) {
                case SQLiteDataAdapter.PRODUCT_DUPLICATE_ERROR:
                    JOptionPane.showMessageDialog(null, "Customer NOT added successfully! Duplicate product ID!");
                default:
                    JOptionPane.showMessageDialog(null, "Customer added successfully!" + cust);
            }
        }
    }

}