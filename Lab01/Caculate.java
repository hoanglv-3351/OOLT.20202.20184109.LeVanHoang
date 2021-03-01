import javax.swing.JOptionPane;

public class Caculate{
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ",
        "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ",
        "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        // JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        // System.exit(0);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double Tong = num1 + num2;
        double Tich = num1 * num2;
        double Hieu = num1 - num2;
        double Thuong = num1/num2;

        JOptionPane.showMessageDialog(null, "Tong la "+ Tong);
        JOptionPane.showMessageDialog(null, "Hieu la "+ Hieu);
        JOptionPane.showMessageDialog(null, "Tich la "+ Tich);
        JOptionPane.showMessageDialog(null, "Thuong la "+ Thuong);
        System.exit(0);
    }
}