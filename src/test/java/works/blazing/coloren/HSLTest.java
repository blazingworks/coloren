package works.blazing.coloren;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class HSLTest {
    @Test
    void testConstructor() {
        HSL hsl = new HSL(0, 100, 50);
        assertEquals(0, hsl.getHue());
        assertEquals(100, hsl.getSaturation());
        assertEquals(50, hsl.getLightness());

        HSL hsl2 = new HSL(360, 0, 100);
        assertEquals(360, hsl2.getHue());
        assertEquals(0, hsl2.getSaturation());
        assertEquals(100, hsl2.getLightness());
    }

    @Test
    void testToString() {
        HSL hsl = new HSL(0, 100, 50);
        assertEquals("hsl(0, 100%, 50%)", hsl.toString());

        HSL hsl2 = new HSL(360, 0, 100);
        assertEquals("hsl(360, 0%, 100%)", hsl2.toString());
    }

    @Test
    void testToRGB() {
        HSL hsl = new HSL(0, 100, 50);
        assertEquals("rgb(255, 0, 0)", hsl.toRGB().toString());

        HSL hsl2 = new HSL(360, 0, 100);
        assertEquals("rgb(255, 255, 255)", hsl2.toRGB().toString());

        HSL hsl3 = new HSL(209, 43, 45);
        assertEquals("rgb(65, 116, 164)", hsl3.toRGB().toString());
    }

    @Test
    void testToHex() {
        HSL hsl = new HSL(0, 100, 50);
        assertEquals("#ff0000", hsl.toHex());

        HSL hsl2 = new HSL(360, 0, 100);
        assertEquals("#ffffff", hsl2.toHex());
    }

    @Test
    void testHexConstructor() {
        HSL hsl = new HSL("#ff0000");
        assertEquals(0, hsl.getHue());
        assertEquals(100, hsl.getSaturation());
        assertEquals(50, hsl.getLightness());

        HSL hsl2 = new HSL("#ffffff");
        assertEquals(0, hsl2.getHue());
        assertEquals(0, hsl2.getSaturation());
        assertEquals(100, hsl2.getLightness());

        HSL hsl3 = new HSL("#4174a4");
        assertEquals(209, hsl3.getHue());
        assertEquals(43, hsl3.getSaturation());
        assertEquals(45, hsl3.getLightness());
    }

    @Test
    void testRGBConstructor() {
        HSL hsl = new HSL(new RGB(255, 0, 0));
        assertEquals(0, hsl.getHue());
        assertEquals(100, hsl.getSaturation());
        assertEquals(50, hsl.getLightness());

        HSL hsl2 = new HSL(new RGB(255, 255, 255));
        assertEquals(0, hsl2.getHue());
        assertEquals(0, hsl2.getSaturation());
        assertEquals(100, hsl2.getLightness());

        HSL hsl3 = new HSL(new RGB(65, 116, 164));
        assertEquals(209, hsl3.getHue());
        assertEquals(43, hsl3.getSaturation());
        assertEquals(45, hsl3.getLightness());
    }
}