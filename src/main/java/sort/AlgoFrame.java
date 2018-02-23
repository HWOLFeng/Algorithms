package sort;

import javax.swing.*;
import java.awt.*;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/11.
 */
public class AlgoFrame extends JFrame{


    private SelectionData data;
    public void render(SelectionData data){
        this.data = data;
        repaint();
    }

    /**
     * 绘制柱状图
     */
    private class AlgoCanvas extends JPanel{
        public AlgoCanvas() {
            //双缓存
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2D = (Graphics2D) g;
            // 抗锯齿
            RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                                              RenderingHints.VALUE_ANTIALIAS_ON);
            renderingHints.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
            g2D.addRenderingHints(renderingHints);
            // 具体绘制
            int width ;

            for (int i = 0; i < data.getLength(); i++) {

            }
        }
    }
}
