import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.TimerTask;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
public class Stopwatch  extends frame{
    JButton stopbtn;
    JButton labbtn;
    JLabel lab;
    Timer timer ;
    TimerTask task;
    LocalTime t;
    JPanel lapPan;
    Stopwatch(String name){
        super(name);
    }
    @Override
    void build() {
        setLayout(new GridBagLayout());
        GridBagConstraints abc = new GridBagConstraints();
        abc.insets  = new Insets(5,5,5,5);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(labtimer(),BorderLayout.NORTH);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1,3,10,10));
        pane.add(btn1());
        pane.add(btn2());
        p.add(pane,BorderLayout.CENTER);
        abc.gridx =0;
        abc.gridy = 0;
        abc.gridwidth = 5;
        add(p,abc);
      
    }
    JLabel labtimer(){
        lab = new JLabel();
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setFont(new Font("Arial",Font.BOLD,30));
        lab.setForeground(new Color(255,0,0));
       timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e){
        t = LocalTime.now();
        lab.setText(""+t.getHour()+":"+t.getMinute()+":"+t.getSecond());
    }
});
timer.start();
        return lab;
    }
    JButton btn1(){
        stopbtn = new JButton();
        stopbtn.setBorderPainted(false);
        stopbtn.setFocusPainted(false);
        stopbtn.setText("Stop");
        stopbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning()){
                    timer.stop();
                    stopbtn.setText("Resume");
                }
                else{
                    timer.restart();
                    stopbtn.setText("Stop");
                }
                
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        return stopbtn;

    }
    JButton btn2(){
        labbtn = new JButton();
        labbtn.setText("lap");
        labbtn.setBorderPainted(false);
        labbtn.setFocusPainted(false);
        labbtn.addActionListener(e->{
            String text = lab.getText();
            System.out.println(text);
        });
        return labbtn;
    }

    public static void main(String[] args) {
        Stopwatch stp =  new Stopwatch("stopwatch");
        stp.build();
    }
}
