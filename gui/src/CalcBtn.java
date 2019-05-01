import javax.swing.*;
import java.awt.*;

class CalcBtn extends JButton {
    private Color pressedBackgroundColor;

    public CalcBtn(String text) {
        super(text);
        // 배경을 채우지 않도록 한다. 배경은 paintcomponent에서 채울 것
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // 모델에 버튼의 상태가 담겨있음. 눌려있는지 확인
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        // 버튼을 채운다.
        g.fillRect(0, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}