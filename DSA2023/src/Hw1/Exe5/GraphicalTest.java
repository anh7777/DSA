package Hw1.Exe5;
// bài tập thuộc Project P-1.30 sách M.Goodrich, trang 57

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalTest extends JFrame {
    private CreditCard card;
    private JTextField customerField, bankField, accountField, limitField, balanceField, chargeField, paymentField;
    private JLabel statusLabel;

    public GraphicalTest() {
        // Thiết lập thông tin giao diện
        setTitle("Credit Card Test");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        // Các trường nhập liệu
        customerField = new JTextField();
        bankField = new JTextField();
        accountField = new JTextField();
        limitField = new JTextField();
        balanceField = new JTextField();
        chargeField = new JTextField();
        paymentField = new JTextField();

        // Nhãn và nút
        add(new JLabel("Customer:"));
        add(customerField);
        add(new JLabel("Bank:"));
        add(bankField);
        add(new JLabel("Account:"));
        add(accountField);
        add(new JLabel("Limit:"));
        add(limitField);
        add(new JLabel("Balance:"));
        add(balanceField);

        JButton createButton = new JButton("Create Card");
        add(createButton);

        // Nút tạo thẻ tín dụng
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customer = customerField.getText();
                String bank = bankField.getText();
                String account = accountField.getText();
                int limit = Integer.parseInt(limitField.getText());
                double balance = Double.parseDouble(balanceField.getText());

                card = new CreditCard(customer, bank, account, limit, balance);
                statusLabel.setText("Credit card created successfully!");
            }
        });

        // Các trường liên quan đến giao dịch
        add(new JLabel("Charge Amount:"));
        add(chargeField);
        JButton chargeButton = new JButton("Charge");
        add(chargeButton);

        chargeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(chargeField.getText());
                if (card.charge(amount)) {
                    statusLabel.setText("Charge successful! New Balance: " + card.getBalance());
                } else {
                    statusLabel.setText("Charge failed. Exceeded limit!");
                }
            }
        });

        add(new JLabel("Payment Amount:"));
        add(paymentField);
        JButton paymentButton = new JButton("Make Payment");
        add(paymentButton);

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(paymentField.getText());
                card.makePayment(amount);
                statusLabel.setText("Payment successful! New Balance: " + card.getBalance());
            }
        });

        // Nhãn hiển thị trạng thái
        statusLabel = new JLabel("Welcome to Credit Card Test");
        add(statusLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GraphicalTest();
    }
}
