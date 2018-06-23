import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fly extends JLabel implements Runnable {
    private int objX , objY ;
    private Boolean show = false;
    private ImageIcon monIcon = new ImageIcon("monster.png");

    public void setObjX (int objX){
        this.objX = objX ;
    }
    public int getObjX() {
        return objX;
    }
    public void setObjY(int objY) {
        this.objY = objY;
    }
    public int getObjY() {
        return objY;
    }
    public void setShow(Boolean show) {
        this.show = show;
    }
    public Boolean getShow() {
        return show;
    }

    Fly () {
        Fly.this.setIcon(monIcon);
    }

    @Override
    public void run() {
        while (true){
            objX -= 5;
            Fly.this.setBounds(objX , objY , 189 , 241);
            if (objX <= - 190){
                Fly.this.show = false ;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
