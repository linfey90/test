package test.qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class TwoDimensionCodeImage implements QRCodeImage {

    BufferedImage bufImg;

    public TwoDimensionCodeImage(BufferedImage bufImg) {
        this.bufImg = bufImg;
    }

    @Override
    public int getHeight() {
        return this.bufImg.getHeight();
    }

    @Override
    public int getPixel(int x, int y) {
        return this.bufImg.getRGB(x, y);
    }

    @Override
    public int getWidth() {
        return this.bufImg.getWidth();
    }

}