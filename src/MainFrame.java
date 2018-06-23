import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    private Container cp;
    private Fly [] monster = new Fly[3] ;
    private Timer t1 ;
    private Random rnd = new Random();
    private JPanel jpn = new JPanel();

    public MainFrame (){
        this.init();
    }

    private void init (){
        this.setBounds(30,30,1280,960);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpn);
        jpn.setLayout(null);
        monster[0] =new Fly();
        monster[1] =new Fly();
        monster[2] =new Fly();
        jpn.add(monster[0]);
        jpn.add(monster[1]);
        jpn.add(monster[2]);
        monster[0].setBounds(1280 ,0  , 50 , 63);
        monster[1].setBounds(1280 ,0  , 50 , 63);
        monster[2].setBounds(1280 ,0  , 50 , 63);
        Thread thread_Monster0 = new Thread(monster[0]);
        Thread thread_Monster1 = new Thread(monster[1]);
        Thread thread_Monster2 = new Thread(monster[2]);
        thread_Monster0.start();
        thread_Monster1.start();
        thread_Monster2.start();

        t1 = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = rnd.nextInt(4)+1;
                if (r % 2 == 0 ){
                    if (!monster[0].getShow()){
                        monster[0].setShow(true);
                        monster[0].setObjX(1280);
                        monster[0].setObjY(rnd.nextInt(700));

                    }else if (!monster[1].getShow()){
                        monster[1].setShow(true);
                        monster[1].setObjX(1280);
                        monster[1].setObjY(rnd.nextInt(700));

                    }else if (!monster[2].getShow()){
                        monster[2].setShow(true);
                        monster[2].setObjX(1280);
                        monster[2].setObjY(rnd.nextInt(700));

                    }
                }
            }
        });

        t1.start();
    }
}
