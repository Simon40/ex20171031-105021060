import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private int screenW= Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH= Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW=500,frmH=400;
    private JMenuBar jmb=new JMenuBar();
    private JMenu jmF=new JMenu("File");
    private JMenu jmR=new JMenu("Setting");
    private JMenu jmA=new JMenu("Game");
    private JMenu jmM=new JMenu("About");
    private JMenuItem jMexit=new JMenuItem("Exit");
    private JMenuItem jMscreen=new JMenuItem("Loto");
    private JMenuItem jmi=new JMenuItem("Font");
    private JDesktopPane jdp=new JDesktopPane();
    private JInternalFrame jif=new JInternalFrame();
    private String[] options={"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    private JComboBox jcb=new JComboBox(options);
    private JLabel jb1=new JLabel("字型");
    private JLabel jb2=new JLabel("字體");
    private JLabel jb3=new JLabel("大小");
    private TextField tf1=new TextField();
    private TextField tf2=new TextField();
    private JPanel jp1=new JPanel(new GridLayout(2,3,5,5));
    private JPanel jp=new JPanel(new GridLayout(1,6,6,5));
    private LoginFrame loginfrm;
    // ------------------------------------------------ File
    private JInternalFrame jif1=new JInternalFrame();
    private Container jif1;
    private JMenuBar jmb1=new JMenuBar();
    private JMenu jm=new JMenu("Data");
    private JMenuItem jm1=new JMenuItem("Load");
    private JMenuItem jm2=new JMenuItem("New");
    private JMenuItem jm3=new JMenuItem("Close");
    private JFileChooser jfc=new JFileChooser();
    MainFrame(LoginFrame frm){
        loginfrm=frm;
        initComp();
    }
    private void initComp(){
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        this.setContentPane(jdp);
        this.add(jp,BorderLayout.CENTER);

        jmb.add(jmF);
        jmb.add(jmR);
        jmb.add(jmA);
        jmb.add(jmM);
        jmF.add(jMexit);

        jmA.add(jMscreen);
        jmR.add(jmi);
        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);
        jp1.add(tf1);
        jp1.add(jcb);
        jp1.add(tf2);


        jif.setBounds(0,0,200,80);

        jMscreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jif);
                jif.setVisible(true);
            }
        });
        jMexit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showConfirmDialog(MainFrame.this,jp1,"Font Setting",
                        JOptionPane.OK_CANCEL_OPTION);
            }
        });
        //---------------------------------------- File

        jMexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
