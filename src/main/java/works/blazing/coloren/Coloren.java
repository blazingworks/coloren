package works.blazing.coloren;

public class Coloren {
    private RGB rgb;

    public Coloren(int red, int green, int blue) {
        this.rgb = new RGB(red, green, blue);
    }

    public Coloren(String hexColor) {
        this.rgb = new RGB(hexColor);
    }

    public Coloren(RGB rgb) {
        this.rgb = rgb;
    }

    public Coloren(HSL hsl) {
        this.rgb = new RGB(hsl);
    }

    public RGB toRGB() {
        return rgb;
    }

    public HSL toHSL() {
        return new HSL(rgb);
    }

    public String toHex() {
        return rgb.toHex();
    }

    public String toString() {
        return rgb.toHex();
    }

    public int getRed() {
        return rgb.getRed();
    }

    public Coloren setRed(int red) {
        rgb.setRed(red);
        return this;
    }

    public int getGreen() {
        return rgb.getGreen();
    }

    public Coloren setGreen(int green) {
        rgb.setGreen(green);
        return this;
    }

    public int getBlue() {
        return rgb.getBlue();
    }

    public Coloren setBlue(int blue) {
        rgb.setBlue(blue);
        return this;
    }

    public int getHue() {
        return toHSL().getHue();
    }

    public Coloren setHue(int hue) {
        var hsl = toHSL();
        hsl.h = hue;
        rgb = new RGB(hsl);
        return this;
    }

    public int getSaturation() {
        return toHSL().getSaturation();
    }

    public Coloren setSaturation(int saturation) {
        var hsl = toHSL();
        hsl.s = saturation;
        rgb = new RGB(hsl);
        return this;
    }

    public int getLightness() {
        return toHSL().getLightness();
    }

    public Coloren setLightness(int lightness) {
        var hsl = toHSL();
        hsl.l = lightness;
        rgb = new RGB(hsl);
        return this;
    }

    public Coloren lighten(int amount) {
        var hsl = toHSL();
        if(hsl.l + amount > 100) {
            hsl.l = 100;
        } else {
            hsl.l += amount;
        }
        rgb = new RGB(hsl);
        return this;
    }

    public Coloren darken(int amount) {
        var hsl = toHSL();
        if(hsl.l - amount < 0) {
            hsl.l = 0;
        } else {
            hsl.l -= amount;
        }
        rgb = new RGB(hsl);
        return this;
    }

    public Coloren saturate(int amount) {
        var hsl = toHSL();
        if(hsl.s + amount > 100) {
            hsl.s = 100;
        } else {
            hsl.s += amount;
        }
        rgb = new RGB(hsl);
        return this;
    }

    public Coloren desaturate(int amount) {
        var hsl = toHSL();
        if(hsl.s - amount < 0) {
            hsl.s = 0;
        } else {
            hsl.s -= amount;
        }
        rgb = new RGB(hsl);
        return this;
    }

    public Coloren spin(int amount) {
        var hsl = toHSL();
        if(hsl.h + amount >= 360) {
            hsl.h = 360 - hsl.h;
        } else {
            hsl.h += amount;
        }
        rgb = new RGB(hsl);
        return this;
    }

}
