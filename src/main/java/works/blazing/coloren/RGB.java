package works.blazing.coloren;

public class RGB {
    public int r;
    public int g;
    public int b;

    public RGB(int red, int green, int blue) {
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    public RGB(String hexColor) {
        String hex = hexColor.replace("#", "");
        this.r = Integer.parseInt(hex.substring(0, 2), 16);
        this.g = Integer.parseInt(hex.substring(2, 4), 16);
        this.b = Integer.parseInt(hex.substring(4, 6), 16);
    }

    public RGB(HSL hsl) {
        RGB rgb = hsl.toRGB();
        this.r = rgb.r;
        this.g = rgb.g;
        this.b = rgb.b;
    }

    public int getRed() {
        return r;
    }

    public RGB setRed(int red) {
        this.r = red;
        return this;
    }

    public int getGreen() {
        return g;
    }

    public RGB setGreen(int green) {
        this.g = green;
        return this;
    }

    public int getBlue() {
        return b;
    }

    public RGB setBlue(int blue) {
        this.b = blue;
        return this;
    }

    public String toString() {
        return String.format("rgb(%s, %s, %s)", r, g, b);
    }

    public String toHex() {
        return String.format("#%02x%02x%02x", r, g, b);
    }
}