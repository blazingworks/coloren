package works.blazing.coloren;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColorenTest {
    @Test
    void testConstructor() {
        Coloren coloren = new Coloren(255, 0, 0);
        assertEquals(255, coloren.getRed());
        assertEquals(0, coloren.getGreen());
        assertEquals(0, coloren.getBlue());

        Coloren coloren2 = new Coloren(171, 13, 8);
        assertEquals(171, coloren2.getRed());
        assertEquals(13, coloren2.getGreen());
        assertEquals(8, coloren2.getBlue());
    }

    @Test
    void testRgbConstructor() {
        Coloren coloren = new Coloren(new RGB(255, 0, 0));
        assertEquals(255, coloren.getRed());
        assertEquals(0, coloren.getGreen());
        assertEquals(0, coloren.getBlue());

        Coloren coloren2 = new Coloren(new RGB(171, 13, 8));
        assertEquals(171, coloren2.getRed());
        assertEquals(13, coloren2.getGreen());
        assertEquals(8, coloren2.getBlue());
    }

    @Test
    void testHslConstructor() {
        Coloren coloren = new Coloren(new HSL(0, 100, 50));
        assertEquals(255, coloren.getRed());
        assertEquals(0, coloren.getGreen());
        assertEquals(0, coloren.getBlue());

        Coloren coloren2 = new Coloren(new HSL(0, 100, 20));
        assertEquals(102, coloren2.getRed());
        assertEquals(0, coloren2.getGreen());
        assertEquals(0, coloren2.getBlue());
    }

    @Test
    void testHexConstructor() {
        Coloren coloren = new Coloren("#ff0000");
        assertEquals(255, coloren.getRed());
        assertEquals(0, coloren.getGreen());
        assertEquals(0, coloren.getBlue());

        Coloren coloren2 = new Coloren("#ab0d08");
        assertEquals(171, coloren2.getRed());
        assertEquals(13, coloren2.getGreen());
        assertEquals(8, coloren2.getBlue());
    }

    @Test
    void testToString() {
        Coloren coloren = new Coloren(255, 0, 0);
        assertEquals("#ff0000", coloren.toString());

        Coloren coloren2 = new Coloren(171, 13, 8);
        assertEquals("#ab0d08", coloren2.toString());
    }

    @Test
    void testToHex() {
        Coloren coloren = new Coloren(255, 0, 0);
        assertEquals("#ff0000", coloren.toHex());

        Coloren coloren2 = new Coloren(171, 13, 8);
        assertEquals("#ab0d08", coloren2.toHex());
    }

    @Test
    void testToRgb() {
        Coloren coloren = new Coloren(255, 0, 0);
        assertEquals(new RGB(255, 0, 0).toString(), coloren.toRGB().toString());

        Coloren coloren2 = new Coloren(171, 13, 8);
        assertEquals(new RGB(171, 13, 8).toString(), coloren2.toRGB().toString());
    }

    @Test
    void testToHsl() {
        Coloren coloren = new Coloren(255, 0, 0);
        assertEquals(new HSL(0, 100, 50).toString(), coloren.toHSL().toString());

        Coloren coloren2 = new Coloren(171, 13, 8);
        assertEquals(new HSL(2, 91, 35).toString(), coloren2.toHSL().toString());
    }

    @Test
    void testSetRed() {
        Coloren coloren = new Coloren(255, 0, 0);
        coloren.setRed(0);
        assertEquals(0, coloren.getRed());
        assertEquals(0, coloren.getGreen());
        assertEquals(0, coloren.getBlue());
    }

    @Test
    void testSetGreen() {
        Coloren coloren = new Coloren(255, 0, 0);
        coloren.setGreen(0);
        assertEquals(255, coloren.getRed());
        assertEquals(0, coloren.getGreen());
        assertEquals(0, coloren.getBlue());
    }

    @Test
    void testSetBlue() {
        Coloren coloren = new Coloren(255, 0, 0);
        coloren.setBlue(0);
        assertEquals(255, coloren.getRed());
        assertEquals(0, coloren.getGreen());
        assertEquals(0, coloren.getBlue());
    }

    @Test
    void testBuilder() {
        Coloren coloren = new Coloren("#00fff2").setSaturation(90).lighten(10);
        assertEquals("#3df5ec", coloren.toHex());
    }

    @Test
    void testSetHue() {
        Coloren coloren = new Coloren("#00fff2");
        coloren.setHue(90);
        assertEquals("#7fff00", coloren.toHex());
    }

    @Test
    void testSetSaturation() {
        Coloren coloren = new Coloren("#00fff2");
        coloren.setSaturation(90);
        assertEquals("#0df2e7", coloren.toHex());
    }

    @Test
    void testSetLightness() {
        Coloren coloren = new Coloren("#00fff2");
        coloren.setLightness(90);
        assertEquals("#ccfffc", coloren.toHex());
    }

    @Test
    void testLighten() {
        Coloren coloren = new Coloren("#00fff2");
        coloren.lighten(10);
        assertEquals("#33fff5", coloren.toHex());
    }

    @Test
    void testDarken() {
        Coloren coloren = new Coloren("#00fff2");
        coloren.darken(10);
        assertEquals("#00ccc2", coloren.toHex());
    }

    @Test
    void testSaturate() {
        Coloren coloren = new Coloren("#00fff2");
        coloren.saturate(10);
        assertEquals("#00fff2", coloren.toHex());

        Coloren coloren2 = new Coloren("#40bfb9");
        coloren2.saturate(10);
        assertEquals("#33ccc4", coloren2.toHex());
    }

    @Test
    void testDesaturate() {
        Coloren coloren = new Coloren("#00fff2");
        coloren.desaturate(10);
        assertEquals("#0df2e7", coloren.toHex());
    }

}