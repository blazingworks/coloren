package works.blazing.coloren;

public class HSL {
    public int h;
    public int s;
    public int l;

    public HSL(int h, int s, int l) {
        this.h = h;
        this.s = s;
        this.l = l;
    }

    public HSL(RGB rgb) {
        double r = (double)rgb.getRed() / 255.0;
        double g = (double)rgb.getGreen() / 255.0;
        double b = (double)rgb.getBlue() / 255.0;

        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g, b));
        double delta = max - min;

        double h = 0;
        double s = 0;
        double l = 0;

        if(delta == 0) {
            h = 0;
        } else if(max == r) {
            h = ((g - b) / delta) % 6;
        } else if(max == g) {
            h = (b - r) / delta + 2;
        } else {
            h = (r - g) / delta + 4;
        }

        h = Math.round(h * 60);

        if(h < 0) {
            h += 360;
        }

        l = (max + min) / 2;
        s = delta == 0 ? 0 : delta / (1 - Math.abs(2 * l - 1));
        s = Math.round(+(s * 100));
        l = Math.round(+(l * 100));

        this.h = (int)h;
        this.s = (int)s;
        this.l = (int)l;
    }

    public HSL(String hexColor) {
        this(new RGB(hexColor));
    }

    public int getHue() {
        return h;
    }

    public HSL setHue(int hue) {
        this.h = hue;
        return this;
    }

    public int getSaturation() {
        return s;
    }

    public HSL setSaturation(int saturation) {
        this.s = saturation;
        return this;
    }

    public int getLightness() {
        return l;
    }

    public HSL setLightness(int lightness) {
        this.l = lightness;
        return this;
    }

    public String toString() {
        return String.format("hsl(%s, %s%%, %s%%)", h, s, l);
    }

    public RGB toRGB() {
        int r = 0;
        int g = 0;
        int b = 0;

        if(this.s == 0) {
            r = g = b = (int)Math.round(this.l * 2.55);
        } else {
            double q = this.l < 50 ? this.l * (1 + this.s / 100.0) : this.l + this.s - this.l * this.s / 100.0;
            double p = 2 * this.l - q;
            r = (int)Math.round(2.55 * this.hueToRGB(p, q, this.h + 120));
            g = (int)Math.round(2.55 * this.hueToRGB(p, q, this.h));
            b = (int)Math.round(2.55 * this.hueToRGB(p, q, this.h - 120));
        }

        return new RGB(r, g, b);

    }

    public String toHex() {
        return this.toRGB().toHex();
    }

    private double hueToRGB(double p, double q, double t) {
        if(t < 0) {
            t += 360;
        }

        if(t > 360) {
            t -= 360;
        }

        if(t < 60) {
            return p + (q - p) * t / 60;
        }

        if(t < 180) {
            return q;
        }

        if(t < 240) {
            return p + (q - p) * (240 - t) / 60;
        }

        return p;
    }

}