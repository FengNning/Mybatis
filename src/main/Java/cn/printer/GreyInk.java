package cn.printer;

import java.awt.*;

public class GreyInk implements Ink {

        @Override
        public String getColor(int r, int g, int b) {
            int c=(r+g+b)/3;
            Color colo = new Color(c,c,c);
            return "#"+Integer.toHexString(colo.getRGB()).substring(2);
        }
    }

