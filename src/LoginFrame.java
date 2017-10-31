import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    private JLabel jlid =new JLabel("ID");
    private JLabel jlpw =new JLabel("Password");
    private JTextField jtid=new JTextField();
    private JPasswordField jtpw=new JPasswordField();
    private Button btexit=new Button("Exit");
    private Button btlogin=new Button("Login");
    private Container cp;
    private Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=300,frmH=150,screenW=dim.width,screenH=dim.height;
    LoginFrame(){
        initComp();
    }
    private  void initComp(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        cp.add(jlid);
        cp.add(jtid);
        cp.add(jlpw);
        cp.add(jtpw);
        cp.add(btexit);
        cp.add(btlogin);
        jlid.setHorizontalAlignment(JLabel.RIGHT);
        jlpw.setHorizontalAlignment(JLabel.RIGHT);
        btlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtid.getText().equals("h304")&& new String(jtpw.getPassword()).equals("23323456")){
                    MainFrame mFrm=new MainFrame(LoginFrame.this);
                    mFrm.setVisible(true);
                    LoginFrame.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        btexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}