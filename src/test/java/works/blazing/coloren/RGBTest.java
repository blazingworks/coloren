package works.blazing.coloren;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RGBTest {

        @Test
        void testConstructor() {
            RGB rgb = new RGB(255, 0, 0);
            assertEquals(255, rgb.getRed());
            assertEquals(0, rgb.getGreen());
            assertEquals(0, rgb.getBlue());

            RGB rgb2 = new RGB(171, 13, 8);
            assertEquals(171, rgb2.getRed());
            assertEquals(13, rgb2.getGreen());
            assertEquals(8, rgb2.getBlue());
        }

        @Test
        void testToString() {
            RGB rgb = new RGB(255, 0, 0);
            assertEquals("rgb(255, 0, 0)", rgb.toString());

            RGB rgb2 = new RGB(171, 13, 8);
            assertEquals("rgb(171, 13, 8)", rgb2.toString());
        }

        @Test
        void testToHex() {
            RGB rgb = new RGB(255, 0, 0);
            assertEquals("#ff0000", rgb.toHex());

            RGB rgb2 = new RGB(171, 13, 8);
            assertEquals("#ab0d08", rgb2.toHex());
        }

        @Test
        void testHexConstructor() {
            RGB rgb = new RGB("#ff0000");
            assertEquals(255, rgb.getRed());
            assertEquals(0, rgb.getGreen());
            assertEquals(0, rgb.getBlue());

            RGB rgb2 = new RGB("#ab0d08");
            assertEquals(171, rgb2.getRed());
            assertEquals(13, rgb2.getGreen());
            assertEquals(8, rgb2.getBlue());
        }

}