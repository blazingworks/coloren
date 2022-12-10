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

    public void setRed(int red) {
        rgb.setRed(red);
    }

    public int getGreen() {
        return rgb.getGreen();
    }

    public void setGreen(int green) {
        rgb.setGreen(green);
    }

    public int getBlue() {
        return rgb.getBlue();
    }

    public void setBlue(int blue) {
        rgb.setBlue(blue);
    }

    public int getHue() {
        return toHSL().getHue();
    }

    public void setHue(int hue) {
        HSL hsl = toHSL();
        hsl.h = hue;
        rgb = new RGB(hsl);
    }

    public int getSaturation() {
        return toHSL().getSaturation();
    }

    public void setSaturation(int saturation) {
        HSL hsl = toHSL();
        hsl.s = saturation;
        rgb = new RGB(hsl);
    }

    public int getLightness() {
        return toHSL().getLightness();
    }

    public void setLightness(int lightness) {
        HSL hsl = toHSL();
        hsl.l = lightness;
        rgb = new RGB(hsl);
    }

    public void increaseLightness(int amount) {
        HSL hsl = toHSL();
        if(hsl.l + amount > 100) {
            hsl.l = 100;
        } else {
            hsl.l += amount;
        }
        rgb = new RGB(hsl);
    }

    public void decreaseLightness(int amount) {
        HSL hsl = toHSL();
        if(hsl.l - amount < 0) {
            hsl.l = 0;
        } else {
            hsl.l -= amount;
        }
        rgb = new RGB(hsl);
    }

    public void increaseSaturation(int amount) {
        HSL hsl = toHSL();
        if(hsl.s + amount > 100) {
            hsl.s = 100;
        } else {
            hsl.s += amount;
        }
        rgb = new RGB(hsl);
    }

    public void decreaseSaturation(int amount) {
        HSL hsl = toHSL();
        if(hsl.s - amount < 0) {
            hsl.s = 0;
        } else {
            hsl.s -= amount;
        }
        rgb = new RGB(hsl);
    }

    public void spinHue(int amount) {
        HSL hsl = toHSL();
        if(hsl.h + amount >= 360) {
            hsl.h = 360 - hsl.h;
        } else {
            hsl.h += amount;
        }
        rgb = new RGB(hsl);
    }

    public Coloren red(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.setRed(amount);
        return c;
    }

    public Coloren green(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.setGreen(amount);
        return c;
    }

    public Coloren blue(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.setBlue(amount);
        return c;
    }

    public Coloren hue(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.setHue(amount);
        return c;
    }

    public Coloren saturation(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.setSaturation(amount);
        return c;
    }

    public Coloren lightness(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.setLightness(amount);
        return c;
    }

    public Coloren spin(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.spinHue(amount);
        return c;
    }

    public Coloren lighten(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.increaseLightness(amount);
        return c;
    }

    public Coloren darken(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.decreaseLightness(amount);
        return c;
    }

    public Coloren saturate(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.increaseSaturation(amount);
        return c;
    }

    public Coloren desaturate(int amount) {
        Coloren c = new Coloren(this.rgb);
        c.decreaseSaturation(amount);
        return c;
    }

}
