import javax.swing.JOptionPane;

public class Solve{
    public static void main(String[] args){
        
        String choice;
        choice = JOptionPane.showInputDialog(null, "Choose 1, 2 or 3 to solve math: ", "Choice", JOptionPane.INFORMATION_MESSAGE);
        
        switch (choice){
            case "1":
                String strNum1, strNum2;
                strNum1 = JOptionPane.showInputDialog(null, "Solve for ax + b = 0 \nPlease input a: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                
                strNum2 = JOptionPane.showInputDialog(null, "Solve for ax + b = 0 \nPlease input b: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
               

                double a = Double.parseDouble(strNum1);
                double b = Double.parseDouble(strNum2);

                if(a == 0){
                    JOptionPane.showMessageDialog(null, "Can not solve for a = 0", "Solve", JOptionPane.INFORMATION_MESSAGE);
                }

                else{
                    double x = -b/a;
                    JOptionPane.showMessageDialog(null, "Result: " + x, "Solve", JOptionPane.INFORMATION_MESSAGE);
                }
                String cont;
                cont = JOptionPane.showInputDialog(null, "Continue?\n Press 'y' to continue or 'n' to exit");
                if(cont.equals("y")){
                    JOptionPane.showMessageDialog(null, "OK, let's continue", "ok", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "OK, bye", "BYE", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                break;
            case "2":
                String aa1, aa2, bb1, bb2, cc1, cc2;
                aa1 = JOptionPane.showInputDialog(null, "Solve for: \na1.x + b1.y = c1 \na2.x + b2.y = c2\n--------------\nPlease input a1: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                bb1 = JOptionPane.showInputDialog(null, "Solve for: \na1.x + b1.y = c1 \na2.x + b2.y = c2\n--------------\nPlease input b1: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                cc1 = JOptionPane.showInputDialog(null, "Solve for: \na1.x + b1.y = c1 \na2.x + b2.y = c2\n--------------\nPlease input c1: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                aa2 = JOptionPane.showInputDialog(null, "Solve for: \na1.x + b1.y = c1 \na2.x + b2.y = c2\n--------------\nPlease input a2: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                bb2 = JOptionPane.showInputDialog(null, "Solve for: \na1.x + b1.y = c1 \na2.x + b2.y = c2\n--------------\nPlease input b2: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                cc2 = JOptionPane.showInputDialog(null, "Solve for: \na1.x + b1.y = c1 \na2.x + b2.y = c2\n--------------\nPlease input c2: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                double a1, a2, b1, b2, c1, c2, d, dx, dy;
                a1 = Double.parseDouble(aa1);
                b1 = Double.parseDouble(bb1);
                c1 = Double.parseDouble(cc1);
                a2 = Double.parseDouble(aa2);
                b2 = Double.parseDouble(bb2);
                c2 = Double.parseDouble(cc2);
                d = a1*b2 - a2*b1;
                dx = c1*b2 - c2*b1;
                dy = a1*c2 - a2*c1;
                double x, y;

                if(d == 0){
                    if( dx != 0 | dy != 0 ){
                        JOptionPane.showMessageDialog(null, "Don't have any results !!" , "Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Many results !!!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Result: x = " + dx/d + " and y = " + dy/d, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "3":
                String aa,bb,cc;
                aa = JOptionPane.showInputDialog(null, "Solve for a.x^2 + b.x + c = 0\n ------------ \n Please input a: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                bb = JOptionPane.showInputDialog(null, "Solve for a.x^2 + b.x + c = 0\n ------------ \n Please input b: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                cc = JOptionPane.showInputDialog(null, "Solve for a.x^2 + b.x + c = 0\n ------------ \n Please input c: ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
                double _a, _b, _c, delta;
                _a = Double.parseDouble(aa);
                _b = Double.parseDouble(bb);
                _c = Double.parseDouble(cc);
                
                delta = _b*_b - 4*_a*_c;

                if(delta < 0){
                    JOptionPane.showMessageDialog(null, "No result", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(delta == 0){
                    JOptionPane.showMessageDialog(null, "x = " + -_b/(2*_a), "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "x1 = " + (-_b-Math.sqrt(delta))/(2*_a) + 
                    "\nx2 = " + (-_b+Math.sqrt(delta))/(2*_a), "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, " !!! ", "Choice", JOptionPane.INFORMATION_MESSAGE);

        }
        
    }
}